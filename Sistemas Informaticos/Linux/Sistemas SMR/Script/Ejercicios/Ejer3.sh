#!/bin/bash

# Verificar si se proporcionó un argumento
if [ $# -eq 0 ]; 
then
    echo "Error: Se requiere un argumento (nombre de archivo)"
    exit 1
fi

# Almacenar el nombre del archivo en una variable
archivo="$1"

# Verificar si el archivo existe
if [ ! -e "$archivo" ]; 
then
    echo "El archivo \"$archivo\" no existe."
    exit 1
fi

# Verificar si el archivo es legible
if [ -r "$archivo" ]; 
then
    echo "El archivo \"$archivo\" se puede ver."
else
    echo "El archivo \"$archivo\" no se puede ver."
fi

# Verificar si el archivo es modificable
if [ -w "$archivo" ]; 
then
    echo "El archivo \"$archivo\" se puede modificar."
else
    echo "El archivo \"$archivo\" no se puede modificar."
fi

# Verificar si el archivo es ejecutable
if [ -x "$archivo" ]; 
then
    echo "El archivo \"$archivo\" se puede ejecutar."
else
    echo "El archivo \"$archivo\" no se puede ejecutar."
fi

