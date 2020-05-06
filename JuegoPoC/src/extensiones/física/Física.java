package extensiones.física;

import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.HashMap;

import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;
import javax.swing.Timer;

import otros.Persona;

/***
 * 
 * @author Jorge Dueñas Lerín
 *
 *  Misma estrategia que en el colisionador (Singletone + timer)
 *    
 */
public class Física  implements ActionListener {
	// Mismas estrategias que en el colisionador
	HashMap<JComponent,ArrayList<VectorFuerza>> elementos;
	Timer timer;
	
	JPanel ventana;
	
	public static int PHYSICS_EACH = 10;
	
	private Física() {
		timer = new Timer(PHYSICS_EACH, this);
		elementos = new HashMap<JComponent,ArrayList<VectorFuerza>>();
	}
	
	public void estableceLímite(JPanel panelDeContenido) {
		this.ventana=panelDeContenido;
	}
	
	public void startFísica() {
		timer.start();
	}

	public void stopFísica() {
		timer.stop();
	}
	
	public void addElement(JComponent c) {
		// Creamos su espacio de fuerzas y le añadimos una gravedad
		ArrayList<VectorFuerza> fuerzaElemento = new ArrayList<VectorFuerza>();
		fuerzaElemento.add(new VectorGravedad());
		elementos.put(c, fuerzaElemento);		
	}
	
	public void addFuerza(JComponent c, VectorFuerza vectorFuerza) {
		elementos.get(c).add(vectorFuerza);
	}
	
	@Override
	public void actionPerformed(ActionEvent arg0) {
		for(JComponent c: elementos.keySet()) {
			ArrayList<VectorFuerza> fuerzas = elementos.get(c);
			for(VectorFuerza v : fuerzas) {
				//System.out.println(this.ventana.getBounds());
				//System.out.println(c.getBounds());
				if(this.ventana.getBounds().contains(v.quéOcupará(c))) {
					v.aplicar(c);
				} else {
					v.acabar();
				}
			}
			for(int i = 0; i < fuerzas.size()-1;) {
				VectorFuerza v = fuerzas.get(i);
				if(v.quedaMovimiento()) {
					i++;
				} else {
					fuerzas.remove(i);
				}
			}
			elementos.put(c, fuerzas);
		}
	}
	
	/*
	 * Patrón Singletone
	 * - Buscar información sobre el patrón de diseño
	 * - Útil para que solo exista una instancia del objeto
	 * - Útil para conseguir una referencia desde cualquier parte del código a un objeto
	 * */
	
	private static Física INSTANCE = null;
	
    public static Física getInstance() {
        if (INSTANCE == null) INSTANCE = new Física();
        return INSTANCE;
    }
}
