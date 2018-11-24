package br.com.webspringboot.webspring.model;



import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import javax.persistence.SequenceGenerator;

import lombok.Data;

@Data
@Entity
public class Produto {
	
	@Id
	@GeneratedValue(generator="seq_produto")
	@SequenceGenerator(name="seq_produto", sequenceName="seq_produto")
	private Integer id;
	
	@Column(length=100)
	private String descricao;
	
	@Column(length=15)
	private BigDecimal valor;
	

}
