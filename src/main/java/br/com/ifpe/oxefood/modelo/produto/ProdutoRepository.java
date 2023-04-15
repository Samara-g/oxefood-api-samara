package br.com.ifpe.oxefood.modelo.produto;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.ifpe.oxefood.api.produto.ProdutoRequest;

public interface ProdutoRepository extends JpaRepository<Produto, Long> {

    Produto save(ProdutoRequest produtoRequest);
    
}
