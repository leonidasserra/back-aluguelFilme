package com.projetoestagio.projeto_estagio.services;

import java.util.List;

import com.projetoestagio.projeto_estagio.entities.Aluguel;

public interface AluguelService {
	Aluguel findById(Long id);
    //List<Aluguel> findByName(String name);
	
    Aluguel criarAluguel(Aluguel aluguel);
    Aluguel finalizarAluguel(Long id);
    
//	String deleteById(Long id);
	List<Aluguel> buscarPorNomePessoa(String nome);
//	boolean existsById(Long id);
//	List<Aluguel> buscarPorTituloFilme(String titulo);
}
