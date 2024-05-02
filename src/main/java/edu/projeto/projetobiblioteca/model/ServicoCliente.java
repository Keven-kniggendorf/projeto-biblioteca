package edu.projeto.projetobiblioteca.model;

import edu.projeto.projetobiblioteca.repositores.PessoaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ServicoCliente {

    @Autowired
   private PessoaRepository pessoaRepository;


    public Pessoa cadastrarCliente(Pessoa cliente){
        return pessoaRepository.save(cliente);
    }


    public Pessoa cadastrarAdm(Pessoa adm){
        return pessoaRepository.save(adm);
    }
}
