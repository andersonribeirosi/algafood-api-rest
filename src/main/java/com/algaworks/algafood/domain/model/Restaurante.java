package com.algaworks.algafood.domain.model;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;
import lombok.EqualsAndHashCode;

//@JsonRootName("rest") Renomeia o nome da instância da classe
@Data
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Entity
public class Restaurante {

	@Id
	@EqualsAndHashCode.Include
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(nullable = false, length = 30)
	@JsonProperty("titulo") // Usamos quando queremos renomear o nome da variável na resposta do JSON
	private String nome;

//	@JsonIgnore // ignora o retorno da variavel na requisição
	@Column(nullable = false)
	private BigDecimal taxaFrete;
	
	@ManyToOne
	@OnDelete(action = OnDeleteAction.CASCADE) // Só para testes
	@JoinColumn(nullable = false)
	private Cozinha cozinha;

}
