package tests;

import static org.junit.Assert.*;

import org.junit.Test;

import dominio.entidad.Guardia;
import dominio.entidad.Jugador;
import dominio.entidad.Mesa;
import dominio.entidad.Mucama;
import dominio.entidad.Principe;
import dominio.excepcion.CartaNoEncontrada;
import dominio.excepcion.CartaNoValida;
import dominio.excepcion.JugadorProtegido;

public class GuardiaTest {

	@Test
	public void guardiaAdivinaCorrecto() throws CartaNoValida, JugadorProtegido, CartaNoEncontrada {
		Mesa mesa = new Mesa();
		Jugador jugador1 = new Jugador("Wilson");
		Jugador jugador2 = new Jugador("Marta");

		mesa.agregarJugador(jugador1);
		mesa.agregarJugador(jugador2);

		Guardia guardia = new Guardia();
		Mucama mucama = new Mucama();

		jugador1.tomarCarta(guardia);
		jugador2.tomarCarta(mucama);

		assertTrue(mesa.nombrarCarta(jugador2, mucama));
	}

	@Test
	public void guardiaNoAdivina() throws CartaNoValida, JugadorProtegido, CartaNoEncontrada {
		Mesa mesa = new Mesa();
		Jugador jugador1 = new Jugador("Wilson");
		Jugador jugador2 = new Jugador("Marta");

		mesa.agregarJugador(jugador1);
		mesa.agregarJugador(jugador2);

		Guardia guardia = new Guardia();
		Mucama mucama = new Mucama();
		Principe principe = new Principe();

		jugador1.tomarCarta(guardia);
		jugador2.tomarCarta(mucama);

		assertFalse(mesa.nombrarCarta(jugador2, principe));
	}

	@Test(expected=CartaNoValida.class)
	public void guardiaNoPermiteAdivinarGuardia() throws CartaNoValida, JugadorProtegido, CartaNoEncontrada {
		Mesa mesa = new Mesa();
		Jugador jugador1 = new Jugador("Wilson");
		Jugador jugador2 = new Jugador("Marta");

		mesa.agregarJugador(jugador1);
		mesa.agregarJugador(jugador2);

		Guardia guardia1 = new Guardia();
		Guardia guardia2 = new Guardia();

		jugador1.tomarCarta(guardia1);
		jugador2.tomarCarta(guardia2);

		mesa.nombrarCarta(jugador2, guardia2);
	}
	
	@Test(expected=JugadorProtegido.class)
	public void guardiaNoPermiteAdivinarEnJugadorProtegido() throws CartaNoValida, JugadorProtegido, CartaNoEncontrada {
		Mesa mesa = new Mesa();
		Jugador jugador1 = new Jugador("Wilson");
		Jugador jugador2 = new Jugador("Marta");
		jugador2.proteger();

		mesa.agregarJugador(jugador1);
		mesa.agregarJugador(jugador2);

		Guardia guardia1 = new Guardia();
		Principe principe = new Principe();

		jugador1.tomarCarta(guardia1);
		jugador2.tomarCarta(principe);

		mesa.nombrarCarta(jugador2, principe);
	}
}
