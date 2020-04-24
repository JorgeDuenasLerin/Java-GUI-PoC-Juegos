package básicos.misjpanel;

import java.awt.Color;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

import básicos.ConImagen;

@SuppressWarnings("serial")
public class PantallaMegaman extends JPanel{
	
	JLabel etiqueta1;
	JLabel etiqueta2;
	
	public PantallaMegaman() {
		etiqueta1 = new JLabel(new ImageIcon(ConImagen.class.getResource("/recursos/megaman.png")));
		etiqueta1.setBorder(BorderFactory.createLineBorder(Color.BLUE));
		
		etiqueta2 = new JLabel("Esto es el label de Megaman");
		this.add(etiqueta1);
	}
	
}
