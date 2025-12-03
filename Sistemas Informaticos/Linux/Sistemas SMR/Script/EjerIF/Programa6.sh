#permite al usuario ingresar su edad y maneja el caso en que el usuario no ingresa nada 
# o ingresa un valor no numérico:

#!/bin/bash

# Función para verificar si la entrada es un número
es_numero() {
   
    # Verifica si la entrada es un número
    # Devuelve 0 si es un número, 1 si no lo es
   
    re='^[0-9]+$'
    if [[ $1 =~ $re ]]; then
        return 0
    else
        return 1
    fi
}

# Pedimos al usuario que ingrese su edad
while true; do
    read -p "Por favor, ingresa tu edad: " edad

    # Verificamos si la entrada es un número
    if es_numero "$edad"; then
        break
    else
        echo "Error: Debes ingresar un valor numérico."
    fi
done

# Utilizamos la estructura condicional if para evaluar la edad ingresada
if [ "$edad" -ge 18 ]; then
    echo "Eres mayor de edad"
else
    echo "Eres menor de edad"
fi

