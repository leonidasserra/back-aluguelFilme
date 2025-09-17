package com.projetoestagio.projeto_estagio.controllers;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.projetoestagio.projeto_estagio.entities.Aluguel;
import com.projetoestagio.projeto_estagio.entities.Filme;
import com.projetoestagio.projeto_estagio.entities.Pessoa;
import com.projetoestagio.projeto_estagio.services.FilmeService;

//@CrossOrigin(origins = "http://localhost:5173")
@CrossOrigin("*")
@RestController
@RequestMapping("/filme")
public class FilmeController {
	
	@Autowired
	private FilmeService filmeService;
	
	
	@PostMapping("/criar")
	public ResponseEntity<Filme> criarFilme(@RequestBody Filme filme) throws URISyntaxException {
		Filme respostaFilme= filmeService.criarFilme(filme);
		return  ResponseEntity.created(new URI("/filme/criar")).body(respostaFilme);
		
	}
	
	@GetMapping("/buscar/{id}")
	public ResponseEntity<Filme> buscarFilmeId(@PathVariable Long id){
		Filme respostaFilme= filmeService.findById(id);
		return  ResponseEntity.ok(respostaFilme);
	}
	@GetMapping("/buscar")
	public ResponseEntity<List<Filme>> buscarFilmeId(@RequestParam String title){
		List<Filme> respostaFilme= filmeService.findByName(title);
		return  ResponseEntity.ok(respostaFilme);
	}
	
	@GetMapping("/listar")
	public ResponseEntity<List<Filme>> buscarTodosFilmes(){
		List<Filme> respostaFilme= filmeService.findAll();
		return ResponseEntity.ok(respostaFilme);
	}
}
