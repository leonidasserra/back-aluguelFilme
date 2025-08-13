package com.projetoestagio.projeto_estagio.services.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Service;

import com.projetoestagio.projeto_estagio.entities.Filme;
import com.projetoestagio.projeto_estagio.entities.Pessoa;
import com.projetoestagio.projeto_estagio.exceptions.BadRequestAlertException;
import com.projetoestagio.projeto_estagio.repositories.PessoaRepository;
import com.projetoestagio.projeto_estagio.services.PessoaService;

import jakarta.persistence.EntityNotFoundException;

@Service
public class PessoaServiceIpml implements PessoaService{
	
	@Autowired
	private  PessoaRepository pessoaRepository ;
	


	@Override
	public Pessoa findById(Long id) {
		Optional<Pessoa> pessoa = pessoaRepository.findById(id);
			return pessoa
					.orElseThrow(() -> new BadRequestAlertException("Pessoa não encontrada", "pessoa", "namenotfound"));
	 
} 


	
	@Override
	public List<Pessoa> findByName(String name){
		List<Pessoa> pessoas = pessoaRepository.findByName(name);

		if(pessoas.isEmpty()) {
			throw new BadRequestAlertException("Pessoa não encontrada", "pessoa", "namenotfound");
		}

			return pessoas;
	}

	@Override
	public Pessoa criarPessoa(Pessoa pessoa) {
		Pessoa pessoaResposta = new Pessoa();
		
		if(!(pessoa.getName().isEmpty() || pessoa.getCpf().isEmpty() /*|| pessoa.getSenha().isEmpty()*/)) {
			pessoaResposta.setCpf(pessoa.getCpf());
			pessoaResposta.setName(pessoa.getName());
			pessoaResposta.setEmail(pessoa.getEmail());
			pessoaResposta.setNascimento(pessoa.getNascimento());
			pessoaResposta.setTelefone(pessoa.getTelefone());
//			pessoaResposta.setSenha(pessoa.getSenha());
			Pessoa pessoaSalva = pessoaRepository.save(pessoaResposta);
			return pessoaSalva;
		}
		return null;
	}

//	@Override
//	public String deleteById(Long id) {
//		Optional<Pessoa> pessoaOpt = pessoaRepository.findById(id);
//		Pessoa pessoaResposta = new Pessoa();
//		if(pessoaOpt.isPresent()) {
//			 pessoaResposta= pessoaOpt.get();
//			 pessoaRepository.deleteById(pessoaResposta.getId());
//			return "Pessoa Excluida com sucesso";	
//		}
//		return "Pessoa não foi encontrada";
//	}
//
//	@Override
//	public Pessoa atualizarPessoa(Pessoa pessoa) {
//		Optional<Pessoa> pessoaOpt = pessoaRepository.findById(pessoa.getId());
//		Pessoa pessoaResposta = new Pessoa();
//		if(pessoaOpt.isPresent()) {
//			 pessoaResposta= pessoaOpt.get();
//			 pessoaResposta.setCpf(pessoa.getCpf());
//				pessoaResposta.setName(pessoa.getName());
//				pessoaResposta.setEmail(pessoa.getEmail());
//				pessoaResposta.setNascimento(pessoa.getNascimento());
//				pessoaResposta.setTelefone(pessoa.getTelefone());
//				Pessoa pessoaSalva = pessoaRepository.save(pessoaResposta);
//				return pessoaSalva;
//		}
//		return null;
//	}
//
//	@Override
//	public boolean existsById(Long id) {
//		Optional<Pessoa> pessoaOpt = pessoaRepository.findById(id);
//		//Pessoa pessoaResposta = new Pessoa();
//		if(pessoaOpt.isPresent()) {
//			return true;
//		}
//		else {
//		return false;
//	}
//		}
//
//    @Override
//    public List<Pessoa> findAll(){
//    	List<Pessoa> todasPessoas=pessoaRepository.findAll();
//    	
//    	return todasPessoas;
//    }
	
}
