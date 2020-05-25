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

public class Examen3 implements ActionListener, MouseListener{

	JFrame ventana;
	JButton b1, b2, b3, b4;
	JPanel panel;
	JLabel l;
	
	public Examen3 () {
		
		ventana = new JFrame("Ejemplo de imagen");
		ventana.setSize(800, 400);
		ventana.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		
		panel = new JPanel();
		
		b1 = new JButton("<-");
		b2 = new JButton("0");
		b3 = new JButton("1");
		l = new JLabel("");
		
		b1.addActionListener(this);
		b2.addActionListener(this);
		b3.addActionListener(this);
		
		panel.add(b1);
		panel.add(b2);
		panel.add(b3);
		panel.add(l);
		
		l.addMouseListener(this);
		panel.add(l);
		
		ventana.setContentPane(panel);
		ventana.setVisible(true);
	}
	
	public static void main(String[] args) {
		new Examen3();
	}

	@Override
	public void mouseClicked(MouseEvent arg0) {
		
	}

	String stmp;
	@Override
	public void mouseEntered(MouseEvent arg0) {
		stmp = l.getText();
		int foo = Integer.parseInt(stmp, 2);
		l.setText(""+foo);
	}

	@Override
	public void mouseExited(MouseEvent arg0) {
		l.setText(stmp);
	}

	@Override
	public void mousePressed(MouseEvent arg0) {

	}

	@Override
	public void mouseReleased(MouseEvent arg0) {

	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		String s = l.getText();
		if(arg0.getSource().equals(b1)) {
			if(s.length()>0) {
				l.setText(s.substring(0, s.length()-1));
			}
		}
		if(arg0.getSource().equals(b2)) {
			l.setText(l.getText()+"0");
		}
		if(arg0.getSource().equals(b3)) {
			l.setText(l.getText()+"1");
		}
	}

}
