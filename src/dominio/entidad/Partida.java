package dominio.entidad;

import java.util.Iterator;
import java.util.TreeSet;

import dominio.excepcion.JugadorProtegido;

public class Partida {
	//private Mazo mazo = new Mazo();
	private TreeSet<Jugador> jugadores;
	private int cantSimbolosDeAfectoNecesarios;
	private int cantJugadores=0;
	
	public Partida(TreeSet<Jugador> jugadores, int cantSimbolosDeAfectoNecesarios) {
		cantJugadores= jugadores.size();
		this.jugadores = jugadores;
		this.cantSimbolosDeAfectoNecesarios = cantSimbolosDeAfectoNecesarios;
	}
	
	@Override
	public String toString() {
		return "Partida [jugadores=" + jugadores + ", cantSimbolosDeAfectoNecesarios=" + cantSimbolosDeAfectoNecesarios
				+ "]";
	}

	public boolean agregarJugador(Jugador jugador) throws JugadorProtegido {
		if(cantJugadores>=4)
			return false;
		if(!jugadores.add(jugador)) {
			throw new JugadorProtegido();
		}
		
		return true;
	}
	public TreeSet<Jugador> getJugadores() {
		return jugadores;
	}
	public Jugador ganadorPartida() {
		Jugador ganador = null;

		
		return ganador;
	}
	
	
}
