package básicos;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseListener;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import org.w3c.dom.events.EventTarget;
import org.w3c.dom.events.MouseEvent;
import org.w3c.dom.views.AbstractView;

import básicos.misjpanel.PantallaMegaman;
import básicos.misjpanel.PantallaRick;

public class VariosJFramePrefabricados implements MouseListener {
	
	JPanel panel1;
	JPanel panel2;
	
	JButton b1;
	JButton b2;
	
	JPanel panelDeContenido;
	JPanel panelLateral;
	
	JFrame ventana;
	
	public VariosJFramePrefabricados() {
		panel1 = new PantallaRick();
		panel2 = new PantallaMegaman();
		
		ventana = new JFrame("Ejemplo de imagen");
		ventana.setSize(800, 400);
		ventana.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);


		b1 = new JButton("Rick");
		b2 = new JButton("MM");
		
		b1.addMouseListener(this);
		b2.addMouseListener(this);
				
		panelDeContenido = new JPanel();
		// INFO EN: https://docs.oracle.com/javase/tutorial/uiswing/layout/border.html
		panelDeContenido.setLayout(new BorderLayout());

		panelLateral = new JPanel();
		
		panelLateral.add(b1);
		panelLateral.add(b2);
		
		panelDeContenido.add(panelLateral, BorderLayout.LINE_START);

		panelDeContenido.add(panel1 , BorderLayout.CENTER);
		
		ventana.setContentPane(panelDeContenido);

		ventana.setVisible(true);
	}
	
	
	public static void main(String[] args) {
		new VariosJFramePrefabricados();
	}


	@Override
	public void mouseClicked(java.awt.event.MouseEvent arg0) {
		
		/*
		 * Mini chapuza, hay otro tipo de contenedores para hacer esto
		 * pero para representar la idea básica de JPanel prefabricados vale.
		 * 
		 * Ver cómo hacerlo mejor:
		 *   https://docs.oracle.com/javase/tutorial/uiswing/layout/card.html
		 * */
		
		panelDeContenido.remove(panel1);
		panelDeContenido.remove(panel2);
		
		if(arg0.getSource() == b1) {	
			panelDeContenido.add(panel1, BorderLayout.CENTER);
		} else if(arg0.getSource().equals(b2)) {
			panelDeContenido.add(panel2, BorderLayout.CENTER);
		}
		ventana.setContentPane(panelDeContenido);
	}


	@Override
	public void mouseEntered(java.awt.event.MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void mouseExited(java.awt.event.MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void mousePressed(java.awt.event.MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void mouseReleased(java.awt.event.MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

}
