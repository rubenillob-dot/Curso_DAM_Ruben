
***

### **Apartado 1: La Etiqueta `<head>` - El Cerebro de la Página**

#### **Explicación:**

La etiqueta `<head>` es una parte obligatoria de tu documento HTML que actúa como el "cerebro" de la página. Contiene **metadatos**, que son "datos sobre los datos". Esta información no se muestra directamente en la ventana del navegador, pero es fundamental para que la página funcione correctamente, se vea bien en los resultados de búsqueda de Google y se pueda enlazar con otros archivos, como los de diseño (CSS).

Las etiquetas más importantes que puedes encontrar dentro de `<head>` son: `<title>`, `<meta>`, `<link>` y `<base>`.

#### **Ejemplo de Estructura:**

```html
<head>
    <!-- Aquí dentro van las etiquetas con información sobre la página -->
    <title>Título de la Página</title>
    <meta charset="UTF-8">
    <link rel="stylesheet" href="estilos.css">
</head>
```

***

### **Apartado 2: La Etiqueta `<title>` - El Título en la Pestaña**

#### **Explicación:**

La etiqueta `<title>` es una de las más importantes y es obligatoria. Define el título de tu documento, que es el texto que aparece en:
*   La pestaña del navegador.
*   Los marcadores o favoritos cuando alguien guarda tu página.
*   Los resultados de búsqueda de Google.

Solo puede contener texto plano, cualquier etiqueta que pongas dentro será ignorada.

#### **Ejemplo Práctico:**

```html
<!DOCTYPE html>
<html lang="es">
<head>
    <title>Mi Primera Página Web</title>
</head>
<body>
    <!-- El contenido visible iría aquí -->
</body>
</html>
```
**Resultado:** La pestaña del navegador mostrará el texto "Mi Primera Página Web".

***

### **Apartado 3: La Etiqueta `<meta>` - Información Detallada**

#### **Explicación:**

La etiqueta `<meta>` es muy versátil y se usa para proporcionar metadatos que no pueden ser definidos por otras etiquetas. No tiene etiqueta de cierre. Las más comunes e importantes son:

**1. Definir el juego de caracteres (¡Esencial!)**
*   **¿Qué hace?**: `meta charset="UTF-8"` asegura que el navegador interprete correctamente todos los caracteres especiales, como tildes (`á`), la letra `ñ` o símbolos. **Siempre debes incluir esta etiqueta.**
*   **Ejemplo Práctico:**
    ```html
    <meta charset="UTF-8">
    ```

**2. Descripción de la página (¡Importante para SEO!)**
*   **¿Qué hace?**: `meta name="description"` proporciona una breve descripción de tu página. Google suele mostrar este texto debajo del título en los resultados de búsqueda.
*   **Ejemplo Práctico:**
    ```html
    <meta name="description" content="Aprende a estructurar el encabezado de un documento HTML con ejemplos prácticos.">
    ```

**3. Palabras clave (Menos relevante hoy en día)**
*   **¿Qué hace?**: `meta name="keywords"` se usaba para listar palabras clave relevantes para la página. Hoy en día, los buscadores como Google ya casi no la tienen en cuenta, pero no está de más conocerla.
*   **Ejemplo Práctico:**
    ```html
    <meta name="keywords" content="HTML, tutorial, desarrollo web, head, metadatos">
    ```

**4. Autor del documento**
*   **¿Qué hace?**: `meta name="author"` se usa para indicar quién es el autor de la página.
*   **Ejemplo Práctico:**
    ```html
    <meta name="author" content="Juan Pérez">
    ```

**5. Viewport (¡Esencial para diseño adaptable!)**
*   **¿Qué hace?**: `meta name="viewport"` controla cómo se muestra la página en dispositivos móviles. La línea de abajo es el estándar y le dice al navegador que el ancho de la página debe ser igual al ancho de la pantalla del dispositivo. **Es fundamental para que tu web se vea bien en móviles (diseño responsive).**
*   **Ejemplo Práctico:**
    ```html
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    ```

#### **Ejemplo Práctico Combinado:**

Así se vería una sección `<head>` con varias etiquetas `<meta>` bien utilizadas.

```html
<head>
    <title>Página de Ejemplo</title>

    <!-- Metadatos Esenciales -->
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">

    <!-- Metadatos para SEO y descriptivos -->
    <meta name="description" content="Esta es una página de ejemplo para aprender sobre etiquetas meta.">
    <meta name="author" content="Mi Nombre">
</head>
```

***

### **Apartado 4: La Etiqueta `<link>` - Conectando Archivos Externos**

#### **Explicación:**

La etiqueta `<link>` se usa para vincular tu documento HTML con recursos externos. Su uso más común y fundamental es **enlazar una hoja de estilos CSS**, que es el archivo que define el diseño y la apariencia de tu página (colores, fuentes, etc.).

*   **`href`**: Especifica la ruta (la URL) al archivo que quieres enlazar.
*   **`rel`**: Define la relación entre el archivo HTML y el archivo enlazado. Para hojas de estilo, siempre es `"stylesheet"`.

#### **Ejemplo Práctico:**

Imagina que tienes un archivo llamado `mis-estilos.css` en una carpeta llamada `css`. Así lo enlazarías:

```html
<head>
    <title>Página con Estilos</title>
    <meta charset="UTF-8">
    <link rel="stylesheet" href="css/mis-estilos.css">
</head>
```

***

### **Apartado 5: La Etiqueta `<base>` - Definiendo una URL Base**

#### **Explicación:**

La etiqueta `<base>` es menos común, pero útil en ciertos casos. Permite especificar una **URL base** para todos los enlaces relativos de una página. Por ejemplo, si tienes muchas imágenes en una misma carpeta, puedes definir esa carpeta en la etiqueta `<base>` y luego solo poner el nombre del archivo en cada etiqueta de imagen.

*   **`href`**: Define la URL base.
*   **`target`**: Puede definir si los enlaces se abren en una nueva pestaña (`_blank`) por defecto.

**Nota:** Si se usa, solo puede haber una etiqueta `<base>` por documento.

#### **Ejemplo Práctico:**

```html
<head>
    <base href="https://www.misitio.com/imagenes/" target="_blank">
</head>
<body>
    <!-- Esta imagen se cargará desde https://www.misitio.com/imagenes/logo.png -->
    <!-- Y si haces clic en ella (si fuera un enlace), se abriría en una nueva pestaña -->
    <img src="logo.png" alt="Logo de mi sitio">
</body>
```
