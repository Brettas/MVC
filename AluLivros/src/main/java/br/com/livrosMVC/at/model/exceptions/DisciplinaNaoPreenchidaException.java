package br.com.livrosMVC.at.model.exceptions;

public class DisciplinaNaoPreenchidaException extends Exception {
    private static final long serialVersionUID = 1L;

	public DisciplinaNaoPreenchidaException(String message) {
        super(message);
    }
}
