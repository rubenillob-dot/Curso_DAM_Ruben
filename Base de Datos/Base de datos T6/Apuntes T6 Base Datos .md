# Apuntes Base Datos

---

### 1. Variables y Estructura de Bloque

*Objetivo: Declarar variables y constantes, y usarlas en un bloque PL/SQL.*

```sql
DECLARE
    -- Constante de bonificación (no cambia)
    bono_extra CONSTANT NUMBER := 500;
    -- Variable para guardar el salario modificado
    salario_total NUMBER;
    -- Variable de texto
    nombre_emp VARCHAR2(20) := 'REY';
BEGIN
    -- Obtenemos el salario del presidente y le sumamos el bono
    SELECT SALARIO INTO salario_total
    FROM EMPLEADOSE WHERE APELLIDO = nombre_emp;

    salario_total := salario_total + bono_extra;

    DBMS_OUTPUT.PUT_LINE('El salario total de ' || nombre_emp || ' es: ' || salario_total);
END;
/
```

**¿Por qué este ejemplo?** Muestra cómo definir bloques (`DECLARE-BEGIN-END`), el uso de constantes para valores fijos (`bono_extra`) y cómo realizar operaciones aritméticas básicas usando operadores de PL/SQL.

---

### 2. Estructuras de control (IF-THEN-ELSIF)

*Objetivo: Clasificar a un empleado según su salario.*

```sql
DECLARE
    salario_actual NUMBER;
BEGIN
    SELECT SALARIO INTO salario_actual FROM EMPLEADOSE WHERE APELLIDO = 'GARRIDO';

    IF salario_actual > 3000 THEN
        DBMS_OUTPUT.PUT_LINE('Salario alto');
    ELSIF salario_actual BETWEEN 2000 AND 3000 THEN
        DBMS_OUTPUT.PUT_LINE('Salario medio');
    ELSE
        DBMS_OUTPUT.PUT_LINE('Salario bajo');
    END IF;
END;
/
```

**¿Por qué este ejemplo?** Demuestra el uso de la lógica condicional para tomar decisiones basadas en datos reales de la base de datos, usando `BETWEEN` que es un operador de comparación eficiente.

---

### 3. Estructuras Iterativas (FOR LOOP)

*Objetivo: Recorrer una serie de números o registros de forma controlada.*

```sql
BEGIN
    -- Bucle simple del 1 al 3
    FOR numero IN 1..3 LOOP
        DBMS_OUTPUT.PUT_LINE('Iteracion numero: ' || numero);
    END LOOP;
END;
/
```

**¿Por qué este ejemplo?** El `FOR LOOP` es la estructura más segura para iteraciones donde sabemos cuántas veces debemos repetir un proceso, ya que gestiona automáticamente el contador.

---

### 4. Manejo de excepciones

*Objetivo: Capturar un error cuando un empleado no existe.*

```sql
DECLARE
    salario_emp NUMBER;
BEGIN
    -- Intentamos buscar un empleado que no existe
    SELECT SALARIO INTO salario_emp FROM EMPLEADOSE WHERE APELLIDO = 'INVENTADO';

    DBMS_OUTPUT.PUT_LINE('Salario: ' || salario_emp);
EXCEPTION
    -- Capturamos el error específico de Oracle cuando no hay datos
    WHEN NO_DATA_FOUND THEN
        DBMS_OUTPUT.PUT_LINE('Error: El empleado no ha sido encontrado en la base de datos.');
END;
/
```

**¿Por qué este ejemplo?** Es vital controlar el flujo cuando una consulta falla. Sin el bloque `EXCEPTION`, el programa terminaría bruscamente con un error del sistema; con este bloque, el programa se cierra de forma elegante informando al usuario.

---

### 5. Ejemplo Global: Lógica con Subtipos y Gestión de Errores

*Objetivo: Usar subtipos para definir variables personalizadas y manejar un posible error al insertar un empleado duplicado.*

```sql
DECLARE
    -- Definimos un subtipo para mayor legibilidad
    SUBTYPE salario_empleado IS NUMBER;
    mi_sueldo salario_empleado := 2500;
BEGIN
    -- Intentamos insertar un empleado con una PK que ya existe (7839 es REY)
    INSERT INTO EMPLEADOSE (EMPNU, APELLIDO) VALUES (7839, 'DUPLICADO');

    COMMIT;
EXCEPTION
    -- Capturamos error de clave primaria duplicada
    WHEN DUP_VAL_ON_INDEX THEN
        DBMS_OUTPUT.PUT_LINE('Aviso: El numero de empleado ya existe, no se pudo insertar.');
        ROLLBACK; -- Deshacemos la inserción fallida
    WHEN OTHERS THEN
        DBMS_OUTPUT.PUT_LINE('Error desconocido: ' || SQLERRM);
END;
/
```

**¿Por qué este ejemplo global?**

1. **Subtipos**: Usamos `SUBTYPE` para que nuestro código sea semánticamente más claro.
2. **Transacciones**: Usamos `COMMIT` y `ROLLBACK` para asegurar la integridad de los datos.
3. **Manejo de Errores**: Usamos `DUP_VAL_ON_INDEX` (excepción predefinida) y `SQLERRM` (para mostrar el mensaje de error del sistema), cubriendo todos los conceptos básicos del tema de forma profesional.

---

### 1. Registros (Records)

```sql
DECLARE
    -- Definimos la estructura del registro basándonos en la tabla
    TYPE ficha_cliente IS RECORD (
        nombre_cliente CLIENTESE.NOMBRE%TYPE,
        deuda_cliente  CLIENTESE.DEBE%TYPE
    );

    -- Declaramos la variable que usará esa estructura
    datos_cliente ficha_cliente;
BEGIN
    -- Obtenemos los datos de la fila 101 y los guardamos en el registro
    SELECT NOMBRE, DEBE INTO datos_cliente
    FROM CLIENTESE WHERE CLIENTENU = 101;

    -- Imprimimos los campos usando la notación de punto
    DBMS_OUTPUT.PUT_LINE('--- Datos del Cliente ---');
    DBMS_OUTPUT.PUT_LINE('Cliente: ' || datos_cliente.nombre_cliente);
    DBMS_OUTPUT.PUT_LINE('Deuda actual: ' || datos_cliente.deuda_cliente);
END;
/
```

**¿Por qué este ejemplo?** El uso de `%TYPE` garantiza que el tipo de dato siempre coincida con la columna de la tabla. El registro permite mover "paquetes" de datos en una sola variable en lugar de tener muchas variables sueltas.

---

### 2. Colecciones: VARRAY

```sql
DECLARE
    -- Definimos un array de tamaño máximo 5
    TYPE lista_ids IS VARRAY(5) OF NUMBER;
    -- Inicializamos el array con datos iniciales (constructor)
    mis_productos lista_ids := lista_ids(10, 20, 30, 40, 50);
BEGIN
    -- Accedemos al primer elemento por su índice (comienza en 1)
    DBMS_OUTPUT.PUT_LINE('Primer producto: ' || mis_productos(1));
    -- Usamos la propiedad .COUNT para saber cuántos elementos tiene
    DBMS_OUTPUT.PUT_LINE('Total productos en lista: ' || mis_productos.COUNT);
END;
/
```

**¿Por qué este ejemplo?** El `VARRAY` es una estructura de "tamaño acotado". Es muy útil cuando sabes de antemano el límite máximo de elementos, evitando que la memoria crezca de forma descontrolada.

---

### 3. Colecciones: Tablas Anidadas

```sql
DECLARE
    -- Definimos una tabla sin límite superior
    TYPE tabla_productos IS TABLE OF VARCHAR2(30);
    nombres_prods tabla_productos := tabla_productos('Mesa', 'Silla');
BEGIN
    -- Aumentamos el tamaño de la tabla dinámicamente
    nombres_prods.EXTEND;
    -- Asignamos un nuevo valor en la posición recién creada
    nombres_prods(3) := 'Armario';

    DBMS_OUTPUT.PUT_LINE('Producto añadido: ' || nombres_prods(3));
END;
/
```

**¿Por qué este ejemplo?** La tabla anidada es flexible. A diferencia del `VARRAY`, la capacidad de usar `.EXTEND` permite que el programa se adapte a volúmenes de datos que cambian constantemente durante la ejecución.

---

### 4. Cursores

```sql
DECLARE
    -- Definimos el cursor con la consulta que queremos procesar
    CURSOR cursor_ventas IS
        SELECT APELLIDO, COMISION FROM EMPLEADOSE WHERE COMISION IS NOT NULL;
BEGIN
    -- El bucle FOR se encarga de abrir, leer y cerrar el cursor automáticamente
    FOR empleado IN cursor_ventas LOOP
        -- 'empleado' actúa como un registro temporal de cada fila
        DBMS_OUTPUT.PUT_LINE('Vendedor: ' || empleado.APELLIDO || ' | Comisión: ' || empleado.COMISION);
    END LOOP;
END;
/
```

**¿Por qué este ejemplo?** El bucle `FOR` es la forma más "limpia" de recorrer cursores. Es menos propensa a errores (como olvidar cerrar el cursor) y hace que el código sea mucho más legible.

---

### 5. Ejemplo Global: Procedimiento

```sql
CREATE OR REPLACE PROCEDURE verificar_salario(id_empleado NUMBER) IS
    -- Declaramos un cursor para buscar el empleado
    CURSOR c_emp IS SELECT APELLIDO, SALARIO FROM EMPLEADOSE WHERE EMPNU = id_empleado;
    -- Usamos %ROWTYPE para obtener una estructura idéntica a la fila
    datos_emp c_emp%ROWTYPE;
BEGIN
    -- Abrimos el cursor manualmente
    OPEN c_emp;
    -- Leemos la fila encontrada
    FETCH c_emp INTO datos_emp;

    -- Verificamos si realmente encontramos algo (atributo %FOUND)
    IF c_emp%FOUND THEN
        IF datos_emp.SALARIO > 2000 THEN
DBMS_OUTPUT.PUT_LINE('Resultado:' ||datos_emp.APELLIDO || 'tiene un sueldo ALTO.');
        ELSE
DBMS_OUTPUT.PUT_LINE('Resultado:' || datos_emp.APELLIDO || ' tiene un sueldo BASE.');
        END IF;
    END IF;

    -- Cerramos el cursor para liberar recursos
    CLOSE c_emp;
END;
/

-- Invocación del procedimiento
BEGIN
    verificar_salario(7839); -- Probamos con el presidente
END;
/
```

**¿Por qué este ejemplo global?** Combina la **declaración de estructuras** (`%ROWTYPE`) con la **gestión manual de recursos** (`OPEN/FETCH/CLOSE`). Esto es fundamental para cuando necesitas lógica compleja donde no puedes dejar que el bucle automático haga todo el trabajo, permitiéndote tomar decisiones antes de cerrar el cursor.

Aquí tienes los ejemplos sobre **Paquetes, Objetos y Disparadores** aplicados a tu base de datos `EMPLEADOSE`.

---

### 1. Paquetes (Agrupación de lógica)

*Objetivo: Crear un paquete que gestione funciones relacionadas con los empleados.*

```sql
-- Especificación (interfaz)
CREATE OR REPLACE PACKAGE gestor_empleados AS
    FUNCTION obtener_salario(id NUMBER) RETURN NUMBER;
END gestor_empleados;
/

-- Cuerpo (implementación)
CREATE OR REPLACE PACKAGE BODY gestor_empleados AS
    FUNCTION obtener_salario(id NUMBER) RETURN NUMBER IS
        sal NUMBER;
    BEGIN
        SELECT SALARIO INTO sal FROM EMPLEADOSE WHERE EMPNU = id;
        RETURN sal;
    END obtener_salario;
END gestor_empleados;
/
```

**¿Por qué este ejemplo?** Los paquetes permiten organizar el código. En lugar de tener funciones dispersas, agrupamos todas las operaciones de "empleados" en un solo objeto lógico, lo cual facilita el mantenimiento y la seguridad.

---

### 2. Objetos (Programación Orientada a Objetos)

*Objetivo: Definir un objeto tipo "Producto" con un método propio.*

```sql
-- 1. Definición del objeto
CREATE OR REPLACE TYPE objeto_producto AS OBJECT (
    id_prod NUMBER,
    precio  NUMBER,
    -- Método para calcular impuestos
    MEMBER FUNCTION aplicar_iva RETURN NUMBER
);
/

-- 2. Cuerpo del objeto
CREATE OR REPLACE TYPE BODY objeto_producto AS
    MEMBER FUNCTION aplicar_iva RETURN NUMBER IS
    BEGIN
        RETURN self.precio * 1.21; -- Aplicamos 21% de IVA
    END;
END;
/
```

**¿Por qué este ejemplo?** El paradigma de objetos permite encapsular datos y comportamiento. Al incluir el método `aplicar_iva` dentro del objeto, aseguramos que cualquier cálculo de impuesto sea consistente en toda la aplicación.

---

### 3. Disparadores (Triggers)

*Objetivo: Evitar que un empleado cobre un salario inferior a 500 al insertar o actualizar.*

```sql
CREATE OR REPLACE TRIGGER control_salario
BEFORE INSERT OR UPDATE ON EMPLEADOSE
FOR EACH ROW
BEGIN
    -- Comprobamos si el nuevo salario es menor al mínimo permitido
    IF :NEW.SALARIO < 500 THEN
        -- Lanzamos un error personalizado
        RAISE_APPLICATION_ERROR(-20001, 'El salario no puede ser inferior a 500');
    END IF;
END;
/
```

**¿Por qué este ejemplo?** Este disparador actúa como un **guardián de integridad**. No importa desde qué parte del sistema se intente cambiar un salario, el disparador siempre saltará antes de que los datos se guarden en la tabla, garantizando la calidad de los mismos.

---

### 4. Ejemplo Global: Disparador de Auditoría

*Objetivo: Registrar automáticamente en una tabla de auditoría quién borra un empleado.*

```sql
-- Creamos tabla de auditoría (para el ejemplo)
CREATE TABLE auditoria_empleados (usuario VARCHAR2(50), fecha DATE);

-- Creamos el disparador
CREATE OR REPLACE TRIGGER log_borrado_emp
AFTER DELETE ON EMPLEADOSE
BEGIN
    -- Insertamos el usuario que ejecuta el borrado
    INSERT INTO auditoria_empleados VALUES (USER, SYSDATE);

    -- Usamos el paquete predefinido para informar del proceso
    DBMS_OUTPUT.PUT_LINE('Se ha detectado un borrado y registrado en auditoria.');
END;
/
```

**¿Por qué este ejemplo global?**

1. **Automatización**: El disparador (`AFTER DELETE`) detecta automáticamente la acción sin que el usuario tenga que recordar llamar a otra función.
2. **Seguridad**: La tabla `auditoria_empleados` nos da un histórico inalterable de qué ha ocurrido en la base de datos.
3. **Comunicación**: Utilizamos `DBMS_OUTPUT` (del paquete que vimos en la teoría) para confirmar visualmente al programador que el disparador se ha ejecutado correctamente.
