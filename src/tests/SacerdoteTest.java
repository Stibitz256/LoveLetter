package tests;

import static org.junit.Assert.*;

import org.junit.Test;

import dominio.entidad.Carta;
import dominio.entidad.Guardia;
import dominio.entidad.Jugador;
import dominio.entidad.Mesa;
import dominio.entidad.Mucama;
import dominio.entidad.Sacerdote;
import dominio.excepcion.CartaNoEncontrada;
import dominio.excepcion.CartaNoValida;
import dominio.excepcion.JugadorProtegido;

public class SacerdoteTest {

	@Test
	public void verCartas() throws JugadorProtegido, CartaNoEncontrada {
		Mesa mesa = new Mesa();
		Jugador jugador1 = new Jugador("Wilson");
		Jugador jugador2 = new Jugador("Marta");

		mesa.agregarJugador(jugador1);
		mesa.agregarJugador(jugador2);

		Sacerdote sacerdote = new Sacerdote();
		Mucama mucama = new Mucama();

		jugador1.tomarCarta(sacerdote);
		jugador2.tomarCarta(mucama);

		Carta carta = mesa.verCartas(jugador2);
		assertEquals(mucama, carta);
	}
	
	@Test(expected=JugadorProtegido.class)
	public void verCartasDeProtegido() throws JugadorProtegido, CartaNoEncontrada {
		Mesa mesa = new Mesa();
		Jugador jugador1 = new Jugador("Wilson");
		Jugador jugador2 = new Jugador("Marta");
		jugador2.proteger();

		mesa.agregarJugador(jugador1);
		mesa.agregarJugador(jugador2);

		Sacerdote sacerdote = new Sacerdote();
		Mucama mucama = new Mucama();

		jugador1.tomarCarta(sacerdote);
		jugador2.tomarCarta(mucama);

		Carta carta = mesa.verCartas(jugador2);
		assertEquals(mucama, carta);
	}
}
