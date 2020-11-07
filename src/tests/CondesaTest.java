package tests;

import static org.junit.Assert.*;

import org.junit.Test;

import dominio.entidad.Baron;
import dominio.entidad.Carta;
import dominio.entidad.Condesa;
import dominio.entidad.Jugador;
import dominio.entidad.Mazo;
import dominio.entidad.Mucama;
import dominio.entidad.Principe;
import dominio.entidad.Rey;
import dominio.entidad.Sacerdote;
import dominio.excepcion.CartaNoEncontrada;
import dominio.excepcion.CartaNoValida;
import dominio.excepcion.CondesaEnMano;
import dominio.excepcion.DescartarParametrosIncorrectos;
import dominio.excepcion.JugadorProtegido;

public class CondesaTest {

	@Test
	public void jugarCondesaCuandoTengaRey()
			throws DescartarParametrosIncorrectos, CartaNoValida, JugadorProtegido, CartaNoEncontrada {
		Jugador jugador1 = new Jugador("Charles");
		Jugador jugador2 = new Jugador("George");

		Rey rey = new Rey();
		Condesa condesa = new Condesa();
		jugador1.tomarCarta(rey);
		jugador1.tomarCarta(condesa);

		jugador1.descartar(condesa);
		Carta carta = condesa.descartar(jugador1);
		assertEquals(condesa, carta);
	}

	@Test
	public void jugarCondesaCuandoTengaPrincipe()
			throws DescartarParametrosIncorrectos, CartaNoValida, JugadorProtegido, CartaNoEncontrada {
		Jugador jugador1 = new Jugador("Charles");
		Jugador jugador2 = new Jugador("George");

		Principe principe = new Principe();
		Condesa condesa = new Condesa();
		jugador1.tomarCarta(principe);
		jugador1.tomarCarta(condesa);

		jugador1.descartar(condesa);
		Carta carta = condesa.descartar(jugador1);
		assertEquals(condesa, carta);
	}

	@Test(expected = CondesaEnMano.class)
	public void arrojarExcepcionCuandoTengaCondesaYQuieraJugarRey()
			throws DescartarParametrosIncorrectos, CartaNoValida, JugadorProtegido, CartaNoEncontrada, CondesaEnMano {
		Jugador jugador1 = new Jugador("Charles");
		Jugador jugador2 = new Jugador("George");

		Rey rey = new Rey();
		Condesa condesa = new Condesa();
		Baron baron = new Baron();

		jugador1.tomarCarta(rey);
		jugador1.tomarCarta(condesa);
		jugador2.tomarCarta(baron);

		jugador1.descartar(rey);
		rey.descartar(jugador2, jugador1);
	}

	@Test(expected = CondesaEnMano.class)
	public void arrojarExcepcionCuandoTengaCondesaYQuieraJugarPrincipe()
			throws DescartarParametrosIncorrectos, CartaNoValida, JugadorProtegido, CartaNoEncontrada, CondesaEnMano {
		Jugador jugador1 = new Jugador("Charles");
		Jugador jugador2 = new Jugador("George");

		Principe principe = new Principe();
		Condesa condesa = new Condesa();
		Baron baron = new Baron();

		jugador1.tomarCarta(principe);
		jugador1.tomarCarta(condesa);
		jugador2.tomarCarta(baron);

		Mazo mazo = new Mazo();
		jugador1.descartar(principe);
		principe.descartar(jugador1, mazo, condesa);
	}

}
