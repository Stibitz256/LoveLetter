package cliente;

import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JPanel;

public class Mesa extends JPanel {
    
    public Mesa() {
        
    }
    
    public synchronized void paintComponent(Graphics g) {
        super.paintComponent(g);
        setBackground(new Color(52, 108, 108));

    }    
}