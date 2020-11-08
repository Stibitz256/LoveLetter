package cliente;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.LinkedList;

import com.google.gson.Gson;

import comandos.Comando;
import dominio.entidad.Carta;
import dominio.entidad.EnumerationCarta;
import dominio.entidad.Mazo;
import paquete.PaqueteCarta;
import paquete.PaqueteMesa;

public class ConexionServidor implements MouseListener {
	private Socket socket;
    private String usuario;
    private DataOutputStream salidaDatos;
	private Gson gson;
	private Mazo mazo;
	private EnumerationCarta carta;

    public ConexionServidor(Socket socket, String usuario) {
		this.socket = socket;
        this.usuario = usuario;
        gson = new Gson();
        try {
            this.salidaDatos = new DataOutputStream(socket.getOutputStream());
        } catch (IOException ex) {

        } catch (NullPointerException ex) {
        }
    }
    
    public void setMazo(Mazo mazo) {
    	this.mazo = mazo;
    }
    
    public void addCarta(EnumerationCarta carta) {
    	this.carta = carta;
    }
    
	@Override
	public void mouseClicked(MouseEvent e) {
		if(e.getY() >= 800-300 && e.getY() <=800-300+270) {
			System.out.println(e.getX());
			if(e.getX() >= 1200/2-200 && e.getX() <= 1200/2) {
				System.out.println("CARTA 1 DESCARTAR");
				try {
					this.salidaDatos.writeUTF(gson.toJson(new PaqueteCarta(Comando.JUGAR, this.carta), PaqueteCarta.class));
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			} else if(e.getX() >= 1200/2+30 && e.getX() <=1200/2+200+30*2) {
				System.out.println("CARTA 2 DESCARTAR");
			}
		}	
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		
	}

	@Override
	public void mouseExited(MouseEvent e) {

	}

	@Override
	public void mousePressed(MouseEvent e) {

	}

	@Override
	public void mouseReleased(MouseEvent e) {
		
	}
}
