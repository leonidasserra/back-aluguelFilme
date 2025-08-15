package com.projetoestagio.projeto_estagio.services.impl;

import com.projetoestagio.projeto_estagio.services.FilmeService;

import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import jakarta.persistence.EntityNotFoundException;
import com.projetoestagio.projeto_estagio.entities.Filme;
import com.projetoestagio.projeto_estagio.entities.Pessoa;
import com.projetoestagio.projeto_estagio.exceptions.BadRequestAlertException;
import com.projetoestagio.projeto_estagio.repositories.FilmeRepository;

@Service
public class FilmeServiceIpml implements FilmeService  {
	
	@Autowired
	private FilmeRepository filmeRepository ;

	@Override
	public Filme findById(Long id) {
		Optional<Filme> filme = filmeRepository.findById(id);
		return filme
				.orElseThrow(() -> new BadRequestAlertException("Filme não encontrado", "filme", "movienotfound"));
		
	}

	@Override
	public List<Filme> findByName(String name) {
		List<Filme> filme = filmeRepository.findByTitle(name);
		
		if(filme.isEmpty()) {
			throw new BadRequestAlertException("Filme não encontrado", "filme", "titlenotfound");
		}

			return filme;
	}

//	@Override
//	public String deleteById(Long id) {
//		Optional<Filme> filmeOpt = filmeRepository.findById(id);
//		Filme filmeResposta=new Filme();
//		if(filmeOpt.isPresent()) {
//			filmeResposta= filmeOpt.get();
//			filmeRepository.deleteById(filmeResposta.getId());
//			return "Pessoa Excluida com sucesso";	
//		}
//		return "Pessoa não foi encontrada";
//	}

	@Override
	public Filme criarFilme(Filme filme) {
		Filme filmeResposta=new Filme();
		
		if ((filme.getTitle().trim().isEmpty()
			    && filme.getAno() != null
			    && filme.getQuantidadeEstoque() != null
			    && !filme.getGenero().isEmpty()
			    && !filme.getSinopse().isEmpty()
			    && !filme.getDiretor().isEmpty()
			    && filme.getClassificacao() != null
			    && filme.getDuracao() != null)) {
			    
			    filmeResposta.setAno(filme.getAno());
			    filmeResposta.setTitle(filme.getTitle());
			    filmeResposta.setGenero(filme.getGenero());
			    filmeResposta.setQuantidadeEstoque(filme.getQuantidadeEstoque());
			    filmeResposta.setSinopse(filme.getSinopse());
			    filmeResposta.setDiretor(filme.getDiretor());
			    filmeResposta.setClassificacao(filme.getClassificacao());
			    filmeResposta.setDuracao(filme.getDuracao());

			    return filmeRepository.save(filmeResposta);
			    }
			    	
		throw new BadRequestAlertException("Dados Incompletos para Pessoa", "pessoa", "dadosinvalidos"); 
	}



//	@Override
//	public Filme atualizarFilme(Filme filme) {
//		// TODO Auto-generated method stub
//		return null;
//	}
//	
//	@Override
//	public boolean existsById(Long id) {
//		Optional<Filme> filmeOpt = filmeRepository.findById(id);
//		//Pessoa pessoaResposta = new Pessoa();
//		if(filmeOpt.isPresent()) {
//			return true;
//		}
//		else {
//			return false;
//	}
//		}

    @Override
    public Filme salvarFilme(Filme filme) {
        return filmeRepository.save(filme); //  salva alterações (usado no set do novo estoque)
    }
//
//    
    @Override
    public Set<Filme> findByIdList(Set<Long> ids) {
        Set<Filme> filmes = new HashSet<>(filmeRepository.findAllById(ids));

        if (filmes.size() != ids.size()) {
            throw new BadRequestAlertException("Um ou mais filmes não foram encontrados", "filme", "idnotfound");
        }

        return filmes;
    }
//
//    @Override
//    public List<Filme> findAll(){
//    	List<Filme> todosFilmes=filmeRepository.findAll();
//    	
//    	return todosFilmes;
//    }
    
	
	
}

