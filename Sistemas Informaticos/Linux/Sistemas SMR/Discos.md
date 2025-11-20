
***

## **Parte 1: Administración en el Entorno Gráfico**

### **1. Gestión de Discos Duros**

Ubuntu incluye varias aplicaciones gráficas predeterminadas para gestionar tus discos y el espacio de almacenamiento.

*   **Discos (Disks):** Es la herramienta principal para la gestión de unidades de almacenamiento. Con ella puedes:
    *   Ver todos los discos duros, SSDs, y unidades USB conectadas al sistema.
    *   **Formatear** una partición o un disco completo.
    *   **Crear, eliminar y redimensionar particiones.**
    *   **Modificar opciones de montaje**, como hacer que una partición se monte automáticamente al iniciar el sistema.
    *   Crear y restaurar imágenes de disco.
    *   Probar el rendimiento y ver los datos SMART para comprobar la salud del disco.

*   **Analizador de uso (Disk Usage Analyzer):** Esta utilidad escanea tus carpetas y te muestra una representación visual de qué archivos y directorios están ocupando más espacio en tu disco. Es muy útil para liberar espacio.

*   **Creador de discos de arranque:** Permite crear una unidad USB "booteable" a partir de un archivo de imagen ISO, lo cual es fundamental para instalar Ubuntu u otros sistemas operativos.

### **2. Copias de Seguridad (Backups)**

Ubuntu viene con una herramienta de copias de seguridad integrada y fácil de usar.

*   **Déjà Dup (Copias de seguridad):** Es la utilidad de respaldo por defecto, una interfaz gráfica para la potente herramienta `duplicity`.
    *   **Funcionamiento:** Se inicia automáticamente un monitor (`deja-dup-monitor`) al iniciar sesión para gestionar las copias programadas.
    *   **Configuración:** Permite configurar de manera sencilla todos los aspectos de la copia:
        *   **Carpetas que guardar:** Eliges qué directorios incluir en la copia (por ejemplo, tu carpeta personal).
        *   **Carpetas que ignorar:** Excluyes directorios que no necesitas respaldar (como la Papelera o Descargas).
        *   **Ubicación de almacenamiento:** Dónde se guardará la copia (un disco duro externo, un servidor de red, Google Drive, etc.).
        *   **Planificación:** Puedes programar copias automáticas (diarias, semanales).
    *   **Tipos de Copia:** La primera vez crea una **copia de seguridad completa**. Las siguientes veces, crea **copias incrementales**, guardando solo los archivos que han cambiado, lo que ahorra tiempo y espacio.
    *   **Restauración:** El proceso de restauración es guiado y te pregunta:
        *   **Desde dónde** restaurar (la ubicación de la copia).
        *   **Desde cuándo** restaurar (la fecha de la copia que quieres recuperar).
        *   **A dónde** restaurar (a la ubicación original o a una carpeta nueva).

### **3. Monitorización del Sistema**

Para supervisar el rendimiento de tu sistema, Ubuntu incluye el "Monitor del sistema".

*   **Monitor del sistema:** Esta aplicación te da una visión general del estado de tu ordenador en tiempo real. Se divide en tres pestañas principales:
    *   **Procesos:** Muestra una lista de todas las aplicaciones y procesos en ejecución, permitiéndote ver su consumo de CPU y memoria, y finalizarlos si es necesario.
    *   **Recursos:** Presenta gráficos históricos del uso de la **CPU**, la **memoria RAM**, el **intercambio (swap)** y la **actividad de red**.
    *   **Sistemas de archivos:** Muestra una lista de tus particiones, su tamaño total, el espacio disponible y el porcentaje de uso.

---

## **Parte 2: Administración desde la Línea de Comandos (Terminal)**

### **1. Gestión de Servicios del Sistema (`systemd`)**

Los **servicios** (o demonios) son programas que se ejecutan en segundo plano para realizar funciones esenciales (red, impresión, etc.). En Ubuntu, el sistema que los gestiona es `systemd`.

*   **Comando principal:** `systemctl`
    *   **Ver el estado de todos los servicios:** `systemctl status`
    *   **Ver una lista de todas las unidades activas:** `systemctl list-units`
    *   **Ver todas las unidades (activas e inactivas):** `systemctl list-units --all`
    *   **Filtrar por tipo (ej. solo servicios):** `systemctl list-units --type=service`

*   **Controlar un servicio específico (ej. `cron`):**
    *   **Iniciar:** `sudo systemctl start cron`
    *   **Detener:** `sudo systemctl stop cron`
    *   **Reiniciar:** `sudo systemctl restart cron`
    *   **Ver estado:** `sudo systemctl status cron`

### **2. Administración de Discos Duros**

La gestión de discos desde la terminal se basa en el concepto de **montaje**.

*   **Ideas clave:**
    1.  Se **montan particiones** (ej. `/dev/sda1`), no discos enteros (`/dev/sda`).
    2.  Una partición se monta en un **directorio vacío** (punto de montaje).
    3.  El montaje se configura en el fichero `/etc/fstab` para que sea automático al arrancar el sistema.

*   **El fichero `/etc/fstab`:**
    *   Controla qué particiones se montan al inicio y con qué opciones.
    *   Cada línea define un punto de montaje y tiene la siguiente estructura:
        `<file system> <mount point> <type> <options> <dump> <pass>`
    *   **`<file system>`:** Identifica la partición (ej. `UUID=...` o `/dev/sda1`).
    *   **`<mount point>`:** El directorio donde se montará (ej. `/home` o `/media/datos`).
    *   **`<type>`:** El sistema de archivos (ej. `ext4`, `ntfs`, `vfat`).
    *   **`<options>`:** Permisos y comportamiento (ej. `defaults`, `rw` para lectura/escritura, `ro` para solo lectura, `auto` para montar al inicio).

### **3. Copias de Seguridad (`duplicity`)**

*   **`duplicity`** es la herramienta de línea de comandos que usa Déjà Dup por detrás. Es extremadamente potente para crear scripts y automatizar copias de seguridad cifradas, incrementales y remotas.
    *   **Uso básico:** `duplicity [opciones] /ruta/origen file:///ruta/destino`

### **4. Automatización de Tareas (`cron`)**

Para programar la ejecución de scripts o comandos a intervalos regulares, Linux utiliza el demonio `cron`.

*   **Funcionamiento:** `cron` se ejecuta en segundo plano y revisa cada minuto los ficheros `crontab` para ver si hay alguna tarea que ejecutar.
*   **Comandos `crontab`:**
    *   **Editar las tareas de tu usuario:** `crontab -e`
    *   **Listar las tareas de tu usuario:** `crontab -l`
    *   **Editar las tareas del sistema (como administrador):** `sudo crontab -e`

*   **Formato de una línea en `crontab`:**
    `Minuto Hora DíaMes Mes DíaSemana /ruta/al/comando_o_script`
    *   **Minuto:** 0-59
    *   **Hora:** 0-23
    *   **Día del Mes:** 1-31
    *   **Mes:** 1-12
    *   **Día de la Semana:** 0-7 (0 y 7 son Domingo). También se puede usar `sun`, `mon`, etc.
    *   El asterisco (`*`) significa "todos los valores".

*   **Ejemplos:**
    *   `15 10 * * * /home/usuario/scripts/ejem1.sh` -> Se ejecuta todos los días a las 10:15.
    *   `30 7 11 11 sun /home/curso/scripts/ejem2.sh` -> Se ejecuta a las 7:30 el 11 de noviembre, solo si es domingo.
