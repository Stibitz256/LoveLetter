package dominio.entidad;

import java.util.Iterator;
import java.util.TreeSet;

public class Partida {
	private TreeSet<Jugador> jugadores;
	private int cantSimbolosDeAfectoNecesarios;
	private Ronda ronda;

	public Partida(TreeSet<Jugador> jugadores, int cantSimbolosDeAfectoNecesarios) {
		this.jugadores = jugadores;
		this.cantSimbolosDeAfectoNecesarios = cantSimbolosDeAfectoNecesarios;
		this.ronda = new Ronda(jugadores);
	}

	@Override
	public String toString() {
		return "Partida [jugadores=" + jugadores + ", cantSimbolosDeAfectoNecesarios=" + cantSimbolosDeAfectoNecesarios
				+ "]";
	}
	
	public Ronda inicializarPartida() {
		return this.ronda;
	}

	public Ronda siguienteRonda() {
		if (this.ganadorPartida().obtenerSimbolosAfectos() < this.cantSimbolosDeAfectoNecesarios) {
			this.ronda = new Ronda(this.jugadores);
		}

		return this.ronda;
	}

	public Jugador ganadorPartida() {
		Iterator<Jugador> jugadores = this.jugadores.iterator();
		Jugador ganador = jugadores.next();
		while (jugadores.hasNext()) {
			Jugador jugador = jugadores.next();
			if (jugador.obtenerSimbolosAfectos() > ganador.obtenerSimbolosAfectos()) {
				ganador = jugador;
			}
		}

		return ganador;
	}

	public Jugador finalizarPartida() {
		this.ronda.finalizarRonda();

		return this.ganadorPartida();
	}
}
