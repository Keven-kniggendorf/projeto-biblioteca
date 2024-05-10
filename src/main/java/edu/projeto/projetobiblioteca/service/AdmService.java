package edu.projeto.projetobiblioteca.service;

import edu.projeto.projetobiblioteca.model.Administrador;
import edu.projeto.projetobiblioteca.model.Cliente;
import edu.projeto.projetobiblioteca.repositores.AdmRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Optional;

public class AdmService {

    @Autowired
    AdmRepository admRepository;

    public Administrador cadastrarAdm(Administrador adm){
        return admRepository.save(adm);
    }

    public Optional<Administrador> buscarAdm(int id) {
        return admRepository.findById(id);
    }

    public Administrador atualizarAdm(Administrador adm) {
        return admRepository.save(adm);
    }

    public void deletarAdm(int id) {
        admRepository.deleteById(id);
    }

}


