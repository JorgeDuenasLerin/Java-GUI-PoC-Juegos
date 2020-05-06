package otros;

import java.util.ArrayList;
import java.util.HashMap;

public class EjemploDiccionario {
	
	public static HashMap<String, ArrayList<Persona>> genera(int n){
		HashMap<String, ArrayList<Persona>> agenda = new HashMap<String, ArrayList<Persona>>();
		// Generamos N personas
		for(int i = 0; i < n; i++) {
			Persona p = Persona.generarPersona();
			String índice = String.valueOf(p.obtenerNombre().charAt(0));
			
			// Creamos su "hoja" en la agenda si no hay hoja antes
			if(!agenda.containsKey(índice)) {
				agenda.put(índice, new ArrayList<Persona>());
			}
			
			// Añadimos a la persona a su sitio
			ArrayList<Persona> páginaAgenda = agenda.get(índice);
			páginaAgenda.add(p);
		}
		
		return agenda;
	}
	
	public static void imprimirAgenda(HashMap<String, ArrayList<Persona>> agenda) {
		for(String letra: agenda.keySet()) {
			System.out.println("En la letra:" + letra);
			ArrayList<Persona> hoja = agenda.get(letra);
			for(Persona p : hoja) {
				System.out.println(p);
			}
		}
	}
	
	public static void main(String[] args) {
		imprimirAgenda(
					genera(12)
				);
	}
}
