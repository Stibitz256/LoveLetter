package dominio.entidad;

import java.util.Iterator;

import dominio.excepcion.CartaNoEncontrada;
import dominio.excepcion.CartaNoValida;
import dominio.excepcion.DescartarParametrosIncorrectos;
import dominio.excepcion.JugadorProtegido;

public class Condesa extends Carta {

	private static final String nombre = "Condesa";
	private static final int fuerza = 7;

	public Condesa() {
		super(nombre, fuerza);
	}

	@Override
	public Carta descartar(Jugador jugador)
			throws DescartarParametrosIncorrectos, CartaNoValida, JugadorProtegido, CartaNoEncontrada {

		Carta carta = jugador.obtenerUltimaCartaDescartada();
		if (carta.getClass() == Condesa.class) {
			return carta;
		}

		throw new CartaNoValida();
	}
}
