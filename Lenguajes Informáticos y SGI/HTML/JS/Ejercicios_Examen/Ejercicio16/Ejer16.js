// Función para subir
function moverArriba(boton) {
    // El 'padre' del botón es el <li>
    const elementoLi = boton.parentElement;
    // Buscamos al hermano que está justo arriba
    const hermanoAnterior = elementoLi.previousElementSibling;

    // Si hay un hermano arriba, nos metemos ANTES que él
    if (hermanoAnterior) {
        elementoLi.parentElement.insertBefore(elementoLi, hermanoAnterior);
    }
}

// Función para bajar
function moverAbajo(boton) {
    const elementoLi = boton.parentElement;
    // Buscamos al hermano que está justo debajo
    const hermanoSiguiente = elementoLi.nextElementSibling;

    // Si hay un hermano abajo, nos metemos DESPUÉS de él.
    // (En JS no hay 'insertAfter', así que insertamos ANTES del hermano que le sigue al siguiente)
    if (hermanoSiguiente) {
        elementoLi.parentElement.insertBefore(elementoLi, hermanoSiguiente.nextElementSibling);
    }
}