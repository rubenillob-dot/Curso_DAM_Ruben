# Practica Servidor FTP



### Fase 0: Configuración de Red (En ambas máquinas)

Antes de empezar con el servidor, ambas máquinas deben poder "hablar" entre sí. Como están en **Red Interna**, no tendrán internet y no habrá un servidor que les dé IPs automáticamente, por lo que hay que ponerlas a mano.

1. **En VirtualBox (con las máquinas apagadas o encendidas):**
    - Ve a Configuración -> Red.
    - Conectado a: **Red Interna**.
    - Nombre: `intnet` (asegúrate de que sea el mismo en ambas).
2. **Dentro de Windows (en ambas máquinas):**
    - Ve a Panel de Control -> Centro de redes -> Cambiar configuración del adaptador.
    - Clic derecho en el adaptador -> Propiedades -> Protocolo de Internet versión 4 (TCP/IPv4).
    - **MV1 (Servidor):** IP `192.168.1.1`, Máscara `255.255.255.0`.
    
    ![imagen.png](Practica%20Servidor%20FTP/imagen.png)
    
    - **MV2 (Cliente):** IP `192.168.1.2`, Máscara `255.255.255.0`.
    
    ![imagen.png](Practica%20Servidor%20FTP/imagen%201.png)
    
    - **Prueba:** Desde la MV2, abre el CMD y escribe `ping 192.168.1.1`. Si responde, hay conexión.
    
    ![imagen.png](Practica%20Servidor%20FTP/imagen%202.png)
    

---

### Parte 1: Configuración del servidor FTP (MV1 - Servidor)

### 1. Instalar el Rol de IIS y FTP

1. Pulsa la tecla Windows y escribe "Activar o desactivar las características de Windows".
2. Busca **Internet Information Services (IIS)**.

![imagen.png](Practica%20Servidor%20FTP/imagen%203.png)

1. Despliega y marca:
    - **Servicio FTP** (y dentro: **Servicio FTP** y **Extensibilidad de FTP**).
    - **Herramientas de administración web** (para tener la consola de gestión).
    
    ![imagen.png](Practica%20Servidor%20FTP/imagen%204.png)
    
2. Dale a Aceptar y espera a que instale.

### 2. Crear la carpeta y usuario

1. Crea una carpeta en `C:\\` llamada `FTP_DAM`.

![imagen.png](Practica%20Servidor%20FTP/imagen%205.png)

1. **Importante:** Crea un usuario local en Windows (Panel de Control -> Cuentas de usuario) llamado, por ejemplo, "usuarioftp" con contraseña. Lo usaremos para loguearnos.

![imagen.png](Practica%20Servidor%20FTP/imagen%206.png)

### 3. Configurar el Sitio FTP en IIS

1. Busca en el inicio **Administrador de Internet Information Services (IIS)**.
2. En el panel izquierdo, clic derecho en **Sitios** -> **Agregar sitio FTP**.

![imagen.png](Practica%20Servidor%20FTP/imagen%207.png)

1. **Información del sitio:** Nombre: `ServidorFTP_DAM` / Ruta de acceso: `C:\\FTP_DAM`. Siguiente.

![imagen.png](Practica%20Servidor%20FTP/imagen%208.png)

1. **Enlaces y SSL:**
    - IP: Selecciona `192.168.1.1`.
    - Puerto: `21`.
    - SSL: Selecciona **Sin SSL** (para evitar problemas de certificados en esta práctica). Siguiente.
    
    ![imagen.png](Practica%20Servidor%20FTP/imagen%209.png)
    
2. **Autenticación y Autorización:**
    - Autenticación: **Básica**.
    - Permitir el acceso a: **Usuarios específicos** (escribe el nombre del usuario que creaste antes).
    - Permisos: **Leer** y **Escribir**.
    - Finalizar.
    
    ![imagen.png](Practica%20Servidor%20FTP/imagen%2010.png)
    

### 4. Configurar el Firewall

1. Busca "Firewall de Windows Defender con seguridad avanzada".
2. En **Reglas de entrada**, busca las que digan "Servidor FTP" (Puerto 21) y asegúrate de que estén habilitadas (flecha verde). Si no están, crea una "Nueva regla" para el puerto 21.

![imagen.png](Practica%20Servidor%20FTP/imagen%2011.png)

---

### Parte 2: Acceso desde el cliente (MV2 - Cliente)

### 1. Conexión mediante Línea de Comandos (CMD)

1. Abre el CMD.
2. Escribe: `ftp 192.168.1.1`.
3. Te pedirá el **Usuario**. Pon el que creaste en la MV1.
4. Te pedirá la **Contraseña** (no se verá mientras la escribes).

![imagen.png](Practica%20Servidor%20FTP/imagen%2012.png)

1. Una vez dentro (`ftp>`), prueba estos comandos:
    - `ls`: Listar archivos.
    - `get prueba.txt`: Para descargar el archivo que creaste.
    - `put archivo_cliente.txt`: Para subir un archivo (debes haber creado uno antes en la carpeta donde estés en el CMD del cliente).
    - `bye`: Para salir.
    
    ![imagen.png](Practica%20Servidor%20FTP/imagen%2013.png)
    

### 2. Conexión mediante FileZilla (Gráfico)

1. Descarga e instala **FileZilla Client** en la MV2.
2. Ábrelo y en la barra de arriba (Conexión rápida) pon:
    - **Servidor:** `192.168.1.1`
    - **Nombre de usuario:** (el tuyo)
    - **Contraseña:** (la tuya)
    - **Puerto:** `21`
3. Dale a **Conexión rápida**.
4. Verás a la izquierda tus archivos locales y a la derecha los del servidor. Prueba a arrastrar archivos de un lado a otro para verificar que la subida y descarga funcionan.

![imagen.png](Practica%20Servidor%20FTP/imagen%2014.png)

---
