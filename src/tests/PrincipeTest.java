package tests;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import dominio.entidad.Carta;
import dominio.entidad.Guardia;
import dominio.entidad.Jugador;
import dominio.entidad.Mazo;
import dominio.entidad.Princesa;
import dominio.entidad.Principe;
import dominio.excepcion.CartaNoEncontrada;
import dominio.excepcion.CondesaEnMano;
import dominio.excepcion.DescartarParametrosIncorrectos;
import dominio.excepcion.JugadorProtegido;

public class PrincipeTest {

	@Test(expected=JugadorProtegido.class)
	public void descartarTomarCarta() throws JugadorProtegido, CartaNoEncontrada, CondesaEnMano {
		Jugador jugador1 = new Jugador("Wilson");
		Jugador jugador2 = new Jugador("Marta");
		jugador2.proteger();

		Principe principe = new Principe();
		Principe principe2 = new Principe();

		jugador1.tomarCarta(principe);
		jugador2.tomarCarta(principe2);

		Mazo mazo = new Mazo();
		Carta cartaApartada = mazo.obtenerCarta();
		principe.descartar(jugador2, mazo, cartaApartada);
	}
	
	@Test
	public void descartarTomarCartaASiMismo() throws JugadorProtegido, CartaNoEncontrada, DescartarParametrosIncorrectos, CondesaEnMano {
		Principe principe = new Principe();
		Jugador jugador1 = new Jugador("Wilson");
		jugador1.tomarCarta(principe);
		Mazo mazo = new Mazo();
		Carta cartaApartada = mazo.obtenerCarta();
		
		principe.descartar(jugador1, mazo, cartaApartada);
		
		assertEquals(1, jugador1.obtenerCartasDeLaMano().size());
	}
	
	@Test
	public void descartarTomarCartaPrincesa() throws JugadorProtegido, CartaNoEncontrada, CondesaEnMano {
		Principe principe = new Principe();
		Princesa princesa = new Princesa();
		
		Jugador jugador1 = new Jugador("Wilson");
		jugador1.tomarCarta(princesa);
		
		Mazo mazo = new Mazo();
		Carta cartaApartada = mazo.obtenerCarta();
		
		principe.descartar(jugador1, mazo, cartaApartada);
		
		assertTrue(jugador1.estaEliminado());
		assertEquals(0, jugador1.obtenerCartasDeLaMano().size());
	}
	
	@Test
	public void descartarTomarCartaDelApartado() throws JugadorProtegido, CartaNoEncontrada, CondesaEnMano {
		Jugador jugador1 = new Jugador("Wilson");
		Principe principe = new Principe();
		
		Guardia guardia = new Guardia();
		
		jugador1.tomarCarta(guardia);
		
		Mazo mazo = new Mazo();
		Carta cartaApartada = mazo.obtenerCarta();
		principe.descartar(jugador1, mazo, cartaApartada);
		
		assertNotEquals(cartaApartada, jugador1.darCarta());
	}
}
