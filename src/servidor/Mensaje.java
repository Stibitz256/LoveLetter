package servidor;

import java.util.Observable;

public class Mensaje extends Observable {

    private String mensaje;
    
    public Mensaje() {
    }
    
    public String getMensaje() {
        return mensaje;
    }

    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
        this.setChanged();
        this.notifyObservers(mensaje);
    }
}