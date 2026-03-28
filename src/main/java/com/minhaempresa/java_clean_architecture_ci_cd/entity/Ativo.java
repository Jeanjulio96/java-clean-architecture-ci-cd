package com.minhaempresa.java_clean_architecture_ci_cd.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity; // pacote JPA (persistência)
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity // marca a classe como uma entidade JPA (vira tabela no banco)
@Table(name = "ativos") // define o nome da tabela no banco
public class Ativo {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY) // auto incremento no banco (o próprio banco gera o ID)
	private Long id;

	@Column(nullable = false) // coluna obrigatória (NOT NULL no banco)
	private String nome;

	@Column(nullable = false)
	private Double preco;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Double getPreco() {
		return preco;
	}

	public void setPreco(Double preco) {
		this.preco = preco;
	}

}
