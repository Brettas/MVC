package br.com.livrosMVC.at.model.exceptions;

public class RamoNaoPreenchidoException extends Exception {
    private static final long serialVersionUID = 1L;

	public RamoNaoPreenchidoException(String message) {
        super(message);
    }
}
