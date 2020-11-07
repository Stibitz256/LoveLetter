package tests;

import static org.junit.Assert.*;

import org.junit.Assert;
import org.junit.Test;

import dominio.entidad.Baron;
import dominio.entidad.Jugador;
import dominio.entidad.Princesa;
import dominio.entidad.Principe;
import dominio.entidad.Rey;
import dominio.excepcion.CartaNoEncontrada;
import dominio.excepcion.CartaNoValida;
import dominio.excepcion.CondesaEnMano;
import dominio.excepcion.DescartarParametrosIncorrectos;
import dominio.excepcion.JugadorProtegido;

public class ReyTest {

	@Test(expected=JugadorProtegido.class)
	public void intercambiarCartasProtegido() throws CartaNoEncontrada, JugadorProtegido, DescartarParametrosIncorrectos, CartaNoValida, CondesaEnMano {
		Jugador jugador1 = new Jugador("Wilson");
		Jugador jugador2 = new Jugador("Marta");
		jugador2.proteger();

		Rey rey = new Rey();
		Principe principe = new Principe();
		Baron baron = new Baron();

		jugador1.tomarCarta(principe);
		jugador2.tomarCarta(baron);

		rey.descartar(jugador2, jugador1);
	}
	
	@Test
	public void intercambiarCartas() throws CartaNoEncontrada, JugadorProtegido, CondesaEnMano {
		Jugador jugador1 = new Jugador("Wilson");
		Jugador jugador2 = new Jugador("Marta");

		Rey rey = new Rey();
		Principe principe = new Principe();
		Baron baron = new Baron();

		jugador1.tomarCarta(principe);
		jugador2.tomarCarta(baron);

		rey.descartar(jugador2, jugador1);
		
		assertEquals(jugador1.darCarta(), baron);
		assertEquals(jugador2.darCarta(), principe);
	}
}
