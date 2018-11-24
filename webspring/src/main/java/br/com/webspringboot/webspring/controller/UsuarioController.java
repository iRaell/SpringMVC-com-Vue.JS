package br.com.webspringboot.webspring.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


import br.com.webspringboot.webspring.model.Usuario;

import br.com.webspringboot.webspring.service.UsuarioService;

@RestController
@RequestMapping("/usucontroller")
@CrossOrigin( origins= {"*"}) // O {"*"} significa que não importa onde esteja ospedado'endereço de rede' o FrontEnd poderá consumir a API
// O site que estiver ospedado nesse endereço: {"http://127.0.0.1:5500"} então podera consumir essa API
public class UsuarioController {

		
	@Autowired
	private UsuarioService usuarioService;
	
	

	@PostMapping // postman-> http://localhost:8080/usucontroller
	public Usuario inserir(@RequestBody Usuario usuario) {	// {  nome:  , senha:  }
		/**
		 * Pra realizar cadastro do usuario no postman vinculado ao Perfil
		 * 
		 *           {
         *            "nome":"iris",
         *              "senha":"222",
         *              "perfil": {
	     *              "id": "3"   o numero 3 do id é referente a descrição do Perfil que já está no Banco de Dados
         *              }
         *           }
		 */
		
		return usuarioService.salvar(usuario);
	}

	@PutMapping  // postman -> http://localhost:8080/usucontroller e dentro das { escolher o id: , do usuario a editar os campos }
	public Usuario alterar(@RequestBody Usuario usuario) {		// { id:  , nome:  , senha:  }	
		return usuarioService.salvar(usuario); // Os save do Repository são os mesmos, se tem id é pra alterar, se não
												// tem se inseri o novo.
	}

	@DeleteMapping("/{id}") // postman-> http://localhost:8080/usucontroller/202
	public void excluir(@PathVariable("id") Integer id) {
		usuarioService.excluir(id);

	}
	
	@GetMapping("/{id}")  // postman -> http://localhost:8080/usucontroller/ numero do id
	public Optional<Usuario> buscarPorId(@PathVariable("id") Integer id) {	return usuarioService.buscarPorId(id);	}	
	
	@GetMapping("/q/{nome}") // postman -> http://localhost:8080/usucontroller/q/iris
	public List<Usuario> buscarPorNome(@PathVariable("nome") String nome) {
		return usuarioService.buscarPorNome(nome);
	}
	

	@GetMapping("/q2") // postman -> http://localhost:8080/usucontroller/q2?nome=tiago&senha=116    // obs: A url é formada acrescentando os Paramns no Postman 
	public List<Usuario> buscarPorNomeESenha(@RequestParam("nome") String nome, @RequestParam("senha") String senha) {
		return usuarioService.buscarPorNomeESenha(nome, senha);
	}
  // Segunda forma de buscar por { nome e senha } usando PostMapping, dessa forma os dados não ficam expostos na URL, o PostMapping envia um o dado pra ser consultado no Banco
	@PostMapping("/autenticar") // postman-> http://localhost:8080/usucontroller/autenticar  // E dentro do corpo postman entre as { "nome": "paulo" , "senha":"888" } 
	public List<Usuario> autenticar(@RequestBody Usuario usuario) throws UsuarioNaoEncontradoException {
		List<Usuario> l = usuarioService.buscarPorNomeESenha(usuario.getNome(), usuario.getSenha());

		if (l == null || l.size() == 0) {
			throw new UsuarioNaoEncontradoException(); 
			// Alt Enter pra criar a classe Exception, após ser criada é necessário declara-la na assinatura do metodo: throws UsuarioNaoEncontradoException {

		} else {
			return l;

		}
	}

	@GetMapping  // postman -> http://localhost:8080/usucontroller
	public List<Usuario> buscarTodos() {
		return usuarioService.buscarTodos();
	}
	
	@GetMapping("/q/perfil")  // postman ->  http://localhost:8080/usucontroller/q/perfil?descricao=RH
    List<Usuario> buscarPorPerfil(@RequestParam("descricao") String descricao ){
		return usuarioService.buscarPorPerfil(descricao);
		
	}

}
