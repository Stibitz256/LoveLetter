package dominio.excepcion;

public class JugadorProtegido extends Exception{
	
	public JugadorProtegido() {
		super("Jugador protegido");
	}
	
}
