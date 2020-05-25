package otros;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Examen1 implements ActionListener, MouseListener{
	JFrame ventana;
	JButton b;
	JPanel panel;
	JLabel l;
	
	int i;
	
	public Examen1() {
		i=0;
		
		ventana = new JFrame("Ejemplo de imagen");
		ventana.setSize(800, 400);
		ventana.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		
		panel = new JPanel();
		
		b = new JButton("add");
		b.addActionListener(this);
		
		l = new JLabel("0");
		l.addMouseListener(this);
		
		panel.add(b);
		panel.add(l);
		
		
		
		ventana.setContentPane(panel);

		ventana.setVisible(true);
	}
	
	public static void main(String[] args) {
		new Examen1();
	}
	
	public static boolean esPrimo(int numero){
		  int contador = 2;
		  boolean primo=true;
		  while ((primo) && (contador<numero)){
		    if (numero % contador == 0)
		      primo = false;
		    contador++;
		  }
		  return primo;
		}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		i++;
		while(!esPrimo(i)) {
			System.out.print(i);
			i++;
		}
		l.setText(""+i);
	}

	@Override
	public void mouseClicked(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	int last;
	@Override
	public void mouseEntered(MouseEvent arg0) {
		last = i;
		l.setText("Encima!");
	}

	@Override
	public void mouseExited(MouseEvent arg0) {
		// TODO Auto-generated method stub
		l.setText(""+last);
	}

	@Override
	public void mousePressed(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

}
