package básicos;

import java.awt.Color;
import java.awt.Image;
import java.awt.Rectangle;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
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

public class Movimiento implements KeyListener {
	
	public static void main(String[] args) throws IOException {
		new Movimiento();
	}
	
	BufferedImage img;
	JLabel etiqueta1;
	int x, y;
	
	public Movimiento () throws IOException {
		
		// Crear la ventana de la aplicacion
		JFrame ventana = new JFrame("Titulo de la ventana");
		ventana.setSize(800, 400);
		ventana.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

		// Crear los componentes
		img = ImageIO.read(ConImagen.class.getResource("/recursos/tank.png"));
		etiqueta1 = new JLabel(new ImageIcon(img));
		
		etiqueta1.setBorder(BorderFactory.createLineBorder(Color.red));
		etiqueta1.setForeground(Color.BLUE);
				
		// Crear un contenedor
		JPanel panelDeContenido = new JPanel();

		// Asociar los componentes al contenedor para
		// que los muestre en su interior
		panelDeContenido.add(etiqueta1);

		
		
		panelDeContenido.setLayout(null); // Pintamos las cosas nosotros
		// Ya no coloca sola el label, debemos darle una posición
		x = 100;
		y = 100;
		etiqueta1.setBounds(x, y, img.getHeight(), img.getHeight());
		
		
		// Asociar el contenedor a la ventana para
		// que le muestre en su interior
		ventana.setContentPane(panelDeContenido);
		
		
		
		ventana.addKeyListener(this);
		
		// Hacer visible la ventana
		ventana.setVisible(true);
	}
	
	/**
	 * Información sacada de:
	 * 	https://es.wikipedia.org/wiki/Vuelta_(%C3%A1ngulo)
	 *  https://stackoverflow.com/a/4918576/932888
	 * @param i
	 * @param radianes
	 * @return
	 */
	private Image rotarRadianes(double radianes, BufferedImage i) {
		AffineTransform transform = new AffineTransform();
	    transform.rotate(radianes, i.getWidth()/2, i.getHeight()/2);
	    AffineTransformOp op = new AffineTransformOp(transform, AffineTransformOp.TYPE_BILINEAR);
	    Image newImage = op.filter(img, null);
		return newImage;
	}

	@Override
	public void keyPressed(KeyEvent arg0) {
		int k = arg0.getKeyCode();
		Rectangle r = etiqueta1.getBounds();
		double radianesRotación = 0;
		// Códigos: 37,38,39,40
		
		switch(k) {
			case 37:
				radianesRotación = -Math.PI/2;
			    r.x-=5;
				break;
			case 38:
				radianesRotación = 0;
			    r.y-=5;
				break;
			case 39:
				radianesRotación = Math.PI/2;
			    r.x+=5;
				break;
			case 40:
				radianesRotación = Math.PI;
			    r.y+=5;
				break;
		}
		
		etiqueta1.setIcon(new ImageIcon(rotarRadianes(radianesRotación, img)));
		etiqueta1.setBounds(r);
	}

	@Override
	public void keyReleased(KeyEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyTyped(KeyEvent arg0) {
		// TODO Auto-generated method stub
		
	}
}
