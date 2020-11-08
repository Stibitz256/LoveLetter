package tests;

import static org.junit.Assert.*;

import java.util.Comparator;
import java.util.TreeSet;

import org.junit.Test;

import dominio.entidad.Jugador;
import dominio.entidad.Partida;

public class PartidaTest {

	@Test
	public void testGanaElUltimo() {
		TreeSet<Jugador> jugadores = new TreeSet<Jugador>();
		jugadores.add(new Jugador("pablo"));
		jugadores.add(new Jugador("kevin"));
		Partida partida = new Partida(jugadores, 5);
		Jugador ganador = partida.finalizarPartida();
		System.out.println(ganador.toString());
	}

}
