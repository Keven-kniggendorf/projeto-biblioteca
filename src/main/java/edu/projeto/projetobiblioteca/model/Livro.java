package edu.projeto.projetobiblioteca.model;

import jakarta.persistence.*;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

@Entity
public class Livro {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String nome;
    private String autor;
    private String editora;
    private int anoLancamento;

    @Temporal(TemporalType.DATE)
    private Date dataEmprestimo;

    @Temporal(TemporalType.DATE)
    private Date dataDevolucao;

    @ManyToOne
    private Pessoa pessoaAlugando;

    @Enumerated(EnumType.STRING)
    @Column(name = "status") // Mapear para a coluna 'status' no banco de dados
    private Status status;


    public Livro() {
    }

    public Livro( String nome, String autor, String editora, int anoLancamento) {
        this.nome = nome;
        this.autor = autor;
        this.editora = editora;
        this.anoLancamento = anoLancamento;
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

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public String getEditora() {
        return editora;
    }

    public void setEditora(String editora) {
        this.editora = editora;
    }

    public String getDataEmprestimoFormatted() {
        if (dataEmprestimo == null) {
            return null;
        }
        SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
        return formatter.format(dataEmprestimo);
    }

    // Método para formatar a data de devolução
    public String getDataDevolucaoFormatted() {
        if (dataDevolucao == null) {
            return null;
        }
        SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
        return formatter.format(dataDevolucao);
    }

    public Pessoa getPessoaAlugando() {
        return pessoaAlugando;
    }

    // Setters
    public void setDataEmprestimo(Date dataEmprestimo) {
        this.dataEmprestimo = dataEmprestimo;
    }

    public void setDataDevolucao(Date dataDevolucao) {
        this.dataDevolucao = dataDevolucao;
    }

    public void setPessoaAlugando(Pessoa pessoaAlugando) {
        this.pessoaAlugando = pessoaAlugando;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }


    public int getAnoLancamento() {
        return anoLancamento;
    }

    public void setAnoLancamento(int anoLancamento) {
        this.anoLancamento = anoLancamento;
    }
}
