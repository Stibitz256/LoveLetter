package tests;

import static org.junit.Assert.*;

import org.junit.Test;

import dominio.entidad.Condesa;
import dominio.entidad.Jugador;
import dominio.entidad.Mesa;
import dominio.entidad.Princesa;
import dominio.excepcion.CartaNoEncontrada;

public class PrincesaTest {

	@Test
	public void jugarPrincesa() throws CartaNoEncontrada {
		Mesa mesa = new Mesa();
		Jugador jugador1 = new Jugador("Charles");
		Jugador jugador2 = new Jugador("George");

		mesa.agregarJugador(jugador1);
		mesa.agregarJugador(jugador2);

		Princesa princesa = new Princesa();

		jugador1.tomarCarta(princesa);
		jugador1.descartar(princesa);
		
	}

}
