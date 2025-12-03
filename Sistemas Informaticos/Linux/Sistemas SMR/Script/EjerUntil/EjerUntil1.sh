#!/bin/bash


#Solicita al usuario que ingrese un número mayor que 10. Si el número ingresado es igual a 10 o menor que 10
#El script proporciona retroalimentación y solicita al usuario que ingrese un número válido. 
#Si el valor ingresado no es numérico, se muestra un mensaje de error. 
#El script continuará solicitando al usuario que ingrese un número mayor que 10 hasta que se ingrese un número válido. 
#Una vez que se ingresa un número válido, el script muestra un mensaje de agradecimiento junto con el número ingresado.

# Solicitar al usuario que ingrese un número mayor que 10
echo "Ingrese un número mayor que 10:"
read numero

# Utilizar un bucle until para verificar si el número es válido
until [ $numero -gt 10 ]
do
    if [ $numero -eq 10 ]; 
    then
        echo "El número ingresado es igual a 10. Por favor, ingrese un número mayor."
    elif [ $numero -lt 10 ]; 
    then
        echo "El número ingresado es menor que 10. Por favor, ingrese un número mayor."
    else
        echo "Error: Ha ingresado un valor no numérico. Por favor, ingrese un número mayor que 10."
    fi

    read numero
done

echo "¡Gracias! Has ingresado un número mayor que 10: $numero"

