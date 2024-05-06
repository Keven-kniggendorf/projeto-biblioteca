package edu.projeto.projetobiblioteca.service;

import edu.projeto.projetobiblioteca.model.Livro;
import edu.projeto.projetobiblioteca.model.Pessoa;
import edu.projeto.projetobiblioteca.repositores.LivroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LivroService {

    @Autowired
    private LivroRepository livroRepository;

    public Livro cadastrarLivro(Livro livro){
        return livroRepository.save(livro);
    }


}
