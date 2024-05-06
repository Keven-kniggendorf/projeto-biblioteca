package edu.projeto.projetobiblioteca.controller;

import edu.projeto.projetobiblioteca.model.Cliente;
import edu.projeto.projetobiblioteca.model.Livro;
import edu.projeto.projetobiblioteca.model.Pessoa;
import edu.projeto.projetobiblioteca.repositores.LivroRepository;
import edu.projeto.projetobiblioteca.service.LivroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/cadlivro")
@Validated
public class LivroController {

    @Autowired
    private LivroService livroService;


    @PostMapping("/livro")
    public ResponseEntity<?> cadastrarLivro(@Validated @RequestBody Livro livro) {
        // Validações específicas do cliente


        Livro novoLivro = livroService.cadastrarLivro(livro);
        return ResponseEntity.status(HttpStatus.CREATED).body(novoLivro);
    }

}
