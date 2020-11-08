package cliente;

import java.io.DataInputStream;
import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.logging.Logger;

import javax.swing.JFrame;

//import com.google.gson.Gson;
//import com.google.gson.GsonBuilder;


public class Juego extends JFrame {

    private Socket socket;
    private int puerto;
    private String host;
    private Mesa contentPane;
//    private Gson gson;
//    private GsonBuilder builder;
    private DataInputStream entradaDatos;
    static final int ALTO = 21;
    static final int ANCHO = 21;
    static final int BLOCK_SIZE = 32;

    public Juego() {
        super("LoveLetter");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(0, 0, 800, 600);
        setLocationRelativeTo(null);
        setResizable(false);
        setTitle("LoveLetter");
        setSize(800, 600);
        this.setVisible(true);
        
        contentPane = new Mesa();
        setContentPane(contentPane);
    }
    
    public synchronized void recibirMensajeServidor() {
//        String mensaje;
//        boolean conectado = true;
//        while (conectado) {
//            try {
//                mensaje = entradaDatos.readUTF();
////                Paquete paquete = gson.fromJson(mensaje, Paquete.class);
//                contentPane.repaint();
//            } catch (IOException e) {
//                conectado = false;
//                e.printStackTrace();
//            }
//        }
    }

    public static void main(String[] args) {
    	Juego juego = new Juego();
    	juego.setVisible(true);
//        Thread hilo = new Thread(new Runnable() {
//
//            @Override
//            public void run() {
//                while (true) {
//                    try {
//                        Thread.sleep(30);
//                        juego.recibirMensajeServidor();
//                    } catch (InterruptedException e) {
//                        Logger.getLogger("Error");
//                    }
//                    juego.contentPane.repaint();
//                }
//
//            }
//        });
//        hilo.start();
    }
}
