package servidor;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.Socket;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Observable;
import java.util.Observer;
import java.util.TreeSet;
import java.util.logging.Logger;

import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.Timer;

import com.google.gson.Gson;

import cliente.Mesa;
import dominio.entidad.Jugador;
import dominio.entidad.Mazo;
import paquete.PaqueteMesa;

public class ConexionCliente extends Thread implements Observer {
	private Socket socket;
	private Mensaje mensaje;
	private DataInputStream entradaDatos;
	private DataOutputStream salidaDatos;
	private Gson gson;
	private boolean conectado;

	public ConexionCliente(Socket socket, Mensaje mensajes) {
		try {
			this.mensaje = mensajes;
			this.socket = socket;
			this.entradaDatos = new DataInputStream(socket.getInputStream());
			this.salidaDatos = new DataOutputStream(socket.getOutputStream());
			gson = new Gson();

			salidaDatos.writeUTF(
					gson.toJson(new PaqueteMesa("3", new TreeSet<Jugador>(), new Mazo(), new Jugador("asd"))));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void run() {
		String mensajeRecibido;
		boolean conectado = true;
		mensaje.addObserver(this);

		while (conectado) {
			try {
				mensajeRecibido = entradaDatos.readUTF();
				System.out.println("MENSAJE RECIBIDO SERVER: " + mensajeRecibido.toString());
				PaqueteMesa mesa = gson.fromJson(mensajeRecibido, PaqueteMesa.class);
				// accion
				refrescar();
			} catch (IOException e) {
				conectado = false;
				// JOptionPane.showMessageDialog(null, "El cliente ha salido del servidor");
				try {
					entradaDatos.close();
					salidaDatos.close();
				} catch (IOException e1) {
					e1.printStackTrace();
				}
			}
		}
	}

	private synchronized void refrescar() {
		Timer timer = new Timer(100, new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				mensaje.setMensaje(
						gson.toJson(new PaqueteMesa("2", new TreeSet<Jugador>(), new Mazo(), new Jugador("juancho"))));
			}
		});

		timer.start();
		timer.setRepeats(false);
	}

	@Override
	public void update(Observable o, Object arg) {
		try {
			salidaDatos.writeUTF(arg.toString());
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}