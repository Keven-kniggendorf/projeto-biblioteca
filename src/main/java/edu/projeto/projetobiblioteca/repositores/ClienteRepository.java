package edu.projeto.projetobiblioteca.repositores;

import edu.projeto.projetobiblioteca.model.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ClienteRepository extends JpaRepository<Cliente, Integer> {

    Optional<Cliente> findByCpf(String cpf);


}
