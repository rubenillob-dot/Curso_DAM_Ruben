#Vamos a pedir al usuario que elija una operación mostrando un menú
#1 Suma
#2 Resta
#3 Cuadrado

#Si elige sumar o restar tiene que pedir al usuario dos números
#Si elige cuadrado pide solo un número


#!/bin/bash
clear
echo "1 Suma"
echo "2 Resta"
echo "3 Cuadrado"
echo "Elige una opción 1, 2 o 3"
read -n 1 opcion
#la palabra opción en esta línea es la variable y el 1 el número de elecciones
echo
if [ "$opcion" = "1" ]
then
	clear
	echo "Has elegido la opción suma"
	read -p "Introduce un número " num1
	read -p "Introduce otro número " num2
	resultado=$(($num1+$num2))
	echo "$num1 + $num2 = $resultado"
elif [ "$opcion" = "2" ]
then
	clear
	echo "Has elegido la opción resta"
	read -p "Introduce un número " num1
	read -p "Introduce otro número " num2
	resultado=$(($num1-$num2))
	echo "$num1 - $num2 = $resultado"
elif [ "$opcion" = "3" ]
then
	clear
	echo "Has elegido la opción cuadrado"
	read -p "Introduce un número " num1
	resultado=$(($num1*$num1))
	echo "$num1 elevado a 2 = $resultado"
else
	echo "Opción incorrecta"
fi

