package servidor;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;

import cliente.Mesa;
import dominio.excepcion.CartaNoEncontrada;


public class Juego {

	private static Mesa mesa;
	private static ServerSocket servidor = null;
	
	public static void main(String[] args) throws CartaNoEncontrada {
		Socket socket = null;
		Mensaje mensajes = new Mensaje();
		
		try {
			int puerto = 59002;
			servidor = new ServerSocket(puerto);
			System.out.println("Servidor funcionando en el puerto: " + puerto);
			
			while (true) {
				socket = servidor.accept();
				System.out.println("Nuevo usuario se ha conectado");
				ConexionCliente cc = new ConexionCliente(socket, mensajes);
				cc.start();
			}
		} catch (IOException e) {
			System.err.println("Error en el servidor");
			e.printStackTrace();
		} finally {
			try {
				socket.close();
				servidor.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
}
