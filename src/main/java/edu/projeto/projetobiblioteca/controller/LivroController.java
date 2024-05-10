package edu.projeto.projetobiblioteca.controller;

import edu.projeto.projetobiblioteca.model.Livro;
import edu.projeto.projetobiblioteca.service.LivroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

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

    @PutMapping("/alugarlivro/{id}")
    public ResponseEntity<?> alugarLivro( @RequestBody Livro livro){

        Livro alugarLivro = livroService.alugarLivro(livro);
        return new ResponseEntity<>(alugarLivro, HttpStatus.OK);

    }

}
