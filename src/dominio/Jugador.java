package dominio;

import java.util.LinkedHashSet;

public class Jugador {
	String nombre;
	boolean protegido;
	boolean eliminado;
	boolean rendido;
	int simbolosAfectos;
	LinkedHashSet<Carta> cartasDescartadas;
	LinkedHashSet<Carta> cartasMano;

	public Jugador(String nombre) {
		this.nombre = nombre;
		this.protegido = false;
		this.eliminado = false;
		this.rendido = false;
		this.simbolosAfectos = 0;
	}

	public void descartar(Carta c) {
		cartasMano.remove(c);
		cartasDescartadas.add(c);
	}

	public Carta tomarCarta(Carta c) {
		this.cartasMano.add(c);
		return c;
	}

	public void eliminar() {
		this.eliminado = true;
	}

	public void proteger() {
		this.protegido = true;
	}

	public void desproteger() {
		this.protegido = false;
	}

	public void rendirse() {
		this.rendido = true;
	}

	public boolean estaEliminado() {
		return this.eliminado;
	}

	public boolean estaRendido() {
		return this.rendido;
	}

	public int obtenerSimbolosAfectos() {
		return simbolosAfectos;
	}

	public LinkedHashSet<Carta> obtenerCartasDescartadas() {
		return cartasDescartadas;
	}

}
