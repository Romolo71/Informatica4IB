# Progetto Gestore Quiz 🧠

Applicazione web interattiva progettata per la somministrazione di quiz a risposta chiusa, con recupero dinamico dei contenuti tramite API esterne.

-----

## 👤 Informazioni Progetto

  * **Realizzatore:** Riccardo Tonini
  * **Richiesto da:** Prof. Stefano Giacomello
  * **Sorgente Dati:** Open Trivia Database (OpenTDB)

-----

## 📚 Indice

- [Progetto Gestore Quiz 🧠](#progetto-gestore-quiz-)
  - [👤 Informazioni Progetto](#-informazioni-progetto)
  - [📚 Indice](#-indice)
  - [🖥️ Logica di Funzionamento](#️-logica-di-funzionamento)
  - [⚙️ Personalizzazione del Quiz](#️-personalizzazione-del-quiz)
  - [💡 Competenze Tecniche](#-competenze-tecniche)
  - [🚀 Istruzioni per l'uso](#-istruzioni-per-luso)

-----

## 🖥️ Logica di Funzionamento

Il sistema non si basa su domande statiche, ma interroga un server remoto per ottenere quiz sempre nuovi:

  * **Fetch API:** Utilizzo di chiamate asincrone per recuperare dati in formato JSON.
  * **Interfaccia Utente:** Le domande vengono mostrate singolarmente, utilizzando radio button per la selezione della risposta corretta.

-----

## ⚙️ Personalizzazione del Quiz

L'utente può configurare l'esperienza di gioco attraverso diversi parametri:

  * **Quantità:** Scelta del numero di domande da affrontare.
  * **Categorie:** Selezione della materia (Geografia, Storia, Scienza, Sport, ecc.) tramite menu a tendina.
  * **Difficoltà:** Impostazione del livello di sfida tra facile, medio o difficile.

-----

## 💡 Competenze Tecniche

L'analisi di questo codice permette di approfondire:

1.  **Asynchronous JS:** Gestione del ciclo di vita delle richieste di rete.
2.  **Error Handling:** Utilizzo di blocchi `try/catch` per gestire eventuali problemi di connessione all'API.
3.  **Dynamic UI:** Generazione automatica degli elementi HTML in base alla risposta del server.

-----

## 🚀 Istruzioni per l'uso

Trattandosi di file contenuti nella stessa cartella, è sufficiente aprire il file HTML principale. **Nota:** È necessaria una connessione a internet per permettere alla funzione `fetch()` di raggiungere l'API di OpenTDB.

-----