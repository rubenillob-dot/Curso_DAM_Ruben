#!/bin/bash


#Define una función llamada saludar() que muestra un mensaje de bienvenida adaptado según la hora del día. 
#Utiliza la hora actual del sistema para determinar si es por la mañana, tarde o noche, y muestra un mensaje apropiado en consecuencia.
#Finalmente, llama a la función para imprimir el mensaje de bienvenida en función de la hora actual del sistema.

saludar() {
    hora=$(date +"%H")  #Obtiene la hora actual

    if [ "$hora" -ge 6 ] && [ "$hora" -lt 12 ]; 
    then
        echo "¡Buenos días! Bienvenido a mi script."
    elif [ "$hora" -ge 12 ] && [ "$hora" -lt 18 ]; 
    then
        echo "¡Buenas tardes! Bienvenido a mi script."
    else
        echo "¡Buenas noches! Bienvenido a mi script."
    fi
}


saludar

