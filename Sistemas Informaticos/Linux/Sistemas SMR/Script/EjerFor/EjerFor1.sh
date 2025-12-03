#!/bin/bash

#La variable frutas contiene una lista de nombres de frutas separados por espacios.
#El bucle for itera sobre cada elemento de la lista frutas, 
#almacenando cada elemento en la variable fruta.
#Dentro del bucle, la estructura condicional if verifica si la fruta es igual a "plátano". 
#Si lo es, imprime un mensaje indicando que te gusta esa fruta. 
#Si no, imprime un mensaje indicando que no te gusta esa fruta.



frutas="manzana pera plátano melon sandía naranja"


for fruta in $frutas; 

do
    
    if [ "$fruta" = "plátano" ]; 
    then
        echo "¡Me gusta el $fruta!"
    else
        echo "No me gusta la $fruta."
    fi
done

