package edu.projeto.projetobiblioteca.repositores;

import edu.projeto.projetobiblioteca.model.Administrador;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AdmRepository extends JpaRepository<Administrador, Integer> {
}
