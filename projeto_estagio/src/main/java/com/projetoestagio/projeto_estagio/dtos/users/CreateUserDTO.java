package com.projetoestagio.projeto_estagio.dtos.users;

import java.time.LocalDate;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;

public record CreateUserDTO(
		@NotBlank(message = "O nome é obrigatório.")
	    String name,
	    
	    @NotBlank(message = "O username é obrigatório.")
		String username,
		
		@NotBlank(message = "A senha é obrigatório.")
		String password,
	    
	    @Pattern(regexp = "\\d{11}", message = "O CPF deve conter 11 dígitos numéricos.")
	    String cpf,

	    
	    @NotBlank(message = "O e-mail é obrigatório.")
	    String email
	    
	
) {
	
}
