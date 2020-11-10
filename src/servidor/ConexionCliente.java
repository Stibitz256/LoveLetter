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
import comandos.Comando;
import dominio.entidad.Carta;
import dominio.entidad.EnumerationCarta;
import dominio.entidad.Jugador;
import dominio.entidad.Mazo;
import dominio.entidad.Partida;
import dominio.entidad.Ronda;
import dominio.excepcion.CartaNoEncontrada;
import paquete.PaqueteCarta;
import paquete.PaqueteMesa;

public class ConexionCliente extends Thread implements Observer {
	private Socket socket;
	private Mensaje mensaje;
	private DataInputStream entradaDatos;
	private DataOutputStream salidaDatos;
	private Gson gson;
	private boolean conectado;

	private Mazo mazo;
	private Jugador jugadorTurno;
	private Partida partida;
	private Ronda ronda;
	private TreeSet<Jugador> jugadores;
	private Carta carta;

	public ConexionCliente(Socket socket, Mensaje mensajes) throws CartaNoEncontrada {
		try {
			this.mensaje = mensajes;
			this.socket = socket;
			this.entradaDatos = new DataInputStream(socket.getInputStream());
			this.salidaDatos = new DataOutputStream(socket.getOutputStream());
			gson = new Gson();

			// comenzar partida directa
			TreeSet<Jugador> jugadores = new TreeSet<Jugador>();
			jugadores.add(new Jugador("Player1"));
			partida = new Partida(jugadores, 3);
			ronda = partida.inicializarPartida();
			ronda.repartirMazo();
			jugadorTurno = ronda.jugadorTurno();
			EnumerationCarta carta = EnumerationCarta.valueOf(jugadorTurno.obtenerPrimeraCartaDeLaMano().getNombre());

			salidaDatos.writeUTF(gson.toJson(new PaqueteCarta(Comando.MESA, carta)));
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

				PaqueteCarta paqueteCarta = gson.fromJson(mensajeRecibido, PaqueteCarta.class);
				Carta carta = jugadorTurno.obtenerCartaMano(paqueteCarta.getCarta());
				jugadorTurno.descartar(carta);
				this.carta = ronda.darCartaJugadorTurno();

				EnumerationCarta cartaEnumeration = EnumerationCarta.valueOf(this.carta.getNombre());
				salidaDatos.writeUTF(
						gson.toJson(new PaqueteCarta(Comando.MESA, cartaEnumeration)));
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
			} catch (CartaNoEncontrada e) {
				// TODO Auto-generated catch block
				
				// FIN DE RONDA
				
				e.printStackTrace();
			}
		}
	}

	private synchronized void refrescar() {
		Timer timer = new Timer(100, new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				System.out.println(e);
				/*
				 * mensaje.setMensaje( gson.toJson(new PaqueteCarta(Comando.MESA, );
				 */
			}
		});

		timer.start();
		timer.setRepeats(false);
	}

	@Override
	public void update(Observable o, Object arg) {
//		try {
		System.out.println("UPDATE" + arg.toString());
//			salidaDatos.writeUTF(arg.toString());
//		} catch (IOException e) {
//			e.printStackTrace();
//		}
	}

}