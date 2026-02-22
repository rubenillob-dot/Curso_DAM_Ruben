
function seleccionar(elementoPulsado) {
    /* elementoPulsado.classList.toggle('parrafos'); */

    elementoPulsado.innerHTML = '<mark>' + elementoPulsado.textContent + '</mark>';
    if (elementoPulsado.innerHTML.includes("<mark>")) {

        let contenido = elementoPulsado.textContent;
        let estructuraCompleta = document.createElement('p');
        estructuraCompleta.textContent = contenido;
        elementoPulsado.replaceChild(elementoPulsado, estructuraCompleta);

    }
}
