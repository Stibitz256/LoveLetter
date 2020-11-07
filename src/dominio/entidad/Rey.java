package dominio.entidad;

import java.util.Iterator;

import dominio.excepcion.CartaNoEncontrada;
import dominio.excepcion.CondesaEnMano;
import dominio.excepcion.JugadorProtegido;

public class Rey extends Carta {

	private static final String nombre = "Rey";
	private static final int fuerza = 6;

	public Rey() {
		super(nombre, fuerza);
	}

	@Override
	public Carta descartar(Jugador jugador, Jugador jugadorTurno)
			throws JugadorProtegido, CondesaEnMano, CartaNoEncontrada {
		Iterator<Carta> cartas = jugadorTurno.obtenerCartasDeLaMano().iterator();
		while (cartas.hasNext()) {
			Carta carta = cartas.next();
			if (carta.getClass() == Condesa.class) {
				Rey cartaDescartada = (Rey) jugadorTurno.eliminarUltimaCartaDescartada();
				jugadorTurno.tomarCarta(cartaDescartada);
				throw new CondesaEnMano();
			}
		}
		if (jugador.estaProtegido()) {
			throw new JugadorProtegido();
		}

		Carta cartaTurno = jugadorTurno.darCarta();
		Carta cartaJugador = jugador.darCarta();
		jugador.tomarCarta(cartaTurno);
		jugadorTurno.tomarCarta(cartaJugador);

		return cartaJugador;
	}
}
