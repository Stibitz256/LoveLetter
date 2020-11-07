package dominio.excepcion;

public class CondesaEnMano extends Exception {
	public CondesaEnMano() {
		super("no se puede descartar el rey o el principe ya que tenes en mano una condesa");
	}

}
