package com.projetoestagio.projeto_estagio.entities;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.projetoestagio.projeto_estagio.dtos.users.LoginRequestDTO;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="tb_users")
public class User {
	/**
	 * 
	 */
//	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	private Long id;
	
	@Column(unique = true)
	private String username;
	
	
	private String name;
	
	private String cpf;

	
	private String email;

	
	private String password;

	

	

	public User() {}


	public User(Long id, String username, String name, String cpf, String email, String password) {
		this.id = id;
		this.username = username;
		this.name = name;
		this.cpf = cpf;
		this.email = email;
		this.password = password;
	}








	public Long getId() {
		return id;
	}








	public void setId(Long id) {
		this.id = id;
	}








	public String getUsername() {
		return username;
	}








	public void setUsername(String username) {
		this.username = username;
	}








	public String getName() {
		return name;
	}








	public void setName(String name) {
		this.name = name;
	}








	public String getCpf() {
		return cpf;
	}








	public void setCpf(String cpf) {
		this.cpf = cpf;
	}








	public String getEmail() {
		return email;
	}








	public void setEmail(String email) {
		this.email = email;
	}








	public String getPassword() {
		return password;
	}








	public void setPassword(String password) {
		this.password = password;
	}








	public boolean isLoginCorrect(LoginRequestDTO loginRequest, PasswordEncoder passwordEncoder) {
		
		return passwordEncoder.matches(loginRequest.password(), this.password);
		
	}


}
