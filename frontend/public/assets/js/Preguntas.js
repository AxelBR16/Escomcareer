// Lógica de preguntas existente
const questions = [
    { text: "Ser comentarista de temas diversos en un programa de televisión.", image: "./assets/images/q1.webp" },
    { text: "Diseñar la decoración de interiores para una casa.", image: "./assets/images/q2.webp" },
    { text: "Desarrollar software para resolver problemas matemáticos.", image: "./assets/images/q3.webp" },
    { text: "Organizar eventos sociales o deportivos.", image: "./assets/images/q4.webp" },
];

let currentQuestion = 0;

const questionText = document.getElementById("question-text");
const questionImage = document.getElementById("question-image");
const prevButton = document.getElementById("prev");
const nextButton = document.getElementById("next");
const progressBar = document.getElementById('progress-bar');

function updateProgress() {
    // Calcula el progreso en porcentaje
    const progress = ((currentQuestion + 1) / questions.length) * 100;
    // Actualiza el ancho de la barra de progreso
    progressBar.style.width = `${progress}%`;
}

function updateQuestion() {
    questionText.textContent = questions[currentQuestion].text;
    questionImage.src = questions[currentQuestion].image;
    updateProgress();
}

prevButton.addEventListener("click", () => {
    if (currentQuestion > 0) {
        currentQuestion--;
        updateQuestion();
    }
});

nextButton.addEventListener("click", () => {
    if (currentQuestion < questions.length - 1) {
        currentQuestion++;
        updateQuestion();
    }
});

// Inicializa la primera pregunta y el progreso
updateQuestion();
function toggleMenu() {
    const navLinks = document.getElementById('nav-links');
    navLinks.classList.toggle('show');
}
