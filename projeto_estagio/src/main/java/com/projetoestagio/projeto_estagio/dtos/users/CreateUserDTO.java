package com.projetoestagio.projeto_estagio.dtos.users;

import java.time.LocalDate;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;

public record CreateUserDTO(
		@NotBlank(message = "O nome é obrigatório.")
	    String name,
	    
	    @NotBlank(message = "O nome é obrigatório.")
		String username,
		
		@NotBlank(message = "O nome é obrigatório.")
		String password,
	    
	    @Pattern(regexp = "\\d{11}", message = "O CPF deve conter 11 dígitos numéricos.")
	    String cpf,
	    
	    @Pattern(regexp = "\\d{10,11}", message = "O telefone deve conter entre 10 e 11 dígitos.")
	    String telefone,
	    
	    @NotBlank(message = "O e-mail é obrigatório.")
	    String email,
	    
	    @NotNull(message = "A data de nascimento é obrigatória.")
	    LocalDate nascimento
		
		
		
		
) {
	
}
