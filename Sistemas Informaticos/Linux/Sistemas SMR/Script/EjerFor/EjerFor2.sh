#!/bin/bash

#El bucle for itera sobre cada elemento de la lista paises, 
#almacenando cada nombre de país en la variable pais.
#Dentro del bucle, la estructura condicional if verifica si el país es España, Francia, Alemania o 
#Italia 
#utilizando la declaración elif.
#Si el país coincide con alguno de los nombres especificados, 
#se imprime un mensaje indicando la capital correspondiente.
#Si el país no coincide con ninguno de los nombres especificados, 
#se imprime un mensaje indicando que no se encontró la capital para ese país.


paises="España Francia Alemania Italia"


for pais in $paises; 
do
    
    if [ "$pais" = "España" ]; 
    then
        echo "La capital de $pais es Madrid."
    
    	elif [ "$pais" = "Francia" ]; then
        	echo "La capital de $pais es París."
   	
   	elif [ "$pais" = "Alemania" ]; then
        	echo "La capital de $pais es Berlín."
    
    	elif [ "$pais" = "Italia" ]; then
        echo "La capital de $pais es Roma."
    
    else
        echo "No se encontró la capital para $pais."
    fi
done

