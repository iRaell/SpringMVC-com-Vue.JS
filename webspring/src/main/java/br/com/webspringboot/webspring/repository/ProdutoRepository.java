package br.com.webspringboot.webspring.repository;




import org.springframework.data.jpa.repository.JpaRepository;

import br.com.webspringboot.webspring.model.Produto;


public interface ProdutoRepository extends JpaRepository<Produto, Integer>{


}
