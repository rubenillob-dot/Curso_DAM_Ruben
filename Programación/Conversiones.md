

### **Conversiones de Tipos en Java (Casting)**

A veces, en tu programa, necesitarás transformar un valor de un tipo de dato a otro. Por ejemplo, convertir un número entero (`int`) en un número decimal (`double`). Este proceso se llama **conversión de tipos** o **casting**.

Existen dos tipos principales de conversión:

1.  **Conversión implícita (Widening):** Ocurre automáticamente cuando conviertes un tipo de dato "pequeño" a uno "más grande". Es una operación segura porque no se pierde información.
2.  **Conversión explícita (Narrowing):** Debes hacerla tú manualmente. Ocurre cuando conviertes un tipo "grande" a uno "más pequeño". Se llama así porque "estrechas" el tipo de dato, y esto puede causar una pérdida de información.

---

### **1. Conversión Implícita (Widening o Ampliación)**

Imagina que tienes una caja pequeña (un `int`) y quieres meter su contenido en una caja mucho más grande (un `double`). El contenido cabe sin problemas y no se pierde nada. Java hace esto automáticamente por ti.

**Ruta de conversiones implícitas seguras:**

`byte` → `short` → `int` → `long` → `float` → `double`

También puedes convertir `char` a `int` de forma segura.

#### **Ejemplo de Widening (Conversión Implícita)**

En este ejemplo, un número entero se convertirá automáticamente en un número decimal.

```java
public class ConversionImplicita {
    public static void main(String[] args) {
        // 1. Declaración de variables
        int numeroEntero;
        double numeroDecimal;

        // 2. Inicialización y operación
        numeroEntero = 100;
        
        // Java convierte automáticamente 'numeroEntero' a double antes de asignarlo
        numeroDecimal = numeroEntero;

        // 3. Mostrar resultado
        System.out.println("El valor decimal es: " + numeroDecimal); // Imprime: 100.0
    }
}
```**¿Por qué se escribe así?** La variable `numeroDecimal` es de tipo `double`, que tiene más capacidad que un `int`. Java detecta que la conversión es segura y la realiza automáticamente, añadiendo `.0` al final para representar que ahora es un decimal.

---

### **2. Conversión Explícita (Narrowing o Reducción)**

Ahora imagina lo contrario: tienes una caja grande (`double`) llena de cosas y quieres meter todo su contenido en una caja mucho más pequeña (`int`). Es probable que no quepa todo y tengas que dejar algo fuera.

En programación, esto significa que podrías perder datos (como la parte decimal de un número). Por eso, Java te obliga a decirle explícitamente que estás de acuerdo con esta posible pérdida. Esto se hace poniendo el tipo de dato al que quieres convertir entre paréntesis, justo antes de la variable. A esto se le llama **hacer un cast**.

#### **Ejemplo de Narrowing (Conversión Explícita)**

Aquí convertiremos un `double` a un `int`, perdiendo la parte decimal.

```java
public class ConversionExplicita {
    public static void main(String[] args) {
        // 1. Declaración de variables
        double numeroDecimal;
        int numeroEntero;

        // 2. Inicialización y operación
        numeroDecimal = 9.78;

        // Le decimos a Java: "Sé que puedo perder datos, pero quiero convertirlo a int"
        numeroEntero = (int) numeroDecimal;

        // 3. Mostrar resultado
        System.out.println("El valor entero es: " + numeroEntero); // Imprime: 9
    }
}
```
**¿Por qué se escribe así?** Al escribir `(int)`, estás forzando la conversión. Java obedece y trunca el número decimal, eliminando todo lo que hay después del punto, sin redondear. Le estás diciendo al compilador que entiendes el riesgo y asumes la responsabilidad.

---

### **Conversión de y hacia `String`**

El tipo `String` es especial. No puedes usar casting `(String)` o `(int)` para convertir entre números y texto directamente. Se usan métodos específicos.

#### **1. Conversión de Tipos Numéricos a `String`**

Hay dos formas sencillas de convertir cualquier tipo de dato a una cadena de texto.

*   **Forma automática (Concatenación):** Si usas el operador `+` con una cadena y cualquier otro tipo de dato, Java convertirá automáticamente ese dato a `String`.
*   **Forma explícita (`String.valueOf()`):** Puedes usar el método `String.valueOf()` para dejar claro que quieres hacer una conversión a `String`.

**Ejemplo:**```java
public class ConvertirAString {
    public static void main(String[] args) {
        // 1. Declaración de variables
        String textoResultado;
        int numero;

        // 2. Inicialización y operación
        numero = 100;

        // Se convierte 'numero' a String automáticamente para unirlo al texto
        textoResultado = "El número es: " + numero;

        // 3. Mostrar resultado
        System.out.println(textoResultado); // Imprime: El número es: 100
    }
}```

#### **2. Conversión de `String` a Tipos Numéricos**

Para convertir una cadena que contiene un número (como `"123"`) a un tipo numérico (`int`, `double`, etc.), debes usar los métodos de las "clases envolventes" (Wrapper classes).

*   Para `int`: `Integer.parseInt()`
*   Para `double`: `Double.parseDouble()`

**Ejemplo:**
```java
public class ConvertirDesdeString {
    public static void main(String[] args) {
        // 1. Declaración de variables
        String textoNumero;
        int numeroConvertido;

        // 2. Inicialización y operación
        textoNumero = "123";

        // Usamos el método para "analizar" el texto y extraer el entero
        numeroConvertido = Integer.parseInt(textoNumero);

        // 3. Mostrar resultado
        System.out.println("El número convertido es: " + numeroConvertido);
    }
}
```
**¿Por qué se escribe así?** Una `String` es texto, no un número, aunque sus caracteres sean dígitos. El método `Integer.parseInt()` está diseñado para leer esa cadena de texto, interpretar los dígitos y devolver el valor numérico correspondiente. Si el texto no puede convertirse a número (por ejemplo, `"hola"`), el programa lanzará un error.

---

### **Ejemplo Completo con Varios Tipos de Conversión**

Este programa combina los diferentes tipos de conversión que hemos visto, siguiendo la estructura de declarar todas las variables al principio.

```java
public class EjemploCompletoConversiones {

    public static void main(String[] args) {
        // --- Declaración de todas las variables ---
        
        // Para Widening
        int miEntero;
        double miDecimalDesdeEntero;

        // Para Narrowing
        double miDecimal;
        int miEnteroDesdeDecimal;

        // Para conversión a String
        int numeroParaTexto;
        String textoDesdeNumero;

        // Para conversión desde String
        String textoParaNumero;
        int numeroDesdeTexto;


        // --- Inicialización y Operaciones ---

        System.out.println("--- Conversión Implícita (Widening) ---");
        miEntero = 50;
        miDecimalDesdeEntero = miEntero; // int a double (automático)
        System.out.println("De int a double: " + miDecimalDesdeEntero);

        System.out.println("\n--- Conversión Explícita (Narrowing) ---");
        miDecimal = 25.75;
        miEnteroDesdeDecimal = (int) miDecimal; // double a int (manual con pérdida)
        System.out.println("De double a int: " + miEnteroDesdeDecimal);
        
        System.out.println("\n--- Conversión de Número a String ---");
        numeroParaTexto = 300;
        textoDesdeNumero = "El valor es " + numeroParaTexto; // Conversión automática
        System.out.println(textoDesdeNumero);

        System.out.println("\n--- Conversión de String a Número ---");
        textoParaNumero = "99";
        numeroDesdeTexto = Integer.parseInt(textoParaNumero);
        System.out.println("El número extraído del texto es: " + numeroDesdeTexto);
    }
}
```