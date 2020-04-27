package medio;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

import básicos.ConSonido;
import básicos.misjpanel.PantallaMegaman;
import básicos.misjpanel.PantallaRick;
import extensiones.GameSounds;

public class Sonidos {

	JButton b1;
	JButton b2;
	JButton b3;
	JButton b4;
	JButton b5;
	
	JPanel panel;
	JFrame ventana;
	
	GameSounds gSounds;
	
	public Sonidos() {
		
		gSounds = GameSounds.getInstance();
		
		ventana = new JFrame("Ejemplo de sonidos");
		ventana.setSize(250, 150);
		ventana.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);


		b1 = new JButton("BSO on");
		b2 = new JButton("BSO off");
		b3 = new JButton("HiHat");
		b4 = new JButton("Snare");
		b5 = new JButton("DrumStick");
			
		panel = new JPanel();
	
		panel.add(b1);
		panel.add(b2);
		panel.add(b3);
		panel.add(b4);
		panel.add(b5);
		
		ActionListener manejador = new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				if(arg0.getSource() == b1) {
					gSounds.BSOStart();
				} else if (arg0.getSource() == b2){
					gSounds.BSOStop();
				} else if (arg0.getSource() == b3){
					gSounds.play(GameSounds.HIHAT);
				} else if (arg0.getSource() == b4){
					gSounds.play(GameSounds.SNARE);
				} else if (arg0.getSource() == b5){
					GameSounds.staticPlay(GameSounds.STICK);
				}
			}
		};
		
		b1.addActionListener(manejador);
		b2.addActionListener(manejador);
		b3.addActionListener(manejador);
		b4.addActionListener(manejador);
		b5.addActionListener(manejador);

		
		ventana.setContentPane(panel);

		ventana.setVisible(true);
	}
	
	public static void main(String[] args) {
		new Sonidos();
	}	
}
