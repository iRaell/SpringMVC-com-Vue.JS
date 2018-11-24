package br.com.webspringboot.webspring.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.webspringboot.webspring.model.Perfil;
import br.com.webspringboot.webspring.repository.PerfilRepository;
@CrossOrigin(origins = {"*"} )
@RestController
@RequestMapping("/perfilcontroller")
public class PerfilController {
	
	@Autowired
	private PerfilRepository perfilRepository;

	@PostMapping
	public Perfil cadastrar(@RequestBody Perfil perfil) {		
		return perfilRepository.save(perfil);
	}
	
	
	@GetMapping // postman -> http://localhost:8080/perfilcontroller
	public List<Perfil> buscarTodos(){
		return perfilRepository.findAll();
	}
}
