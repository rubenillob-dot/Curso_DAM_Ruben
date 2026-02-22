// Recordamos que las constanyes no cambian el valor
// Lo que hacemos es retornar el elmento "centrado" como un objeto
const centrado = document.getElementById('centrado');
// Recordemos que esto es para imprimirlo por pantalla
//innerHTML es el contenido que esta dentro del elemento es decir dentro del div
console.log(centrado.innerHTML);


// Seleccionar todo de una misma clase "texto"
// Textos es el nombre de la constante
// Texto es el nombre de la clase que le di en el html
const textos = document.getElementsByClassName('texto');
console.log(textos);
// En caso de que quiera acceder a una sola posicion le hacemos asi 
console.log(textos[0]);



// En caso de solo querer sacar de una etiqueta en concreto ejem h1
const textoss = document.getElementsByTagName('h2');
console.log(textoss);


// Seleccionar elementos con un ID
const Titulo = document.querySelector('#Titulo');

// Los queryselectero tambien se pueden poner con las clases añadiendo un punto delante .nombre
// Si queremos cambiar el estilo tiene que ser una LIST class

// nombreclase.style.color = 'blue';

