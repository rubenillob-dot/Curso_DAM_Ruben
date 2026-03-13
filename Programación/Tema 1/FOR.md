

Imagina que necesitas escribir en pantalla "Hola mundo" cinco veces. Podrías hacer esto:

```java
System.out.println("Hola mundo");
System.out.println("Hola mundo");
System.out.println("Hola mundo");
System.out.println("Hola mundo");
System.out.println("Hola mundo");
```

Funciona, pero... ¿y si necesitaras hacerlo 100 veces? Sería una locura. Para solucionar esto, existen los **bucles** (o ciclos). Un bucle te permite ejecutar un bloque de código una y otra vez mientras se cumpla una condición.

El bucle más común y estructurado es el **bucle `for`**. Es perfecto cuando sabes de antemano cuántas veces quieres repetir una acción.

### **¿Cómo Encaja Esto con lo que Ya Sabes?**

*   **Variables:** El bucle `for` necesita una **variable de control** (normalmente llamada `i` por "índice") para llevar la cuenta de cuántas veces se ha repetido.
*   **Operadores:** Usa operadores de comparación (`<`, `>`, `<=`) para decidir cuándo debe detenerse el bucle y operadores de asignación (`++`, `--`, `+=`) para actualizar el contador en cada vuelta.
*   **`if` / `switch`:** Puedes poner decisiones `if` o `switch` dentro de un bucle `for` para hacer cosas diferentes en cada repetición.

---

### **1. La Sintaxis del Bucle `for`**

El bucle `for` puede parecer complicado al principio porque define todo lo que necesita en una sola línea. Esta línea tiene tres partes, separadas por punto y coma:

`for ( inicialización ; condición ; actualización )`

Vamos a desglosarlo:

1.  **Inicialización:** Se ejecuta **una sola vez**, justo antes de que empiece el bucle. Aquí es donde creas y das un valor inicial a tu variable contadora. Ejemplo: `int i = 1;` (Empezamos a contar desde 1).
2.  **Condición:** Se comprueba **antes de cada vuelta** del bucle. Mientras esta condición sea `true`, el código dentro del bucle se ejecutará. Si se vuelve `false`, el bucle termina. Ejemplo: `i <= 5;` (Repetir mientras `i` sea menor o igual a 5).
3.  **Actualización:** Se ejecuta **al final de cada vuelta**. Sirve para modificar la variable contadora y acercarnos al final. Ejemplo: `i++` (Aumenta `i` en 1 después de cada repetición).

#### **Ejemplo Práctico: Imprimir los números del 1 al 5**

```java
public class ContarHastaCinco {
    public static void main(String[] args) {
        
        // No necesitamos declarar la variable 'i' aquí fuera,
        // porque el 'for' la puede crear por nosotros.

        // El bucle 'for' se encargará de repetir el código entre llaves {}
        for (int i = 1; i <= 5; i++) {
            // Este es el código que se repite
            System.out.println("Número: " + i);
        }

        System.out.println("El bucle ha terminado.");
    }
}
```
**¿Cómo funciona paso a paso?**
1.  **Inicialización:** Se crea la variable `i` y se le asigna el valor `1`.
2.  **Vuelta 1:**
    *   **Condición:** ¿Es `i <= 5`? (¿1 <= 5?). Sí, es `true`.
    *   **Ejecución:** Se ejecuta `System.out.println("Número: " + i);`. Se imprime "Número: 1".
    *   **Actualización:** `i` se incrementa a `2`.
3.  **Vuelta 2:**
    *   **Condición:** ¿Es `i <= 5`? (¿2 <= 5?). Sí, es `true`.
    *   **Ejecución:** Se imprime "Número: 2".
    *   **Actualización:** `i` se incrementa a `3`.
4.  ...y así sucesivamente...
5.  **Vuelta 5:**
    *   **Condición:** ¿Es `i <= 5`? (¿5 <= 5?). Sí, es `true`.
    *   **Ejecución:** Se imprime "Número: 5".
    *   **Actualización:** `i` se incrementa a `6`.
6.  **Vuelta 6:**
    *   **Condición:** ¿Es `i <= 5`? (¿6 <= 5?). No, es `false`.
    *   **Fin del bucle:** El bucle se detiene y el programa continúa con la siguiente línea después del `for`.

---

### **2. Variaciones del Bucle `for`**

Puedes cambiar las tres partes del `for` para adaptarlo a tus necesidades.

#### **Contar hacia atrás (decremento)**

```java
public class CuentaAtras {
    public static void main(String[] args) {
        
        // Inicializamos en 5, la condición es que sea mayor que 0,
        // y en cada paso restamos 1 (i--)
        for (int i = 5; i > 0; i--) {
            System.out.println("Número: " + i);
        }
        System.out.println("¡Despegue!");
    }
}
```

#### **Contar de dos en dos**
```java
public class NumerosPares {
    public static void main(String[] args) {

        // Empezamos en 2, y en cada paso sumamos 2 (i += 2)
        for (int i = 2; i <= 10; i += 2) {
            System.out.println("Número par: " + i);
        }
    }
}
```

---

### **3. Bucles `for` Anidados (un bucle dentro de otro)**

Puedes poner un bucle dentro de otro. Esto es muy útil para trabajar con estructuras de dos dimensiones, como tablas o cuadrículas. El bucle interno se ejecutará por completo por cada vuelta del bucle externo.

#### **Ejemplo Práctico: Imprimir una tabla de multiplicar**

```java
public class TablaDeMultiplicar {
    public static void main(String[] args) {
        // 1. Declaración de variables para los bucles
        int i; // Variable para el bucle externo (filas)
        int j; // Variable para el bucle interno (columnas)

        // Bucle externo: controla las filas (del 1 al 5)
        for (i = 1; i <= 5; i++) {
            
            // Bucle interno: controla las columnas (del 1 al 5)
            // Por cada valor de 'i', este bucle se ejecuta 5 veces
            for (j = 1; j <= 5; j++) {
                // System.out.print en lugar de println para que no salte de línea
                // "\t" es un tabulador, para que los números queden alineados
                System.out.print( (i * j) + "\t" );
            }

            // Cuando el bucle interno termina, hacemos un salto de línea
            // para empezar la siguiente fila.
            System.out.println();
        }
    }
}
```
**¿Por qué se escribe así?**
*   Cuando `i` es 1, el bucle interno con `j` se ejecuta 5 veces (1*1, 1*2, 1*3, 1*4, 1*5).
*   Se imprime un salto de línea.
*   Ahora `i` es 2, y el bucle interno con `j` se vuelve a ejecutar 5 veces (2*1, 2*2, 2*3, 2*4, 2*5).
*   Y así sucesivamente, creando una tabla completa.

---

### **4. Controlando el Bucle: `break` y `continue`**

A veces, dentro de un bucle, quieres alterar su comportamiento normal.

*   **`break`**: Termina el bucle **inmediatamente**, sin importar si la condición sigue siendo verdadera.
*   **`continue`**: Salta **el resto de la vuelta actual** y pasa directamente a la siguiente iteración.

#### **Ejemplo con `break` y `continue`**

Vamos a contar hasta 10, pero nos detendremos si encontramos el número 8 y nos saltaremos el número 5.

```java
public class ControlarBucle {
    public static void main(String[] args) {
        // 1. Declaración de la variable del bucle
        int i;

        // 2. Bucle del 1 al 10
        for (i = 1; i <= 10; i++) {
            
            // Decisión para saltar una vuelta
            if (i == 5) {
                System.out.println("(Saltando el 5)");
                continue; // Vuelve al inicio del for para la siguiente vuelta (i=6)
            }

            // Decisión para romper el bucle
            if (i == 8) {
                System.out.println("¡Encontré el 8! Saliendo del bucle...");
                break; // Termina el bucle aquí mismo
            }

            System.out.println("Número: " + i);
        }

        System.out.println("El bucle ha finalizado. El último valor de i fue: " + i);
    }
}
```
Como ves, el bucle `for` es una herramienta increíblemente potente que, combinada con variables y condicionales, te permite automatizar tareas repetitivas de forma controlada y precisa.