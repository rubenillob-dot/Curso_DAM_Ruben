
Piensa en todo el código que hemos escrito hasta ahora. Lo hemos puesto todo dentro de `public static void main(String[] args)`. Esto está bien para programas pequeños, pero imagina un programa de miles de líneas. Sería un caos.

Una **función** es simplemente un bloque de código que realiza una tarea específica y al que le ponemos un nombre. En lugar de escribir el mismo código una y otra vez, simplemente "llamamos" a la función por su nombre.

**La gran idea:** divide un problema grande en problemas más pequeños, y crea una función para resolver cada uno de esos problemas pequeños.

---

### **1. La Anatomía de una Función (Método)**

Toda función tiene una estructura, que es como su "declaración de intenciones".

`public static tipo_de_retorno nombreDeLaFuncion(parametros)`

Vamos a desglosar las partes más importantes para empezar:

1.  **`nombreDeLaFuncion`**: El nombre que le das. Debe ser descriptivo y seguir la convención *camelCase* (empezar con minúscula).
2.  **`parametros`**: Son los "ingredientes" que la función necesita para trabajar. Son variables que declaras dentro de los paréntesis. Si una función no necesita ningún dato, los paréntesis se dejan vacíos.
3.  **`tipo_de_retorno`**: Es el "resultado" que la función produce. Define qué tipo de dato va a devolver la función cuando termine.
    *   Si la función va a devolver un número entero, el tipo es `int`.
    *   Si va a devolver un texto, el tipo es `String`.
    *   Si la función **no devuelve nada** (solo realiza una acción, como imprimir algo en pantalla), se usa la palabra clave **`void`**.
4.  **`return`**: Es la palabra clave que se usa dentro de la función para devolver el resultado.

*(Por ahora, no te preocupes demasiado por `public static`. Piénsalo como parte de la "magia" necesaria para que funcione dentro de nuestra clase principal.)*

---

### **2. Funciones que Hacen Algo (pero no devuelven nada)**

Estas son las funciones más sencillas. Su `tipo_de_retorno` es `void`. Las usas cuando quieres que realicen una acción, como mostrar un menú o un saludo.

#### **Ejemplo Práctico: Una función que saluda**

```java
public class EjemploFuncionesVoid {

    // --- Definición de la función ---
    // No necesita datos (paréntesis vacíos) y no devuelve nada (void).
    public static void saludar() {
        // Este es el cuerpo de la función. El código que se ejecutará.
        System.out.println("¡Hola! Bienvenido al programa.");
    }

    // --- El método 'main' que inicia todo ---
    public static void main(String[] args) {
        
        System.out.println("El programa va a empezar...");
        
        // --- Llamada a la función ---
        // Simplemente escribimos su nombre seguido de paréntesis.
        saludar();
        
        System.out.println("El programa ha terminado.");
    }
}
```
**¿Por qué se escribe así?** Hemos sacado la lógica del saludo fuera del `main` y la hemos empaquetado en una función llamada `saludar`. Ahora, cada vez que queramos mostrar ese saludo, solo tenemos que "llamar" a `saludar()`. Esto hace que el `main` sea mucho más limpio y fácil de leer.

---

### **3. Funciones que Calculan y Devuelven un Resultado**

Estas funciones son como calculadoras. Les das unos "ingredientes" (parámetros) y te devuelven un resultado (el `return`).

#### **Ejemplo Práctico: Una función que suma dos números**

```java
public class EjemploFuncionesConRetorno {

    // --- Definición de la función ---
    // Necesita dos 'int' como parámetros y devuelve un 'int'.
    public static int sumar(int numeroA, int numeroB) {
        // 1. Declaración de la variable para el resultado
        int resultado;

        // 2. Lógica de la función
        resultado = numeroA + numeroB;

        // 3. Devolvemos el resultado con 'return'
        return resultado;
    }
    
    public static void main(String[] args) {
        // --- 1. Declaración de variables en main ---
        int valor1;
        int valor2;
        int sumaTotal;

        // --- 2. Inicialización ---
        valor1 = 10;
        valor2 = 5;

        // --- 3. Llamada a la función y almacenamiento del resultado ---
        // El valor que devuelve la función 'sumar' se guarda en 'sumaTotal'.
        sumaTotal = sumar(valor1, valor2);

        // --- 4. Mostrar el resultado ---
        System.out.println("El resultado de la suma es: " + sumaTotal);
    }
}
```
**¿Por qué se escribe así?**
1.  **Definimos `sumar`**: Le decimos que necesita dos enteros (`numeroA` y `numeroB`).
2.  **Llamamos a `sumar`**: Desde `main`, llamamos a la función y le "pasamos" los valores de `valor1` y `valor2`. Dentro de la función, `numeroA` tomará el valor de `valor1` (10) y `numeroB` el de `valor2` (5).
3.  **La función trabaja**: Calcula `10 + 5` y lo guarda en `resultado`.
4.  **`return resultado`**: La función termina y "escupe" el valor de `resultado` (15).
5.  **El `main` recibe el valor**: El valor `15` que ha devuelto la función se asigna a la variable `sumaTotal`.

### **La Regla de Oro: Paso por Valor**

En Java, cuando pasas una variable a una función, en realidad estás pasando **una copia** de su valor. Esto significa que si modificas el parámetro dentro de la función, **la variable original fuera de la función no se ve afectada**.

```java
public class PasoPorValor {

    public static void intentarCambiar(int numero) {
        numero = 100; // Cambiamos la COPIA a 100
        System.out.println("Dentro de la función, el número es: " + numero);
    }

    public static void main(String[] args) {
        int miNumero = 5;
        
        System.out.println("Antes de llamar a la función, miNumero es: " + miNumero);
        
        intentarCambiar(miNumero); // Le pasamos una copia de '5'
        
        System.out.println("Después de llamar a la función, miNumero sigue siendo: " + miNumero);
    }
}
```
**Salida del programa:**
```
Antes de llamar a la función, miNumero es: 5
Dentro de la función, el número es: 100
Después de llamar a la función, miNumero sigue siendo: 5
```

Las funciones son la base para escribir código ordenado, mantenible y profesional. Te permiten crear tus propias "herramientas" que puedes reutilizar en todo tu programa.