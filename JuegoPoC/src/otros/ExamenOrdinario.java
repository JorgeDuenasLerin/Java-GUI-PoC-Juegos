package otros;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class ExamenOrdinario implements ActionListener, MouseListener{
	JFrame ventana;
	
	
	JPanel panel;
	
	JButton bi;
	JLabel li;
	
	JButton bd;
	JLabel ld;
	
	JLabel lr;

	public ExamenOrdinario () {
		ventana = new JFrame("Examen");
		ventana.setSize(800, 400);
		ventana.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		
		panel = new JPanel();
		
		bi = new JButton("add");
		bi.addActionListener(this);
		
		li = new JLabel("0");

		lr = new JLabel("resultado");
		lr.addMouseListener(this);
		
		ld = new JLabel("0");
		
		bd = new JButton("add");
		bd.addActionListener(this);
		
		
		panel.add(bi);
		panel.add(li);
		panel.add(lr);
		panel.add(ld);
		panel.add(bd);
		
		
		
		

		ventana.setContentPane(panel);

		ventana.setVisible(true);
	}
	
	public static void main(String[] args) {
		new ExamenOrdinario();
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		if(arg0.getSource().equals(bi)) {
			int i = Integer.parseInt(li.getText());
			i++;
			li.setText(""+i);
		}
		if(arg0.getSource().equals(bd)) {
			int i = Integer.parseInt(ld.getText());
			i++;
			ld.setText(""+i);
		}
	}

	@Override
	public void mouseClicked(MouseEvent arg0) {
		
	}

	@Override
	public void mouseEntered(MouseEvent arg0) {
		int i = Integer.parseInt(li.getText());
		int d = Integer.parseInt(ld.getText());
		if(i==d) {
			lr.setText("iguales");
		} else {
			if(i>d) {
				lr.setText("izquierda mayor");
			} else {
				lr.setText("derecha mayor");
			}
		}
	}

	@Override
	public void mouseExited(MouseEvent arg0) {
		lr.setText("resultado");
	}

	@Override
	public void mousePressed(MouseEvent arg0) {
		
	}

	@Override
	public void mouseReleased(MouseEvent arg0) {
		
	}

}
