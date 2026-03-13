

### **¿Cómo se Usa la Clase `Math`?**

Es muy sencillo. No tienes que crear un objeto como hacías con `Scanner`. Simplemente escribes el nombre de la clase, `Math`, seguido de un punto y el nombre de la operación que quieres realizar.

Por ejemplo: `Math.sqrt(9)` te dará la raíz cuadrada de 9.

---

### **1. Las Herramientas Más Útiles de la Caja `Math`**

Vamos a ver las funciones más comunes, que son como las herramientas principales de esta caja.

#### **A. Redondeo y Valor Absoluto**

*   `Math.abs(numero)`: Devuelve el **valor absoluto**. Simplemente, le quita el signo negativo a un número. `Math.abs(-10)` es `10`.
*   `Math.round(numeroDecimal)`: **Redondea** un número decimal al entero más cercano, como te enseñaron en el colegio (si es .5 o más, sube; si es menos, baja).
*   `Math.ceil(numeroDecimal)`: **Redondea siempre hacia arriba** (hacia el "techo", *ceiling* en inglés), al siguiente entero. `Math.ceil(7.1)` es `8.0`.
*   `Math.floor(numeroDecimal)`: **Redondea siempre hacia abajo** (hacia el "suelo", *floor* en inglés), al entero anterior. `Math.floor(7.9)` es `7.0`.

#### **B. Potencias y Raíces**

*   `Math.sqrt(numero)`: Calcula la **raíz cuadrada** (*square root*).
*   `Math.pow(base, exponente)`: Calcula una **potencia** (*power*). Eleva el número `base` al `exponente`. `Math.pow(2, 3)` es 2³, o sea, 8.

#### **C. Mínimos y Máximos**

*   `Math.max(num1, num2)`: Devuelve el número **máximo** (el más grande) entre `num1` y `num2`.
*   `Math.min(num1, num2)`: Devuelve el número **mínimo** (el más pequeño) entre `num1` y `num2`.

#### **D. Generar Números Aleatorios**

*   `Math.random()`: Esta es una de las más divertidas. Devuelve un número decimal **aleatorio** entre `0.0` (incluido) y `1.0` (sin incluir).

"Pero yo quiero un número entero aleatorio, por ejemplo, entre 1 y 100". ¡Se puede! Solo hay que combinarlo con lo que ya sabemos. La fórmula es:
`(int)(Math.random() * (max - min + 1)) + min`

No te asustes, es más fácil de lo que parece. Para un dado de 6 caras (números del 1 al 6):
`int tiradaDado = (int)(Math.random() * 6) + 1;`

#### **E. Constantes Famosas**

*   `Math.PI`: Te da el valor de la constante **Pi** (3.14159...).
*   `Math.E`: Te da el valor de la constante **e** (2.71828...).

---

### **Ejemplo Práctico Juntando Todo**

Vamos a crear un programa que use varias de estas herramientas para realizar diferentes cálculos sobre un par de números.

```java
public class EjemploClaseMath {

    public static void main(String[] args) {

        // --- 1. Declaración de todas las variables ---
        double numeroDecimal;
        int numeroEntero1;
        int numeroEntero2;

        long numeroRedondeado;
        double raizCuadrada;
        int numeroMaximo;
        double potencia;
        int numeroAleatorio;

        // --- 2. Inicialización ---
        numeroDecimal = -9.75;
        numeroEntero1 = 10;
        numeroEntero2 = 20;

        System.out.println("--- Cálculos con la Clase Math ---");
        System.out.println("Números originales: " + numeroDecimal + ", " + numeroEntero1 + ", " + numeroEntero2);

        // --- 3. Uso de los métodos de Math ---

        // Redondeo
        numeroRedondeado = Math.round(numeroDecimal);
        System.out.println("\nEl redondeo de " + numeroDecimal + " es: " + numeroRedondeado); // Redondea a -10

        // Raíz Cuadrada (primero necesitamos el valor absoluto)
        raizCuadrada = Math.sqrt(Math.abs(numeroEntero1)); // Raíz cuadrada de 10
        System.out.println("La raíz cuadrada de " + numeroEntero1 + " es: " + raizCuadrada);

        // Potencia
        potencia = Math.pow(numeroEntero1, 2); // 10 elevado a 2
        System.out.println(numeroEntero1 + " elevado al cuadrado es: " + potencia);
        
        // Máximo de dos números
        numeroMaximo = Math.max(numeroEntero1, numeroEntero2);
        System.out.println("El número más grande entre " + numeroEntero1 + " y " + numeroEntero2 + " es: " + numeroMaximo);
        
        // Número aleatorio entre 1 y 100
        numeroAleatorio = (int)(Math.random() * 100) + 1;
        System.out.println("\n¡He generado un número aleatorio!: " + numeroAleatorio);
        
        // Usando la constante PI para calcular el área de un círculo
        double radio = 5;
        double area = Math.PI * Math.pow(radio, 2);
        System.out.println("El área de un círculo con radio " + radio + " es: " + area);
    }
}
```

Como ves, la clase `Math` es tu mejor amiga para cualquier cálculo que vaya más allá de una simple suma o resta. Es una herramienta fundamental que te ahorrará mucho tiempo y esfuerzo.