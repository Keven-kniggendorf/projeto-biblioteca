package edu.projeto.projetobiblioteca.model;

import jakarta.persistence.*;
import org.hibernate.annotations.Columns;

@Entity
public class Pessoa {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String nome;
    @Column(unique = true)
    private String email;
    private String senha;

    public Pessoa() {
    }

    public Pessoa(String nome, String email, String senha) {
        this.nome = nome;
        this.email = email;
        this.senha = senha;
    }

    //Construtor para Cliente
    public Pessoa(String nome, String cpf, String email, String senha){
        super();
        this.nome = nome;
        this.email = email;
        this.senha = senha;
    }

    //Construtor para ADM
    public Pessoa(String nome, int matricula, String email, String senha){
        super();
        this.nome = nome;
        this.email = email;
        this.senha = senha;
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



}
