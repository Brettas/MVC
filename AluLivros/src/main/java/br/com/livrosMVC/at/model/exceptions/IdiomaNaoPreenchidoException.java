package br.com.livrosMVC.at.model.exceptions;

public class IdiomaNaoPreenchidoException extends Exception {
    private static final long serialVersionUID = 1L;

	public IdiomaNaoPreenchidoException(String message) {
        super(message);
    }
}