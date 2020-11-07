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
	public boolean descartar(Jugador jugador, EnumerationCarta carta) throws JugadorProtegido, CartaNoValida {
		if (jugador.estaProtegido()) {
			throw new JugadorProtegido();
		}
		if (carta == EnumerationCarta.Guardia) {
			throw new CartaNoValida();
		}
		Iterator<Carta> cartas = jugador.obtenerCartasDeLaMano().iterator();
		while (cartas.hasNext()) {
			Carta cartaJugador = cartas.next();
			if (cartaJugador.getNombre() == carta.name()) {
				return true;
			}
		}

		return false;
	}

}
