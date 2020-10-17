package dominio.entidad;

abstract public class Carta {
	private String nombre;
	private int fuerza;
	private String efecto;
	
	public Carta(String nombre, int fuerza, String efecto) {
		super();
		this.nombre = nombre;
		this.fuerza = fuerza;
		this.efecto = efecto;
	}
	
	public String getNombre() {
		return nombre;
	}
	
	public int getFuerza() {
		return fuerza;
	}
	
	public String getEfecto() {
		return efecto;
	}	
}
