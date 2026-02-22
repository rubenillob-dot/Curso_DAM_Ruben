const boton = document.getElementById("btn-generar");
const contenedor = document.getElementById("contenedor-avatar");

boton.addEventListener("click", function () {
    // Limpiamos avatares anteriores
    contenedor.innerHTML = "";

    const nombreCompleto = document.getElementById("nombre").value;
    // Cortamos el nombre por los espacios (ej: ["Harry", "Potter"])
    const partes = nombreCompleto.split(" ");

    let iniciales = "";
    // Cogemos la primera letra de la primera palabra
    if (partes[0]) {
        iniciales += partes[0][0]; // Toma la letra 0 de la palabra 0
    }
    // Cogemos la primera letra de la segunda palabra (si existe)
    if (partes[1]) {
        iniciales += partes[1][0];
    }

    // Generamos colores al azar de 0 a 255
    const rojo = Math.floor(Math.random() * 256);
    const verde = Math.floor(Math.random() * 256);
    const azul = Math.floor(Math.random() * 256);

    // Creamos el div circular
    const divAvatar = document.createElement("div");
    divAvatar.classList.add("avatar"); // Le ponemos el diseño CSS
    divAvatar.textContent = iniciales.toUpperCase(); // Iniciales en mayúscula

    // Le aplicamos el color al azar
    divAvatar.style.backgroundColor = "rgb(" + rojo + "," + verde + "," + azul + ")";

    // Lo mostramos
    contenedor.appendChild(divAvatar);
});