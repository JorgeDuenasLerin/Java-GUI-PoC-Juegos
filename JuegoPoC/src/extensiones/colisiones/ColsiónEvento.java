package extensiones.colisiones;

import java.util.EventObject;

import javax.swing.JComponent;

public class ColsiónEvento extends EventObject {
	JComponent c1;
	JComponent c2;
	
	public ColsiónEvento(Object source, JComponent c1, JComponent c2) {
		// Quién lo genera
	    super(source);
	    
	    this.c1 = c1;
	    this.c2 = c2;
	}
	
	public JComponent getComponentA() {
		return c1;
	}
	
	public JComponent getComponentB() {
		return c2;
	}
}
