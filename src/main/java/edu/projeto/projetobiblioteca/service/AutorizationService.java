package edu.projeto.projetobiblioteca.service;

import edu.projeto.projetobiblioteca.model.Administrador;
import edu.projeto.projetobiblioteca.model.Cliente;
import edu.projeto.projetobiblioteca.repositores.AdmRepository;
import edu.projeto.projetobiblioteca.repositores.UserRepository;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class AutorizationService implements UserDetailsService {

    UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        return userRepository.findByEmail(email);

    }


}
