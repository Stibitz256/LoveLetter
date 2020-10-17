package dominio.entidad;

public class Principe extends Carta {
	
	private static final String nombre = "Principe";
	private static final String efecto = "descartarTomarCarta";
	private static final int fuerza = 5;
	
	public Principe() {
		super(nombre, fuerza, efecto);
	}
}
