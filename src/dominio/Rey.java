package dominio;

public class Rey extends Carta {
	
	private static final String nombre = "Rey";
	private static final String efecto = "intercambiarCartas";
	private static final int fuerza = 6;
	
	public Rey() {
		super(nombre, fuerza, efecto);

	}
	
}
