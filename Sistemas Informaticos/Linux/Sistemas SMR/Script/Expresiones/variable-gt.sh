#!/bin/bash
clear

echo "ingresa un numero" 
read num

if [ $num -gt 10 ];

then 
	echo "El numero es mayor que 10"
else
	echo "El numero es menor que 10"
fi
