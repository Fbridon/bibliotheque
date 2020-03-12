package biblio.exception;

public class BiblioException extends Exception {
	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	
	public BiblioException() {
		// TODO Auto-generated constructor stub
		super("probleme tehcnique survenu");
	}
	
	public BiblioException(String message) {
		super(message);
	}
	
}
