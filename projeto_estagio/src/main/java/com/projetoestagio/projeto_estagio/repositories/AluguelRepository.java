package com.projetoestagio.projeto_estagio.repositories;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;

import com.projetoestagio.projeto_estagio.entities.Aluguel;
import com.projetoestagio.projeto_estagio.entities.Pessoa;

public interface AluguelRepository extends JpaRepository<Aluguel,Long> {
	//List<Aluguel> findByName(@Param("name") String name);
	List<Aluguel> findByPessoaNameContainingIgnoreCase(String name);
	List<Aluguel> findByFilmeTitleContainingIgnoreCase(String title);
}
