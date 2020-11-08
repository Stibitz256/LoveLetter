package paquete;

import dominio.entidad.EnumerationCarta;

public class PaqueteCarta extends Paquete {
	private EnumerationCarta carta;
	
	public PaqueteCarta(String comando, EnumerationCarta carta) {
		super(comando);
		this.carta = carta;
	}

	public EnumerationCarta getCarta() {
		return carta;
	}
}
