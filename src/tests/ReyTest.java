package tests;

import static org.junit.Assert.*;

import org.junit.Assert;
import org.junit.Test;

import dominio.entidad.Jugador;
import dominio.entidad.Mesa;
import dominio.entidad.Princesa;
import dominio.entidad.Principe;
import dominio.excepcion.CartaNoEncontrada;
import dominio.excepcion.JugadorProtegido;

public class ReyTest {

	@Test(expected=JugadorProtegido.class)
	public void intercambiarCartasProtegido() throws CartaNoEncontrada, JugadorProtegido {
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

		mesa.intercambiarCartas(jugador2);
	}
	
	@Test
	public void intercambiarCartas() throws CartaNoEncontrada, JugadorProtegido {
		Mesa mesa = new Mesa();
		Jugador jugador1 = new Jugador("Wilson");
		Jugador jugador2 = new Jugador("Marta");

		mesa.agregarJugador(jugador1);
		mesa.agregarJugador(jugador2);

		Principe principe = new Principe();
		Princesa princesa = new Princesa();

		jugador1.tomarCarta(principe);
		jugador2.tomarCarta(princesa);

		mesa.intercambiarCartas(jugador2);
		
		Assert.assertEquals(principe, jugador2.darCarta());
		Assert.assertEquals(princesa, jugador1.darCarta());
	}
}
