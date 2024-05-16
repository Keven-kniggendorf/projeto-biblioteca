package edu.projeto.projetobiblioteca.repositores;

import edu.projeto.projetobiblioteca.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.security.core.userdetails.UserDetails;

public interface UserRepository extends JpaRepository<User, Integer> {

  public  User findByEmail(String email);
}
