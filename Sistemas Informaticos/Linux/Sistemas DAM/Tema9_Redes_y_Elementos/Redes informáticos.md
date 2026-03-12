# Redes informáticos

# 🌐 Clasificación de las Redes Informáticas

Una red no es más que un grupo de ordenadores conectados para compartir cosas (archivos, impresoras, internet).

**¿Por qué son útiles?**

- Ahorras dinero (compartes una sola impresora para 10 personas).
- Trabajas más rápido (productividad).
- Todo se controla desde un solo sitio (administración centralizada).

---

## 1. Según su alcance (¿Qué distancia cubren?)

Esta es la clasificación más común. Se ordenan de la más pequeña a la más grande.

| Siglas | Nombre completo | Tamaño real | Ejemplo cotidiano |
| --- | --- | --- | --- |
| **PAN** | Personal Area Network | Unos pocos metros. | Conectar tu móvil a los auriculares por Bluetooth. |
| **LAN** | Local Area Network | Un edificio o una casa. | El Wi-Fi de tu casa o la red de tu oficina. |
| **Campus** | Campus Area Network | Varios edificios cercanos. | La red de una Universidad con varios pabellones. |
| **MAN** | Metropolitan Area Network | Una ciudad entera. | La red de fibra óptica de un ayuntamiento. |
| **WAN** | Wide Area Network | Países o continentes. | **Internet** es la WAN más grande del mundo. |

---

## 2. Según el rol de sus equipos (¿Quién manda?)

Existen dos formas de organizar "quién hace qué":

- **Redes de igual a igual (P2P):** Todos los ordenadores son iguales. Nadie manda sobre nadie. Tú controlas tus archivos y yo los míos.
    - *Ideal para:* Casas o empresas muy pequeñas.
- **Redes Cliente-Servidor:** Hay uno o varios "jefes" (**Servidores**) que dan servicios y el resto (**Clientes**) solo piden. El servidor guarda los archivos y pone las reglas de seguridad.
    - *Ideal para:* Empresas medianas y grandes (ej: Windows Server).

---

## 3. Según su conexión y acceso

### Por tipo de cableado:

- **Cableadas:** Usan cables físicos (Ethernet, Fibra).
- **Inalámbricas:** Usan ondas (Wi-Fi, Bluetooth).

### 3.1. Las Categorías: ¿Por qué hay tantas y en qué se diferencian?

La diferencia entre categorías no es solo "el nombre". Físicamente, un cable de Cat 6 tiene los hilos más trenzados (más vueltas por centímetro) y suele ser más grueso que un Cat 5e. Esto se hace para evitar las **interferencias** (diafonía) y que la señal llegue más lejos y más rápido.

| Categoría | Velocidad Máxima | Frecuencia (Ancho de banda) | Uso común |
| --- | --- | --- | --- |
| **Cat 5** | 100 Mbps | 100 MHz | **Obsoleto.** Ya no se instala. |
| **Cat 5e** | 1 Gbps (1000 Mbps) | 100 MHz | El estándar básico en casas antiguas/baratas. |
| **Cat 6** | 1 Gbps (o 10Gbps en distancias cortas) | 250 MHz | **El estándar actual** para oficinas y casas modernas. |
| **Cat 6a** | 10 Gbps | 500 MHz | Redes profesionales, centros de datos. Muy rígido y blindado. |
| **Cat 7/7a** | 10 Gbps | 600 - 1000 MHz | Siempre blindado. Muy usado en industria. |

**Dato clave:** La **frecuencia (MHz)** es como el "ancho de la autopista". A más MHz, más datos pueden viajar al mismo tiempo sin chocarse o perderse.

---

### 3.2. El "Valor" de los colores (Lo que recuerdas de SMR)

En SMR, cuando mides con un polímetro o un tester, lo que buscas es **continuidad**. Pero lo que mencionas de que "cada color tiene un valor" se refiere probablemente a la **función de los pines** en el estándar Ethernet (10/100 Mbps):

- **Par Naranja (Pines 1 y 2):** Se usan para **Transmitir (TX)**.
- **Par Verde (Pines 3 y 6):** Se usan para **Recibir (RX)**.
- **Pares Azul y Marrón (Pines 4, 5, 7, 8):** En redes antiguas (10/100) **no hacían nada** (se usaban a veces para llevar corriente eléctrica - PoE - o telefonía).

**OJO:** En las redes modernas (**Gigabit Ethernet**), se usan los **8 hilos** a la vez para enviar y recibir datos. Por eso, si un hilo del par marrón está mal, tu red no irá a 1000 Mbps, sino que bajará automáticamente a 100 Mbps.

---

### 3.3. Los Estándares: T568A y T568B

Para que todo el mundo hable el mismo idioma, se inventaron dos "recetas" para ordenar los cables. En España y la mayor parte del mundo, usamos casi siempre la **T568B**.

- **Cable Directo:** (Mismo estándar en ambos lados, ej: B en un lado y B en el otro). Se usa para conectar dispositivos diferentes: **PC a Switch** o **Switch a Router**.
- **Cable Cruzado:** (A en un lado y B en el otro). Se usaba para conectar dispositivos iguales: **PC a PC** o **Switch a Switch**.
    - *Nota de SMR:* Hoy en día casi no se usan porque los equipos tienen **Auto MDI-X**, que detecta el cable y "cruza" la señal electrónicamente si es necesario.

---

### 3.4. ¿Cómo recordar el orden de los colores (T568B)?

Si tienes que crimpar, este es el truco para el estándar **B** (el más común):

1. **Blanco-Naranja**
2. **Naranja**
3. **Blanco-Verde**
4. **Azul** (¡Cuidado! Aquí se rompe el orden, el azul va en medio)
5. **Blanco-Azul**
6. **Verde**
7. **Blanco-Marrón**
8. **Marrón**

**Regla de oro de SMR:** El clip del conector RJ-45 siempre debe mirar **hacia abajo** cuando estés contando los pines del 1 al 8 de izquierda a derecha.

### Resumen para tu examen o repaso:

1. **Categoría = Velocidad.** Cat 6 es el equilibrio perfecto hoy.
2. **Gigabit (1000 Mbps)** necesita los 8 hilos perfectos.
3. **10/100 Mbps** solo necesita los pines 1, 2, 3 y 6 (Naranjas y Verdes).
4. **T568B** es el estándar que vas a usar el 99% de las veces.

### Por su difusión (Alcance lógico):

- **Internet:** Es la red mundial, pública y abierta para todo el mundo usando el protocolo TCP/IP.
- **Intranet:** Es como un "mini internet" privado. Solo los empleados de una empresa pueden entrar para ver noticias o documentos internos.

### Por su acceso y seguridad:

1. **Red Pública:** Cualquiera puede entrar (ej: El Wi-Fi de una plaza o Internet).
2. **Red Privada:** Solo entran usuarios autorizados con usuario y contraseña (ej: La red de un banco).
3. **Red Híbrida:** Una mezcla. Por ejemplo, una empresa que usa internet público pero crea un "túnel" seguro (llamado **VPN**) para que sus empleados trabajen desde casa de forma privada.

---

### 💡 Resumen visual rápido:

- **PAN/LAN/WAN:** Es sobre la **distancia**.
- **P2P / Cliente-Servidor:** Es sobre **quién manda**.
- **Internet / Intranet:** Es sobre si es **abierto o cerrado**.

# 🌐 Guía Rápida: Elementos de Red

Para que una red funcione, necesitamos **Hardware** (lo que se toca) y **Software** (los programas). Aquí nos centraremos en el Hardware.

---

## 1. Medios de Transmisión (Los Cables)

Existen dos tipos básicos:

- **Guiados:** Cables físicos (cobre o fibra).
- **No guiados:** Inalámbricos (Wi-Fi, Bluetooth).

### 📊 Comparativa de Cables

| Tipo de Cable | ¿Cómo es? | Uso principal | Velocidad / Distancia |
| --- | --- | --- | --- |
| **Coaxial** | Un núcleo de cobre con una malla protectora (como el de la antena de TV). | Casi no se usa en redes locales, más para televisión o internet antiguo. | Media / Distancia media. |
| **Par Trenzado** | 8 hilos de colores trenzados de 2 en 2 para evitar interferencias. Usa conector **RJ-45**. | El estándar en oficinas y casas (Ethernet). | **Cat 5e/6:** 1 Gbps<br>**Cat 6a/7:** 10 Gbps |
| **Fibra Óptica** | Hilo de vidrio o plástico que transmite **pulsos de luz**. Inmune a interferencias. | Conexiones de larga distancia y muy alta velocidad. | Muy alta / Distancias muy largas. |

---

## 2. Cómo conectar los cables (Estándares RJ-45)

Para los cables de par trenzado, existen dos formas de ordenar los hilos (Normas **568A** y **568B**):

1. **Cable Directo:** Se usa la misma norma en ambos extremos (normalmente 568B). Se usa para conectar dispositivos de **distinto nivel** (ej: Ordenador a Switch).
2. **Cable Cruzado:** Se usa una norma en un lado (A) y la otra en el otro (B). Se usa para dispositivos del **mismo nivel** (ej: Ordenador a Ordenador).
    - *Nota:* Los equipos modernos hoy en día lo detectan solos, pero la teoría sigue siendo esta.

---

## 3. Dispositivos de Interconexión (El "Cerebro")

Los dividimos según el **Modelo OSI** (el nivel de inteligencia):

### Nivel 1: Físico

- **Hub (Concentrador):** Recibe información y la envía a **todos** los ordenadores conectados. Es poco eficiente porque genera mucho tráfico innecesario.
- **Tarjeta de Red (NIC):** La pieza que tiene cada ordenador para conectarse. Tiene un nombre único en el mundo llamado **Dirección MAC**.

### Nivel 2: Enlace de Datos

- **Switch (Conmutador):** Es más inteligente que el Hub. Sabe qué ordenador está en cada puerto gracias a su dirección MAC y envía la información **solo a quien la necesita**.

### Nivel 3: Red

- **Router (Enrutador):** Su función es conectar redes distintas (ej: la red de tu casa con Internet). Elige el mejor camino para que los datos lleguen a su destino usando la **Dirección IP**.

---

## 4. Otros componentes importantes

- **Punto de Acceso (AP):** Permite que dispositivos inalámbricos (móviles, laptops) se conecten a una red por cable.
- **Rack o Armario:** El armario metálico donde se guarda y organiza todo el equipo de red.
- **Patch Panel:** Un panel donde terminan todos los cables que vienen de las paredes para conectarlos fácilmente a los equipos.
- **Cortafuegos (Firewall):** Protege la red de accesos no autorizados (puede ser hardware o software).

---

## 5. Cableado Estructurado

Es la forma organizada de montar una red en un edificio para que sea fácil de mantener. Se divide en:

1. **Cableado Horizontal:** Los cables que van por la planta hasta los puestos de trabajo.
2. **Cableado Vertical (Backbone):** Los cables que conectan las distintas plantas entre sí.
3. **Cuarto de entrada:** Por donde llega el internet de la calle al edificio.

---

### 💡 Resumen para no olvidar:

- **MAC:** Identificación física de la tarjeta de red (única).
- **Switch:** Conecta equipos dentro de la **misma red** (usa MAC).
- **Router:** Conecta **distintas redes** (usa IP).
- **Categoría 6:** Es lo más común hoy para ir a 1 Gbps.

---

# 🕸️ Topologías de Red

La **topología** es la "forma" o el mapa de la red. Se divide en dos puntos de vista:

1. **Física:** Cómo están conectados los cables y equipos (lo que ves).
2. **Lógica:** Cómo viajan los datos por dentro (aunque no los veas).

---

## 📡 Modos de Conexión Inalámbrica (Wi-Fi)

Antes de ver los cables, las redes sin cables se conectan de dos formas:

- **Modo Infraestructura:** Todos los dispositivos se conectan a un punto central (un **Router** o Punto de Acceso). Es el que usamos en casa.
- **Modo Ad-hoc:** Los dispositivos se conectan directamente entre ellos sin que haya un router de por medio (como pasar un archivo por Bluetooth).

---

## 🏗️ Tipos de Topologías Físicas

### 1. Topología en BUS (La "Línea")

- **Cómo es:** Todos los ordenadores están conectados a un único cable central llamado **troncal**.
- **Problema:** Si el cable central se rompe en cualquier punto, **toda la red deja de funcionar**.
- **Uso:** Se usaba en las primeras redes Ethernet con cable coaxial. Hoy es casi inexistente en oficinas.

### 2. Topología en ANILLO (El "Círculo")

- **Cómo es:** Cada ordenador se conecta al siguiente, y el último al primero, formando un círculo. La información viaja en una sola dirección.
- **Curiosidad:** Los datos pasan de uno a otro como si fuera un testigo en una carrera de relevos (llamado *Token*).
- **Uso:** Redes profesionales de fibra óptica (FDDI) porque permiten que, si se rompe un lado, la red siga funcionando por el otro (redundancia).

### 3. Topología en ESTRELLA (La más común)

- **Cómo es:** Todos los ordenadores se conectan a un **nodo central** (un Switch o Hub).
- **Ventaja:** Si se rompe el cable de un ordenador, solo ese ordenador pierde conexión. El resto sigue funcionando perfectamente.
- **Punto débil:** Si el Switch central se rompe, se cae toda la red.
- **Uso:** Es el estándar en el 99% de las redes actuales (casas y oficinas).

### 4. Topología en ÁRBOL / Estrella Extendida

- **Cómo es:** Es una jerarquía de estrellas. Hay un router principal conectado a varios switches, y cada switch tiene sus propios ordenadores.
- **Uso:** Es la forma en la que se organizan las redes de edificios grandes o universidades.

---

## 📊 Tabla Comparativa Rápida

| Topología | Facilidad de montaje | ¿Qué pasa si falla un cable? | Uso Actual |
| --- | --- | --- | --- |
| **Bus** | Muy fácil | Se cae **toda** la red. | Muy bajo (obsoleto). |
| **Anillo** | Media | Depende (si es doble anillo, aguanta). | Redes de fibra troncales. |
| **Estrella** | Fácil | Solo falla **ese** ordenador. | **El estándar actual.** |
| **Árbol** | Compleja | Falla solo la "rama" afectada. | Empresas y edificios. |

---

### 💡 Conceptos Clave para recordar:

- **Estrella:** Si ves un Switch con muchos cables saliendo hacia PCs, es una estrella. Es la que más vas a ver en el mundo real.
- **Redundancia:** Capacidad de la red para seguir funcionando aunque algo falle (típico del Anillo o la Malla).
- **Mapa Lógico:** Es donde anotas las IPs y nombres de los equipos, no solo por dónde van los cables.

---

# 🏗️ Arquitectura de Red y Modelos OSI / TCP-IP

Para que dos ordenadores se entiendan, no basta con conectarlos; necesitan **protocolos** (reglas de comunicación). La arquitectura de red organiza estas reglas en **capas** para que todo sea más ordenado.

### 📜 ¿Qué es un Protocolo?

Es el "idioma" de la red. Establece cómo se identifica el emisor, cómo se estructuran los mensajes, a qué velocidad se envían y cómo se corrigen los errores.

---

## 🏗️ Los Dos Modelos de Referencia

| Capa | **Modelo OSI** (Teórico - 7 capas) | **Modelo TCP/IP** (Real - 4 capas) | ¿Qué ocurre aquí? |
| --- | --- | --- | --- |
| **7, 6, 5** | Aplicación, Presentación, Sesión | **4. Aplicación** | El usuario interactúa con la red (Web, Email). |
| **4** | Transporte | **3. Transporte** | Divide los datos en paquetes y controla errores. |
| **3** | Red | **2. Internet** | Se encarga del direccionamiento IP y la ruta. |
| **2, 1** | Enlace de datos y Física | **1. Acceso a Red** | Se encarga de los bits, cables y direcciones MAC. |

---

## 📊 Tabla de Protocolos Completada

Aquí tienes la tabla que solicitabas, indicando en qué capa del modelo **TCP/IP** trabaja cada protocolo y para qué sirve:

| Protocolo | Capa del modelo TCP/IP | Descripción |
| --- | --- | --- |
| **HTTP** | Aplicación (4) | Protocolo para la transferencia de páginas web (hipertexto). |
| **IP** | Internet (2) | Direccionamiento lógico y enrutamiento de paquetes entre redes. |
| **TCP** | Transporte (3) | Envío fiable de datos con confirmación de recepción (orientado a conexión). |
| **UDP** | Transporte (3) | Envío rápido de datos sin confirmación, ideal para streaming o juegos. |
| **ICMP** | Internet (2) | Protocolo de control y mensajes de error (usado por el comando *Ping*). |
| **DNS** | Aplicación (4) | Traduce nombres de dominio (ej: [google.com](http://google.com/)) en direcciones IP. |
| **MAC** | Acceso a Red (1) | Dirección física única de la tarjeta de red para identificar el equipo localmente. |
| **FTP** | Aplicación (4) | Protocolo especializado en la transferencia de archivos entre equipos. |

---

### 💡 Datos Clave para recordar:

1. **Modelo OSI:** Es el modelo educativo y teórico para entender el proceso.
2. **Modelo TCP/IP:** Es el que realmente usa Internet hoy en día.
3. **Encapsulación:** A medida que la información baja por las capas, se le va añadiendo una "etiqueta" (cabecera) con información necesaria para esa capa (como el remite en un sobre).
