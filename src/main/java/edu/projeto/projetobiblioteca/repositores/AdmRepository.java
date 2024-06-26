package edu.projeto.projetobiblioteca.repositores;

import edu.projeto.projetobiblioteca.model.Administrador;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.security.core.userdetails.UserDetails;

public interface AdmRepository extends JpaRepository<Administrador, Integer> {

}
