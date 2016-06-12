package exceptions;

public class NotRomanNumeralException extends Exception {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public NotRomanNumeralException() {
		super();
	}

	public NotRomanNumeralException(String message) {
		super(message);
	}

	public NotRomanNumeralException(String message, Throwable cause) {
		super(message, cause);
	}

	public NotRomanNumeralException(Throwable cause) {
		super(cause);
	}
}
