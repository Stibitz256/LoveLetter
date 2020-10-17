package dominio.excepcion;

public class CartaNoEncontrada extends Exception{
	
	public CartaNoEncontrada() {
		super("No hay siguiente carta");
	}
	
}
