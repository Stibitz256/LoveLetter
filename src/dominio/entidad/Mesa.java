package dominio.entidad;

import java.util.Comparator;
import java.util.Iterator;
import java.util.TreeSet;

import dominio.excepcion.CartaNoEncontrada;
import dominio.excepcion.CartaNoValida;
import dominio.excepcion.JugadorProtegido;

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

	public void intercambiarCartas(Jugador jugador) throws JugadorProtegido {
		if (jugador.estaProtegido()) {
			throw new JugadorProtegido();
		}
		
		Carta cartaTurno = this.turno.darCarta();
		Carta cartaJugador = jugador.darCarta();
		jugador.tomarCarta(cartaTurno);
		this.turno.tomarCarta(cartaJugador);
	}

	public Carta darCarta(Jugador jugador) {
		return null;
	}

	public boolean nombrarCarta(Jugador jugador, Carta carta) throws CartaNoValida, JugadorProtegido {
		if (jugador.estaProtegido()) {
			throw new JugadorProtegido();
		}
		if (carta.getClass() == Guardia.class) {
			throw new CartaNoValida();
		}
		Iterator<Carta> cartas = jugador.obtenerCartasDeLaMano().iterator();
		while (cartas.hasNext()) {
			Carta cartaJugador = cartas.next();
			if (cartaJugador.getClass() == carta.getClass()) {
				return true;
			}
		}

		return false;
	}

	public Carta verCartas(Jugador jugador) throws JugadorProtegido {
		if (jugador.estaProtegido()) {
			throw new JugadorProtegido();
		}

		return jugador.obtenerCartasDeLaMano().iterator().next();
	}

	public Carta mostrarseCartas(Jugador jugador) throws JugadorProtegido {
		if (jugador.estaProtegido()) {
			throw new JugadorProtegido();
		}
		
		Carta carta = jugador.obtenerCartasDeLaMano().iterator().next();
		Carta cartaTurno = this.turno.obtenerCartasDeLaMano().iterator().next();
		
		if(cartaTurno.getFuerza() > carta.getFuerza()) {
			jugador.eliminar();
		} else if(cartaTurno.getFuerza() < carta.getFuerza()) {
			this.turno.eliminar();
		}
		
		return carta;
	}

	public void descartarTomarCarta(Jugador jugador) throws JugadorProtegido, CartaNoEncontrada {
		if (jugador.estaProtegido()) {
			throw new JugadorProtegido();
		}
		
		Carta cartaDescartada = jugador.descartar();
		if (cartaDescartada.getClass() == Princesa.class) {
			jugador.eliminar();
			
			return;
		}
		
		try {
			jugador.tomarCarta(this.mazo.obtenerCarta());
		} catch(CartaNoEncontrada exception) {
			jugador.tomarCarta(this.cartaApartada);
			this.cartaApartada = null;
		}
	}

	public Carta jugarInmediatamente() {
		// Carta carta = this.turno.obtenerCartasDeLaMano();

		return null;
	}
	
	public void proteger(Jugador jugador) {
		jugador.proteger();
	}
	
	public Jugador obtenerJugadorTurno() {
		return this.turno;
	}
}
