
function script() {
    const MAX_GERATED = 5;

    for (let i = 0; i < MAX_GERATED; i++) {
        let contenedor = document.createElement('div');
        contenedor.classList.add('contenedor');
        let boton = document.createElement('button');
        boton.textContent = 'Cerrar';
        boton.onclick = function () {
            Eliminar(this);
        };
        let imagen = document.createElement('img');
        imagen.classList.add('imagen');
        imagen.src = 'https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcSCVSPUdz3daPKic-eORjl2Vdj_txXc4ceUkw&s';
        imagen.alt = 'Imagen'
        let titulo = document.createElement('h2');
        titulo.textContent = 'Elemento'
        let precio = document.createElement('p');
        precio.innerHTML = '100€'

        contenedor.append(boton, titulo, imagen, precio);

        let padre = document.getElementById('contenedorPadre');
        padre.append(contenedor);
    }


}

function Eliminar(elementoPulsado) {
    elementoPulsado.parentElement.remove();
}
