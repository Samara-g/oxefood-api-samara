package br.com.ifpe.oxefood.modelo.cadastro;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import org.hibernate.annotations.Where;

import br.com.ifpe.oxefood.util.entity.EntidadeAuditavel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "Cadastro")
@Where(clause = "habilitado = true")
@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Cadastro extends EntidadeAuditavel  {

    private static final long serialVersionUID = -9147515922627050356L;

    @Column
    private String nome;

    @Column
   private LocalDate dataNasc;

    @Column
    private int cpf;

    @Column
    private int rg;

    @Column
    private int foneCel;

    @Column
    private String endereco;

     @Column
    private int criarSenha;

   
   @Column
   private Boolean formaDePag;




}