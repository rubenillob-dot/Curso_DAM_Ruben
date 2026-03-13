
 ### ¿Qué es `System.out.print`? 

 Imagina que quieres que tu programa en Java muestre un mensaje en la pantalla (la consola). `System.out.print()` es como darle la instrucción a Java de "escribir esto en la pantalla". 

 Lo más importante que debes recordar es que **`System.out.print()` escribe y deja el cursor justo al final de lo que escribió**, sin bajar a la siguiente línea. 

 --- 

 ### La diferencia clave: `print` vs. `println` 

 En Java, tienes dos formas principales de imprimir texto: 

 *  **`System.out.print()`**: Imprime el texto y mantiene el cursor en la misma línea. 
 *  **`System.out.println()`**: Imprime el texto y luego mueve el cursor a la siguiente línea (como si presionaras "Enter"). 

 **Ejemplo para que veas la diferencia:** 

 Imagina que escribes esto: 
 ```java
 System.out.print("Hola, ");
 System.out.print("mundo");
 ``` 
 **Salida:** 
 ```
 Hola, mundo
 ``` 
 Todo aparece en la misma línea porque usamos `print`. 

 Ahora, mira qué pasa con `println`: 
 ```java
 System.out.println("Hola, ");
 System.out.println("mundo");
 ``` 
 **Salida:** 
 ```
 Hola, 
 mundo
 ``` 
 Cada `println` imprime y luego salta a la siguiente línea. 

 --- 

 ### Ejemplos súper sencillos de cómo usar `System.out.print` 

 #### 1. Imprimir un texto simple 

 Puedes imprimir cualquier texto que quieras, siempre y cuando lo pongas entre comillas dobles. 

 ```java
 public class MiPrimerPrograma {
     public static void main(String[] args) {
         System.out.print("¡Bienvenidos a la programación en Java!");
     }
 }
 ``` 
 **Salida:** 
 ```
 ¡Bienvenidos a la programación en Java!
 ``` 

 #### 2. Imprimir varias cosas en la misma línea 

 Como `print` no hace un salto de línea, puedes usar varios `print` seguidos para construir una frase. 

 ```java
 public class MisSaludos {
     public static void main(String[] args) {
         System.out.print("Hola, ");
         System.out.print("mi nombre es ");
         System.out.print("Gemini.");
     }
 }
 ``` 
 **Salida:** 
 ```
 Hola, mi nombre es Gemini.
 ``` 

 #### 3. Imprimir números y variables 

 No solo puedes imprimir texto, también puedes mostrar números y el valor que guardan tus variables. Para combinar texto y variables, usamos el símbolo `+` (a esto se le llama "concatenar"). 

 ```java
 public class ImprimirVariables {
     public static void main(String[] args) {
         String nombre = "Juan";
         int edad = 25;
 
         System.out.print("Nombre: " + nombre);
         System.out.print(", Edad: " + edad);
     }
 }
 ``` 
 **Salida:** 
 ```
 Nombre: Juan, Edad: 25
 ``` 

 #### 4. Imprimir el resultado de una operación matemática 

 También puedes hacer cálculos directamente dentro de `System.out.print`. 

 ```java
 public class CalculadoraSimple {
     public static void main(String[] args) {
         System.out.print("El resultado de 5 + 3 es: ");
         System.out.print(5 + 3);
     }
 }
 ``` 
 **Salida:** 
 ```
 El resultado de 5 + 3 es: 8
 ``` 

 --- 

 ### Caracteres especiales para dar formato 

 A veces, aunque uses `print`, quieres tener más control sobre cómo se ve el texto. Para eso existen los "caracteres de escape". Los más comunes son: 

 *  **`\n`**: Para hacer un **salto de línea** donde tú quieras. 
 *  **`\t`**: Para añadir una **tabulación** (un espacio grande y ordenado). 

 **Ejemplo con salto de línea:** 

 ```java
 public class SaltoDeLinea {
     public static void main(String[] args) {
         System.out.print("Esta es la primera línea.\nEsta es la segunda línea.");
     }
 }
 ``` 
 **Salida:** 
 ```
 Esta es la primera línea.
 Esta es la segunda línea.
 ``` 

 **Ejemplo con tabulación para crear una tabla simple:** 

 ```java
 public class TablaSimple {
     public static void main(String[] args) {
         System.out.print("Producto\tCantidad\tPrecio");
         System.out.print("\nManzanas\t5\t\t$2.50");
     }
 }
 ``` 
 **Salida:** 
 ```
 Producto    Cantidad    Precio
 Manzanas    5           $2.50
 ``` 


 ¡Y eso es todo! Con estos ejemplos súper sencillos, ya tienes una buena idea de cómo funciona `System.out.print` y cómo puedes empezar a mostrar información en tus programas de Java.
