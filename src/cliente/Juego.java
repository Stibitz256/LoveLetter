package cliente;

import java.io.DataInputStream;
import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.logging.Logger;

import javax.swing.JFrame;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import paquete.PaqueteMesa;

public class Juego extends JFrame {

	private Socket socket;
	private int puerto;
	private String host;
	private Mesa contentPane;
	private Gson gson;
	private GsonBuilder builder;
	private DataInputStream entradaDatos;
	static final int ALTO = 1200;
	static final int ANCHO = 800;

	public Juego() throws IOException {
		super("LoveLetter");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(0, 0, 1200, 800);
		setLocationRelativeTo(null);
		setResizable(false);
		setTitle("LoveLetter");
		setSize(Juego.ALTO, Juego.ANCHO);
		this.setVisible(true);

		contentPane = new Mesa();
		setContentPane(contentPane);

		host = "localhost";
		puerto = 59002;

		try {
			socket = new Socket(host, puerto);
			entradaDatos = new DataInputStream(socket.getInputStream());
			System.out.println(entradaDatos.readUTF().toString());
			System.out.println("PaqueMesaCliente");
//            PaqueteMesa paquete = gson.fromJson(entradaDatos.readUTF(), PaqueteMesa.class);
//            System.out.println("PaqueMesaCliente: " + paquete.getMazo().toString());
//            contentPane.setMazo(paquete.getMazo());
//            System.out.println(paquete.getJugadores().toString());
//            contentPane.setJugadores(paquete.getJugadores());
		} catch (UnknownHostException e) {
			System.out.println("error: " + e);
			e.printStackTrace();
		} catch (IOException e) {
			System.out.println("error: " + e);
			e.printStackTrace();
		} catch (Exception e) {
			System.out.println("error: " + e);
		}

		this.addMouseListener(new ConexionServidor(socket, host));
	}

	public synchronized void recibirMensajeServidor() {
		String mensaje;
		boolean conectado = true;
		while (conectado) {
//			try {
//				mensaje = entradaDatos.readUTF();
//				System.out.println(mensaje.toString());
//				PaqueteMesa paquete = gson.fromJson(mensaje, PaqueteMesa.class);
				contentPane.repaint();
//			} catch (IOException e) {
//				conectado = false;
//				e.printStackTrace();
//			}
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
					juego.contentPane.repaint();
				}

			}
		});
		hilo.start();
	}
}
