package es.upm.miw.apiArchitectureTheme.exceptions;

public class EntityNotFoundException extends Exception {
	private static final long serialVersionUID = -642045799876625537L;
	public static final String DESCRIPTION = "Entidad no encontrada: ";

	public EntityNotFoundException(String detail) {
		super(DESCRIPTION + detail + ". ");
	}

	public EntityNotFoundException() {
		this("");
	}

}
