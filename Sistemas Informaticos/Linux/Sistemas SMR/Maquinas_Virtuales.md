

### **Unidad 3: Máquinas Virtuales**

---

### **Parte 1: Teoría y Conceptos Fundamentales**

#### **1. ¿Qué es la Virtualización?**

La virtualización es la creación, a través de software, de una **versión virtual** de un recurso tecnológico. Esto puede incluir un ordenador completo (hardware), un sistema operativo, un dispositivo de almacenamiento o una red.

*   **Impulsores de la tecnología:**
    *   El aumento de la **potencia de los ordenadores actuales**, que a menudo deja muchos recursos infrautilizados.
    *   El **soporte a nivel de hardware** integrado en los procesadores modernos desde 2005, como **Intel VT** y **AMD-V**.

#### **2. Tipos de Virtualización**

*   **Virtualización de Sistema Operativo (en Clientes):**
    *   Consiste en ejecutar uno o más sistemas operativos "invitados" (Guest) sobre un sistema operativo principal "anfitrión" (Host).
    *   Utiliza un software llamado **hipervisor de tipo 2**, que funciona como una aplicación más dentro del sistema anfitrión.

*   **Virtualización de Servidores:**
    *   El programa de virtualización, o **hipervisor de tipo 1**, se instala directamente sobre el hardware físico del servidor, sin necesidad de un sistema operativo anfitrión. Esto le da un mayor rendimiento y eficiencia.

*   **Virtualización de Almacenamiento:**
    *   Independiza la gestión lógica del almacenamiento de los discos físicos.
    *   Permite crear unidades lógicas (volúmenes) que pueden combinar el espacio de varios discos duros o particiones, siendo transparente para el usuario.
    *   Ejemplos: **LVM** (Logical Volume Manager) en Linux y **LDM** (Logical Disk Manager) en Windows.

*   **Virtualización de Aplicaciones:**
    *   Permite ejecutar aplicaciones de forma remota en un servidor, sin necesidad de instalarlas en el equipo local. El usuario se conecta a la aplicación a través de la red.

#### **3. Ventajas e Inconvenientes de la Virtualización**

*   **Ventajas:**
    *   **Ahorro de costes:** Reduce la necesidad de hardware físico, ahorrando en inversión, energía y espacio.
    *   **Entornos de prueba seguros:** Permite probar sistemas operativos o aplicaciones nuevas sin afectar al sistema principal.
    *   **Flexibilidad y rendimiento:** Facilita la prueba de programas en diferentes sistemas operativos para comprobar su rendimiento.
    *   **Recuperación ante desastres:** Las máquinas virtuales son ficheros, lo que facilita enormemente las copias de seguridad y la recuperación.
    *   **Compatibilidad:** Permite usar sistemas operativos o aplicaciones antiguas que no son compatibles con el hardware moderno.

*   **Inconvenientes:**
    *   **Inversión inicial:** Requiere **equipos anfitriones potentes** (con suficiente RAM, CPU y almacenamiento) para soportar la carga de varias máquinas virtuales.
    *   **Planificación y Mantenimiento:** Necesita una buena planificación y gestión para funcionar de manera eficiente.
    *   **Formación:** El personal puede necesitar formación para usar las nuevas herramientas de virtualización.

#### **4. La Máquina Virtual (MV)**

*   **Definición:** Una máquina virtual es, en esencia, un **fichero o un conjunto de ficheros** que simulan todos los componentes de un ordenador completo (BIOS, procesador, memoria, disco duro, etc.).
*   **Características:**
    *   **Aislamiento:** El sistema operativo virtualizado es totalmente independiente del sistema anfitrión y no interfiere con él.
    *   **Portabilidad:** Al ser ficheros, las MVs se pueden mover o copiar fácilmente de un equipo a otro.
    *   **Compatibilidad:** Pueden ejecutar sistemas operativos diferentes al del anfitrión.

*   **Software de Creación:**
    *   **VMware:** Ofrece productos como Workstation (de pago, tipo 2), Player (gratuito, tipo 2) y ESXi (líder en servidores, tipo 1).
    *   **Oracle:** Su principal producto es **VirtualBox** (gratuito, tipo 2).
    *   **Microsoft:** Ofrece soluciones como **Hyper-V**.

---

### **Parte 2: Guía Práctica y Funcionalidades**

#### **1. Creación de una Máquina Virtual (Pasos Generales)**

1.  **Iniciar el Asistente:** Abre el software de virtualización (ej. VirtualBox) y selecciona "Crear nueva máquina virtual".
2.  **Nombre y Sistema Operativo:** Asigna un nombre a la MV y especifica el tipo y la versión del sistema operativo que vas a instalar.
3.  **Memoria RAM:** Asigna la cantidad de memoria RAM que la MV podrá utilizar.
4.  **Disco Duro Virtual:** Crea un disco duro virtual. Puedes elegir entre:
    *   **Tipo de archivo:** VDI (VirtualBox), VMDK (VMware), VHD (Microsoft), etc.
    *   **Almacenamiento:**
        *   **Reservado dinámicamente:** El fichero del disco duro crece a medida que se llena.
        *   **Tamaño fijo:** Se reserva todo el espacio desde el principio (mejor rendimiento).
5.  **Tamaño y Ubicación:** Define el tamaño máximo del disco y dónde se guardará el fichero.

#### **2. Opciones de Configuración de la MV**

*   **Sistema:**
    *   **Memoria:** Ajusta la RAM.
    *   **Orden de arranque:** Simula la BIOS para elegir desde dónde arrancar (disco duro, CD/DVD, red).
    *   **Procesador:** Asigna el número de núcleos de la CPU física que la MV podrá usar y limita su porcentaje de uso.
*   **Almacenamiento:**
    *   Permite gestionar los discos duros virtuales y las unidades de CD/DVD.
    *   Puedes "montar" un **fichero ISO** como si fuera un CD/DVD físico, lo cual es ideal para instalar sistemas operativos.
*   **Red:** Configura cómo la MV se conecta a la red. Las opciones principales son:
    *   **NAT:** La MV accede a Internet usando la IP del equipo anfitrión. Es la opción más sencilla pero aísla la MV de la red local.
    *   **Adaptador Puente (Bridge):** La MV se conecta directamente a la red local y obtiene su propia dirección IP, comportándose como un equipo físico más.
    *   **Red Interna:** Crea una red privada y aislada a la que solo pueden conectarse las MVs que configures de esta manera.
    *   **Adaptador solo-anfitrión:** Crea una red privada entre la MV y el equipo anfitrión.
*   **USB:** Permite que la MV acceda a los dispositivos USB conectados al equipo físico. **Importante:** Un dispositivo USB solo puede ser utilizado por el anfitrión o por la MV a la vez, nunca por ambos.

#### **3. Añadiendo Funcionalidad: Guest Additions y Extension Pack**

*   **Guest Additions:**
    *   **¿Qué son?** Un paquete de controladores y software que se instala **dentro** del sistema operativo invitado.
    *   **¿Para qué sirven?** Mejoran drásticamente el rendimiento y la usabilidad, permitiendo:
        *   Integración fluida del ratón entre el anfitrión y el invitado.
        *   **Carpetas compartidas** para intercambiar archivos fácilmente.
        *   **Portapapeles compartido** (copiar y pegar texto entre sistemas).
        *   Mejor resolución de pantalla y soporte de vídeo.
*   **Extension Pack:**
    *   **¿Qué es?** Un paquete que se instala en el software de virtualización (en el equipo anfitrión).
    *   **¿Para qué sirve?** Añade funcionalidades avanzadas a VirtualBox, como:
        *   Soporte para **USB 2.0 y 3.0**.
        *   Control remoto de la MV (VRDP).
        *   Arranque por red (PXE).

#### **4. Operaciones de Recuperación y Gestión**

*   **Instantáneas (Snapshots):**
    *   Permiten **guardar el estado exacto de una MV** en un momento concreto.
    *   Es una herramienta muy potente para realizar pruebas, ya que si algo sale mal, puedes **volver a un estado anterior** con un solo clic. Se pueden crear múltiples instantáneas.
*   **Clonado de Máquinas:**
    *   Crea una copia exacta de una MV. Es muy útil para desplegar rápidamente varios equipos idénticos para simular una red.
    *   Es crucial seleccionar la opción de **reinicializar la dirección MAC** para evitar conflictos en la red.
*   **Importar y Exportar:**
    *   Permite empaquetar una MV completa (con su configuración y discos duros) en un **único fichero** (formato `.ova`).
    *   Esto facilita enormemente hacer copias de seguridad o mover la MV a otro ordenador.