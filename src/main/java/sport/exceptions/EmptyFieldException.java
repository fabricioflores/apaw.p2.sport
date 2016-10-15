package sport.exceptions;

public class EmptyFieldException extends Exception {
	private static final long serialVersionUID = -633045799876625537L;
	public static final String DESCRIPTION = "Campo vacío";

	public EmptyFieldException(String detail) {
		super(DESCRIPTION + detail + ". ");
	}

	public EmptyFieldException() {
		this("");
	}

}
