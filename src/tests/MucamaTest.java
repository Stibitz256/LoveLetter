package tests;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import java.util.TreeSet;

import org.junit.Test;

import dominio.entidad.Guardia;
import dominio.entidad.Jugador;
import dominio.entidad.Mucama;
import dominio.entidad.Ronda;
import dominio.excepcion.CartaNoEncontrada;
import dominio.excepcion.CartaNoValida;

public class MucamaTest {

	@Test
	public void test() throws CartaNoValida, CartaNoEncontrada {
		TreeSet<Jugador> jugadores = new TreeSet<Jugador>();
		Jugador jugador1 = new Jugador("Carlos");
		Jugador jugador2 = new Jugador("Jhon");

		Mucama mucama = new Mucama();
		jugador1.tomarCarta(mucama);

		Guardia guardia = new Guardia();
		jugador2.tomarCarta(guardia);

		jugadores.add(jugador1);
		jugadores.add(jugador2);

		Ronda ronda = new Ronda(jugadores);

		jugador1.descartar(mucama);
		mucama.descartar(jugador1);

		assertTrue(jugador1.estaProtegido());
		ronda.siguienteJugadorEnLaRonda();
		ronda.siguienteJugadorEnLaRonda();
		assertFalse(jugador1.estaProtegido());
	}

	@Test
	public void test2() throws CartaNoValida, CartaNoEncontrada {
		TreeSet<Jugador> jugadores = new TreeSet<Jugador>();
		Jugador jugador1 = new Jugador("Carlos");
		Jugador jugador2 = new Jugador("Jhon");

		Mucama mucama = new Mucama();
		jugador1.tomarCarta(mucama);

		Guardia guardia = new Guardia();
		jugador2.tomarCarta(guardia);

		jugadores.add(jugador1);
		jugadores.add(jugador2);

		Ronda ronda = new Ronda(jugadores);

		jugador1.descartar(mucama);
		mucama.descartar(jugador1);

		assertTrue(jugador1.estaProtegido());
		ronda.siguienteJugadorEnLaRonda();
		assertTrue(jugador1.estaProtegido());
	}

}
