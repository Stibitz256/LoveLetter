package tests;

import java.util.Comparator;
import java.util.TreeSet;

import org.junit.Test;

import dominio.entidad.Jugador;
import dominio.entidad.Ronda;

public class RondaTest {

	@Test
	public void testFinalizarRonda() {
		
		TreeSet<Jugador> jugadores= new TreeSet<Jugador>(new Comparator<Object>() {
			@Override
			public int compare(Object o1, Object o2) {
				// TODO Auto-generated method stub
				return 1;
			}
		});
		jugadores.add(new Jugador("pablo"));
		jugadores.add(new Jugador("kevin"));
		Ronda juego= new Ronda(jugadores);
		
		Jugador ganador = juego.finalizarRonda();
		
		System.out.println(ganador.toString());
	}

}
