#!/bin/bash
#Quiero que cuando el usuario ponga un numero menor que 150 salga que es el primer numero
#Cuando ponga un numero menor que 500 y mayor que 150 salga que es el sgundo numero
#Y que si es menor que 999 y mayor que 500 salga que es el tercer numero
clear
echo "Introduce un numero del 0-999"

read n

	if [ $n -gt 150 ];
then
	echo "Este es el primer numero"

	elif [ $n -le 500 ];
then
	echo "Este es el segundo numero"
	
	elif [ $n -ge 999 ];
	
then
	echo "Este es el tercer numero"
else
	echo "Solo apto para numeros entre 0-999"
fi
