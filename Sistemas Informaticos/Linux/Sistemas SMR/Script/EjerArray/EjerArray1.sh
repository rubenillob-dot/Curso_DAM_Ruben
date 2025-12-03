#!/bin/bash

#Define una cadena de texto llamada nombres que contiene una lista de nombres separados por comas: "Juan,María,Pedro,Ana".

nombres="Juan,María,Pedro,Ana"
IFS=',' read -ra array <<< "$nombres"

# Imprimir cada nombre en una línea
for nombre in "${array[@]}"; do
    echo "$nombre"
done

