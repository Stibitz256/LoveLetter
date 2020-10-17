package dominio;


public class Jugador {
	String nombre;
	boolean protegido;
	boolean eliminado;
	boolean rendido;
	int simbolosAfectos;
	LinkedHashSet cartasDescartadas<Carta>;
	LinkedHashSet cartasMano<Carta>;

	public Jugador(String nombre) {
		this.nombre = nombre;
	}

	public Carta descartar(Carta) {
		
	}

//	public Carta tomarCarta(Carta) {
//		
//	}

	public void eliminar() {

	}

	public void proteger() {

	}

	public void desproteger() {

	}

	public void rendirse() {

	}

	public boolean estaEliminado() {

	}

	public boolean estaRendido() {

	}

	public int obtenerSimbolosAfectos() {

	}

	public LinkedHashSet<Carta> obtenerCartasDescartadas() {

	}


}
