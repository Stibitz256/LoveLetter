package tests;

import static org.junit.Assert.*;

import java.util.Comparator;
import java.util.TreeSet;

import org.junit.Test;

import dominio.entidad.Jugador;
import dominio.entidad.Ronda;

public class RondaTest {

	@Test
	public void testFinalizarRonda() {
		
		TreeSet<Jugador> jugadores= new TreeSet<>(new Comparator() {
			@Override
			public int compare(Object o1, Object o2) {
				// TODO Auto-generated method stub
				return 0;
			}
		});
		jugadores.add(new Jugador("pablo1"));
		jugadores.add(new Jugador("abbbbb"));
		Ronda juego= new Ronda(jugadores);
		
		Jugador ganador = juego.finalizarRonda();
		
		System.out.println(ganador.toString());
	}

}
