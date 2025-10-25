
### **Operadores en Java**

Un **operador** en programación es simplemente un símbolo que le dice a Java que realice una tarea específica. Estas tareas pueden ser desde hacer cálculos matemáticos, como una suma, hasta comparar dos valores para ver cuál es mayor.

Piensa en los operadores como los "verbos" de la programación: le dan acción a tus datos (que serían los "sustantivos").

#### **Tipos de Operadores**

En Java, los operadores se clasifican en varios grupos según lo que hacen:

1.  **Aritméticos:** Para realizar operaciones matemáticas básicas (`+`, `-`, `*`, `/`, `%`).
2.  **De asignación:** Para guardar un valor en una variable (`=`, `+=`, `-=`, etc.).
3.  **De comparación o relacionales:** Para comparar dos valores y obtener un resultado de verdadero o falso (`==`, `!=`, `>`, `<`, etc.).
4.  **Condicional (ternario):** Para tomar decisiones rápidas en una sola línea (`? :`).
5.  **Lógicos:** Para combinar varias condiciones de verdadero o falso (`&&`, `||`, `!`).
6.  **De bits:** Para manipular los datos a nivel de bits (1s y 0s). Son más avanzados y se usan en situaciones específicas.

---

### **1. Operadores Aritméticos**

Son los que usas para hacer cálculos matemáticos. Son muy parecidos a los que usas en la calculadora.

| Operador | Descripción | Ejemplo |
| :--- | :--- | :--- |
| `+` | **Suma** | `a + b` |
| `-` | **Resta** | `a - b` |
| `*` | **Multiplicación** | `a * b` |
| `/` | **División** | `a / b` |
| `%` | **Módulo** (resto de la división) | `a % b` |
| `++` | **Incremento** (suma 1 al valor) | `a++` o `++a` |
| `--` | **Decremento** (resta 1 al valor) | `a--` o `--a` |

#### **Descripción de los Operadores Aritméticos**

*   **Suma (+):** Suma dos números.
    ```java
    int a = 5;
    int b = 3;
    int suma = a + b; // resultado: 8
    ```
*   **Resta (-):** Resta el segundo número del primero.
    ```java
    int resta = a - b; // resultado: 2
    ```
*   **Multiplicación (\*):** Multiplica dos números.
    ```java
    int multiplicacion = a * b; // resultado: 15
    ```
*   **División (/):** Divide el primer número entre el segundo.
    **¡Ojo!** Si divides dos números enteros, el resultado también será un número entero, sin decimales.
    ```java
    int division = 5 / 3; // resultado: 1 (ignora el resto)
    ```
*   **Módulo (%):** Te da el resto de una división. Es muy útil para saber si un número es par o impar.
    ```java
    int modulo = 5 % 3; // resultado: 2 (porque 5 dividido entre 3 es 1, con un resto de 2)
    ```

#### **Operadores de Incremento (++) y Decremento (--)**

Estos operadores son atajos para sumar o restar 1. Tienen dos formas de usarse que cambian cuándo se realiza la operación.

*   **Post-incremento (a++):** "Usa el valor actual y *luego* súmale 1".
    ```java
    int a = 5;
    System.out.println(a++); // Imprime 5. Después de esta línea, 'a' valdrá 6.
    System.out.println(a);   // Ahora imprime 6.
    ```
*   **Pre-incremento (++a):** "Primero súmale 1 y *luego* usa el nuevo valor".
    ```java
    int a = 5;
    System.out.println(++a); // Primero 'a' se convierte en 6, y luego imprime 6.
    ```

Lo mismo ocurre con el decremento (`a--` y `--a`).

---

### **2. Operadores de Asignación**

Se usan para asignar (guardar) un valor en una variable. El más básico es `=`, pero hay otros que son atajos para hacer una operación y asignar el resultado a la vez.

| Operador | Ejemplo | Equivalente a |
| :--- | :--- | :--- |
| `=` | `a = 5` | `a = 5` |
| `+=` | `a += 3` | `a = a + 3` |
| `-=` | `a -= 3` | `a = a - 3` |
| `*=` | `a *= 3` | `a = a * 3` |
| `/=` | `a /= 3` | `a = a / 3` |
| `%=` | `a %= 3` | `a = a % 3` |

Estos operadores combinados (`+=`, `-=`, etc.) hacen tu código más corto y limpio.

**Ejemplo:**
```java
int puntuacion = 100;

// En lugar de escribir: puntuacion = puntuacion + 20;
// Puedes escribir:
puntuacion += 20; // Ahora puntuacion es 120

puntuacion -= 10; // Ahora puntuacion es 110
```

---

### **3. Operadores de Comparación o Relacionales**

Estos operadores comparan dos valores y el resultado siempre es un valor booleano: `true` (verdadero) o `false` (falso). Son la base para tomar decisiones en el código.

| Operador | Descripción | Ejemplo |
| :--- | :--- | :--- |
| `==` | **Igual a** | `a == b` |
| `!=` | **Distinto de** | `a != b` |
| `>` | **Mayor que** | `a > b` |
| `<` | **Menor que** | `a < b` |
| `>=` | **Mayor o igual que** | `a >= b` |
| `<=` | **Menor o igual que** | `a <= b` |

**Ejemplo:**
```java
int edad = 20;
int mayoriaDeEdad = 18;

boolean esMayor = edad > mayoriaDeEdad;  // esMayor será true
boolean esIgual = edad == 20;            // esIgual será true
boolean esDistinto = edad != 18;         // esDistinto será true
```

---

### **4. Operador Condicional (Ternario)**

Es una forma súper compacta de escribir una decisión `if-else`. Se usa para elegir un valor u otro dependiendo de una condición.

**Sintaxis:**
`resultado = (condición) ? valorSiEsVerdadero : valorSiEsFalso;`

Piensa en el `?` como un "¿es esto verdad?" y en el `:` como un "si no...".

**Ejemplo:**
Imagina que quieres mostrar un mensaje dependiendo de si un alumno ha aprobado o no.
```java
int nota = 7;
String mensaje;

// Con un if-else normal:
if (nota >= 5) {
    mensaje = "Aprobado";
} else {
    mensaje = "Suspendido";
}

// Con el operador ternario (hace lo mismo en una línea):
mensaje = (nota >= 5) ? "Aprobado" : "Suspendido";

System.out.println(mensaje); // Imprime "Aprobado"
```

---

### **5. Operadores Lógicos**

Permiten combinar múltiples condiciones (`true`/`false`) para crear una sola expresión lógica más compleja.

| Operador | Descripción | Ejemplo |
| :--- | :--- | :--- |
| `&&` | **AND (y)**: Devuelve `true` solo si *ambas* condiciones son `true`. | `(edad > 18) && (tieneCarnet)` |
| `||` | **OR (o)**: Devuelve `true` si *al menos una* de las condiciones es `true`. | `(esLunes || esMartes)` |
| `!` | **NOT (no)**: Invierte el valor booleano. `true` se convierte en `false` y viceversa. | `!estaLloviendo` |

**Ejemplo:**
```java
int edad = 25;
boolean tieneTrabajo = true;

// Para entrar a un club, necesitas ser mayor de 18 Y tener dinero.
boolean puedeEntrar = (edad >= 18) && (tieneTrabajo == true);
System.out.println("¿Puede entrar? " + puedeEntrar); // true

// Para un descuento, eres estudiante O eres jubilado.
boolean esEstudiante = false;
boolean esJubilado = false;
boolean tieneDescuento = esEstudiante || esJubilado;
System.out.println("¿Tiene descuento? " + tieneDescuento); // false

// Negación
boolean esDeNoche = false;
System.out.println("¿Es de día? " + !esDeNoche); // true
```

---

### **Precedencia de los operadores**

Al igual que en matemáticas, donde la multiplicación se hace antes que la suma (PEMDAS/BODMAS), en Java los operadores también tienen un orden de ejecución.

Aquí tienes un resumen del orden, de mayor a menor prioridad (los de arriba se ejecutan primero):

1.  **Postfijos** (`expresión++`, `expresión--`)
2.  **Unarios** (`++expresión`, `--expresión`, `!`)
3.  **Multiplicativos** (`*`, `/`, `%`)
4.  **Aditivos** (`+`, `-`)
5.  **Relacionales** (`>`, `<`, `>=`, `<=`)
6.  **Igualdad** (`==`, `!=`)
7.  **AND Lógico** (`&&`)
8.  **OR Lógico** (`||`)
9.  **Ternario** (`? :`)
10. **Asignación** (`=`, `+=`, `-=`, etc.)

Si tienes dudas, ¡usa paréntesis `()`! Lo que está dentro de los paréntesis siempre se evalúa primero y hace que tu código sea mucho más fácil de leer.

**Ejemplo:**
```java
int resultado = 5 + 3 * 2; // resultado es 11 (primero 3 * 2, luego + 5)
int resultadoConParentesis = (5 + 3) * 2; // resultado es 16 (primero 5 + 3, luego * 2)
```