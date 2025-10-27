
***

## **Introducción a la Administración del Sistema**

Las **tareas de administración** son aquellas que van más allá del uso normal de un usuario estándar. Son realizadas por usuarios con privilegios elevados (que pertenecen al grupo `sudoers`) y son cruciales para mantener el sistema operativo seguro, actualizado y funcionando correctamente.

Algunas de estas tareas incluyen:
*   Agregar o quitar programas.
*   Gestionar actualizaciones del sistema.
*   Controlar usuarios y grupos.
*   Administrar procesos y servicios del sistema.
*   Organizar discos y particiones.
*   Realizar copias de seguridad.

---

## **Parte 1: Administración en el Entorno Gráfico**

### **1. Agregar o Quitar Software**

La forma más sencilla de gestionar programas en Ubuntu es a través de sus herramientas gráficas, que gestionan automáticamente las **dependencias** (otros paquetes que un programa necesita para funcionar).

*   **Centro de Software de Ubuntu (Ubuntu Software):** Es la "tienda de aplicaciones" de Ubuntu. Permite buscar, instalar y desinstalar programas de forma muy visual e intuitiva, con categorías, puntuaciones y descripciones.

*   **Gestor de Paquetes Synaptic:** Es una herramienta más avanzada y detallada que el Centro de Software. No suele venir instalada por defecto, pero es muy potente para gestionar paquetes, resolver problemas de dependencias y ver todos los archivos que componen un programa.

*   **Añadir Repositorios ("Software y Actualizaciones"):** Ubuntu obtiene el software de fuentes o "repositorios". Desde la aplicación "Software y Actualizaciones", en la pestaña "Otro software", puedes añadir repositorios de terceros (como los PPA - Personal Package Archives) para tener acceso a software más reciente o que no está en los repositorios oficiales de Ubuntu.

### **2. Gestión de Usuarios y Grupos**

Puedes gestionar quién usa el ordenador y qué puede hacer desde la configuración del sistema.

*   **Añadir, Modificar o Eliminar Usuarios:**
    1.  Ve a **Configuración del Sistema** -> **Usuarios**.
    2.  Haz clic en **"Desbloquear"** e introduce tu contraseña de administrador.
    3.  Usa el botón **"Añadir usuario..."** para crear una nueva cuenta.
    4.  Puedes elegir el **tipo de cuenta**:
        *   **Estándar:** Para un usuario normal, sin permisos de administración.
        *   **Administrador:** Puede instalar software y cambiar configuraciones importantes del sistema.
    5.  Al **eliminar un usuario**, el sistema te preguntará si deseas **conservar o eliminar sus archivos personales**.

*   **Gestión de Grupos y Ajustes Avanzados:**
    *   Para una gestión más detallada de los grupos, puedes instalar el paquete `gnome-system-tools`.
    *   Esta herramienta te permite crear grupos nuevos, añadir o quitar usuarios de un grupo existente y acceder a "Ajustes avanzados" de un usuario para cambiar su directorio personal, la shell de inicio de sesión o su ID de usuario.

### **3. Gestión de Procesos y Servicios**

Para ver qué programas y servicios se están ejecutando y cuántos recursos consumen, puedes usar herramientas gráficas.

*   **Monitor del Sistema:** Es la herramienta por defecto en Ubuntu para visualizar procesos. Muestra una lista de todos los procesos en ejecución, el uso de la CPU, la memoria RAM y el uso de la red. Desde aquí puedes:
    *   Ordenar los procesos por consumo de CPU o memoria para identificar los que más recursos usan.
    *   **Detener, continuar o terminar** un proceso que no responde (haciendo clic derecho sobre él).

*   **htop:** Aunque se ejecuta en una terminal, `htop` es una herramienta muy visual e interactiva que mejora al clásico `top`. Muestra el uso de la CPU por núcleo, la memoria y la swap de forma gráfica, y permite gestionar procesos fácilmente con el teclado. Es necesario instalarlo (`sudo apt install htop`).

---

## **Parte 2: Administración desde la Línea de Comandos (Terminal)**

La terminal ofrece un control más directo y potente para todas las tareas de administración.

### **1. Agregar o Quitar Software**

En sistemas basados en Debian como Ubuntu, la gestión de paquetes se realiza principalmente con `apt` y `dpkg`.

*   **Bajo Nivel: `dpkg`**
    *   Es la herramienta base para instalar paquetes `.deb` que has descargado manualmente. **No resuelve dependencias automáticamente**.
    *   **Instalar un paquete:** `sudo dpkg -i paquete.deb`
    *   **Desinstalar (conservando configuración):** `sudo dpkg -r nombre-paquete`
    *   **Desinstalar (eliminando todo):** `sudo dpkg -P nombre-paquete`

*   **Alto Nivel: `apt`**
    *   `apt` es la herramienta recomendada. Trabaja con los repositorios del sistema para descargar software y **gestionar todas las dependencias de forma automática**.
    *   **Actualizar la lista de paquetes:** `sudo apt update`
    *   **Actualizar todo el software instalado:** `sudo apt upgrade`
    *   **Instalar un paquete:** `sudo apt install nombre-paquete` (por ejemplo, `sudo apt install synaptic`)
    *   **Desinstalar un paquete:** `sudo apt remove nombre-paquete`
    *   **Desinstalar un paquete y sus archivos de configuración:** `sudo apt purge nombre-paquete`
    *   **Añadir un repositorio (PPA):** `sudo add-apt-repository ppa:nombre/ppa`

*   **Ficheros de Configuración:**
    *   Los repositorios oficiales se configuran en `/etc/apt/sources.list`.
    *   Los repositorios añadidos (como los PPAs) crean sus propios ficheros en el directorio `/etc/apt/sources.list.d/`.

### **2. Gestión de Usuarios y Grupos**

La terminal permite una gestión completa y programable de usuarios y grupos.

*   **Ficheros de Configuración Clave:**
    *   `/etc/passwd`: Almacena la información de los usuarios (nombre, ID, directorio personal, shell).
    *   `/etc/group`: Almacena la información de los grupos.

*   **Comandos de Gestión de Usuarios:**
    *   **Añadir un usuario:** `sudo adduser nombre_usuario` (es un script interactivo que crea el usuario, su grupo, su directorio personal y pide una contraseña).
    *   **Eliminar un usuario:** `sudo deluser nombre_usuario`
    *   **Eliminar un usuario y su directorio personal:** `sudo deluser --remove-home nombre_usuario`
    *   **Modificar un usuario:** `sudo usermod [opciones] nombre_usuario`
        *   `-aG`: Añade el usuario a un grupo secundario (`sudo usermod -aG sudo juan`).
        *   `-d`: Cambia el directorio personal.

*   **Comandos de Gestión de Grupos:**
    *   **Añadir un grupo:** `sudo addgroup nombre_grupo`
    *   **Eliminar un grupo:** `sudo delgroup nombre_grupo`
    *   **Ver los grupos de un usuario:** `groups nombre_usuario`

*   **Cambiar Propietario de Archivos:** `chown`
    *   **Cambiar propietario:** `sudo chown nuevo_propietario archivo`
    *   **Cambiar propietario y grupo:** `sudo chown usuario:grupo archivo`
    *   **Cambiar recursivamente:** `sudo chown -R usuario:grupo /directorio`

### **3. Gestión de Procesos y Servicios**

Un **proceso** es un programa en ejecución. La terminal ofrece herramientas para verlos y controlarlos.

*   **Ver Procesos:**
    *   **`ps` (Process Status):** Muestra una "foto" de los procesos actuales.
        *   `ps` (muestra tus procesos en la terminal actual).
        *   `ps aux` (muestra todos los procesos de todos los usuarios con mucho detalle).
    *   **`top`:** Muestra una lista de procesos que se actualiza en tiempo real, ordenada por uso de CPU.

*   **Controlar Procesos con `kill`:**
    *   El comando `kill` envía **señales** a los procesos para indicarles qué hacer. Se usa con el ID del proceso (PID).
    *   **Terminar un proceso de forma amable (pide que se cierre):** `kill PID_del_proceso` (envía la señal 15, SIGTERM).
    *   **Forzar la terminación de un proceso (lo mata inmediatamente):** `kill -9 PID_del_proceso` (envía la señal 9, SIGKILL). Úsalo solo si no responde.
    *   **Parar/Pausar un proceso:** `kill -19 PID_del_proceso` (señal SIGSTOP).
    *   **Continuar un proceso parado:** `kill -18 PID_del_proceso` (señal SIGCONT).
