package dominio.entidad;

import dominio.excepcion.CartaNoEncontrada;

public class Princesa extends Carta {

	private static final String nombre = "Princesa";
	private static final int fuerza = 8;

	public Princesa() {
		super(nombre, fuerza);

	}

	@Override
	public Carta descartar(Jugador jugador) throws CartaNoEncontrada {
		Carta carta = jugador.obtenerUltimaCartaDescartada();

		jugador.eliminar();

		return carta;
	}
}
