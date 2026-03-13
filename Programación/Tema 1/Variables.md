
### **Variables en Java**

Imagina que una variable es como una caja en la que puedes guardar algo. Para poder usar esa caja, necesitas saber tres cosas sobre ella:

*   **Un nombre:** Es la etiqueta que le pones a la caja para saber qué hay dentro y poder encontrarla fácilmente. Este nombre debe ser un identificador válido.
*   **Un tipo de dato:** Te dice qué clase de cosas puedes guardar en la caja. Por ejemplo, si es una caja para "números enteros" o para "letras".
*   **Un rango de valores:** Define los límites de lo que puedes guardar. Por ejemplo, si en una caja solo caben números del -128 al 127.

Un identificador en Java es simplemente el nombre que le damos a nuestras "cajas" (variables), y puede ser una secuencia de letras y números sin espacios.

A la hora de nombrar tus variables, aunque no es obligatorio, es muy recomendable seguir unas reglas de estilo para que tu código sea fácil de leer y entender por otros programadores.

*   **Java distingue mayúsculas de minúsculas.** Esto significa que si creas una variable llamada `edad` y otra llamada `Edad`, para Java son dos "cajas" completamente diferentes.
*   **No se suelen usar identificadores que empiecen con `$` o `_`.** Aunque es posible, por convenio no se utilizan para nombres de variables comunes para evitar confusiones.
*   **No puedes usar palabras que Java ya tiene reservadas para su funcionamiento**, como `true`, `false` o `null`.

La idea es que los nombres que elijas describan claramente lo que guardan. Por ejemplo, `nombreUsuario` es mucho más claro que `n`.

### **Convenciones sobre identificadores en JAVA**

Aquí tienes una guía de estilo para nombrar tus identificadores. Seguir estas convenciones hará que tu código se vea profesional y sea fácil de entender.

| Identificador | Convención | Ejemplo |
| :--- | :--- | :--- |
| **Nombre de variable** | Comienza con letra minúscula. Si el nombre tiene varias palabras, la primera empieza con minúscula y las siguientes con mayúscula (esto se llama *camelCase*). | `edad`, `nombreCompleto` |
| **Nombre de constante** | Se escribe todo en letras mayúsculas. Si tiene varias palabras, se separan con un guion bajo (`_`). | `PI`, `TASA_DE_INTERES` |
| **Nombre de clase** | La primera letra de cada palabra siempre va en mayúscula (esto se llama *PascalCase* o *UpperCamelCase*). | `String`, `Calculadora` |
| **Nombre de función (método)**| Igual que las variables, comienza con minúscula y usa *camelCase* para las siguientes palabras. | `calcularArea`, `obtenerNombre` |

### **Palabras reservadas**

Estas son palabras que Java utiliza para sus propias funciones internas. No puedes usarlas como nombres para tus variables, clases o métodos porque el programa no sabría si te refieres a tu variable o a una función interna de Java.

| | | | | |
| :--- | :--- | :--- | :--- | :--- |
| abstract | default | if | protected | throw |
| assert | do | implements | public | throws |
| boolean | double | import | return | transient |
| break | else | instanceof | short | try |
| byte | enum | int | static | void |
| case | extends | interface | strictfp | volatile |
| catch | final | long | super | while |
| char | finally | native | switch | yield |
| class | float | new | synchronized |
| const | for | package | this |
| continue | goto | private | |

### **Tipos de variables y Constantes**

En un programa, las variables se pueden clasificar de diferentes maneras:

*   **Según el tipo de dato que representan:**
    *   **Variables de tipos primitivos:** Guardan valores muy simples y directos, como un número (`10`) o una letra (`'A'`).
    *   **Variables de referencia:** No guardan el dato directamente, sino una "dirección" o referencia a dónde se encuentra el dato en la memoria, que suele ser algo más complejo como un texto o un objeto.

*   **Según si su valor puede cambiar:**
    *   **Variables:** Su valor puede cambiar en cualquier momento durante la ejecución del programa.
    *   **Constantes (o variables `final`):** Se les asigna un valor una sola vez y ese valor no puede cambiar nunca más. Son útiles para valores que siempre serán los mismos, como el número PI.

*   **Según dónde se declaran en el programa:**
    *   **Variables miembro:** Se declaran dentro de una clase pero fuera de cualquier método. Son como las "propiedades" de un objeto.
    *   **Variables locales:** Se declaran y usan dentro de un método o un bloque de código. Solo existen mientras ese método se está ejecutando.

### **Tipos de datos primitivos**

Son los tipos de datos más básicos y fundamentales en Java.

**Numéricos enteros**

| Tipo | Tamaño | Descripción y Rango | Ejemplo |
| :--- | :--- | :--- | :--- |
| **byte** | 1 byte | Guarda números enteros muy pequeños (-128 a 127). Ideal para ahorrar memoria. | `byte edad = 25;` |
| **short** | 2 bytes | Guarda números enteros pequeños (-32,768 a 32,767). | `short anio = 2024;` |
| **int** | 4 bytes | Es el tipo más común para números enteros (-2^31 a 2^31 - 1). | `int salario = 50000;` |
| **long** | 8 bytes | Para números enteros extremadamente grandes. Se debe añadir una `L` al final. | `long distanciaEstrella = 1000000000L;` |

**Numéricos de punto flotante (decimales)**

| Tipo | Tamaño | Descripción | Ejemplo |
| :--- | :--- | :--- | :--- |
| **float** | 4 bytes | Para números decimales con una precisión de unos 7 dígitos. Se debe añadir una `f` al final. | `float precio = 19.99f;` |
| **double** | 8 bytes | Para números decimales con doble precisión (unos 15 dígitos). Es el tipo por defecto para decimales. | `double pi = 3.1415926535;` |

**Otros tipos**

| Tipo | Tamaño | Descripción | Ejemplo |
| :--- | :--- | :--- | :--- |
| **boolean** | 1 bit | Solo puede tener dos valores: `true` (verdadero) o `false` (falso). Se usa para condiciones. | `boolean esMayorDeEdad = true;` |
| **char** | 2 bytes | Almacena un único carácter (letra, número, símbolo). Se escribe entre comillas simples (`' '`). | `char inicial = 'J';` |

### **Tipos de datos de referencia**

Estos tipos son más complejos porque no guardan el valor directamente, sino una referencia a un objeto en la memoria.

*   **String:** Aunque parece básico, no es un tipo primitivo. Se utiliza para guardar secuencias de caracteres (texto).
    *   `String nombre = "Juan Pérez";`
*   **Arreglos (Arrays):** Son colecciones de valores del mismo tipo.
    *   `int[] notas = {10, 8, 9, 7};`
*   **Objetos y Clases:** Son las estructuras más complejas que te permiten crear tus propios tipos de datos con sus propiedades y comportamientos.
    *   `MiClase objeto = new MiClase();`

### **Resumen de tipos de datos en Java**

| Tipo | Tamaño | Rango / Precisión |
| :--- | :--- | :--- |
| `byte` | 1 byte | -128 a 127 |
| `short` | 2 bytes | -32,768 a 32,767 |
| `int` | 4 bytes | -2^31 a 2^31 - 1 |
| `long` | 8 bytes | -2^63 a 2^63 - 1 |
| `float` | 4 bytes | Precisión de 6-7 dígitos decimales |
| `double` | 8 bytes | Precisión de 15 dígitos decimales |
| `boolean`| 1 byte | `true` o `false` |
| `char` | 2 bytes | Cualquier carácter Unicode (0 a 65,535) |

### **Declaración e inicialización**

Para poder usar una variable, primero debes crearla. Este proceso tiene dos pasos:

**1. Declaración de una variable**

Consiste en decir el **tipo** de dato que va a guardar y el **nombre** que le vas a dar. Al hacer esto, Java reserva un espacio en la memoria para esa variable.

**Sintaxis:** `tipo nombreVariable;`

**Ejemplos:**
```java
int edad;          // Declara una variable entera llamada edad
double salario;    // Declara una variable de punto flotante llamada salario
char letra;        // Declara una variable de tipo carácter llamada letra
```

**2. Inicialización de una variable**

Consiste en darle un valor inicial a esa variable. En Java, es obligatorio dar un valor a las variables locales antes de intentar usarlas.

**Sintaxis:** `nombreVariable = valor;`

**Ejemplos:**
```java
edad = 25;           // Inicializa la variable edad con el valor 25
salario = 3500.75;   // Inicializa la variable salario con el valor 3500.75
letra = 'A';         // Inicializa la variable letra con el carácter 'A'
```

**Declaración e inicialización en una sola línea (Lo más común)**

Para ahorrar tiempo y evitar errores, puedes declarar e inicializar una variable en la misma línea.

**Sintaxis:** `tipo nombreVariable = valor;`

**Ejemplos:**
```java
int edad = 25;                       // Declara e inicializa la variable edad con 25
double salario = 3500.75;            // Declara e inicializa la variable salario
char letra = 'A';                    // Declara e inicializa la variable letra
```

### **Ejemplo completo de tipos de datos primitivos**

Este es un programa simple que declara, inicializa y muestra por pantalla los diferentes tipos de datos primitivos.

```java
public class EjemploTiposDeDatos {

    public static void main(String[] args) {
        // Tipos numéricos enteros
        byte edad = 25;
        System.out.println("Valor byte (edad): " + edad);

        short anio = 2024;
        System.out.println("Valor short (año): " + anio);

        int poblacion = 1000000;
        System.out.println("Valor int (población): " + poblacion);

        long distanciaGalaxia = 9460730472580800L; // La 'L' es necesaria
        System.out.println("Valor long (distancia a otra galaxia en km): " + distanciaGalaxia);

        // Tipos numéricos con punto flotante (decimales)
        float temperatura = 36.6f; // La 'f' es necesaria
        System.out.println("Valor float (temperatura corporal): " + temperatura);

        double pi = 3.1415926535;
        System.out.println("Valor double (pi): " + pi);

        // Tipos booleanos y de caracteres
        boolean esProgramador = true;
        System.out.println("Valor boolean (es programador): " + esProgramador);

        char inicial = 'A';
        System.out.println("Valor char (inicial): " + inicial);
    }
}

```
