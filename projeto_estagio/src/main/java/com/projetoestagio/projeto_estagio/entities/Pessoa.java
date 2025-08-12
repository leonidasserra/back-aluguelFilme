package com.projetoestagio.projeto_estagio.entities;

import java.io.Serializable;
import java.sql.Date;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonValue;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

@Entity
public class Pessoa implements Serializable {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	private String cpf;
	private String telefone;
	private String name;
	private String email;
//	private String senha;
	
	private Date nascimento;
	
	@OneToMany(mappedBy = "pessoa")
	@JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
	private List<Aluguel> aluguel;
	
	
	public Pessoa() {
	}	

	public Pessoa(Long id, String cpf, String telefone, String name, String email, Date nascimento,
			List<Aluguel> aluguel) {
		super();
		this.id = id;
		this.cpf = cpf;
		this.telefone = telefone;
		this.name = name;
		this.email = email;
		this.nascimento = nascimento;
		this.aluguel = aluguel;
	}


	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Date getNascimento() {
		return nascimento;
	}

	public void setNascimento(Date nascimento) {
		this.nascimento = nascimento;
	}

	public List<Aluguel> getAluguel() {
		return aluguel;
	}

	public void setAluguel(List<Aluguel> aluguel) {
		this.aluguel = aluguel;
	}

	
	
	@Override
	public String toString() {
		return "Pessoa [id=" + id + ", cpf=" + cpf + ", telefone=" + telefone + ", name=" + name + ", email=" + email
				+ ", nascimento=" + nascimento + ", aluguel=" + aluguel + "]";
	}


}
