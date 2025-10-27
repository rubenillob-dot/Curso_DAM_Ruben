Claro, aquí tienes toda la información de la presentación, estructurada y separada entre la teoría y los pasos prácticos o comandos.

### Parte 1: Teoría sobre GNU/Linux

#### **1. Introducción a GNU/Linux**

*   **¿Qué es?** Linux es un sistema operativo de código abierto, fundamental en el mundo de la informática moderna. Nació de la unión del núcleo (kernel) **Linux** y el sistema de utilidades **GNU**.
*   **Origen:** En 1991, Linus Torvalds, un estudiante de la Universidad de Helsinki (Finlandia), comenzó a crear un núcleo de sistema operativo que se comportara como UNIX pero que funcionara en ordenadores personales (PC).
*   **Inspiración y Requisitos:** Linus se inspiró en **Minix**, una versión reducida de UNIX creada por el profesor Andy Tanenbaum. Un requisito técnico inicial fue que los ordenadores tuvieran al menos un procesador i386 para asegurar la compatibilidad.
*   **El Papel de GNU:** El objetivo era que el núcleo Linux fuera compatible con UNIX para poder ejecutar los programas gratuitos desarrollados por la **Free Software Foundation** (fundada por Richard Stallman). Estos programas se distribuyen bajo la **licencia GNU**, que impide ponerles precio y obliga a que cualquier nuevo software que utilice su código sea también libre.

#### **2. Conceptos Básicos**

*   **Kernel (Núcleo):** Es la parte central del sistema operativo. Interactúa directamente con el hardware (procesador, memoria, dispositivos) y gestiona todos los recursos del sistema.
*   **Distribución (Distro):** Es una versión completa y funcional de Linux. Incluye el kernel, software adicional (como entornos de escritorio, aplicaciones, utilidades) y herramientas de gestión.
*   **Terminal:** Es la interfaz de línea de comandos (CLI) que permite a los usuarios interactuar directamente con el sistema operativo introduciendo comandos de texto. Es una herramienta esencial para usuarios avanzados.
*   **Interfaz Gráfica de Usuario (GUI):** Son los entornos de escritorio que proporcionan una experiencia visual similar a la de Windows o macOS. Los más populares son **GNOME**, **KDE** y **Xfce**.

#### **3. Distribuciones Populares**

Existen muchas distribuciones, cada una con sus propias características y objetivos.

*   **Ubuntu:** Conocida por su facilidad de uso, ideal para principiantes. Ofrece versiones **LTS (Long Term Support)** para una mayor estabilidad.
*   **Debian:** Famosa por su gran estabilidad y su fuerte compromiso con el software 100% libre.
*   **Fedora:** Se centra en adoptar las últimas tecnologías, ofreciendo una experiencia de usuario muy actualizada.
*   **CentOS:** Basada en el código de **Red Hat Enterprise Linux (RHEL)**, está orientada a servidores y entornos empresariales.

#### **4. Uso, Ventajas e Inconvenientes**

**Casos de Uso Principales:**
*   **Servidores web:** Ampliamente utilizado con distros como CentOS y Ubuntu Server.
*   **Estaciones de trabajo:** Preferido por muchos desarrolladores y profesionales de la informática.
*   **Sistemas embebidos:** Se encuentra en routers, televisores inteligentes y sistemas de automóviles.
*   **Supercomputadoras:** Es el sistema operativo base de las supercomputadoras más potentes del mundo.
*   **Dispositivos IoT (Internet de las cosas).**
*   **Nube:** Es la base de implementaciones en la nube como Amazon Web Services (AWS) y Microsoft Azure.

**Ventajas:**
*   **Código Abierto:** Su código fuente es accesible para todos, lo que fomenta la transparencia y la colaboración.
*   **Estabilidad y Seguridad:** Es conocido por ser robusto, menos propenso a fallos y más resistente a ataques de malware.
*   **Personalización:** Ofrece un control total sobre el sistema, permitiendo elegir y modificar casi cualquier aspecto.
*   **Gratuito:** La mayoría de las distribuciones y su software son gratuitos, sin costes de licencia.

**Inconvenientes:**
*   **Curva de Aprendizaje:** Puede ser un desafío para usuarios acostumbrados a otros sistemas, especialmente por el uso de la línea de comandos.
*   **Compatibilidad de Software:** Aunque tiene un gran catálogo de software, no es compatible de forma nativa con todas las aplicaciones comerciales diseñadas para Windows.
*   **Soporte de Hardware:** Aunque ha mejorado enormemente, la compatibilidad con el hardware más reciente a veces puede presentar problemas.

#### **5. Sobre Ubuntu y Canonical**

*   **Canonical Ltd.:** Es la empresa privada, fundada por el sudafricano Mark Shuttleworth, que financia y promueve proyectos de software libre, siendo Ubuntu el más importante.
*   **Ubuntu:** Es una de las distribuciones más populares del mundo. Fue lanzada en 2004 y se basa en Debian GNU/Linux. Su objetivo es la facilidad de uso, la libertad y una instalación fluida.
*   **Ciclo de Lanzamiento:** Publica una nueva versión cada 6 meses:
    *   La versión **.04** en abril. En años pares, esta es una versión LTS (con soporte a largo plazo).
    *   La versión **.10** en octubre.

---

### Parte 2: Guía Práctica de Instalación de Ubuntu

Esta sección detalla los pasos y decisiones a tomar durante la instalación de Ubuntu.

#### **1. Requisitos del Sistema (para Ubuntu 22.04 LTS)**

*   **Procesador:** Doble núcleo de 2 GHz.
*   **Memoria RAM:** 4 GiB.
*   **Almacenamiento:** 25 GB de espacio en disco duro.
*   **Pantalla:** Resolución de 1024x768.
*   **Medio de instalación:** Puerto USB o unidad de CD/DVD.
*   **Tarjeta de vídeo (Recomendado):** Con capacidad de aceleración 3D y al menos 256 MB de memoria.

> **Nota:** Para equipos más antiguos, se recomiendan alternativas más ligeras como **Lubuntu** o **Xubuntu**.

#### **2. Proceso de Instalación (Pasos en el Asistente Gráfico)**

**Paso 1: Arranque e inicio**
*   Arranca el ordenador desde el medio de instalación (USB o DVD).
*   Elige tu idioma y haz clic en **"Instalar Ubuntu"**.

**Paso 2: Actualizaciones y otro software**
*   **Tipo de instalación:**
    *   **Instalación normal:** Instala un paquete completo de software (navegador web, utilidades, ofimática, juegos, etc.).
    *   **Instalación mínima:** Instala solo el navegador web y las utilidades básicas.
*   **Otras opciones:**
    *   **Descargar actualizaciones al instalar Ubuntu:** Ahorra tiempo después de la instalación.
    *   **Instalar programas de terceros:** Instala controladores para hardware (WiFi, gráficos) y códecs multimedia. (Recomendado).

**Paso 3: Tipo de instalación (Particionado del disco)**
Aquí tienes dos opciones principales:

*   **Opción A: Borrar disco e instalar Ubuntu**
    *   **Acción:** Formateará completamente el disco duro seleccionado, eliminará todos los datos existentes y creará las particiones necesarias de forma automática.
    *   **Uso recomendado:** Si el disco está vacío o no te importa perder los datos que contiene. Es la opción más sencilla.

*   **Opción B: Más opciones**
    *   **Acción:** Permite personalizar la gestión del disco y crear las particiones manualmente.
    *   **Uso recomendado:** Para usuarios avanzados, si quieres instalar Linux junto a otro sistema operativo (dual-boot) o si deseas una estructura de particiones específica.

**Paso 4 (Opcional): Particionado Manual Detallado**
Si elegiste "Más opciones", verás la pantalla de gestión de particiones.

1.  **Selecciona el disco duro:** `/dev/sda` (normalmente el primer disco).
2.  **Crea la tabla de particiones** si el disco es nuevo.
3.  **Crea las particiones** una por una, seleccionando el espacio libre. Para cada partición, debes configurar:
    *   **Tamaño:** La cantidad de espacio en MB.
    *   **Tipo:** Primaria o Lógica.
    *   **Ubicación:** Al principio o al final del espacio.
    *   **Utilizar como (Sistema de archivos):**
        *   `sistema de ficheros ext4 transaccional`: Es el estándar moderno para Linux.
        *   `área de intercambio`: Se usa como "memoria virtual" (swap).
    *   **Punto de montaje:** La carpeta donde se "montará" la partición.
        *   `/`: La raíz del sistema. Es la partición principal y obligatoria.
        *   `/home`: Para los datos de los usuarios. Es recomendable tenerla separada.
        *   `/boot`: Para los ficheros de arranque.

**Paso 5: Configuración final**
*   **¿Dónde se encuentra?** Elige tu zona horaria en el mapa para configurar el reloj del sistema.
*   **¿Quién es usted?** Configura tu cuenta de usuario:
    *   **Su nombre:** Tu nombre completo.
    *   **Nombre de su equipo:** El nombre que tendrá el ordenador en la red.
    *   **Elija un nombre de usuario:** Tu nombre de usuario para iniciar sesión.
    *   **Elija una contraseña:** La contraseña para tu usuario.

Tras este último paso, la instalación comenzará a copiar los archivos. Una vez finalice, se te pedirá reiniciar el equipo.