package exceptions;

public class NumberOutOfRangeException extends Exception {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public NumberOutOfRangeException() {
		super();
	}

	public NumberOutOfRangeException(String message) {
		super(message);
	}

	public NumberOutOfRangeException(String message, Throwable cause) {
		super(message, cause);
	}

	public NumberOutOfRangeException(Throwable cause) {
		super(cause);
	}
}
