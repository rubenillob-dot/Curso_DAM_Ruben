
***

### **Apartado 1: La Diferencia Clave: Estilo vs. Significado (Semántica)**

Antes de empezar, es crucial entender una idea muy importante en HTML moderno: no es lo mismo dar un **estilo visual** que dar un **significado semántico**.

*   **Etiquetas de Estilo (Visuales):** Simplemente cambian la apariencia del texto. Por ejemplo, `<b>` hace que el texto se vea en negrita, pero no le dice al navegador ni a Google que esa palabra es más importante.
*   **Etiquetas Semánticas:** También cambian la apariencia, pero además, le añaden un significado especial al texto. Por ejemplo, `<strong>` también pone el texto en negrita, pero le está diciendo al sistema que esa palabra tiene una "gran importancia".

**Regla de oro:** Siempre que puedas, **prefiere usar una etiqueta semántica sobre una puramente visual.** Ayuda a la accesibilidad (lectores de pantalla) y al SEO (posicionamiento en buscadores).

***

### **Apartado 2: Formato de Énfasis y Relevancia (Semánticas)**

Estas son las etiquetas que deberías usar con más frecuencia para destacar texto.

#### **1. `<strong>` (Importancia Fuerte)**
*   **¿Qué hace?**: Muestra el texto en **negrita**.
*   **¿Qué significa?**: Indica que el texto tiene una gran importancia, seriedad o urgencia. Es el equivalente semántico de `<b>`.
*   **Ejemplo Práctico:**
    ```html
    <p><strong>Cuidado:</strong> No tocar el cable de alta tensión.</p>
    ```

#### **2. `<em>` (Énfasis)**
*   **¿Qué hace?**: Muestra el texto en *cursiva*.
*   **¿Qué significa?**: Se usa para enfatizar una palabra o frase, cambiando el sentido de la oración. Es el equivalente semántico de `<i>`.
*   **Ejemplo Práctico:**
    ```html
    <p>Yo <em>nunca</em> dije que debías hacer eso.</p>
    ```

#### **3. `<mark>` (Texto Marcado o Resaltado)**
*   **¿Qué hace?**: Muestra el texto con un fondo de color, como si lo hubieras marcado con un rotulador (normalmente amarillo).
*   **¿Qué significa?**: Indica que un texto es particularmente relevante en un contexto específico, como resaltar un término de búsqueda en una lista de resultados.
*   **Ejemplo Práctico:**
    ```html
    <p>El buscador encontró la palabra <mark>HTML</mark> en tres párrafos.</p>
    ```

***

### **Apartado 3: Citas, Abreviaturas y Definiciones**

#### **1. `<blockquote>` (Bloque de Cita)**
*   **¿Qué hace?**: Crea un bloque de texto separado con márgenes (indentado) para representar una cita larga de otra fuente.
*   **Ejemplo Práctico:**
    ```html
    <p>Como dijo una vez un sabio:</p>
    <blockquote>
        Aprender a programar es como aprender un nuevo idioma; requiere práctica y paciencia.
    </blockquote>
    ```

#### **2. `<q>` (Cita en Línea)**
*   **¿Qué hace?**: Envuelve una frase corta en **comillas**. Es la forma semántica de citar algo dentro de un párrafo.
*   **Ejemplo Práctico:**
    ```html
    <p>El profesor siempre nos recuerda que <q>la semántica es clave en HTML</q>.</p>
    ```

#### **3. `<abbr>` (Abreviatura)**
*   **¿Qué hace?**: Define una abreviatura o un acrónimo. Usando el atributo `title`, puedes proporcionar el significado completo, que aparecerá cuando el usuario pase el ratón por encima.
*   **Ejemplo Práctico:**
    ```html
    <p>La <abbr title="Organización de las Naciones Unidas">ONU</abbr> fue fundada en 1945.</p>
    ```
    *(Nota: La etiqueta `<acronym>` que aparece en el documento está obsoleta. Siempre se debe usar `<abbr>`).*

#### **4. `<dfn>` (Definición)**
*   **¿Qué hace?**: Se usa para marcar el término que se está definiendo por primera vez en un texto.
*   **Ejemplo Práctico:**
    ```html
    <p>El <dfn>HTML</dfn> es el lenguaje de marcado estándar para crear páginas web.</p>
    ```

***

### **Apartado 4: Formato de Posición y Estilo (Uso Específico)**

#### **1. `<sub>` (Subíndice) y `<sup>` (Superíndice)**
*   **¿Qué hacen?**: `<sub>` muestra el texto más pequeño y por debajo de la línea base. `<sup>` lo muestra más pequeño y por encima.
*   **¿Cuándo se usan?**: Son perfectos para fórmulas químicas, notas a pie de página o expresiones matemáticas.
*   **Ejemplo Práctico:**
    ```html
    <p>La fórmula del agua es H<sub>2</sub>O.</p>
    <p>El área de un círculo es πr<sup>2</sup>.</p>
    ```

#### **2. `<small>` (Texto Pequeño)**
*   **¿Qué hace?**: Muestra el texto en un tamaño de fuente más pequeño.
*   **¿Cuándo se usa?**: Se usa para contenido secundario o "letra pequeña", como derechos de autor, avisos legales o aclaraciones.
*   **Ejemplo Práctico:**
    ```html
    <footer>
        <p><small>&copy; 2025 Mi Empresa. Todos los derechos reservados.</small></p>
    </footer>
    ```

***

### **Apartado 5: Etiquetas Visuales Antiguas (Usar con Precaución)**

Estas etiquetas provienen de versiones antiguas de HTML. Aunque todavía funcionan, **generalmente se recomienda usar sus alternativas semánticas o dar estilo con CSS**.

*   `<b>`: Pone el texto en **negrita**. Prefiere usar `<strong>`.
*   `<i>`: Pone el texto en *cursiva*. Prefiere usar `<em>`.
*   `<u>`: **Subraya** el texto. **¡Evítala!** En la web, el subrayado se asocia universalmente a los hipervínculos, por lo que puede confundir al usuario.
*   `<strike>`: Tacha el texto. Esta etiqueta está obsoleta. La alternativa moderna es `<del>` para indicar que algo ha sido eliminado o `<s>` para indicar que algo ya no es relevante.
*   `<big>`: Aumenta el tamaño del texto. Esta etiqueta está obsoleta y no debe usarse. Para hacer el texto más grande, usa CSS.

### **Ejemplo Práctico Completo**

Aquí tienes un ejemplo que combina muchas de estas etiquetas en
