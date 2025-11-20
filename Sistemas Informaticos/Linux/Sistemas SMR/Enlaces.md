
***

## **Parte 1: Gestión de Enlaces en el Entorno Gráfico**

En el entorno gráfico, el concepto más parecido a un enlace que los usuarios suelen manejar es el de un **"acceso directo"**, que es la representación visual de un **enlace simbólico**.

### **1. Crear un Enlace (Acceso Directo)**

1.  **Haz clic derecho** sobre el archivo o directorio del que quieres crear un acceso directo.
2.  En el menú contextual, busca la opción **"Crear un enlace"** o "Make Link".
3.  Aparecerá un nuevo icono en la misma carpeta, normalmente con un nombre como "Enlace a [nombre original]" y una flecha superpuesta para indicar que es un enlace.
4.  Puedes **mover o renombrar** este enlace a cualquier otra ubicación, como tu escritorio, para acceder rápidamente al archivo original.

### **2. Comportamiento de los Enlaces Gráficos**

*   **Identificación:** Los enlaces simbólicos se distinguen visualmente por un pequeño **icono de flecha** en una esquina.
*   **Eliminación:** Si **eliminas el enlace** (el acceso directo), el archivo o directorio original **permanece intacto**. Simplemente borras el acceso directo.
*   **Enlaces rotos:** Si **mueves o eliminas el archivo original**, el enlace se "romperá". Al hacer doble clic en él, el sistema te mostrará un error indicando que el destino no se puede encontrar.
*   **Enlaces Duros:** Crear o gestionar enlaces duros **no es una función común** en los exploradores de archivos gráficos. Es una operación que se realiza casi exclusivamente a través de la terminal.

***

## **Parte 2: Enlaces en la Línea de Comandos (Terminal)**

En la terminal es donde se gestiona la diferencia fundamental entre enlaces duros y simbólicos. El concepto clave para entenderlos es el **inodo (inode)**: un número que identifica de forma única los datos de un archivo en el sistema de archivos.

### **1. Enlace Duro (Hard Link)**

Un enlace duro es como tener **dos nombres de archivo diferentes que apuntan exactamente a los mismos datos** en el disco.

*   **Características Principales:**
    *   Comparten el **mismo número de inodo** y el mismo espacio en disco que el archivo original.
    *   **No es una copia:** cualquier cambio realizado a través de un enlace duro modifica los datos originales, y viceversa.
    *   El contenido del archivo **solo se elimina del disco cuando se borra el último enlace duro** que apunta a él. Borrar el archivo "original" no elimina los datos si existe otro enlace duro.
    *   **Limitaciones:**
        *   No se pueden crear enlaces duros a directorios (para evitar bucles infinitos en el sistema de archivos).
        *   No pueden cruzar sistemas de archivos o particiones diferentes.

*   **Comando para crear:** `ln [archivo_original] [nombre_del_enlace_duro]`
    *   **Ejemplo:** `ln fi enlaceDurofi`

### **2. Enlace Simbólico (Symbolic Link o Symlink)**

Un enlace simbólico es un **archivo especial que contiene la ruta a otro archivo o directorio**. Es funcionalmente un "acceso directo".

*   **Características Principales:**
    *   Tiene su **propio número de inodo** y es un archivo independiente de tamaño muy pequeño.
    *   Apunta a una **ruta**, no directamente a los datos.
    *   Si **eliminas el enlace simbólico, el archivo original no se ve afectado**.
    *   Si **eliminas o mueves el archivo original, el enlace simbólico se "rompe"** y deja de funcionar.
    *   **Ventajas:**
        *   Sí se pueden crear enlaces simbólicos a directorios.
        *   Pueden apuntar a archivos en diferentes sistemas de archivos o particiones.

*   **Comando para crear:** `ln -s [archivo_o_directorio_original] [nombre_del_enlace_simbolico]`
    *   **Ejemplo:** `ln -s dir enlaceDir`
    *   **Ejemplo:** `ln -s fi enlacefi`

### **3. Ejemplos Prácticos y Verificación**

El comando `ls -li` es fundamental para ver las diferencias:

`ls -li`

*   La primera columna es el **número de inodo**.
*   El primer carácter indica el tipo de archivo (`l` para enlace simbólico, `-` para archivo regular, `d` para directorio).
*   La columna después de los permisos es el **contador de enlaces duros** (indica cuántos nombres apuntan a ese inodo).

**Observaciones de los ejemplos del PDF:**

*   Al crear `enlaceDurofi`, se puede ver con `ls -li` que comparte el **mismo inodo** que `fi` y el contador de enlaces de ese inodo sube a **2**.
*   Al crear `enlacefi` (simbólico), tiene un **inodo diferente** y el contador de enlaces de `fi` no cambia. Además, el tipo de archivo de `enlacefi` empieza por `l`.
*   Cuando se borra el archivo original `fi` (`rm fi`):
    *   Se puede seguir accediendo al contenido a través de `enlaceDurofi` (`cat enlaceDurofi` funciona).
    *   El enlace simbólico `enlacefi` se rompe y da un error de "No existe el archivo o el directorio".
*   **Rutas relativas vs. absolutas:** Un enlace simbólico creado con una ruta relativa puede romperse si se mueve a otro directorio, mientras que uno creado con una ruta absoluta (`/home/curso/...`) seguirá funcionando sin importar dónde se mueva el enlace.
