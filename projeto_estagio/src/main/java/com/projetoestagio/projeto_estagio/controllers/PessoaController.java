package com.projetoestagio.projeto_estagio.controllers;


import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.projetoestagio.projeto_estagio.entities.Pessoa;
import com.projetoestagio.projeto_estagio.services.PessoaService;

import jakarta.persistence.EntityNotFoundException;

@RestController
@RequestMapping("/pessoa")
public class PessoaController {
	private  PessoaService pessoaService;

	public PessoaController(PessoaService pessoaService) {
		this.pessoaService = pessoaService;
	}
	
	@PostMapping("/criar")
	public ResponseEntity<Pessoa> criarPessoa(@RequestBody Pessoa pessoa) throws URISyntaxException {
		Pessoa respostaPessoa= pessoaService.criarPessoa(pessoa);
		return  ResponseEntity.created(new URI("/pessoa/criar")).body(respostaPessoa);
		
	}
	@PutMapping("/atualizar")
	public ResponseEntity<Pessoa> atualizarPessoa(@RequestBody Pessoa pessoa){
		Pessoa respostaPessoa= pessoaService.atualizarPessoa(pessoa);
		return ResponseEntity.ok(respostaPessoa);
	} 
	
	@GetMapping("/buscar/{id}")
	public ResponseEntity<?> buscarPessoaId(@PathVariable Long id){
		try {
		Pessoa respostaPessoa= pessoaService.findById(id);
		return ResponseEntity.ok(respostaPessoa);}
		
		catch (EntityNotFoundException e) {
	        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
	    }
	} 
	
	@GetMapping("/buscar")
	public ResponseEntity</*List<Pessoa> */ ?> buscarPessoaName(@RequestParam String name){
		List<Pessoa> respostaPessoa= pessoaService.findByName(name);
		return ResponseEntity.ok(respostaPessoa);
	}
	
	@DeleteMapping("/deletar/{id}")
	public ResponseEntity<Void> deletarPessoaId(@PathVariable Long id){
		try {
		String respostaPessoa= pessoaService.deleteById(id);
		return ResponseEntity.noContent().build();}
		
		catch(EntityNotFoundException e){
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
		}
	
	}
	
}
