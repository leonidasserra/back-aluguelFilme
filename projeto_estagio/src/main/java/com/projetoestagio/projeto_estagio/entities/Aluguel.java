package com.projetoestagio.projeto_estagio.entities;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

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
	
	public Aluguel() {
	}
	
	

	
	public Aluguel(Long id, BigDecimal valorAluguel, LocalDate dataAluguel, LocalDate devolucaoPrevista, String status,
			Pessoa pessoa) {
		this.id = id;
		this.valorAluguel = valorAluguel;
		this.dataAluguel = dataAluguel;
		this.devolucaoPrevista = devolucaoPrevista;
		this.status = status;
		this.pessoa = pessoa;
	}




	public Pessoa getPessoa() {
	    return pessoa;
	}

	public void setPessoa(Pessoa pessoa) {
	    this.pessoa = pessoa;
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


		
}
