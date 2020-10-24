package dominio.entidad;

import java.util.TreeSet;

import dominio.excepcion.JugadorProtegido;

public class Partida {
	private Mazo mazo = new Mazo();
	private TreeSet<Jugador> jugadores;
	private int cantSimbolosDeAfectoNecesarios;

	public Partida(TreeSet<Jugador> jugadores, int cantSimbolosDeAfectoNecesarios) {
		this.jugadores = jugadores;
		this.cantSimbolosDeAfectoNecesarios = cantSimbolosDeAfectoNecesarios;
	}

	@Override
	public String toString() {
		return "Partida [jugadores=" + jugadores + ", cantSimbolosDeAfectoNecesarios=" + cantSimbolosDeAfectoNecesarios
				+ "]";
	}

	public void siguienteRonda() {

	}

	public Jugador ganadorPartida() {
		return this.jugadores.first();
	}

	public Jugador finalizarPartida() {
		Jugador ganador;
		Ronda ronda= new Ronda(this.jugadores);
		ganador= ronda.finalizarRonda();
		while(ganador.obtenerSimbolosAfectos()!=this.cantSimbolosDeAfectoNecesarios) {
			ronda= new Ronda(this.jugadores);
			ganador= ronda.finalizarRonda();
		}
		return ganador;
	}
}
