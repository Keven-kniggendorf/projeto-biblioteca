package edu.projeto.projetobiblioteca.service;

import edu.projeto.projetobiblioteca.model.Cliente;
import edu.projeto.projetobiblioteca.repositores.ClienteRepository;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

@Service
public class ServicoCliente {

    @Autowired
    private ClienteRepository clienteRepository;
    private HttpServletRequest request;


    public Cliente cadastrarCliente(Cliente cliente) {
        return clienteRepository.save(cliente);
    }

    public Cliente buscarClientePorCpf(String cpf) {
        return clienteRepository.findByCpf(cpf).orElse(null);
    }

    public Cliente atualizarCliente(Cliente cliente) {
        return clienteRepository.save(cliente);
    }

    public void deletarCliente(int id) {
        clienteRepository.deleteById(id);
    }

    public Cliente getUsuarioLogado() {
        HttpServletRequest request = null;
        return (Cliente) request.getSession().getAttribute("cpf");
    }

}

