package dominio.entidad;

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
		this.cartasMano = new LinkedHashSet<Carta>();
		this.cartasDescartadas = new LinkedHashSet<Carta>();
	}

	public void descartar(Carta carta) {
		cartasMano.remove(carta);
		cartasDescartadas.add(carta);
	}

	public Carta descartar() {
		Carta carta = cartasMano.iterator().next();
		cartasMano.remove(carta);
		cartasDescartadas.add(carta);

		return carta;
	}
	
	public Carta darCarta() {
		Carta carta = cartasMano.iterator().next();
		cartasMano.remove(carta);
		
		return carta;
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

	public boolean estaProtegido() {
		return this.protegido;
	}

	public int obtenerSimbolosAfectos() {
		return simbolosAfectos;
	}
	
	public LinkedHashSet<Carta> obtenerCartasDeLaMano() {
		return this.cartasMano;
	}

	public LinkedHashSet<Carta> obtenerCartasDescartadas() {
		return cartasDescartadas;
	}

}
