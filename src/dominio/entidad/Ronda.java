package dominio.entidad;

import java.util.Iterator;
import java.util.TreeSet;

public class Ronda {
	private Mazo mazo = new Mazo();
	private Carta cartaApartada;
	private Jugador turno;
	Iterator<Jugador> jugadores;

	public Ronda(TreeSet<Jugador> jugadores) {
		this.jugadores = jugadores.iterator();
		turno = jugadores.first();
	}

	public Jugador ganadorRonda() {
		this.turno.incrementarSimbolosDeAfecto();
		// System.out.println(jugador.toString());
		return this.turno;

	}

	public Jugador finalizarRonda() { // se termina la ronda bruscamente y devuelve al ganador
		return ganadorRonda();
	}

	public void repartirMazo() throws Exception {
		Iterator<Jugador> jugadores = this.jugadores;
		cartaApartada = this.mazo.obtenerCarta();
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
