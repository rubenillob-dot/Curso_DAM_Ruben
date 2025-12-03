#vamos a pedir al usuario que elija una operacion mostrando un menu
#1 suma
#2 resta
#3 cuadrado

#si elige sumar o restar tiene que pedir al usuario dos numeros
#si elige cuadradopide solo un numero

#!/bin/bash
#clear
echo "1 suma"
echo "2 resta"
echo "3 cuadrado"

read -n 1 -p "Elige una opcion 1, 2 o 3 " opcion
echo
if [ "$opcion" = "1" ]
then
	
	read -p "Primer numero" num1
	read -p "Segundo numero " num2
	echo "$num1 + $num2 = "$((num1+$num2))
	
elif [ "$option" = "2" ]
then
	read -p "Primer numero " num1
	read -p "Segundo numero " num2
	echo "$num1 + $num2 = "$(($num1-$num2))
	
elif [ "$option" = "3" ]
then
	read -p "Numero " num
	echo "El cuadrado de $num = "$(($num*$num))

else 
	echo "Error"
fi


