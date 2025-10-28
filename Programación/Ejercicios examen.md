¡Claro! Aquí tienes todos los ejercicios resueltos en un único bloque de código, formateado para que lo puedas copiar y pegar directamente en un archivo Markdown (`.md`).

---

```java
import java.util.Scanner;

public class Ejercicio2ContadorVocales {

    public static void main(String[] args) {
        
        Scanner sc = new Scanner(System.in);
        // Declaracion de variables
        String palabra;
        int contadorVocales;
        int i; // Variable para el bucle

        System.out.println("--- Contador de Vocales ---");
        System.out.print("Escribe una palabra o una frase: ");
        palabra = sc.nextLine();

        // Convertimos toda la palabra a minúsculas para no tener que comprobar A, a, E, e, etc.
        palabra = palabra.toLowerCase();
        
        // Inicializamos el contador a 0
        contadorVocales = 0;

        // Bucle para recorrer cada letra
        for (i = 0; i < palabra.length(); i++) {
            // Sacamos la letra en la que estamos
            char letra = palabra.charAt(i);

            // Comprobamos si la letra es una vocal
            if (letra == 'a' || letra == 'e' || letra == 'i' || letra == 'o' || letra == 'u') {
                // Si es una vocal, aumentamos el contador
                contadorVocales = contadorVocales + 1;
            }
        }

        System.out.println("La palabra tiene " + contadorVocales + " vocales.");
        sc.close();
    }
}```

```java
import java.util.Scanner;

public class Ejercicio3SumaInteractiva {

    public static void main(String[] args) {
        
        Scanner sc = new Scanner(System.in);
        // Declaracion de variables
        int numeroIntroducido;
        int sumaTotal;

        System.out.println("--- Suma de Números ---");
        System.out.println("Introduce números para sumar. Escribe 0 para terminar y ver el resultado.");
        
        // Inicializamos la suma a 0
        sumaTotal = 0;

        // Usamos un bucle do-while para que pida un número al menos una vez
        do {
            System.out.print("Introduce un número: ");
            numeroIntroducido = sc.nextInt();

            // Añadimos el número a nuestra suma
            sumaTotal = sumaTotal + numeroIntroducido;

        } while (numeroIntroducido != 0); // El bucle se repite mientras el número NO sea 0

        System.out.println("\nLa suma total de los números es: " + sumaTotal);
        sc.close();
    }
}
```

```java
import java.util.Scanner;

public class Ejercicio4ValidadorEdad {

    public static void main(String[] args) {
        
        Scanner sc = new Scanner(System.in);
        // Declaracion de variables
        int edad;

        System.out.println("--- Validador de Edad ---");

        // Usamos un bucle do-while para obligar al usuario a meter una edad correcta
        do {
            System.out.print("Por favor, introduce tu edad (entre 1 y 120): ");
            edad = sc.nextInt();

            // Si la edad es incorrecta, mostramos un error
            if (edad < 1 || edad > 120) {
                System.out.println("Error: La edad debe ser un número entre 1 y 120. Inténtalo de nuevo.");
            }

        } while (edad < 1 || edad > 120); // El bucle se repite mientras la edad sea inválida

        System.out.println("\nEdad correcta registrada: " + edad + " años.");
        sc.close();
    }
}
```

```java
import java.util.Scanner;

public class Ejercicio5CalculadoraCalificaciones {

    public static void main(String[] args) {
        
        Scanner sc = new Scanner(System.in);
        // Declaracion de variables
        int totalCalificaciones;
        double sumaTotal;
        int i; // Variable para el bucle principal

        System.out.println("--- Calculadora de Promedio de Calificaciones ---");
        System.out.print("¿Cuántas calificaciones vas a introducir? ");
        totalCalificaciones = sc.nextInt();

        // Inicializamos la suma a 0
        sumaTotal = 0.0;

        // Bucle principal que se repite para pedir cada calificación
        for (i = 1; i <= totalCalificaciones; i++) {
            
            double calificacionActual; // Variable para guardar la calificación de esta vuelta

            // Bucle interior para validar que la calificación esté entre 0 y 10
            do {
                System.out.print("Introduce la calificación #" + i + " (de 0 a 10): ");
                calificacionActual = sc.nextDouble();

                if (calificacionActual < 0 || calificacionActual > 10) {
                    System.out.println("Error: La calificación no es válida. Inténtalo de nuevo.");
                }
            } while (calificacionActual < 0 || calificacionActual > 10);
            
            // Cuando la calificación es válida, la sumamos al total
            sumaTotal = sumaTotal + calificacionActual;
        }

        // Calculamos el promedio al final
        double promedio = sumaTotal / totalCalificaciones;

        System.out.println("\nEl promedio de las " + totalCalificaciones + " calificaciones es: " + promedio);
        sc.close();
    }
}
```

```java
import java.util.Scanner;

public class Ejercicio6MayorMenor {

    public static void main(String[] args) {
        
        Scanner sc = new Scanner(System.in);
        // Declaracion de variables
        int numeroMaximo;
        int numeroMinimo;
        int numeroActual;
        int i;

        System.out.println("--- El Número Mayor y Menor ---");
        System.out.println("Introduce 10 números y te diré cuál es el mayor y el menor.");

        // Pedimos el PRIMER número ANTES del bucle
        System.out.print("Introduce el número 1: ");
        numeroActual = sc.nextInt();

        // Como es el primer número, de momento es el más grande y el más pequeño
        numeroMaximo = numeroActual;
        numeroMinimo = numeroActual;

        // El bucle empieza en 2 porque ya hemos pedido el primer número
        for (i = 2; i <= 10; i++) {
            System.out.print("Introduce el número " + i + ": ");
            numeroActual = sc.nextInt();

            // Comparamos el nuevo número con nuestro máximo actual
            if (numeroActual > numeroMaximo) {
                numeroMaximo = numeroActual; // Si es más grande, lo guardamos como el nuevo máximo
            }

            // Comparamos el nuevo número con nuestro mínimo actual
            if (numeroActual < numeroMinimo) {
                numeroMinimo = numeroActual; // Si es más pequeño, lo guardamos como el nuevo mínimo
            }
        }
        
        System.out.println("\n--- Resultados ---");
        System.out.println("El número más grande introducido es: " + numeroMaximo);
        System.out.println("El número más pequeño introducido es: " + numeroMinimo);
        sc.close();
    }
}
```

```java
import java.util.Scanner;

public class Ejercicio7Fibonacci {

    public static void main(String[] args) {
        
        Scanner sc = new Scanner(System.in);
        // Declaracion de variables
        int cantidad;
        int anterior;
        int actual;
        int siguiente;
        int i;

        System.out.println("--- Secuencia de Fibonacci ---");
        System.out.print("¿Cuántos números de la secuencia quieres ver? ");
        cantidad = sc.nextInt();

        // Inicializamos los dos primeros números de la secuencia
        anterior = 0;
        actual = 1;

        System.out.println("Los primeros " + cantidad + " números de Fibonacci son:");
        
        // El bucle empieza en 1
        for (i = 1; i <= cantidad; i++) {
            System.out.print(anterior + " "); // Imprimimos el número "anterior"

            // Calculamos el siguiente número
            siguiente = anterior + actual;
            
            // Actualizamos las variables para la siguiente vuelta del bucle
            anterior = actual;
            actual = siguiente;
        }
        
        System.out.println(); // Para hacer un salto de línea al final
        sc.close();
    }
}
```