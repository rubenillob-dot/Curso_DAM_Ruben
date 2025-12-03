
***

## **Parte 1: Gestión Gráfica de Archivos y Directorios**

### **1. Comprimir y Descomprimir Archivos**

En el entorno gráfico de Linux, puedes comprimir archivos o directorios de forma muy sencilla. Generalmente, el proceso es el siguiente:

1.  **Selecciona** los archivos o directorios que deseas comprimir.
2.  Haz **clic con el botón derecho** sobre la selección.
3.  En el menú contextual, elige la opción **"Comprimir..."**.
4.  Se abrirá una ventana donde podrás:
    *   Elegir el **nombre** del archivo comprimido.
    *   Seleccionar el **formato** de compresión (por ejemplo, .zip, .tar.gz, .7z).
    *   Elegir la **ubicación** donde se guardará.

Para **descomprimir**, el proceso es igual de simple:

1.  Haz **clic con el botón derecho** sobre el archivo comprimido.
2.  Selecciona una opción como **"Extraer aquí"** (descomprime en la misma carpeta) o **"Extraer a..."** (te permite elegir una carpeta de destino).

**Formatos de compresión más comunes:**

*   **Paquetes .zip:** Son los más tradicionales y ampliamente compatibles, ideales para compartir archivos con usuarios de otros sistemas operativos como Windows (WinZip).
*   **Paquetes .tar, .tar.gz y .tar.bz2:** Muy utilizados en Linux. El formato `.tar` por sí solo agrupa archivos (empaqueta), mientras que `.tar.gz` o `.tar.bz2` los agrupa y además los comprime.
*   **Paquetes .rar:** Populares para archivos grandes. Es posible que necesites instalar software adicional desde el gestor de paquetes de tu distribución (como los paquetes `rar` y `unrar`) para poder gestionarlos.

### **2. Gestión de Permisos de Archivos y Directorios**

El sistema de permisos es fundamental en Linux para controlar quién puede leer, escribir o ejecutar archivos. Desde el entorno gráfico, puedes gestionar estos permisos fácilmente.

1.  Haz **clic con el botón derecho** sobre el archivo o directorio que deseas modificar.
2.  Selecciona la opción **"Propiedades"**.
3.  Ve a la pestaña **"Permisos"**.

En esta pantalla, podrás ver y cambiar los permisos para:

*   **Propietario:** El usuario que creó el archivo.
*   **Grupo:** El grupo de usuarios al que pertenece el archivo.
*   **Otros:** El resto de los usuarios del sistema.

Para cada uno de ellos, podrás asignar permisos de acceso como "Leer y escribir", "Solo lectura" o "Ninguno", usando los menús desplegables.

***

## **Parte 2: Gestión desde la Línea de Comandos (Terminal)**

### **1. Comprimir y Descomprimir Archivos**

La terminal ofrece herramientas potentes y flexibles para manejar archivos comprimidos.

#### **Archivos .tar (Empaquetar)**
El comando `tar` agrupa múltiples ficheros en uno solo (empaquetar), pero no los comprime.

*   **Empaquetar:** `tar -cvf paquete.tar directorio_a_empaquetar`
*   **Desempaquetar:** `tar -xvf paquete.tar`

**Resumen de opciones de `tar`:**
*   **c:** **c**rear un archivo.
*   **x:** e**x**traer archivos.
*   **v:** modo **v**erboso (visualizar lo que se está haciendo).
*   **f:** indicar el nombre del **f**ichero.

#### **Archivos .tar.gz (Empaquetar y Comprimir con gzip)**
Este es el formato más común en Linux.

*   **Comprimir:** `tar -czvf empaquetado.tar.gz carpeta_a_empaquetar/`
    *   La opción **-z** indica que se use compresión **gzip**.
*   **Descomprimir:** `tar -xzvf archivo.tar.gz`

#### **Archivos .gz (Solo Comprimir con gzip)**

*   **Comprimir:** `gzip -k fichero` (mantiene el original) o `gzip -r carpeta` (comprime todos los archivos de la carpeta recursivamente).
*   **Descomprimir:** `gzip -d fichero.gz`

#### **Archivos .zip**
Necesitarás los comandos `zip` y `unzip` (puede que tengas que instalarlos).

*   **Comprimir:** `zip archivo.zip carpeta_o_ficheros`
*   **Descomprimir:** `unzip archivo.zip`

### **2. Redirecciones y Tuberías**

#### **Redirecciones**
Permiten cambiar la entrada y salida por defecto de los comandos (que son el teclado y la pantalla).

*   **Redirección de entrada `<`:** Un comando lee datos desde un fichero en lugar del teclado.
    *   `cat < fichero.txt` (muestra el contenido de fichero.txt).
*   **Redirección de salida `>`:** El resultado de un comando se guarda en un fichero. **Si el fichero existe, lo sobrescribe.**
    *   `ls > f.txt` (guarda la lista de archivos en f.txt).
*   **Redirección de salida `>>`:** El resultado de un comando se **añade al final** de un fichero. Si no existe, lo crea.
    *   `ls >> f.txt` (añade la lista de archivos al final de f.txt).
*   **Redirección de errores `2>`:** Redirige solo los mensajes de error. Muy útil para ocultarlos.
    *   `find -name fic.txt 2> /dev/null` (busca el fichero y envía cualquier error al "dispositivo nulo", es decir, lo descarta).

#### **Tuberías (Pipes `|`)**
El carácter `|` (pipe) conecta la salida de un comando con la entrada de otro.

*   **Ejemplo:** `ls -l | more`
    *   El comando `ls -l` genera una lista larga de archivos.
    *   La tubería `|` envía esa lista directamente al comando `more`.
    *   `more` recibe la lista y la muestra de forma paginada.
*   **Otro ejemplo:** `ls -l | less` (funciona de manera similar, pero `less` es más interactivo).

### **3. Búsqueda de Archivos con `find`**
El comando `find` es una utilidad muy potente para localizar archivos y directorios.

`find [dónde_buscar] [criterio] [qué_buscar]`

**Parámetros interesantes:**
*   `-name "patrón"`: Busca por nombre. Se pueden usar comodines como `*`.
*   `-type f`: Busca solo **f**icheros.
*   `-type d`: Busca solo **d**irectorios.
*   `-perm 755`: Busca archivos con permisos específicos.
*   `-user nombre_usuario`: Busca archivos que pertenecen a un usuario.
*   `-group nombre_grupo`: Busca archivos que pertenecen a un grupo.
*   `-maxdepth N`: Limita la búsqueda a `N` niveles de profundidad.

**Ejemplos:**
*   `find . -name "f*"`: Busca en el directorio actual (`.`) todos los archivos que empiecen por "f".
*   `find /home/lolo/ -maxdepth 3 -name "exam*"`: Busca en `/home/lolo/` hasta 3 niveles de profundidad archivos que empiecen por "exam".

### **4. Gestión de Permisos**

#### **Conceptos Clave**
*   **Tipos de Permisos:**
    *   **Lectura (r):** Permite ver el contenido.
    *   **Escritura (w):** Permite modificar o borrar.
    *   **Ejecución (x):** Permite ejecutar un programa o acceder a un directorio.
*   **Grupos de Usuarios:**
    *   **Propietario (u):** El dueño del archivo.
    *   **Grupo (g):** El grupo al que pertenece el archivo.
    *   **Otros (o):** Todos los demás usuarios.

#### **Comando `chmod`**
Se utiliza para **ch**ange **mod**e (cambiar los permisos).

*   **Forma Octal (Numérica):** Se asigna un número a cada permiso (r=4, w=2, x=1) y se suman.
    *   **Ejemplo:** `chmod 740 fichero`
        *   **Propietario (u):** 7 (4+2+1) -> `rwx` (todos los permisos).
        *   **Grupo (g):** 4 -> `r--` (solo lectura).
        *   **Otros (o):** 0 -> `---` (ningún permiso).

*   **Forma Simbólica:** Utiliza letras para representar usuarios (`u, g, o, a` para todos) y operadores (`+` para añadir, `-` para quitar, `=` para establecer).
    *   **Ejemplo 1:** `chmod u=rwx,g=r,o= fichero` (establece permisos exactos).
    *   **Ejemplo 2:** `chmod g+w fichero` (añade permiso de escritura al grupo).
    *   **Ejemplo 3:** `chmod a-x fichero` (quita el permiso de ejecución a todos).

#### **Máscara de Permisos `umask`**
La `umask` define los permisos que se **quitarán** por defecto a los nuevos archivos y directorios que se creen.

*   Funciona a la inversa: el valor de `umask` se resta de los permisos máximos (666 para archivos, 777 para directorios).
*   **Comando:** `umask` (para ver la máscara actual) o `umask 077` (para cambiarla temporalmente).
*   **Ejemplo:** Si `umask` es `022`:
    *   **Nuevos directorios:** 777 - 022 = 755 (`rwxr-xr-x`).
    *   **Nuevos archivos:** 666 - 022 = 644 (`rw-r--r--`).
*   Para cambiarla de forma **permanente**, se debe modificar el fichero `~/.bashrc`.
