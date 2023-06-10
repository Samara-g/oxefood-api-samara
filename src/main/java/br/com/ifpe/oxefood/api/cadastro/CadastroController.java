package br.com.ifpe.oxefood.api.cadastro;

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

import br.com.ifpe.oxefood.modelo.cadastro.Cadastro;
import br.com.ifpe.oxefood.modelo.cadastro.CadastroService;
import br.com.ifpe.oxefood.util.entity.GenericController;

@RestController
@RequestMapping("/api/cadastro")
public class CadastroController extends GenericController {

   @Autowired
   private CadastroService cadastroService;

   @PostMapping
   public ResponseEntity<Cadastro> save(@RequestBody @Valid CadastroRequest request) {

    Cadastro cadastro = cadastroService.save(request.build());
       return new ResponseEntity<Cadastro>(cadastro, HttpStatus.CREATED);
   }
   @GetMapping
   public List<Cadastro> listarTodos() {
  
       return cadastroService.listarTodos();
   }

   @GetMapping("/{id}")
   public Cadastro obterPorID(@PathVariable Long id) {

       return cadastroService.obterPorID(id);
   }

   @PutMapping("/{id}")
   public ResponseEntity<Cadastro> update(@PathVariable("id") Long id, @RequestBody CadastroRequest request) {

       cadastroService.update(id, request.build());
       return ResponseEntity.ok().build();
   }
   
   @DeleteMapping("/{id}")
   public ResponseEntity<Void> delete(@PathVariable Long id) {

       cadastroService.delete(id);
       return ResponseEntity.ok().build();
   }

}