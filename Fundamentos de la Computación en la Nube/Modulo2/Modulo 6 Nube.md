# Modulo 6 Nube

---

# Servicios de cómputo de AWS

Amazon Web Services (AWS) ofrece muchos servicios de cómputo. Aquí se muestra un breve resumen de lo que ofrece cada servicio de cómputo:

- **Amazon Elastic Compute Cloud (Amazon EC2):** proporciona máquinas virtuales redimensionables.
- **Amazon EC2 Auto Scaling:** admite la disponibilidad de las aplicaciones al permitirle definir condiciones que iniciarán o terminarán las instancias de EC2 de manera automática.
- **Amazon Elastic Container Registry (Amazon ECR):** se utiliza para almacenar y recuperar imágenes de Docker.
- **Amazon Elastic Container Service (Amazon ECS):** es un servicio de coordinación compatible con Docker.
- **VMware Cloud on AWS:** le permite aprovisionar una nube híbrida sin hardware personalizado.
- **AWS Elastic Beanstalk:** proporciona una forma sencilla de ejecutar y administrar aplicaciones web.
- **AWS Lambda:** es una opción de cómputo sin servidor. Solo paga por el tiempo de cómputo que utilice.
- **Amazon Elastic Kubernetes Service (Amazon EKS):** le permite ejecutar Kubernetes administrado en AWS.
- **Amazon Lightsail:** proporciona un servicio fácil de usar para crear una aplicación o un sitio web.
- **AWS Batch:** proporciona una herramienta para ejecutar trabajos por lotes a cualquier escala.
- **AWS Fargate:** proporciona una forma de ejecutar contenedores que reducen la necesidad de administrar servidores o clústeres.
- **AWS Outposts:** proporciona una manera de ejecutar AWS seleccionados en su centro de datos en las instalaciones.
- **Repositorio de aplicaciones sin servidor de AWS:** proporciona una manera de descubrir, implementar y publicar aplicaciones sin servidor.

---

## Categorización de servicios de cómputo

Se puede considerar que cada servicio de cómputo de AWS pertenece a una de cuatro categorías amplias: 
Máquinas virtuales (VM) infraestructura como servicio (IaaS)
Tecnología sin servidor, basada en contenedores y plataforma como servicio (PaaS).

**Amazon EC2** proporciona máquinas virtuales (IaaS). 
Los servicios de IaaS ofrecen flexibilidad y le permiten estar a cargo de muchas de las responsabilidades de la administración del servidor. Puede elegir el sistema operativo, así como el tamaño y las capacidades de los recursos de los servidores que lance. 

**AWS Lambda** es una plataforma de cómputo que no requiere ningún tipo de administración, permite ejecutar código sin necesidad de aprovisionar ni administrar servidores. 
Solo paga por el tiempo de cómputo que consume. 
Sin embargo posibilita una escalabilidad masiva a un costo menor que el de la ejecución ininterrumpida de servidores para respaldar las mismas cargas de trabajo.

Los servicios basados en contenedores, incluidos **Amazon Elastic Container Service**, **Amazon Elastic Kubernetes Service**, **AWS Fargate** y **Amazon Elastic Container Registry**, le permiten ejecutar varias cargas de trabajo en un solo sistema operativo. 

**AWS Elastic Beanstalk** servicio (PaaS). 
Facilita la implementación rápida de las aplicaciones que se crean al prestar todos los servicios de aplicaciones necesarios. 
AWS administra el sistema operativo, el servidor de aplicaciones y los demás componentes de la infraestructura para que usted pueda centrarse en desarrollar el código de la aplicación.

---

## Elección de un servicio de cómputo optimo

- El servicio o servicios de cómputo óptimos que utilice dependerán de su caso práctico.
- Algunos aspectos a considerar:
    - ¿Cuál es el diseño de su aplicación?
    - ¿Cuáles son los patrones de uso?
    - ¿Qué ajustes de configuración querrás administrar?
- Seleccionar la solución de cómputo incorrecta para una arquitectura puede provocar una menor eficiencia del rendimiento.
- Un buen punto de partida es comprender las opciones de cómputo disponibles.

AWS ofrece muchos servicios de cómputo porque los diferentes casos prácticos se benefician de diferentes entornos de cómputo. 

A menudo, la arquitectura de cómputo que utiliza está determinada por el código heredado.

Las prácticas recomendadas incluyen lo siguiente:
* evaluar las opciones de cómputo disponibles
* comprender las opciones de configuración de cómputo disponibles
* recopilar métricas relacionadas con el cómputo
* utilizar la elasticidad disponible de los recursos
* re-evalúe constantemente las necesidades de cómputo según las métricas

---

# Sección 2: Amazon Elastic Compute Cloud

*Módulo 6: Cómputo*

## Amazon Elastic Compute Cloud (Amazon EC2)

Proporciona máquinas virtuales en las que puede alojar los mismos tipos de aplicaciones que podría ejecutar en un servidor en las instalaciones locales tradicionales. Proporciona capacidad de cómputo segura y modificable en la nube. Las instancias EC2 pueden admitir diversas cargas de trabajo. Los usos comunes de las instancias de EC2 incluyen los siguientes, entre otros:

- Servidores de aplicaciones
- Servidores web
- Servidores de bases de datos
- Servidores de juegos
- Servidores de correo
- Servidores multimedia
- Servidores de catálogos
- Servidores de archivos
- Servidores de cómputo
- Servidores proxy

---

## Información general sobre Amazon EC2

**Amazon Elastic Compute Cloud (Amazon EC2)**
* Proporciona máquinas virtuales, denominadas instancias EC2, en la nube.
* Le proporciona control absoluto sobre el sistema operativo invitado (Windows o Linux) en cada instancia.
* Puede iniciar instancias de cualquier capacidad en una zona de disponibilidad en cualquier parte del mundo.
* Lance instancias desde **Amazon Machine Images (AMI)**.
* Inicie instancias con unos pocos clics o con una línea de código y estarán listas en cuestión de minutos.
* Puede controlar el tráfico hacia y desde las instancias.

El EC2 en Amazon EC2 significa **Elastic Compute Cloud**:

* **Elastic** se refiere al hecho de que puede aumentar o reducir fácilmente el número de servidores que ejecuta para dar soporte a una aplicación de forma automática, y también puede aumentar o disminuir el tamaño de los servidores existentes.

* El **cómputo** se refiere a la razón por la cual la mayoría de los usuarios ejecutan servidores en primer lugar, que es alojar aplicaciones en ejecución o procesar datos, acciones que requieren recursos de cómputo, incluida la potencia de procesamiento (CPU) y la memoria (RAM).

* **Cloud** se refiere al hecho de que las instancias de EC2 que ejecuta están alojadas en la nube.

Amazon EC2 proporciona máquinas virtuales en la nube y le proporciona un control administrativo total sobre el sistema operativo Microsoft Windows o Linux que se ejecuta en la instancia. 

Un sistema operativo que se ejecuta en una máquina virtual suele denominarse sistema operativo invitado 

Con Amazon EC2, puede iniciar en cuestión de minutos cualquier cantidad de instancias.
Las instancias se lanzan desde las Amazon Machine Images (AMI), que son en efecto plantillas de máquinas virtuales. 

---

## Lanzamiento de una instancia de EC2

La primera vez que lance una instancia EC2, tendrá la oportunidad de experimentar el uso del Asistente de inicio en el laboratorio que se encuentra en este módulo.

El asistente de lanzamiento de instancias facilita el lanzamiento de una instancia.

Sin embargo, para la mayoría de las implementaciones, querrá modificar la configuración predeterminada para que los servidores que inicie se implementen de forma que se ajusten a sus necesidades específicas.

---

### 1. Seleccionar una AMI

- **Imagen de máquina de Amazon (AMI)**
    - Es una plantilla que se utiliza para crear una instancia EC2 (que es una máquina virtual, o VM, que se ejecuta en la nube de AWS).
    - Contiene un sistema operativo Windows o Linux.
    - A menudo también tiene algún software preinstalado.
- **Elecciones de AMI:**
    - Inicio rápido: AMI de Linux y Windows que proporciona AWS.
    - AWS Marketplace: plantillas preconfiguradas de terceros.
    - AMI de la comunidad: AMI que comparten los demás; utilícelas bajo su propio riesgo.

Una **Amazon Machine Image (AMI)** proporciona la información necesaria para lanzar una instancia de EC2. Debe especificar una AMI de origen al lanzar una instancia. 
Puedes usar diferentes AMI para lanzar distintos tipos de instancias. Por ejemplo, puede elegir una AMI para lanzar una instancia que se convertirá en un servidor web y otra AMI para implementar una instancia que alojará un servidor de aplicaciones. 

Una AMI incluye los siguientes componentes:
* Un volumen raíz suele contener un sistema operativo (SO) y todo lo que se instaló en ese SO (aplicaciones, bibliotecas, etc.). Amazon EC2 copia la plantilla en el volumen raíz de una nueva instancia EC2 y, a continuación, la inicia.
* **Permisos de lanzamiento** que controlan qué cuentas de AWS pueden utilizar la AMI.
* **Una asignación de dispositivos de bloques** que especifica los volúmenes que deben adjuntarse a la instancia (si hay) cuando se lanza.

Puede elegir muchas AMI:
* **Quick Start:** AMI prediseñadas para iniciar las instancias. 
* **Mis AMI:** AMI que has creado.
* **AWS Marketplace:** un catálogo digital que enumera miles de soluciones de software. 

---

### 2. Seleccionar un tipo de instancia

- Considere su caso de uso.
- ¿Cómo se utilizará la instancia EC2 que cree?
- El **tipo de instancia** que elija determina lo siguiente:
    - Memoria (RAM)
    - Potencia de procesamiento (CPU)
    - Espacio en disco y tipo de disco (almacenamiento)
    - Rendimiento de red
- Categorías de tipos de instancia:
    - Instancias de propósito general
    - optimizadas para cómputo
    - Optimizadas para memoria
    - Optimizadas para almacenamiento
    - Con cómputo acelerado
- Los tipos de instancia ofrecen *familia, generación y tamaño*.

Después de elegir la AMI para lanzar la instancia, debe elegir un tipo de instancia.

Amazon EC2 proporciona una selección de **tipos de instancias** optimizados para adaptarse a diferentes casos prácticos. 
Los tipos de instancias tienen diversas combinaciones de CPU, memoria, almacenamiento y capacidad de redes. Los diferentes tipos de instancias le dan la flexibilidad de elegir la combinación adecuada de recursos para las aplicaciones. Cada tipo de instancia se ofrece en uno o varios tamaños, lo que le permite escalar los recursos según los requisitos de la carga de trabajo deseada.

Las categorías de tipos de instancia incluyen instancias de 
Uso general, optimizadas para cómputo, optimizadas para memoria, optimizadas para almacenamiento y de cómputo acelerado. 

---

### Nombres y tamaños de los tipos de instancia EC2

Cuando se analiza un tipo de instancia de EC2, verá que el nombre tiene varias partes. Por ejemplo, considere el tipo T.

**T** es el **nombre de la familia**, al cual le sigue un número. Aquí, ese número es 3.

El número es el **número de la generación** de ese tipo. Por lo tanto, una instancia t3 es la tercera generación de la familia T. En general, los tipos de instancias que son de una generación más alta son más potentes y ofrecen un mejor relación calidad-precio.

La parte siguiente del nombre corresponde a la capacidad de la instancia. Cuando se comparan las capacidades, es importante tener en cuenta la parte del coeficiente de la categoría de capacidad.

Por ejemplo, una instancia **t3.2xlarge tiene el doble de vCPU y memoria** que una instancia t3.xlarge. La instancia t3.xlarge tiene, a su vez, el doble de vCPU y memoria que una instancia t3.large.

Además es importante tener en cuenta que el **ancho de banda de la red** también está vinculada al tamaño de la instancia de EC2. Si ejecuta trabajos que hacen un uso intensivo de la red, es posible que deba aumentar las especificaciones de las instancias para satisfacer sus necesidades.

---

### Seleccione el tipo de instancia: según el caso práctico

Los tipos de instancias varían de varias maneras e incluyen: tipo de CPU, CPU o número de núcleos, tipo de almacenamiento, cantidad de almacenamiento, cantidad de memoria y rendimiento de la red. Evaluemos algunos de los tipos de instancia con más detalle:

- **Las instancias T3** proporcionan instancias de **propósito general** con rendimiento ampliable ofrecen un nivel base de rendimiento de la CPU con la posibilidad de extenderse por encima de dicho nivel. Entre los casos prácticos de este tipo de instancia, se incluyen sitios y aplicaciones web, entornos de desarrollo, repositorios de código
- **Las instancias C5** están optimizadas para las cargas de trabajo con uso intensivo de cómputo y ofrecen un rendimiento rentable y alto con un precio bajo por relación de cómputo. Algunos de los casos prácticos incluyen el modelado científico, el procesamiento por lotes, la presentación de anuncios, los videojuegos multijugador
- **Las instancias R5** están **optimizadas para las aplicaciones con uso intensivo de la memoria**. Entre los casos prácticos, se incluyen las bases de datos de alto rendimiento, la extracción y el análisis de datos, las bases de datos en memoria, el almacenamiento en caché en memoria distribuida a escala web, las aplicaciones que realizan el procesamiento en tiempo real de big data no estructurados.

---

### Tipos de instancias: características de redes

- La banda ancha de red (Gb/s) varía según el tipo de instancia.
- Para maximizar el rendimiento de las redes y la banda ancha del tipo de instancia:
    - Si tiene instancias interdependientes, láncelas en un **grupo con ubicación en clúster**.
    - Habilitar redes mejoradas.
- La mayoría de los tipos de instancia admiten tipos de redes mejoradas.
- Tipos de redes mejoradas:
    - **Adaptador de red elástico (ENA):** admite velocidades de red de hasta 100 Gbps.
    - **Interfaz de función virtual Intel 82599:** admite velocidades de red de hasta 10 Gbps.

Cada tipo de instancia proporciona un nivel de rendimiento de red documentado. 

Al lanzar varias instancias EC2 nuevas, Amazon EC2 intenta distribuir de forma predeterminada las instancias en el hardware subyacente. 
Esto lo hace para minimizar los errores correlacionados. 
Sin embargo, si desea especificar criterios de colocación, puede utilizar los **grupos de ubicación** para influir en la ubicación de un grupo de instancias interdependientes para satisfacer las necesidades de su carga de trabajo. 

Muchos tipos de instancias también le permiten configurar redes mejoradas para obtener 
Un rendimiento de paquetes por segundo (PPS) mayor de forma significativa
Menor variación del retraso en la llegada de paquetes a través de la red (variación de la red) 
Latencias más bajas. 

---

### 3. Especificar la configuración de red

- ¿Dónde debería implementarse la instancia?
    - Identificar la nube virtual privada (VPC) y opcionalmente, la subred.
- ¿Debería asignarse automáticamente una **dirección IP pública**?
    - Para hacerla accesible a Internet.

Después de elegir una AMI y un tipo de instancia, tiene que especificar la ubicación de red en la que se implementará la instancia de EC2.

Cuando lance una instancia en una **(VPC) predeterminada**, AWS le asignará una **dirección IP pública** de forma predeterminada. 
Cuando lanza una instancia en una VPC no predeterminada, la subred reciben una dirección IP pública del grupo de direcciones IPv4 públicas. 
De forma predeterminada, AWS no asignará una dirección IP pública a las instancias que se lancen en una subred no predeterminada. 

---

### 4. Adjuntar rol de IAM (opcional)

- ¿El software de la instancia de EC2 necesita interactuar con otros AWS?
    - En caso afirmativo, adjunte un **rol de IAM** adecuado.
- Un rol de AWS Identity and Access Management (IAM) que se adjunta a una instancia de EC2 se mantiene en un **perfil de instancias**.
- No se limita a adjuntar un rol solo en el lanzamiento de la instancia.
- También puede adjuntar un rol a una instancia que ya existe.

Es habitual utilizar instancias EC2 para ejecutar una aplicación que debe realizar llamadas API seguras a otros productos de AWS. 
AWS le permite adjuntar un **rol de AWS Identity and Access Management (IAM)** a una instancia de EC2. Sin esta función, podría tener la tentación de colocar las credenciales de AWS en una instancia de EC2 para una aplicación que se ejecuta en esa instancia. Sin embargo, **nunca debe almacenar las credenciales de AWS en una instancia EC2**. 
El rol de IAM concede permisos para realizar solicitudes de Application Program Interface (API) a las aplicaciones que se ejecutan en la instancia de EC2.

Un **perfil de instancias** es un contenedor de un rol de IAM. 

Puede adjuntar un rol de IAM al lanzar la instancia, pero también puede adjuntar un rol a una instancia de EC2 que ya esté en ejecución.

---

### 5. Script de datos de usuario (opcional)

- Si lo desea, especifique un script de datos de usuario al lanzar la instancia.
- Utilice scripts de **datos de usuario** para personalizar el entorno en tiempo de ejecución de su instancia.
    - El script se ejecuta la primera vez que se inicia la instancia.

Al crear las instancias de EC2, tiene la opción de pasar **datos de usuario** a la instancia. Los datos de usuario pueden automatizar la finalización de las instalaciones y configuraciones en el lanzamiento de la instancia. 

Cuando se crea la instancia de EC2, **el script de datos de usuario se ejecuta con privilegios de usuario raíz** durante las fases finales del proceso de arranque. 
**De forma predeterminada, los datos de usuario solo se ejecutan la primera vez que se inicia la instancia.** 

---

### 6. Especificar almacenamiento

- **Configurar el volumen raíz**
    - Dónde está instalado el sistema operativo invitado.
- **Adjuntar volúmenes de almacenamiento adicionales (opcional)**
    - Es posible que la AMI ya incluya más de un volumen.
- Para cada volumen, especifique lo siguiente:
    - **Tamaño del disco (en GB)**
    - **El tipo de volumen** (Hay disponibles diferentes tipos de unidades de estado sólido (SSD) y unidades de disco duro (HDD)).
    - Si el volumen se eliminará al finalizar la instancia.
    - Si se debe utilizar el **cifrado**.

Cuando lanza una instancia EC2, puede configurar las opciones de almacenamiento. 

Para cada volumen que tendrá la instancia, puede especificar el tamaño de los discos, los tipos de volumen y si el almacenamiento se conservará si se termina la instancia. 
También puede especificar si se debe utilizar el cifrado.

---

### 7. Agregar etiquetas

- Una **etiqueta** es un rótulo que se puede asignar a un recurso de AWS.
    - Consta de una **clave** y un **valor opcional**.
- El etiquetado es la forma en que se pueden adjuntar **metadatos** a una instancia de EC2.
- Beneficios potenciales de las etiquetas: filtro, automatización, asignación de costos y control de acceso.

Una etiqueta es un rótulo que se asigna a un recurso de AWS. 
Cada etiqueta está formada por una clave y un valor opcional que usted mismo define. Las etiquetas le permiten clasificar los recursos de AWS tales como instancias de EC2 de distintas formas. 

El etiquetado es la forma en que se pueden adjuntar metadatos a una instancia de EC2.

---

### 8. Configuración del grupo de seguridad

- Un **grupo de seguridad** es un conjunto de reglas de firewall que controlan el tráfico a la instancia.
    - Existe fuera del SO invitado de la instancia.
- Cree reglas que especifiquen la **fuente** y los **puertos** que pueden utilizar las comunicaciones de red.
    - Especifique el número de **puerto** y el **protocolo** (TCP, UDP, ICMP).
    - Especifique la **fuente** (por ejemplo, una dirección IP u otro grupo de seguridad) a la que se le permita utilizar la regla.

Las reglas de un grupo de seguridad se pueden modificar en cualquier momento; las nuevas reglas se aplican automáticamente a todas las instancias que estén asociadas al grupo de seguridad. 

Al definir una regla, puede especificar la fuente permitida de la comunicación de red (reglas de entrada) o el destino (reglas de salida).

Las listas de control de acceso a la red (ACL de red) también se pueden utilizar como firewalls para proteger las subredes de una VPC.

---

### 9. Identificar o crear el par de claves

- En el lanzamiento de la instancia, se especifica un par de claves existente o se crea un nuevo par de claves.
- Un par de claves consiste en:
    - una **clave pública** que AWS almacena.
    - un archivo de **clave privada** que usted almacena.
- Permite conexiones seguras a la instancia.
- **Para AMI de Windows:**
    - utilice la clave privada con el fin de obtener la contraseña de administrador que necesita para iniciar sesión en su instancia.
- **Para AMI de Linux:**
    - utilice la clave privada a fin de emplear SSH para conectarse de forma segura a su instancia.

Amazon EC2 utiliza la criptografía de clave pública para cifrar y descifrar la información de inicio de sesión. 
La tecnología utiliza una **clave pública** para cifrar un dato y luego el destinatario usa la **clave privada** para descifrar los datos. El conjunto de clave pública y clave privada se denomina **par de claves**.

---

## Ciclo de vida de las instancias de Amazon EC2

Una instancia puede tener uno de los siguientes estados:
* **Pendiente:** cuando una instancia se inicia por primera vez desde una AMI o cuando se inicia una instancia detenida

* **En ejecución:** cuando la instancia se ha iniciado completamente y se encuentra lista, sale del estado pendiente y entra en estado de en ejecución. 

* **Reinicio:** Una instancia reiniciada permanece en el mismo host físico, mantiene el mismo nombre DNS público y dirección IP pública y, si tiene volúmenes de almacenamiento de instancias, conserva los datos de esos volúmenes.

* **Apagando:** este estado es un estado intermedio entre en ejecución y terminada.

* **Terminada:** una instancia terminada permanece en la consola de Amazon EC2 durante algún tiempo antes de que se elimine la máquina virtual. Sin embargo, no puede conectarse a una instancia terminada ni recuperarla.

* **Deteniendo:** las instancias respaldadas por Amazon EBS se pueden detener. Entran en el estado de en proceso de detención antes de alcanzar el estado de detenida por completo.

* **Detenida:** Una instancia detenida no incurrirá en los mismos costos que una instancia en ejecución. Al iniciar una instancia detenida, se vuelve a poner en estado pendiente, lo que la mueve a un nuevo equipo host.

### Opción de hibernación de instancia (Instance hibernation option)

Algunas instancias respaldadas por Amazon EBS admiten la hibernación. Cuando hibernas una instancia, el sistema operativo invitado guarda el contenido de la memoria de la instancia (RAM) en el volumen raíz de Amazon EBS. Cuando reinicias la instancia, el volumen raíz se restaura a su estado anterior, se recarga el contenido de la RAM y se reanudan los procesos que se estaban ejecutando previamente en la instancia.

---

## Considere utilizar una dirección IP elástica

- **Reiniciar** una instancia no cambiará ninguna dirección IP ni nombre de host DNS.
- ¿Qué ocurre si la instancia **se detiene y se vuelve a iniciar**?
    - La dirección IPv4 *pública* y el nombre de host DNS *externo* se modificarán.
    - La dirección IPv4 *privada* y el nombre de host DNS *interno* no se modifican.
- Si necesita una dirección IP pública persistente:
    - puede asociar una **dirección IP elástica** con la instancia.
- Características de la dirección IP elástica:
    - se puede asociar con instancias en la Región según sea necesario.
    - permanece asignado a su cuenta hasta que decida liberarlo.

Una **dirección IP pública** es una dirección IPv4 a la que se puede acceder desde Internet. Cada instancia que recibe una dirección IP pública también recibe un nombre de host DNS externo.

La instancia detenida recibe una nueva dirección IP pública cuando se inicia de nuevo.

Si necesita una dirección IP pública persistente, es posible que desee asociar una **dirección IP elástica** con la instancia. Para asociar una dirección IP elástica, primero debe asignar una nueva dirección IP elástica en la región donde existe la instancia. Luego de la asignación de la dirección IP elástica, puede asociar la dirección IP elástica con una instancia de EC2.

De forma predeterminada, todas las cuentas de AWS están limitadas a cinco (5) direcciones IP elásticas por región.

---

## Metadatos de la instancia de EC2

- Los **metadatos de la instancia** son datos sobre su instancia.
- Mientras esté conectado a la instancia, podrá visualizarla:
    - En un navegador: `http://169.254.169.254/latest/meta-data/`
    - En una ventana de terminal: `curl http://169.254.169.254/latest/meta-data/`
- Ejemplos de valores recuperables: Dirección IP pública, dirección IP privada, nombre de host público, ID de instancia, grupos de seguridad, región, zona de disponibilidad.
- Se puede utilizar para configurar o administrar una instancia en ejecución (scripts de configuración).

Los metadatos de la instancia son datos sobre su instancia. Mientras esté conectado a la instancia, puede visualizarla. 

---

## Se utiliza CloudWatch para la supervisión

- Utilice **Amazon CloudWatch** para monitorear instancias de EC2.
    - Proporciona métricas en tiempo real.
    - Proporciona gráficos en la pestaña **Monitoreo** de la consola Amazon EC2.
    - Mantiene 15 meses de datos históricos.
- **Supervisión básica**
    - Predeterminado, sin costo adicional.
    - Datos de métricas enviados a CloudWatch cada 5 minutos.
- **Monitoreo detallado**
    - Tarifa mensual fija para siete métricas preseleccionadas.
    - Datos de métricas entregados cada 1 minuto.

Puede monitorear las instancias mediante Amazon CloudWatch, que recopila y procesa datos sin procesar de Amazon EC2 en métricas legibles casi en tiempo real. Estas estadísticas se registran durante un periodo de 15 meses, de forma que pueda acceder a información histórica.

De forma predeterminada, Amazon EC2 proporciona **supervisión básica**, que envía datos de métrica a CloudWatch en periodos de 5 minutos. Para enviar datos de métricas para su instancia a CloudWatch en períodos de 1 minuto, puede habilitar la **supervisión detallada** de la instancia.

# Sección 3: Optimización de costos de Amazon EC2

## Modelos de precios de Amazon EC2

Amazon ofrece diferentes modelos de precios entre los cuales elegir cuando desee ejecutar instancias EC2.

**Instancias bajo demanda**
* Pago por hora.
* No asume compromisos a largo plazo.
* Apto para el nivel gratuito de AWS.
* La facturación por segundo solo está disponible para las instancias bajo demanda.
* Tienen el costo inicial más bajo y la mayor flexibilidad. Son una buena opción para aplicaciones con cargas de trabajo a corto plazo, con picos de demanda o impredecibles.

**Servidores dedicados**
* Un servidor físico con capacidad de EC2 totalmente dedicado a su uso.
* Los alojamientos dedicados son servidores físicos con capacidad de instancia dedicada para su uso. 
* Las instancias dedicadas son instancias de EC2 que se ejecutan en una nube virtual privada (VPC) en un hardware dedicado a un único cliente. Se aíslan físicamente de las instancias que pertenecen a otras cuentas de AWS a nivel del hardware que es host.

**Instancias reservadas**
* Pago total, parcial o sin pago inicial para la instancia que reserva.
* Descuento en el cargo horario por uso de dicha instancia.
* Plazo de 1 o 3 años.

**Instancias reservadas programadas**
* Adquiera una reserva de capacidad que esté disponible en un horario recurrente que especifique (diaria, semanal o mensualmente).
* Plazo de 1 año.

**Instancias de spot**
* Las instancias se ejecutan siempre que estén disponibles y su puja sea superior al precio de las instancias de spot.
* AWS puede interrumpirlas con una notificación de 2 minutos.
* Las opciones de interrupción incluyen terminación, parada o hibernación.
* Los precios pueden ser de forma significativa menos costosos en comparación con las instancias bajo demanda.

## Modelos de precios de Amazon EC2: beneficios

Cada modelo de precios de Amazon EC2 proporciona un conjunto diferente de beneficios.

- **Instancias bajo demanda:** Ofrece bajo costo y flexibilidad, sin contratos a largo plazo.
- **Instancias de spot:** Carga de trabajo dinámica y a gran escala a un precio con un descuento significativo.
- **Instancias reservadas:** Ofrece previsibilidad, lo que garantiza que la capacidad de cómputo esté disponible cuando sea necesario. Ideal para necesidades de cómputo de estado estable.
- **Servidores dedicados:** Permite ahorrar en costos de licencia y ayuda a cumplir los requisitos normativos y de conformidad específicos.

---

## Modelos de precios de Amazon EC2: casos de uso

Esta es una revisión de algunos casos de uso de las distintas opciones de precios.

- **Instancias bajo demanda:** Cargas de trabajo a corto plazo, con picos de demanda o impredecibles. Desarrollo o prueba de aplicaciones.
- **Instancias de spot:** Aplicaciones con tiempos de inicio y finalización flexibles. Aplicaciones que solo son viables con precios de cómputo muy bajos. Usuarios con necesidades de cómputo urgentes de grandes cantidades de capacidad adicional.
- **Instancias reservadas:** Cargas de trabajo de uso predecible o estado estable. Aplicaciones que requieren capacidad reservada, incluida la recuperación ante desastres (DR).
- **Servidores dedicados:** Licencia “Bring your own license” (BYOL). Conformidad y restricciones normativas. Seguimiento del uso y las licencias. Control en una ubicación de instancia.

---

## Los cuatro pilares de la optimización de costos

Para optimizar los costos, debe considerar cuatro factores potentes y consistentes:

1. **Tamaño adecuado:** elija el equilibrio adecuado de tipos de instancias. Observe cuándo los servidores pueden reducirse o apagarse y aun así cumplir con los requisitos de rendimiento.
2. **Aumento de la elasticidad:** diseña implementaciones para reducir la cantidad de capacidad del servidor que está inactiva mediante implementaciones que sean elásticas, tales como implementaciones que utilizan el escalado automático para manejar cargas máximas.
3. **Modelo de precios óptimo:** reconoce las opciones de precios disponibles. Analice sus patrones de uso de manera que pueda ejecutar las instancias EC2 con la combinación adecuada de opciones de precios.
4. **Optimización de las opciones de almacenamiento:** analiza los requisitos de almacenamiento de las implementaciones. Reduzca la sobrecarga de almacenamiento sin utilizar cuando sea posible y elegir opciones de almacenamiento más económicas si siguen cumpliendo con los requisitos de rendimiento de almacenamiento

---

### Pilar 2: Aumento de la elasticidad

- **Detener o hibernar instancias respaldadas por Amazon EBS que estén en uso inactivo.**
    - Ejemplo: desarrollo no productivo o instancias de prueba.
- **Utilice el escalado automático para satisfacer las necesidades de acuerdo con el uso.**
    - Elasticidad automatizada y basada en el tiempo.

Una forma de **elasticidad** es crear, iniciar o usar instancias de EC2 cuando sean necesarias, pero luego desactivarlas cuando no estén en uso. La elasticidad es uno de los principios centrales de la nube.

La forma más fácil para que los grandes clientes adopten la elasticidad es buscar recursos que parezcan buenos candidatos para detenerse o hibernar, como entornos que no son de producción (desarrollo o prueba). 

Para las cargas de trabajo de producción, configurar políticas de escalado automático más precisas y granulares puede ayudarle a aprovechar el escalado horizontal para satisfacer las necesidades de capacidad máxima

---

### Pilar 3: Modelo de precios óptimo

- **Aproveche el modelo de precios adecuado para su caso práctico.**
    - ¿Cuáles son los patrones de uso?
- **Optimizar y combinar tipos de compra.**
- **Ejemplos:**
    - Utilice **instancias bajo demanda e instancias de spot** para cargas de trabajo variables.
    - Utilice **instancias reservadas** para cargas de trabajo predecibles.
- **Considere soluciones sin servidor (AWS Lambda).**

Los clientes pueden combinar múltiples tipos de compras para optimizar los precios en función de sus necesidades de capacidad actuales y previstas.

---

### Pilar 4: Optimización de las opciones de almacenamiento

- **Reduzca los costos manteniendo el rendimiento y la disponibilidad del almacenamiento.**
- **Modificar el tamaño de los volúmenes de Amazon EBS.**
- **Modificar los tipos de volúmenes de Amazon EBS.**
    - ¿Se pueden cumplir los requisitos de rendimiento con un almacenamiento menos costoso?
    - Ejemplo: el almacenamiento HDD (st1) con rendimiento optimizado de Amazon EBS por lo general cuesta la mitad que la opción de almacenamiento SSD de uso general (gp2) predeterminada.
- **Elimine las instantáneas de EBS que ya no sean necesarias.**
- **Identificar el destino más apropiado para tipos específicos de datos.**
    - ¿La aplicación necesita que la instancia resida en Amazon EBS?
    - Las opciones de almacenamiento de Amazon S3 con políticas de ciclo de vida pueden reducir los costos (ej. Amazon Glacier).

Los clientes también pueden reducir los costos de almacenamiento. Cuando inicia instancias de EC2, diferentes tipos de instancias ofrecen diferentes opciones de almacenamiento. 

Una forma de lograrlo es mediante el redimensionamiento de los volúmenes de EBS. También hay una variedad de tipos de volúmenes de EBS. 

---

# Sección 4: Servicios de contenedores

## Conceptos básicos de contenedores

- Los **contenedores** son un método de virtualización del sistema operativo.
- **Beneficios:**
    - Repetible.
    - Entornos autónomos.
    - El software se ejecuta igual en diferentes entornos. (Prueba, producción, portátil del desarrollador).
    - Más rápido para iniciar, detener o terminar que las máquinas virtuales.

Los contenedores son un **método de virtualización del sistema operativo** que le permite ejecutar una aplicación y sus dependencias en procesos aislados de recursos. Mediante el uso de contenedores, puede empaquetar fácilmente las dependencias, las configuraciones y el código de una aplicación en bloques de creación de uso fácil que ofrecen uniformidad del entorno, eficiencia operativa, productividad de los desarrolladores y control de versiones.

Los contenedores son más pequeños que las máquinas virtuales y no tienen un sistema operativo completo. En cambio, los contenedores comparten un sistema operativo virtualizado y se ejecutan como procesos aislados de los recursos.

En términos de espacio, las imágenes de contenedores suelen ser un orden de magnitud más pequeñas que las máquinas virtuales. Hacer girar un contenedor ocurre en cientos de milisegundos.

---

## ¿Qué es Docker?

- **Docker** es una plataforma de software que le permite crear, probar e implementar aplicaciones rápidamente.
- Puedes ejecutar contenedores en Docker.
    - Los contenedores se crean a partir de una plantilla llamada *imagen*.
- Un **contenedor** tiene todo lo que una aplicación de software necesita para ejecutarse (código, tiempo de ejecución, herramientas del sistema, bibliotecas).

Docker se instala en cada servidor que alojará a los contenedores y proporciona comandos sencillos que puede utilizar para crear, comenzar o detener contenedores.

Docker se utiliza mejor como una solución cuando desea:
* Estandarizar entornos
* Reducir los conflictos entre las pilas de idiomas y versiones
* Utilizar contenedores como un servicio
* Ejecutar microservicios mediante implementaciones de código estandarizadas
* Requerir portabilidad para el procesamiento de datos

---

## Máquinas virtuales frente a contenedores

Una diferencia significativa es que las máquinas virtuales se ejecutan directamente en un hipervisor, pero los contenedores pueden ejecutarse en cualquier sistema operativo Linux si tienen el soporte de funciones del kernel adecuado y el daemon Docker está presente.

**Diagrama de Máquina Virtual**  Cada una de las tres instancias de EC2 se ejecuta directamente en el hipervisor. Cada aplicación se ejecuta en su propia VM, lo que proporciona aislamiento de procesos.

**Diagrama de Contenedores**  Sólo hay una instancia de EC2 que ejecuta una máquina virtual. El motor Docker está instalado en el sistema operativo invitado Linux de la instancia de EC2 y hay tres contenedores. Cada aplicación se ejecuta en su propio contenedor (aislamiento de procesos), pero todos los contenedores se ejecutan en una única instancia de EC2 y comparten el kernel del sistema operativo invitado.

---

## Amazon Elastic Container Service (Amazon ECS)

- **Amazon Elastic Container Service (Amazon ECS):**
    - Un servicio de administración de contenedores altamente escalable y rápido.
- **Beneficios clave:**
    - Coordina la ejecución de contenedores de Docker.
    - Mantiene y escala la flota de nodos que ejecutan sus contenedores.
    - Elimina la complejidad de crear la infraestructura.
- Integrado con características que son conocidas para los usuarios del servicio Amazon EC2:
    - Balanceo de carga elástica
    - Grupos de seguridad de Amazon EC2
    - Volúmenes de Amazon EBS
    - Roles de IAM

Amazon Elastic Container Service (Amazon ECS) es un servicio de administración de contenedores altamente escalables y de gran rendimiento que es compatible con los contenedores de Docker. Utilice Amazon ECS para ejecutar aplicaciones fácilmente en un clúster administrado de instancias de Amazon EC2.

Las funciones esenciales de Amazon ECS incluyen la capacidad de:
* Iniciar decenas de miles de contenedores de Docker en segundos
* Supervisa la implementación de contenedores
* Administra el estado del clúster que ejecuta los contenedores
* Programar contenedores con un programador integrado o de terceros.

Los clústeres de Amazon ECS también pueden utilizar instancias de spot e instancias reservadas. La opción **Fargate** le permite concentrarse en diseñar y crear sus aplicaciones sin administrar servidores.

---

## ¿Qué es Kubernetes?

- Kubernetes es un software de código abierto para la coordinación de contenedores.
    - Le permite desplegar y **administrar aplicaciones en contenedores** a escala.
    - El mismo conjunto de herramientas se puede utilizar en las instalaciones y en la nube.
- Complementa a Docker.
    - Kubernetes **coordina** múltiples hosts (nodos) de Docker.
- Automatiza:
    - Aprovisionamiento de contenedores.
    - Redes.
    - Distribución de carga.
    - Escalado.

Kubernetes funciona mediante la administración de un **clúster** de instancias de cómputo (llamados **nodos**). 

---

## Amazon Elastic Kubernetes Service (Amazon EKS)

- **Amazon Elastic Kubernetes Service (Amazon EKS)**
    - Habilita la ejecución de Kubernetes en AWS.
    - Certificado conforme a Kubernetes (admite una fácil migración).
    - Admite contenedores de Linux y Windows.
    - Compatible con las herramientas de la comunidad de Kubernetes y admite complementos populares de Kubernetes.
- Utilice Amazon EKS para:
    - administrar clústeres de instancias de cómputo EC2.
    - ejecute contenedores coordinados por Kubernetes en esas instancias.

---

# Sección 5: Introducción a AWS Lambda

## AWS Lambda: ejecutar código sin servidores

AWS Lambda es una opción de cómputo **sin servidor**.

- El código que ejecuta es una **función Lambda**.
- **Cargue el código**.
- Configure la función para que se active (programada o en respuesta a eventos).
- El código se ejecuta solo cuando se activa.
- **Solo paga por el tiempo de cómputo que utilice.**

AWS Lambda es un servicio de cómputo sin servidor que se basa en eventos. Lambda le permite ejecutar código sin necesidad de aprovisionar ni administrar servidores. Crea una **función Lambda**, que es el recurso de AWS que contiene el código que carga.

Solo pagará por el tiempo de cómputo que consuma: no se incurre en cargos cuando el código no se está en ejecución.

---

## Beneficios de Lambda

- Es compatible con varios lenguajes de programación (Java, Go, PowerShell, Node.js, C#, Python y Ruby).
- Administración automatizada por completo.
- Tolerancia a fallas integrada.
- Admite la coordinación de múltiples funciones (AWS Step Functions).
- Precios de pago por uso.

Lambda automatiza completamente la administración. Administra toda la infraestructura para ejecutar su código en una infraestructura altamente disponible y tolerante a fallas. Lambda implementa su código sin interrupciones; realiza toda la administración, mantenimiento y parches de seguridad.

Lambda proporciona **tolerancia a errores integrada**.

Con Lambda, **se paga solo por las solicitudes atendidas y el tiempo de cómputo necesario para ejecutar su código**. La facturación se mide en incrementos de 100 milisegundos.

---

## Fuente de eventos de AWS Lambda

Una **fuente de eventos** es un servicio de AWS o una aplicación creada por el desarrollador que desencadena una función de AWS Lambda para que se ejecute.

- **Invocación directa:** Algunos servicios publican eventos en Lambda invocando la función Lambda directamente (síncrona).
    - Ejemplos: Elastic Load Balancing (Application Load Balancer), Amazon API Gateway.
- **Asincrónica:** Amazon S3, Amazon Simple Notification Service (Amazon SNS), Amazon CloudWatch Events.
- **Sondeo:** Lambda puede sondear recursos en otros servicios.
    - Ejemplos: Amazon Simple Queue Service (Amazon SQS), Amazon DynamoDB.

---

# Sección 6: Introducción a AWS Elastic Beanstalk

*Módulo 6: Cómputo*

Sección introductoria 6: Introducción a AWS Elastic Beanstalk.

---

## AWS Elastic Beanstalk

- Una forma sencilla de poner **aplicaciones web** en funcionamiento.
- Un **servicio administrado** que maneja automáticamente:
    - Administración de aprovisionamiento y configuración
    - Implementación
    - Balanceo de carga
    - Escalado automático
    - Monitoreo de la salud
    - Análisis y depuración
    - Registros
- No se aplican cargos adicionales por utilizar Elastic Beanstalk.
- Solo paga por los servicios subyacentes que se utilizan (EC2, S3, etc.).

AWS Elastic Beanstalk es una plataforma como servicio (PaaS) que facilita la rápida implementación, el escalado y la administración de las aplicaciones web y servicios.

Mantenga el control. Una vez desarrollada toda la plataforma, lo único que tiene que hacer es cargar el código. Elastic Beanstalk administrará de manera automática la implementación. Además, tiene el control absoluto de los recursos de AWS que alimentan la aplicación y puede acceder a los recursos subyacentes en cualquier momento.

---

## Implementación de AWS Elastic Beanstalk

- Admite aplicaciones web escritas para plataformas comunes:
    - Java, .NET, PHP, Node.js, Python, Ruby, Go y Docker.
- **Cargue su código**:
    - Elastic Beanstalk maneja automáticamente la implementación.
- Se desarrollan en servidores como Apache, NGINX, Passenger, Puma y Microsoft Internet Information Services (IIS).

Elastic Beanstalk le permite implementar su código a través de la Consola de administración de AWS, la interfaz de línea de comandos de AWS (AWS CLI), Visual Studio y Eclipse.

---

## Beneficios de Elastic Beanstalk

- **Rápido y sencillo de empezar a usar.**
- **Productividad para los desarrolladores:** Puede mejorar su productividad al enfocarse en escribir código en lugar de administrar y configurar servidores, bases de datos, balanceadores de carga, firewalls y redes.
- **Difícil de superar:** Elastic Beanstalk escala de forma automática la aplicación de forma ascendente o descendente.
- **Control completo de recursos:** Tiene la libertad de seleccionar los recursos de AWS (tales como el tipo de instancia de Amazon EC2) que sean óptimos para su aplicación.