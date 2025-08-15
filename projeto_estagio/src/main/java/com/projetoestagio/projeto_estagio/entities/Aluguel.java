package com.projetoestagio.projeto_estagio.entities;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Date;
import java.util.List;


import java.util.Set;
import java.util.HashSet;
import jakarta.persistence.*; 

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;

import java.io.Serializable;

@Entity
public class Aluguel implements Serializable {
// acho que ta errado	private Filme filme;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	private BigDecimal valorAluguel;
	private LocalDate dataAluguel;
	private LocalDate devolucaoPrevista;
	private String status;
	
    @ManyToOne
    @JoinColumn(name = "pessoa_id") // chave estrangeira no banco
    private Pessoa pessoa;
	
//    @ManyToMany
//    @JoinTable(
//        name = "aluguel_filmes",
//        joinColumns = @JoinColumn(name = "aluguel_id"),
//        inverseJoinColumns = @JoinColumn(name = "filme_id")
//    )
//    private List<Filme> filmes;
    
    
    @ManyToMany(fetch = FetchType.LAZY /*, cascade = {CascadeType.PERSIST, CascadeType.MERGE}*/)
    @JoinTable(
        name = "aluguel_filmes",
        joinColumns = @JoinColumn(name = "aluguel_id", nullable = false, foreignKey = @ForeignKey(name="fk_af_aluguel")),
        inverseJoinColumns = @JoinColumn(name = "filme_id", nullable = false, foreignKey = @ForeignKey(name="fk_af_filme")),
        uniqueConstraints = @UniqueConstraint(name = "uk_aluguel_filme", columnNames = {"aluguel_id","filme_id"})
    )
    private Set<Filme> filmes = new HashSet<>();
    
    
	public Aluguel() {
	}
	

	public Aluguel(Long id, BigDecimal valorAluguel, LocalDate dataAluguel, LocalDate devolucaoPrevista, String status,
			Pessoa pessoa, Set<Filme> filmes) {
		super();
		this.id = id;
		this.valorAluguel = valorAluguel;
		this.dataAluguel = dataAluguel;
		this.devolucaoPrevista = devolucaoPrevista;
		this.status = status;
		this.pessoa = pessoa;
		this.filmes = filmes;
	}




	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public BigDecimal getValorAluguel() {
		return valorAluguel;
	}
	public void setValorAluguel(BigDecimal valorAluguel) {
		this.valorAluguel = valorAluguel;
	}
	public LocalDate getDataAluguel() {
		return dataAluguel;
	}
	public void setDataAluguel(LocalDate dataAluguel) {
		this.dataAluguel = dataAluguel;
	}
	public LocalDate getDevolucaoPrevista() {
		return devolucaoPrevista;
	}
	public void setDevolucaoPrevista(LocalDate localDate) {
		this.devolucaoPrevista = localDate;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	
	
	public Pessoa getPessoa() {
		return pessoa;
	}
	public void setPessoa(Pessoa pessoa) {
		this.pessoa = pessoa;
	}
		
	
	
	public Set<Filme> getFilmes() {
		return filmes;
	}

	public void setFilmes(Set<Filme> filmes) {
		this.filmes = filmes;
	}

	
	

	@Override
	public boolean equals(Object o) {
	    // Verifica se o objeto comparado é exatamente o mesmo na memória
	    if (this == o) return true;

	    // Verifica se o objeto é da mesma classe
	    if (!(o instanceof Filme)) return false;

	    // Faz o cast para Filme, já que é seguro depois da verificação acima
	    Filme f = (Filme) o;

	    // Considera dois filmes iguais se seus IDs forem não nulos e iguais
	    return id != null && id.equals(f.getId());
	}
//
//	@Override
//	public int hashCode() {
//	    // Se o id for diferente de null, usa o hash do id
//	    // Se o id ainda for null (ex: antes de salvar no banco), retorna 0
//	    return id != null ? id.hashCode() : 0;
//	}






		
}
