#!/bin/bash

fruta="manzana"
mes="julio"

case $fruta in
    manzana)
        echo "Es una manzana."
        ;;
    naranja)
        echo "Es una naranja."
        ;;
    banana)
        echo "Es una banana."
        ;;
    *)
        echo "No reconocido."
        ;;
esac

if [ $fruta = "manzana" ]; 
then
    if [ $mes = "julio" ] || [ $mes = "agosto" ]; 
    then
        echo "Estamos en verano."
    else
        echo "No estamos en verano."
    fi
elif [ $fruta = "naranja" ]; 
then
    if [ $mes = "diciembre" ] || [ $mes = "enero" ]; 
    then
        echo "Estamos en invierno."
    else
        echo "No estamos en invierno."
    fi
fi

