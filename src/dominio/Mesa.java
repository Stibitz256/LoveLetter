package dominio;

import java.util.TreeSet;

public class Mesa {
	Mazo mazo;
	TreeSet<Jugador> jugadores;
	Jugador turno;
	Carta cartaApartada;
	int cantSimbolosDeAfectoNecesario;
	
	public Mesa() {
		
	}
	
	public void repartir() {
		
	}
	
	public void agregarJugador(Jugador jugador) {
		
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
		return null;
	}
}
