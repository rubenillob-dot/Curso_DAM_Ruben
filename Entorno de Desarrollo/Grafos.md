Claro que sí. Aquí tienes los **Grafos de Flujo de Control** representados en **ASCII Art vertical**, diseñados para que se visualice claramente el flujo de las decisiones (`if/else`) de arriba hacia abajo.

---

### 1. Grafo Vertical: `validarEdad` (Ejercicio 1)

Este grafo representa una estructura secuencial de decisiones. Si una condición se cumple, se sale del método ("early return"); si no, baja a la siguiente.

```text
               ( 1. Inicio )
                    |
                    v
             /------------\  
            | ¿edad < 0?   |-------(Sí)-------> [ 2. return false ]
             \------------/                         |
                    |                               |
                  (No)                              |
                    |                               |
                    v                               |
             /------------\                         |
            | ¿edad < 18?  |-------(Sí)-------> [ 3. return false ]
             \------------/                         |
                    |                               |
                  (No)                              |
                    |                               |
                    v                               |
            [ 4. return true ]                      |
                    |                               |
                    v                               v
             ((  5.  Fin del Método (Salida Unificada)  ))
```

**Explicación de Caminos:**
1.  **Camino 1:** Inicio -> `edad < 0` (Sí) -> Fin.
2.  **Camino 2:** Inicio -> `edad < 0` (No) -> `edad < 18` (Sí) -> Fin.
3.  **Camino 3:** Inicio -> `edad < 0` (No) -> `edad < 18` (No) -> `return true` -> Fin.

---

### 2. Grafo Vertical: `clasificarNota` (Ejercicio 2)

Este grafo representa una estructura en "escalera" (`if - else if - else if - else`). Todas las ramas positivas se unen al final para terminar el método.

```text
               ( 1. Inicio )
                    |
                    v
             /------------\
            | ¿nota >= 90? |-------(Sí)-------> [ 3. "Excelente" ]
             \------------/                         |
                    |                               |
                  (No)                              |
                    |                               |
                    v                               |
             /------------\                         |
            | ¿nota >= 70? |-------(Sí)-------> [ 5. "Bueno"     ]
             \------------/                         |
                    |                               |
                  (No)                              |
                    |                               |
                    v                               |
             /------------\                         |
            | ¿nota >= 50? |-------(Sí)-------> [ 7. "Aprobado"  ]
             \------------/                         |
                    |                               |
                  (No)                              |
                    |                               |
                    v                               |
            [ 8. "Reprobado" ]                      |
                    |                               |
                    |                               |
                    v                               v
             ((  9.  Fin del Método (Nodo de Salida)  ))
```

**Explicación de Caminos:**
1.  **Camino 1:** Inicio -> `>=90` (Sí) -> Fin.
2.  **Camino 2:** Inicio -> `>=90` (No) -> `>=70` (Sí) -> Fin.
3.  **Camino 3:** Inicio -> `>=90` (No) -> `>=70` (No) -> `>=50` (Sí) -> Fin.
4.  **Camino 4:** Inicio -> `>=90` (No) -> `>=70` (No) -> `>=50` (No) -> "Reprobado" -> Fin.

---

### 📝 Leyenda de Símbolos
*   `( ... )` : Nodo de Inicio o Fin.
*   `/ ... \` : Nodo de Decisión (Rombo en diagramas clásicos). Representa los `IF`.
*   `[ ... ]` : Nodo de Sentencia/Acción (Rectángulo). Representa los `return`.
*   `-->` : Aristas (Flujo de control). Indica hacia dónde va el programa.
