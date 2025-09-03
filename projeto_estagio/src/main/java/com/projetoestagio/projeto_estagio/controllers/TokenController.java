package com.projetoestagio.projeto_estagio.controllers;

import java.time.Instant;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.oauth2.jwt.JwtClaimsSet;
import org.springframework.security.oauth2.jwt.JwtEncoder;
import org.springframework.security.oauth2.jwt.JwtEncoderParameters;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.projetoestagio.projeto_estagio.dtos.users.LoginRequestDTO;
import com.projetoestagio.projeto_estagio.dtos.users.LoginResponseDTO;
import com.projetoestagio.projeto_estagio.repositories.UserRepository;

@RestController
public class TokenController {

    @Autowired // Adicionei esta linha
    private JwtEncoder jwtEncoder;
	
	@Autowired		
    private UserRepository userRepository;
	
    @Autowired // Adicionei esta linha
    private BCryptPasswordEncoder passwordEncoder;
	
	@PostMapping("/login")
	public ResponseEntity<LoginResponseDTO> login(@RequestBody LoginRequestDTO loginRequest) {

        var user = userRepository.findByUsername(loginRequest.username());

        if (user.isEmpty() || !user.get().isLoginCorrect(loginRequest, passwordEncoder)) {
            throw new BadCredentialsException("user or password is invalid!");
        }

        var now = Instant.now();
        var expiresIn = 300L;
	
		var claims = JwtClaimsSet.builder()
				.issuer("mybackend")
				.subject(user.get().getId().toString())
				.issuedAt(now)
				.expiresAt(now.plusSeconds(expiresIn))
				.build();
		
		var jwtValue= jwtEncoder.encode(JwtEncoderParameters.from(claims)).getTokenValue();
	
		return ResponseEntity.ok(new LoginResponseDTO(jwtValue, expiresIn));
}
}