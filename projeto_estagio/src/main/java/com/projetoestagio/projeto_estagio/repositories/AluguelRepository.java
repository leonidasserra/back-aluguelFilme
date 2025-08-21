package com.projetoestagio.projeto_estagio.repositories;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.projetoestagio.projeto_estagio.entities.Aluguel;
import com.projetoestagio.projeto_estagio.entities.Pessoa;

@Repository
public interface AluguelRepository extends JpaRepository<Aluguel,Long> {
	
	@Query(" select a from Aluguel a join a.filmes f where f.id=:idBuscado")
	List<Aluguel> buscarPorIdFilme(Long idBuscado);
	
	
	@Query(" select a from Aluguel a join a.pessoa p where lower (p.name) like lower(concat('%', :name ,'%')) ")
	List<Aluguel> buscarPorNomePessoa(String name);


}
