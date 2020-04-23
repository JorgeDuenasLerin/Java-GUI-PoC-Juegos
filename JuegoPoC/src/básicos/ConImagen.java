package básicos;
import java.awt.Color;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;


public class ConImagen {
	
	public static void main(String[] args) {

		// Crear la ventana de la aplicacion
		JFrame ventana = new JFrame("Ejemplo de imagen");
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