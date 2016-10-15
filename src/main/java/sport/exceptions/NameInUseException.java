package sport.exceptions;

public class NameInUseException extends Exception {
	private static final long serialVersionUID = -3893110892899234744L;

	public static final String DESCRIPTION = "El valor debe ser único: ";

	public NameInUseException(String detail) {
		super(DESCRIPTION + detail + ". ");
	}

	public NameInUseException() {
		this("");
	}
}
