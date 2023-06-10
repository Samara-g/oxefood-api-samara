package br.com.ifpe.oxefood.modelo.cadastro;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.ifpe.oxefood.util.entity.GenericService;

@Service
public class CadastroService extends GenericService {

   @Autowired
   private CadastroRepository repository;

   @Transactional
   public Cadastro save(Cadastro cadastro) {

       super.preencherCamposAuditoria(cadastro);
       return repository.save(cadastro);
   }

   @Transactional
   public void update(Long id, Cadastro cadastroAlterado) {

      Cadastro cadastro = repository.findById(id).get();
      cadastro.setNome(cadastroAlterado.getNome());
      cadastro.setDataNasc(cadastroAlterado.getDataNasc());
      cadastro.setCpf(cadastroAlterado.getCpf());
      cadastro.setRg(cadastroAlterado.getRg());
      cadastro.setFoneCel(cadastroAlterado.getFoneCel());
      cadastro.setEndereco(cadastroAlterado.getEndereco());
      cadastro.setCriarSenha(cadastroAlterado.getCriarSenha());
      cadastro.setFormaDePag(cadastroAlterado.getFormaDePag());
	    
      super.preencherCamposAuditoria(cadastro);
      repository.save(cadastro);
  }

   public List<Cadastro> listarTodos() {
  
    return repository.findAll();
}

public Cadastro obterPorID(Long id) {

    return repository.findById(id).get();
}

@Transactional
public void delete(Long id) {

    Cadastro cadastro = repository.findById(id).get();
    cadastro.setHabilitado(Boolean.FALSE);
    super.preencherCamposAuditoria(cadastro);

    repository.save(cadastro);
}


}
