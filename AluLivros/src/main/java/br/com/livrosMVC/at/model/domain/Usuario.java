package br.com.livrosMVC.at.model.domain;

import javax.persistence.*;
import java.util.List;

@Entity
public class Usuario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String nome;
    private String email;
    private String senha;
    private boolean admin;
    @OneToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "idEndereco")
    private Endereco endereco;
    @OneToMany
    @JoinColumn(name = "idUsuario")
    private List<Solicitante> solicitantes;
    @OneToMany(cascade = CascadeType.REMOVE, orphanRemoval = true)
    @JoinColumn(name = "idUsuario")
    private List<Livro> livros;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
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

    public boolean isAdmin() {
        return admin;
    }

    public void setAdmin(boolean admin) {
        this.admin = admin;
    }

    public List<Solicitante> getSolicitantes() {
        return solicitantes;
    }

    public void setSolicitantes(List<Solicitante> solicitantes) {
        this.solicitantes = solicitantes;
    }

    public Endereco getEndereco() {
        return endereco;
    }

    public void setEndereco(Endereco endereco) {
        this.endereco = endereco;
    }

    public List<Livro> getLivros() {
        return livros;
    }

    public void setLivros(List<Livro> livros) {
        this.livros = livros;
    }
}
