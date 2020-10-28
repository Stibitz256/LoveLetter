package dominio.entidad;

import java.util.Iterator;
import java.util.TreeSet;

import dominio.excepcion.CartaNoEncontrada;

public class Ronda {
	private Mazo mazo;
	private Carta cartaApartada;
	private Jugador turno;
	Iterator<Jugador> jugadores;

	public Ronda(TreeSet<Jugador> jugadores) {
		this.jugadores = jugadores.iterator();
		turno = jugadores.first();
		this.mazo = new Mazo();
	}

	public Jugador ganadorRonda() {
		this.turno.incrementarSimbolosDeAfecto();

		return this.turno;
	}

	// se termina la ronda bruscamente y devuelve al ganador
	public Jugador finalizarRonda() {
		return ganadorRonda();
	}

	public void repartirMazo() throws CartaNoEncontrada {
		Iterator<Jugador> jugadores = this.jugadores;
		this.cartaApartada = this.mazo.obtenerCarta();
		while (jugadores.hasNext()) {
			Jugador jugador = jugadores.next();
			jugador.tomarCarta(this.mazo.obtenerCarta());
		}
	}

	public Jugador siguienteJugadorEnLaRonda() {
		Iterator<Jugador> principio = this.jugadores;
		Iterator<Jugador> jugadores = this.jugadores;
		boolean iterador = true;

		Jugador actual = jugadores.next();
		while (actual != this.turno) {
			actual = jugadores.next();
		}

		while (iterador) {
			if (!jugadores.hasNext()) {
				jugadores = principio;
			}
			Jugador jugador = jugadores.next();
			if (!jugador.estaEliminado()) {
				actual = jugador;
				iterador = false;
			}
		}

		return actual;
	}

	public Jugador compararFuerzasYDescartes() {
		Iterator<Jugador> jugadores = this.jugadores;
		Jugador ganador = jugadores.next();

		while (jugadores.hasNext() && ganador.estaEliminado()) {
			ganador = jugadores.next();
		}
		while (jugadores.hasNext()) {
			Jugador jugador = jugadores.next();
			if (!jugador.estaEliminado()) {

				int comp = jugador.obtenerFuerza() - ganador.obtenerFuerza();
				if (comp > 0) {
					ganador = jugador;
				} else {
					if (comp == 0) {
						if (jugador.obtenerCantCartasDescartadas() > ganador.obtenerCantCartasDescartadas())
							ganador = jugador;
					}
				}
			}
		}

		return ganador;
	}
}
