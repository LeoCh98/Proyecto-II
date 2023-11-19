/* 
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/ClientSide/javascript.js to edit this template
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

function loadAnswers() {
    fetch(`${backend}/respuestas`, {
        method: 'GET'
    })
            .then(r => {
                console.log(r);
                return r.json();
            })
}