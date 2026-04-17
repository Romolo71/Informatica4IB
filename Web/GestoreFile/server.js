// Importa il modulo HTTP per creare il server
const http = require('http');

// Importa il modulo File System per leggere/scrivere file
const fs = require("fs");

// Porta su cui il server ascolterà
const PORT = 8000;

// Creazione del server
const server = http.createServer((req, res) => {

    // Log dell'URL e del metodo della richiesta
    console.log(req.url);
    console.log(req.method);

    // Gestione richieste GET
    if (req.method === 'GET') {

        // Endpoint per leggere il file
        if (req.url === '/caricaFile') {

            // Legge il file fileInput.txt
            fs.readFile(__dirname + '/fileInput.txt', function (error, data) {

                // Se c'è un errore (file non trovato, ecc.)
                if (error) {
                    res.writeHead(404);
                    res.write(error);
                    res.end();

                } else {
                    // Risposta OK con intestazioni (CORS incluso)
                    res.writeHead(200, {
                        'Content-Type': 'application/json',

                        // Permette richieste da qualsiasi origine (CORS)
                        'Access-Control-Allow-Origin': '*',
                        'Access-Control-Allow-Methods': 'GET, POST, PUT',
                        'Access-Control-Allow-Headers': 'Content-Type'
                    });

                    // Invia il contenuto del file come JSON
                    res.write(JSON.stringify(data));

                    // Termina la risposta
                    res.end();
                }
            });
        }
    } 

    // Gestione richieste POST
    else if (req.method === 'POST') {

        // Endpoint per scrivere il file
        if (req.url === '/scriviFile') {

            let body = '';

            // Riceve i dati a chunk
            req.on('data', chunk => {
                // Converte ogni chunk in stringa e lo concatena
                body += chunk.toString();
            });

            // Quando tutti i dati sono stati ricevuti
            req.on('end', () => {

                // Converte il body da JSON a oggetto/stringa
                const data = JSON.parse(body);

                // Percorso del file di output
                const nomeFile = __dirname + '/fileOutput.txt';

                // Scrive il contenuto nel file
                fs.writeFile(nomeFile, data, (err) => {

                    if (err) {
                        // Errore durante la scrittura
                        res.writeHead(400, {
                            'Content-Type': 'application/json',
                            'Access-Control-Allow-Origin': '*',
                            'Access-Control-Allow-Methods': 'GET, POST, PUT',
                            'Access-Control-Allow-Headers': 'Content-Type'
                        });

                        res.write(JSON.stringify({ esito: 'non riuscito' }));
                        res.end();

                    } else {
                        // Scrittura completata con successo
                        res.writeHead(200, {
                            'Content-Type': 'application/json',
                            'Access-Control-Allow-Origin': '*',
                            'Access-Control-Allow-Methods': 'GET, POST, PUT',
                            'Access-Control-Allow-Headers': 'Content-Type'
                        });

                        res.write(JSON.stringify({ esito: 'riuscito' }));
                        res.end();
                    }
                });
            });
        }
    }
});

// Avvia il server sulla porta specificata
server.listen(PORT, () => 
    console.log(`Server running on port ${PORT}`)
);

// Esporta il server (utile per test o modularizzazione)
module.exports = server;