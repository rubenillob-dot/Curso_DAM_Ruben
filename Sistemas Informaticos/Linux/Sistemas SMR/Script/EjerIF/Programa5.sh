#!/bin/bash

# Pedimos al usuario que ingrese su edad
read -p "Por favor, ingresa tu edad: " edad

# Utilizamos la estructura condicional if para evaluar la edad ingresada
if [ "$edad" -ge 18 ]; then
    echo "Eres mayor de edad"
else
    echo "Eres menor de edad"
fi

