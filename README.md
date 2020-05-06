# Java-GUI-PoC-Juegos
Ejemplos de cómo hacer determinadas tareas en los juegos

Las imágenes están metidas dentro del proyecto bajo la carpeta imágenes.


## Listado de ejemplos básicos

En estos ejemplo básicos hacemos funcionar la tecnología pero no hay diseño orientado a objetos. Solo sirve para ver cómo hacer las cosas no para proyectos en los que vayamos a tirar muchas líneas de código.

- básicos.ConImagen: Ejemplo que carga una imagen en un label
- básicos.ConAnimación: Ejemplo que carga un sprite y lo anima con cada pulsación de tecla
- básicos.ConAnimaciónConTimer: Ejemplo anterior modificado para que sea el timer el que cambie la imagen
- básicos.Movimiento: Movemos la imagen con el teclado y la rotamos
- básicos.VariosJFramPrefabricados: Hace uso de clases extendidas de JFrame con funcionalidad
- básicos.ConSonido: Hace uso de sonido a través de Clip. Deben ser archivos wav sin nigún tipo de procesado
- básicos.Colisión: Ejemplo de botón que se mueve con ratón, cómo posicionar un elemento delante de otro y detectar una colisión
NOTA: Archivos WAV conseguidos con [mpg123](https://www.cyberciti.biz/faq/convert-mp3-files-to-wav-files-in-linux/)

## Ejemplo dificultad media

### Banco de sonidos

En este ejmplo podemos ver varias estrategias comunes en el desarrollo de código de calidad. La clave de este código está en GameSounds que reune varios elementos de programación de dificultad media.

Expone al mundo exterior los efectos sonoros como constantes (HIHAT, SNARE, DRUMSTICK) de esta forma hace más fácil desde el exterior su uso:

```
GameSounds gSounds = GameSounds.getInstance();
gSounds.play(GameSounds.STICK);
```

Implementa el patrón de software Singletone, de esta forma se garantiza que solo existe una única instancia de este tipo de objetos. Solo habrá un gestor de sonido. También facilita poder acceder desde cualquier parte del código a este objeto a través del método estático getInstance().


```
Dentro de las entrañas de mi código, podŕia acceder a este reproductor y reproducir un sonido. 
// Dentro un método de jugador
...
GameSounds gSounds = GameSounds.getInstance();
gSounds.play(GameSounds.STICK);

...

O accediendo de forma estática
GameSounds.play(GameSounds.STICK);
```

Información sobre sigletone: 
[Singletone](https://duckduckgo.com/?q=singletone&t=h_&ia=web)

### Colisiones
Para este ejemplo hemos generado nuestros propios evento de colisión.

Son ejemplos similares a los del Mouse, Teclado o las ventanas pero nosotros tenemos el control de cuándo y cómo dispararlos. En este caso cuando un objeto está encima de otro.

Una vez que lo disparamos desde la clase principal podemos recogerlo con facilidad:

```
Colisionador colisionador = Colisionador.getInstance();

colisionador.addElement(etiqueta1);
colisionador.addElement(boton);

colisionador.addColsiónListener(this);

colisionador.startDetection();

@Override
public void colsión(ColsiónEvento ce) {
	System.out.println("Colisión!");
	System.out.println("chocó: " + ce.getComponentA());
	System.out.println("con: " + ce.getComponentB());
}
```


### Física

Siguiendo el esquema de Singletone y Timer podemos ver la clase que gestiona las fuerzas físicas.

Cada elemento de juego tiene asociado un listado de fuerzas que se le aplican.

```
HashMap<JComponent,ArrayList<VectorFuerza>> elementos;
```

Hay dos tipos de fuerzas:
- VectorFuerza: genérica, cuando se aplica se consume por rozamiento.
- VectorGravedad: Como el vector fuerza pero no se consume y siempre va hacía abajo.


Se pueden meter elementos en la física  
```
phy = Física.getInstance();

phy.estableceLímite(panelDeContenido);
phy.addElement(etiqueta1);
```

Se le pueden aplicar fuerzas
```
phy.addFuerza(etiqueta1, new VectorFuerza(0, -10));
```