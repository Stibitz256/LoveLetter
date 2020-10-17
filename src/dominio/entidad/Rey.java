package dominio.entidad;

import dominio.excepcion.JugadorProtegido;

public class Rey extends Carta {

	private static final String nombre = "Rey";
	private static final int fuerza = 6;

	public Rey() {
		super(nombre, fuerza);
	}

	@Override
	public Carta descartar(Jugador jugador, Jugador jugadorTurno) throws JugadorProtegido {
		if (jugador.estaProtegido()) {
			throw new JugadorProtegido();
		}

		Carta cartaTurno = jugadorTurno.darCarta();
		Carta cartaJugador = jugador.darCarta();
		jugador.tomarCarta(cartaTurno);
		jugadorTurno.tomarCarta(cartaJugador);
		
		return (Carta) new Object();
	}
}
