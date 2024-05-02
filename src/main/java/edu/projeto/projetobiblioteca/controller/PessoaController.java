package edu.projeto.projetobiblioteca.controller;

import edu.projeto.projetobiblioteca.model.Administrador;
import edu.projeto.projetobiblioteca.model.Cliente;
import edu.projeto.projetobiblioteca.model.Pessoa;
import edu.projeto.projetobiblioteca.model.ServicoCliente;
import edu.projeto.projetobiblioteca.repositores.PessoaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.regex.Pattern;

@RestController
@RequestMapping("/cadastro")
@Validated
public class PessoaController {

        @Autowired
        private ServicoCliente servicoCliente;

        @PostMapping("/cliente")
        public ResponseEntity<?> cadastrarCliente(@Validated @RequestBody Cliente cliente) {
            // Validações específicas do cliente

            if (!isValidCPF(cliente.getCpf())) {
                return ResponseEntity.badRequest().body("CPF inválido");
            }
            // Validações comuns a todos os usuários
            if (!isValidEmail(cliente.getEmail())) {
                return ResponseEntity.badRequest().body("Email inválido");
            }


            Pessoa novoCliente = servicoCliente.cadastrarCliente(cliente);
            return ResponseEntity.status(HttpStatus.CREATED).body(novoCliente);
        }

        //Validação do cpf para ter 11 digitos
    private boolean isValidCPF(String cpf) {
        // Verifica se o CPF possui 11 dígitos
        if (cpf == null || cpf.length() != 11) {
            return false;
        }

        // Verifica se todos os caracteres são dígitos
        if (!Pattern.matches("\\d{11}", cpf)) {
            return false;
        }
        return true;
    }


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
            Pessoa novoAdministrador = servicoCliente.cadastrarAdm(administrador);
            return ResponseEntity.status(HttpStatus.CREATED).body(novoAdministrador);
        }


        // Método para validar o formato do email
        private boolean isValidEmail(String email) {
            return email != null && !email.isEmpty() && email.matches("^[\\w-\\.]+@([\\w-]+\\.)+[\\w-]{2,4}$");
        }


}
