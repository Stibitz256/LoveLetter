package tests;

import static org.junit.Assert.*;

import org.junit.Test;

import dominio.Guardia;
import dominio.Jugador;
import dominio.Mesa;
import dominio.Mucama;

public class GuardiaTest {

	@Test
	public void guardiaAdivinaCorrecto() {
		Mesa mesa = new Mesa();
		Jugador jugador1 = new Jugador("Wilson");
		Jugador jugador2 = new Jugador("Marta");

		mesa.agregarJugador(jugador1);
		mesa.agregarJugador(jugador2);

		Guardia guardia = new Guardia();
		Mucama mucama = new Mucama();

		jugador1.tomarCarta(guardia);
		jugador2.tomarCarta(mucama);

//		mesa.nombrarCarta(jugador2, mucama);

		assertFalse(mesa.nombrarCarta(jugador2, mucama));

	}

	// En el lote de pruebas se llama guardiaAdivinaMal
	@Test
	public void guardiaNoAdivina() {
		Mesa mesa = new Mesa();
		Jugador jugador1 = new Jugador("Wilson");
		Jugador jugador2 = new Jugador("Marta");

		mesa.agregarJugador(jugador1);
		mesa.agregarJugador(jugador2);

		Guardia guardia = new Guardia();
		Mucama mucama = new Mucama();

		jugador1.tomarCarta(guardia);
		jugador2.tomarCarta(mucama);

		assertFalse(mesa.nombrarCarta(jugador2, mucama));

	}
}
