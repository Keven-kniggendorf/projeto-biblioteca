package edu.projeto.projetobiblioteca.controller;

import edu.projeto.projetobiblioteca.model.Cliente;
import edu.projeto.projetobiblioteca.service.ServicoCliente;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.regex.Pattern;

@RestController
@RequestMapping("/cadastro")
@Validated
public class ClienteController {

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


        Cliente novoCliente = servicoCliente.cadastrarCliente(cliente);
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

    private boolean isValidEmail(String email) {
        return email != null && !email.isEmpty() && email.matches("^[\\w-\\.]+@([\\w-]+\\.)+[\\w-]{2,4}$");
    }


}
