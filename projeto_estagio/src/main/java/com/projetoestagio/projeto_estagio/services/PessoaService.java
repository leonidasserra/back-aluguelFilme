package com.projetoestagio.projeto_estagio.services;

import java.util.List;
import java.util.Optional;

import com.projetoestagio.projeto_estagio.entities.Filme;
import com.projetoestagio.projeto_estagio.entities.Pessoa;

public interface PessoaService {
    Pessoa findById(Long id);
    List<Pessoa> findByName(String name);
    Pessoa criarPessoa(Pessoa pessoa);
//	String deleteById(Long id);
//	Pessoa atualizarPessoa(Pessoa pessoa);
//	boolean existsById(Long id);
//	public List<Pessoa> findAll();
	List<Pessoa> findAll();
}
