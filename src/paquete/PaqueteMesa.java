package paquete;

import java.util.TreeSet;

import dominio.entidad.Jugador;
import dominio.entidad.Mazo;

public class PaqueteMesa extends Paquete {
	private Mazo mazo;
	private TreeSet<Jugador> jugadores;
	
	public PaqueteMesa(String comando, TreeSet<Jugador> jugadores, Mazo mazo, Jugador jugador) {
		super(comando);
		this.mazo = mazo;
		this.jugadores = jugadores;
	}

	public Mazo getMazo() {
		return mazo;
	}

	public TreeSet<Jugador> getJugadores() {
		return jugadores;
	}
}
