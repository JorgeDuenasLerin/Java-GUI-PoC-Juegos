package básicos;

import java.awt.Color;
import java.awt.MouseInfo;
import java.awt.Point;
import java.awt.PointerInfo;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

import javax.imageio.ImageIO;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.Timer;

public class Colisión implements ActionListener{
	public static void main(String[] args) {
		new Colisión();
	}
	
	JLabel etiqueta1;
	JButton boton;
	JFrame ventana;
	Timer timer;
	
	int topSize=0;
	
	public Colisión() {
		ventana = new JFrame("Colisión");
		ventana.setSize(800, 400);
		ventana.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

		etiqueta1 = new JLabel(new ImageIcon(ConImagen.class.getResource("/recursos/rick_morty.png")));
		etiqueta1.setBorder(BorderFactory.createLineBorder(Color.BLUE));
		
		boton = new JButton("Movimiento");
				
		// Crear un contenedor
		JPanel panelDeContenido = new JPanel();

		// Asociar los componentes al contenedor para
		// que los muestre en su interior
		panelDeContenido.add(etiqueta1);
		panelDeContenido.add(boton);
		
		panelDeContenido.setComponentZOrder(etiqueta1, 1);
		panelDeContenido.setComponentZOrder(boton, 0);
		
		// Asociar el contenedor a la ventana para
		// que le muestre en su interior
		ventana.setContentPane(panelDeContenido);
		
		// Hacer visible la ventana
		ventana.setVisible(true);
		
		System.out.println("Frame Size   : " + ventana.getSize());
	    System.out.println("Frame Insets : " + ventana.getInsets());
	    System.out.println("Content Size : " + ventana.getContentPane().getSize());
	    topSize = ventana.getInsets().top;
	    
	    timer = new Timer(20, this );
	    
	    ventana.addWindowListener(new WindowListener() {
			
			@Override
			public void windowOpened(WindowEvent arg0) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void windowIconified(WindowEvent arg0) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void windowDeiconified(WindowEvent arg0) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void windowDeactivated(WindowEvent arg0) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void windowClosing(WindowEvent arg0) {
				// TODO Auto-generated method stub
				timer.stop();
			}
			
			@Override
			public void windowClosed(WindowEvent arg0) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void windowActivated(WindowEvent arg0) {
				// TODO Auto-generated method stub
				
			}
		});
	    
	    timer.start();
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		Point mouse = ventana.getMousePosition();
		if(mouse != null) { // Si el raon no está devuelve null
			int x = (int) (mouse.getX() - (boton.getWidth()/2));
			int y = (int) ((mouse.getY()-topSize) - (boton.getHeight()/2));
			//System.out.println(x + " " + y);
			boton.setLocation(x, y);
		}
		
		if(boton.getBounds().intersects(etiqueta1.getBounds())) {
			System.out.print("*");
		} else {
			System.out.println(".");
		}
	}
}
