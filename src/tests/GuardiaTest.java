package tests;

import static org.junit.Assert.*;

import java.util.Enumeration;

import org.junit.Test;

import dominio.entidad.Carta;
import dominio.entidad.EnumerationCarta;
import dominio.entidad.Guardia;
import dominio.entidad.Jugador;
import dominio.entidad.Mucama;
import dominio.entidad.Principe;
import dominio.excepcion.CartaNoEncontrada;
import dominio.excepcion.CartaNoValida;
import dominio.excepcion.JugadorProtegido;

public class GuardiaTest {

	@Test
	public void guardiaAdivinaCorrecto() throws CartaNoValida, JugadorProtegido, CartaNoEncontrada {
		Jugador jugador1 = new Jugador("Wilson");
		Jugador jugador2 = new Jugador("Marta");

		Guardia guardia = new Guardia();
		Mucama mucama = new Mucama();

		jugador1.tomarCarta(guardia);
		jugador2.tomarCarta(mucama);

		boolean esAdivinado = guardia.descartar(jugador2, EnumerationCarta.Mucama);
		
		assertTrue(esAdivinado);
	}

	@Test
	public void guardiaNoAdivina() throws CartaNoValida, JugadorProtegido, CartaNoEncontrada {
		Jugador jugador1 = new Jugador("Wilson");
		Jugador jugador2 = new Jugador("Marta");

		Guardia guardia = new Guardia();
		Mucama mucama = new Mucama();
		Principe principe = new Principe();

		jugador1.tomarCarta(guardia);
		jugador2.tomarCarta(mucama);

		boolean esAdivinado = guardia.descartar(jugador2, EnumerationCarta.Principe);
		
		assertFalse(esAdivinado);
	}

	@Test(expected=CartaNoValida.class)
	public void guardiaNoPermiteAdivinarGuardia() throws CartaNoValida, JugadorProtegido, CartaNoEncontrada {
		Jugador jugador1 = new Jugador("Wilson");
		Jugador jugador2 = new Jugador("Marta");

		Guardia guardia1 = new Guardia();
		Guardia guardia2 = new Guardia();

		jugador1.tomarCarta(guardia1);
		jugador2.tomarCarta(guardia2);

		guardia1.descartar(jugador2, EnumerationCarta.Guardia);
	}
	
	@Test(expected=JugadorProtegido.class)
	public void guardiaNoPermiteAdivinarEnJugadorProtegido() throws CartaNoValida, JugadorProtegido, CartaNoEncontrada {
		Jugador jugador1 = new Jugador("Wilson");
		Jugador jugador2 = new Jugador("Marta");
		jugador2.proteger();

		Guardia guardia1 = new Guardia();
		Principe principe = new Principe();

		jugador1.tomarCarta(guardia1);
		jugador2.tomarCarta(principe);

		guardia1.descartar(jugador2, EnumerationCarta.Principe);
	}
}
