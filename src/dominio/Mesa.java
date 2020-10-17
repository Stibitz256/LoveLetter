package dominio;

import java.util.Iterator;
import java.util.TreeSet;

public class Mesa {
	Mazo mazo;
	TreeSet<Jugador> jugadores;
	Jugador turno;
	Carta cartaApartada;
	int cantSimbolosDeAfectoNecesario;
	
	public Mesa() {
		this.mazo = new Mazo();
	}
	
	public void repartir() {
		Iterator<Jugador> jugadores = this.jugadores.iterator();
		while (jugadores.hasNext()) { 
            Jugador jugador = jugadores.next();
            jugador.tomarCarta(this.mazo.tomarCarta());
        }
	}
	
	public void agregarJugador(Jugador jugador) {
		if(this.jugadores.isEmpty()) {
			this.turno = jugador;
		}
		this.jugadores.add(jugador);
	}
	
	public void intercambiarJugador(Jugador jugador) {
		
	}
	
	public Carta darCarta(Jugador jugador) {
		return null;
	}
	
	public boolean nombrarCarta(Jugador jugador, Carta carta) {
		return false;
	}
	
	public boolean verCartas(Jugador jugador, Carta carta) {
		return false;
	}
	
	public boolean mostrarseCartas(Jugador jugador) {
		return false;
	}
	
	public void descartarTomarCarta(Jugador jugador) {
		
	}
	
	public Carta jugarInmediatamente() {
		//Carta carta = this.turno.obtenerCartasDeLaMano();
		
		return null;
	}
}
