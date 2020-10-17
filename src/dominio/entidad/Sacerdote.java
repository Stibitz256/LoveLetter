package dominio.entidad;

import dominio.excepcion.JugadorProtegido;

public class Sacerdote extends Carta {
	
	private static final String nombre = "Sacerdote";
	private static final int fuerza = 2;
	
	public	Sacerdote(){
		super(nombre, fuerza);
	}

	@Override
	public Carta descartar(Jugador jugador) throws JugadorProtegido {
		if (jugador.estaProtegido()) {
			throw new JugadorProtegido();
		}

		return jugador.obtenerCartasDeLaMano().iterator().next();
	}
}
