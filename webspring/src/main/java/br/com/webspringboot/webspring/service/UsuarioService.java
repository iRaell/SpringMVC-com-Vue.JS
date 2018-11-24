package br.com.webspringboot.webspring.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.webspringboot.webspring.model.Perfil;
import br.com.webspringboot.webspring.model.Usuario;
import br.com.webspringboot.webspring.repository.PerfilRepository;
import br.com.webspringboot.webspring.repository.UsuarioRepository;

@Service
public class UsuarioService {

	@Autowired
	private UsuarioRepository usuarioRepository;

	@Autowired
	private PerfilRepository perfilRepository;

	
	public Usuario salvar(Usuario usuario) {
    
		if (usuario.getPerfil() == null) {
	//	Perfil perfilPadrao = perfilRepository.findOne(2);
	     
   //      usuario.setPerfil(perfilPadrao); 
	   
		}
		return usuarioRepository.save(usuario);
	}

	public void excluir(Integer id) {

		usuarioRepository.deleteById(id);

	}

	public List<Usuario> buscarPorNome(String nome) {

		return usuarioRepository.findByNomeIgnoreCase(nome);
	}

	public List<Usuario> buscarPorNomeESenha(String nome, String senha) {
		return usuarioRepository.findByNomeAndSenha(nome, senha);
	}

	public Optional<Usuario> buscarPorId(Integer id) {
		return usuarioRepository.findById(id);
	}
	

	public List<Usuario> buscarTodos() {
		return usuarioRepository.findAll();
	}

	public List<Usuario> buscarPorPerfil(String descricao) {
		return usuarioRepository.findByPerfilDescricao(descricao);
	}

}
