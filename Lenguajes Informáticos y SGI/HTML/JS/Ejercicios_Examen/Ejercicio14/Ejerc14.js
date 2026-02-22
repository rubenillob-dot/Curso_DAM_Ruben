// Localizamos el botón y donde vamos a pintar el CV
const botonCrear = document.getElementById("btn-crear");
const contenedorCV = document.getElementById("cv-resultado");

botonCrear.addEventListener("click", function () {
    // 1. Limpiamos el contenedor por si ya había un CV antes
    contenedorCV.innerHTML = "";

    // 2. Leemos lo que el usuario ha escrito
    const nombreVal = document.getElementById("nombre").value;
    const profesionVal = document.getElementById("profesion").value;
    const expVal = document.getElementById("experiencia").value;
    const habVal = document.getElementById("habilidades").value;

    // 3. Fabricamos las etiquetas HTML
    const h1 = document.createElement("h1");
    h1.textContent = nombreVal;

    const h2 = document.createElement("h2");
    h2.textContent = profesionVal;

    const p = document.createElement("p");
    p.textContent = "Experiencia: " + expVal;

    const ul = document.createElement("ul");
    // Separamos las habilidades por la coma y creamos un 'li' para cada una
    const arrayHabilidades = habVal.split(",");
   
    for (let i = 0; i < arrayHabilidades.length; i++) {
        const li = document.createElement("li");
        li.textContent = arrayHabilidades[i];
        ul.appendChild(li); // Metemos el punto en la lista
    }

    // 4. Pegamos todo en la página
    contenedorCV.appendChild(h1);
    contenedorCV.appendChild(h2);
    contenedorCV.appendChild(p);
    contenedorCV.appendChild(ul);
});