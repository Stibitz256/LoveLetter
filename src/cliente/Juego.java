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
    static final int ALTO = 21;
    static final int ANCHO = 21;
    static final int BLOCK_SIZE = 32;

    public Juego() throws IOException {
        super("LoveLetter");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(0, 0, 1200, 800);
        setLocationRelativeTo(null);
        setResizable(false);
        setTitle("LoveLetter");
        setSize(1200, 800);
        this.setVisible(true);
        
        contentPane = new Mesa();
        setContentPane(contentPane);
        
        host = "localhost";
        puerto = 59002;
        
        try {
            socket = new Socket(host, puerto);
            entradaDatos = new DataInputStream(socket.getInputStream());
            System.out.println(entradaDatos.readUTF());
//            PaqueteMesa paquete = gson.fromJson(entradaDatos.readUTF(), PaqueteMesa.class);
//            contentPane.setMazo(paquete.getMazo());
//            contentPane.setJugadores(paquete.getJugadores());
        } catch (UnknownHostException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        
        this.addMouseListener(new ConexionServidor(socket, host));
    }
    
    public synchronized void recibirMensajeServidor() {
        String mensaje;
        boolean conectado = true;
        while (conectado) {
            try {
                mensaje = entradaDatos.readUTF();
                System.out.println(mensaje);
                //PaqueteMesa paquete = gson.fromJson(mensaje, PaqueteMesa.class);
                contentPane.repaint();
            } catch (IOException e) {
                conectado = false;
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
                    juego.contentPane.repaint();
                }

            }
        });
        hilo.start();
    }
}
