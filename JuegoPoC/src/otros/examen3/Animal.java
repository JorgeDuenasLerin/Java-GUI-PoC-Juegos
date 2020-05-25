package otros.examen3;

public abstract class Animal {
	private String nombre;
	
	public Animal() {
		
	}
	
	public void establecerNombre(String nombre) {
		this.nombre = nombre;
	}
	
	public String obtenerNombre() {
		return nombre;
	}
	
	public abstract void emiteRuido();
	
	public static Animal generarAnimal() {
		Animal a;
		
		if(Math.random()>0.5) {
			a = new Perro();
			a.establecerNombre("Perro");
		} else {
			a = new Gato();
			a.establecerNombre("Gato");
		}
		
		return a;
	}
}
