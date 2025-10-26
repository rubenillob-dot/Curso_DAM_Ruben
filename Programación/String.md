
Un `String` no es un tipo de dato primitivo como `int` o `boolean`. Es un **objeto**, lo que significa que, además de guardar texto, tiene "habilidades" incorporadas (métodos) que nos permiten manipular ese texto de formas muy útiles.

### **1. Creación de Strings**

La forma más común y sencilla de crear un `String` es usando comillas dobles.

```java
public class CrearStrings {
    public static void main(String[] args) {
        // --- 1. Declaración de variables ---
        String saludo;
        String nombre;

        // --- 2. Inicialización ---
        saludo = "Hola";
        nombre = "Mundo";

        // --- 3. Uso ---
        System.out.println(saludo + ", " + nombre + "!");
    }
}
```
**¿Por qué se escribe así?** Al usar comillas dobles, le estás diciendo a Java que "Hola" es un literal de cadena, es decir, un valor de texto fijo. Es la forma más directa y eficiente de crear un `String`.

### **2. La Propiedad Más Importante: Los Strings son Inmutables**

Esto es crucial y puede ser un poco confuso al principio. **Inmutable** significa que una vez que un `String` ha sido creado, **nunca puede ser cambiado**.

"¡Pero yo he cambiado un String!", podrías decir. Por ejemplo:
```java
String mensaje = "Hola";
mensaje = mensaje + ", ¿qué tal?"; // Aquí parece que lo estoy cambiando
```

**Lo que realmente sucede:**
1.  Se crea un `String` en memoria que contiene "Hola". La variable `mensaje` apunta a él.
2.  Cuando haces `mensaje + ", ¿qué tal?"`, Java **crea un objeto `String` completamente nuevo** en memoria que contiene "Hola, ¿qué tal?".
3.  Luego, la variable `mensaje` deja de apuntar al `String` original y **ahora apunta a este nuevo `String`**.

El `String` original ("Hola") sigue existiendo en memoria por un tiempo, pero ya no lo estás usando.

**¿Por qué es importante?** Entender que las operaciones con `String` crean nuevos objetos te ayuda a comprender por qué a veces es más eficiente usar otras herramientas (como `StringBuilder`) cuando necesitas hacer muchas modificaciones de texto.

---

### **3. Métodos Útiles de la Clase `String` (Sus "Habilidades")**

Como `String` es un objeto, podemos usar el punto (`.`) después de una variable de tipo `String` para acceder a sus métodos. Aquí tienes los más importantes, explicados de forma sencilla.

#### **Ejemplo Práctico General**
Vamos a declarar un `String` y luego le aplicaremos varios métodos para ver qué hacen.

```java
public class MetodosString {
    public static void main(String[] args) {
        // --- 1. Declaración de variables ---
        String frase;
        int longitud;
        String enMayusculas;
        String enMinusculas;
        boolean contienePalabra;

        // --- 2. Inicialización ---
        frase = "Java es Divertido";

        System.out.println("La frase original es: '" + frase + "'");

        // --- 3. Usando los métodos ---

        // a) .length() -> Obtener la longitud (número de caracteres)
        longitud = frase.length();
        System.out.println("Longitud de la frase: " + longitud);

        // b) .toUpperCase() -> Convertir a mayúsculas
        enMayusculas = frase.toUpperCase();
        System.out.println("En mayúsculas: " + enMayusculas);

        // c) .toLowerCase() -> Convertir a minúsculas
        enMinusculas = frase.toLowerCase();
        System.out.println("En minúsculas: " + enMinusculas);
        
        // d) .contains("texto") -> Verificar si contiene una subcadena
        // Devuelve 'true' o 'false', ¡perfecto para un if!
        contienePalabra = frase.contains("Divertido");
        if (contienePalabra) {
            System.out.println("La frase contiene la palabra 'Divertido'.");
        }
    }
}```

**Salida del programa:**
```
La frase original es: 'Java es Divertido'
Longitud de la frase: 17
En mayúsculas: JAVA ES DIVERTIDO
En minúsculas: java es divertido
La frase contiene la palabra 'Divertido'.
```

### **4. Comparando Strings: `==` vs `.equals()`**

Este es uno de los errores más comunes de los principiantes.

*   `==`: Compara si dos variables apuntan **al mismo objeto en memoria**. No compara el contenido del texto.
*   `.equals()`: Compara **el contenido del texto**, letra por letra, para ver si son idénticos.

**Regla de oro: Para comparar el contenido de dos Strings, USA SIEMPRE `.equals()`**.

#### **Ejemplo de Comparación**
```java
public class CompararStrings {
    public static void main(String[] args) {
        // --- 1. Declaración de variables ---
        String texto1;
        String texto2;
        String texto3;
        boolean comparacionConIgual;
        boolean comparacionConEquals;

        // --- 2. Inicialización ---
        texto1 = "Hola";
        texto2 = "Hola"; // Java optimiza y hace que texto1 y texto2 apunten al mismo objeto
        texto3 = new String("Hola"); // Forzamos la creación de un NUEVO objeto en memoria

        // --- 3. Comparaciones ---

        // Usando ==
        comparacionConIgual = (texto1 == texto2); // true (ambos apuntan al mismo sitio)
        System.out.println("¿texto1 == texto2? -> " + comparacionConIgual);

        comparacionConIgual = (texto1 == texto3); // false (apuntan a objetos diferentes)
        System.out.println("¿texto1 == texto3? -> " + comparacionConIgual);

        // Usando .equals() (La forma correcta)
        comparacionConEquals = texto1.equals(texto3); // true (el contenido es el mismo)
        System.out.println("¿texto1.equals(texto3)? -> " + comparacionConEquals);

        // También existe .equalsIgnoreCase() para ignorar mayúsculas/minúsculas
        comparacionConEquals = "Java".equalsIgnoreCase("java"); // true
        System.out.println("¿'Java'.equalsIgnoreCase('java')? -> " + comparacionConEquals);
    }
}
```

En resumen, los `String` son la base para manejar cualquier tipo de texto en Java. Recuerda que son **inmutables** y que debes usar **`.equals()`** para compararlos. Sus métodos te darán un montón de herramientas para transformar y analizar el texto fácilmente.