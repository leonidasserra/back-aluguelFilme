package com.projetoestagio.projeto_estagio.services.impl;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

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

@Service
public /*abstract*/ class AluguelServiceIpml implements AluguelService {

	@Autowired
	private PessoaService pessoaService;
	
	@Autowired
	private FilmeService filmeService;
	
    @Autowired
    private AluguelRepository aluguelRepository;

    @Override
    public List<Aluguel> buscarPorNomePessoa(String nome) {
        return aluguelRepository.findByPessoaNameContainingIgnoreCase(nome);
    }
    
    @Override
    public List<Aluguel> buscarPorTituloFilme(String title) {
        return aluguelRepository.findByFilmeTitleContainingIgnoreCase(title);
    }


    @Override
    public Aluguel findById(Long id) {
        return aluguelRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Aluguel não encontrado"));
    }


    @Override
    public Aluguel criarAluguel(Aluguel aluguel) {
        if (aluguel.getValorAluguel() != null && aluguel.getDataAluguel() != null) {
            Aluguel aluguelResposta = new Aluguel();
            aluguelResposta.setValorAluguel(aluguel.getValorAluguel());
            aluguelResposta.setDataAluguel(aluguel.getDataAluguel());
            Filme filme = filmeService.findById(aluguel.getFilme().getId());
            if(aluguel.getPessoa().getId()!=null && aluguel.getFilme().getId()!=null) {
            	Optional<Pessoa> pessoa = Optional.of(pessoaService.findById(aluguel.getPessoa().getId()));
            	aluguelResposta.setPessoa(pessoa.get());
            	//System.out.println("Pessoa: " + aluguelResposta.getPessoa());
            	
            	
            	// Verificar se há estoque
                if (filme.getQuantidadeEstoque() <= 0) {
                    throw new BadRequestAlertException("Filme sem estoque disponível", "filme", "estoquezerado");
                }
            	}
            aluguelResposta.setFilme(filme);
            
            //Decrescimo no Estoque
            filme.setQuantidadeEstoque(filme.getQuantidadeEstoque()-1);
            filmeService.salvarFilme(filme);

            
            // Supondo que dataAluguel seja LocalDate:
            LocalDate data = aluguel.getDataAluguel();
            aluguelResposta.setDevolucaoPrevista(data.plusDays(30));
            aluguelResposta.setStatus("Ativo");
            return aluguelRepository.save(aluguelResposta);
        }

        throw new BadRequestAlertException("Dados incompletos para criar aluguel", "aluguel", "dadosinvalidos");
    }

	@Override
	public String deleteById(Long id) {
		Optional<Aluguel> aluguelOpt = aluguelRepository.findById(id);
		Aluguel aluguelResposta = new Aluguel();
		if(aluguelOpt.isPresent()) {
			aluguelResposta= aluguelOpt.get();
			aluguelRepository.deleteById(aluguelResposta.getId());
			return "Aluguel Excluida com sucesso";	
		}
		throw new BadRequestAlertException("Dados incompletos para criar aluguel", "aluguel", "dadosinvalidos");
	}

	@Override
	public boolean existsById(Long id) {
		Optional<Aluguel> aluguelOpt = aluguelRepository.findById(id);
		//Pessoa pessoaResposta = new Pessoa();
		if(aluguelOpt.isPresent()) {
			return true;
		}
		else {
		return false;
	}
		}


}
