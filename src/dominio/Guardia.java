package dominio;

public class Guardia extends Carta{
	
	private static final String nombre = "Guardia";
	private static final String efecto = "nombrarCarta";
	private static final int fuerza = 1;
	
	public Guardia() {
		super(nombre, fuerza, efecto);
	}
	
	
}
