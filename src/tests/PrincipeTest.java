package tests;

import static org.junit.Assert.*;

import org.junit.Assert;
import org.junit.Test;

import dominio.entidad.Carta;
import dominio.entidad.Guardia;
import dominio.entidad.Jugador;
import dominio.entidad.Mesa;
import dominio.entidad.Mucama;
import dominio.entidad.Princesa;
import dominio.entidad.Principe;
import dominio.entidad.Sacerdote;
import dominio.excepcion.CartaNoEncontrada;
import dominio.excepcion.JugadorProtegido;

public class PrincipeTest {

	@Test(expected=JugadorProtegido.class)
	public void descartarTomarCarta() throws JugadorProtegido, CartaNoEncontrada {
		Mesa mesa = new Mesa();
		Jugador jugador1 = new Jugador("Wilson");
		Jugador jugador2 = new Jugador("Marta");
		jugador2.proteger();

		mesa.agregarJugador(jugador1);
		mesa.agregarJugador(jugador2);

		Principe principe = new Principe();
		Principe principe2 = new Principe();

		jugador1.tomarCarta(principe);
		jugador2.tomarCarta(principe2);

		mesa.descartarTomarCarta(jugador2);
	}
	
	@Test
	public void descartarTomarCartaASiMismo() throws JugadorProtegido, CartaNoEncontrada {
		Mesa mesa = new Mesa();
		Jugador jugador1 = new Jugador("Wilson");

		mesa.agregarJugador(jugador1);
		
		Mucama principe = new Mucama();
		
		jugador1.tomarCarta(principe);
		
		mesa.descartarTomarCarta(jugador1);
		
		assertEquals(1, jugador1.obtenerCartasDeLaMano().size());
	}
	
	@Test
	public void descartarTomarCartaPrincesa() throws JugadorProtegido, CartaNoEncontrada {
		Mesa mesa = new Mesa();
		Jugador jugador1 = new Jugador("Wilson");

		mesa.agregarJugador(jugador1);
		
		Princesa princesa = new Princesa();
		
		jugador1.tomarCarta(princesa);
		
		mesa.descartarTomarCarta(jugador1);
		
		assertTrue(jugador1.estaEliminado());
		assertEquals(0, jugador1.obtenerCartasDeLaMano().size());
	}
	
	@Test
	public void descartarTomarCartaDelApartado() throws JugadorProtegido, CartaNoEncontrada {
		Mesa mesa = new Mesa();
		
		Jugador jugador1 = new Jugador("Wilson");

		mesa.agregarJugador(jugador1);
		
		Guardia guardia = new Guardia();
		
		jugador1.tomarCarta(guardia);
		
		mesa.descartarTomarCarta(jugador1);
		
		assertNotEquals(guardia, jugador1.darCarta());
	}
}
