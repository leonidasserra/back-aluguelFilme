package com.projetoestagio.projeto_estagio.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.projetoestagio.projeto_estagio.entities.Pessoa;

@Repository
public interface PessoaRepository extends JpaRepository<Pessoa,Long> {
	@Query("SELECT p FROM Pessoa p WHERE LOWER(p.name) LIKE LOWER(CONCAT('%', :name, '%'))")
	List<Pessoa> findByName(@Param("name") String name);
//	Pessoa criarPessoa(Pessoa pessoa);
//	Pessoa deletePessoa(Pessoa pessoa);	
//		
}
