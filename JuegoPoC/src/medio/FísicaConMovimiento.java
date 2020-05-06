package medio;

import java.awt.Color;
import java.awt.Image;
import java.awt.Point;
import java.awt.Rectangle;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.awt.geom.AffineTransform;
import java.awt.image.AffineTransformOp;
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import básicos.ConImagen;
import extensiones.física.Física;
import extensiones.física.VectorFuerza;

public class FísicaConMovimiento implements KeyListener, WindowListener {
	
	public static void main(String[] args) throws IOException {
		new FísicaConMovimiento();
	}
	
	JLabel etiqueta1;
	Física phy;
	
	public FísicaConMovimiento () throws IOException {
		
		// Crear la ventana de la aplicacion
		JFrame ventana = new JFrame("Física con movimiento");
		ventana.setSize(800, 400);
		ventana.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

		// Crear los componentes
		
		
		etiqueta1 = new JLabel(new ImageIcon(FísicaConMovimiento.class.getResource("/recursos/tortuga.png")));
		
		etiqueta1.setBorder(BorderFactory.createLineBorder(Color.red));
		etiqueta1.setForeground(Color.BLUE);
				
		// Crear un contenedor
		JPanel panelDeContenido = new JPanel();

		// Asociar los componentes al contenedor para
		// que los muestre en su interior
		panelDeContenido.add(etiqueta1);

		
		
		panelDeContenido.setLayout(null); // Pintamos las cosas nosotros
		// Ya no coloca sola el label, debemos darle una posición
		etiqueta1.setBounds(200, 200, 150, 78);
		
		
		// Asociar el contenedor a la ventana para
		// que le muestre en su interior
		ventana.setContentPane(panelDeContenido);
		ventana.addKeyListener(this);
		
		// Hacer visible la ventana
		ventana.setVisible(true);
		
		ventana.addWindowListener(this);
		
		phy = Física.getInstance();
		
		phy.estableceLímite(panelDeContenido);
		
		phy.addElement(etiqueta1);
		phy.startFísica();
	}

	@Override
	public void keyPressed(KeyEvent arg0) {
		int k = arg0.getKeyCode();
		
		if(arg0.getKeyCode() == KeyEvent.VK_W) {
			phy.addFuerza(etiqueta1, new VectorFuerza(0, -10));
        }   
        if(arg0.getKeyCode() == KeyEvent.VK_A) {
        	phy.addFuerza(etiqueta1, new VectorFuerza(-15, 0));
        }   
        if(arg0.getKeyCode() == KeyEvent.VK_S) {
        	//phy.addFuerza(etiqueta1, new VectorFuerza(5, 0));
        }   
        if(arg0.getKeyCode() == KeyEvent.VK_D) {
        	phy.addFuerza(etiqueta1, new VectorFuerza(15, 0));
        }   
		
		/*
		 * 
		 * SIN FÍSICA
		 * 
		 * */
		// Códigos: 37,38,39,40
		Point p = etiqueta1.getLocation();
		switch(k) {
			case 37:
			    p.x-=5;
				break;
			case 38:
			    p.y-=5;
				break;
			case 39:
			    p.x+=5;
				break;
			case 40:
			    p.y+=5;
				break;	
		}
		etiqueta1.setLocation(p);
	}
	
	
	
	
	
	

	@Override
	public void keyReleased(KeyEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyTyped(KeyEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowActivated(WindowEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowClosed(WindowEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowClosing(WindowEvent arg0) {
		// TODO Auto-generated method stub
		phy.stopFísica();
	}

	@Override
	public void windowDeactivated(WindowEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowDeiconified(WindowEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowIconified(WindowEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowOpened(WindowEvent arg0) {
		// TODO Auto-generated method stub
		
	}
}
