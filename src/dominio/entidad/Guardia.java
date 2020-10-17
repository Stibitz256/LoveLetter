package dominio.entidad;

import java.util.Enumeration;
import java.util.Iterator;

import dominio.excepcion.CartaNoValida;
import dominio.excepcion.JugadorProtegido;

public class Guardia extends Carta {

	private static final String nombre = "Guardia";
	private static final int fuerza = 1;

	public Guardia() {
		super(nombre, fuerza);
	}

	@Override
	public boolean descartar(Jugador jugador, Enumeration<Carta> carta) throws JugadorProtegido, CartaNoValida {
		if (jugador.estaProtegido()) {
			throw new JugadorProtegido();
		}
		if (carta.getClass() == Guardia.class) {
			throw new CartaNoValida();
		}
		Iterator<Carta> cartas = jugador.obtenerCartasDeLaMano().iterator();
		while (cartas.hasNext()) {
			Carta cartaJugador = cartas.next();
			if (cartaJugador.getClass() == carta.getClass()) {
				return true;
			}
		}

		return false;
	}

}
