const buscador = document.getElementById("buscador");
// Pillamos todos los li que tienen la clase 'item'
const elementos = document.querySelectorAll(".item");

// El evento "input" se dispara cada vez que pulsas una tecla 
buscador.addEventListener("input", function() {
    // Pasamos lo escrito a minúsculas para que no haya fallos con mayúsculas
    const textoBuscado = buscador.value.toLowerCase();

    // Repasamos la lista elemento por elemento
    for (let i = 0; i < elementos.length; i++) {
        const peli = elementos[i];
        const textoPeli = peli.textContent.toLowerCase();

        // Preguntamos: ¿El texto de la peli INCLUYE lo que he escrito?
        if (textoPeli.includes(textoBuscado)) {
            // Si coincide, le quitamos la clase oculto para que se vea
            peli.classList.remove("oculto");
        } else {
            // Si no coincide, le ponemos la etiqueta 'oculto' para esconderlo 
            peli.classList.add("oculto");
        }
    }
});