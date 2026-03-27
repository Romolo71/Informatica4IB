
async function loadInfo(){
    try {
    response = await fetch("https://opentdb.com/api.php?amount=10&category=22&difficulty=easy&type=multiple");
    if (!response.ok) {
        throw new Error('Errore nel recupero dei dati');
    }
    data = await response.json();
    console.log(data); // Dati ricevuti
    visDomanda();
    } catch (error) {
    console.error('Errore:', error);
    }
}

function start(){
    loadInfo();
    loadDOM();
}

document.addEventListener("DOMContentLoaded", start());