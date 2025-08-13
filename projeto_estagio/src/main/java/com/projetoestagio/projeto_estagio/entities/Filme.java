package com.projetoestagio.projeto_estagio.entities;

import java.io.Serializable;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;
//import com.projetoestagio.projeto_estagio.entities.enums.Genero;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
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
    
   
    private Integer quantidadeEstoque;
    
    private String sinopse;
    private String diretor;
    private Integer classificacao;
    private Integer duracao;
    
    
//    @Enumerated(EnumType.STRING)
    private String genero;
    
    
//    @ManyToMany(mappedBy = "filmes")
//	@JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
//	private List<Aluguel> alugueis;

	
	public Filme(){
	}



	public Filme(Long id, String title, Integer ano, Integer quantidadeEstoque, String sinopse, String diretor,
			Integer classificacao, Integer duracao, String genero /*, List<Aluguel> alugueis*/) {
		this.id = id;
		this.title = title;
		this.ano = ano;
		this.quantidadeEstoque = quantidadeEstoque;
		this.sinopse = sinopse;
		this.diretor = diretor;
		this.classificacao = classificacao;
		this.duracao = duracao;
		this.genero = genero;
//		this.alugueis = alugueis;
	}







	public Integer getDuracao() {
		return duracao;
	}


	public void setDuracao(Integer duracao) {
		this.duracao = duracao;
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


	public Integer getQuantidadeEstoque() {
		return quantidadeEstoque;
	}


	public void setQuantidadeEstoque(Integer quantidadeEstoque) {
		this.quantidadeEstoque = quantidadeEstoque;
	}


	public String getSinopse() {
		return sinopse;
	}


	public void setSinopse(String sinopse) {
		this.sinopse = sinopse;
	}


	public String getDiretor() {
		return diretor;
	}


	public void setDiretor(String diretor) {
		this.diretor = diretor;
	}


	public Integer getClassificacao() {
		return classificacao;
	}


	public void setClassificacao(Integer classificacao) {
		this.classificacao = classificacao;
	}


	public String getGenero() {
		return genero;
	}


	public void setGenero(String genero) {
		this.genero = genero;
	}


//	public List<Aluguel> getAlugueis() {
//		return alugueis;
//	}
//
//
//	public void setAlugueis(List<Aluguel> alugueis) {
//		this.alugueis = alugueis;
//	}



	
	
	
	
}