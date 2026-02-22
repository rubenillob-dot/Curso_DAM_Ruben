const panel = document.getElementById("panel-notificaciones");

function mostrarNotificacion(tipo) {
    // Creamos la caja
    const nota = document.createElement("div");
    nota.classList.add("notificacion");
    nota.classList.add(tipo); // Le pone la clase 'exito', 'error' o 'info' [cite: 101]

    // Le ponemos el texto según el botón pulsado
    if (tipo === "exito") nota.textContent = "¡Todo salió perfecto!";
    if (tipo === "error") nota.textContent = "¡Hubo un problema fatal!";
    if (tipo === "info") nota.textContent = "Te informo de algo importante.";

    // Lo pegamos en la esquina
    panel.appendChild(nota);

    // Activamos un temporizador. A los 3000 milisegundos (3s), se borra.
    setTimeout(function() {
        nota.remove();
    }, 3000);
}