package edu.projeto.projetobiblioteca.model;

import jakarta.persistence.*;

@Entity
public class Administrador {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String nome;
    @Column(unique = true)
    private String email;
    private String senha;
    @Column(unique = true)
    private int matricula;

public Administrador() {
    }

    public Administrador(String nome, int matricula, String email, String senha){
        super();
        this.nome = nome;
        this.email = email;
        this.senha = senha;
        this.matricula = matricula;
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public int getMatricula() {
        return matricula;
    }

    public void setMatricula(int matricula) {
        this.matricula = matricula;
    }
}
