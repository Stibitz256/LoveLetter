package tests;

import static org.junit.Assert.*;

import org.junit.Test;

import dominio.entidad.Carta;
import dominio.entidad.Condesa;
import dominio.entidad.Jugador;
import dominio.entidad.Mesa;
import dominio.entidad.Mucama;
import dominio.entidad.Rey;
import dominio.entidad.Sacerdote;
import dominio.excepcion.CartaNoEncontrada;

public class CondesaTest {

	@Test
	public void jugarCondesaCuandoTengaRey() throws CartaNoEncontrada {
		Mesa mesa = new Mesa();
		Jugador jugador1 = new Jugador("Charles");
		Jugador jugador2 = new Jugador("George");
		mesa.agregarJugador(jugador1);
		mesa.agregarJugador(jugador2);

		Condesa condesa = new Condesa();
		Rey rey = new Rey();

		jugador1.tomarCarta(condesa);
		jugador1.tomarCarta(rey);

	}

}
