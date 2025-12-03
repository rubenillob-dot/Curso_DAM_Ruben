#!/bin/bash
clear
echo "1 Suma"
echo "2 Resta"
echo "3 Cuadrado"
echo "Elige una opción 1, 2 o 3"
read -n 1 opcion

echo 
if [ "$opcion" = "1"]
then
	echo "Has elegido la opción suma"
	read -p "Introduce un número " num1
	read -p "Introduce otro número " num2
	resultado=(($num1 + $num2))
	echo "$num1 + $num2 = $resultado"

elif [ "$opcion" = "2" ]
then
echo "Has elegido la opción resta"
	read -p "Introduce un número " num1
	read -p "Introduce otro número " num2
	resultado=(($num1 - $num2))
	echo "$num1 -$num2 = $resultado"
elif [ "$opcion" = "3 ]
then
echo "Has elegido la opción Cuadrado"
	read -p "Introduce un número " num1
	read -p "Introduce otro número " num2
	resultado=(($num1 * $num2))
	echo "$num1*$num2 = $resultado"
	
fi
