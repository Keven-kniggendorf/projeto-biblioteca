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

            Cliente novoCliente = servicoCliente.cadastrarCliente(cliente);
            return ResponseEntity.status(HttpStatus.CREATED).body(novoCliente);
        }

        @PostMapping("/administrador")
        public ResponseEntity<?> cadastrarAdministrador(@Validated @RequestBody Administrador administrador) {
            // Validações comuns a todos os usuários
            if (!isValidEmail(administrador.getEmail())) {
                return ResponseEntity.badRequest().body("Email inválido");
            }
            // Se todas as validações passarem, chame o serviço para cadastrar o administrador
            Administrador novoAdministrador = servicoCliente.cadastrarAdm(administrador);
            return ResponseEntity.status(HttpStatus.CREATED).body(novoAdministrador);
        }

        // Método para validar o formato do CPF
        private boolean isValidCPF(String cpf) {
            // Implementação da validação do CPF (pode variar de acordo com as regras do seu país)
            return true; // Aqui você implementaria a lógica real de validação
        }

        // Método para validar o formato do email
        private boolean isValidEmail(String email) {
            return email != null && !email.isEmpty() && email.matches("^[\\w-\\.]+@([\\w-]+\\.)+[\\w-]{2,4}$");
        }


}
