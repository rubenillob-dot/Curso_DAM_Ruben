#!/bin/bash

# Usando un if-elif-else
numero=15

if [ $numero -gt 20 ]; 
then
    echo "El número es mayor que 20."
elif [ $numero -lt 10 ]; 
then
    echo "El número es menor que 10."
else
    echo "El número está entre 10 y 20."
fi

