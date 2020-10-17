package dominio;

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
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public int getFuerza() {
		return fuerza;
	}
	public void setFuerza(int fuerza) {
		this.fuerza = fuerza;
	}
	public String getEfecto() {
		return efecto;
	}
	public void setEfecto(String efecto) {
		this.efecto = efecto;
	}
	
	
}
