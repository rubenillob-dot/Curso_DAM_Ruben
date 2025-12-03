#!/bin/bash

archivo="Lista.txt"

# Función para añadir un registro
anadir_registro() {
    echo "Ingrese el nombre:"
    read nombre
    echo "Ingrese la dirección:"
    read direccion
    echo "Ingrese el teléfono:"
    read telefono
    echo "$nombre:$direccion:$telefono" >> "$archivo"
    echo "Registro añadido correctamente."
}

# Función para buscar entradas por nombre, dirección o teléfono
buscar_entradas() {
    echo "Ingrese el término a buscar:"
    read termino
    grep -i "$termino" "$archivo"
}

# Función para listar todo el archivo
listar_archivo() {
    cat "$archivo"
}

# Función para ordenar los registros alfabéticamente
ordenar_registros() {
    sort -o "$archivo" "$archivo"
    echo "Registros ordenados alfabéticamente."
}

# Función para borrar un registro
borrar_registro() {
    echo "Ingrese el nombre, dirección o teléfono del registro a borrar:"
    read busqueda
    sed -i "/$busqueda/d" "$archivo"
    echo "Registro borrado correctamente."
}

# Menú principal
while true; do
    options=("Añadir" "Buscar" "Listar" "Ordenar" "Borrar" "Salir")
    echo "Menú:"
    select opt in "${options[@]}"; do
        case $REPLY in
            1) anadir_registro; break ;;
            2) buscar_entradas; break ;;
            3) listar_archivo; break ;;
            4) ordenar_registros; break ;;
            5) borrar_registro; break ;;
            6) echo "¡Hasta luego!"; exit ;;
            *) echo "Opción inválida. Inténtelo de nuevo." ;;
        esac
    done
done

