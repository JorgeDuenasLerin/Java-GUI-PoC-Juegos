package extensiones.colisiones;

import java.util.EventListener;

public interface ColisiónEscuchador extends EventListener{
	public void colsión(ColsiónEvento ce);
}
