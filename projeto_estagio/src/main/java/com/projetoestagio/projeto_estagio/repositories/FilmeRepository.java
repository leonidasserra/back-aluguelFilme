package com.projetoestagio.projeto_estagio.repositories;


import java.util.List;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.projetoestagio.projeto_estagio.entities.Filme;

@Repository
public interface FilmeRepository extends JpaRepository<Filme,Long> {
	@Query("SELECT f FROM Filme f WHERE LOWER(f.title) LIKE LOWER(CONCAT('%', :title, '%'))")
	List<Filme> findByTitle(String title);
		
	List<Filme> findAllById(Iterable<Long> ids);
}

