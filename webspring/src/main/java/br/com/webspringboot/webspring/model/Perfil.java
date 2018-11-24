package br.com.webspringboot.webspring.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;

import lombok.Data;

@Entity
@Data
public class Perfil {
	
	
	@Id
	@SequenceGenerator(name="seq_perfil", sequenceName= "seq_perfil")
	@GeneratedValue(generator= "seq_perfil")
	private Integer id;

	@Column(length=100)
	private String descricao;
}
