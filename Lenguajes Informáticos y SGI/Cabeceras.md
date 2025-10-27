
***

### **Apartado 1: Cabeceras o Títulos (`<h1>` a `<h6>`)**

#### **Explicación:**

Las etiquetas de cabecera, también conocidas como *headings*, se utilizan para definir los títulos y subtítulos de tu contenido. Son fundamentales para dar una **estructura jerárquica** a tu página, lo que ayuda tanto a los usuarios a leer el contenido como a los motores de búsqueda (como Google) a entender de qué trata tu web.

Existen 6 niveles de importancia:
*   `<h1>`: **El título más importante.** Deberías usar solo uno por página para el título principal.
*   `<h2>`: Subtítulos de las secciones principales.
*   `<h3>`: Subtítulos dentro de una sección `<h2>`.
*   `<h4>`, `<h5>`, `<h6>`: Para niveles de subtítulos aún más bajos.

**Importante:** No uses las cabeceras solo para que el texto se vea grande y en negrita. Su función principal es la de estructurar. El diseño (tamaño, color, etc.) se debe modificar con CSS.

#### **Ejemplo Práctico:**

Imagina que estás escribiendo un artículo sobre un postre. La estructura correcta sería así:

```html
<body>
    <h1>Receta de Tarta de Manzana</h1>
    
    <h2>Ingredientes</h2>
    <p>Aquí listamos los ingredientes necesarios para la receta...</p>
    
    <h2>Preparación de la Masa</h2>
    <p>El primer paso es preparar la masa...</p>
    
    <h3>Amasado</h3>
    <p>Explicación sobre cómo amasar...</p>
    
    <h3>Reposo</h3>
    <p>Explicación sobre el tiempo de reposo...</p>

    <h2>Horneado</h2>
    <p>Finalmente, horneamos la tarta...</p>
</body>
```
***

### **Apartado 2: Párrafos (`<p>`)**

#### **Explicación:**

La etiqueta `<p>` (de *paragraph*) es la que usarás con más frecuencia. Se utiliza para agrupar texto en bloques de párrafos. El navegador automáticamente añade un espacio en blanco antes y después de cada etiqueta `<p>`, separando visualmente los párrafos entre sí.

Cualquier texto que no sea un título, una lista o algún otro elemento específico, debería ir dentro de una etiqueta `<p>`.

#### **Ejemplo Práctico:**

```html
<body>
    <h2>Mi Viaje a la Montaña</h2>
    
    <p>
        El fin de semana pasado decidí hacer una excursión a la montaña. El día amaneció
        soleado y el aire era fresco y limpio.
    </p>
    
    <p>
        Durante la caminata, pude observar la flora y fauna local. Los pájaros cantaban
        y el sonido del viento entre los árboles era muy relajante.
    </p>
</body>
```
***

### **Apartado 3: Etiquetas de Formato Especial**

#### **1. Texto Preformateado (`<pre>`)**

*   **¿Qué hace?**: La etiqueta `<pre>` es especial porque **respeta todos los espacios en blanco, tabulaciones y saltos de línea** que escribas en tu código HTML. Además, muestra el texto con una fuente monoespaciada (como la de una máquina de escribir).
*   **¿Cuándo se usa?**: Es perfecta para mostrar bloques de código, poesía o arte ASCII, donde la alineación y los espacios son importantes.

*   **Ejemplo Práctico:**
    ```html
    <p>Aquí hay una función simple en JavaScript:</p>
    
    <pre>
    function saludar() {
        console.log("¡Hola, mundo!");
    }
    </pre>
    ```

#### **2. Salto de Línea (`<br>`)**

*   **¿Qué hace?**: La etiqueta `<br>` (de *break*) fuerza un **salto de línea** en el punto exacto donde la colocas. Es una etiqueta "vacía", lo que significa que no necesita cierre (`</br>`).
*   **¿Cuándo se usa?**: Úsala cuando necesites un salto de línea dentro de un mismo párrafo, como en direcciones postales o poemas. No la uses para crear espacio entre párrafos (para eso está la etiqueta `<p>`).

*   **Ejemplo Práctico:**
    ```html
    <p>
      Dirección de la Tienda:<br>
      Calle Falsa, 123<br>
      08001, Barcelona<br>
      España
    </p>
    ```

#### **3. Línea Horizontal (`<hr>`)**

*   **¿Qué hace?**: La etiqueta `<hr>` (de *horizontal rule*) dibuja una línea horizontal que ocupa todo el ancho disponible. Al igual que `<br>`, es una etiqueta vacía.
*   **¿Cuándo se usa?**: Se utiliza para indicar una **separación temática** o un cambio de sección dentro del contenido.

*   **Ejemplo Práctico:**
    ```html
    <h2>Capítulo 1</h2>
    <p>Texto del primer capítulo...</p>

    <hr>

    <h2>Capítulo 2</h2>
    <p>Texto del segundo capítulo...</p>
    ```

***

### **Ejemplo Práctico Completo**

Aquí tienes un ejemplo final que combina todas las etiquetas que hemos visto en este documento para que veas cómo funcionan juntas.

```html
<!DOCTYPE html>
<html lang="es">
<head>
    <meta charset="UTF-8">
    <title>Artículo sobre HTML</title>
</head>
<body>

    <h1>Aprendiendo Etiquetas de Texto</h1>
    
    <p>
        En este documento vamos a ver las etiquetas básicas para estructurar
        el texto en una página web. Es fundamental usar las etiquetas
        correctas para cada tipo de contenido.
    </p>
    
    <hr>
    
    <h2>Cabeceras y Párrafos</h2>
    
    <p>
        Las cabeceras (h1, h2, etc.) definen la jerarquía y los párrafos (p)
        contienen el texto principal.
    </p>

    <h2>Ejemplos de Código</h2>
    
    <p>
        A veces queremos mostrar código y necesitamos que los espacios se respeten.
        Para eso usamos la etiqueta 'pre'.
    </p>
    
    <pre>
    <body>
        <h1>Título principal</h1>
    </body>
    </pre>

    <h2>Información de Contacto</h2>
    <p>
      Si tienes dudas, escríbenos a:<br>
      info@ejemplo.com<br>
      Apartado Postal 456
    </p>

</body>
</html>
```
