package edu.projeto.projetobiblioteca.repositores;

import edu.projeto.projetobiblioteca.model.Cliente;
import edu.projeto.projetobiblioteca.model.Pessoa;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PessoaRepository extends JpaRepository<Pessoa, Integer> {



}
