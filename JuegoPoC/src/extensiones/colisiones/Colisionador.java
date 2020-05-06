package extensiones.colisiones;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.JComponent;
import javax.swing.Timer;
import javax.swing.event.EventListenerList;

import extensiones.GameSounds;

public class Colisionador implements ActionListener {
	// Elijo el ancestro de JLabel, JButton
	// https://docs.oracle.com/javase/7/docs/api/javax/swing/package-tree.html
	// Uso polimorfismo, necesito objetos a los que les pueda mandar el mensaje getWitdh()
	ArrayList<JComponent> elementos;
	Timer timer;
	
	public static int TRIGGER_DETECTOR_EACH = 50;
	
	private Colisionador() {
		timer = new Timer(TRIGGER_DETECTOR_EACH, this);
		elementos = new ArrayList<JComponent>();
	}
	
	public void startDetection() {
		timer.start();
	}

	public void stopDetection() {
		timer.stop();
	}
	
	public void addElement(JComponent e) {
		elementos.add(e);
	}
	
	@Override
	public void actionPerformed(ActionEvent arg0) {
		// Detectar
		for(int i = 0; i< elementos.size();i++) {
			for(int j = i+1; j< elementos.size();j++) {
				JComponent c1 = elementos.get(i);
				JComponent c2 = elementos.get(j);
				if(c1.getBounds().intersects(c2.getBounds())) {
					ColisiónEvento ce = new ColisiónEvento(this, c1, c2);
					lanzarColisión(ce);
				}
			}
		}
	}
	
	/*
	 * Listado de manejadores
	 * Inspiración de: http://www.java2s.com/Tutorial/Java/0260__Swing-Event/CreatingaCustomEvent.htm
	 * */
	protected EventListenerList listenerList = new EventListenerList();

	public void addColsiónListener(ColisiónEscuchador listener) {
		listenerList.add(ColisiónEscuchador.class, listener);
	}
	public void removeColsiónListener(ColisiónEscuchador listener) {
		listenerList.remove(ColisiónEscuchador.class, listener);
	}
	void lanzarColisión(ColisiónEvento evt) {
		Object[] listeners = listenerList.getListenerList();
		for (int i = 0; i < listeners.length; i = i+2) {
			if (listeners[i] == ColisiónEscuchador.class) {
				((ColisiónEscuchador) listeners[i+1]).colsión(evt);
			}
		}
	}

	/*
	 * OJO: No todo tiene que tener Singletone pero los últimos ejemplos son elementos core del juego
	 * y me viene bien que haya solo uno y que sea accesible desde cualquier parte de código.
	 * 
	 * */
	
	/*
	 * Patrón Singletone
	 * - Buscar información sobre el patrón de diseño
	 * - Útil para que solo exista una instancia del objeto
	 * - Útil para conseguir una referencia desde cualquier parte del código a un objeto
	 * */
	
	private static Colisionador INSTANCE = null;
	
    public static Colisionador getInstance() {
        if (INSTANCE == null) INSTANCE = new Colisionador();
        return INSTANCE;
    }
}
