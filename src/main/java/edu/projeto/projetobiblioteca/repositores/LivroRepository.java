package edu.projeto.projetobiblioteca.repositores;

import edu.projeto.projetobiblioteca.model.Livro;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LivroRepository extends JpaRepository<Livro, Integer> {
}
