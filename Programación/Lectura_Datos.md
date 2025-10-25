
### **Clase `Scanner` en Java**

Cuando haces un programa, a menudo necesitas que el usuario introduzca datos, como su nombre, su edad o cualquier otro valor. La clase `Scanner` es la herramienta principal en Java para **leer datos de entrada**, principalmente desde el teclado.

Imagina que `Scanner` es como un "oído" que tu programa utiliza para escuchar lo que el usuario escribe.

---

### **1. Importar la Clase `Scanner`**

Antes de poder usar el "oído", tienes que decirle a tu programa dónde encontrarlo. La clase `Scanner` se encuentra en el paquete `java.util`. Por lo tanto, la primera línea de tu archivo (antes de `public class...`) debe ser:

```java
import java.util.Scanner;
```
Esto es como decirle a tu programa: "Oye, voy a necesitar la herramienta `Scanner`, así que tenla a mano".

---

### **2. Crear un Objeto `Scanner`**

Una vez importada, necesitas crear una instancia de `Scanner` para empezar a leer. Si quieres leer lo que el usuario escribe en la consola (el teclado), lo configuras así:

```java
Scanner scanner = new Scanner(System.in);```
*   `Scanner scanner`: Estás creando una variable llamada `scanner` que será de tipo `Scanner`.
*   `= new Scanner(...)`: Estás creando un nuevo objeto `Scanner`.
*   `System.in`: Le estás diciendo al `Scanner` que su fuente de datos, es decir, de dónde va a leer, es la "entrada estándar" del sistema, que es el teclado.

---

### **3. Lectura de Diferentes Tipos de Datos**

`Scanner` tiene métodos específicos para leer diferentes tipos de datos. Aquí están los más comunes:

#### **3.1 Leer un Número Entero (`int`)**

Para leer un número entero, usas el método `nextInt()`.

```java
System.out.print("Ingresa tu edad: ");
int edad = scanner.nextInt();
System.out.println("Tu edad es: " + edad);
```

#### **3.2 Leer un Número Decimal (`double`)**

Para leer un número con decimales, usas `nextDouble()`.

```java
System.out.print("Ingresa tu altura en metros (ej: 1.75): ");
double altura = scanner.nextDouble();
System.out.println("Tu altura es: " + altura);
```

#### **3.3 Leer una Sola Palabra (`String`)**

Si solo quieres leer la primera palabra que el usuario escriba (hasta que encuentre un espacio), usa el método `next()`.

```java
System.out.print("Ingresa tu primer nombre: ");
String nombre = scanner.next();
System.out.println("Tu nombre es: " + nombre);
```
Si el usuario escribe "Juan Carlos", `next()` solo leerá "Juan".

#### **3.4 Leer una Línea Completa de Texto (`String`)**

Si quieres leer todo lo que el usuario escribe, incluyendo espacios, hasta que presione la tecla "Enter", usa el método `nextLine()`.

```java
System.out.print("Ingresa tu nombre completo: ");
String nombreCompleto = scanner.nextLine();
System.out.println("Tu nombre completo es: " + nombreCompleto);
```
Si el usuario escribe "Juan Carlos", `nextLine()` leerá la frase completa.

#### **3.5 Leer un Carácter (`char`)**

`Scanner` no tiene un método directo como `nextChar()`. El truco es leer la siguiente palabra con `next()` y luego tomar solo el primer carácter de esa palabra con `.charAt(0)`.

```java
System.out.print("Ingresa una inicial: ");
char inicial = scanner.next().charAt(0);
System.out.println("La inicial es: " + inicial);
```

---

### **4. Manejo de Errores y Problemas Comunes**

#### **¿Qué pasa si el usuario se equivoca?**

Si le pides un número con `nextInt()` y el usuario escribe "hola", tu programa se detendrá y mostrará un error llamado `InputMismatchException`. Para evitar que tu programa se rompa, puedes usar un bloque `try-catch`.

```java
try {
    System.out.print("Ingresa un número entero: ");
    int numero = scanner.nextInt();
    System.out.println("El número ingresado es: " + numero);
} catch (InputMismatchException e) {
    System.out.println("Error: Eso no es un número. Por favor, ingresa un número entero.");
}
```
El `try-catch` es como una red de seguridad: "Intenta (`try`) hacer esto, y si ocurre este error específico (`catch`), en lugar de romperte, haz esto otro".

#### **El Problema de `nextLine()` después de `nextInt()`**

Este es el error más común para los principiantes con `Scanner`. Observa este código:
```java
System.out.print("Ingresa tu edad: ");
int edad = scanner.nextInt(); // El usuario escribe 25 y presiona Enter

System.out.print("Ingresa tu nombre: ");
String nombre = scanner.nextLine(); // Esta línea parece que se la salta

System.out.println("Nombre: " + nombre + ", Edad: " + edad);
```
**¿Qué pasa aquí?** Cuando usas `nextInt()`, este lee el número (`25`), pero deja el "salto de línea" (la pulsación de la tecla "Enter") en la memoria. Cuando llega el `nextLine()`, ve ese salto de línea pendiente, lo lee y piensa que el usuario ya terminó de escribir, por lo que no te da la oportunidad de introducir tu nombre.

**Solución:** Siempre que uses `nextLine()` después de `nextInt()` (o `nextDouble()`, `nextFloat()`, etc.), debes "limpiar" ese salto de línea pendiente añadiendo un `scanner.nextLine();` extra.

```java
System.out.print("Ingresa tu edad: ");
int edad = scanner.nextInt();

scanner.nextLine(); // ¡Esta línea consume el salto de línea sobrante!

System.out.print("Ingresa tu nombre: ");
String nombre = scanner.nextLine();

System.out.println("Nombre: " + nombre + ", Edad: " + edad);
```

---

### **5. Cerrar el Objeto `Scanner`**

Cuando ya no vayas a leer más datos, es una buena práctica cerrar el `Scanner` para liberar los recursos que está utilizando. Esto se hace con el método `close()`.

```java
scanner.close();
```

---

### **Resumen de Métodos Comunes de `Scanner`**

| Método | Descripción |
| :--- | :--- |
| `nextInt()` | Lee un número entero (`int`). |
| `nextDouble()` | Lee un número decimal de doble precisión (`double`). |
| `next()` | Lee una palabra (hasta el próximo espacio). |
| `nextLine()` | Lee una línea completa de texto (hasta el próximo "Enter"). |
| `nextBoolean()`| Lee un valor `true` o `false`. |
| `nextFloat()` | Lee un número decimal de precisión simple (`float`). |
| `close()` | Cierra el `Scanner` y libera los recursos. |

---

### **Ejemplo Completo de Uso**

Aquí tienes un programa completo que pone en práctica todo lo que hemos visto.

```java
import java.util.Scanner;

public class EjemploCompletoScanner {

    public static void main(String[] args) {
        // 1. Crear el objeto Scanner
        Scanner scanner = new Scanner(System.in);

        // 2. Leer un número entero
        System.out.print("Ingresa tu edad: ");
        int edad = scanner.nextInt();

        // 3. Limpiar el salto de línea pendiente
        scanner.nextLine();

        // 4. Leer una cadena de texto completa
        System.out.print("Ingresa tu nombre completo: ");
        String nombre = scanner.nextLine();

        // 5. Leer un número decimal
        System.out.print("Ingresa tu calificación (ej: 8.5): ");
        double calificacion = scanner.nextDouble();

        // Imprimir los valores ingresados
        System.out.println("\n--- Resumen de Datos ---");
        System.out.println("Nombre: " + nombre);
        System.out.println("Edad: " + edad);
        System.out.println("Calificación: " + calificacion);

        // 6. Cerrar el objeto Scanner
        scanner.close();
    }
}```

**Salida de ejemplo del programa:**

```
Ingresa tu edad: 20
Ingresa tu nombre completo: Ana Sofía García
Ingresa tu calificación (ej: 8.5): 9.5

--- Resumen de Datos ---
Nombre: Ana Sofía García
Edad: 20
Calificación: 9.5
```