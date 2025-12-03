#!/bin/bash


#Determina el tipo de fruta y, dependiendo del tipo y del mes, imprime un mensaje correspondiente, como "Estamos en verano" o "Estamos en invierno".

fruta="manzana"
mes="julio"

case $fruta in
    manzana)
        echo "Es una manzana."
        if [ $mes = "julio" ] || [ $mes = "agosto" ]; 
        then
            echo "Estamos en verano."
        else
            echo "No estamos en verano."
        fi
        ;;
    naranja)
        echo "Es una naranja."
        if [ $mes = "diciembre" ] || [ $mes = "enero" ]; 
        then
            echo "Estamos en invierno."
        else
            echo "No estamos en invierno."
        fi
        ;;
    banana)
        echo "Es una banana."
        ;;
    *)
        echo "No reconocido."
        ;;
esac

