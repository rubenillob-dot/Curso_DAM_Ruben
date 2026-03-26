# Redes en dominio. Directivas de seguridad

Clase: Sistemas Informáticos
Estado: Completado
Tipo: Entrega
Fecha de Entrega: 26 de marzo de 2026
Fecha de Finalización: 26 de marzo de 2026

### Máquinas Virtuales Necesarias

Para realizar esta práctica necesitarás utilizar **2 máquinas virtuales en total**:

1. **Máquina Virtual 1 (Servidor):** Debe tener instalado **Windows Server** . 
Esta máquina actuará como el Controlador de Dominio (DC).
2. **Máquina Virtual 2 (Cliente):** Debe tener instalado **Windows 10 Pro**. 
Esta máquina actuará como el equipo de un usuario normal que se conectará a la red de la empresa.

### FASE 1: Configuración Inicial del Servidor

🖥️ **MÁQUINA A UTILIZAR: MÁQUINA VIRTUAL 1 (Servidor Windows Server)**

1. **Configurar la red:** Apaga la máquina virtual si está encendida y en la configuración de VirtualBox, pon el adaptador de red en modo **"Red interna"**.

![imagen.png](imagen.png)

1. **Configurar IP estática:** Enciende el servidor, ve a las conexiones de red y asigna la dirección **IP: 192.168.1.1**.

![imagen.png](imagen%201.png)

1. **Cambiar el nombre:** Cambia el nombre del equipo a **DC01** y reinicia si es necesario.

![imagen.png](imagen%202.png)

1. **Crear usuario local:** Ve a la administración de equipos y crea un nuevo usuario local llamado *tu_nombre* (usa tu nombre real).

![imagen.png](imagen%203.png)

### FASE 2: Promoción a Controlador de Dominio

🖥️ **MÁQUINA A UTILIZAR: MÁQUINA VIRTUAL 1 (Servidor Windows Server)**

1. **Instalar el Rol:** Abre el "Administrador del servidor". Ve al menú "Administrar" > "Agregar roles y características". Elige "Instalación basada en características o en roles".

    
    ![imagen.png](imagen%204.png)
    

![imagen.png](imagen%205.png)

1. **Seleccionar Servicios de Dominio:** Marca e instala los "Servicios de dominio de Active Directory" (AD DS).

![imagen.png](imagen%206.png)

![imagen.png](imagen%207.png)

1. **Promover el servidor:** Una vez terminada la instalación, haz clic en la bandera de notificaciones (el triángulo amarillo en la parte superior, como se ve en la segunda imagen) y selecciona "Promover este servidor a controlador de dominio".

![imagen.png](imagen%208.png)

1. **Configurar el bosque:** Elige la opción de **agregar un nuevo bosque** y pon como nombre de dominio raíz: **dam.local**. Completa el asistente y espera a que el servidor se reinicie.

![imagen.png](imagen%209.png)

### FASE 3: Unión del Equipo Cliente al Dominio

🖥️ **MÁQUINA A UTILIZAR: MÁQUINA VIRTUAL 2 (Cliente Windows 10 Pro)**

1. **Inicio de sesión:** Inicia sesión con una cuenta de usuario administrador local.
2. **Configurar la red:** Asegúrate en tu hipervisor VirtualBox/ de que el adaptador de red también está configurado en **"Red interna"**.

![imagen.png](imagen%2010.png)

1. **Configurar IP y DNS:** Entra en las propiedades de red de Windows 10. Asigna una dirección IP en la misma red que el servidor (por ejemplo, 192.168.1.10 o 192.168.1.2) y, **muy importante**, establece como **Servidor DNS principal la IP del servidor: 192.168.1.1**.

![imagen.png](imagen%2011.png)

1. **Prueba de conectividad:** Abre una consola (CMD) y haz un ping a la IP del servidor (`ping 192.168.1.1`) y al nombre del dominio (`ping dam.local`) para verificar que hay conexión.

![imagen.png](imagen%2012.png)

![imagen.png](imagen%2013.png)

1. **Unir al dominio:** Ve a la configuración del sistema, cambia el nombre del equipo/dominio, selecciona "Dominio" y escribe **DAM.LOCAL**. Te pedirá credenciales (usa el Administrador del dominio). Reinicia el equipo cliente.

![imagen.png](imagen%2014.png)

![imagen.png](imagen%2015.png)

![imagen.png](imagen%2016.png)

### FASE 4: Actividad de Directivas de Seguridad (GPOs)

Para esta última parte tendrás que ir alternando entre ambas máquinas para configurar y luego comprobar.

🖥️ **MÁQUINA A UTILIZAR: MÁQUINA VIRTUAL 2 (Cliente Windows 10 Pro)**

1. **Restricción local:** Entra con un usuario local (o abre `secpol.msc` / `gpedit.msc`). Edita las directivas locales de seguridad y **habilita** la opción "Prohibir el acceso al panel de control".

![imagen.png](imagen%2017.png)

🖥️ **MÁQUINA A UTILIZAR: MÁQUINA VIRTUAL 1 (Servidor Windows Server)**
3.  **Crear Unidad Organizativa:** Ve a "Herramientas" > "Usuarios y equipos de Active Directory". Haz clic derecho sobre el dominio `dam.local`, selecciona Nuevo > Unidad Organizativa y llámala **MI_UO**.

![imagen.png](imagen%2018.png)

![imagen.png](imagen%2019.png)

![imagen.png](imagen%2020.png)

4.  **Mover usuario:** En "Users" (o donde esté tu usuario *tu_nombre* creado al principio), búscalo, haz clic derecho sobre él, elige "Mover" y mándalo a **MI_UO**.

![imagen.png](imagen%2021.png)

![imagen.png](imagen%2022.png)

5.  **Crear y configurar GPO:** Ve a "Herramientas" > "Administración de directivas de grupo". Despliega tu bosque, ve a la carpeta de tu dominio, haz clic derecho sobre **MI_UO** y elige "Crear un GPO en este dominio y vincularlo aquí...".

![imagen.png](imagen%2023.png)

6.  **Editar la GPO:** Edita esa nueva GPO. Navega por el árbol hasta Configuración de usuario > Directivas > Plantillas administrativas > Panel de control.
7.  **Deshabilitar restricción:** Busca la directiva "Prohibir el acceso a Configuración del PC y Panel de control" y configúrala como **Deshabilitada** (para forzar que sí se pueda entrar y anular la restricción local).

![imagen.png](imagen%2024.png)

🖥️ **MÁQUINA A UTILIZAR: MÁQUINA VIRTUAL 2 (Cliente Windows 10 Pro)**
8.  **Comprobación final y justificación:** Inicia sesión con el usuario de dominio (*tu_nombre*). Intenta abrir el panel de control. Ahora deberías poder entrar.

![imagen.png](imagen%2025.png)

![imagen.png](imagen%2026.png)
