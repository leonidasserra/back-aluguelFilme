package com.projetoestagio.projeto_estagio.entities;

import java.math.BigDecimal;
import java.util.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import java.io.Serializable;

@Entity
public class Aluguel implements Serializable {
// acho que ta errado	private Filme filme;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	private BigDecimal valorAluguel;
	private Date dataAluguel;
	private Date devolucaoPrevista;
	private String status;
	
	public Aluguel() {
	}
	
	
	public Aluguel(Long id, BigDecimal valorAluguel, Date dataAluguel, Date devolucaoPrevista, String status) {
		
		this.id = id;
		this.valorAluguel = valorAluguel;
		this.dataAluguel = dataAluguel;
		this.devolucaoPrevista = devolucaoPrevista;
		this.status = status;
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
	public Date getDataAluguel() {
		return dataAluguel;
	}
	public void setDataAluguel(Date dataAluguel) {
		this.dataAluguel = dataAluguel;
	}
	public Date getDevolucaoPrevista() {
		return devolucaoPrevista;
	}
	public void setDevolucaoPrevista(Date devolucaoPrevista) {
		this.devolucaoPrevista = devolucaoPrevista;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}

		
}
