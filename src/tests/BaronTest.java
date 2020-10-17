package tests;

import static org.junit.Assert.*;

import org.junit.Test;

import dominio.entidad.Baron;
import dominio.entidad.Carta;
import dominio.entidad.Jugador;
import dominio.entidad.Mesa;
import dominio.entidad.Mucama;
import dominio.entidad.Principe;
import dominio.entidad.Sacerdote;
import dominio.excepcion.CartaNoEncontrada;
import dominio.excepcion.JugadorProtegido;

public class BaronTest {

	@Test
	public void mostrarseCartasFuerzaSuperiorTurno() throws JugadorProtegido, CartaNoEncontrada {
		Mesa mesa = new Mesa();
		Jugador jugador1 = new Jugador("Wilson");
		Jugador jugador2 = new Jugador("Marta");

		mesa.agregarJugador(jugador1);
		mesa.agregarJugador(jugador2);

		Principe principe = new Principe();
		Mucama mucama = new Mucama();

		jugador1.tomarCarta(principe);
		jugador2.tomarCarta(mucama);

		Carta carta = mesa.mostrarseCartas(jugador2);
		assertEquals(mucama, carta);
		assertTrue(jugador2.estaEliminado());
	}
	
	@Test
	public void mostrarseCartasFuerzaMenorTurno() throws JugadorProtegido, CartaNoEncontrada {
		Mesa mesa = new Mesa();
		Jugador jugador1 = new Jugador("Wilson");
		Jugador jugador2 = new Jugador("Marta");

		mesa.agregarJugador(jugador1);
		mesa.agregarJugador(jugador2);

		Principe principe = new Principe();
		Mucama mucama = new Mucama();

		jugador1.tomarCarta(mucama);
		jugador2.tomarCarta(principe);

		Carta carta = mesa.mostrarseCartas(jugador2);
		assertEquals(principe, carta);
		assertTrue(jugador1.estaEliminado());
	}
	
	@Test
	public void mostrarseCartasFuerzaIgualadaTurno() throws JugadorProtegido, CartaNoEncontrada {
		Mesa mesa = new Mesa();
		Jugador jugador1 = new Jugador("Wilson");
		Jugador jugador2 = new Jugador("Marta");

		mesa.agregarJugador(jugador1);
		mesa.agregarJugador(jugador2);

		Principe principe = new Principe();
		Principe principe2 = new Principe();

		jugador1.tomarCarta(principe);
		jugador2.tomarCarta(principe2);

		Carta carta = mesa.mostrarseCartas(jugador2);
		assertEquals(principe2, carta);
		assertFalse(jugador1.estaEliminado());
		assertFalse(jugador2.estaEliminado());
	}
	
	@Test(expected=JugadorProtegido.class)
	public void mostrarseCartasJugadorProtegido() throws JugadorProtegido, CartaNoEncontrada {
		Mesa mesa = new Mesa();
		Jugador jugador1 = new Jugador("Wilson");
		Jugador jugador2 = new Jugador("Marta");
		jugador2.proteger();

		mesa.agregarJugador(jugador1);
		mesa.agregarJugador(jugador2);

		Principe principe = new Principe();
		Mucama mucama = new Mucama();

		jugador1.tomarCarta(mucama);
		jugador2.tomarCarta(principe);

		mesa.mostrarseCartas(jugador2);
	}
}
