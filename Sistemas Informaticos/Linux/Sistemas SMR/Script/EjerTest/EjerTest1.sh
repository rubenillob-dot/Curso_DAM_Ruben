#!/bin/bash


#Este script primero verifica si el archivo "archivo.txt" existe en el directorio actual utilizando test -e. 
#Si el archivo existe, imprime un mensaje indicando que el archivo existe. 
#Luego, verifica si el archivo es un archivo regular utilizando test -f. 
#Si el archivo existe y es un archivo regular, imprime un mensaje adicional indicando que el archivo es un archivo regular. 
#Si el archivo no existe o no es un archivo regular, se imprime un mensaje correspondiente.



# Comprobar si el archivo existe
if test -e "archivo.txt"; 
then
    echo "El archivo 'archivo.txt' existe."
else
    echo "El archivo 'archivo.txt' no existe."
fi

# Comprobar si el archivo existe y es un archivo regular
if test -f "archivo.txt"; 
then
    echo "El archivo 'archivo.txt' existe y es un archivo regular."
else
    echo "El archivo 'archivo.txt' no existe o no es un archivo regular."
fi

