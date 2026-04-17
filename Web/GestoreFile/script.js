// URL del server backend
const url = "http://127.0.0.1:8000/";

// Recupera il form dalla pagina HTML
const form = document.getElementById("myForm");

// Funzione eseguita al caricamento della pagina
async function onLoad_Setup() {
    try {
        // Richiesta GET al server per caricare il contenuto del file
        const response = await fetch(url + "caricaFile");

        // Converte la risposta in formato JSON
        const data = await response.json();

        // Estrae l'array ASCII dal JSON ricevuto
        const stringaAscii = data.data;

        // Converte l'array ASCII in stringa e lo inserisce nel campo del form
        form.file.value = String.fromCharCode(...stringaAscii);

    } catch (error) {
        // Mostra un alert in caso di errore
        alert(error);

        // Log dell'errore nella console
        console.error(error.message);
    }
}

// Aggiunge un listener per l'invio del form
form.addEventListener('submit', (event) => {

    // Previene il comportamento di default (refresh della pagina)
    event.preventDefault();

    // Opzioni per la richiesta POST
    const options = {
        method: 'POST',

        // Converte il contenuto del campo file in JSON
        body: JSON.stringify(form.file.value),
    };

    // Invia la richiesta al server per scrivere il file
    fetch(url + "scriviFile", options)
        .then(response => response.json())

        .then((data) => {
            // Mostra un messaggio di successo
            alert('File scritto con successo!');
        })

        .catch(error => {
            // Mostra un messaggio di errore
            alert('Errore durante la scrittura del file');
        });
});