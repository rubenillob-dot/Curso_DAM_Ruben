# Ejericios Base Datos T6 Relacionados


### PDF 1: Variables y Estructuras de Control (IF/LOOP)

*Ejercicio: Pedir el número de un departamento y calcular si tiene empleados.*

```sql
DECLARE
    -- Usamos %TYPE para asegurar compatibilidad
    dept_a_buscar NUMBER := 10;
    contar_emps NUMBER;
BEGIN
    SELECT COUNT(*) INTO contar_emps FROM EMPLEADOSE WHERE DEPNU = dept_a_buscar;

    -- Estructura IF de tus apuntes
    IF contar_emps > 0 THEN
        DBMS_OUTPUT.PUT_LINE('El departamento tiene ' || contar_emps || ' empleados.');
    ELSE
        DBMS_OUTPUT.PUT_LINE('No hay empleados en este departamento.');
    END IF;
END;
/
```

**¿Por qué?** Combina la entrada de datos (variable) con la lógica condicional que aparecía en tu PDF de `SOLUCIONES EJ3`.

---

### PDF 2: Bucles y Funciones Matemáticas

*Ejercicio: Calcular la raíz cuadrada de la diferencia de salarios entre dos empleados.*

```sql
DECLARE
    sal1 NUMBER;
    sal2 NUMBER;
BEGIN
    SELECT SALARIO INTO sal1 FROM EMPLEADOSE WHERE EMPNU = 7839;
    SELECT SALARIO INTO sal2 FROM EMPLEADOSE WHERE EMPNU = 7698;

    -- Uso de funciones matemáticas SQRT y POWER como en tu ejercicio 4
    DBMS_OUTPUT.PUT_LINE('Distancia salarial: ' || SQRT(POWER(sal1 - sal2, 2)));
END;
/
```

**¿Por qué?** Es una adaptación directa del ejercicio 4 de tu segundo PDF, aplicado a los salarios de tu base de datos en lugar de puntos (x,y).

---

### PDF 3: Consultas avanzadas y funciones de texto

*Ejercicio: Contar empleados y mostrar el día de la semana actual.*

```sql
DECLARE
    total_emps NUMBER;
    dia_actual VARCHAR2(20);
BEGIN
    -- Contador como en el ejercicio 4
    SELECT COUNT(*) INTO total_emps FROM EMPLEADOSE;
    -- Formato de fecha como en el ejercicio 3
    dia_actual := TO_CHAR(SYSDATE, 'DAY');

    DBMS_OUTPUT.PUT_LINE('Hoy es ' || dia_actual || ' y hay ' || total_emps || ' empleados.');
END;
/
```

**¿Por qué?** Une el uso de funciones de fecha y contadores, siguiendo la estructura del ejercicio 3 y 4 de tu PDF sobre funciones básicas.

---

### PDF 4: Manejo de Excepciones

*Ejercicio: Capturar errores al buscar un pedido inexistente.*

```sql
DECLARE
    unidad_ped NUMBER;
BEGIN
    -- Buscamos un pedido que no existe
    SELECT UNIDADES INTO unidad_ped FROM PEDIDOSE WHERE PEDIDONU = 9999;
EXCEPTION
    -- Capturamos el error específico como en tu ejercicio 2
    WHEN NO_DATA_FOUND THEN
        DBMS_OUTPUT.PUT_LINE('Error: El pedido no existe en la base de datos.');
END;
/
```

**¿Por qué?** Es la esencia de los ejercicios de excepciones: evitar que el programa "explote" cuando una consulta `SELECT` falla.

---

### PDF 5: Registros (Records)

*Ejercicio: Usar un Record para procesar un producto.*

```sql
DECLARE
    -- Definimos el tipo registro como en tu EJERCICIO 1
    TYPE reg_prod IS RECORD (
        descrip PRODUCTOSE.DESCRIPCION%TYPE,
        stock   PRODUCTOSE.STOCKDISPONIBLE%TYPE
    );
    mi_prod reg_prod;
BEGIN
    SELECT DESCRIPCION, STOCKDISPONIBLE INTO mi_prod FROM PRODUCTOSE WHERE PRODUCTONU = 10;
    DBMS_OUTPUT.PUT_LINE('Producto: ' || mi_prod.descrip || ' | Stock: ' || mi_prod.stock);
END;
/
```

**¿Por qué?** Replica exactamente la estructura de crear un `TYPE IS RECORD` y luego volcar datos en él, tal como en tus ejercicios de clase.

---

### PDF 6: Cursores

*Ejercicio: Recorrer todos los departamentos con un bucle.*

```sql
DECLARE
    CURSOR cur_dept IS SELECT DNOMBRE FROM DEPARTAMENTOSE;
    nombre_dpto DEPARTAMENTOSE.DNOMBRE%TYPE;
BEGIN
    OPEN cur_dept;
    LOOP
        FETCH cur_dept INTO nombre_dpto;
        EXIT WHEN cur_dept%NOTFOUND;
        DBMS_OUTPUT.PUT_LINE('Departamento: ' || nombre_dpto);
    END LOOP;
    CLOSE cur_dept;
END;
/
```

**¿Por qué?** Es la forma clásica de procesar cursores explicada en el PDF de cursores, usando el bucle `LOOP` y `EXIT WHEN`.

---

### PDF 7: Paquetes y Procedimientos

*Ejercicio: Llamar a un procedimiento almacenado.*

```sql
-- Creación del procedimiento (ejercicio 3 del PDF)
CREATE OR REPLACE PROCEDURE ver_salario(id_emp NUMBER) IS
    sal NUMBER;
BEGIN
    SELECT SALARIO INTO sal FROM EMPLEADOSE WHERE EMPNU = id_emp;
    DBMS_OUTPUT.PUT_LINE('Salario: ' || sal);
END;
/

-- Bloque de ejecución
BEGIN
    ver_salario(7839);
END;
/
```

**¿Por qué?** Implementa la creación y llamada a procedimientos, igual que en los ejemplos de tus apuntes finales.

---

### PDF 8: Disparadores (Triggers)

*Ejercicio: Trigger para auditar una tabla.*

```sql
-- Trigger que avisa al borrar un cliente
CREATE OR REPLACE TRIGGER aviso_borrado
BEFORE DELETE ON CLIENTESE
BEGIN
    DBMS_OUTPUT.PUT_LINE('Advertencia: Se va a borrar un cliente.');
END;
/
```

**¿Por qué?** Refleja la parte de triggers de tu PDF final, donde se ejecutan disparadores antes de realizar una operación de manipulación de datos (`DELETE`).
