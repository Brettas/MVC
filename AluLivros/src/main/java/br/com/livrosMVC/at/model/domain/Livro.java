package br.com.livrosMVC.at.model.domain;

import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;

import br.com.livrosMVC.at.model.exceptions.DisciplinaNaoPreenchidaException;
import br.com.livrosMVC.at.model.exceptions.IdiomaNaoPreenchidoException;
import br.com.livrosMVC.at.model.exceptions.RamoNaoPreenchidoException;

import javax.persistence.*;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
@JsonTypeInfo(
        use = JsonTypeInfo.Id.NAME,
        include = JsonTypeInfo.As.PROPERTY,
        property = "tipo")
@JsonSubTypes({
        @JsonSubTypes.Type(value = Literatura.class, name = "literatura"),
        @JsonSubTypes.Type(value = Didatico.class, name = "didatico"),
        @JsonSubTypes.Type(value = Cientifico.class, name = "cientifico"),
})
public abstract class Livro {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String titulo;
    private String autor;
    private float valorAluguel;
    private boolean usado;
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

    public Livro(String tipo) {
        setTipo(tipo);
    }

    public Livro() {

    }

    public float getValorAluguel() {
        return valorAluguel;
    }

    public String obterLivro() throws DisciplinaNaoPreenchidaException, IdiomaNaoPreenchidoException, RamoNaoPreenchidoException {
        StringBuilder stringBuilder = new StringBuilder();

        stringBuilder.append(this.titulo);
        stringBuilder.append(";");
        stringBuilder.append(this.autor);
        stringBuilder.append(";");
        stringBuilder.append(this.calcularValorBruto());
        stringBuilder.append("\r\n");

        return stringBuilder.toString();
    }

    public abstract float calcularValorBruto() throws DisciplinaNaoPreenchidaException, IdiomaNaoPreenchidoException, RamoNaoPreenchidoException;

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
