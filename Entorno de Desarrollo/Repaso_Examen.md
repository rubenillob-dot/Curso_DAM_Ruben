

# 📘 Cheat Sheet Extendida: Entornos de Desarrollo

## 1. Entornos Integrados de Desarrollo (IDE)
Un IDE es un software que centraliza las herramientas necesarias para desarrollar, compilar y depurar software.

### Componentes Detallados
1.  **Editor de Código:**
    *   **Coloreado de sintaxis:** Resalta palabras clave, variables y errores.
    *   **Autocompletado (Intellisense):** Sugiere métodos y variables mientras escribes.
    *   **Refactorización:** Permite cambiar nombres de variables o extraer métodos automáticamente en todo el proyecto.
2.  **Compilador / Intérprete:**
    *   Transforma el código fuente a lenguaje máquina o bytecode (ej. `.class` en Java).
    *   Gestiona el *Build* (construcción) del proyecto.
3.  **Depurador (Debugger):**
    *   **Ejecución paso a paso:** (`Step Over`, `Step Into`).
    *   **Breakpoints:** Puntos de parada para inspeccionar el estado del programa.
    *   **Inspección de variables:** Ver valores en tiempo real.
4.  **Gestor de Proyectos y Construcción:**
    *   Organiza la estructura de carpetas (ej: separar `src` de `test`).
    *   Gestiona dependencias (librerías externas como `.jar`).
5.  **Constructor de GUI (Graphical User Interface):**
    *   Editor visual ("Drag and drop") para diseñar ventanas, botones y formularios.
6.  **Herramientas Externas y Plugins:**
    *   Integración con Bases de Datos, Terminales, Servidores Web y Control de Versiones (Git).

### Clasificación de IDEs (Según tus diapositivas)
| IDE | Licencia | Lenguajes Principales | Notas |
| :--- | :--- | :--- | :--- |
| **Eclipse** | Libre | Java, C/C++, PHP, Python | Muy usado en educación y empresas. |
| **NetBeans** | Libre | Java, PHP, C/C++ | Oficial de Apache. |
| **IntelliJ IDEA** | Prop./Libre | Java, Kotlin, Python | Versión *Community* (Libre) y *Ultimate* (Pago). |
| **Visual Studio Code** | Libre | JS, TS, Python, C++, Java | Editor ligero extensible mediante **Plugins**. |
| **PyCharm** | Prop./Libre | Python | De JetBrains. |
| **Xcode** | Propietario | Swift, Objective-C | Solo para macOS/iOS. |
| **Visual Studio** | Propietario | C#, .NET, C++ | Entorno robusto de Microsoft. |

---

## 2. Pruebas de Caja Blanca (Estructurales)
Se centran en la lógica interna. Se busca garantizar que todas las instrucciones y caminos se ejecuten.

### Criterios de Cobertura (Jerarquía)
1.  **Cobertura de Sentencias:** Cada línea de código se ejecuta al menos una vez.
2.  **Cobertura de Decisiones (Ramas):** Cada `if` o bucle debe evaluarse a `true` y a `false` al menos una vez.
3.  **Cobertura de Condiciones:** En condiciones compuestas (ej: `if (A > 5 && B < 0)`), se evalúa cada parte atómica por separado.
4.  **Cobertura de Caminos:** Se prueban todos los recorridos posibles desde el inicio hasta el fin.
    *   **Regla para Bucles:** Deben probarse 3 escenarios:
        1.  Sin entrar al bucle (0 iteraciones).
        2.  Una sola iteración.
        3.  Dos o más iteraciones.

### Creación del Grafo de Flujo
Para calcular la complejidad, primero se dibuja el grafo:
*   **Secuencia:** Círculos (nodos) uno tras otro.
*   **IF (Condición simple):** Un nodo se bifurca en dos caminos que luego se unen.
*   **SWITCH (Selección múltiple):** Un nodo se bifurca en N caminos.
*   **WHILE / DO-WHILE:** Aristas que vuelven hacia atrás (ciclos).
*   **Condiciones Compuestas (AND / OR):**
    *   **AND (`&&`):** Si la primera es falsa, salta al final. Si es verdadera, evalúa la segunda. **Se crean dos nodos de decisión.**
    *   **OR (`||`):** Si la primera es verdadera, entra (éxito). Si es falsa, evalúa la segunda. **Se crean dos nodos de decisión.**

### Complejidad Ciclomática (V(G))
Define el número máximo de caminos independientes. Se calcula de 3 formas:
1.  **Fórmula Matemática:** `V(G) = Aristas (E) - Nodos (N) + 2`
2.  **Método de Regiones:** `V(G) = Número de regiones cerradas + 1 (la exterior)`
3.  **Método de Predicados:** `V(G) = Número de condiciones (nodos de decisión) + 1`

> **Nota:** Los nodos secuenciales que no tienen decisiones (ej: asignaciones de variables) se pueden agrupar para simplificar el grafo sin afectar la complejidad.

---

## 3. Pruebas de Caja Negra (Funcionales)
Se ignora el código. Se valida que "Entrada X produzca Salida Y".

### A. Particiones de Equivalencia
Divide los datos de entrada en clases donde se asume que el programa se comporta igual.
*   **Regla:** Si un caso de la clase funciona, se asume que todos los de esa clase funcionan.
*   **Identificación:**
    *   *Rango Numérico (1-100):* 1 clase válida (50), 2 inválidas (0, 101).
    *   *Conjunto (Coche, Moto, Camión):* 1 válida por cada tipo, 1 inválida (Barco).
    *   *Booleano:* 1 Verdadero, 1 Falso.

### B. Análisis de Valores Límite (AVL)
Complementa a las particiones. Los errores suelen estar en los bordes.
*   Se seleccionan los valores exactos de los límites y sus adyacentes inmediatos.
*   **Ejemplo:** Si `edad` válida es `[18, 65]`:
    *   **Límite Inferior:** 17 (Inválido), 18 (Válido).
    *   **Límite Superior:** 65 (Válido), 66 (Inválido).
    *   *A veces se incluye:* Justo encima, justo debajo y el valor exacto.

### C. Conjetura de Errores (Error Guessing)
Lista de comprobación basada en la experiencia para romper el programa.
*   **Entradas vacías:** Strings de longitud 0, `null`.
*   **Espacios en blanco:** `"   "`.
*   **Tipos incorrectos:** Texto en campos numéricos (`"doce"` en lugar de `12`).
*   **Inyección de código:** `<script>alert('hack')</script>` o SQL Injection.
*   **Fechas:** 29 de febrero en año no bisiesto, fechas futuras imposibles.
*   **Desbordamiento:** Números más grandes que `Integer.MAX_VALUE`.

---

## 4. Pruebas Unitarias con JUnit 5

### Configuración del Proyecto
1.  **Estructura:**
    *   `src`: Código fuente de la aplicación.
    *   `test`: Código de las pruebas unitarias.
2.  **Dependencias:** Se añade la librería `.jar` de JUnit 5 (generalmente `junit-jupiter`) al *Build Path* o mediante Maven/Gradle.
3.  **Clase de Test:** Se crea una clase nueva (ej: `CalculadoraTest`) que replica la estructura de paquetes de la clase original.

### Annotations (Ciclo de Vida)
| Etiqueta | Descripción Detallada |
| :--- | :--- |
| `@Test` | Marca un método como una prueba unitaria. |
| `@DisplayName("Nombre")` | Define un nombre legible para el reporte de ejecución (ej: "Test Suma Positivos"). |
| `@BeforeEach` | Ejecuta código **antes** de cada test individual (ej: `new Calculadora()`). |
| `@AfterEach` | Ejecuta código **después** de cada test (ej: cerrar conexión DB). |
| `@BeforeAll` | Ejecuta código **una vez** antes de todos los tests de la clase. Debe ser `static`. |
| `@AfterAll` | Ejecuta código **una vez** al finalizar todos los tests. Debe ser `static`. |
| `@Disabled` | Deshabilita el test temporalmente (aparece como "saltado"). |
| `@RepeatedTest(n)` | Ejecuta el mismo test `n` veces seguidas. |

### Tests Parametrizados (`@ParameterizedTest`)
Permiten ejecutar el mismo test muchas veces con diferentes datos.
*   **`@ValueSource(ints = {1, 3, 5})`**: Pasa un array de valores simples.
*   **`@CsvSource({"1, 2, 3", "2, 3, 5"})`**: Pasa múltiples argumentos (ej: a, b, resultadoEsperado).

### Assertions (Aserciones)
Métodos estáticos de la clase `Assertions`. Si fallan, el test se detiene (Fail).

```java
// Igualdad
assertEquals(esperado, actual, "Mensaje de error opcional");
assertNotEquals(noEsperado, actual);

// Booleanos y Nulos
assertTrue(condicion);
assertFalse(condicion);
assertNull(objeto);
assertNotNull(objeto);

// Comparar Arrays/Iterables
assertArrayEquals(arrayEsperado, arrayActual);

// Excepciones (Verifica que el código lance un error específico)
assertThrows(ArithmeticException.class, () -> {
    int x = 1 / 0;
});

// Assert All (Agrupamiento)
// Ejecuta TODAS las validaciones dentro, aunque falle la primera.
assertAll("Validar Usuario",
    () -> assertEquals("Juan", usuario.getNombre()),
    () -> assertTrue(usuario.isActivo())
);
```

### Assumptions (Suposiciones)
Métodos de la clase `Assumptions`. Si no se cumplen, el test se **cancela** (Abort), no falla. Se usa para condiciones externas.
*   `assumeTrue(System.getProperty("os.name").startsWith("Linux"));` -> Si no es Linux, el test no corre.