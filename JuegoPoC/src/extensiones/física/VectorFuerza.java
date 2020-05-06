package extensiones.física;

import java.awt.Point;
import java.awt.Rectangle;

import javax.swing.JComponent;

public class VectorFuerza {
	int x;
	int y;
	
	public VectorFuerza() {
		this.x = 0;
		this.y = 0;
	}
	
	public VectorFuerza(int x, int y) {
		this.x = x;
		this.y = y;
	}
	
	public void aplicar(JComponent c) {
		// Se mueve y se consume la fuerza
		c.setLocation(
				dóndeEstará(c)
			);
		rozamiento();
	}
	
	public Point dóndeEstará(JComponent c) {
		Point p = c.getLocation();
		p.x += x;
		p.y += y;
		return p;
	}
	
	public Rectangle quéOcupará(JComponent c) {
		Rectangle r =  new Rectangle(dóndeEstará(c));
		r.width = c.getWidth();
		r.height= c.getHeight();
		return r;
	}
	
	public void rozamiento() {
		if(x>0)x--;
		if(x<0)x++;
		if(y>0)y--;
		if(y<0)y++;
	}
	
	public boolean quedaMovimiento() {
		return x != 0 || y !=0;
	}

	public void acabar() {
		x=0;
		y=0;
	}
}
