package dominio.entidad;

import java.util.Iterator;

import dominio.excepcion.CartaNoEncontrada;
import dominio.excepcion.CondesaEnMano;
import dominio.excepcion.JugadorProtegido;

public class Principe extends Carta {

	private static final String nombre = "Principe";
	private static final int fuerza = 5;

	public Principe() {
		super(nombre, fuerza);
	}

	@Override
	public Carta descartar(Jugador jugador, Mazo mazo, Carta cartaApartada) throws JugadorProtegido, CondesaEnMano, CartaNoEncontrada {
		Iterator<Carta> cartas = jugador.obtenerCartasDeLaMano().iterator();
		while (cartas.hasNext()) {
			Carta carta = cartas.next();
			if (carta.getClass() == Condesa.class) {
				Principe cartaDescartada = (Principe) jugador.eliminarUltimaCartaDescartada();
				jugador.tomarCarta(cartaDescartada);
				throw new CondesaEnMano();
			}
		}
		if (jugador.estaProtegido()) {
			throw new JugadorProtegido();
		}

		Carta cartaDescartada = jugador.descartar();
		if (cartaDescartada.getClass() == Princesa.class) {
			jugador.eliminar();

			return cartaDescartada;
		}

		Carta carta = null;

		try {
			carta = jugador.tomarCarta(mazo.obtenerCarta());
		} catch (CartaNoEncontrada exception) {
			carta = jugador.tomarCarta(cartaApartada);
		}

		return carta;

	}
}
