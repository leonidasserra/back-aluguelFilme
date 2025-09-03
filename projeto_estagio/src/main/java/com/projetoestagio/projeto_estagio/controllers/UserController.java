package com.projetoestagio.projeto_estagio.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.projetoestagio.projeto_estagio.dtos.users.CreateUserDTO;
import com.projetoestagio.projeto_estagio.entities.User;
import com.projetoestagio.projeto_estagio.repositories.UserRepository;

@RestController
public class UserController {
	
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private  BCryptPasswordEncoder passwordEncoder;

	
	//Esse Metodo não ta segindo a  arquitetura proposta. Deopis tem que adicionar o user service e impl
	@PostMapping("/register")
	public ResponseEntity<Void> criarUsuario(@RequestBody CreateUserDTO dto){

        var userFromDb = userRepository.findByUsername(dto.username());
        if (userFromDb.isPresent()) {
            throw new ResponseStatusException(HttpStatus.UNPROCESSABLE_ENTITY);
        }
        
        var user = new User();
        user.setUsername(dto.username());
        user.setPassword(passwordEncoder.encode(dto.password()));
        user.setCpf(dto.cpf());
        user.setName(dto.name());
        user.setEmail(dto.email());
        user.setNascimento(dto.nascimento());
        user.setTelefone(dto.telefone());
        userRepository.save(user);
        return ResponseEntity.ok().build();
        
		
	}
}
