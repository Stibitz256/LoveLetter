package dominio.entidad;

import java.util.Iterator;
import java.util.TreeSet;

public class Ronda {
	private Mazo mazo = new Mazo();
	private Carta cartaApartada;
	private Jugador turno;
	Iterator<Jugador> jugadores;

	public Ronda(TreeSet<Jugador> jugadores){
		this.jugadores= jugadores.iterator();
	}

	
	public void ganadorRonda(Jugador jugador) {
			jugador.simbolosAfectos++;
			System.out.println(jugador.toString());

	}

	public void repartirMazo() throws Exception {
		Iterator<Jugador> jugadores = this.jugadores;
		while (jugadores.hasNext()) {
			Jugador jugador = jugadores.next();
			jugador.tomarCarta(this.mazo.obtenerCarta());			
		}
	}

	public void siguienteTurno() {
		
	}

	public Jugador siguienteJugadorEnLaRonda() {
		return null;
	}
	
	public void compararFuerzasYDescartes() {
		Iterator<Jugador> jugadores = this.jugadores;
		Jugador ganador= jugadores.next();
		while (jugadores.hasNext()) {
			Jugador jugador = jugadores.next();
			int comp= jugador.obtenerFuerza()-ganador.obtenerFuerza();
			if(comp>0) {
				ganador= jugador;
			}
			else {
				if(comp==0) {
					if(jugador.obtenerCantCartasDescartadas()>ganador.obtenerCantCartasDescartadas())
						ganador= jugador;
				}
			}
		}
		ganadorRonda(ganador);
	}

}
