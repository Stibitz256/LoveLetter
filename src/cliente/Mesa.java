package cliente;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.AffineTransform;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.TreeSet;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JPanel;

import dominio.entidad.Carta;
import dominio.entidad.EnumerationCarta;
import dominio.entidad.Jugador;
import dominio.entidad.Mazo;

public class Mesa extends JPanel {

	private int mazoTam = 16;
	private final BufferedImage mazo;
	private final BufferedImage mesa;
	private BufferedImage[] cartas;
	private EnumerationCarta carta;

	public Mesa() throws IOException {
		mazo = ImageIO.read(new File("./img/cartas/back.png"));
		mesa = ImageIO.read(new File("./img/mesa/table.jpg"));
		cartas = new BufferedImage[2];
		cartas[0] = ImageIO.read(new File("./img/cartas/guard.png"));
		cartas[1] = ImageIO.read(new File("./img/cartas/king.png"));
	}
	
	public void setMazo(Mazo mazo) {
		mazoTam = mazo.obtenerCantidadDeCartas();
	}
	
	public void setJugadores(TreeSet<Jugador> jugadores) {
		
	}
	
	public void addCarta(EnumerationCarta carta) {
		this.carta = carta;
	}

	public synchronized void paintComponent(Graphics g) {
		super.paintComponent(g);
		setBackground(new Color(52, 108, 108));

		dibujarMesa(g);
		dibujarMazo(g);
		dibujarCartas(g);

	}

	private synchronized void dibujarMazo(Graphics g) {
		Graphics2D g2 = (Graphics2D) g;
		int posX = this.getSize().width / 2 - mazo.getWidth() / 3 / 2;
		int posY = 20;
		for (int i = 0; i < mazoTam; i++) {
			g2.drawImage(this.mazo, posX + i, posY + i, mazo.getWidth() / 3, mazo.getHeight() / 3, null);
		}
	}

	private synchronized void dibujarMesa(Graphics g) {
		Graphics2D g2 = (Graphics2D) g;
		g2.drawImage(this.mesa, 0, 0, this.getSize().width, this.getSize().height, null);
	}

	private synchronized void dibujarCartas(Graphics g) {
		Graphics2D g2 = (Graphics2D) g;
		int width = this.getSize().width / 2;
		int heigth = this.getSize().height - 300;
		for (BufferedImage carta : cartas) {
			width -= 200;
			g2.drawImage(carta, width, heigth, 200, 270, null);
			width += 200 * cartas.length + 30 * cartas.length;
		}
	}
	
}