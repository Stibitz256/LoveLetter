package dominio.entidad;

import java.util.Iterator;
import java.util.LinkedHashSet;

import dominio.excepcion.CartaNoEncontrada;

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
	
	public int obtenerFuerza() {
		// TODO Auto-generated method stub
		int fuerza=0;
		Iterator<Carta>	listaCartas= this.cartasMano.iterator();
		while(listaCartas.hasNext()) {
			Carta carta= listaCartas.next();
			if(carta.getFuerza()>fuerza)
				fuerza= carta.getFuerza();
		}
		return fuerza;
	}
	
	public int incrementarSimbolosDeAfecto() {
		return ++simbolosAfectos;
	}
	
	public int obtenerCantCartasDescartadas() {
		// TODO Auto-generated method stub
		int cant=0;
		Iterator<Carta>	listaCartas= this.cartasDescartadas.iterator();
		while(listaCartas.hasNext()) {
			cant++;
		}
		return cant;
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

	public Carta tomarCarta(Carta carta) {
		this.cartasMano.add(carta);

		return carta;
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
	
	public Carta obtenerPrimeraCartaDeLaMano() throws CartaNoEncontrada {
		if(this.cartasMano.isEmpty()) {
			throw new CartaNoEncontrada();
		}
		
		return this.cartasMano.iterator().next();
	}
	
	public Carta obtenerUltimaCartaDescartada() throws CartaNoEncontrada {
		if(this.cartasDescartadas.isEmpty()) {
			throw new CartaNoEncontrada();
		}
		
		Iterator<Carta> cartasDescartadas = this.cartasDescartadas.iterator();
		Carta carta = null;
		while (cartasDescartadas.hasNext()) {
			carta = cartasDescartadas.next();
		}
		
		return carta;
	}

	@Override
	public String toString() {
		return "Jugador [nombre=" + nombre + ", protegido=" + protegido + ", eliminado=" + eliminado + ", rendido="
				+ rendido + ", simbolosAfectos=" + simbolosAfectos + ", cartasDescartadas=" + cartasDescartadas
				+ ", cartasMano=" + cartasMano + "]";
	}

}
