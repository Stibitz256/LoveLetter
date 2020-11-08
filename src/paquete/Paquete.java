package paquete;

public class Paquete {

	String comando;
	
	public Paquete() {
		
	}
	
	public Paquete(String comando) {
		this.comando = comando;
    }

	public String getComando() {
		return comando;
	}

	public void setComando(String comando) {
		this.comando = comando;
	}
}