#!/bin/bash
clear

read -p "Ingresa un número: " numero

if [ $numero -lt 150 ]; 
then
    echo "Es el primer número."
elif [ $numero -lt 500 ]; 
then
    echo "Es el segundo número."
elif [ $numero -lt 999 ]; 
then
    echo "Es el tercer número."
else
    echo "El número es mayor o igual a 999."
fi

