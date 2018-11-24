package br.com.webspringboot.webspring.model;




import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.SequenceGenerator;


import lombok.Data;

@Data
@Entity
@NamedQuery(name = "Usuario.buscarPorPerfil", query = "select new Usuario(u.id , u.nome ) from Usuario u where u.perfil.descricao= ?1")

public class Usuario {

	@Id
	@GeneratedValue  // (generator= "seq_usuario")
	@SequenceGenerator(name = "seq_usuario", sequenceName = "seq_usuario")
	private Integer id;

	@Column(name = "nome", length = 50, nullable = false)
	private String nome;
	
	@Column(name = "email", length = 50)
	private String email;

	@Column(name = "senha")
	private String senha;

	@JoinColumn
	@ManyToOne
	private Perfil perfil;
    
		
	public Usuario() {

	}

	public Usuario(Integer id, String nome) {
		this.id = id;
		this.nome = nome;
	}

		
}
