
package com.projetoestagio.projeto_estagio.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.projetoestagio.projeto_estagio.entities.Filme;


@Service
public interface FilmeService {
	Filme findById(Long id);
	List<Filme> findByName(String name);
//	List<Filme> findByIdList(List<Long> ids);
//	String deleteById(Long id);
	Filme criarFilme(Filme filme);
//	Filme atualizarFilme(Filme filme);
//	Filme salvarFilme(Filme filme);
//	boolean existsById(Long id);
//	List<Filme> findAll();
}

