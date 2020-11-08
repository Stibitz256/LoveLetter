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
		boolean seguir = true;

		while (jugadores.hasNext() && actual != turno) {
			actual = jugadores.next();
		}

		if (!jugadores.hasNext()) {
			jugadores = this.jugadores.iterator();
		}

		while (seguir && jugadores.hasNext()) {
			actual = jugadores.next();
			if(!actual.estaEliminado() && !actual.estaRendido()) {
				seguir = false;
			}
			if(!jugadores.hasNext()) {
				jugadores = this.jugadores.iterator();
			}
		}
		
		actual.desproteger();
		this.turno = actual;
		
		return actual;
	}

	public Jugador compararFuerzasYDescartes() {
		Iterator<Jugador> jugadores = this.jugadores.iterator();
		Jugador ganador = jugadores.next();
		boolean seguir = true;
		
		while (jugadores.hasNext() && (ganador.estaEliminado() || ganador.estaRendido())) {
			ganador = jugadores.next();
		}
		
		while (seguir && jugadores.hasNext()) {
			Jugador otroJugador = jugadores.next();
			if(!otroJugador.estaEliminado() && !otroJugador.estaRendido()) {
				seguir = false;

				int comp = otroJugador.obtenerFuerza() - ganador.obtenerFuerza();
				if (comp > 0) {
					ganador = otroJugador;
				} else if(comp == 0 && otroJugador.obtenerCantCartasDescartadas() > ganador.obtenerCantCartasDescartadas()) { 
					ganador = otroJugador;
				}
			}
		}

		return ganador;
	}
}
