package exception;

public class SystemException extends Exception {

	public SystemException() {

	}

	public SystemException(String arg0) {
		super(arg0);
	}

	public SystemException(String arg0, String arg1) {
		super(arg0 + (arg1 == null?"":" (" + arg1 + ")"));
	}

}
