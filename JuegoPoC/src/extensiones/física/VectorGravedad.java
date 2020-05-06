package extensiones.física;

public class VectorGravedad extends VectorFuerza {
	public static int Y_INCREMENT = 1;
	public VectorGravedad() {
		super(0, Y_INCREMENT);
	}
	
	@Override
	public void rozamiento() {
		return;
	}
	
	@Override
	public void acabar() {
		return;
	}
}
