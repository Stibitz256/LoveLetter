package paquete;

import java.util.TreeSet;

import dominio.entidad.Jugador;
import dominio.entidad.Mazo;


public class PaqueteMesa {
	private String comando;
	private TreeSet<Jugador> jugadores;
	private Mazo mazo;
	private Jugador jugador;
	
	public PaqueteMesa(String comando, TreeSet<Jugador> jugadores, Mazo mazo, Jugador jugador) {
		this.comando = comando;
		this.jugadores = jugadores;
		this.mazo = mazo;
		this.jugador = jugador;
	}

	public Mazo getMazo() {
		return mazo;
	}

	public TreeSet<Jugador> getJugadores() {
		return jugadores;
	}
	
	public String getComando() {
		return comando;
	}

	public void setComando(String comando) {
		this.comando = comando;
	}

	public Jugador getJugador() {
		return jugador;
	}

	public void setJugador(Jugador jugador) {
		this.jugador = jugador;
	}
}
