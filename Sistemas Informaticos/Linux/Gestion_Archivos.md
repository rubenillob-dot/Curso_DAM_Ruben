
## **Parte 1: Gestión de Archivos y Directorios en Entorno Gráfico**

### **1. Operaciones con Directorios en Entorno Gráfico**

Para trabajar con directorios desde el entorno gráfico, abrimos el explorador de archivos. Al pulsar con el botón derecho del ratón sobre un directorio o espacio vacío, se desplegará un menú contextual con las siguientes opciones posibles:

*   **Abrir:** Abre el directorio para ver su contenido.
*   **Abrir en una pestaña nueva:** Abre el directorio en una nueva pestaña dentro del explorador.
*   **Crear:** Permite crear nuevos directorios o archivos.
*   **Copiar:** Copia el directorio seleccionado para pegarlo en otra ubicación.
*   **Mover a... / Copiar en...:** Abre un cuadro de diálogo para seleccionar un destino al que mover o copiar el directorio.
*   **Mover a la papelera:** Envía el directorio a la papelera de reciclaje.
*   **Renombrar:** Permite cambiar el nombre del directorio.
*   **Comprimir:** Crea un archivo comprimido a partir del directorio seleccionado.
*   **Propiedades:** Muestra información detallada como el tamaño, la ubicación, los permisos y la fecha de modificación.

### **2. Operaciones con Archivos en Entorno Gráfico**

De manera similar, para gestionar archivos, abrimos el explorador y hacemos clic derecho sobre el archivo deseado para ver las opciones disponibles:

*   **Abrir con:** Permite seleccionar la aplicación con la que se desea abrir el archivo.
*   **Cortar:** Prepara el archivo para moverlo a otra ubicación.
*   **Copiar:** Duplica el archivo para pegarlo en otro lugar.
*   **Mover a... / Copiar en...:** Facilita mover o copiar el archivo a una nueva ubicación mediante un cuadro de diálogo.
*   **Mover a la papelera:** Elimina el archivo enviándolo a la papelera.
*   **Cambiar nombre:** Permite editar el nombre del archivo.
*   **Comprimir:** Agrupa el archivo en un formato comprimido.
*   **Propiedades:** Ofrece detalles sobre el tipo de archivo, tamaño, permisos y fechas importantes.

***

## **Parte 2: Gestión de Archivos y Directorios con Comandos**

### **1. Introducción y Conceptos Fundamentales**

#### **1.1. Sistema de Archivos**
Un sistema de archivos es el conjunto de normas y procedimientos que un sistema operativo utiliza para organizar y gestionar los archivos en un dispositivo de almacenamiento. Define características clave como:
*   El tamaño máximo de las particiones.
*   El tamaño máximo de los ficheros.
*   La longitud máxima de los nombres de archivo.

El sistema de archivos predeterminado en muchas distribuciones de Linux, como Ubuntu, es **EXT4**.

#### **1.2. Características de EXT4**
*   **Capacidad:** Soporta sistemas de archivos de hasta 16 TB y maneja archivos individuales de hasta 16 TB.
*   **Sensibilidad a mayúsculas:** Distingue entre mayúsculas y minúsculas en los nombres de archivos (`Archivo.txt` es diferente de `archivo.txt`).
*   **Estructura jerárquica:** Organiza los archivos y directorios en una estructura de árbol que comienza en el directorio raíz (`/`).
*   **Carácter separador:** Utiliza la barra inclinada (`/`) para separar los directorios en una ruta.
*   **Caracteres no recomendados:** Se debe evitar el uso de los siguientes caracteres en los nombres de archivo: `! # & ( ) ‘ “ ; | > < @ $ { } * ? \ Tab Espacio Retroceso +`.

#### **1.3. Rutas de Archivos y Directorios**
Una **ruta** es el camino que especifica la ubicación de un archivo o directorio.

*   **Ruta absoluta:** Comienza desde el directorio raíz (`/`) y detalla la ruta completa.
    *   **Ejemplos:** `/home/usuario/Documentos`, `/etc/nginx/nginx.conf`
*   **Ruta relativa:** Comienza desde el directorio actual en el que nos encontramos.
    *   **Ejemplos:** `../Imágenes`, `./scripts/backup.sh`

Para saber en qué directorio te encuentras, utiliza el comando:
*   **`pwd`**: Muestra el directorio de trabajo actual.

### **2. Comandos para la Gestión de Directorios**

*   **Ver el contenido de un directorio: `ls`**
    *   `ls -l`: Formato largo, muestra permisos, propietario, tamaño y fecha.
    *   `ls -a`: Muestra todos los archivos, incluyendo los ocultos (que empiezan por `.`).
    *   `ls -h`: Muestra el tamaño en un formato legible para humanos (KB, MB, GB).
    *   `ls -t`: Ordena los archivos por fecha de modificación.
    *   `ls -R`: Muestra el contenido del directorio y de todos sus subdirectorios de forma recursiva.

*   **Crear un directorio: `mkdir`**
    *   `mkdir nombre_directorio`: Crea un nuevo directorio.
    *   `mkdir -p ruta/completa/nuevo_directorio`: Crea toda la estructura de directorios necesaria (`-p` de "parents").

*   **Eliminar un directorio (solo si está vacío): `rmdir`**
    *   `rmdir nombre_directorio`: Elimina un directorio vacío.

*   **Moverse entre directorios: `cd`**
    *   `cd nombre_directorio`: Cambia al directorio especificado.
    *   `cd ..`: Sube al directorio padre.
    *   `cd`: Sin argumentos, te lleva a tu directorio `HOME`.

*   **Mover o renombrar un directorio: `mv`**
    *   `mv origen destino`: Mueve el directorio `origen` a la ubicación `destino`.
    *   `mv nombre_actual nuevo_nombre`: Renombra un directorio.

*   **Copiar un directorio: `cp`**
    *   `cp -r origen destino`: Copia el directorio `origen` y todo su contenido de forma recursiva (`-r`) a la ubicación `destino`.

*   **Ver la estructura de directorios en forma de árbol: `tree`**
    *   (Puede que necesites instalarlo primero: `sudo apt-get install tree`).

### **3. Comandos para la Gestión de Archivos**

*   **Ver el contenido de un fichero: `cat`, `more`, `less`**
    *   `cat fichero`: Muestra todo el contenido del fichero en la terminal.
        *   `cat -n fichero`: Muestra el contenido con las líneas numeradas.
    *   `more fichero`: Muestra el contenido de forma paginada (avanza con la barra espaciadora, sale con `q`).
    *   `less fichero`: Similar a `more` pero más avanzado, permite navegar hacia adelante y hacia atrás (sale con `q`).

*   **Crear un archivo vacío: `touch`**
    *   `touch nombre_archivo`: Crea un archivo vacío o actualiza su fecha de modificación si ya existe.

*   **Eliminar un archivo: `rm`**
    *   `rm nombre_archivo`: Elimina el archivo de forma permanente.

*   **Mover o renombrar un archivo: `mv`**
    *   `mv archivo.txt /ruta/destino/`: Mueve el archivo.
    *   `mv archivo_viejo.txt archivo_nuevo.txt`: Renombra el archivo.

*   **Copiar un archivo: `cp`**
    *   `cp origen.txt destino.txt`: Copia el contenido de `origen.txt` a `destino.txt`.
    *   `cp archivo.txt /ruta/destino/`: Copia el archivo a otro directorio.

*   **Editar archivos de texto: `vi`, `nano`, `pico`, `gedit`**
    *   Estos son editores de texto de línea de comandos (`vi`, `nano`, `pico`) o gráficos (`gedit`) que permiten modificar el contenido de los archivos.

### **4. Ayuda del Sistema**
Para obtener ayuda sobre cualquier comando, puedes usar:
*   **`man comando`**: Muestra el manual completo del comando.
*   **`comando --help`**: Muestra una ayuda rápida y las opciones disponibles.
