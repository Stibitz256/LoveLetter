package paquete;

import dominio.entidad.EnumerationCarta;

public class PaqueteCarta {
	protected String comando;
	private EnumerationCarta carta;
	
	public PaqueteCarta(String comando, EnumerationCarta carta) {
		this.comando = comando;
		this.carta = carta;
	}

	public EnumerationCarta getCarta() {
		return carta;
	}
	
	public String getComando() {
		return comando;
	}

	public void setComando(String comando) {
		this.comando = comando;
	}
	
	public void setCarta(EnumerationCarta carta) {
		this.carta = carta;
	}

}
