package com.projetoestagio.projeto_estagio.entities;

import java.io.Serializable;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;

@Entity
public class Filme implements Serializable{
   
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	
    private String title;
    private Integer ano;
    
    private String genero;
    private Integer quantidadeEstoque;
    
    @ManyToMany(mappedBy = "filmes")
	@JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
	private List<Aluguel> alugueis;

	
	public Filme(){
	}



	public Filme(Long id, String title, Integer ano, String genero, Integer quantidadeEstoque, List<Aluguel> alugueis) {
		super();
		this.id = id;
		this.title = title;
		this.ano = ano;
		this.genero = genero;
		this.quantidadeEstoque = quantidadeEstoque;
		this.alugueis = alugueis;
	}



	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}



	public Integer getAno() {
		return ano;
	}


	public void setAno(Integer ano) {
		this.ano = ano;
	}


	public List<Aluguel> getAlugueis() {
		return alugueis;
	}


	public void setAlugueis(List<Aluguel> alugueis) {
		this.alugueis = alugueis;
	}


	public String getGenero() {
		return genero;
	}


	public void setGenero(String genero) {
		this.genero = genero;
	}


	public Integer getQuantidadeEstoque() {
		return quantidadeEstoque;
	}


	public void setQuantidadeEstoque(Integer quantidadeEstoque) {
		this.quantidadeEstoque = quantidadeEstoque;
	}
	
	
	
	
}