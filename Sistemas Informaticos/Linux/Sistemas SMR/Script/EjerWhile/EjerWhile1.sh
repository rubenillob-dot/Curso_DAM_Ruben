#!/bin/bash


#Vamos a escribir un script en Bash que simula un juego de adivinanzas. 
#El script generará un número aleatorio entre 1 y 100, y pedirá al usuario que lo adivine. 
#Proporcionará pistas de si el número a adivinar es mayor o menor que el intento del usuario, 
#y seguirá pidiendo intentos hasta que el usuario adivine correctamente el número.

# Generar un número aleatorio entre 1 y 100
numero_aleatorio=$(( ( RANDOM % 100 ) + 1 ))

# Definir la función para jugar
jugar() {
    objetivo=$1
    intento=0
    
    while true; 
    do
        read -p "Introduce un número entre 1 y 100: " respuesta
        intento=$((intento+1))

        if [[ $respuesta -eq $objetivo ]]; 
        then
            echo "¡Felicidades! Adivinaste el número en $intento intentos."
            break
        elif [[ $respuesta -lt $objetivo ]];
        then
            echo "El número es mayor."
        else
            echo "El número es menor."
        fi
    done
}

# Iniciar el juego
echo "¡Bienvenido al juego de adivinanzas!"
jugar $numero_aleatorio

