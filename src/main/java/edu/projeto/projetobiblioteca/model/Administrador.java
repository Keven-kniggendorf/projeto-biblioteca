package edu.projeto.projetobiblioteca.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;

@Entity
public class Administrador extends Pessoa{

    @Column(unique = true)
    private int matricula;

    public int getMatricula() {
        return matricula;
    }

    public void setMatricula(int matricula) {
        this.matricula = matricula;
    }
}
