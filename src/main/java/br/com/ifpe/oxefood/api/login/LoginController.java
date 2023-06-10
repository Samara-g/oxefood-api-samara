package br.com.ifpe.oxefood.api.login;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.ifpe.oxefood.modelo.login.Login;
import br.com.ifpe.oxefood.modelo.login.LoginService;
import br.com.ifpe.oxefood.util.entity.GenericController;

@RestController
@RequestMapping("/api/login")
public class LoginController extends GenericController {
    
    @Autowired
    private LoginService loginService;

    @PostMapping
    public ResponseEntity<Login> save(@RequestBody @Valid LoginRequest request) {

        Login login = loginService.save(request.build());
        return new ResponseEntity<Login>(login, HttpStatus.CREATED);
    }
    
    @GetMapping
   public List<Login> listarTodos() {
  
       return loginService.listarTodos();
   }

   @GetMapping("/{id}")
   public Login obterPorID(@PathVariable Long id) {

       return loginService.obterPorID(id);
   }
   
   @PutMapping("/{id}")
   public ResponseEntity<Login> update(@PathVariable("id") Long id, @RequestBody LoginRequest request) {

       loginService.update(id, request.build());
       return ResponseEntity.ok().build();
   }

   @DeleteMapping("/{id}")
   public ResponseEntity<Void> delete(@PathVariable Long id) {

       loginService.delete(id);
       return ResponseEntity.ok().build();
   }


}
