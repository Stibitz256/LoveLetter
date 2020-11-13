package cliente;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.TreeSet;

import javax.imageio.ImageIO;
import javax.swing.JPanel;

import dominio.entidad.EnumerationCarta;
import dominio.entidad.Jugador;
import dominio.entidad.Mazo;

public class Mesa extends JPanel {

	private int mazoTam = 16;
	private final BufferedImage mazo;
	private final BufferedImage mesa;
	private BufferedImage[] cartasImagen;
	private EnumerationCarta[] cartas;
	///////////
	private BufferedImage cartel;

	///////////
	public Mesa() throws IOException {
		mazo = ImageIO.read(new File("./img/cartas/back.png"));
		mesa = ImageIO.read(new File("./img/mesa/table.jpg"));
		cartasImagen = new BufferedImage[2];
		cartasImagen[0] = ImageIO.read(new File("./img/cartas/back.png"));
		cartasImagen[1] = ImageIO.read(new File("./img/cartas/back.png"));
		this.cartas = new EnumerationCarta[2];
		cartel = null;
	}

	public void setMazo(Mazo mazo) {
		mazoTam = mazo.obtenerCantidadDeCartas();
	}

	public void setJugadores(TreeSet<Jugador> jugadores) {

	}

	public void removerCarta(int numero) {
		this.cartas[numero] = null;
	}

	public void addCarta(EnumerationCarta carta) throws IOException {
		if (this.cartas[0] == null) {
			this.cartas[0] = carta;
			cartasImagen[0] = ImageIO.read(new File("./img/cartas/" + carta.name() + ".png"));
		} else {
			this.cartas[1] = carta;
			cartasImagen[1] = ImageIO.read(new File("./img/cartas/" + carta.name() + ".png"));
		}
	}

	public EnumerationCarta[] getCarta() {
		return this.cartas;
	}

	////////////////////////////////////////////////////////////
	public void cartelFinDeJuego() throws IOException {

		this.cartel = ImageIO.read(new File("./img/carteles/findejuego.png"));

	}

	////////////////////////////////////////////////////////////

	public synchronized void paintComponent(Graphics g) {
		super.paintComponent(g);
		setBackground(new Color(52, 108, 108));

		dibujarMesa(g);
		dibujarMazo(g);
		dibujarCartas(g);
		////////////////
		dibujarCartel(g);
		//////////////

	}

	////////////////////////////////////////////////////////
	private synchronized void dibujarCartel(Graphics g) {
		Graphics2D g2 = (Graphics2D) g;
		if (cartel != null)
			g2.drawImage(cartel, this.getSize().width / 2 - cartel.getWidth() / 2,
					this.getSize().height / 2 - cartel.getHeight() / 2, cartel.getWidth(), cartel.getHeight(), null);
	}

	////////////////////////////////////////////////////////
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
		for (BufferedImage carta : cartasImagen) {
			width -= 200;
			g2.drawImage(carta, width, heigth, 200, 270, null);
			width += 200 * cartasImagen.length + 30 * cartasImagen.length;
		}
	}

}