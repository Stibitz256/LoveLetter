package dominio;

public class Baron extends Carta {
	
	private static final String nombre = "Baron";
	private static final String efecto = "mostrarseCartas";
	private static final int fuerza = 3;
	
	public Baron() {
		super(nombre, fuerza, efecto);
	}
}
