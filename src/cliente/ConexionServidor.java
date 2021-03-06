package cliente;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.LinkedList;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import comandos.Comando;
import dominio.entidad.Carta;
import dominio.entidad.EnumerationCarta;
import dominio.entidad.Mazo;
import paquete.Paquete;
import paquete.PaqueteCarta;
import paquete.PaqueteCartaDeserializer;
import paquete.PaqueteMesa;

public class ConexionServidor implements MouseListener {
	private Socket socket;
	private DataOutputStream salidaDatos;
	private DataInputStream entradaDatos;
	private Gson gson;
	private GsonBuilder builder;
	private Mesa mesa;

	public ConexionServidor(String host, int puerto, Mesa mesa) throws UnknownHostException, IOException {
		this.socket = new Socket(host, puerto);
		this.mesa = mesa;

		builder = new GsonBuilder();
		builder.registerTypeAdapter(PaqueteCarta.class, new PaqueteCartaDeserializer());
		gson = builder.create();

		this.entradaDatos = new DataInputStream(socket.getInputStream());
		this.salidaDatos = new DataOutputStream(socket.getOutputStream());
	}

	public void leer() throws IOException {
		String mensaje = this.entradaDatos.readUTF();
		System.out.println("leer: " + mensaje.toString());

		PaqueteCarta paquete = gson.fromJson(mensaje, PaqueteCarta.class);
		//////////////////////////////////////////////////////////////
		if (paquete.getComando().equals("3")) {
			this.mesa.cartelFinDeJuego();
			this.mesa.repaint();
		} else {
			//////////////////////////////////////////////////////////////
			this.mesa.addCarta(paquete.getCarta());
			this.mesa.repaint();
		}
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		if (e.getY() >= 800 - 300 && e.getY() <= 800 - 300 + 270) {
			System.out.println(e.getX());
			if (e.getX() >= 1200 / 2 - 200 && e.getX() <= 1200 / 2) {
				System.out.println("CARTA 1 DESCARTAR");
				try {
					this.mesa.removerCarta(0);
					this.salidaDatos.writeUTF(
							gson.toJson(new PaqueteCarta(Comando.JUGAR, this.mesa.getCarta()[0]), PaqueteCarta.class));

				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			} else if (e.getX() >= 1200 / 2 + 30 && e.getX() <= 1200 / 2 + 200 + 30 * 2) {
				System.out.println("CARTA 2 DESCARTAR");
				try {
					this.mesa.removerCarta(1);
					this.salidaDatos.writeUTF(
							gson.toJson(new PaqueteCarta(Comando.JUGAR, this.mesa.getCarta()[1]), PaqueteCarta.class));

				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
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
