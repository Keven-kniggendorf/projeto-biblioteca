package edu.projeto.projetobiblioteca.controller;

import edu.projeto.projetobiblioteca.model.Administrador;
import edu.projeto.projetobiblioteca.service.AdmService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.regex.Pattern;

@Validated
@RestController
@RequestMapping("/cadastroadm")
public class AdmController {

    private AdmService AdmService;

    private boolean isValidMatricula(String matricula) {
        // Verifica se o CPF possui 11 dígitos
        if (matricula == null || matricula.length() != 10) {
            return false;
        }

            // Verifica se todos os caracteres são dígitos
            if (!Pattern.matches("\\d{10}", matricula)) {
                return false;
            }
            return true;
        }

    @PostMapping("/administrador")
    public ResponseEntity<?> cadastrarAdministrador(@Validated @RequestBody Administrador administrador) {
        // trasnformei o int da matricula em String
        String matriculaString = String.valueOf(administrador.getMatricula());

        if (!isValidMatricula(matriculaString)) {
            return ResponseEntity.badRequest().body("Matricula inválida");
        }
        // Se todas as validações passarem, chame o serviço para cadastrar o administrador
        Administrador novoAdministrador = AdmService.cadastrarAdm(administrador);
        return ResponseEntity.status(HttpStatus.CREATED).body(novoAdministrador);
    }


}
