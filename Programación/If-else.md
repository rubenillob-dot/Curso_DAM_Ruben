

Piensa en un programa como una persona que sigue instrucciones. Hasta ahora, solo le hemos dado instrucciones en una línea recta: "declara esta variable", "haz esta suma", "muestra este mensaje". Pero para que sea útil, necesita poder tomar **decisiones**.

La estructura `if-else` es simplemente la forma en que le enseñamos a nuestro programa a tomar esas decisiones.

---

### **1. La Decisión Básica: `if` (El "Si...")**

El `if` es la forma más simple de decisión. Le dices al programa: "**Si** esta condición es verdadera, **entonces** haz esto". Si la condición no es verdadera (es falsa), simplemente ignora las instrucciones y sigue adelante.

**¿Cómo encaja con lo que ya sabes?**
*   **La "condición"** es una pregunta que haces usando **operadores de comparación** (`>`, `<`, `==`, etc.) sobre tus **variables**.
*   El resultado de esa pregunta siempre es `true` (verdadero) o `false` (falso).
*   El `if` mira esa respuesta. Si es `true`, actúa.

#### **Ejemplo: Comprobar si un número es positivo**

```java
public class ComprobarPositivo {
    public static void main(String[] args) {
        // 1. Declaración de variables
        int numero;

        // 2. Inicialización
        numero = 5;

        // 3. La Decisión (La "pregunta")
        // Preguntamos: ¿es la variable 'numero' mayor que 0?
        // Usamos el operador '>' sobre la variable 'numero'.
        // Como 5 > 0, la respuesta es 'true'.
        if (numero > 0) {
            // Como la respuesta fue 'true', se ejecuta este código.
            System.out.println("El número es positivo.");
        }

        System.out.println("Fin del programa.");
    }
}
```
**¿Por qué se escribe así?** El `if` evalúa la expresión `numero > 0`. Como el resultado es `true`, el código dentro de las llaves `{}` se ejecuta. Si `numero` fuera `-5`, la condición sería `false` y la línea `System.out.println("El número es positivo.");` se saltaría por completo.

---

### **2. La Decisión con Alternativa: `if-else` (El "Si... y si no...")**

Esto es una mejora. Ahora le decimos al programa: "**Si** esta condición es verdadera, haz la cosa A. **Si no** (si es falsa), haz la cosa B". Con `if-else`, siempre se ejecutará una de las dos opciones.

#### **Ejemplo: Comprobar si una persona es mayor de edad**

```java
public class MayorDeEdad {
    public static void main(String[] args) {
        // 1. Declaración de variables
        int edad;

        // 2. Inicialización
        edad = 15;

        // 3. La Decisión con Alternativa
        // Preguntamos: ¿es la variable 'edad' mayor o igual que 18?
        // Como 15 >= 18, la respuesta es 'false'.
        if (edad >= 18) {
            // Este bloque se ignora porque la respuesta fue 'false'.
            System.out.println("Es mayor de edad.");
        } else {
            // Como la condición del 'if' fue falsa, se ejecuta este bloque 'else'.
            System.out.println("Es menor de edad.");
        }
    }
}
```
**¿Por qué se escribe así?** El bloque `else` es el "plan B". Solo se ejecuta si la condición del `if` principal resulta ser `false`. De esta manera, el programa siempre da una respuesta, ya sea una cosa o la otra.

---

### **3. Decisiones Múltiples: `if-else if-else` (El "Si... y si no, prueba esto... y si no...")**

Esto te permite revisar varias condiciones en orden. Es como una cadena de preguntas.

**¿Cómo funciona?**
1.  Java comprueba la primera condición del `if`. Si es `true`, ejecuta su código y se salta todo lo demás.
2.  Si es `false`, pasa a la siguiente condición del `else if`. Si esta es `true`, ejecuta su código y se salta el resto.
3.  Continúa así hasta que encuentra una condición verdadera o llega al `else` final, que es la opción por defecto si nada de lo anterior fue verdad.

#### **Ejemplo: Clasificar un número como positivo, negativo o cero**

```java
public class ClasificarNumero {
    public static void main(String[] args) {
        // 1. Declaración de variables
        int numero;

        // 2. Inicialización
        numero = 0;

        // 3. La Decisión Múltiple
        // Pregunta 1: ¿es numero > 0? No, 0 no es mayor que 0. La respuesta es 'false'.
        if (numero > 0) {
            System.out.println("El número es positivo.");
        } 
        // Como la primera fue 'false', pasamos a la Pregunta 2: ¿es numero < 0?
        // No, 0 no es menor que 0. La respuesta es 'false'.
        else if (numero < 0) {
            System.out.println("El número es negativo.");
        } 
        // Como todas las preguntas anteriores fueron 'false', se ejecuta el 'else' final.
        else {
            System.out.println("El número es cero.");
        }
    }
}
```
**¿Por qué se escribe así?** Esta estructura te permite manejar situaciones complejas con múltiples resultados posibles de una manera ordenada y clara.

---

### **4. Anidación de `if-else` (Decisiones dentro de decisiones)**

Puedes poner un `if-else` completo dentro de otro `if` o de otro `else`. Esto te permite hacer preguntas más detalladas.

"**Si** se cumple la Condición A, entonces ahora pregúntate por la Condición B".

#### **Ejemplo: Comprobar si un número es positivo y, además, si es par o impar.**

```java
public class AnidacionIfElse {
    public static void main(String[] args) {
        // 1. Declaración de variables
        int numero;

        // 2. Inicialización
        numero = 8;

        // 3. Decisión Principal
        // Pregunta 1: ¿es numero > 0? Sí, 8 > 0. La respuesta es 'true'.
        if (numero > 0) {
            // Como la respuesta fue 'true', entramos a este bloque.
            System.out.println("El número es positivo.");

            // 4. Decisión Anidada (una nueva pregunta)
            // Pregunta 2: ¿el resto de dividir numero entre 2 es 0?
            // Usamos el operador de módulo '%'. 8 % 2 es 0. La respuesta es 'true'.
            if (numero % 2 == 0) {
                // Como la respuesta fue 'true', se ejecuta este código.
                System.out.println("Y además, es par.");
            } else {
                System.out.println("Y además, es impar.");
            }
        } else {
            // Si el número no fuera positivo, se ejecutaría esto.
            System.out.println("El número es negativo o cero.");
        }
    }
}```
**¿Por qué se escribe así?** La anidación te permite crear una lógica más compleja. Primero nos aseguramos de que el número es positivo, y solo entonces nos molestamos en comprobar si es par o impar. Si el número fuera `-10`, el segundo `if` (el anidado) nunca se llegaría a ejecutar.