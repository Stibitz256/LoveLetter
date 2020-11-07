package dominio.entidad;

import dominio.excepcion.JugadorProtegido;

public class Baron extends Carta {

	private static final String nombre = "Baron";
	private static final int fuerza = 3;

	public Baron() {
		super(nombre, fuerza);
	}

	@Override
	public Carta descartar(Jugador jugador, Jugador jugadorTurno) throws JugadorProtegido {
		if (jugadorTurno.estaProtegido()) {
			throw new JugadorProtegido();
		}

		Carta carta = jugador.obtenerCartasDeLaMano().iterator().next();
		Carta cartaTurnoJugador = jugadorTurno.obtenerCartasDeLaMano().iterator().next();

		if (cartaTurnoJugador.getFuerza() > carta.getFuerza()) {
			jugador.eliminar();

			return cartaTurnoJugador;
		}
		
		if (cartaTurnoJugador.getFuerza() < carta.getFuerza()) {
			jugadorTurno.eliminar();
			
			return carta;
		}

		return null;
	}
}
