package dominio.excepcion;

public class CartaNoValida extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 8747126846992080422L;

	public CartaNoValida() {
		super("Carta no valida");
	}

}
