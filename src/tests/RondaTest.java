package tests;

import static org.junit.Assert.assertEquals;

import java.util.Comparator;
import java.util.TreeSet;

import org.junit.Test;

import dominio.entidad.Baron;
import dominio.entidad.Guardia;
import dominio.entidad.Jugador;
import dominio.entidad.Ronda;
import dominio.entidad.Sacerdote;
import junit.framework.Assert;

public class RondaTest {

	@Test
	public void testFinalizarRonda() {
		TreeSet<Jugador> jugadores = new TreeSet<Jugador>();
		Jugador jugador = new Jugador("pablo");
		Jugador otroJugador = new Jugador("kevin");
		
		jugadores.add(jugador);
		jugadores.add(otroJugador);
		Ronda juego = new Ronda(jugadores);

		Jugador ganador = juego.finalizarRonda();

		assertEquals(jugador, ganador);
	}
	
	@Test
	public void testCompararFuerzasGanadorFuerza() {
		TreeSet<Jugador> jugadores = new TreeSet<Jugador>();
		Jugador jugador = new Jugador("pablo");
		Jugador otroJugador = new Jugador("kevin");
		
		Guardia guardia = new Guardia();
		
		Sacerdote sacerdote = new Sacerdote();
		
		jugador.tomarCarta(guardia);
		otroJugador.tomarCarta(sacerdote);
		
		jugadores.add(jugador);
		jugadores.add(otroJugador);
		
		Ronda juego = new Ronda(jugadores);
		Jugador ganador = juego.compararFuerzasYDescartes();

		assertEquals(otroJugador, ganador);
	}
	
	@Test
	public void testCompararFuerzasGanadorPorDescartes() {
		TreeSet<Jugador> jugadores = new TreeSet<Jugador>();
		Jugador jugador = new Jugador("pablo");
		Jugador otroJugador = new Jugador("kevin");
		
		Guardia guardia = new Guardia();
		Guardia guardia2 = new Guardia();
		Guardia guardia3 = new Guardia();
		
		jugador.tomarCarta(guardia);
		jugador.tomarCarta(guardia2);
		jugador.descartar(guardia2);
		
		otroJugador.tomarCarta(guardia3);
		
		jugadores.add(jugador);
		jugadores.add(otroJugador);
		
		Ronda juego = new Ronda(jugadores);
		Jugador ganador = juego.compararFuerzasYDescartes();

		assertEquals(jugador, ganador);
	}
}
