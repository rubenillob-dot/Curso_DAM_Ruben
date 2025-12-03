#!/bin/bash

# Función para verificar si la entrada es un número
numero() {
    
    local solo='^[0-9]+$'
    if ! [[ $1 =~ $solo ]] ; 
    then
        return 1
    else
        return 0
    fi
}

# Solicitar al usuario que ingrese el primer número
while true; 
do
    echo "Ingrese el primer número:"
    read num1
    if numero "$num1"; 
    then
        break
    else
        echo "Error: '$num1' no es un número válido. Inténtelo de nuevo."
    fi
done


while true; 
do
    echo "Ingrese el segundo número:"
    read num2
    if numero "$num2"; 
    then
        break
    else
        echo "Error: '$num2' no es un número válido. Inténtelo de nuevo."
    fi
done

# Comprobar cuál de los dos números es el más pequeño

if [ "$num1" -lt "$num2" ]; 
then
    echo "El número más pequeño es: $num1"

elif [ "$num2" -lt "$num1" ]; 
then
    echo "El número más pequeño es: $num2"
else
    echo "Los números son iguales."
fi

