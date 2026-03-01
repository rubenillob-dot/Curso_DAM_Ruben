# 1. Conceptos Previos: Tipos y Permisos

Antes de gestionar las cuentas, el documento define qué opciones existen:

*   **Tipos de Cuentas:**
    *   **Cuenta Local:** Se guarda solo en el ordenador. Sirve para ese equipo en concreto.
    *   **Cuenta de Microsoft:** Se guarda en la nube (correo + contraseña). Permite sincronizar configuración entre dispositivos y acceder a la Microsoft Store.
*   **Niveles de Acceso (Privilegios):**
    *   **Usuario Estándar:** Puede usar software y cambiar configuraciones simples. No puede afectar a otros usuarios.
    *   **Administrador:** Control total del equipo. Puede cambiar todo (a veces requiere confirmación).
    *   **Usuario Inicial:** Es el creado al instalar Windows; pertenece al grupo de Administradores.

## 2. Pasos para la Gestión de Cuentas

El documento explica que no hay una única forma de gestionar los usuarios, sino **4 vías de acceso** diferentes. Puedes elegir la que te resulte más cómoda:

### Vía A: Desde "Configuración" (La opción moderna)
Es la interfaz principal de Windows 10/11.
1. Abre el menú de **Configuración**.
2. Selecciona la opción **Cuentas**.
3. Desde aquí puedes gestionar "Tu información", "Correo y cuentas", "Opciones de inicio de sesión", etc.

### Vía B: Desde el "Panel de Control" (La opción clásica)
Interfaz tradicional de Windows.
1. Abre el **Panel de control**.
2. Busca y selecciona **Cuentas de usuario**.
3. Desde aquí puedes "Cambiar el tipo de cuenta", "Quitar cuentas de usuario" o "Administrar otra cuenta".

### Vía C: Ejecutando un comando directo
Para usuarios avanzados que quieren una ventana rápida de gestión.
1. Presiona la tecla `Windows + R`
2. Escribe el comando: `netplwiz`
3. Se abrirá una ventana emergente donde puedes agregar, quitar o ver propiedades de los usuarios y gestionar el inicio de sesión automático.

### Vía D: Desde "Administración de equipos"
*Nota: Esta opción suele estar disponible completamente solo en versiones Windows Pro, no en Home.*
1. Abre la herramienta **Administración de equipos**.
2. En el menú lateral izquierdo, despliega **Herramientas del sistema**.
3. Busca la carpeta **Usuarios y grupos locales**.
    *   **Dentro de Usuarios:** Ves la lista completa y puedes crear nuevos.
    *   **Dentro de Grupos:** Puedes asignar usuarios a grupos (ej. añadir a alguien al grupo Administradores).

---

## Administración de equipos.
**Paso Previo: Abrir la Herramienta de Gestión**
Para realizar todas las actividades, necesitamos acceder a la consola de gestión de usuarios locales.
1. Presiona la tecla `Windows + R`.
2. Escribe el comando: `compmgmt.msc` y pulsa Enter.
    *   *Explicación:* Este comando abre la consola de "Administración de equipos". Es una "caja de herramientas" que centraliza la gestión de discos, eventos y, lo que nos interesa, **Usuarios y grupos locales**.
3. En el panel izquierdo, despliega **Herramientas del sistema > Usuarios y grupos locales**.

### Solución ACTIVIDAD 1: Comprobación de Grupos
**Objetivo:** Verificar quién está en los grupos "Administradores" e "Invitados" y su estado.
1. En la consola, haz clic en la carpeta **Grupos**.
2. Haz doble clic en **Administradores**.
    *   *Lo que verás:* Aquí aparecerá el usuario "Administrador" (el integrado) y tu usuario personal con el que instalaste Windows.
3. Haz doble clic en **Invitados**.
    *   *Lo que verás:* Normalmente contiene al usuario "Invitado".
4. Ahora ve a la carpeta **Usuarios** (panel izquierdo).
5. Observa los iconos de "Administrador" e "Invitado".
    *   **Respuesta a la pregunta 2:** Probablemente veas una flecha negra pequeña apuntando hacia abajo en el icono de "Administrador" y en el de "Invitado".
    *   **Conclusión: NO, no están habilitadas.** Por defecto, Windows deshabilita la cuenta "Administrador" (por seguridad) y la de "Invitado".

### Solución ACTIVIDAD 2: Creación de Usuarios y Grupos

**Objetivo 1: Habilitar la cuenta Administrador**
1. En la carpeta **Usuarios**, haz clic derecho sobre **Administrador > Propiedades**.
2. Desmarca la casilla que dice **"La cuenta está deshabilitada"**.
3. Acepta. (Ahora el "super-usuario" está activo).

**Objetivo 2: Crear los Grupos (A, B y C)**
1. Ve a la carpeta **Grupos**.
2. Clic derecho en un espacio blanco > **Grupo nuevo...**
3. Nombre de grupo: **GrupoA**. Clic en **Crear**.
4. Repite para **GrupoB** y **GrupoC**.

**Objetivo 3: Crear Usuarios y asignarlos (Según la tabla)**
Para cada usuario (Antonio, Andrés, Benito, etc.), haremos lo siguiente:
1. Ve a la carpeta **Usuarios**.
2. Clic derecho > **Usuario nuevo...**
3. Escribe el nombre (ej: Antonio). Desmarca "El usuario debe cambiar la contraseña..." (para facilitar el ejercicio) y pulsa **Crear**.
4. Una vez creados los 6 usuarios, asígnalos a los grupos. La forma más rápida es ir a **Grupos**:
    *   Doble clic en **GrupoA** > botón **Agregar**.
    *   Escribe "Antonio; Andrés" (separados por punto y coma) > *Comprobar nombres* > Aceptar.
    *   Doble clic en **GrupoB** > Agregar > "Benito; Beatriz".
    *   Doble clic en **GrupoC** > Agregar > "Carlos; Carmen".

### Solución ACTIVIDAD 3: Permisos de Carpetas (NTFS)
*Nota: Crea tres carpetas en tu disco C: llamadas CarpetaA, CarpetaB y CarpetaC para probar esto.*
Aquí aplicaremos la teoría de la página 3 (Lectura, Modificar, Control Total).

**Importante:** Para cumplir la condición "El resto de usuarios no podrán entrar", debemos **romper la herencia**. Por defecto, las carpetas heredan permisos del disco C: que permiten a "Usuarios" leer todo.

**1. Configurar CarpetaA**
*Condición: Solo GrupoA modifica. Admins control total. Nadie más entra.*
1. Clic derecho en CarpetaA > **Propiedades** > pestaña **Seguridad**.
2. Botón **Opciones avanzadas**.
3. Botón **Deshabilitar herencia** > Selecciona "Convertir los permisos heredados en permisos explícitos".
4. **Limpieza:** Selecciona el grupo "Usuarios" (Users) y dale a **Quitar**. (Esto impide que entre "el resto del sistema").
5. **Agregar GrupoA:** Botón Agregar > Seleccionar entidad de seguridad > Escribe "GrupoA".
    *   En permisos básicos, marca **Modificar** (esto marca automáticamente Lectura y Escritura). Acepta.
6. Asegúrate de que "Administradores" sigue en la lista con "Control total".

**2. Configurar CarpetaB**
*Condición: Solo GrupoB modifica. Admins control total. Nadie más entra.*
1. Repite los pasos de la CarpetaA (Deshabilitar herencia y quitar "Usuarios").
2. Agrega **GrupoB** y marca la casilla **Modificar**.
3. Mantén a "Administradores" con Control Total.

**3. Configurar CarpetaC**
*Condición: Todos ven (leen). GrupoC modifica. Admins control total.*
1. Clic derecho CarpetaC > **Propiedades** > **Seguridad**.
2. Aquí **NO** quitamos al grupo "Usuarios", porque el ejercicio dice "Todos los usuarios del sistema podrán entrar y ver".
3. Verifica que el grupo **Usuarios** tiene marcado **Lectura y ejecución, Mostrar contenido y Lectura** (columna Permitir).
4. Botón **Editar** > **Agregar** > Escribe "GrupoC".
5. Selecciona "GrupoC" en la lista y marca la casilla **Modificar** en la columna *Permitir*.
6. Acepta.

### Solución ACTIVIDAD 4: Denegar Acceso (Permiso Restrictivo)
**Objetivo:** Impedir que Andrés entre a la CarpetaC (aunque pertenezca a un grupo que sí tiene permiso).
1. Clic derecho en CarpetaC > **Propiedades** > pestaña **Seguridad**.
2. Botón **Editar**.
3. Botón **Agregar** > Escribe "Andrés" > Aceptar.
4. Selecciona al usuario **Andrés** en la lista de arriba.
5. En la lista de abajo (Permisos), busca la columna **DENEGAR**.
6. Marca la casilla **Control total** (o al menos "Lectura" y "Listar") en la columna **Denegar**.
7. Acepta. Te saldrá una advertencia de Windows diciendo que "Denegar tiene preferencia sobre Permitir". Dile que **Sí**.

*Explicación técnica:*
Aunque "Andrés" esté en el "GrupoA" (que podría tener acceso) o en el grupo "Usuarios" (que tiene lectura), en el sistema de archivos NTFS, un permiso **Denegar explícito** siempre gana a cualquier permiso de "Permitir". Andrés será rebotado al intentar abrir la carpeta.

---

## Directivas de Grupo y Seguridad Local.

### 1. ¿Qué son las Directivas de Grupo?
Son el mecanismo de Windows que permite a los administradores **configurar, controlar y restringir** el comportamiento de usuarios y equipos de forma centralizada, evitando tener que configurar cada PC uno por uno.

*   **Tipos:**
    *   **Locales:** Afectan solo al equipo donde se configuran (útil para PC sueltos).
    *   **De Dominio:** Se gestionan desde un servidor (Active Directory) y afectan a toda una red de usuarios/equipos.
*   **Estados de una directiva:**
    *   **No configurada:** Usa el valor por defecto de Windows.
    *   **Habilitada:** Activa la regla.
    *   **Deshabilitada:** Impide que la regla funcione.

### 2. Herramientas y Comandos Clave
Para gestionar estas directivas, el PDF destaca los siguientes comandos (ejecutar con `Windows + R`):

*   `gpedit.msc`: Abre el editor de **Directivas de Grupo Local** (General).
*   `SecPol.msc`: Abre directamente las **Directivas de Seguridad Local** (Contraseñas y bloqueos).
*   `gpupdate`: Fuerza al sistema a **actualizar** las directivas inmediatamente sin reiniciar.

### 3. Ejemplo Práctico: Restringir el sistema (CMD)
El documento pone como ejemplo cómo prohibir el uso de la consola de comandos.
1. Ejecuta `gpedit.msc`.
2. Navega a: Configuración de usuario > Plantillas Administrativas > Sistema.
3. Busca la directiva: **"Impedir el acceso al símbolo del sistema"**.
4. Haz doble clic, selecciona **Habilitada** y Aceptar.

### 4. Directivas de Seguridad (Cuentas y Contraseñas)
Estas configuraciones son críticas para proteger el acceso. Se encuentran en `SecPol.msc` (o dentro de gpedit en *Configuración del equipo > Configuración de Windows > Configuración de seguridad*).

**A. Directivas de Contraseña**
Definen cómo deben ser las claves de los usuarios:
*   **Exigir historial de contraseñas:** Impide repetir las últimas "X" contraseñas usadas.
*   **Requerimientos de complejidad:** Obliga a usar mayúsculas, minúsculas, números y símbolos.
*   **Longitud mínima:** Cantidad mínima de caracteres (0 significa que se permite en blanco).
*   **Vigencia máxima:** Días antes de que la contraseña caduque y el sistema obligue a cambiarla.
*   **Vigencia mínima:** Tiempo que debe pasar antes de que el usuario pueda volver a cambiar su contraseña.

**B. Directivas de Bloqueo de Cuenta**
Protegen contra ataques de fuerza bruta:
*   **Umbral de bloqueo:** Número de intentos fallidos permitidos antes de bloquear la cuenta (ej. 3 intentos).
*   **Duración del bloqueo:** Cuántos minutos la cuenta permanecerá inaccesible tras bloquearse. (Si es "0", solo un administrador puede desbloquearla).
*   **Restablecer bloqueo después de:** Cuánto tiempo debe pasar sin fallos para que el contador de intentos vuelva a cero.

---

## PARTE 1: Resumen Teórico - EFS (Encrypting File System)
El documento explica cómo usar **EFS**, una herramienta nativa de Windows (versiones Pro/Enterprise) para proteger archivos mediante cifrado.

### 1. ¿Qué es EFS?
Es un sistema que cifra archivos y carpetas para que **solo el usuario que los creó** (o quien tenga el certificado digital) pueda leerlos.
*   **Diferencia con NTFS:** Los permisos NTFS (Lectura/Escritura) dicen "quién puede entrar". EFS dice "quién puede entender los datos". Aunque un intruso tenga permiso para copiar el archivo, si no tiene el certificado, verá basura o recibirá "Acceso denegado".

### 2. Características Clave
*   **Transparente:** El dueño no pone contraseña cada vez; Windows usa su certificado invisiblemente.
*   **Específico:** Se pueden cifrar archivos sueltos o carpetas enteras.
*   **Requisito:** Solo funciona en discos formateados como **NTFS**.
*   **Seguridad:** Si pierdes el certificado (y no tienes copia), pierdes los datos para siempre.

### 3. Cómo se activa
1. Clic derecho en el archivo/carpeta > **Propiedades**.
2. Botón **Avanzadas** (en la pestaña General).
3. Marcar la casilla: **"Cifrar contenido para proteger datos"**.

---

## PARTE 2: Solución de la ACTIVIDAD (Página 4)

**Paso 1: Preparación del entorno**
1. Entra con tu usuario administrador.
2. En el disco local (C: o E:), crea una carpeta llamada Cifrada.
3. Clic derecho en Cifrada > **Propiedades > Seguridad > Editar**.
4. Asegúrate de que el grupo "Usuarios" tenga marcada la casilla **Modificar**. (Esto es vital para probar que, aunque tengan permiso, no podrán leer).
5. Entra en la carpeta y crea un archivo de texto (Documento.txt) y escribe algo dentro.

**Paso 2: Cifrado y Certificados**
1. Clic derecho en Cifrada > **Propiedades > Avanzadas**.
2. Marca **Cifrar contenido para proteger datos** > Aceptar > Aceptar.
3. Windows preguntará: "¿Desea aplicar el cambio solo a esta carpeta o a todas las subcarpetas?". Elige **"Aplicar cambios a esta carpeta y a todas las subcarpetas y archivos"**.
4. **Exportación:** Verás una notificación en la barra de tareas pidiendo hacer copia de seguridad. Haz clic, sigue el asistente, ponle una contraseña y guarda el archivo `.pfx` (el certificado) en un pendrive o en una carpeta fuera de la encriptada.
5. **Verificación:** Abre el comando `certmgr.msc`. Ve a **Personal > Certificados**. Ahí verás un certificado donde en "Propósitos" dice *Sistema de archivos de cifrado*.

**Paso 3: Prueba de acceso (El "Hackeo")**
1. Cierra sesión e inicia con **otro usuario** distinto.
2. Ve a la carpeta Cifrada.
3. Intenta abrir Documento.txt.
    *   **Resultado esperado:** Recibirás un mensaje de **"Acceso Denied"** o "No tiene permisos".
    *   **Respuesta a la pregunta:** *¿Es posible acceder a la carpeta?* SÍ, puedes entrar en la carpeta (porque NTFS lo permite). *¿Al contenido del fichero?* NO, está cifrado.
    *   **Respuesta a la pregunta:** *¿Puedes crear nuevos documentos?* SÍ. Como tienes permiso NTFS de "Modificar", puedes crear un archivo nuevo (ej: Hola.txt). **Ojo:** Dependiendo de la configuración, ese nuevo archivo podría cifrarse con TU certificado (y el dueño original no podría leer el tuyo) o quedarse sin cifrar.

**Paso 4: Simulación de Desastre (Borrar la llave)**
1. Vuelve al usuario original (el dueño).
2. Ejecuta `certmgr.msc`.
3. Ve a **Personal > Certificados**.
4. Borra el certificado de EFS.
5. Intenta abrir tu propio Documento.txt.
    *   **Resultado:** **No podrás abrirlo.** Aunque eres el dueño, has tirado la "llave" al río.

**Paso 5: Recuperación**
1. Busca el archivo `.pfx` que exportaste en el paso 2.
2. Haz doble clic sobre él.
3. Sigue el asistente (te pedirá la contraseña que pusiste al exportar).
4. Asegúrate de marcar "Marcar esta clave como exportable" (buena práctica).
5. Finaliza. Ahora intenta abrir Documento.txt. ¡Funcionará de nuevo!

**Paso 6: Convivencia**
Comprueba si puedes crear otra carpeta y que otro usuario cifre la suya.
*   **Resultado:** Sí. EFS es multi-usuario. "Usuario A" cifra sus cosas con su certificado y "Usuario B" cifra las suyas con el suyo. Ninguno puede leer lo del otro, pero ambos conviven en el mismo disco duro.

---

## PARTE 3: Explicación de Comandos Nuevos

**Comando: `certmgr.msc`**
*   **Significado:** Certificate Manager (Administrador de Certificados).
*   **¿Para qué sirve?** Es la consola que gestiona tu **identidad digital** en el equipo. Windows no guarda las claves de cifrado en archivos de texto, las guarda en un almacén seguro.
*   **Uso en este ejercicio:** Aquí es donde se guarda la "llave maestra" de EFS. Si borras el certificado de aquí, pierdes el acceso a todo lo que hayas cifrado.

---

## Cifrado de Disco Completo
Solución de la Actividad BitLocker y Solución de la Actividad VeraCrypt.

### PARTE 1: Resumen Teórico - Herramientas de Cifrado

**1. BitLocker (Nativo de Windows)**
*   **¿Qué es?:** Herramienta incluida en versiones **Pro y Enterprise** de Windows. Cifra toda la partición.
*   **Requisito de Hardware (TPM):** Por defecto, BitLocker pide un chip **TPM** (Módulo de Plataforma Segura) en la placa base. 
*   **BitLocker To Go:** Es la versión para cifrar pendrives (USB) y discos duros externos.
*   **Recuperación:** Es vital guardar la "Clave de recuperación" en un lugar seguro.

**2. VeraCrypt (Multiplataforma)**
*   **Origen:** Nace cuando TrueCrypt fue abandonado. Es de código abierto (Open Source).
*   **Ventaja principal:** Funciona en **Windows, Linux y MacOS**.
*   **Concepto de "Contenedor":** VeraCrypt permite crear un archivo (ej: mis_secretos.hc) que, al abrirse con contraseña, se monta como si fuera un disco duro real (Letra Z:, por ejemplo).

### PARTE 2: Solución ACTIVIDAD BITLOCKER (Paso a Paso)

**Objetivo:** Cifrar la unidad C: (Sistema).
*Problema común:* Al intentarlo, Windows suele dar error diciendo: *"Este dispositivo no puede usar un Módulo de plataforma segura (TPM)"*.

**Solución al error del TPM (El "Truco" del PDF):**
Para usar BitLocker sin chip TPM, debemos autorizar el uso de contraseñas/USB mediante directivas.
1. Presiona `Windows + R`, escribe `gpedit.msc` y pulsa Enter.
2. Navega por la izquierda: Configuración del equipo > Plantillas administrativas > Componentes de Windows > Cifrado de unidad BitLocker > Unidades del sistema operativo.
3. A la derecha, busca la directiva: **"Requerir autenticación adicional al iniciar"**.
4. Doble clic sobre ella y marca **Habilitada**.
5. Asegúrate de que abajo esté marcada la casilla: **"Permitir BitLocker sin un TPM compatible"**.
6. Acepta y cierra.

**Procedimiento de Cifrado:**
1. Ve al **Panel de Control > Sistema y seguridad > Cifrado de unidad BitLocker**.
2. En la unidad C:, pulsa **Activar BitLocker**.
3. Ahora no dará error. Te pedirá cómo quieres desbloquear la unidad. Elige **"Escribir una contraseña"**.
4. **Clave de recuperación:** Elige "Guardar en un archivo" (y guárdalo en un USB distinto) o "Imprimir".
5. Sigue el asistente y elige reiniciar. Verás una pantalla azul pidiendo la contraseña ANTES de que cargue Windows.

### PARTE 3: Solución ACTIVIDAD VERACRYPT (Paso a Paso)

**Objetivo:** Crear un "Contenedor seguro" en la partición de datos.
1. **Instalación:** Descarga e instala VeraCrypt.
2. Abre VeraCrypt y pulsa el botón **"Crear volumen"** (Create Volume).
3. **Tipo de volumen:** Elige **"Crear un contenedor de archivos cifrado"**.
4. **Tipo:** Volumen VeraCrypt común (Standard).
5. **Ubicación:** Dale al botón "Seleccionar Archivo". Navega a tu disco y ponle un nombre (ej: `CajaFuerte.hc`).
6. **Opciones de cifrado:** Deja las opciones por defecto (AES y SHA-512).
7. **Tamaño:** Decide cuánto espacio tendrá (ej. 500 MB).
8. **Contraseña:** Escribe una contraseña robusta.
9. **Formateo:** Mueve el ratón aleatoriamente dentro de la ventana para generar entropía y pulsa **Formatear**.

**Montar la unidad (Usarla):**
*   En la pantalla principal de VeraCrypt, selecciona una letra libre (ej: Z:).
*   Pulsa "Seleccionar Archivo" y busca tu fichero `CajaFuerte.hc`.
*   Pulsa el botón **Montar** (Mount).
*   Escribe la contraseña.
*   *Resultado:* Ahora en "Este Equipo" verás un nuevo disco Z:. Todo lo que guardes ahí se cifrará. Al terminar, pulsa **Desmontar**.

---

## Imágenes del sistema y Clonación.

### 1. Conceptos Clave: Imagen vs. Clonación

**A. Imágenes del Sistema (La "Foto" guardada)**
*   **¿Qué es?** Se trata de empaquetar todo el contenido de un disco o partición en **un solo archivo comprimido**.
*   **¿Para qué sirve?** Para restaurar el equipo a un estado anterior ("limpio") si entra un virus.
*   **Tipos:**
    *   **De Partición:** Guardas solo una parte del disco.
    *   **De Disco Completo:** Guardas TODO el disco físico (necesitas un disco externo).
*   **Restauración:** Sobrescribe y borra todo lo que haya en el destino.

**B. Clonación (La "Copia exacta")**
*   **¿Qué es?** Es un volcado de información "bit a bit". Se copia el contenido directamente de un disco a otro.
*   **¿Para qué sirve?** Para cambiar un disco duro viejo por uno nuevo (SSD).
*   **Regla de oro:** El disco de destino debe ser **igual o más grande** que el de origen.

### 2. Herramientas Mencionadas
*   **Clonezilla:** Gratuita (Open Source). Funciona con un **Live CD/USB** arrancando desde el pendrive.
*   **Comerciales:** Norton Ghost y Acronis (de pago).

### 3. Análisis Técnico: El comando dd (Linux)
Ejemplo: `sudo dd if=/dev/sda of=/dev/sdb bs=1M`
1. `sudo`: Da permisos de administrador.
2. `dd`: Programa Data Duplicator.
3. `if=/dev/sda`: Input File (Origen). `/dev/sda` es el primer disco.
4. `of=/dev/sdb`: Output File (Destino). `/dev/sdb` es el segundo disco.
5. `bs=1M`: Block Size (Copia los datos en paquetes de 1 Megabyte).

---

## Guía Definitiva y Estructurada de Clonezilla

### FASE 1: Configuración Inicial
1. **Arrancar Clonezilla (Boot):** Opción *Clonezilla Live (VGA 800x600 & To RAM)* (Carga el programa en la memoria RAM).
2. **Idioma:** *es_ES.UTF-8 Spanish*.
3. **Teclado:** *Don't touch keymap* (Mantiene la distribución estándar).
4. **Iniciar:** *Start_Clonezilla*.

### FASE 2: La Gran Decisión
*   **Opción A: device-image (Imagen de disco):** Creas un archivo de copia de seguridad.
*   **Opción B: device-device (Clonación directa):** Copias de un disco duro directamente a otro.

**CAMINO A: Crear una Imagen de Respaldo (device-image)**
1. **¿Dónde guardar la imagen?:** `local_dev` (Dispositivo local / USB).
2. **Comprobación de errores:** `no-fsck` (Salta el chequeo de errores para ahorrar tiempo).
3. **Selección del Repositorio:** Confirma que el montaje es correcto.
4. **Tipo de copia:** `savedisk` (Copia TODO el disco duro).
5. **Compresión:** `z9p` (Compresión moderna y rápida usando todos los núcleos).
6. **Finalizar:** Se crearán archivos `.zst`.

**CAMINO B: Clonar de Disco a Disco (device-device)**
1. **Modo de trabajo:** `disk_to_local_disk`.
2. **Seleccionar ORIGEN (Source):** Elige el disco con tus datos actuales. ⚠️ *¡Cuidado de no equivocarte!*
3. **Seleccionar DESTINO (Target):** Elige el disco vacío/nuevo. ⚠️ *Todo se borrará.*
4. **Comprobación del sistema:** `sfsck` (Saltar).
5. **Ajuste de tamaño:**
    *   `k0`: Hace una copia exacta 1:1.
    *   `k1`: Crea tabla proporcionalmente (Estira las particiones si el disco nuevo es más grande).
6. **Proceso final:** Verás una barra de progreso roja y azul.

### Resumen de archivos generados (Solo Camino A)
*   `clonezilla-img`: Archivo "bandera".
*   `info-*.txt`: Detalles del hardware.
*   `sdb1...img.zst`: **El archivo más importante**. Contiene tus datos comprimidos.