package br.com.livrosMVC.at.model.domain;

import javax.persistence.*;

import br.com.livrosMVC.at.model.exceptions.SolicitanteNaoInformadoException;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

@Entity
public class Reserva {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private LocalDate dataInicio;
    private LocalDate dataFinal;
    @OneToOne(cascade = CascadeType.DETACH)
    @JoinColumn(name = "idSolicitante")
    private Solicitante solicitante;
    @ManyToMany(cascade = CascadeType.DETACH)
    private List<Livro> livros;
    private String observacao;
    @ManyToOne
    @JoinColumn(name = "idUsuario")
    private Usuario usuario;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Reserva() {
        this.dataInicio = LocalDate.now();
        this.dataFinal = LocalDate.now().plusDays(7);
    }

    public Reserva(String observacao) {
        this();
        this.observacao = observacao;
    }

    public String obterReserva() {
        DateTimeFormatter formato = DateTimeFormatter.ofPattern("dd/MM/yyyy");

        return String.format("Reserva realizada de %s a %s",
                this.dataInicio.format(formato),
                this.dataFinal.format(formato));

    }

    @Override
    public String toString() {
        DateTimeFormatter formato = DateTimeFormatter.ofPattern("dd/MM/yyyy");

        return String.format("%s;%s;%s;%s",
                this.observacao,
                this.dataInicio.format(formato),
                this.dataFinal.format(formato),
                this.solicitante
        );
    }

    public void setSolicitante(Solicitante solicitante) throws SolicitanteNaoInformadoException {
        if (solicitante == null) {
            throw new SolicitanteNaoInformadoException("É necessário informar o solicitante!");
        }
        this.solicitante = solicitante;
    }

    public void setObservacao(String observacao) {
        this.observacao = observacao;
    }

    public LocalDate getDataInicio() {
        return dataInicio;
    }

    public void setDataInicio(LocalDate dataInicio) {
        this.dataInicio = dataInicio;
    }

    public LocalDate getDataFinal() {
        return dataFinal;
    }

    public void setDataFinal(LocalDate dataFinal) {
        this.dataFinal = dataFinal;
    }

    public Solicitante getSolicitante() {
        return solicitante;
    }

    public List<Livro> getLivros() {
        return livros;
    }

    public void setLivros(List<Livro> livros) {
        this.livros = livros;
    }

    public String getObservacao() {
        return observacao;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }
}