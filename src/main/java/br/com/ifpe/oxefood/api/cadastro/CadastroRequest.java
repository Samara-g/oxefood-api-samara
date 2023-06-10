package br.com.ifpe.oxefood.api.cadastro;

import java.time.LocalDate;

import com.fasterxml.jackson.annotation.JsonFormat;

import br.com.ifpe.oxefood.modelo.cadastro.Cadastro;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CadastroRequest {

   private String nome;

 @JsonFormat(pattern = "dd/MM/yyyy")
    private LocalDate dataNasc;

   private int cpf;

   private int rg;

   private int foneCel;

   private String endereco;

    private int criarSenha;

   private Boolean formaDePag;


public Cadastro build() {

       return Cadastro.builder()
               .nome(nome)
               .dataNasc(dataNasc)
               .cpf(cpf)
               .rg(rg)
               .foneCel(foneCel)
               .endereco(endereco)
               .criarSenha(criarSenha)
               .formaDePag(formaDePag)
               .build();
   }
}