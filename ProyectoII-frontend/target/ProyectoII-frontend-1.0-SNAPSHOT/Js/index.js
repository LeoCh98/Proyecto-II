/*
 * -----------------------------------------------------------------
 *
 * (c) 2023
 * 
 * @author Jean Paul Castillo Vives
 * @author Jorge Andrés Durán Campos
 * @author Leonardo Jesús Chaves Hernández
 * 
 * @version 1.0.0 2023-11-15
 * 
 * -----------------------------------------------------------------
 */

var backend = "http://localhost:8080/ProyectoII-backend/api";

var globalstate = {user: null};

var app;

function loaded() {
    app = new App();
    document.querySelector('#root').replaceChildren(app.dom);
}

document.addEventListener("DOMContentLoaded", loaded);

function errorMessage(code) {
    alert(`Error. Status: ${code}`);
}