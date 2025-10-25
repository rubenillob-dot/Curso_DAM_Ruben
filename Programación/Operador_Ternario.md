El **operador ternario**.

Piensa en una situación muy común: tienes que asignar un valor a una variable dependiendo de si una condición es verdadera o falsa. Por ejemplo:

```java
if (edad >= 18) {
    mensaje = "Es mayor de edad";
} else {
    mensaje = "Es menor de edad";
}
```
Esto ocupa 5 líneas. El operador ternario te permite hacer **exactamente lo mismo, pero en una sola línea**. Es una forma más compacta y directa de escribir un `if-else` simple.

Se llama "ternario" porque tiene tres partes.

### **¿Cómo Encaja Esto con lo que Ya Sabes?**

Es muy sencillo. El operador ternario es una combinación de lo que ya conoces:
*   Una **condición** que usa **variables** y **operadores de comparación** (como en un `if`).
*   Dos posibles **valores a asignar**, uno para `true` y otro para `false`.

---

### **1. La Sintaxis del Operador Ternario**

La estructura siempre es la misma y se lee casi como una pregunta en inglés.

`variable_resultado = (condición) ? valor_si_es_verdad : valor_si_es_falso;`

Vamos a desglosarlo:
1.  **`(condición)`**: La pregunta que haces. El resultado será `true` o `false`.
2.  **`?`**: El signo de interrogación significa "Entonces...". Separa la condición del primer posible valor.
3.  **`valor_si_es_verdad`**: Este es el valor que se asignará si la condición es `true`.
4.  **`:`**: Los dos puntos significan "Si no...". Separa el valor verdadero del valor falso.
5.  **`valor_si_es_falso`**: Este es el valor que se asignará si la condición es `false`.

---

### **2. Comparación Directa: `if-else` vs. Ternario**

Veamos el ejemplo de la mayoría de edad con ambas formas. ¡Verás qué claro queda!

#### **Ejemplo Práctico: ¿Es mayor de edad?**

```java
public class EjemploTernario {
    public static void main(String[] args) {
        // --- 1. Declaración de variables ---
        int edad;
        String mensajeIf;
        String mensajeTernario;

        // --- 2. Inicialización ---
        edad = 20;

        // --- 3. Lógica con IF-ELSE (la forma larga) ---
        if (edad >= 18) {
            mensajeIf = "Mayor de edad";
        } else {
            mensajeIf = "Menor de edad";
        }
        System.out.println("Resultado con if-else: " + mensajeIf);

        // --- 4. Lógica con Operador Ternario (la forma corta) ---
        // Se lee así:
        // ¿Es 'edad >= 18'? SI (?) -> usa "Mayor de edad". NO (:) -> usa "Menor de edad".
        mensajeTernario = (edad >= 18) ? "Mayor de edad" : "Menor de edad";
        System.out.println("Resultado con ternario: " + mensajeTernario);
    }
}
```
**¿Por qué se escribe así?** Como puedes ver, el operador ternario condensa toda la lógica de asignación del `if-else` en una sola línea, haciendo el código más compacto.

---

### **3. Otro Ejemplo: ¿Par o Impar?**

Este es otro caso perfecto para usar el operador ternario.

```java
public class ParOImpar {
    public static void main(String[] args) {
        // --- 1. Declaración de variables ---
        int numero;
        String resultado;

        // --- 2. Inicialización ---
        numero = 7;

        // --- 3. Usamos el operador ternario para decidir ---
        // La condición usa el operador de módulo (%) para ver si el resto es 0.
        // ¿Es 'numero % 2 == 0'? SI (?) -> usa "Par". NO (:) -> usa "Impar".
        resultado = (numero % 2 == 0) ? "Par" : "Impar";

        // --- 4. Mostrar resultado ---
        System.out.println("El número " + numero + " es: " + resultado);
    }
}
```
**Salida del programa:**
```
El número 7 es: Impar
```

### **Ventajas y Desventajas**

*   **Ventaja - Código Compacto:** Es ideal para asignaciones simples y rápidas. Hace que tu intención sea muy clara en una sola línea.

*   **Desventaja - Poco Legible en Casos Complejos:** **NO** lo uses para sustituir un `if-else` que tiene muchas líneas de código en su interior. El operador ternario está diseñado para **asignar un valor**, no para ejecutar múltiples acciones. Si tu lógica es compleja, usa siempre un `if-else` normal, que será mucho más fácil de leer.

En resumen, el **operador ternario** es un fantástico atajo para los `if-else` sencillos que solo asignan un valor a una variable.