package com.projetoestagio.projeto_estagio.services.impl;

import java.lang.System.Logger;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.projetoestagio.projeto_estagio.entities.Filme;
import com.projetoestagio.projeto_estagio.entities.Aluguel;
import com.projetoestagio.projeto_estagio.entities.Pessoa;
import com.projetoestagio.projeto_estagio.exceptions.BadRequestAlertException;
import com.projetoestagio.projeto_estagio.repositories.AluguelRepository;
import com.projetoestagio.projeto_estagio.services.AluguelService;
import com.projetoestagio.projeto_estagio.services.FilmeService;
import com.projetoestagio.projeto_estagio.services.PessoaService;

import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;

@Service
public /*abstract*/ class AluguelServiceIpml implements AluguelService {

	@Autowired
	private PessoaService pessoaService;
//	
	@Autowired
	private FilmeService filmeService;
	
    @Autowired
    private AluguelRepository aluguelRepository;

    @Override
    public List<Aluguel> buscarPorNomePessoa(String nome) {
    	List<Aluguel> aluguelResposta = aluguelRepository.buscarPorNomePessoa(nome);
    	
    	if(aluguelResposta.isEmpty()) {
    		throw new BadRequestAlertException("Entity not found", "aluguel", "namenotfound");
    	   
    	}
    	
        return aluguelResposta;
 }
//    
//    @Override
//    public List<Aluguel> buscarPorTituloFilme(String title) {
//        return aluguelRepository.findByFilmeTitleContainingIgnoreCase(title);
//    }
//
//
    @Override
    public Aluguel findById(Long id) {
        return aluguelRepository.findById(id)
                .orElseThrow(() -> new BadRequestAlertException("Entity not found", "aluguel", "idnotfound"));
    }




  //READEQUAR CRIAR ALUGUEL
    @Override
    public Aluguel criarAluguel(Aluguel aluguel) {
        if (aluguel.getValorAluguel() != null && aluguel.getDataAluguel() != null) {
            Aluguel aluguelResposta = new Aluguel();
            aluguelResposta.setValorAluguel(aluguel.getValorAluguel());
            aluguelResposta.setDataAluguel(aluguel.getDataAluguel());
            aluguelResposta.setDevolucaoPrevista(aluguel.getDataAluguel().plusDays(30));
            aluguelResposta.setStatus("Ativo");
//            
            // 1. Extrair os IDs dos filmes recebidos
            Set<Long> filmeIds = new HashSet<>();
            for (Filme f : aluguel.getFilmes()) {
                filmeIds.add(f.getId());
            }
//           
            // 2. Buscar os filmes completos do banco
            Set<Filme> filmes = filmeService.findByIdList(filmeIds);
            System.out.println("filme:"+filmes);  
//            
            if(aluguel.getPessoa().getId()!=null  && aluguel.getFilmes()!=null ) {
            	Optional<Pessoa> pessoa = Optional.of(pessoaService.findById(aluguel.getPessoa().getId()));
            	aluguelResposta.setPessoa(pessoa.get());
            	}
//            	//System.out.println("Pessoa: " + aluguelResposta.getPessoa());
//            	
            	for (Filme f : filmes) {
            		// Verificar se há estoque
                    if (f.getQuantidadeEstoque() <= 0) {
                        throw new BadRequestAlertException("Filme sem estoque disponível", "filme", "estoquezerado");
                    }
                }
           

            	
            aluguelResposta.setFilmes(filmes);
            
            for (Filme f : filmes) {
            //Decrescimo no Estoque
            f.setQuantidadeEstoque(f.getQuantidadeEstoque()-1);
            filmeService.salvarFilme(f);
            }

            

            return aluguelRepository.save(aluguelResposta);
        }
//
        throw new BadRequestAlertException("Dados incompletos para criar aluguel", "aluguel", "dadosinvalidos");
    	

    }

//	@Override
//	public String deleteById(Long id) {
//		Optional<Aluguel> aluguelOpt = aluguelRepository.findById(id);
//		Aluguel aluguelResposta = new Aluguel();
//		if(aluguelOpt.isPresent()) {
//			aluguelResposta= aluguelOpt.get();
//			aluguelRepository.deleteById(aluguelResposta.getId());
//			return "Aluguel Excluida com sucesso";	
//		}
//		throw new BadRequestAlertException("Dados incompletos para criar aluguel", "aluguel", "dadosinvalidos");
//	}

//	@Override
//	public boolean existsById(Long id) {
//		Optional<Aluguel> aluguelOpt = aluguelRepository.findById(id);
//		//Pessoa pessoaResposta = new Pessoa();
//		if(aluguelOpt.isPresent()) {
//			return true;
//		}
//		else {
//		return false;
//	}
//		}




	@Override
	public Aluguel finalizarAluguel(Long id) {
			Aluguel aluguelResposta =  aluguelRepository.findById(id) 
					.orElseThrow(() -> new EntityNotFoundException("Aluguel não encontrado"));
;
			aluguelResposta.setStatus("Finalizado");
			
			Set<Filme> filmes =aluguelResposta.getFilmes();
			for (Filme f : filmes) {
				f.setQuantidadeEstoque(f.getQuantidadeEstoque()+1);
			}
			return aluguelRepository.save(aluguelResposta);
		
	}
	@Override
	public List<Aluguel> buscarPorIdFilme(Long id) {
		
		return aluguelRepository.buscarPorIdFilme(id);
	}







	
	
}
