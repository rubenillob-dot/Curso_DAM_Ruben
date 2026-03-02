# Script de Linux


### 📖 Diccionario de Símbolos

1. **`$1`, `$2`, `$3`**: Son **argumentos**. Imagina que el script es una función de cocina.
    - Si escribes en la terminal: `./script.sh Harina Huevo`
    - `$1` vale "Harina".
    - `$2` vale "Huevo".
2. **`$(( ... ))`**: Es la **calculadora**.
    - Bash no sabe sumar por sí mismo. Si pones `2+2`, te escribe "2+2".
    - Si pones `$(( 2+2 ))`, te escribe "4".
3. **`$( ... )`** (Paréntesis con dólar delante): Es **ejecutar y guardar**.
    - Significa: "Ejecuta el comando de dentro y el resultado guárdamelo aquí".
    - Ejemplo: `hoy=$(date)` (Guarda la fecha en la variable `hoy`).
4. **`|` (La tubería o Pipe)**: **Pasar la pelota**.
    - Pasa el resultado del comando de la izquierda al comando de la derecha.
    - `cat archivo | grep hola`: "Lee el archivo Y PÁSALE el texto a grep para que busque 'hola'".

---

## 1. Funciones (La receta de cocina)

**Objetivo:** Crear una pequeña "fórmula" para sumar y usarla después.

**Simplificación: N**os centramos en que `$1` y `$2` son los números que le enviamos a la función.

```bash
#!/bin/bash

# 1. Definimos la función (la receta)
suma(){
    # Sumamos el primer número ($1) con el segundo ($2)
    echo $(( $1 + $2 ))
}

# 2. Usamos la función
# Le enviamos 10 y 5. La función los recibe como $1 y $2.
resultado=$(suma 10 5)

echo "El resultado de la suma es: $resultado"

```

---

## 2. Conversor Decimal a Binario

**Objetivo:** Dividir un número entre 2 todo el rato hasta que no se pueda más.

```bash
#!/bin/bash

read -p "Dime un número: " numero

# Creamos una variable vacía para guardar el resultado final
binario=""

# Bucle: MIENTRAS el número sea mayor que 0
while [ $numero -gt 0 ]; do

    # 1. Calculamos el resto (será 0 o 1)
    resto=$(( numero % 2 ))

    # 2. Pegamos el resto al principio de nuestro resultado
    binario="$resto$binario"

    # 3. Dividimos el número entre 2 para la siguiente vuelta
    numero=$(( numero / 2 ))
done

echo "En binario es: $binario"

```

---

## 3. El Cajero (Lógica simple)

**Objetivo:** Dar billetes. La lógica original era muy repetitiva.

**Explicación:** Solo tienes que entender que el ordenador hace divisiones enteras. Si tienes 250 y divides entre 100, da **2** (y sobran 50).

```bash
#!/bin/bash
read -p "Cantidad de dinero: " dinero

# Comprobamos si termina en 0 (es divisible por 10)
if [ $(( dinero % 10 )) -eq 0 ]; then

    # Calculamos billetes de 100
    b100=$(( dinero / 100 ))
    # Actualizamos el dinero quitando lo que ya hemos dado en billetes de 100
    dinero=$(( dinero % 100 ))

    # Calculamos billetes de 50 con lo que sobra
    b50=$(( dinero / 50 ))
    dinero=$(( dinero % 50 ))

    # Calculamos billetes de 20
    b20=$(( dinero / 20 ))
    dinero=$(( dinero % 20 ))

    # Calculamos billetes de 10
    b10=$(( dinero / 10 ))

    echo "Billetes de 100: $b100"
    echo "Billetes de 50:  $b50"
    echo "Billetes de 20:  $b20"
    echo "Billetes de 10:  $b10"

else
    echo "Error: La cantidad debe ser múltiplo de 10 (ej: 20, 50, 100)"
fi

```

---

## 4 y 5. Crear/Borrar Usuarios (Bucles fáciles)

**Objetivo:** Crear varios usuarios de golpe (usuario1, usuario2...).
**Estructura rara explicada:** `for i in {1..5}`. Esto significa "Haz esto 5 veces, y en cada vuelta la variable `i` valdrá 1, luego 2, luego 3...".

```bash
#!/bin/bash

nombre_base=$1   # El primer argumento será el nombre (ej: pepe)
cantidad=$2      # El segundo será cuántos queremos (ej: 3)

# Comprobamos si nos han dado los dos datos
if [ $# -eq 2 ]; then

    # Bucle: Desde 1 hasta la cantidad que nos digan
    # seq 1 $cantidad genera una lista: 1 2 3...
    for i in $(seq 1 $cantidad)
    do
        # Creamos el nombre completo (ej: pepe1)
        usuario_nuevo="$nombre_base$i"

        echo "Creando usuario: $usuario_nuevo"

        # Comando de sistema para crear usuario
        sudo useradd -m $usuario_nuevo

        # Comando para ponerle contraseña (la misma que el nombre)
        echo "$usuario_nuevo:$usuario_nuevo" | sudo chpasswd
    done

else
    echo "Uso: ./script.sh [nombre] [cantidad]"
fi

```

---

## 6. Comparar 3 números (Sin líos)

**Objetivo:** Saber cuál es el mayor.
**Simplificación:** En lugar de poner un `if` dentro de otro `if` , usamos `&&` (Y).

```bash
#!/bin/bash
# Leemos los 3 números de golpe
read -p "Dime 3 números separados por espacio: " n1 n2 n3

# Opción A: El 1 es el mayor si gana al 2 Y gana al 3
if [[ $n1 -ge $n2 && $n1 -ge $n3 ]]; then
    echo "El mayor es $n1"

# Opción B: El 2 es el mayor si gana al 1 Y gana al 3
elif [[ $n2 -ge $n1 && $n2 -ge $n3 ]]; then
    echo "El mayor es $n2"

# Opción C: Si no es ninguno de los anteriores, es el 3
else
    echo "El mayor es $n3"
fi

```

---

## 8. Contar Usuarios "Humanos" (Filtros)

**Objetivo:** Leer un archivo de sistema y contar cosas.
**Estructura rara explicada:**

1. `cat /etc/passwd`: Muestra el archivo de usuarios.
2. `cut -d":" -f3`: Imagina que cada línea se corta por los dos puntos `:`. `f3` dice "quédate con el tercer trozo" (que es el ID del usuario).

```bash
#!/bin/bash

contador=0

# $( ... ) ejecuta el comando y el bucle recorre el resultado línea a línea
for id in $(cat /etc/passwd | cut -d":" -f3)
do
    # Los usuarios reales suelen tener ID mayor o igual a 1000
    if [ $id -ge 1000 ]; then
        # Truco para sumar 1 al contador
        ((contador++))
    fi
done

echo "Hay $contador usuarios humanos en el sistema."

```

---

## 10. Saludo según la hora

**Objetivo:** Decir buenos días/tardes.
**Simplificación:** Uso de `date +%H` que nos da solo la hora (09, 14, 20...).

```bash
#!/bin/bash

# Sacamos la hora actual
hora=$(date +%H)

# Si es menor de las 12
if [ $hora -lt 12 ]; then
    echo "Buenos días"

# Si es mayor o igual a 12 Y menor de las 20
elif [[ $hora -ge 12 && $hora -lt 20 ]]; then
    echo "Buenas tardes"

# Si no, es de noche
else
    echo "Buenas noches"
fi

```

---

## 12. Bucles (Loop)

**Objetivo:** Repetir una acción.
**Simplificación:** Olvídate del estilo C (`for (( i=0...))`) si te lía. Usa el estilo de rangos `{inicio..fin}`.

```bash
#!/bin/bash

echo "Forma fácil de contar del 1 al 10:"

# Esto expande los números del 1 al 10 automáticamente
for numero in {1..10}
do
    echo "Voy por el número $numero"
done

```

---

## 15. Backup (Copias de seguridad)

**Objetivo:** Comprimir una carpeta.
**Estructura rara explicada:** `tar`. Es el "WinZip" de Linux.

- `c`: **C**rear archivo.
- `z`: Comprimir (**Z**ip).
- `f`: **F**ile (indicar el nombre del archivo).

```bash
#!/bin/bash

# Creamos una variable con la fecha de hoy pegada (ej: 20231025)
fecha=$(date +%Y%m%d)

echo "Haciendo copia de seguridad..."

# tar czf [NOMBRE_SALIDA] [CARPETA_A_COPIAR]
# $HOME suele ser /home/tu_usuario
tar czf "copia_$fecha.tar.gz" "$HOME/Escritorio"

echo "Copia terminada."

```
