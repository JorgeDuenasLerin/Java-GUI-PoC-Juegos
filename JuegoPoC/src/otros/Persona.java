package otros;

/*
Crea una clase persona que almacene su nombre, su dinero
la nota que ha sacado y su género (hombre o mujer).

Los atributos deberán ser privados y tienes que establecer
los métodos que te permitan gestionar su información.

También vamos a crear un generador (estático) de personas aleatorias.

Constantes:
MAX_DINERO = 20000;
MAX_DEUDA = 2000;
MAX_NOTA = 10;

*/

public class Persona {
	public static final boolean HOMBRE = true;
	public static final boolean MUJER = false;

	private static final double MAX_DINERO = 20000;
	private static final double MAX_DEUDA = 2000;
	private static final int MAX_NOTA = 10;

	private String nombre;
	private double dinero;
	private int nota;
	private boolean sexo;

	public Persona () {
			nombre = "Anónimo";
			dinero = 0;
			nota = 0;
			sexo = MUJER;
	}

	public Persona (String nombre, double dinero, int nota, boolean sexo) {
			this.nombre = nombre;
			this.dinero = dinero;
			this.nota = nota;
			this.sexo = sexo;
	}

	public void estableceNombre(String nombre) {
		this.nombre = nombre;
	}

	public String obtenerNombre() {
		return nombre;
	}

	public void estableceDinero(double d) {
		this.dinero = d;
	}

	public double obtenerDinero() {
		return dinero;
	}

	public void estableceNota(int nota) {
		this.nota = nota;
	}

	public int obtenerNota() {
		return nota;
	}

	public boolean esHombre() {
		return sexo == HOMBRE;
	}

	public void estableceHombre() {
		sexo = HOMBRE;
	}

	public boolean esMujer() {
		return sexo == MUJER;
	}

	public void estableceMujer() {
		sexo = MUJER;
	}

	public String toString() {
		return String.format(
				"%s ha sacado un %d, tiene %f euros y es %s",
				nombre,
				nota,
				dinero,
				(esHombre())?"hombre":"mujer"
			);
	}

	public static Persona generarPersona() {

		String[] nombres = {
				"Lola Mento",
				"Luz Cuesta Mogollón",
				"Tomas Turbao",
				"Aitor Tilla",
				"Alba Bosa",
				"Tosta Ito",
				"Borja Mon de York",
				"Armando Ruido",
				"Francisco Jones",
				"Josechu Letón",
				"Chema Pamundi"
		};

		Persona p = new Persona(
				nombres[
								(int) (Math.random()*nombres.length)
				 		],
				( Math.random() * (MAX_DINERO+MAX_DEUDA) ) - MAX_DEUDA,
				(int) (Math.random()*MAX_NOTA),
				((Math.random()*2)>1)
		);

		return p;
	}
}
