package tests;

import static org.junit.Assert.assertEquals;

import java.util.Comparator;
import java.util.TreeSet;

import org.junit.Test;

import dominio.entidad.Jugador;
import dominio.entidad.Ronda;
import junit.framework.Assert;

public class RondaTest {

	@Test
	public void testFinalizarRonda() {
		TreeSet<Jugador> jugadores = new TreeSet<Jugador>();
		Jugador jugador = new Jugador("pablo");
		jugadores.add(jugador);
		jugadores.add(new Jugador("kevin"));
		Ronda juego = new Ronda(jugadores);

		Jugador ganador = juego.finalizarRonda();

		assertEquals(jugador, ganador);
	}

}
