# Progetto Vivaio "La Grande Sequoia" 🌿

Questo progetto consiste nella realizzazione di un mini-sito web dinamico per la gestione e la visualizzazione del catalogo di un vivaio. Il sito è articolato in diverse categorie: piante da interno, alberi/arbusti e bonsai.

---

## 👤 Informazioni Progetto
* **Realizzatore:** Riccardo Tonini
* **Richiesto da:** Prof. Giacomello Stefano
* **Istituto:** ITIS "C. Zuccante"
* **Data Inizio:** 14 Gennaio 2026
* **Data Fine:** 6 Febbraio 2026

---

## 📚 Indice
1. [Descrizione del Sito](dDescrizione-del-sito)
2. [Struttura dei File](#struttura-dei-file)
3. [Tecnologie e Competenze](#tecnologie-e-competenze)
4. [Istruzioni per l'Uso](#istruzioni-per-luso)

---

## 🖥️ Descrizione del Sito
Il sito è composto da tre sezioni principali:
* **Home Page (`index.html`):** Vetrina principale con navigazione verso le categorie.
* **Piante da Interno & Alberi:** Pagine statiche e dinamiche che mostrano le specie botaniche con descrizioni dettagliate.
* **Sezione Bonsai:** Una pagina avanzata che comunica con un server esterno per il recupero dei dati in tempo reale.

---

## 📁 Struttura degli Assets
Il progetto segue una gerarchia ordinata per separare logica e stile:
* **`/assets/css/`**: Contiene il foglio di stile globale (`style.css`) che garantisce coerenza grafica a tutte le pagine.
* **`/assets/images/`**: Directory locale contenente le icone, i loghi e le immagini delle piante per le sezioni statiche.
* **File JSON/JS**: I dati delle piante sono strutturati per essere facilmente manutenibili senza modificare l'HTML.

---

## 💡 Cosa si può apprendere da questo codice
Analizzando i file di questo progetto, è possibile approfondire i seguenti concetti di sviluppo web:

1.  **Layout Moderno:** Utilizzo dei CSS per creare card e box con scorrimento (`overflow-y`).
2.  **Manipolazione del DOM:** Come JavaScript può "iniettare" contenuti HTML all'interno di contenitori vuoti in base ai dati.
3.  **Fetch API:** Gestione di richieste asincrone verso server esterni (`http://192.168.4.59:8000`) per caricare dati in formato JSON.
4.  **Programmazione Dinamica:** Uso di array di oggetti e cicli (`forEach`) per automatizzare la creazione delle interfacce.
5.  **Clean Code:** Separazione delle responsabilità tra HTML (struttura), CSS (stile) e JS (logica).

---

## 🚀 Istruzioni per l'uso
Per visualizzare correttamente la sezione Bonsai, è necessario che il computer sia collegato alla rete locale dell'istituto per raggiungere l'IP del server. Per le altre sezioni, è sufficiente aprire `index.html` in qualsiasi browser moderno.