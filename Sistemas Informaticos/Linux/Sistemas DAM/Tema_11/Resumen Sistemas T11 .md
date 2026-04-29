# Resumen Sistemas T11

Clase: Sistemas Informáticos (https://www.notion.so/Sistemas-Inform-ticos-27f981b058b981569f34ea256ed796ed?pvs=21)
Estado: En curso
Tipo: Entrega

# 1. Servidor Samba (Configuración por Terminal)

**Resumen:** Trata sobre cómo convertir un equipo Linux en un servidor de archivos compatible con Windows. Se basa en instalar el servicio y editar el archivo principal de configuración `/etc/samba/smb.conf`.

### Comandos y Explicación para el Examen

| Comando | ¿Para qué sirve? | Ejemplo | Explicación del procedimiento |
| --- | --- | --- | --- |
| `apt install samba` | Instala el servicio Samba. | `sudo apt install samba` | "Utilizo el gestor de paquetes `apt` para descargar e instalar los binarios del servidor Samba". |
| `systemctl status smbd` | Comprueba si el servicio está activo. | `sudo systemctl status smbd` | "Uso `systemctl` para verificar que el 'demonio' (servicio) Samba está corriendo sin errores". |
| `cp /archivo /archivo.bak` | Crea una copia de seguridad. | `cp /etc/samba/smb.conf /etc/samba/smb.conf.bak` | "Hago una copia del original antes de tocar nada para poder restaurarlo si la configuración falla". |
| `smbpasswd -a usuario` | Crea un usuario para Samba. | `smbpasswd -a juan` | "Añado un usuario a la base de datos de Samba. El usuario ya debe existir en el sistema Linux". |
| `pdbedit -L` | Lista los usuarios de Samba. | `pdbedit -L` | "Consulto la base de datos de Samba para ver qué usuarios tienen permisos de red". |
| `smbstatus` | Ve quién está conectado. | `smbstatus` | "Muestro en tiempo real qué máquinas y usuarios han montado mis carpetas compartidas". |

### Resolución de Actividad (Pág. 3 y 4 del PDF 1)

Para resolver esto, debes añadir estas líneas al final del archivo `/etc/samba/smb.conf`:

1. **Recurso [pub]:**
    
    ```
    [pub]
       path = /samba/publico
       browseable = yes
       guest ok = yes
       read only = yes
    ```
    
    - **Explicación:** `path` indica la ruta física, `browseable` permite que se vea en la red, `guest ok` permite entrar sin contraseña y `read only` cumple con "solo lectura".
2. **Recurso [privado]:**
    
    ```
    [privado]
       path = /samba/privado
       browseable = yes
       guest ok = no
       valid users = @gprivado
       read only = no
    ```
    
    - **Explicación:** `valid users = @gprivado` restringe el acceso solo a los miembros de ese grupo. `read only = no` permite escribir (lectura-escritura).
3. **Recurso [padron]:**
    
    ```
    [padron]
       path = /samba/padron
       invalid users = pica
       read only = yes
    ```
    
    - **Explicación:** `invalid users` bloquea específicamente a "pica" aunque estuviera en otros grupos.
4. **Habilitar usmbh:** Simplemente crea la sección `[homes]` o asegúrate de que el usuario `usmbh` tiene cuenta en Samba.

---

# 2. Netplan (Configuración de Red)

**Resumen:** Explica el nuevo sistema de Ubuntu para configurar IPs. Ya no se usa `/etc/network/interfaces`, sino archivos YAML en `/etc/netplan/`.

### Comandos y Explicación para el Examen

| Comando | ¿Para qué sirve? | Ejemplo | Explicación del procedimiento |
| --- | --- | --- | --- |
| `netplan try` | Prueba la configuración. | `sudo netplan try` | "Verifica que el archivo YAML no tenga errores de sintaxis y lo aplica temporalmente". |
| `netplan apply` | Aplica los cambios definitivos. | `sudo netplan apply` | "Hace que la nueva configuración de IP sea permanente en el sistema". |
| `ip address` | Muestra las IPs actuales. | `ip ad` | "Consulto el estado de las interfaces para ver si se ha asignado la IP correctamente". |
| `ip link set dev up/down` | Enciende o apaga la tarjeta. | `ip link set enp0s3 up` | "Activo o desactivo físicamente la interfaz de red desde la terminal". |
| `ip route` | Muestra la puerta de enlace. | `ip route` | "Reviso la tabla de rutas para saber por dónde sale el tráfico a Internet". |

---

# 3. NFS (Network File System)

**Resumen:** Es el sistema nativo de Linux para compartir archivos. Es más rápido que Samba entre máquinas Linux. Se basa en "exportar" carpetas desde un servidor.

### Comandos y Explicación para el Examen

| Comando | ¿Para qué sirve? | Ejemplo | Explicación del procedimiento |
| --- | --- | --- | --- |
| `apt install nfs-kernel-server` | Instala el servidor NFS. | `sudo apt install nfs-kernel-server` | "Instalo los servicios necesarios para que mi Linux pueda exportar directorios". |
| `ufw allow from IP to any port nfs` | Abre el cortafuegos. | `ufw allow from 192.168.1.0/24 to any port nfs` | "Permito que las máquinas de mi red local atraviesen el firewall para usar NFS". |
| `exportfs -ra` | Recarga las comparticiones. | `sudo exportfs -ra` | "Fuerzo al sistema a leer de nuevo el archivo `/etc/exports` sin reiniciar el servidor". |
| `showmount -e [IP]` | Mira qué comparte un servidor. | `showmount -e 192.168.1.10` | "Desde el cliente, pregunto al servidor qué carpetas tiene disponibles para montar". |
| `mount -t nfs IP:/ruta /punto` | Monta la carpeta remota. | `mount -t nfs 10.0.0.1:/pub /mnt` | "Enlazo la carpeta del servidor en mi propio sistema de archivos local". |

### Resolución de Actividades (Pág. 8 del PDF 3)

1. **Permisos r, w, x:** `r` (leer archivos/listar carpeta), `w` (modificar archivos/crear en carpeta), `x` (entrar en la carpeta o ejecutar programas).
2. **Opciones `(rw,async,no_subtree_check)`:**  (todos), `rw` (lectura/escritura), `async` (mejor rendimiento, no espera a confirmar escritura), `no_subtree_check` (evita errores si se mueven archivos).
3. **Exportación:** Añadir en `/etc/exports`: `/exportaciones *(rw,sync,no_root_squash)`.
    - *Nota:* Para que todos escriban, hay que dar permisos 777 a la carpeta: `chmod 777 /exportaciones`.
4. **Montaje automático:** Editar `/etc/fstab` y añadir: `192.168.X.X:/exportaciones /mnt/enmv nfs defaults 0 0`.
5. **Root Squashing (Puntos 5 y 6):**
    - Por defecto, NFS convierte al `root` del cliente en un usuario sin privilegios (`nobody`) en el servidor por seguridad. Esto es el **Root Squashing**.
    - Si usamos `no_root_squash`, el `root` del cliente tendrá poder total en el servidor.

---

# 4. Samba en Ubuntu Desktop (Interfaz Gráfica)

**Resumen:** Muestra cómo compartir carpetas haciendo clic derecho en el escritorio de Ubuntu.

### Conceptos clave para explicar:

- **Instalación automática:** Al intentar compartir una carpeta por primera vez por GUI, Ubuntu detecta que no tienes Samba e intenta instalarlo por ti.
- **Red Interna:** Para que dos máquinas virtuales se vean, en VirtualBox hay que poner las tarjetas en modo "Red Interna".
- **smbclient:** Es la herramienta de terminal para acceder a un servidor.
    - Ejemplo: `smbclient -L //192.168.1.100` (Para listar).
    - Ejemplo: `smbclient //192.168.1.100/Compartida -U usuario` (Para entrar).

### Resolución de Actividades (Pág. 3 y 4 del PDF 4)

- **Punto 11:** En el cliente (`smb2`) no hace falta el servidor Samba completo, solo las utilidades de cliente (`smbclient` o `cifs-utils`).
- **Punto 12:** Para permitir usuarios identificados, hay que quitar el "Acceso invitado" en las propiedades de la carpeta y crear el usuario con `sudo smbpasswd -a nombre`.

---

### 💡 Consejos para el examen (Explicación a mano):

1. **Sintaxis YAML (Netplan):** Di que "la indentación (espacios) es crítica; si pones un espacio de más, la red no funcionará".
2. **Permisos:** Siempre que compartas algo para escribir (`rw`), recuerda decir: "Aparte de configurar el servicio (Samba/NFS), debo dar permisos en el sistema de archivos Linux con `chmod`".
3. **Seguridad:** Si te preguntan por `no_root_squash` en NFS, di que "es un riesgo de seguridad porque permite que cualquiera con root en su PC borre todo en el servidor".