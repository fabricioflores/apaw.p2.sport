package es.upm.miw.apiArchitectureTheme.exceptions;

public class NotFoundThemeIdException extends Exception {
	private static final long serialVersionUID = -3893110892899234744L;
	
	public static final String DESCRIPTION = "El id del thema no existe";

	public NotFoundThemeIdException(String detail) {
		super(DESCRIPTION + ". " + detail);
	}

	public NotFoundThemeIdException() {
		this("");
	}
}
