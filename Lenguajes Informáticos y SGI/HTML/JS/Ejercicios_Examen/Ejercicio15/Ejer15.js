const boton = document.getElementById("btn-calcular");
const divResultado = document.getElementById("resultado");

boton.addEventListener("click", function() {
    // Leemos los valores
    // 'parseFloat' convierte el texto a un número con decimales
    const monto = parseFloat(document.getElementById("monto").value);
    const porcentaje = parseFloat(document.getElementById("porcentaje").value);

    // Calculamos la propina
    const propina = monto * porcentaje;
    const total = monto + propina;

    // Escribimos el texto en el div
    divResultado.textContent = "Total a pagar: " + total + "€ (Propina: " + propina + "€)";

    // ¡La magia del CSS en JS! Cambiamos el borde y el padding
    divResultado.style.border = "3px solid orange";
    divResultado.style.padding = "20px";
    divResultado.style.backgroundColor = "#fff3e0";
});