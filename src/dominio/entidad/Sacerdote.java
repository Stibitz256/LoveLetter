package dominio.entidad;

public class Sacerdote extends Carta {
	
	private static final String nombre = "Sacerdote";
	private static final String efecto = "verCartas";
	private static final int fuerza = 2;
	
	public	Sacerdote(){
		super(nombre, fuerza, efecto);
	}
}
