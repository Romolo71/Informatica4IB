# Progetto Registro Elettronico 📝

Sviluppo di una Single Page Application (SPA) per la gestione dinamica dei dati scolastici, focalizzata sulla manipolazione del DOM e la gestione di strutture dati in JavaScript.

-----

## 👤 Informazioni Progetto

  * **Realizzatore:** Riccardo Tonini
  * **Richiesto da:** Prof. Stefano Giacomello
  * **Istituto:** ITIS "C. Zuccante"
  * **Tecnologie:** HTML5, CSS3, JavaScript ES6

-----

## 📚 Indice

- [Progetto Registro Elettronico 📝](#progetto-registro-elettronico-)
  - [👤 Informazioni Progetto](#-informazioni-progetto)
  - [📚 Indice](#-indice)
  - [🖥️ Descrizione del Sito](#️-descrizione-del-sito)
  - [🛠️ Funzionalità Implementate](#️-funzionalità-implementate)
  - [📁 Struttura dei File](#-struttura-dei-file)
  - [🚀 Istruzioni per l'uso](#-istruzioni-per-luso)

-----

## 🖥️ Descrizione del Sito

L'interfaccia è suddivisa in due sezioni principali per ottimizzare l'esperienza utente:

  * **Area Input (Sinistra):** Contiene i form per l'inserimento di Cognome, Nome, Sesso (tramite radio button) e i voti per 10 materie differenti.
  * **Area Visualizzazione (Destra):** Una tabella dinamica che si aggiorna in tempo reale mostrando l'elenco degli studenti salvati.

-----

## 🛠️ Funzionalità Implementate

Il progetto copre le operazioni fondamentali di gestione dati:

1.  **CRUD Completo:** Inserimento di nuovi record, modifica dei dati esistenti e rimozione degli studenti dalla tabella.
2.  **Ordinamento:** Funzione per ordinare alfabeticamente l'elenco degli studenti.
3.  **Analisi Dati:** Un menu a tendina permette di selezionare una specifica materia per calcolarne istantaneamente la media aritmetica di tutta la classe.

-----

## 📁 Struttura dei File

Tutti i componenti del progetto risiedono nella cartella principale per una gestione semplificata:

  * `index.html`: Struttura del registro e dei form.
  * `style.css`: Layout a due colonne e styling della tabella.
  * `script.js`: Logica di calcolo delle medie e manipolazione del DOM.

-----

## 🚀 Istruzioni per l'uso

È sufficiente aprire il file `index.html` in un browser. I dati inseriti verranno gestiti localmente dalla logica JavaScript durante la sessione.

-----