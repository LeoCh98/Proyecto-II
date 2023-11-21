document.addEventListener('DOMContentLoaded', function () {
    const apiUrl = 'http://localhost:8080/ProyectoII-backend/api/preguntas/';
    let currentQuestionIndex = 0;
    let userResponses = [];

    // Función para obtener las preguntas y respuestas del API
    async function fetchQuestions() {
        try {
            const response = await fetch(apiUrl);
            const data = await response.json();
            return data;
        } catch (error) {
            console.error('Error al obtener preguntas:', error);
        }
    }

    // Función para mostrar la pregunta actual en el DOM
    function displayCurrentQuestion(questions) {
        const currentQuestion = questions[currentQuestionIndex];

        const questionContainer = document.getElementById('questions-container');
        questionContainer.innerHTML = '';

        const questionDiv = document.createElement('div');
        questionDiv.classList.add('question');

        const questionTitle = document.createElement('h4');
        questionTitle.textContent = currentQuestion.enunciado;
        questionDiv.appendChild(questionTitle);

        if (currentQuestion.categoria === 'valoracion cualitativa') {
            for (let i = 1; i <= 5; i++) {
                const radioContainer = document.createElement('div');
                radioContainer.classList.add('form-check');

                const radioInput = document.createElement('input');
                radioInput.setAttribute('type', 'radio');
                radioInput.setAttribute('name', 'rating');
                radioInput.setAttribute('value', i);
                radioInput.setAttribute('id', `rating${i}`);
                radioInput.classList.add('form-check-input');
                radioInput.addEventListener('change', (event) => handleRatingChange(event.target.value));

                const radioLabel = document.createElement('label');
                radioLabel.setAttribute('for', `rating${i}`);
                radioLabel.classList.add('form-check-label');
                radioLabel.textContent = i;

                radioContainer.appendChild(radioInput);
                radioContainer.appendChild(radioLabel);

                questionDiv.appendChild(radioContainer);
            }
        } else if (currentQuestion.categoria === 'respuesta abierta') {
            const answerInput = document.createElement('textarea');
            answerInput.setAttribute('rows', '4'); // Ajusta el número de filas según tus preferencias
            answerInput.setAttribute('placeholder', 'Escribe tu respuesta aquí');
            answerInput.addEventListener('input', (event) => handleAnswerInput(event.target.value));
            questionDiv.appendChild(answerInput);
        } else if (currentQuestion.categoria === 'seleccion unica') {
            currentQuestion.respuestas.forEach(answer => {
                const checkboxContainer = document.createElement('div');
                checkboxContainer.classList.add('form-check');

                const checkboxInput = document.createElement('input');
                checkboxInput.setAttribute('type', 'radio');
                checkboxInput.setAttribute('name', 'selection');
                checkboxInput.setAttribute('value', answer.id);
                checkboxInput.setAttribute('id', `selection${answer.id}`);
                checkboxInput.classList.add('form-check-input');
                checkboxInput.addEventListener('change', (event) => handleAnswerClick(event.target.value));

                const checkboxLabel = document.createElement('label');
                checkboxLabel.setAttribute('for', `selection${answer.id}`);
                checkboxLabel.classList.add('form-check-label');
                checkboxLabel.textContent = answer.laRespuesta;

                checkboxContainer.appendChild(checkboxInput);
                checkboxContainer.appendChild(checkboxLabel);

                questionDiv.appendChild(checkboxContainer);
            });
        } else if (currentQuestion.categoria === 'seleccion multiple') {
            currentQuestion.respuestas.forEach(answer => {
                const checkboxContainer = document.createElement('div');
                checkboxContainer.classList.add('form-check');

                const checkboxInput = document.createElement('input');
                checkboxInput.setAttribute('type', 'checkbox');
                checkboxInput.setAttribute('name', 'selection');
                checkboxInput.setAttribute('value', answer.id);
                checkboxInput.setAttribute('id', `selection${answer.id}`);
                checkboxInput.classList.add('form-check-input');
                checkboxInput.addEventListener('change', (event) => handleAnswerClick(event.target.value));

                const checkboxLabel = document.createElement('label');
                checkboxLabel.setAttribute('for', `selection${answer.id}`);
                checkboxLabel.classList.add('form-check-label');
                checkboxLabel.textContent = answer.laRespuesta;

                checkboxContainer.appendChild(checkboxInput);
                checkboxContainer.appendChild(checkboxLabel);

                questionDiv.appendChild(checkboxContainer);
            });
        }

        questionContainer.appendChild(questionDiv);
    }

    // Función para manejar la selección de respuestas
    function handleAnswerClick(answerId) {
        const index = userResponses.indexOf(answerId);

        if (index === -1) {
            userResponses.push(answerId);
        } else {
            userResponses.splice(index, 1);
        }
        // Puedes agregar lógica adicional aquí si es necesario
    }

    // Función para manejar la entrada de respuestas para preguntas abiertas
    function handleAnswerInput(answer) {
        userResponses[currentQuestionIndex] = answer;
        // Puedes agregar lógica adicional aquí si es necesario
    }

    // Función para manejar el cambio de valoración
    function handleRatingChange(rating) {
        userResponses[currentQuestionIndex] = rating;
        // Puedes agregar lógica adicional aquí si es necesario
    }

    // Función para avanzar a la siguiente pregunta
    function nextQuestion() {
        if (currentQuestionIndex < questions.length - 1) {
            currentQuestionIndex++;
            displayCurrentQuestion(questions);
        }
    }

    // Función para retroceder a la pregunta anterior
    function prevQuestion() {
        if (currentQuestionIndex > 0) {
            currentQuestionIndex--;
            displayCurrentQuestion(questions);
        }
    }

    // Función para enviar la encuesta y redirigir a la nueva página
    function submitSurvey() {
        const queryString = userResponses.map((response, index) => `q${index + 1}=${response}`).join('&');
        const redirectUrl = `resultado.html?${queryString}`;
        window.location.href = redirectUrl;
    }

    // Obtener preguntas y respuestas y mostrar la primera pregunta
    let questions;
    fetchQuestions().then(data => {
        questions = data;
        displayCurrentQuestion(questions);
    });

    // Event listener para el botón "Siguiente"
    document.getElementById('nextBtn').addEventListener('click', nextQuestion);

    // Event listener para el botón "Anterior"
    document.getElementById('prevBtn').addEventListener('click', prevQuestion);

    // Event listener para el botón "Enviar encuesta"
    document.getElementById('submitBtn').addEventListener('click', submitSurvey);
});