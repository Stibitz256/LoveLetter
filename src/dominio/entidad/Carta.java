package dominio.entidad;

import java.util.Enumeration;

import dominio.excepcion.CartaNoEncontrada;
import dominio.excepcion.CartaNoValida;
import dominio.excepcion.CondesaEnMano;
import dominio.excepcion.DescartarParametrosIncorrectos;
import dominio.excepcion.JugadorProtegido;

abstract public class Carta {
	private String nombre;
	private int fuerza;

	public Carta(String nombre, int fuerza) {
		this.nombre = nombre;
		this.fuerza = fuerza;
	}

	public Carta descartar(Jugador jugador)
			throws DescartarParametrosIncorrectos, CartaNoValida, JugadorProtegido, CartaNoEncontrada {
		throw new DescartarParametrosIncorrectos();
	}

	public boolean descartar(Jugador jugador, EnumerationCarta Carta) throws JugadorProtegido, CartaNoValida,
			DescartarParametrosIncorrectos, InstantiationException, IllegalAccessException, CondesaEnMano {
		throw new DescartarParametrosIncorrectos();
	}

	public Carta descartar(Jugador jugador, Jugador jugadorTurno)
			throws JugadorProtegido, DescartarParametrosIncorrectos, CondesaEnMano {
		throw new DescartarParametrosIncorrectos();
	}

	public Carta descartar(Jugador jugador, Mazo mazo) throws JugadorProtegido, DescartarParametrosIncorrectos {
		throw new DescartarParametrosIncorrectos();
	}

	public Carta descartar(Jugador jugador, Mazo mazo, Carta cartaApartada)
			throws JugadorProtegido, DescartarParametrosIncorrectos, CondesaEnMano {
		throw new DescartarParametrosIncorrectos();
	}

	public String getNombre() {
		return nombre;
	}

	public int getFuerza() {
		return fuerza;
	}
}
