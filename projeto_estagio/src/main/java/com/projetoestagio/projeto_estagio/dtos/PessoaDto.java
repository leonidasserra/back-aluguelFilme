package com.projetoestagio.projeto_estagio.dtos;

import java.sql.Date;

public class PessoaDto {
	private Long id;
	private String cpf;
	private String telefone;
	private String name;
	private String email;
	private Date nascimento;
	
	
	
	
	public PessoaDto(Long id, String cpf, String telefone, String name, String email, Date nascimento) {
		this.id = id;
		this.cpf = cpf;
		this.telefone = telefone;
		this.name = name;
		this.email = email;
		this.nascimento = nascimento;
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
}
