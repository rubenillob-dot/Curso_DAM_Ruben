
***

## **Parte 1: Administración en el Entorno Gráfico**

### **1. Gestión de la Configuración de Red**

Por defecto, Ubuntu se configura en "modo itinerante", lo que significa que intenta obtener una configuración de red automáticamente a través de DHCP. Sin embargo, podemos modificarla fácilmente para adaptarla a nuestras necesidades.

1.  **Acceder a la Configuración:**
    *   Haz clic en el icono de red en la esquina superior derecha del escritorio.
    *   Selecciona "Configuración de red cableada" (o "Wi-Fi", según corresponda).
    *   Haz clic en el icono del engranaje (⚙️) junto a tu conexión activa.

2.  **Ver y Modificar la Configuración:**
    *   **Pestaña "Detalles":** Aquí puedes ver la información actual de tu conexión, como la velocidad, la dirección IP, la dirección MAC (física), la ruta predeterminada (puerta de enlace) y los servidores DNS que estás utilizando.
    *   **Pestaña "IPv4":** Esta es la sección clave para cambiar la configuración.
        *   **Automático (DHCP):** Es el modo por defecto, donde el router o un servidor DHCP asigna una IP automáticamente.
        *   **Manual:** Selecciona esta opción para configurar una IP estática. Deberás rellenar los siguientes campos:
            *   **Dirección:** La dirección IP que quieres asignar a tu equipo (ej. `192.168.1.11`).
            *   **Máscara de red:** Define el tamaño de tu red (ej. `255.255.255.0`).
            *   **Puerta de enlace:** La dirección IP de tu router (ej. `192.168.1.1`).
            *   **DNS:** Los servidores para traducir nombres de dominio (ej. `8.8.8.8, 8.8.4.4`).

### **2. Compartición de Archivos (con Windows)**

Ubuntu permite compartir carpetas en la red de forma sencilla a través del explorador de archivos (Nautilus).

1.  **Iniciar la Compartición:**
    *   Haz clic con el **botón derecho** sobre la carpeta que deseas compartir.
    *   Selecciona la opción **"Recurso compartido de red local"**.

2.  **Configurar la Carpeta Compartida:**
    *   Activa la casilla **"Compartir esta carpeta"**.
    *   **Nombre compartido:** El nombre que tendrá la carpeta en la red.
    *   **Opciones de permisos:**
        *   **"Permitir a otras personas crear y eliminar archivos en esta carpeta":** Otorga permisos de escritura a otros usuarios.
        *   **"Acceso invitado":** Permite que usuarios sin una cuenta en tu máquina accedan a la carpeta.

3.  **Instalación del Servicio (Primera Vez):**
    *   La primera vez que compartas una carpeta, el sistema te informará que "El servicio de compartición no está instalado" y te ofrecerá instalar los paquetes necesarios (el servicio **Samba**) para que los equipos con Windows puedan ver y acceder a tus carpetas compartidas. Simplemente haz clic en "Instalar el servicio".

4.  **Ajuste Automático de Permisos:**
    *   Si los permisos del directorio no son adecuados para las opciones de compartición que has elegido (por ejemplo, permitir escritura a otros), el sistema te pedirá permiso para añadirlos automáticamente.

5.  **Acceder desde la Red:**
    *   Una vez compartida, la carpeta será visible para otros equipos en la red. Desde un equipo Windows, por ejemplo, podrás acceder a ella a través de la sección "Red" del explorador de archivos o escribiendo directamente la ruta `\\ip_del_equipo_linux` o `\\nombre_del_equipo_linux`.

***

## **Parte 2: Administración desde la Línea de Comandos (Terminal)**

La terminal ofrece un conjunto de herramientas esenciales para diagnosticar y configurar la red.

### **1. Comandos Básicos de Gestión de Red**

*   **`ip address` (o `ip a`):** Es el comando moderno para ver la configuración de todas las interfaces de red. Muestra información detallada como la dirección IP, la dirección MAC (link/ether) y el estado de la interfaz.

*   **`ifconfig`:** El comando clásico para mostrar la configuración de red. En versiones recientes de Ubuntu, puede que necesites instalarlo primero (`sudo apt install net-tools`). Es menos detallado que `ip`, pero sigue siendo muy utilizado.
    *   `ifconfig [interfaz] down`: Desactiva una interfaz de red.
    *   `ifconfig [interfaz] up`: Activa una interfaz de red.

*   **`lshw -class network`:** Muestra información de hardware muy detallada sobre tus tarjetas de red, como el fabricante, el modelo, la velocidad máxima soportada y la dirección MAC.

*   **`ping`:** Es la herramienta fundamental para verificar la conectividad. Envía un pequeño paquete a un destino y espera una respuesta.
    *   `ping 8.8.8.8` (verifica si tienes conexión con un servidor de Google por IP).
    *   `ping google.com` (verifica la conexión y la resolución de DNS).

### **2. Conceptos Básicos de Red (Recordatorio)**

*   **Dirección IP:** Identificador único de un dispositivo en una red.
*   **Máscara de Red (Netmask):** Define qué parte de la IP corresponde a la red y qué parte al dispositivo.
*   **Puerta de Enlace (Gateway):** La dirección del router, que sirve como punto de salida de la red local hacia internet.
*   **Servidores DNS:** Traducen nombres de dominio (como `www.google.com`) a direcciones IP.
