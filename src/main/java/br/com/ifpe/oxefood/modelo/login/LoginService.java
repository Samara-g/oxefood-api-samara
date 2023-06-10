package br.com.ifpe.oxefood.modelo.login;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.ifpe.oxefood.util.entity.GenericService;
@Service
public class LoginService extends GenericService {
    
    @Autowired
    private LoginRepository repository;

    @Transactional
    public Login save(Login login) {

        super.preencherCamposAuditoria(login);
        return repository.save(login);
    }
    
    @Transactional
   public void update(Long id, Login loginAlterado) {

      Login login = repository.findById(id).get();
      login.setEmail(loginAlterado.getEmail());
      login.setSenha(loginAlterado.getSenha());
	    
      super.preencherCamposAuditoria(login);
      repository.save(login);
  }

    public List<Login> listarTodos() {
  
        return repository.findAll();
    }
 
    public Login obterPorID(Long id) {
 
        return repository.findById(id).get();
    }

    

    @Transactional
    public void delete(Long id) {
 
        Login login = repository.findById(id).get();
        login.setHabilitado(Boolean.FALSE);
        super.preencherCamposAuditoria(login);
 
        repository.save(login);
    }
 

}