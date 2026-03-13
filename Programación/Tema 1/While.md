

### **1. El Bucle `while` (El "Mientras...")**

Piensa en el `while` como un portero de discoteca muy estricto. **Primero comprueba la condición** y solo si es verdadera, te deja pasar (ejecutar el código). Repetirá esto una y otra vez **mientras** la condición siga siendo verdadera.

**La Regla:** Comprueba primero, actúa después. Si la condición es falsa desde el principio, el código no se ejecuta **nunca**.

#### **Ejemplo: Contar hasta 5 con `while`**

```java
public class EjemploWhile {
    public static void main(String[] args) {
        // 1. Declaración de la variable de control
        int contador;

        // 2. Inicialización (Paso 1 del 'for')
        contador = 1;

        // 3. Bucle 'while' (Pasos 2 y 3 del 'for' están aquí)
        // Mientras el contador sea menor o igual a 5...
        while (contador <= 5) {
            // ...ejecuta este código.
            System.out.println(contador);
            
            // ¡MUY IMPORTANTE! Actualizar el contador para no crear un bucle infinito.
            contador++;
        }
    }
}
```
**¿Por qué se escribe así?** Un `while` es como un `for` pero con sus partes separadas. Inicializas la variable *antes*, pones la condición en el `while`, y actualizas la variable *dentro* del bucle.

---

### **2. El Bucle `do-while` (El "Haz esto, y luego comprueba...")**

Este es el portero de discoteca simpático. Te deja pasar una vez sin preguntar, y **solo después de la primera vez, empieza a comprobar la condición** para ver si te deja seguir dentro.

**La Regla:** Actúa primero, comprueba después. El código se ejecuta **siempre al menos una vez**.

#### **Ejemplo: Contar hasta 5 con `do-while`**
```java
public class EjemploDoWhile {
    public static void main(String[] args) {
        // 1. Declaración
        int contador;

        // 2. Inicialización
        contador = 1;

        // 3. Bucle 'do-while'
        do {
            // Primero, ejecuta este código sin preguntar.
            System.out.println(contador);
            
            // Actualiza el contador
            contador++;
        } while (contador <= 5); // Y después, comprueba la condición para ver si repite.
    }
}
```
**¿Por qué se escribe así?** La palabra `do` le dice a Java que ejecute el bloque de código sí o sí. La condición `while` al final decide si debe volver al `do` para repetirlo. Fíjate en el punto y coma (`;`) al final del `while`, ¡es obligatorio!

---

### **La Gran Diferencia en un Ejemplo Claro**

¿Qué pasa si la condición es falsa desde el principio?

```java
public class DiferenciaClara {
    public static void main(String[] args) {
        // 1. Declaración
        int numero;

        // 2. Inicialización
        numero = 10;

        // --- Bucle while ---
        // Pregunta: ¿es 10 <= 5? No, es falso.
        System.out.println("Probando el bucle while...");
        while (numero <= 5) {
            // Este código NUNCA se ejecuta.
            System.out.println("Mensaje desde el while");
        }

        // --- Bucle do-while ---
        // No pregunta, simplemente entra y actúa.
        System.out.println("\nProbando el bucle do-while...");
        do {
            // Este código SÍ se ejecuta una vez.
            System.out.println("Mensaje desde el do-while");
        } while (numero <= 5); // Luego pregunta: ¿es 10 <= 5? No. Y ya no repite.
    }
}
```
**Salida del programa:**
```
Probando el bucle while...

Probando el bucle do-while...
Mensaje desde el do-while
```

### **En Resumen: ¿Cuándo Usar Cada Uno?**

*   Usa **`while`** cuando **no estés seguro de si necesitas ejecutar el código siquiera una vez**. Es el más común.
*   Usa **`do-while`** cuando necesites que el código se ejecute **obligatoriamente al menos una vez**, como al mostrar un menú de opciones al usuario.