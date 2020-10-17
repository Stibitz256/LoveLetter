package dominio.excepcion;

public class JugadorProtegido extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 7232820825630153043L;

	public JugadorProtegido() {
		super("Jugador protegido");
	}

}
