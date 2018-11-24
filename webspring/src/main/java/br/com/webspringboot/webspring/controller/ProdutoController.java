package br.com.webspringboot.webspring.controller;



import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

import br.com.webspringboot.webspring.model.Produto;

import br.com.webspringboot.webspring.repository.ProdutoRepository;

@RestController
@RequestMapping("/produtocontroller")
public class ProdutoController {
	
	@Autowired
	private ProdutoRepository produtoRepository;
	
	@PostMapping
	public Produto inserir(@RequestBody Produto produto) {
		 return produtoRepository.save(produto);
	}


}
