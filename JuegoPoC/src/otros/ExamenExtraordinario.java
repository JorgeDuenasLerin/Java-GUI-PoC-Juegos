package otros;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class ExamenExtraordinario implements ActionListener {
	JFrame ventana;
	JPanel panel;
	
	JButton bDo;
	JButton bRe;
	JButton bMi;
	
	JCheckBox sos;
	
	JLabel parti;
	
	public ExamenExtraordinario() {
		ventana = new JFrame("Examen");
		ventana.setSize(800, 400);
		ventana.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		
		panel = new JPanel();
		
		bDo = new JButton("Do");
		bDo.addActionListener(this);
		bRe = new JButton("Re");
		bRe.addActionListener(this);
		bMi = new JButton("Mi");
		bMi.addActionListener(this);
		
		sos = new JCheckBox("Sostenido");
		
		parti = new JLabel("Partitura: ");
				
		panel.add(bDo);
		panel.add(bRe);
		panel.add(bMi);
		panel.add(sos);
		panel.add(parti);
		
		ventana.setContentPane(panel);

		ventana.setVisible(true);
	}
	
	public static void main(String[] args) {
		new ExamenExtraordinario();
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		String s = "";
		if(sos.isSelected()) {
			s="#";
		}
		String nota = "";
		if(arg0.getSource().equals(bDo)) {
			nota = "Do";
		}
		if(arg0.getSource().equals(bRe)) {
			nota = "Re";
		}
		if(arg0.getSource().equals(bMi)) {
			nota = "Mi";
		}
		parti.setText(parti.getText() + " " + nota+s);
	}

}
