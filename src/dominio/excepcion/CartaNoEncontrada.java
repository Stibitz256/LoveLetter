package dominio.excepcion;

public class CartaNoEncontrada extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = -7272810952716990479L;

	public CartaNoEncontrada() {
		super("No hay siguiente carta");
	}

}
