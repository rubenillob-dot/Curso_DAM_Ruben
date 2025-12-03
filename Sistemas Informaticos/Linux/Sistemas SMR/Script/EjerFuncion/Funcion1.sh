#!/bin/bash

#Si el saludo es "Buenos días", responde con un mensaje apropiado para ese momento del día. 
#Si el saludo es "Buenas tardes", responde de acuerdo a ese saludo, y lo mismo para "Buenas noches". 
#Si el saludo no coincide con ninguno de estos, 
#muestra un mensaje indicando que no pudo reconocer el saludo.


saludar() {
    if [ "$1" = "Buenos días" ]; 
    then
        echo "¡Buenos días! "
    elif [ "$1" = "Buenas tardes" ]; 
    then
        echo "¡Buenas tardes! "
    elif [ "$1" = "Buenas noches" ]; 
    then
        echo "¡Buenas noches!"
    else
        echo "No reconocí el saludo."
    fi
}

saludar "Buenos días"
saludar "Buenas tardes"
saludar "Buenas noches"
saludar "Hola"


