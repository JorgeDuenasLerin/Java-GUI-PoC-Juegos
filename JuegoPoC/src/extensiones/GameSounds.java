package extensiones;

import java.io.IOException;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;

import básicos.ConSonido;

public class GameSounds {
	public static int HIHAT = 0;
	public static int SNARE = 1;
	public static int STICK = 2;
	
	private Clip BSOClip;
	
	private Clip[] efectos;
	
	private static Clip cargaSonido(String recurso) {
		AudioInputStream audioInputStream;
		Clip clip = null;
		try {
			audioInputStream = AudioSystem.getAudioInputStream(ConSonido.class.getResource(recurso));
			clip = AudioSystem.getClip();
			clip.open(audioInputStream);
		} catch (UnsupportedAudioFileException | IOException | LineUnavailableException e) {
			System.out.print("Error al cargar sonido: " + recurso);
			e.printStackTrace();
		}
		return clip;
	}
	
	private GameSounds() {
		BSOClip = GameSounds.cargaSonido("/recursos/caparezza-abiura-di-me.wav");
		efectos = new Clip[3];
		efectos[HIHAT] = GameSounds.cargaSonido("/recursos/hihat.wav");
		efectos[SNARE] = GameSounds.cargaSonido("/recursos/snare.wav");
		efectos[STICK] = GameSounds.cargaSonido("/recursos/drumstick.wav");
	}
	
	public void BSOStart() {
		BSOClip.start();
	}
	
	public void BSOStop() {
		BSOClip.stop();
	}
	
	public void play(int sound) {
		Clip c = efectos[sound];
		c.stop();
		c.setFramePosition(0);
		c.start();		
	}
	
	public static void staticPlay(int sound) {
		getInstance().play(sound);
	}
	
	/*
	 * Patrón Singletone
	 * - Buscar información sobre el patrón de diseño
	 * - Útil para que solo exista una instancia del objeto
	 * - Útil para conseguir una referencia desde cualquier parte del código a un objeto
	 * */
	private static GameSounds INSTANCE = null;
	
    public static GameSounds getInstance() {
        if (INSTANCE == null) INSTANCE = new GameSounds();
        return INSTANCE;
    }
}
