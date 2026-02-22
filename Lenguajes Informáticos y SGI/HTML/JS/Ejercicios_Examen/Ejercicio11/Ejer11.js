function script() {
    document.body.classList.toggle('cambioColor');
    let boton = document.querySelectorAll('button');

    boton.forEach(b => {
        b.classList.toggle('cambioColor');
    });

}