package dominio.entidad;

import dominio.excepcion.CartaNoEncontrada;
import dominio.excepcion.CartaNoValida;

public class Mucama extends Carta {
	private static final String nombre = "Mucama";
	private static final int fuerza = 4;

	public Mucama() {
		super(nombre, fuerza);
	}

	@Override
	public Carta descartar(Jugador jugador) throws CartaNoValida, CartaNoEncontrada {
		Carta carta = jugador.obtenerUltimaCartaDescartada();
		if (carta.getClass() == Mucama.class) {
			jugador.proteger();

			return carta;
		}

		throw new CartaNoValida();
	}
}
