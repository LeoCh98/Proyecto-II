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

class App{
    dom;
    
    modal;
    registerUserModal;
    editUserModal;
    
    state;
    
    constructor(){
        this.state={};
        this.dom=this.render();
        this.renderBodyFiller();
        //this.renderMenuItems();
        /*
        this.modal = new bootstrap.Modal(this.dom.querySelector('#app>#modal'));
        this.registerUserModal = new bootstrap.Modal(this.dom.querySelector('#app>#registerUserModal'));
        this.editUserModal = new bootstrap.Modal(this.dom.querySelector('#app>#editUserModal'));
        
        this.dom.querySelector('#app>#modal #apply').addEventListener('click',e=>this.login());
        this.dom.querySelector('#app>#registerUserModal #applyRegister').addEventListener('click',e=>this.register());
        */
    }
    
    render=()=>{
        const html = `
            ${this.renderMenu()}
            ${this.renderBody()} 
            ${this.renderFooter()}
        `;
       var rootContent = document.createElement('div');
       rootContent.id='app';
       rootContent.innerHTML=html;
       return rootContent;
    }
    
    renderMenu=()=>{
        return `
            <header class="bg-dark text-white text-center py-4">
                <h1>Encuestas</h1>
            </header>
        `;
    }
    
    renderBody=()=>{
        return `
            <div id="body" style="margin-bottom: 51px">   
            </div>    
        `;
    }
    
    renderFooter=()=>{
        return `
            <footer class="bg-dark text-white text-center py-3">
                <p>&copy; 2023 Universidad Nacional de Costa Rica</p>
            </footer> 
        `;
    }
    
    renderBodyFiller=()=>{
        var html= `
            <div id='bodyFiller' style='margin-left: 10%; margin-top:100px; width: 80%; text-align: center; font-size: 1.5em'>
                <p>Bienvenidos a Seguros.</p>
                <img src="images/filler.png" alt="filler" style="max-width: 50%; max-height: 50%">
            </div>
        `;
        this.dom.querySelector('#app>#body').replaceChildren();
        this.dom.querySelector('#app>#body').innerHTML=html; 
    }
}