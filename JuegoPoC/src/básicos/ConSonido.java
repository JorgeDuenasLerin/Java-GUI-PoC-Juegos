package básicos;

import java.awt.Color;
import java.io.IOException;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class ConSonido {
	public static void main(String[] args) {
		try {
			new ConSonido();
		} catch (UnsupportedAudioFileException | IOException | LineUnavailableException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public ConSonido() throws UnsupportedAudioFileException, IOException, LineUnavailableException {  
		AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(ConSonido.class.getResource("/recursos/mario.wav"));
		Clip clip = AudioSystem.getClip();
		clip.open(audioInputStream);
		clip.start();
		
		// Crear la ventana de la aplicacion
		JFrame ventana = new JFrame("Ejemplo de sonido");
		ventana.setSize(800, 400);
		ventana.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

		// Crear los componentes
		// Acceso relativo al proyecto para que al exportarlo este la imagen
		// La imagen debe estar dentro de una carpeta "recursos"
		JLabel etiqueta1 = new JLabel(new ImageIcon(ConImagen.class.getResource("/recursos/rick_morty.png")));
		etiqueta1.setBorder(BorderFactory.createLineBorder(Color.BLUE));
				
		// Crear un contenedor
		JPanel panelDeContenido = new JPanel();

		// Asociar los componentes al contenedor para
		// que los muestre en su interior
		panelDeContenido.add(etiqueta1);

		// Asociar el contenedor a la ventana para
		// que le muestre en su interior
		ventana.setContentPane(panelDeContenido);

		// Hacer visible la ventana
		ventana.setVisible(true);
	}
}
