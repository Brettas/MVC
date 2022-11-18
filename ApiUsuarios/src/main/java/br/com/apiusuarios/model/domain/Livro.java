package br.com.apiusuarios.model.domain;
import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
public class Livro {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String titulo;
    private String autor;
    private float valorAluguel;
    private boolean usado;
    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "idUsuario")
    private Usuario usuario;
    private String tipo;

    public Livro(String titulo, String autor, float valorAluguel, boolean usado) {
        this.titulo = titulo;
        this.autor = autor;
        this.valorAluguel = valorAluguel;
        this.usado = usado;
    }

    public Livro() {

    }

    public float getValorAluguel() {
        return valorAluguel;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public void setValorAluguel(float valorAluguel) {
        this.valorAluguel = valorAluguel;
    }

    public boolean isUsado() {
        return usado;
    }

    public void setUsado(boolean usado) {
        this.usado = usado;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }
}
