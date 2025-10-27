
***

## **Parte 1: Operaciones en el Entorno Gráfico**

Aunque los "filtros" como comandos individuales son una característica de la terminal, sus funciones equivalentes en el entorno gráfico se encuentran integradas dentro de las aplicaciones que usamos a diario.

### **1. Filtrar, Buscar y Manipular Texto en Aplicaciones Gráficas**

En un entorno gráfico, no se "filtra" la salida de un programa a otro de la misma manera que en la terminal. En su lugar, estas tareas se realizan con las herramientas que ofrecen los programas específicos:

*   **Búsqueda de texto (Equivalente a `grep`)**:
    *   Casi todos los editores de texto (como Gedit), procesadores de texto (LibreOffice Writer) y navegadores web tienen una función de "Buscar" (normalmente con el atajo `Ctrl+F`). Esta te permite encontrar rápidamente cadenas de texto dentro de un documento.

*   **Reemplazar texto (Equivalente a `sed`)**:
    *   Las herramientas de "Buscar y Reemplazar" (`Ctrl+H` en muchas aplicaciones) te permiten sustituir todas las apariciones de una palabra o frase por otra, que es la función principal de `sed`.

*   **Ordenar datos (Equivalente a `sort`)**:
    *   Esta función es una característica clave de las hojas de cálculo como LibreOffice Calc. Puedes seleccionar una o varias columnas y ordenarlas alfabética o numéricamente con solo unos clics.

*   **Contar palabras y caracteres (Equivalente a `wc`)**:
    *   Los procesadores de texto suelen incluir una herramienta de "Contar palabras" en el menú "Herramientas" o en la barra de estado, que te da estadísticas del documento.

*   **Visualizar archivos grandes (Equivalente a `more`/`less`)**:
    *   Cualquier visor de texto o editor gráfico maneja esto de forma natural mediante la **barra de desplazamiento**, que te permite navegar por el contenido del archivo sin necesidad de comandos.

### **2. Variables de Entorno en el Entorno Gráfico**

Generalmente, las variables de entorno no se gestionan directamente a través de la interfaz gráfica estándar, ya que son parte de la configuración del sistema y del shell. Sin embargo, algunas utilidades avanzadas de configuración del sistema pueden ofrecer una interfaz para verlas o modificarlas, aunque no es una tarea común para el usuario promedio.

***

## **Parte 2: Filtros y Variables en la Línea de Comandos (Terminal)**

La terminal es donde los filtros demuestran todo su potencial, permitiendo encadenar comandos para procesar datos de manera eficiente.

### **1. Filtros: Procesamiento de Flujos de Datos**

Los filtros son programas que toman una entrada de datos (generalmente texto), la procesan y generan una salida modificada. Son la base de la filosofía de Unix: "Hacer una cosa y hacerla bien".

#### **Visualización de Contenido**

*   **`more`**: Visualiza el contenido de un archivo paginando la salida. Es útil para leer archivos largos que no caben en una pantalla.
    *   `ls -l /etc | more`

*   **`head`**: Muestra las primeras 10 líneas (por defecto) de un fichero.
    *   `head /etc/passwd` (muestra las primeras 10 líneas)
    *   `head -n 5 /etc/passwd` (muestra las primeras 5 líneas)

*   **`tail`**: Muestra las últimas 10 líneas (por defecto) de un fichero. Es muy útil para ver los registros (logs) más recientes.
    *   `tail /var/log/syslog` (muestra las últimas 10 líneas del log del sistema)
    *   `tail -n 3 /etc/passwd` (muestra las últimas 3 líneas)

#### **Análisis y Conteo**

*   **`wc` (Word Count)**: Cuenta líneas, palabras y caracteres.
    *   `wc fichero.txt`
    *   **Opciones:**
        *   `-l`: Cuenta solo las líneas.
        *   `-w`: Cuenta solo las palabras.
        *   `-c`: Cuenta solo los caracteres.
    *   `who | wc -l` (cuenta cuántos usuarios están conectados).

#### **Búsqueda y Patrones**

*   **`grep`**: Busca líneas que contengan un patrón de texto en uno o más archivos.
    *   `grep "error" /var/log/syslog`
    *   **Opciones:**
        *   `-i`: Ignora mayúsculas y minúsculas.
        *   `-v`: Muestra las líneas que **no** coinciden con el patrón.
        *   `-c`: Imprime solo la cantidad de líneas que coinciden.
        *   `-n`: Muestra el número de línea de la coincidencia.

#### **Manipulación y Transformación de Texto**

*   **`sort`**: Ordena las líneas de un archivo.
    *   `sort fichero.txt`
    *   **Opciones:**
        *   `-r`: Invierte el orden (descendente).
        *   `-n`: Ordena numéricamente.
        *   `-f`: Ignora mayúsculas y minúsculas.

*   **`tr` (Translate)**: Sustituye o elimina caracteres.
    *   `who | tr -s " "` (comprime los espacios repetidos en uno solo).
    *   `cat fichero.txt | tr 'a-z' 'A-Z'` (convierte el texto a mayúsculas).

*   **`cut`**: Extrae secciones (columnas) de cada línea de un archivo.
    *   `cut -d: -f1 /etc/passwd` (usa `:` como delimitador y extrae el primer campo).
    *   **Opciones:**
        *   `-d`: Especifica el delimitador.
        *   `-f`: Especifica el campo (columna) a extraer.
        *   `-c`: Especifica las posiciones de los caracteres a extraer.

*   **`sed` (Stream Editor)**: Permite realizar transformaciones complejas de texto, como buscar y reemplazar.
    *   **Reemplazar:** `sed 's/viejo/nuevo/g' archivo.txt` (reemplaza todas las apariciones de "viejo" por "nuevo").
    *   **Eliminar líneas:** `sed '/eliminar/d' archivo.txt` (elimina todas las líneas que contienen la palabra "eliminar").

*   **`awk`**: Es un potente lenguaje de programación para procesar texto, especialmente útil para archivos estructurados en columnas.
    *   `ls -l | awk '{print $9}'` (imprime la novena columna de la salida de `ls -l`, que es el nombre del archivo).
    *   `awk -F ',' '{print $2}' datos.csv` (imprime la segunda columna de un archivo CSV).

#### **Utilidades Adicionales**

*   **`echo`**: Muestra un texto en la pantalla.
    *   `echo "Hola mundo"`

*   **`tee`**: Lee de la entrada estándar y escribe tanto en la salida estándar como en un archivo. Es como una "T" en una tubería.
    *   `ls -l | tee lista_archivos.txt | wc -l` (guarda la lista de archivos en `lista_archivos.txt` y al mismo tiempo la pasa a `wc -l` para contarla).

### **2. Variables de Entorno**

Son variables que contienen información sobre el entorno del shell y están disponibles para todos los comandos.

*   **Formato:** `NOMBRE=valor` (por convención, en mayúsculas).
*   **Visualizar una variable:** `echo $NOMBRE`
    *   `echo $HOME` (muestra tu directorio de inicio).
    *   `echo $PATH` (muestra los directorios donde el sistema busca comandos).

*   **Ver todas las variables:**
    *   `env` o `printenv`

*   **Asignar la salida de un comando a una variable:** Se utiliza el acento grave (` `) o la sintaxis `$()`.
    *   `LINEAS=$(cat f* | wc -l)`
    *   `echo $LINEAS` (mostrará el número de líneas calculado).
