package br.com.ifpe.oxefood.modelo.entregador;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.ifpe.oxefood.api.produto.ProdutoRequest;

public interface EntregadorRepository extends JpaRepository<Entregador, Long> {

    Entregador save(ProdutoRequest produtoRequest);
    
}
