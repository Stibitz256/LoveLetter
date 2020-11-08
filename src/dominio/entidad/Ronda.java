package dominio.entidad;

import java.util.Iterator;
import java.util.TreeSet;

import dominio.excepcion.CartaNoEncontrada;

public class Ronda {
	private Mazo mazo;
	private Carta cartaApartada;
	private Jugador turno;
	TreeSet<Jugador> jugadores;

	public Ronda(TreeSet<Jugador> jugadores) {
		this.jugadores = jugadores;
		turno = jugadores.first();
		this.mazo = new Mazo();
	}

	public Jugador ganadorRonda() {
		this.turno.incrementarSimbolosDeAfecto();

		return this.turno;
	}

	public Jugador finalizarRonda() {
		return this.ganadorRonda();
	}

	public void repartirMazo() throws CartaNoEncontrada {
		Iterator<Jugador> jugadores = this.jugadores.iterator();
		this.cartaApartada = this.mazo.obtenerCarta();
		while (jugadores.hasNext()) {
			Jugador jugador = jugadores.next();
			jugador.tomarCarta(this.mazo.obtenerCarta());
		}
	}

	public Jugador siguienteJugadorEnLaRonda() {
		Iterator<Jugador> jugadores = this.jugadores.iterator();
		Jugador actual = jugadores.next();
		Jugador ultimoJugador = this.jugadores.last();
		boolean seguir = true;

		while (jugadores.hasNext() && actual != turno) {
			actual = jugadores.next();
		}

		if (jugadores.hasNext()) {
			actual = jugadores.next();
		} else {
			jugadores = this.jugadores.iterator();
			actual = jugadores.next();
		}

		while (seguir && jugadores.hasNext()) {
			if(actual.estaEliminado() || actual.estaRendido())
				actual = jugadores.next();
			else {
				seguir = false;
			}
		}
		actual.desproteger();
		this.turno = actual;
		return actual;
	}

	public Jugador compararFuerzasYDescartes() {
		Iterator<Jugador> jugadores = this.jugadores.iterator();
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
