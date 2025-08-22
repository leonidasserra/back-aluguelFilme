package com.projetoestagio.projeto_estagio.controllers;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.projetoestagio.projeto_estagio.entities.Aluguel;

import com.projetoestagio.projeto_estagio.exceptions.BadRequestAlertException;
import com.projetoestagio.projeto_estagio.services.AluguelService;


@CrossOrigin("*")
@RestController
@RequestMapping("/aluguel")
public class AluguelController {

	@Autowired
	private AluguelService aluguelService;

//
//	public void setAluguelService(AluguelService aluguelService) {
//		this.aluguelService = aluguelService;
//	} 
	

//	@DeleteMapping("/deletar/{id}")
//	public ResponseEntity<Void> deletarAluguelId(@PathVariable Long id) {
//	    if (id == null) {
//	        throw new BadRequestAlertException("Invalid id", "aluguel", "idnull");
//	    }
//
//	    if (!aluguelService.existsById(id)) {
//	        throw new BadRequestAlertException("Entity not found", "aluguel", "idnotfound");
//	    }
//
//	    aluguelService.deleteById(id);
//
//	    return ResponseEntity.noContent().build();
//	}
	

	
	@GetMapping("/buscar/{id}")
	public ResponseEntity<Aluguel> buscarAluguelId(@PathVariable Long id){
			Aluguel respostaAluguel= aluguelService.findById(id);
			return ResponseEntity.ok(respostaAluguel);}

	
	@GetMapping("/buscar")
	public ResponseEntity<List<Aluguel>> buscarPorNomePessoa(@RequestParam String name){
		List<Aluguel> respostaAluguel= aluguelService.buscarPorNomePessoa(name);
		return ResponseEntity.ok(respostaAluguel);
		
	}	
	@GetMapping("/buscafilme/{id}")
	public ResponseEntity<List<Aluguel>> buscarPorFilmeId(@PathVariable Long id){
		List<Aluguel> respostaAluguel= aluguelService.buscarPorIdFilme(id);
		return ResponseEntity.ok(respostaAluguel);}
	
	@PostMapping("/criar")
	public ResponseEntity<Aluguel> criarAluguel(@RequestBody Aluguel aluguel) throws URISyntaxException {
		
		Aluguel respostaAluguel= aluguelService.criarAluguel(aluguel);
		
		return  ResponseEntity.created(new URI("/aluguel/criar")).body(respostaAluguel);
	}
	
	
	@PutMapping("/finalizar/{id}")
	public ResponseEntity<Aluguel> finalizarAluguel(@PathVariable Long id){
		Aluguel respostaAluguel= aluguelService.finalizarAluguel(id);
		return ResponseEntity.ok(respostaAluguel);}
	
	
	
}
