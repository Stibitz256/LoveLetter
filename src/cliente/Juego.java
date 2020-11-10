package cliente;

import java.io.DataInputStream;
import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.logging.Logger;

import javax.swing.JFrame;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import dominio.entidad.EnumerationCarta;
import paquete.PaqueteCarta;
import paquete.PaqueteCartaDeserializer;
import paquete.PaqueteMesa;

public class Juego extends JFrame {

	private int puerto;
	private String host;
	private Mesa mesa;

	static final int ALTO = 1200;
	static final int ANCHO = 800;
	private ConexionServidor conexion;

	public Juego() throws IOException {
		super("LoveLetter");

		host = "localhost";
		puerto = 59002;
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(0, 0, 1200, 800);
		setLocationRelativeTo(null);
		setResizable(false);
		setTitle("LoveLetter");
		setSize(Juego.ALTO, Juego.ANCHO);
		this.setVisible(true);
		
		try {
			
			mesa = new Mesa();
			setContentPane(mesa);
			this.conexion = new ConexionServidor(host, puerto, mesa);
			this.addMouseListener(this.conexion);
			
		} catch (UnknownHostException e) {
			
			System.out.println("error: " + e);
			e.printStackTrace();
			
		} catch (IOException e) {
			
			System.out.println("error: " + e);
			e.printStackTrace();
			
		} catch (Exception e) {
			
			System.out.println("error: " + e);
		}

	}

	public synchronized void recibirMensajeServidor() {
		String mensaje;
		boolean conectado = true;
		while (conectado) {
			try {
				this.conexion.leer();
				
			} catch (IOException e) {
				conectado = false;
				System.out.println("conexion leer exception");
				e.printStackTrace();
			}
		}
	}

	public static void main(String[] args) throws IOException {
		Juego juego = new Juego();
		juego.setVisible(true);
		Thread hilo = new Thread(new Runnable() {

			@Override
			public void run() {
				while (true) {
					try {
						Thread.sleep(30);
						juego.recibirMensajeServidor();
					} catch (InterruptedException e) {
						System.out.println(e);
					}
				}

			}
		});
		hilo.start();
	}
}
