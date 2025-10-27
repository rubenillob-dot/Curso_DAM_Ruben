

### **Parte 1: Tareas desde el Entorno Gráfico (GUI)**

Esta sección cubre todas las operaciones que se realizan de manera visual, utilizando ventanas, iconos y el ratón.

#### **1. Primeros Pasos e Interfaz Gráfica**

*   **Inicio y Cierre de Sesión:**
    *   Al encender el equipo, aparece una pantalla de inicio de sesión donde seleccionas tu usuario e introduces la contraseña.
    *   Una vez dentro, te encuentras con el escritorio (como Unity o GNOME), que incluye:
        *   **El Lanzador (Launcher/Dock):** Una barra lateral (o inferior) con accesos directos a aplicaciones favoritas, aplicaciones abiertas y el botón principal de Ubuntu.
        *   **Tablero (Activities/Dashboard):** Al pulsar el botón de Ubuntu (o la tecla `Super`/`Windows`), se abre una vista general donde puedes buscar y lanzar cualquier aplicación o archivo.
        *   **Área de Notificación:** Ubicada en la esquina superior derecha, permite gestionar la red, el sonido, el calendario y las opciones de sesión.

*   **Opciones en el Área de Notificación:**
    *   **Configuración del sistema:** Acceso directo al panel de control.
    *   **Bloquear:** Bloquea la pantalla para proteger tu sesión.
    *   **Cambiar de Usuario:** Inicia una nueva sesión sin cerrar la actual (si hay otros usuarios creados).
    *   **Cerrar Sesión:** Cierra todos los programas y vuelve a la pantalla de inicio de sesión.
    *   **Suspender o Apagar:** Pone el equipo en modo de bajo consumo o lo apaga completamente.

#### **2. Configuración del Sistema (Panel de "Configuración")**

Puedes acceder a todas estas opciones desde el panel de "Configuración".

*   **Cambiar el Nombre del Equipo:**
    1.  Ve a `Configuración`.
    2.  En el menú lateral, baja hasta la sección **"Acerca de"**.
    3.  Pulsa sobre el **"Nombre del dispositivo"** actual para renombrarlo.

*   **Comprobación y Gestión de Drivers:**
    1.  Abre la utilidad **"Software y actualizaciones"**.
    2.  Ve a la pestaña **"Más controladores"** (Additional Drivers).
    3.  Aquí el sistema buscará y te mostrará los controladores privativos disponibles (comúnmente para tarjetas gráficas o Wi-Fi) y te permitirá elegir cuál usar.

*   **Gestión de Repositorios de Software:**
    1.  En la misma utilidad **"Software y actualizaciones"**, ve a la pestaña **"Otro software"**.
    2.  Desde aquí puedes **Añadir**, **Editar** o **Quitar** repositorios de software (como los PPA) para instalar programas que no están en las fuentes oficiales de Ubuntu.

*   **Configuración de la Red:**
    1.  Haz clic en el icono de red en el área de notificación y selecciona `Configuración de red cableada` o `Configuración de Wi-Fi`.
    2.  En la pestaña **"Detalles"** puedes ver la información actual (IP, MAC, DNS).
    3.  En la pestaña **"IPv4"** e **"IPv6"** puedes cambiar de configuración automática (DHCP) a manual para asignar una IP estática.

*   **Configuración de Actualizaciones:**
    1.  Abre **"Software y actualizaciones"** y ve a la pestaña **"Actualizaciones"**.
    2.  Aquí puedes configurar la frecuencia con la que el sistema buscará actualizaciones y si estas se descargarán e instalarán automáticamente.

#### **3. Utilidades del Sistema**

*   **Explorador de Archivos (Nautilus):** Es el gestor de archivos gráfico por defecto. Permite navegar por carpetas, copiar, mover y eliminar archivos de forma visual.
*   **Centro de Software (Ubuntu Software):** Es la "tienda de aplicaciones" de Ubuntu. Permite buscar, instalar y desinstalar programas de manera sencilla y gráfica, sin necesidad de usar la terminal.

---

### **Parte 2: Tareas desde la Línea de Comandos (Terminal)**

Esta sección cubre las operaciones que se realizan escribiendo comandos en una terminal.

#### **1. Conceptos Fundamentales de la Interfaz de Texto**

*   **La Terminal:** Es la interfaz donde se introducen comandos de texto. Las acciones son directas y no utilizan una representación gráfica.
*   **Intérpretes de Comandos (Shells):** Linux dispone de varios intérpretes como `bash` (el más común), `zsh`, `ksh`, `csh`, etc.
*   **"Todo es un fichero":** En Linux, casi todo se representa como un fichero, incluyendo directorios, discos duros, y otros dispositivos. Estos se encuentran principalmente en el directorio `/dev`.
*   **Terminales Virtuales (TTYs):** Además de la ventana de terminal en el entorno gráfico, Linux ofrece consolas de texto a pantalla completa. Puedes acceder a ellas con la combinación de teclas **`Ctrl + Alt + F3`** (o F4, F5, F6). Para volver al modo gráfico, usa **`Ctrl + Alt + F1`** o **`Ctrl + Alt + F2`**.

#### **2. Tareas de Configuración y Gestión**

*   **Cambiar el Nombre del Equipo:**
    *   Para **ver** el nombre actual:
      ```bash
      hostname
      ```
    *   Para **ver más detalles** del sistema:
      ```bash
      hostnamectl
      ```
    *   Para **cambiar permanentemente** el nombre del equipo (necesitas permisos de administrador):
      ```bash
      sudo hostnamectl set-hostname NuevoNombreDelEquipo
      ```

*   **Gestión de Repositorios y Actualizaciones (usando `apt`):**
    *   **Archivo de configuración:** Los repositorios se configuran en el fichero `/etc/apt/sources.list` y en los ficheros dentro de `/etc/apt/sources.list.d/`. Las líneas que comienzan con `#` son comentarios y son ignoradas.
    *   **Actualizar la lista de paquetes:** Antes de instalar o actualizar, siempre debes refrescar la lista de software disponible en los repositorios.
      ```bash
      sudo apt update
      ```    *   **Actualizar los paquetes instalados:** Una vez actualizada la lista, este comando descarga e instala las nuevas versiones de todos tus programas.
      ```bash
      sudo apt upgrade
      ```

#### **3. Estructura de Directorios de Linux (FHS)**

Entender la estructura de directorios es fundamental para trabajar en la terminal. Los más importantes son:

*   `/bin`: Contiene los comandos (binarios) esenciales para todos los usuarios.
*   `/sbin`: Comandos esenciales del sistema, para ser usados por el administrador (root).
*   `/etc`: Ficheros de configuración de todo el sistema.
*   `/home`: Directorios personales de los usuarios. Cada usuario tiene su propia carpeta aquí.
*   `/root`: El directorio personal del superusuario (root).
*   `/dev`: Ficheros que representan los dispositivos del sistema (discos, terminales, etc.).
*   `/lib`: Bibliotecas esenciales para los programas en `/bin` y `/sbin`.
*   `/var`: Ficheros de datos variables, como logs (`/var/log`), correo, etc.
*   `/tmp`: Ficheros temporales que se borran al reiniciar.
*   `/usr`: Contiene la mayoría de los programas y ficheros de los usuarios (no confundir con `/home`).
*   `/boot`: Ficheros necesarios para el arranque del sistema, incluyendo el kernel de Linux.
*   `/mnt` y `/media`: Puntos de montaje para dispositivos extraíbles como USBs o discos externos.