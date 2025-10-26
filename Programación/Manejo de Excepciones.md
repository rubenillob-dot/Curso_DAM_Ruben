 **Manejo de Excepciones**.

Piensa en todo el código que hemos escrito. Funciona muy bien siempre y cuando el usuario haga exactamente lo que esperamos. Pero, ¿qué pasa si...?
*   ...le pides un número y el usuario escribe "hola".
*   ...intentas dividir un número entre cero.
*   ...intentas acceder a un archivo que no existe.

En estos casos, nuestro programa "se rompe" y termina abruptamente con un montón de texto rojo en la consola. Esto es una **excepción**: un evento inesperado que interrumpe el flujo normal del programa.

El **manejo de excepciones** es simplemente la forma en que podemos "atrapar" estos errores antes de que rompan nuestro programa, y decidir qué hacer en su lugar, como mostrar un mensaje de error amigable.

### **¿Cómo Encaja Esto con lo que Ya Sabes?**

*   **Variables, Operadores, Funciones:** Todo el código que escribes normalmente y que podría fallar.
*   **`if-else`:** El manejo de excepciones es como un `if-else` para errores. **Si (`try`)** el código funciona bien, genial. **Si no (`catch`)**, si ocurre un error, haz esto otro.

---

### **1. La Estructura `try-catch` (El "Intentar y Atrapar")**

La herramienta principal para manejar excepciones es el bloque `try-catch`.

**La idea es simple:**
*   Pones el código "peligroso" (el que podría fallar) dentro de un bloque `try`.
*   Justo después, pones un bloque `catch` que actuará como una "red de seguridad". Si algo sale mal en el `try`, la ejecución salta inmediatamente al `catch`.

**Sintaxis:**
```java
try {
    // Código que podría lanzar una excepción (ej: una división, una conversión)
} catch (TipoDeError nombreDelError) {
    // Código que se ejecuta SÓLO SI el error específico ocurre
}
```
*   **`try`**: Significa "Intenta ejecutar este código".
*   **`catch`**: Significa "Si mientras lo intentabas, ocurrió este tipo de error, atrápalo y ejecuta este otro código en su lugar".
*   **`TipoDeError`**: Es el nombre específico del error que quieres atrapar (ej: `ArithmeticException` para errores matemáticos).

#### **Ejemplo Práctico: Evitando la división por cero**

Sin manejo de excepciones, este programa se rompería si el usuario introduce un 0.

```java
public class DivisionSegura {
    public static void main(String[] args) {
        // --- 1. Declaración de variables ---
        int numerador;
        int denominador;
        int resultado;

        // --- 2. Inicialización ---
        numerador = 10;
        denominador = 0; // ¡Peligro!

        // --- 3. Usamos try-catch para proteger la operación ---
        try {
            // Intentamos hacer la división. Java sabe que esto puede fallar.
            resultado = numerador / denominador;
            System.out.println("El resultado es: " + resultado);
        } catch (ArithmeticException e) {
            // Si ocurre un error aritmético (como dividir por cero),
            // la ejecución salta aquí.
            System.out.println("¡Error! No se puede dividir por cero.");
            // La 'e' es una variable que contiene información sobre el error, si la necesitaras.
        }

        System.out.println("El programa continúa después del error.");
    }
}
```
**¿Por qué se escribe así?**
Al envolver la división en un `try`, le estamos diciendo a Java que esté alerta. Cuando detecta que se intenta dividir por cero, en lugar de "romper" el programa, busca una "red" (`catch`) que sea capaz de manejar ese tipo de error (`ArithmeticException`). Al encontrarla, ejecuta el código que hay dentro del `catch` y luego sigue con el programa normalmente.

---

### **2. El Bloque `finally` (El "Pase lo que Pase")**

A veces, hay código que quieres que se ejecute **siempre**, sin importar si hubo un error o no. Típicamente, esto se usa para "limpiar" recursos, como cerrar un archivo o una conexión a una base de datos. Para eso sirve el bloque `finally`.

*   Si el `try` funciona, se ejecuta `try` -> `finally`.
*   Si el `try` falla, se ejecuta `try` -> `catch` -> `finally`.

El bloque `finally` **siempre** se ejecuta al final.

#### **Ejemplo Prácto: `try-catch-finally` con `Scanner`**

Es una buena práctica cerrar siempre el `Scanner`. `finally` es el lugar perfecto para asegurarse de que eso ocurra.

```java
import java.util.Scanner;
import java.util.InputMismatchException;

public class EjemploCompletoExcepciones {
    public static void main(String[] args) {
        // --- 1. Declaración de variables ---
        Scanner teclado;
        int edad;

        // --- 2. Inicialización ---
        teclado = new Scanner(System.in);
        
        System.out.print("Por favor, introduce tu edad (como un número): ");

        // --- 3. Bloque try-catch-finally ---
        try {
            // Código que puede fallar si el usuario no escribe un número.
            edad = teclado.nextInt();
            System.out.println("Gracias. Tu edad es: " + edad);
        } catch (InputMismatchException e) {
            // Red de seguridad si el usuario escribe "hola" en lugar de un número.
            System.out.println("Error: Debes introducir un número entero.");
        } finally {
            // Este bloque se ejecuta SIEMPRE.
            System.out.println("Cerrando recursos...");
            teclado.close(); // Nos aseguramos de cerrar el Scanner.
        }

        System.out.println("Fin del programa.");
    }
}
```

### **En Resumen**

*   Usa **`try`** para envolver el código que sospechas que podría fallar.
*   Usa **`catch`** para definir un plan B y manejar el error de forma controlada si ocurre.
*   Usa **`finally`** (opcional) para el código de limpieza que debe ejecutarse pase lo que pase.

Manejar las excepciones es lo que diferencia un programa frágil de uno robusto y profesional que puede resistir entradas inesperadas del usuario y otros problemas sin "morir" en el intento.