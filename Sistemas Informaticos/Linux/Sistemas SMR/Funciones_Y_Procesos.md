
### **Unidad 2: Concepto de Sistema Operativo, Elementos y Estructura**

#### **1. Introducción y Conceptos Fundamentales**

*   **¿Qué es un Sistema Operativo (SO)?** Es un conjunto de programas, servicios y funciones que actúan como intermediario entre el usuario/aplicaciones y el hardware. Su propósito es gestionar y coordinar todos los recursos del sistema informático.

*   **Recursos Gestionados:** El SO controla todos los recursos físicos, como:
    *   El procesador (CPU).
    *   La memoria RAM.
    *   Los periféricos de entrada y salida (teclado, monitor, etc.).
    *   Los dispositivos de almacenamiento (discos duros).
    *   Los dispositivos de comunicación (tarjetas de red).

*   **Jerarquía del Sistema:** La interacción en un sistema informático sigue una estructura jerárquica:
    1.  **Hardware:** La base física.
    2.  **Sistema Operativo:** Gestiona el hardware.
    3.  **Aplicaciones:** Se ejecutan sobre el SO.
    4.  **Usuario:** Interactúa con las aplicaciones.
    La comunicación entre estos niveles se realiza a través de **interfaces**.

---

#### **2. Clasificación de los Sistemas Operativos**

Los sistemas operativos se pueden clasificar según diferentes criterios:

**A. Por Número de Usuarios:**
*   **Monousuario:** Solo un usuario puede utilizar los recursos del equipo a la vez.
*   **Multiusuario:** Varios usuarios pueden acceder y compartir los recursos del sistema simultáneamente. El modelo moderno se basa en una arquitectura **cliente-servidor**:
    *   **Servidor:** Un ordenador potente que ejecuta el SO de Red y gestiona los recursos compartidos.
    *   **Clientes:** Equipos que se conectan al servidor a través de una red para solicitar servicios y recursos.

**B. Por Número de Tareas:**
*   **Monotarea:** Solo puede ejecutar una tarea o programa a la vez (ej. MS-DOS).
*   **Multitarea:** Permite que el usuario ejecute varias aplicaciones simultáneamente. Los sistemas actuales utilizan una multitarea "simulada" donde el procesador cambia tan rápidamente entre tareas que parece que se ejecutan al mismo tiempo.

**C. Por Número de Procesadores:**
*   **Monoproceso:** Capaz de manejar un solo procesador. Común en equipos de sobremesa, portátiles y tablets.
*   **Multiproceso:** Capaz de gestionar y utilizar varios procesadores a la vez. Típico en servidores.
    *   **Simétrico (SMP):** Todos los procesadores son iguales y pueden ejecutar cualquier tarea.
    *   **Asimétrico (AMP):** Un procesador actúa como "maestro" y reparte las tareas entre los demás procesadores "esclavos".

**D. Por Hilos de Ejecución (Multihilo):**
*   Los sistemas operativos modernos son **Multihilo (Multithreading)**. Esto significa que un solo proceso (programa en ejecución) puede dividirse en múltiples **hilos** de ejecución que se ejecutan a la vez, compartiendo los recursos y la memoria del proceso principal.

---

#### **3. Funciones Principales del Sistema Operativo**

El SO realiza cuatro funciones de gestión clave a través de sus **servicios** (aplicaciones que se ejecutan en segundo plano).

##### **A. Gestión de Procesos**

*   **Concepto:** Un **proceso** es un programa que está en ejecución. Ocupa memoria, utiliza el procesador y accede a otros recursos del sistema.
*   **Estados de un Proceso:** Un proceso pasa por diferentes estados a lo largo de su ciclo de vida:
    *   **Nuevo:** Se está creando el proceso.
    *   **Preparado:** Listo para ser ejecutado, esperando al procesador.
    *   **Ejecución:** El procesador está ejecutando sus instrucciones.
    *   **Bloqueado:** Esperando a que ocurra un evento (ej. una operación de E/S).
    *   **Terminado:** El proceso ha finalizado su ejecución.

*   **GUÍA PRÁCTICA: Cómo ver los procesos**
    *   **En Windows:**
        *   **Gráfico:** Administrador de Tareas (`Ctrl + Shift + Esc` o `Ctrl + Alt + Del`).
        *   **Línea de comandos:**
            *   En CMD: `tasklist`
            *   En PowerShell: `get-process`
    *   **En Linux:**
        *   **Línea de comandos:**
            *   Interactivo: `top`
            *   Estático: `ps aux`

##### **B. Gestión de Memoria**

*   **Concepto:** El SO gestiona la memoria principal (RAM) para cargar los procesos. Utiliza la **multiprogramación** para tener varios procesos en memoria a la vez y aprovechar al máximo la CPU.
*   **Memoria Virtual:** Es una técnica que permite al SO usar espacio del disco duro como si fuera memoria RAM. Esto permite:
    *   Ejecutar procesos más grandes que la memoria física disponible.
    *   Liberar espacio en la RAM moviendo procesos inactivos o bloqueados al disco.

*   **GUÍA PRÁCTICA: Gestión de memoria virtual**
    *   **En Windows:**
        *   Utiliza un archivo oculto llamado **`c:\pagefile.sys`**.
        *   **Recomendación:** El tamaño suele ser de 1.5 a 3 veces la cantidad de RAM. Para mejor rendimiento, se puede ubicar en una partición o disco duro diferente.
        *   Se puede configurar manualmente en `Propiedades del sistema > Opciones avanzadas > Rendimiento > Configuración > Opciones avanzadas > Memoria virtual`.
    *   **En Linux:**
        *   Utiliza una partición dedicada llamada **`swap`**.
        *   **Recomendaciones de tamaño:**
            *   Si la RAM es **menor de 32 GiB**: el mismo tamaño que la RAM.
            *   Si la RAM es **mayor de 32 GiB**: 32 GiB de swap es suficiente.

##### **C. Gestión de Entrada/Salida (E/S)**

*   **Concepto:** El SO debe controlar todos los dispositivos periféricos, garantizando que no haya interferencias entre ellos y facilitando la incorporación de nuevo hardware.
*   **Interrupciones:** Una **interrupción** es una señal que un dispositivo de hardware o software envía al procesador para solicitar su atención de forma inmediata. Esto obliga al SO a tomar el control para gestionar el evento. Tipos:
    *   **De Hardware:** Teclado, un proceso que se desbloquea, botón de reinicio.
    *   **De Software:** Llamadas al sistema desde un programa.

##### **D. Gestión de Archivos**

*   **Concepto:** Un **archivo** es un conjunto de datos almacenados en un dispositivo de almacenamiento.
*   **Sistema de Archivos:** Es el conjunto de normas y procedimientos que utiliza el SO para organizar y gestionar los archivos y directorios en los discos (ej. **NTFS**, **FAT32** en Windows; **Ext4** en Linux).

---

#### **4. Modos de Explotación del Sistema**

Se refiere a la forma en que el usuario interactúa con el sistema operativo.

*   **Modo Comando o Modo Texto (CLI - Command Line Interface):**
    *   La comunicación se realiza a través de una consola de texto.
    *   El usuario introduce órdenes (comandos) que el sistema interpreta y ejecuta.
    *   Es muy utilizado en la administración de servidores por su eficiencia y bajo consumo de recursos.

*   **Modo Gráfico (GUI - Graphical User Interface):**
    *   La información y las acciones se manejan a través de elementos visuales como ventanas, iconos y menús, utilizando un ratón y un teclado.
    *   Es el modo de uso estándar en los sistemas operativos de escritorio modernos.