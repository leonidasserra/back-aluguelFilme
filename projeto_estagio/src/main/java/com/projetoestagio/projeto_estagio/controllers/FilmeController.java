package com.projetoestagio.projeto_estagio.controllers;

import java.net.URI;
import java.net.URISyntaxException;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.projetoestagio.projeto_estagio.entities.Filme;
import com.projetoestagio.projeto_estagio.entities.Pessoa;
import com.projetoestagio.projeto_estagio.services.FilmeService;

@RestController
@RequestMapping("/filme")
public class FilmeController {
	
	private FilmeService filmeService;
	
	
	@PostMapping("/criar")
	public ResponseEntity<Filme> criarFilme(@RequestBody Filme filme) throws URISyntaxException {
		Filme respostaFilme= filmeService.criarFilme(filme);
		return  ResponseEntity.created(new URI("/filme/criar")).body(respostaFilme);
		
	}
	
	
}
