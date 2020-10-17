package dominio.entidad;

import java.util.Comparator;
import java.util.Iterator;
import java.util.TreeSet;

import dominio.excepcion.CartaNoEncontrada;

public class Mesa {
	Mazo mazo;
	TreeSet<Jugador> jugadores;
	Jugador turno;
	Carta cartaApartada;
	int cantSimbolosDeAfectoNecesario;

	public Mesa() throws CartaNoEncontrada {
		this.mazo = new Mazo();
		this.cartaApartada = mazo.obtenerCarta();
		this.jugadores = new TreeSet<Jugador>(new Comparator() {

			@Override
			public int compare(Object o1, Object o2) {
				// TODO Auto-generated method stub
				return 1;
			}
		});
	}

	public void repartir() throws Exception {
		Iterator<Jugador> jugadores = this.jugadores.iterator();
		while (jugadores.hasNext()) {
			Jugador jugador = jugadores.next();
			jugador.tomarCarta(this.mazo.obtenerCarta());
		}
	}

	public void agregarJugador(Jugador jugador) {
		if (this.jugadores.isEmpty()) {
			this.turno = jugador;
		}
		this.jugadores.add(jugador);
	}

	public Carta darCarta(Jugador jugador) {
		return null;
	}
	
	public Jugador obtenerJugadorTurno() {
		return this.turno;
	}
}
