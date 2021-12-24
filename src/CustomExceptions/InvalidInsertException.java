package CustomExceptions;

public class InvalidInsertException extends RuntimeException {
	
	public InvalidInsertException(String msg) {
		super(msg);
	}
}
