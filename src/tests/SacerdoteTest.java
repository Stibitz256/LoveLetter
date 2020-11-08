package tests;

import static org.junit.Assert.*;

import org.junit.Test;

import dominio.entidad.Carta;
import dominio.entidad.Guardia;
import dominio.entidad.Jugador;
import dominio.entidad.Mucama;
import dominio.entidad.Rey;
import dominio.entidad.Sacerdote;
import dominio.excepcion.CartaNoEncontrada;
import dominio.excepcion.CartaNoValida;
import dominio.excepcion.JugadorProtegido;

public class SacerdoteTest {

	@Test
	public void verCartas() throws JugadorProtegido, CartaNoEncontrada {
		
		Jugador jugador1 = new Jugador("Wilson");
		Jugador jugador2 = new Jugador("Marta");

		Sacerdote sacerdote = new Sacerdote();
		Rey rey = new Rey();

		jugador1.tomarCarta(sacerdote);
		jugador2.tomarCarta(rey);
		
		Carta carta = sacerdote.descartar(jugador2);
		
		assertEquals(rey, carta);
	}
	
	@Test(expected=JugadorProtegido.class)
	public void verCartasDeProtegido() throws JugadorProtegido, CartaNoEncontrada {

		Jugador jugador1 = new Jugador("Wilson");
		Jugador jugador2 = new Jugador("Marta");
		jugador2.proteger();

		Sacerdote sacerdote = new Sacerdote();
		Mucama mucama = new Mucama();

		jugador1.tomarCarta(sacerdote);
		jugador2.tomarCarta(mucama);

		Carta carta = sacerdote.descartar(jugador2);
		
	}
}
