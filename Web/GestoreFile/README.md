# Progetto Gestore File Node.js 📂

Sviluppo di un'applicazione web client-server per la lettura, modifica e scrittura asincrona di file di testo sul file system locale tramite l'ambiente di runtime Node.js.

-----

## 👤 Informazioni Progetto

  * **Realizzatore:** Riccardo Tonini
  * **Richiesto da:** Prof. Stefano Giacomello
  * **Istituto:** ITIS "C. Zuccante"
  * **Tecnologie:** HTML5, JavaScript ES6, Node.js (File System module)

-----

## 📚 Indice

  - [Progetto Gestore File Node.js 📂](#progetto-gestore-file-nodejs-)
      - [👤 Informazioni Progetto](#-informazioni-progetto)
      - [📚 Indice](#-indice)
      - [🖥️ Descrizione del Sito](#️-descrizione-del-sito)
      - [🛠️ Funzionalità Implementate](#️-funzionalità-implementate)
      - [📁 Struttura dei File](#-struttura-dei-file)
      - [🚀 Istruzioni per l'uso](#-istruzioni-per-luso)

-----

## 🖥️ Descrizione del Sito

L'interfaccia è progettata per essere essenziale e funzionale, focalizzandosi sull'interazione diretta con il backend:

  * **Area di Testo (TextArea):** Uno spazio centrale dove viene caricato il contenuto del file sorgente, permettendo all'utente un editing immediato.
  * **Pannello di Controllo:** Pulsanti dedicati per innescare le chiamate al server per le operazioni di input/output.

-----

## 🛠️ Funzionalità Implementate

Il progetto gestisce il flusso di dati tra client e server attraverso le seguenti fasi:

1.  **Lettura Automatica:** All'avvio o tramite comando, il server legge `fileInput.txt` e invia il testo al client.
2.  **Editing in Real-time:** L'utente può modificare il testo direttamente all'interno della TextArea del browser.
3.  **Persistenza Dati:** Al clic del pulsante di salvataggio, il contenuto corrente della TextArea viene inviato al server che lo scrive nel nuovo file `fileOutput.txt`.
4.  **Gestione Server-Side:** Utilizzo del modulo `fs` di Node.js per la manipolazione fisica dei file sul disco.

-----

## 📁 Struttura dei File

La cartella di progetto include i file sorgente e le risorse per il funzionamento del server:

  * `server.js`: Il motore dell'applicazione che gestisce le richieste HTTP e l'accesso ai file.
  * `script.js`: Logica lato client per gestire l'interfaccia e le comunicazioni asincrone.
  * `index.html`: (Incluso/Referenziato) La struttura grafica dell'applicazione.
  * `fileInput.txt`: Il file sorgente contenente i dati iniziali.
  * `schermata.jpg`: Riferimento visivo per il layout dell'interfaccia.

-----

## 🚀 Istruzioni per l'uso

1.  Assicurarsi che **Node.js** sia installato sul sistema.
2.  Aprire il terminale nella cartella del progetto e avviare il server con il comando `node server.js`.
3.  Navigare all'indirizzo `http://localhost:[porta]` indicato nel codice.
4.  Modificare il testo e premere il pulsante per generare `fileOutput.txt`.