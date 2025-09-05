package com.projetoestagio.projeto_estagio.controllers;

import java.time.Instant;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.oauth2.jwt.JwtClaimsSet;
import org.springframework.security.oauth2.jwt.JwtEncoder;
import org.springframework.security.oauth2.jwt.JwtEncoderParameters;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.projetoestagio.projeto_estagio.dtos.users.LoginRequestDTO;
import com.projetoestagio.projeto_estagio.dtos.users.LoginResponseDTO;
import com.projetoestagio.projeto_estagio.entities.User;
import com.projetoestagio.projeto_estagio.repositories.UserRepository;

@CrossOrigin("*")
@RestController
public class TokenController {

    @Autowired
    private JwtEncoder jwtEncoder;
	
	@Autowired		
    private UserRepository userRepository;
	
    @Autowired
    private BCryptPasswordEncoder passwordEncoder;
	
	@PostMapping("/login")
	public ResponseEntity<LoginResponseDTO> login(@RequestBody LoginRequestDTO loginRequest) {

        var username = userRepository.findByUsername(loginRequest.username());
        User user=username.get();
//        		.orElseThrow(()->new BadCredentialsException("user or password is invalid!"));
//        ;
System.out.println(user);
//        if (username.isEmpty() || !username.get().isLoginCorrect(loginRequest, passwordEncoder)) {
//            throw new BadCredentialsException("user or p///assword is invalid!");
//        }

        var now = Instant.now();
        var expiresIn = 300L;
	
		var claims = JwtClaimsSet.builder()
				.issuer("mybackend")
				.subject(username.get().getId().toString())
				.issuedAt(now)
				.expiresAt(now.plusSeconds(expiresIn))
				.build();
		
		var jwtValue= jwtEncoder.encode(JwtEncoderParameters.from(claims)).getTokenValue();
	
		return ResponseEntity.ok(new LoginResponseDTO(jwtValue, expiresIn));
}
}