package otros;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.Border;

public class Examen2 implements ActionListener, MouseListener{

	JFrame ventana;
	JButton b1, b2;
	JPanel panel;
	JLabel l;
	
	StringBuilder s;
	int i = 7;
	
	public Examen2 () {
		
		ventana = new JFrame("Ejemplo de imagen");
		ventana.setSize(800, 400);
		ventana.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		
		panel = new JPanel();
		
		s = new StringBuilder("-------0-------");
		
		b1 = new JButton("-");
		l = new JLabel(s.toString());
		b2 = new JButton("+");
		
		b1.addActionListener(this);
		b2.addActionListener(this);
		l.addMouseListener(this);
		
		panel.add(b1);
		panel.add(l);
		panel.add(b2);
		
		ventana.setContentPane(panel);
		ventana.setVisible(true);
	}
	
	public static void main(String[] args) {
		new Examen2();
	}

	@Override
	public void mouseClicked(MouseEvent arg0) {
		
	}

	Border b;
	@Override
	public void mouseEntered(MouseEvent arg0) {
		b = l.getBorder();
		l.setBorder(BorderFactory.createLineBorder(Color.BLUE, 5));
	}

	@Override
	public void mouseExited(MouseEvent arg0) {
		l.setBorder(b);
		
	}

	@Override
	public void mousePressed(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		if(arg0.getSource().equals(b1)) {
			if(i>0) {
				s.replace(i, i+1, "-");
				i--;
				s.replace(i, i+1, "0");
				l.setText(s.toString());
			}
		}
		if(arg0.getSource().equals(b2)) {
			if(i<14) {
				s.replace(i, i+1, "-");
				i++;
				s.replace(i, i+1, "0");
				l.setText(s.toString());
			}
		}
	}

}
