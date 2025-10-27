
***

### **Apartado 1: La Etiqueta `<img>` - Cómo Insertar una Imagen**

#### **Explicación:**

La etiqueta `<img>` (de *image*) es la que se utiliza para incrustar una imagen en tu página web. Es una etiqueta "vacía", lo que significa que no tiene una etiqueta de cierre como `</img>`. Toda la información que necesita se proporciona a través de atributos.

La sintaxis básica es:
`<img src="ruta_de_la_imagen.jpg" alt="texto_descriptivo">`

***

### **Apartado 2: Atributos Esenciales de la Etiqueta `<img>`**

Para que una imagen funcione correctamente y tu página sea accesible, siempre debes incluir estos dos atributos:

#### **1. `src` (Source o Fuente)**
*   **¿Qué hace?**: Este atributo es **obligatorio** y le dice al navegador **dónde encontrar el archivo de la imagen**. Su valor es la URL de la imagen, que puede ser una ruta relativa (dentro de tu propio sitio) o una ruta absoluta (en otro sitio web).
*   **Ejemplo Práctico (Ruta Relativa):**
    ```html
    <!-- La imagen "logo.png" está en una carpeta llamada "imagenes" -->
    <img src="imagenes/logo.png" alt="Logo de la empresa">
    ```

#### **2. `alt` (Alternative Text o Texto Alternativo)**
*   **¿Qué hace?**: Este atributo es **fundamental para la accesibilidad y el SEO**. Proporciona una descripción textual de la imagen. Este texto se mostrará si la imagen no se puede cargar y será leído por los lectores de pantalla para personas con discapacidad visual.
*   **¿Por qué es tan importante?**
    1.  **Accesibilidad:** Permite que las personas que no pueden ver la imagen entiendan su contenido.
    2.  **SEO:** Ayuda a Google y otros buscadores a entender de qué trata la imagen.
    3.  **Contenido de respaldo:** Si la ruta de la imagen está rota, el usuario al menos verá una descripción.

*   **Ejemplo Práctico:**
    ```html
    <img src="paisaje-montana.jpg" alt="Un paisaje montañoso con un lago azul claro al amanecer">
    ```

***

### **Apartado 3: Atributos de Tamaño y Estilo (Uso con Precaución)**

El documento menciona los atributos `width` (ancho), `height` (alto) y `border` (borde).

*   `width`: Define el ancho de la imagen en píxeles.
*   `height`: Define el alto de la imagen en píxeles.
*   `border`: Define un borde alrededor de la imagen (este atributo está obsoleto).

**¡NOTA MUY IMPORTANTE SOBRE BUENAS PRÁCTICAS!**
En el desarrollo web moderno, **no se recomienda usar atributos HTML para dar estilo**. La apariencia visual (tamaño, bordes, sombras, etc.) debe controlarse siempre con **CSS**. Aunque añadir `width` y `height` en el HTML puede ayudar al navegador a reservar el espacio de la imagen mientras carga, la gestión del tamaño para que sea adaptable a móviles (*responsive design*) se hace con CSS.

#### **Ejemplo de la Forma Moderna (con CSS):**

```html
<!-- En tu archivo HTML -->
<img src="imagenes/mi-foto.jpg" alt="Una foto de perfil" class="imagen-redonda">

<!-- En tu archivo CSS -->
<style>
    .imagen-redonda {
        width: 150px;
        height: 150px;
        border-radius: 50%; /* Esto hace que la imagen sea un círculo */
        border: 3px solid #333; /* Esto añade un borde gris oscuro */
    }
</style>
```

***

### **Apartado 4: La Forma Semántica de Presentar Imágenes: `<figure>` y `<figcaption>`**

#### **Explicación:**

A menudo, una imagen necesita un pie de foto o una leyenda que la explique. La forma semántica y correcta de hacer esto en HTML5 es usando las etiquetas `<figure>` y `<figcaption>`.

*   `<figure>`: Es un contenedor que se usa para agrupar contenido independiente, como una imagen, un diagrama o un bloque de código, que está relacionado con el contenido principal pero que podría moverse a otra parte del documento sin afectar el flujo principal.
*   `<figcaption>`: Proporciona una leyenda o título para el contenido dentro de `<figure>`. Lo que escribas aquí se mostrará como el pie de foto.

Usar estas etiquetas ayuda a los buscadores y a las herramientas de accesibilidad a entender que la imagen y su pie de foto están conectados.

#### **Ejemplo Práctico:**

```html
<figure>
    <img 
        src="imagenes/torre-eiffel.jpg" 
        alt="La Torre Eiffel iluminada por la noche en París."
    >
    <figcaption>
        Vista nocturna de la Torre Eiffel, París.
    </figcaption>
</figure>
```

***

### **Ejemplo Práctico Completo**

Aquí tienes un código completo que puedes usar como plantilla, combinando todo lo que hemos visto de la manera correcta y moderna.

```html
<!DOCTYPE html>
<html lang="es">
<head>
    <meta charset="UTF-8">
    <title>Galería de Viajes</title>
    <style>
        /* Estilos básicos para las imágenes y las figuras */
        figure {
            margin: 20px;
            border: 1px solid #ccc;
            padding: 10px;
            display: inline-block; /* Para que se pongan una al lado de la otra */
        }
        
        figure img {
            width: 300px; /* Hacemos todas las imágenes del mismo ancho */
            height: auto; /* El alto se ajusta automáticamente para mantener la proporción */
        }

        figcaption {
            text-align: center;
            font-style: italic;
            margin-top: 5px;
        }
    </style>
</head>
<body>

    <h1>Mis Destinos Favoritos</h1>

    <figure>
        <img src="imagenes/roma.jpg" alt="El Coliseo de Roma bajo un cielo azul.">
        <figcaption>El majestuoso Coliseo en Roma, Italia.</figcaption>
    </figure>

    <figure>
        <img src="imagenes/tokio.jpg" alt="Un cruce de calles muy transitado en Tokio con luces de neón.">
        <figcaption>El icónico cruce de Shibuya en Tokio, Japón.</figcaption>
    </figure>

</body>
</html>
```
