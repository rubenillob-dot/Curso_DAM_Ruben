# Base Datos Tema 4

Clase: Bases de Datos  (https://www.notion.so/Bases-de-Datos-27f981b058b981bf8ebfead9b305af80?pvs=21)
Estado: En curso
Tipo: Entrega

# 📘 Guía de Apuntes : Realización de Consultas SQL

## 1. La sentencia SELECT

### 1.1 y 1.3. Cláusulas SELECT y FROM (Obligatorias)

Definen **qué** quieres ver y **de dónde** lo vas a sacar.

```sql
-- 1. Ver absolutamente toda la tabla
SELECT * FROM Empleados;

-- 2. Ver columnas específicas
SELECT nombre, apellido, departamento FROM Empleados;

-- 3. Ver valores únicos (ej: ¿Qué departamentos distintos existen en la empresa?)
SELECT DISTINCT departamento FROM Empleados;
```

### 1.4. Cláusula WHERE (Opcional)

Aplica un filtro. Piensa en el `WHERE` como un guardia de seguridad que revisa fila por fila y pregunta: *"¿Cumples esta condición? Si es sí, pasas; si es no, te quedas fuera"*.

```sql
-- Ver empleados de un departamento específico
SELECT nombre, apellido
FROM Empleados
WHERE departamento = 'Recursos Humanos';
```

### 1.5. Ordenación de registros: ORDER BY (Opcional)

Ordena la salida final. Siempre va al final de la consulta. Puedes ordenar por múltiples columnas.

- `ASC` (Ascendente): De A a Z, o de 0 a 9.
- `DESC` (Descendente): De Z a A, o de 9 a 0.

```sql
-- Ordenar por departamento de la A a la Z, y si hay empates, por salario de mayor a menor
SELECT nombre, departamento, salario_base
FROM Empleados
ORDER BY departamento ASC, salario_base DESC;
```

---

## 2. Operadores

### 2.1. Operadores de comparación

Comparan el valor de una columna con otro valor.

```sql
-- Igual a (=)
SELECT nombre FROM Empleados WHERE edad = 30;

-- Diferente de (<> o !=)
SELECT nombre, departamento FROM Empleados WHERE departamento <> 'Ventas';

-- Mayor que (>) y Menor que (<)
SELECT nombre, salario_base FROM Empleados WHERE salario_base > 3000;
SELECT nombre, edad FROM Empleados WHERE edad < 25;

-- Mayor o igual (>=) y Menor o igual (<=)
SELECT nombre FROM Empleados WHERE salario_base >= 1500;
```

### 2.3. Operadores Aritméticos y de Concatenación

### A) Operadores Aritméticos (`+`, , , `/`)

Permiten hacer cálculos matemáticos directamente en la consulta.

```sql
-- SUMA (+): Calcular el salario total (base + comisión)
SELECT nombre, salario_base, comision, (salario_base + comision)
FROM Empleados;

-- RESTA (-): Calcular cuánto le falta a un empleado para llegar a un salario meta de 5000
SELECT nombre, salario_base, (5000 - salario_base)
FROM Empleados;

-- MULTIPLICACIÓN (*): Calcular el salario anual (mensual x 12)
SELECT nombre, (salario_base * 12)
FROM Empleados;

-- DIVISIÓN (/): Calcular el salario diario estimado (mensual / 30)
SELECT nombre, (salario_base / 30)
FROM Empleados;
```

### B) Operadores de Concatenación

Sirven para pegar o unir cadenas de texto. *(Nota: La sintaxis cambia según el motor de base de datos).*

```sql
-- ESTÁNDAR / ORACLE / POSTGRESQL (Usa doble tubería || )
-- Crea una frase completa combinando columnas y texto fijo
SELECT nombre || ' ' || apellido || ' trabaja en ' || departamento
FROM Empleados;

-- SQL SERVER (Usa el signo + )
SELECT nombre + ' ' + apellido + ' trabaja en ' + departamento
FROM Empleados;

-- MYSQL (Usa la función CONCAT)
SELECT CONCAT(nombre, ' ', apellido, ' trabaja en ', departamento)
FROM Empleados;
```

### 2.4. Operadores Lógicos

Estos evalúan si una condición es verdadera o falsa, y permiten combinar múltiples filtros.

**1. `AND` (Y):** TODAS las condiciones deben cumplirse.

```sql
-- Empleados de Ventas que además tengan más de 30 años
SELECT nombre FROM Empleados
WHERE departamento = 'Ventas' AND edad > 30;
```

**2. `OR` (O):** Basta con que UNA de las condiciones se cumpla.

```sql
-- Empleados que sean de 'IT' o que ganen más de 4000 (no importa su departamento)
SELECT nombre, departamento, salario_base FROM Empleados
WHERE departamento = 'IT' OR salario_base > 4000;
```

**3. `NOT` (NO):** Invierte el resultado de la condición.

```sql
-- Empleados que NO pertenezcan al departamento de 'IT'
SELECT nombre FROM Empleados
WHERE NOT departamento = 'IT';
```

**4. `IN` (En una lista):** Es una forma abreviada de usar múltiples `OR`.

```sql
-- Empleados que trabajen en IT, Finanzas o Ventas
SELECT nombre, departamento FROM Empleados
WHERE departamento IN ('IT', 'Finanzas', 'Ventas');

-- NOT IN: Empleados que no trabajen en esos departamentos
SELECT nombre, departamento FROM Empleados
WHERE departamento NOT IN ('IT', 'Finanzas', 'Ventas');
```

**5. `BETWEEN` (Entre):** Busca valores dentro de un rango inclusivo (incluye los límites).

```sql
-- Empleados que ganan entre 2000 y 3000
SELECT nombre, salario_base FROM Empleados
WHERE salario_base BETWEEN 2000 AND 3000;

-- NOT BETWEEN: Empleados que ganan menos de 2000 o más de 3000
SELECT nombre, salario_base FROM Empleados
WHERE salario_base NOT BETWEEN 2000 AND 3000;
```

**6. `LIKE` (Como/Patrón):** Busca patrones de texto.

- `%`: Representa cero, uno o múltiples caracteres.
- `_`: Representa exactamente un solo carácter.

```sql
-- Empleados cuyo nombre empieza con 'M' (ej: María, Marcos)
SELECT nombre FROM Empleados WHERE nombre LIKE 'M%';

-- Empleados cuyo nombre termina en 'a' (ej: Ana, Laura)
SELECT nombre FROM Empleados WHERE nombre LIKE '%a';

-- Empleados cuyo nombre tiene 'ar' en cualquier parte (ej: M"ar"ía, M"ar"cos, C"ar"los)
SELECT nombre FROM Empleados WHERE nombre LIKE '%ar%';

-- Empleados cuyo nombre tiene exactamente 4 letras y empieza con 'J' (ej: Juan, Jose)
SELECT nombre FROM Empleados WHERE nombre LIKE 'J___';
```

**7. `IS NULL` / `IS NOT NULL` (Es Nulo):** Las bases de datos usan `NULL` para representar "ausencia de datos". No se puede usar `=` para buscar nulos.

```sql
-- Empleados que NO tienen asignada una comisión (el campo está vacío/nulo)
SELECT nombre FROM Empleados WHERE comision IS NULL;

-- Empleados que SÍ tienen alguna comisión asignada
SELECT nombre FROM Empleados WHERE comision IS NOT NULL;
```

### 2.6. Precedencia

Controla qué operador se evalúa primero cuando hay varios en el `WHERE`. Los **paréntesis `()`** son tu mejor amigo para evitar errores lógicos. El `AND` siempre se procesa antes que el `OR` si no hay paréntesis.

> 💡 **Ejemplo Clave:**
Queremos darle un bono a los empleados que cumplan este perfil:
Deben ser de **IT** o de **Finanzas**, y **además** deben ganar **más de 3000**.
> 

```sql
-- ❌ LA FORMA INCORRECTA (Sin paréntesis)
-- El motor SQL agrupará primero el AND: (Finanzas AND >3000).
-- Resultado: Traerá a TODOS los de IT (sin importar su salario) y solo a los de Finanzas que ganen más de 3000.
SELECT nombre, departamento, salario_base FROM Empleados
WHERE departamento = 'IT' OR departamento = 'Finanzas' AND salario_base > 3000;

-- ✅ LA FORMA CORRECTA (Con paréntesis)
-- Obligamos a resolver primero qué departamentos nos interesan, y a ESE grupo le aplicamos el filtro del salario.
SELECT nombre, departamento, salario_base FROM Empleados
WHERE (departamento = 'IT' OR departamento = 'Finanzas') AND salario_base > 3000;
```

---

## 3. Consultas calculadas

Cuando usamos operadores aritméticos o de concatenación, la base de datos devuelve esa columna con un nombre muy feo (la fórmula misma). Para darle un nombre presentable y profesional, usamos el alias **`AS`**.

```sql
-- Consulta sencilla calculada: Darle formato de reporte a la tabla
SELECT
    nombre AS "Nombre del Trabajador",
    (salario_base + 500) AS Salario_Proyectado_Con_Aumento
FROM Empleados;
```

### 🚀 LA CONSULTA FINAL MAESTRA (Combinando todo)

*Vamos a hacer un reporte complejo. Queremos un listado que muestre una "Ficha del empleado" en una sola columna de texto, además de calcular cuánto cobrarían en total al año (salario + comisión) para aquellos empleados que tienen comisión, que ganan más de 1500, y que pertenecen a IT o Ventas. Finalmente, queremos a los que más ganan arriba en la lista.*

```sql
SELECT
    -- 1. Concatenación con Alias (Consulta Calculada)
    nombre || ' ' || apellido || ' del área de ' || departamento AS "Ficha_Empleado",

    -- 2. Aritmética con Alias (Consulta Calculada)
    ((salario_base + comision) * 12) AS "Ingreso_Total_Anual"
FROM
    Empleados
WHERE
    -- 3. Operador Lógico (Es Nulo)
    comision IS NOT NULL
    -- 4. Operador Lógico (AND y Precedencia con paréntesis y OR)
    AND (departamento = 'IT' OR departamento = 'Ventas')
    -- 5. Operador de Comparación
    AND salario_base > 1500
ORDER BY
    -- 6. Ordenación descendente basada en la columna calculada
    "Ingreso_Total_Anual" DESC;
```

---

# 📘 Guía de Apuntes: Funciones, Resúmenes y Agrupaciones en SQL

## 📌 Introducción: La tabla `DUAL`

Antes de empezar, el texto menciona la tabla `DUAL`. En Oracle, es una tabla especial temporal que tiene una sola columna y una sola fila. Se usa para hacer pruebas, cálculos matemáticos o probar funciones sin necesidad de consultar una tabla real que tenga miles de registros.

```sql
-- Ejemplo de uso de DUAL para una simple calculadora:
SELECT (50 * 2) AS resultado FROM DUAL;
```

---

## 1. Funciones (Funciones de una sola fila/Escalares)

Las funciones actúan sobre los datos de **cada fila individualmente** y devuelven un resultado por cada fila. Transforman el dato antes de mostrarlo.

### 1.1. Funciones numéricas

Realizan operaciones matemáticas complejas.

- **`ROUND(número, decimales)`**: Redondea al decimal más cercano.
- **`TRUNC(número, decimales)`**: Trunca (corta) los decimales sin redondear.
- **`MOD(dividendo, divisor)`**: Devuelve el resto de una división.

**Ejemplos:**

```sql
-- Probando en DUAL
SELECT ROUND(45.926, 2), TRUNC(45.926, 2) FROM DUAL;
-- Resultado: 45.93 (redondeado) y 45.92 (cortado)

-- Aplicado a nuestra tabla (ej: calcular un bono del 15.5% del salario redondeado a 0 decimales)
SELECT nombre, salario_base, ROUND(salario_base * 0.155, 0) AS bono_calculado
FROM Empleados;
```

### 1.2. Funciones de cadenas de caracteres

Modifican el texto.

- **`UPPER(texto)`**: Convierte todo a MAYÚSCULAS.
- **`LOWER(texto)`**: Convierte todo a minúsculas.
- **`INITCAP(texto)`**: Primera letra de cada palabra en Mayúscula.
- **`SUBSTR(texto, inicio, longitud)`**: Extrae un pedazo del texto.
- **`LENGTH(texto)`**: Cuenta cuántos caracteres tiene la palabra.

**Ejemplos:**

```sql
SELECT
    UPPER(apellido) AS apellido_mayus,
    LOWER(departamento) AS depto_minus,
    LENGTH(nombre) AS letras_en_nombre,
    SUBSTR(nombre, 1, 3) AS primeras_3_letras -- Ej: de 'Carlos' saca 'Car'
FROM Empleados;
```

### 1.3. Funciones de manejo de fechas

- **`SYSDATE`**: Devuelve la fecha y hora actual del sistema.
- **`MONTHS_BETWEEN(fecha1, fecha2)`**: Calcula los meses transcurridos entre dos fechas.
- **`ADD_MONTHS(fecha, cantidad)`**: Suma o resta meses a una fecha.

**Ejemplos:**

```sql
SELECT
    nombre,
    fecha_contrato,
    -- ¿Cuántos meses lleva trabajando en la empresa desde que entró hasta HOY?
    ROUND(MONTHS_BETWEEN(SYSDATE, fecha_contrato), 0) AS meses_antiguedad,
    -- ¿Cuándo fue (o será) su evaluación a los 6 meses de contrato?
    ADD_MONTHS(fecha_contrato, 6) AS fecha_evaluacion
FROM Empleados;
```

### 1.4. Funciones de conversión

Transforman un tipo de dato en otro. En Oracle, **`TO_CHAR`** es la estrella para dar formato visual.

- **`TO_CHAR(fecha o numero, 'formato')`**: Convierte a texto con el formato deseado.
- **`TO_DATE(texto, 'formato')`**: Convierte un texto en fecha real.

**Ejemplos:**

```sql
SELECT
    nombre,
    -- Convertir número a formato moneda (Ej: $ 2,500.00)
    TO_CHAR(salario_base, '$99,999.00') AS salario_formateado,

    -- Convertir fecha a texto legible (Ej: 15 de Febrero de 2023)
    TO_CHAR(fecha_contrato, 'DD "de" Month "de" YYYY') AS fecha_bonita
FROM Empleados;
```

### 1.5. Otras funciones: NVL y DECODE

- **`NVL(columna, valor_sustituto)`**: Si la columna es `NULL` (vacía), la reemplaza por el valor que le digas. Es vital para no dañar operaciones matemáticas (un número + NULL = NULL).
- **`DECODE(columna, buscar1, resultado1, buscar2, resultado2, valor_por_defecto)`**: Funciona como un "IF-THEN-ELSE" (Si pasa esto, pon esto).

**Ejemplos:**

```sql
SELECT
    nombre,
    -- NVL: Si comision es NULA, trátala como un 0 para poder sumarla al salario.
    salario_base + NVL(comision, 0) AS sueldo_total_real,

    -- DECODE: Traducir los nombres de los departamentos
    DECODE(departamento,
           'IT', 'Tecnología',
           'HR', 'Recursos Humanos',
           'Desconocido') AS departamento_traducido
FROM Empleados;
```

---

## 2. Consultas de resumen (Funciones de Agregado)

A diferencia de las anteriores, estas funciones **toman múltiples filas y devuelven un único valor resumido**.

### 2.1. Funciones: SUM y COUNT

- **`COUNT(*)`**: Cuenta cuántas filas existen en total.
- **`COUNT(columna)`**: Cuenta cuántos valores NO nulos hay en esa columna.
- **`SUM(columna)`**: Suma todos los valores de una columna numérica.

**Ejemplo:** *(Imagina que esta consulta resume a TODA la empresa en una sola fila)*

```sql
SELECT
    COUNT(*) AS total_empleados_empresa,
    COUNT(comision) AS empleados_que_cobran_comision,
    SUM(salario_base) AS gasto_total_en_nominas
FROM Empleados;
```

### 2.3. Funciones: MIN y MAX

Encuentran el valor más bajo y más alto respectivamente. Funcionan con números, fechas (fecha más antigua/reciente) y texto (A-Z).

**Ejemplo:**

```sql
SELECT
    MIN(salario_base) AS salario_mas_bajo,
    MAX(fecha_contrato) AS empleado_mas_novato, -- La fecha más cercana a hoy
    MIN(apellido) AS primer_apellido_alfabetico
FROM Empleados;
```

### 2.4. Funciones: AVG, VAR, STDEV

Funciones estadísticas.

- **`AVG(columna)`**: Average (Promedio).
- **`VARIANCE(columna)` / `STDDEV(columna)`**: Varianza y Desviación estándar (qué tan dispersos están los datos respecto al promedio).

**Ejemplo:**

```sql
SELECT
    AVG(salario_base) AS salario_promedio_empresa,
    STDDEV(salario_base) AS desviacion_salarial
FROM Empleados;
```

---

## 3. Agrupamiento de registros (`GROUP BY`)

Aquí es donde ocurre la magia. ¿Qué pasa si no quiero el salario promedio de *toda* la empresa, sino **el salario promedio POR departamento**?

Para eso usamos la cláusula **`GROUP BY`**. Agrupa las filas que tienen los mismos valores en las columnas especificadas, y luego aplica las funciones de resumen (agregado) a cada grupo.

> ⚠️ **REGLA ESTRICTA DE SQL:** Toda columna que esté en el `SELECT` y que **NO** tenga una función de agregado (SUM, MAX, AVG...), **TIENE** que estar obligatoriamente escrita en el `GROUP BY`.
> 

### Ejemplo básico de Agrupamiento:

```sql
-- Queremos saber cuántos empleados hay y cuánto se gasta en salarios POR CADA departamento
SELECT
    departamento,
    COUNT(*) AS cantidad_empleados,
    SUM(salario_base) AS gasto_salarial
FROM Empleados
GROUP BY departamento;
-- El motor agrupa a todos los de 'IT', suma sus datos; luego agrupa a 'Ventas', suma sus datos, etc.
```

### Agrupamiento con Filtro (`HAVING`)

Así como el `WHERE` filtra filas individuales *antes* de agrupar, el **`HAVING` filtra los grupos *después* de haber hecho el cálculo de resumen**.

**Ejemplo:**

```sql
-- Mostrar el gasto salarial por departamento, PERO SOLO de aquellos departamentos
-- donde trabajan estrictamente más de 5 personas.
SELECT
    departamento,
    COUNT(*) AS cantidad_empleados,
    SUM(salario_base) AS gasto_salarial
FROM Empleados
GROUP BY departamento
HAVING COUNT(*) > 5; -- Se usa HAVING, no WHERE, porque estamos filtrando sobre un cálculo agrupado.
```

---

## 🚀 LA CONSULTA FINAL MAESTRA (Combinando Secciones 1, 2 y 3)

*Vamos a hacer un reporte gerencial avanzado:"Necesito un reporte que muestre el **nombre del departamento en mayúsculas**, el **número total de empleados** en ese departamento, y el **costo salarial real promedio (formateado como dinero)**. El 'costo salarial real' debe incluir el salario base más las comisiones (tratando nulos como 0). Solo quiero ver los departamentos cuyo costo promedio real sea **mayor a $3000**. Finalmente, quiero que la lista esté **ordenada alfabéticamente** por el nombre del departamento."*

```sql
SELECT
    -- 1.2. Función de texto: Mayúsculas
    UPPER(departamento) AS DEPARTAMENTO,

    -- 2.1. Función de Agregado: Conteo
    COUNT(*) AS TOTAL_EMPLEADOS,

    -- 1.4. Formato, 2.4. Promedio y 1.5. Manejo de nulos (NVL)
    -- Calculamos el total real por persona, le sacamos el promedio al grupo, y lo convertimos a texto con formato de dólar.
    TO_CHAR(AVG(salario_base + NVL(comision, 0)), '$999,999.00') AS PROMEDIO_SALARIO_REAL

FROM
    Empleados

-- 3. Agrupamiento: Agrupamos por departamento original
GROUP BY
    departamento

-- 3. Filtro de grupo: Solo mostramos grupos donde el promedio matemático supera los 3000
HAVING
    AVG(salario_base + NVL(comision, 0)) > 3000

-- Ordenamiento final basado en el texto en mayúsculas
ORDER BY
    UPPER(departamento) ASC;
```

---

# 📘 Guía de Apuntes: Consultas Multitabla y Subconsultas

---

## 1. Consultas Multitablas

Para consultar campos de varias tablas a la vez, debemos "cruzarlas" o "unirlas".

### 1.1. Composiciones internas (Sintaxis Tradicional/Antigua)

Es la forma clásica de unir tablas. Se ponen todas las tablas en el `FROM` separadas por comas, y la condición de unión se pone en el `WHERE`.

> 💡 **Tip:** Cuando usas varias tablas, es muy recomendable usar **Alias de tabla** (apodos cortos) para no tener que escribir el nombre completo de la tabla cada vez.
> 

**Ejemplo:**
Queremos ver el nombre del empleado y el nombre del departamento en el que trabaja.

```sql
SELECT e.nombre, d.nombre_dept
FROM EMPLEADOS e, DEPARTAMENTOS d
WHERE e.id_dept = d.id_dept; -- ¡Esta es la condición que las une!
```

*Si no pones el `WHERE`, SQL mezclará a todos los empleados con todos los departamentos creando un caos llamado "Producto Cartesiano".*

### 1.4. Composiciones en la versión SQL99 (Sintaxis Moderna con JOIN)

*Nota: Salto al 1.4 porque es la forma moderna y estándar de hacer lo que vimos en el 1.1 y 1.3. Hoy en día, **siempre deberías usar esta sintaxis**.*

En lugar de usar comas y el `WHERE`, usamos la palabra clave **`JOIN`** (unir) y la palabra **`ON`** (donde especificamos cómo se relacionan).

### A) INNER JOIN (Composición Interna SQL99)

Devuelve **SOLO** las filas que tienen coincidencias en **AMBAS** tablas.

**Ejemplo:**

```sql
-- Hace exactamente lo mismo que el ejemplo 1.1, pero de forma más limpia
SELECT e.nombre, d.nombre_dept
FROM EMPLEADOS e
INNER JOIN DEPARTAMENTOS d ON e.id_dept = d.id_dept;
```

### 1.3. Composiciones externas (OUTER JOINS)

¿Qué pasa si tenemos un departamento recién creado que aún no tiene empleados? ¿O un empleado nuevo al que aún no le asignan departamento? Un `INNER JOIN` los ignoraría a ambos. Las composiciones externas sirven para **no perder datos de una tabla, aunque no tengan pareja en la otra**.

### A) LEFT JOIN (o LEFT OUTER JOIN)

Muestra **TODOS** los registros de la tabla de la "Izquierda" (la primera que escribes), y si tienen pareja en la tabla derecha, la muestra. Si no, pone valores `NULL`.

**Ejemplo:**
Queremos ver **todos** los empleados, y si tienen departamento, que lo muestre. Si hay un empleado "huérfano" sin departamento, aparecerá igual.

```sql
SELECT e.nombre, d.nombre_dept
FROM EMPLEADOS e          -- Tabla Izquierda (Manda)
LEFT JOIN DEPARTAMENTOS d -- Tabla Derecha (Se acopla)
  ON e.id_dept = d.id_dept;
```

### B) RIGHT JOIN (o RIGHT OUTER JOIN)

Es lo inverso. Muestra **TODOS** los registros de la tabla de la "Derecha" (la que pones después del JOIN).

**Ejemplo:**
Queremos ver **todos** los departamentos, incluso aquellos que actualmente tienen 0 empleados.

```sql
SELECT d.nombre_dept, e.nombre
FROM EMPLEADOS e           -- Tabla Izquierda
RIGHT JOIN DEPARTAMENTOS d -- Tabla Derecha (Manda)
  ON e.id_dept = d.id_dept;
```

---

### 1.5. Unión, intersección y diferencia de consultas (Operadores de Conjuntos)

A diferencia de los `JOIN` (que unen columnas lado a lado), los operadores de conjuntos **unen filas** de dos consultas `SELECT` independientes (una debajo de la otra).

*Reglas de oro:* Ambas consultas deben devolver la **misma cantidad de columnas** y ser de **tipos de datos compatibles**.

- **`UNION`**: Junta los resultados de ambas consultas y **elimina los duplicados**. (Si quieres mantener duplicados, usa `UNION ALL`).
- **`INTERSECT`**: Muestra SOLO las filas que son idénticas en el resultado de AMBAS consultas.
- **`MINUS`** (en Oracle) o **`EXCEPT`** (en otros motores): Muestra las filas de la primera consulta que NO están en la segunda.

**Ejemplos Conceptuales:**
Imagina que generamos dos listas:
Consulta A: Empleados que ganan más de 3000.
Consulta B: Empleados que trabajan en el departamento 'IT'.

```sql
-- UNION: La lista final tendrá a los que ganan > 3000 O son de IT (o ambas).
SELECT id_empleado, nombre FROM EMPLEADOS WHERE salario > 3000
UNION
SELECT e.id_empleado, e.nombre FROM EMPLEADOS e INNER JOIN DEPARTAMENTOS d ON e.id_dept = d.id_dept WHERE d.nombre_dept = 'IT';

-- INTERSECT: La lista final SOLO tendrá a los empleados de IT que ADEMÁS ganan > 3000.
SELECT id_empleado, nombre FROM EMPLEADOS WHERE salario > 3000
INTERSECT
SELECT e.id_empleado, e.nombre FROM EMPLEADOS e INNER JOIN DEPARTAMENTOS d ON e.id_dept = d.id_dept WHERE d.nombre_dept = 'IT';

-- MINUS: La lista final tendrá a los que ganan > 3000, PERO excluyendo a los que sean de IT.
SELECT id_empleado, nombre FROM EMPLEADOS WHERE salario > 3000
MINUS
SELECT e.id_empleado, e.nombre FROM EMPLEADOS e INNER JOIN DEPARTAMENTOS d ON e.id_dept = d.id_dept WHERE d.nombre_dept = 'IT';
```

---

### 1.6. Subconsultas

Una subconsulta es **una consulta `SELECT` anidada dentro de otra consulta principal**. Se usan mucho para filtrar datos usando un valor desconocido que primero debes calcular.

**Ejemplo 1: Subconsulta básica en el WHERE (Devuelve un solo valor)***Problema:* ¿Quiénes ganan más que el promedio de la empresa?
*Lógica:* No sabemos el promedio. Primero debemos calcularlo (Subconsulta) y luego comparar el salario de cada empleado contra ese cálculo.

```sql
SELECT nombre, salario
FROM EMPLEADOS
WHERE salario > (
    -- Esta es la subconsulta. Se ejecuta primero.
    SELECT AVG(salario) FROM EMPLEADOS
);
```

**Ejemplo 2: Subconsulta con IN (Devuelve varios valores)***Problema:* Mostrar los empleados que trabajan en departamentos ubicados en 'Madrid'.

```sql
SELECT nombre
FROM EMPLEADOS
WHERE id_dept IN (
    -- La subconsulta busca los IDs de los departamentos en Madrid
    SELECT id_dept FROM DEPARTAMENTOS WHERE ubicacion = 'Madrid'
);
```

*(Nota: Esto mismo se podría resolver con un `INNER JOIN`, pero las subconsultas a veces son más fáciles de leer lógicamente).*

---

## 🚀 LA CONSULTA FINAL MAESTRA (Combinando Secciones)

*Escenario complejo: "Necesitamos un reporte que muestre **todos los departamentos de la empresa** (incluso los que no tienen empleados), la **cantidad de empleados** que tienen, y queremos que **solo aparezcan** aquellos departamentos donde el salario promedio de sus trabajadores sea mayor al salario promedio de toda la empresa junta."*

¿Qué usaremos?

1. Un `LEFT JOIN` (para asegurar que salen todos los departamentos).
2. Un `GROUP BY` y `COUNT` (para agrupar por departamento y contar).
3. Un `HAVING` (para filtrar los grupos).
4. Una `Subconsulta` dentro del `HAVING` (para calcular el promedio total).

```sql
SELECT
    d.nombre_dept AS Departamento,
    COUNT(e.id_empleado) AS Numero_Empleados
FROM
    DEPARTAMENTOS d
-- 1. LEFT JOIN: Aseguramos que se listen todos los departamentos
LEFT JOIN
    EMPLEADOS e ON d.id_dept = e.id_dept
-- 2. Agrupamos por el nombre del departamento
GROUP BY
    d.nombre_dept
-- 3. Filtramos los grupos comparando promedios
HAVING
    -- 4. Promedio del departamento > Promedio total de la empresa (Subconsulta)
    AVG(e.salario) > (SELECT AVG(salario) FROM EMPLEADOS);
```

---

# 📘 Guía de Apuntes: Operadores EXISTS, NOT EXISTS y ROWNUM

## 1. Operadores EXISTS y NOT EXISTS

A diferencia de operadores como `>`, `<`, o `=`, que comparan valores específicos (ej: `salario > 1000`), el operador `EXISTS` hace una pregunta muy simple a la base de datos: **"¿Hay algo aquí?"**.

- Solo se usa junto con subconsultas.
- Devuelve **VERDADERO (True)** si la subconsulta arroja al menos 1 fila.
- Devuelve **FALSO (False)** si la subconsulta arroja 0 filas (está vacía).
- No importa qué columnas pongas en el `SELECT` de la subconsulta (por convención se usa `SELECT *` o `SELECT 1`), porque la base de datos no evalúa el dato, solo evalúa la **existencia** de la fila.

### ⚠️ Concepto Clave: La Subconsulta Correlacionada

Para que `EXISTS` sea realmente útil, la subconsulta interna debe estar "atada" a la consulta externa. A esto se le llama subconsulta correlacionada.
Funciona como un bucle: El motor SQL toma la primera fila de la consulta principal, ejecuta la subconsulta para ver si existe coincidencia, luego toma la segunda fila, y así sucesivamente.

### Ejemplo de EXISTS (Subconsulta Correlacionada)

*Objetivo: Obtener los datos de los empleados que trabajan en el departamento de 'Ventas'.*

```sql
SELECT e.nombre, e.puesto
FROM EMPLEADOS e
WHERE EXISTS (
    -- La subconsulta se conecta a la consulta principal usando "e.id_dept"
    SELECT 1
    FROM DEPARTAMENTOS d
    WHERE d.nombre_dept = 'Ventas'
    AND e.id_dept = d.id_dept -- ¡Este es el enlace correlacionado!
);
```

### Ejemplo de NOT EXISTS

Hace exactamente lo contrario: retiene la fila principal solo si la subconsulta interna **no devuelve nada** (está vacía).

*Objetivo: Obtener los empleados que NO pertenecen al departamento de 'Marketing'.*

```sql
SELECT e.nombre, e.puesto
FROM EMPLEADOS e
WHERE NOT EXISTS (
    SELECT 1
    FROM DEPARTAMENTOS d
    WHERE d.nombre_dept = 'Marketing'
    AND e.id_dept = d.id_dept
);
```

---

## 2. Análisis Práctico: IN vs EXISTS (El caso de las imágenes)

Tus capturas muestran un error muy común al aprender `EXISTS`. Vamos a desglosarlo para que entiendas perfectamente por qué ocurre.

**El Problema:** Queremos saber qué empleados (sin importar su puesto) ganan el mismo salario que cobra algún 'Administrativo' (CLERK).

**Solución 1: Usando IN (Fácil y directa)**

```sql
SELECT nombre, salario
FROM EMPLEADOS e1
WHERE salario IN (
    SELECT salario FROM EMPLEADOS e2 WHERE puesto = 'Administrativo'
);
```

*(Funciona bien: La subconsulta genera una lista de salarios [ej: 1000, 1200] y el IN busca quién coincide).*

**Solución 2: Usando EXISTS - "Intento 1" (INCORRECTO ❌)**

```sql
SELECT nombre, salario
FROM EMPLEADOS e1
WHERE EXISTS (
    -- Subconsulta NO correlacionada
    SELECT salario FROM EMPLEADOS e2 WHERE puesto = 'Administrativo'
);
```

*¿Por qué falla y muestra a todos los empleados?*
Porque la subconsulta dice: *"¿Existe algún administrativo en toda la empresa?"*. Como la respuesta es "Sí", el `EXISTS` devuelve VERDADERO como si fuera un interruptor general encendido. Como es verdadero, la consulta principal imprime a TODOS los empleados de la tabla. No está comparando salarios.

**Solución 3: Usando EXISTS - "Intento 2" (CORRECTO ✅)**

```sql
SELECT nombre, salario
FROM EMPLEADOS e1
WHERE EXISTS (
    SELECT salario
    FROM EMPLEADOS e2
    WHERE puesto = 'Administrativo'
    AND e1.salario = e2.salario -- 🔑 ¡Aquí está la magia!
);
```

*¿Por qué esta sí funciona?*
Porque ahora le decimos: *"Para el empleado e1 que estoy revisando ahora mismo, ve y busca si existe algún administrativo (e2) que tenga EXACTAMENTE el mismo salario que e1"*. Si lo encuentra, imprime a e1. Funciona igual que el operador `IN`.

---

## 3. Comando ROWNUM (Específico de Oracle)

`ROWNUM` es una pseudo-columna en Oracle. A medida que la base de datos va encontrando filas que cumplen las condiciones del `WHERE`, les va pegando una etiqueta con un número de orden (1, 2, 3...).

Sirve para **limitar la cantidad de resultados** que se muestran en pantalla. (En otros motores SQL esto se hace con `LIMIT` o `TOP`).

### Ejemplo básico

*Objetivo: Mostrar solo los primeros 3 departamentos de la tabla.*

```sql
SELECT *
FROM DEPARTAMENTOS
WHERE ROWNUM < 4; -- Menor que 4 significa que mostrará la fila 1, 2 y 3.
```

> 💡 **Nota Avanzada (Pro-Tip):** `ROWNUM` se asigna *antes* de que actúe el `ORDER BY`. Por lo tanto, si intentas hacer `WHERE ROWNUM < 4 ORDER BY salario DESC` (esperando ver a los 3 que más ganan), te dará un resultado erróneo (tomará 3 aleatorios y luego los ordenará). Para hacer "Top N" correctamente en Oracle antiguo, se deben usar subconsultas en el FROM.
> 

---

## 🚀 LA CONSULTA FINAL MAESTRA (Combinando todo)

*Escenario:*
"Necesitamos sacar una lista rápida (limitada a **solo los 5 primeros** resultados) de empleados que cumplan estas dos condiciones:

1. Su departamento **SÍ EXISTE** físicamente en la sede de 'Madrid' (usaremos `EXISTS`).
2. Tienen un salario que **NO EXISTE** (no coincide) con el salario de ningún 'Gerente' (usaremos `NOT EXISTS`)."

```sql
SELECT
    e.nombre,
    e.salario
FROM
    EMPLEADOS e
WHERE
    -- Condición 1: El departamento del empleado existe y está en Madrid
    EXISTS (
        SELECT 1
        FROM DEPARTAMENTOS d
        WHERE d.ubicacion = 'Madrid'
        AND e.id_dept = d.id_dept -- Correlación 1
    )
    -- Condición 2: Ningún Gerente cobra exactamente este mismo salario
    AND NOT EXISTS (
        SELECT 1
        FROM EMPLEADOS gerentes
        WHERE gerentes.puesto = 'Gerente'
        AND e.salario = gerentes.salario -- Correlación 2
    )
    -- Límite final: Mostrar solo las 5 primeras filas que pasen todos estos filtros
    AND ROWNUM <= 5;
```