
# 📘 Cheat Sheet: Pruebas de Software (Caja Negra y Blanca) + JUnit 5

## 1. Pruebas de Caja Blanca (Teoría Estructural)
Se centran en la lógica interna del código (cómo está hecho).

### Conceptos Clave
*   **Grafo de Flujo de Control:** Representación visual del código.
    *   **Nodos:** Sentencias o decisiones.
    *   **Aristas (Flechas):** Flujo de ejecución.
*   **Complejidad Ciclomática (V(G)):** Métrica que indica la dificultad del código y el número **mínimo** de casos de prueba necesarios para cubrir todos los caminos independientes.
    *   *Fórmula rápida (Método de Predicados):* **V(G) = Nº de condiciones (`if`, `while`, `for`) + 1**.

---

## 2. Pruebas de Caja Negra (Teoría Funcional)
Se ignora el código. Se valida que la entrada genere la salida esperada.

*   **Particiones de Equivalencia:** Agrupar datos que se comportan igual (ej: todos los números positivos).
*   **Valores Límite (AVL):** Probar los bordes exactos de esos grupos (n, n-1, n+1).

---

## 3. Ejercicios Resueltos de Caja Negra (Análisis de Valores Límite)

### EJERCICIO 1: Validador de Email

#### Paso 1: Clases y Paso 2: Valores Límite
| Condición | Límite Válido (Frontera OK) | Límite No Válido (Frontera Error) |
| :--- | :--- | :--- |
| **Longitud Buzón** | 1 (Mínimo), 64 (Máximo) | 0 (Vacío), 65 (Excede) |
| **Longitud Dominio** | 2 (`.es`), 6 (`.museum`) | 1 (Muy corto), 7 (Muy largo) |
| **Longitud Total** | 254 (Máximo RFC) | 255 (Excede) |

> **💡 ¿Por qué se hace así?**
> Buscamos errores de "off-by-one" (por uno). Si el programador escribió `if (longitud < 64)` en lugar de `<= 64`, el valor 64 fallaría. Por eso probamos el 64 (debe entrar) y el 65 (debe rebotar).

### EJERCICIO 2: Validador de Contraseñas

#### Análisis de Rangos (Clases de Equivalencia)
Este ejercicio tiene "escalones" de seguridad según la longitud.

| Nivel de Seguridad | Rango | Prueba Límite Inferior | Prueba Límite Superior |
| :--- | :--- | :--- | :--- |
| **Inválido (Corto)** | 0 - 5 | 5 (Rechaza) | - |
| **Débil** | 6 - 7 | **6** (Acepta Débil) | **7** (Mantiene Débil) |
| **Medio** | 8 - 11 | **8** (Salta a Medio) | **11** (Mantiene Medio) |
| **Fuerte** | 12 - 15 | **12** (Salta a Fuerte) | **15** (Mantiene Fuerte) |
| **Muy Fuerte** | 16 - 128| **16** (Salta a Muy Fuerte)| 128 (Máximo) |

> **💡 ¿Por qué se hace así?**
> Aquí lo crítico es el **cambio de estado**. Debemos verificar que al pasar de 7 caracteres a 8, la etiqueta cambie de "Débil" a "Media". Si no probamos el 7 y el 8, no sabremos si el corte está bien definido.

---

## 4. Ejercicios Resueltos de Grafos (Caja Blanca) 🆕

A continuación, la resolución de los ejercicios del PDF de Grafos, explicando cómo pasar del código al diseño de prueba.

### EJERCICIO 1: Método `validarEdad`

**Código Analizado:**
```java
public boolean validarEdad(int edad){
    if (edad < 0){          // Nodo Decisión A
        return false;       // Nodo Salida 1
    } else if (edad < 18) { // Nodo Decisión B
        return false;       // Nodo Salida 1 (o 2 unificada)
    } else {
        return true;        // Nodo Salida 2
    }
}
```

**Análisis de Complejidad (V(G)):**
*   Tenemos 2 nodos de decisión (`if` y `else if`).
*   **Fórmula:** V(G) = 2 decisiones + 1 = **3**.
*   **Conclusión:** Necesitamos **3 caminos independientes** (Test Cases) para probar todo el código.

**Caminos y Casos de Prueba:**

| Camino (Ruta Lógica) | Valor de Entrada (`edad`) | Resultado Esperado | Explicación Lógica |
| :--- | :--- | :--- | :--- |
| **Camino 1** | `-1` | `false` | Evalúa el primer `if (edad < 0)` como **True**. Sale inmediatamente. |
| **Camino 2** | `5` | `false` | El primer `if` es **False**. Entra al segundo `if (edad < 18)` como **True**. |
| **Camino 3** | `20` | `true` | El primer `if` es **False**. El segundo `if` es **False**. Ejecuta el `else`. |

> **💡 ¿Por qué se hace así?**
> El grafo se bifurca dos veces.
> 1.  Primero chequea si es negativo. Si sí, termina.
> 2.  Si no es negativo, chequea si es menor de edad. Si sí, termina.
> 3.  Si no es ninguna de las anteriores, asume mayoría de edad.
> *Cada camino representa una ruta única desde el inicio hasta el final ("Fin") del método.*

---

### EJERCICIO 2: Método `clasificarNota`

**Código Analizado:**
```java
public String clasificarNota(int nota) {
    if (nota >= 90) return "Excelente";      // Decisión A
    else if (nota >= 70) return "Bueno";     // Decisión B
    else if (nota >= 50) return "Aprobado";  // Decisión C
    else return "Reprobado";                 // Caso Base
}
```

**Análisis de Complejidad (V(G)):**
*   Tenemos 3 nodos de decisión en cascada (`if` + `else if` + `else if`).
*   **Fórmula:** V(G) = 3 decisiones + 1 = **4**.
*   **Conclusión:** Necesitamos **4 caminos** para cubrir todas las clasificaciones posibles.

**Caminos y Casos de Prueba (Graph TD):**

| Camino | Valor de Entrada | ¿>= 90? | ¿>= 70? | ¿>= 50? | Salida |
| :--- | :--- | :--- | :--- | :--- | :--- |
| **1** | `95` | **Sí** (Entra) | - | - | "Excelente" |
| **2** | `80` | No | **Sí** (Entra) | - | "Bueno" |
| **3** | `60` | No | No | **Sí** (Entra)| "Aprobado" |
| **4** | `40` | No | No | No | "Reprobado"|

> **💡 ¿Por qué se hace así?**
> Es una estructura de **escalera (else-if ladder)**.
> *   Para llegar al camino 3 ("Aprobado"), la prueba **obligatoriamente** tiene que haber fallado las condiciones de "Excelente" y "Bueno" primero.
> *   La complejidad ciclomática de 4 nos confirma que no podemos probar esto con menos de 4 tests (uno por cada tipo de nota).

---

## 5. Pruebas Unitarias con JUnit 5

### Configuración Rápida
*   Añadir librería `junit-jupiter` al proyecto.
*   Crear clase `CalculadoraTest` en carpeta `test`.

### Annotations Principales
| Annotation | Uso |
| :--- | :--- |
| `@Test` | Define el método como una prueba. |
| `@BeforeEach` | Se ejecuta antes de CADA test (resetear datos). |
| `@BeforeAll` | Se ejecuta UNA vez al principio (static, conectar DB). |
| `@DisplayName`| Nombre bonito para la consola ("Test Sumar Dos Números"). |

### Aserciones (Assertions)
Lo que verifica si el test pasa o falla.
*   `assertEquals(esperado, actual)`: Para números o Strings.
*   `assertTrue(condicion)`: Para verificar booleanos.
*   `assertNotNull(objeto)`: Verificar que algo no sea nulo.
*   `assertThrows(Exception.class, () -> codigo)`: Verificar que el código explota como debe (control de errores).
