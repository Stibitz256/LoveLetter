package tests;

import static org.junit.Assert.*;

import org.junit.Test;

import dominio.entidad.Condesa;
import dominio.entidad.Jugador;
import dominio.entidad.Princesa;
import dominio.excepcion.CartaNoEncontrada;

public class PrincesaTest {

	@Test
	public void jugarPrincesa() throws CartaNoEncontrada {
		Jugador jugador1 = new Jugador("Charles");
		Jugador jugador2 = new Jugador("George");

		Princesa princesa = new Princesa();

		jugador1.tomarCarta(princesa);
		jugador1.descartar(princesa);
		princesa.descartar(jugador1);

		assertTrue(jugador1.estaEliminado());

	}

}
