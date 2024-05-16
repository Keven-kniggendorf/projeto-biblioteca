package edu.projeto.projetobiblioteca.controller;

import edu.projeto.projetobiblioteca.config.AuthenticationDTO;
import edu.projeto.projetobiblioteca.config.RecordDTO;
import edu.projeto.projetobiblioteca.model.User;
import edu.projeto.projetobiblioteca.repositores.AdmRepository;
import edu.projeto.projetobiblioteca.repositores.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
public class AuthenticationController {

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    UserRepository userRepository;

    @PostMapping("/login")
    public ResponseEntity login(@RequestBody @Validated AuthenticationDTO data){
    var usernamePassowrdToken = new UsernamePasswordAuthenticationToken(data.email(), data.senha());
    var authentication = authenticationManager.authenticate(usernamePassowrdToken);

    return ResponseEntity.ok().build();
    }

    @PostMapping("/register")
    public ResponseEntity register(@RequestBody @Validated RecordDTO data) {
        if (userRepository.findByEmail(data.email()) != null) {
            return ResponseEntity.badRequest().build();
        }
        String CriptSenha = new BCryptPasswordEncoder().encode(data.senha());
        User user = new User(data.email(), CriptSenha, data.role());

        userRepository.save(user);

        return ResponseEntity.ok().build();

    }


}
