package dominio;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Random;
import java.util.Set;

public class Mazo {

	private HashSet<Carta> cartas;

	public Mazo() {
		cartas = new HashSet<Carta>();
		
		
		cartas.add(new Mucama());
		cartas.add(new Mucama());
		
		cartas.add(new Rey());
		cartas.add(new Condesa());
		cartas.add(new Princesa());
		
		cartas.add(new Guardia());
		cartas.add(new Guardia());
		cartas.add(new Guardia());
		cartas.add(new Guardia());
		cartas.add(new Guardia());
		
		cartas.add(new Baron());
		cartas.add(new Baron());
		
		cartas.add(new Principe());
		cartas.add(new Principe());
		
		cartas.add(new Sacerdote());
		cartas.add(new Sacerdote());
	}

	public Carta obtenerCarta() throws Exception {
		Iterator<Carta> itr = cartas.iterator();  
	
		if(!itr.hasNext()) {
			throw new CartaNoEncontrada();
		}
		
		Carta carta = itr.next();
		cartas.remove(carta);
		
		return carta;
	}

}
