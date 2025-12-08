Aquí tienes una **Cheat Sheet (Hoja de Referencia)** completa basada en los documentos que has subido, organizada por categorías.

He incluido los comandos mencionados en el texto, explicaciones claras y he añadido **"Opciones Extra"** que son muy comunes en el mundo real y complementan lo aprendido en tus apuntes.

---

### 1. Gestión de Paquetes (Software)
Comandos para instalar, actualizar y eliminar programas en distribuciones basadas en Debian/Ubuntu (`apt`, `dpkg`).

| Comando | Función Principal | Opciones del PDF | **Opciones Extra Útiles** |
| :--- | :--- | :--- | :--- |
| **`sudo apt update`** | Actualiza la lista de repositorios (no instala nada, solo "refresca" la lista). | - | - |
| **`sudo apt install`** | Instala un paquete nuevo. | `paquete` | `-y` (acepta automáticamente la instalación). |
| **`sudo apt upgrade`** | Actualiza los paquetes instalados a la versión más reciente. | `paquete` (opcional) | `-y` (para no preguntar sí/no). |
| **`sudo apt remove`** | Desinstala un paquete (mantiene configuración). | `paquete` | `--autoremove` (borra dependencias que ya no sirven). |
| **`sudo apt purge`** | Desinstala un paquete y **borra** sus archivos de configuración. | `paquete` | - |
| **`sudo apt search`** | Busca un paquete en los repositorios. | `paquete` | - |
| **`sudo apt list`** | Lista paquetes. | `paquete` | `--installed` (solo lista los instalados). |
| **`sudo add-apt-repository`**| Añade un repositorio externo o PPA. | `ppa:nombre` | `-r` (para eliminar el repositorio). |
| **`dpkg`** | Gestor de paquetes de bajo nivel (archivos `.deb`). | `-i` (instalar), `-r` (eliminar), `-P` (purgar). | `-l` (listar paquetes instalados, útil con `grep`). |

---

### 2. Archivos y Directorios: Empaquetado y Compresión
Herramientas para juntar varios archivos en uno solo (`tar`) y reducir su tamaño (`gzip`).

| Comando | Función Principal | Opciones del PDF | **Opciones Extra Útiles** |
| :--- | :--- | :--- | :--- |
| **`tar`** | Empaqueta (archiva) múltiples archivos/carpetas. | `-c` (crear), `-x` (extraer), `-v` (ver proceso), `-f` (archivo), `-r` (añadir), `-t` (listar). | `-C ruta` (extraer en una carpeta específica). |
| **`tar` (Compresión)** | Usa `tar` combinado con compresión. | `-z` (usa gzip `.tar.gz`), `-j` (usa bzip2). | - |
| **`gzip`** | Comprime un archivo (lo reemplaza por `.gz`). | `fichero`, `-d` (descomprimir). | `-9` (máxima compresión), `-k` (keep, no borra el original). |
| **`gunzip`** | Descomprime archivos `.gz`. | `fichero.gz` | - |

> **Ejemplos rápidos:**
> *   Crear comprimido: `tar -czvf copia.tar.gz carpeta/`
> *   Descomprimir: `tar -xzvf copia.tar.gz`

---

### 3. Visualización y Manipulación de Texto
Comandos para leer archivos y modificar la salida de texto.

| Comando | Función Principal | Opciones del PDF | **Opciones Extra Útiles** |
| :--- | :--- | :--- | :--- |
| **`cat`** | Muestra todo el contenido de un archivo de golpe. | `> archivo` (crear/sobrescribir). | `-n` (numera las líneas al mostrarlo). |
| **`more`** | Muestra contenido paginado (avanza con espacio). | - | - |
| **`less`** | Muestra contenido paginado (permite subir/bajar). | - | `/texto` (busca texto dentro del archivo), `q` (salir). |
| **`head`** | Muestra las primeras líneas. | `-n` o `-5` (número de líneas). | - |
| **`tail`** | Muestra las últimas líneas. | `-n` o `-5` (número de líneas). | `-f` (follow: muestra en tiempo real si el archivo crece, ideal para logs). |
| **`sort`** | Ordena las líneas de texto. | `-n` (numérico), `-r` (inverso), `-o` (salida a archivo). | `-k X` (ordena por la columna número X), `-u` (elimina duplicados). |
| **`wc`** | Cuenta elementos del archivo. | `-l` (líneas), `-w` (palabras), `-c` (bytes). | `-L` (longitud de la línea más larga). |
| **`cut`** | Corta columnas o secciones de texto. | `-c` (por caracteres), `-d` (delimitador), `-f` (field/campo). | `--complement` (muestra todo MENOS lo seleccionado). |

---

### 4. Búsqueda de Archivos
Comando potente para encontrar ficheros en el sistema.

| Comando | Función Principal | Opciones del PDF | **Opciones Extra Útiles** |
| :--- | :--- | :--- | :--- |
| **`find`** | Busca archivos en una jerarquía de directorios. | `-name` (por nombre), `-iname` (ignora mayús/minús). | `-type f` (solo archivos), `-type d` (solo directorios), `-size +5M` (mayores de 5MB), `-exec` (ejecuta un comando sobre lo encontrado). |

---

### 5. Historial y Shell
Control de la terminal y scripts.

| Comando | Función Principal | Opciones del PDF | **Opciones Extra Útiles** |
| :--- | :--- | :--- | :--- |
| **`history`** | Muestra la lista de comandos ejecutados anteriormente. | `!n` (ejecuta el número n), `-c` (borrar historial). | `history | grep "comando"` (busca en el pasado). |
| **`chmod`** | Cambia permisos (usado para hacer ejecutables scripts). | `a+x` (all + execute). | `u+x` (solo usuario), `755` (permisos numéricos). |
| **`bash` / `sh`** | Intérpretes de comandos. | `bash script.sh` | - |
| **Shebang** | Línea 1 de un script para indicar el intérprete. | `#!/bin/bash` | `#!/usr/bin/env python3` (para scripts de python). |

---

### 6. Operadores de Redirección y Tuberías (Pipes)
Conceptos fundamentales mencionados en los ejercicios.

*   **`|` (Pipe / Tubería):** Pasa el resultado (salida) de un comando como entrada al siguiente.
    *   *Ejemplo:* `ls -l | wc -l` (Cuenta cuántos archivos hay listados).
    *   *Ejemplo:* `sort notas.txt | head -1` (Ordena y coge solo el primero).
*   **`>` (Redirección de salida):** Guarda el resultado en un archivo (sobrescribe si existe).
    *   *Ejemplo:* `ls > listado.txt`.
*   **`>>` (Redirección de anexado):** (Opción extra) Guarda el resultado al final de un archivo (no borra lo anterior).
    *   *Ejemplo:* `date >> log.txt`.

### Truco para los ejercicios de `sort` y `cut` (Actividad 4 y 5)
En tus documentos aparece un ejercicio complejo con notas. Aquí la lógica:
1.  **`sort -k3`**: Ordena usando la **columna 3** (la nota).
2.  **`sort -r`**: Orden inverso (mayor a menor).
3.  **`head -1`**: Se queda solo con la primera línea (la nota más alta).
4.  **`cut -f3`**: Corta y se queda solo con el campo 3 (el número de la nota).