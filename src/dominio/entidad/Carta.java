package dominio.entidad;

import java.util.Enumeration;

import dominio.excepcion.CartaNoEncontrada;
import dominio.excepcion.CartaNoValida;
import dominio.excepcion.DescartarParametrosIncorrectos;
import dominio.excepcion.JugadorProtegido;

abstract public class Carta {
	private String nombre;
	private int fuerza;

	public Carta(String nombre, int fuerza) {
		super();
		this.nombre = nombre;
		this.fuerza = fuerza;
	}

	public Carta descartar(Jugador jugador)
			throws DescartarParametrosIncorrectos, CartaNoValida, JugadorProtegido, CartaNoEncontrada {
		throw new DescartarParametrosIncorrectos();
	}

	public boolean descartar(Jugador jugador, Enumeration<Carta> Carta) throws JugadorProtegido, CartaNoValida,
			DescartarParametrosIncorrectos, InstantiationException, IllegalAccessException {
		throw new DescartarParametrosIncorrectos();
	}

	public Carta descartar(Jugador jugador, Jugador jugadorTurno)
			throws JugadorProtegido, DescartarParametrosIncorrectos {
		throw new DescartarParametrosIncorrectos();
	}

	public Carta descartar(Jugador jugador, Mazo mazo) throws JugadorProtegido, DescartarParametrosIncorrectos {
		throw new DescartarParametrosIncorrectos();
	}

	public Carta descartar(Jugador jugador, Mazo mazo, Carta cartaApartada)
			throws JugadorProtegido, DescartarParametrosIncorrectos {
		throw new DescartarParametrosIncorrectos();
	}

	public String getNombre() {
		return nombre;
	}

	public int getFuerza() {
		return fuerza;
	}
}
