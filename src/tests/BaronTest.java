package tests;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import java.util.TreeSet;

import org.junit.Test;

import dominio.entidad.Baron;
import dominio.entidad.Carta;
import dominio.entidad.Jugador;
import dominio.entidad.Mucama;
import dominio.entidad.Partida;
import dominio.entidad.Principe;
import dominio.excepcion.CartaNoEncontrada;
import dominio.excepcion.JugadorProtegido;

public class BaronTest {

	@Test
	public void mostrarseCartasFuerzaSuperiorTurno() throws JugadorProtegido, CartaNoEncontrada {
		Jugador jugador1 = new Jugador("Wilson");
		Jugador jugador2 = new Jugador("Marta");

		Baron baron = new Baron();
		Principe principe = new Principe();
		Mucama mucama = new Mucama();

		jugador1.tomarCarta(principe);
		jugador2.tomarCarta(mucama);

		Carta carta = baron.descartar(jugador2, jugador1);
		assertEquals(principe, carta);
		assertTrue(jugador2.estaEliminado());
	}
	
	@Test
	public void mostrarseCartasFuerzaMenorTurno() throws JugadorProtegido, CartaNoEncontrada {
		Jugador jugador1 = new Jugador("Wilson");
		Jugador jugador2 = new Jugador("Marta");

		Baron baron = new Baron();
		Principe principe = new Principe();
		Mucama mucama = new Mucama();

		jugador1.tomarCarta(mucama);
		jugador2.tomarCarta(principe);
		
		Carta carta = baron.descartar(jugador2, jugador1);
		assertEquals(principe, carta);
		assertTrue(jugador1.estaEliminado());
	}
	
	@Test
	public void mostrarseCartasFuerzaIgualadaTurno() throws JugadorProtegido, CartaNoEncontrada {
		Jugador jugador1 = new Jugador("Wilson");
		Jugador jugador2 = new Jugador("Marta");

		Principe principe = new Principe();
		Principe principe2 = new Principe();

		Baron baron = new Baron();
		jugador1.tomarCarta(principe);
		jugador2.tomarCarta(principe2);

		Carta carta = baron.descartar(jugador2, jugador1);
		assertNull(carta);
		
		assertFalse(jugador1.estaEliminado());
		assertFalse(jugador2.estaEliminado());
	}
	
	@Test(expected=JugadorProtegido.class)
	public void mostrarseCartasJugadorProtegido() throws JugadorProtegido, CartaNoEncontrada {
		Jugador jugador1 = new Jugador("Wilson");
		Jugador jugador2 = new Jugador("Marta");
		jugador2.proteger();
		Principe principe = new Principe();
		Mucama mucama = new Mucama();
		Baron baron = new Baron();

		jugador1.tomarCarta(mucama);
		jugador2.tomarCarta(principe);
		
		baron.descartar(jugador2, jugador1);
	}
}
