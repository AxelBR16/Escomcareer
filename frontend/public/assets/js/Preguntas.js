// Lógica de preguntas actualizada
const questions = [
    { text: "Resolver operaciones matemáticas.", image: "./assets/images/q1.webp" },
    { text: "Ser asistente por temporadas de un investigador que trabaje en programas de investigación aplicada a la genética en seres vivos.", image: "./assets/images/q2.webp" },
    { text: "Conocer los compuestos químicos de las sustancias.", image: "./assets/images/q5.webp" },
    { text: "Hacer inventarios de lo que hay en un almacén.", image: "./assets/images/q4.webp" },
    { text: "Ayudar a un grupo de campesinos a organizarse.", image: "./assets/images/q5.webp" },
    { text: "Participar en un jurado que calificará un concurso teatral, en cuanto a escenografía, coreografía y guion de la obra.", image: "./assets/images/q6.webp" },
    { text: "Trabajar en un centro dedicado a la producción de los modelos matemáticos y físicos para mejorar los productos en la industria.", image: "./assets/images/q7.webp" },
    { text: "Participar en una operación médica.", image: "./assets/images/q8.webp" },
    { text: "Manejar instrumentos y aparatos para elaborar productos químicos.", image: "./assets/images/q9.webp" },
    { text: "Organizar los detalles de venta al público en un almacén.", image: "./assets/images/q10.webp" },
    { text: "Ayudar en la rehabilitación de los presos.", image: "./assets/images/q11.webp" },
    { text: "Diseñar la escenografía de un programa televisivo.", image: "./assets/images/q12.webp" },
    { text: "Aplicar los principios y leyes de la física.", image: "./assets/images/q13.webp" },
    { text: "Conocer a fondo los problemas ecológicos (ecosistema).", image: "./assets/images/q14.webp" },
    { text: "Hacer análisis químicos del agua (su potabilidad).", image: "./assets/images/q15.webp" },
    { text: "Determinar la relación entre inversión y utilidad de una empresa.", image: "./assets/images/q16.webp" },
    { text: "Conocer las causas que intervienen en la desintegración familiar.", image: "./assets/images/q17.webp" },
    { text: "Manejar con habilidad las cámaras de fotografía y de cine.", image: "./assets/images/q18.webp" },
    { text: "Calcular fuerzas y resultantes físicas.", image: "./assets/images/q19.webp" },
    { text: "Aplicar los principios de la cadena alimentaria entre las especies, para su conservación.", image: "./assets/images/q20.webp" },
    { text: "Estudiar a fondo los efectos de la quimioterapia en el hombre.", image: "./assets/images/q21.webp" },
    { text: "Determinar las funciones de los empleados en una empresa.", image: "./assets/images/q22.webp" },
    { text: "Hacer programas para educación de los huérfanos de la casa-hogar.", image: "./assets/images/q23.webp" },
    { text: "Conocer cómo eran nuestros antepasados a través de las pinturas, esculturas y danzas que nos legaron.", image: "./assets/images/q24.webp" },
    { text: "Calcular matemáticamente, a través de una computadora, la probabilidad de éxito en un proyecto cualquiera.", image: "./assets/images/q25.webp" },
    { text: "Conocer cómo funciona la reproducción bacteriana.", image: "./assets/images/q26.webp" },
    { text: "Ser hábil para obtener nuevos compuestos químicos.", image: "./assets/images/q27.webp" },
    { text: "Determinar los elementos sociales que estimulan los procesos económicos inflacionarios.", image: "./assets/images/q28.webp" },
    { text: "Investigar las costumbres de vida entre las clases sociales y sus diferencias.", image: "./assets/images/q29.webp" },
    { text: "Producir y dirigir audiovisuales, teatro y películas.", image: "./assets/images/q30.webp" },
    { text: "Usar modelos matemáticos y físicos para realizar un trabajo.", image: "./assets/images/q31.webp" },
    { text: "Conocer la estructura y funciones de la anatomía animal o humana.", image: "./assets/images/q32.webp" },
    { text: "Hacer experimentos en el laboratorio de química.", image: "./assets/images/q33.webp" },
    { text: "Llevar el inventario de productos que tiene una bodega, a través de un programa computacional.", image: "./assets/images/q34.webp" },
    { text: "Participar en campañas de educación y concientización política.", image: "./assets/images/q35.webp" },
    { text: "Idear nuevas técnicas de pintura, escultura y grabado.", image: "./assets/images/q36.webp" },
    { text: "Diseñar fórmulas matemáticas y físicas, aplicables a una labor cualquiera.", image: "./assets/images/q37.webp" },
    { text: "Conocer las causas del suicidio colectivo en algunas especies.", image: "./assets/images/q38.webp" },
    { text: "Analizar los elementos químicos de algunas sustancias.", image: "./assets/images/q39.webp" },
    { text: "Organizar y dirigir una empresa turística.", image: "./assets/images/q40.webp" },
    { text: "Ayudar a una persona que pasa por momentos difíciles.", image: "./assets/images/q41.webp" },
    { text: "Investigar por qué y para qué existe el hombre.", image: "./assets/images/q42.webp" },
    { text: "Calcular áreas, perímetros y volumen (pueden ser calderas, hornos metalúrgicos, construcciones, etc.).", image: "./assets/images/q43.webp" },
    { text: "Conocer las causas de la extinción de algunos organismos vivos y cómo evitarla.", image: "./assets/images/q44.webp" },
    { text: "Determinar, mediante el análisis químico, la presencia de alguna enfermedad.", image: "./assets/images/q45.webp" },
    { text: "Hacer las declaraciones fiscales a una pequeña cámara de comerciantes.", image: "./assets/images/q46.webp" },
    { text: "Conocer las causas, consecuencias y soluciones del divorcio.", image: "./assets/images/q47.webp" },
    { text: "Saber cuáles son las diferencias y semejanzas entre la música, las artesanías y las danzas características de los distintos grupos culturales.", image: "./assets/images/q48.webp" },
    { text: "Probar nuevos programas computacionales para realizar operaciones numéricas.", image: "./assets/images/q49.webp" },
    { text: "Conocer técnicas de mejoramiento de semillas y ganado.", image: "./assets/images/q50.webp" },
    { text: "Manejar los productos químicos adecuados para la conservación de alimentos.", image: "./assets/images/q51.webp" },
    { text: "Tener un despacho para asesorar empresas en el mejoramiento de su administración y organización.", image: "./assets/images/q52.webp" },
    { text: "Participar en programas educativos que ayuden a evitar el alcoholismo y la drogadicción.", image: "./assets/images/q53.webp" },
    { text: "Conocer la vida religiosa y artística de las tribus indígenas de nuestro país.", image: "./assets/images/q54.webp" },
    { text: "Explicar matemática y físicamente los probables resultados de un diseño cualquiera.", image: "./assets/images/q55.webp" },
    { text: "Conocer técnicas de siembra y recolección de frutas.", image: "./assets/images/q56.webp" },
    { text: "Observar y conocer cómo actúan los reactivos químicos.", image: "./assets/images/q57.webp" },
    { text: "Vigilar los rendimientos económicos de una empresa.", image: "./assets/images/q58.webp" },
    { text: "Conocer el comportamiento humano y las causas que lo motivan.", image: "./assets/images/q59.webp" },
    { text: "Seleccionar la música más adecuada para una película.", image: "./assets/images/q60.webp" }
];

let currentQuestion = 0;
let isAnswered = false;

const questionText = document.getElementById("question-text");
const questionImage = document.getElementById("question-image");
const prevButton = document.getElementById("prev");
const nextButton = document.getElementById("next");
const progressBar = document.getElementById('progress-bar');
const answerOptions = document.querySelectorAll(".answer-option");

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
    isAnswered = false;
    answerOptions.forEach(option => option.checked = false); // Reinicia las respuestas
}

answerOptions.forEach(option => {
    option.addEventListener("change", () => {
        isAnswered = true;
    });
});

prevButton.addEventListener("click", () => {
    if (currentQuestion > 0) {
        currentQuestion--;
        updateQuestion();
    }
});

nextButton.addEventListener("click", () => {
    if (isAnswered) {
        if (currentQuestion < questions.length - 1) {
            currentQuestion++;
            updateQuestion();
        }
    } else {
        alert("Por favor, selecciona una respuesta antes de continuar.");
    }
});

// Inicializa la primera pregunta y el progreso
updateQuestion();

function toggleMenu() {
    const navLinks = document.getElementById('nav-links');
    navLinks.classList.toggle('show');
}
