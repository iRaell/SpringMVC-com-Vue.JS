package br.com.webspringboot.webspring.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
//import org.springframework.data.jpa.repository.Query;
//import org.springframework.data.repository.query.Param;

import br.com.webspringboot.webspring.model.Usuario;
//import br.com.webspringboot.webspring.model.Perfil;

public interface UsuarioRepository extends JpaRepository<Usuario, Integer> {

  
	List<Usuario> findByNomeIgnoreCase(String nome);
	
	List<Usuario> findByNomeAndSenha(String nome, String senha);
	
	// Busca o perfil do Usuario
	 List<Usuario> findByPerfilDescricao(String descricao);
	
  /***
   * 
   *  >> Metodo de consulta comentado e usado direto na classe entidade: Usuario, através do @NamedQuery()  
   *  
   * //Busca o perfil do Usuario: usando Query
   * @param descricaoPerfil
   * @return
	 @Query("select u from Usuario u where u.perfil.descricao= :desc ")
	 List<Usuario> buscarPorPerfil(@Param("desc") String descricaoPerfil );	
   */
	
	 // Metodo usado pra invocação da @NamedQuery() da classe entidade: Usuario
	 List<Usuario> buscarPorPerfil( String descricaoPerfil );	
	 
}







