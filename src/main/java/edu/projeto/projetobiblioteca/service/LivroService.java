package edu.projeto.projetobiblioteca.service;

import edu.projeto.projetobiblioteca.model.Livro;
import edu.projeto.projetobiblioteca.model.Status;
import edu.projeto.projetobiblioteca.repositores.LivroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class LivroService {

    @Autowired
    private LivroRepository livroRepository;

    private ServicoCliente servicoCliente;

    public Livro cadastrarLivro(Livro livro){
        return livroRepository.save(livro);
    }

    public Optional<Livro> buscarLivro(int id) {
        return livroRepository.findById(id);
    }

    public Livro atualizarLivro(Livro livro) {
        return livroRepository.save(livro);
    }

    public void deletarLivro(int id) {
        livroRepository.deleteById(id);
    }


    public Livro alugarLivro(Livro livro) {
        livroRepository.findById(livro.getId()).orElse(null);


        if (livro.getStatus().equals(Status.DISPONIVEL)) {
            livro.setStatus(Status.ALUGADO);
            livro.setPessoaAlugando(servicoCliente.getUsuarioLogado()); // Associa o livro ao cliente
            livroRepository.save(livro);
        } else {
            throw new RuntimeException("Livro não disponível para aluguel ou cliente não encontrado.");
        }
        return livro;
    }


}
