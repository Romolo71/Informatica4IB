const express = require('express');
const fs = require('fs');
const path = require('path');
const app = express();
const PORT = 3000;

app.use(express.json());
app.use(express.static('public')); // Cartella per HTML/JS/CSS

const DB_PATH = path.join(__dirname, 'db.json');

// Carica articoli
app.get('/articoli', (req, res) => {
    fs.readFile(DB_PATH, 'utf8', (err, data) => {
        if (err) return res.status(500).send("Errore lettura file");
        res.json(JSON.parse(data));
    });
});

// Salva intera lista
app.post('/salva', (req, res) => {
    const nuovaLista = req.body;
    fs.writeFile(DB_PATH, JSON.stringify(nuovaLista, null, 2), (err) => {
        if (err) return res.status(500).send("Errore salvataggio");
        res.send("Lista salvata con successo");
    });
});

app.listen(PORT, () => console.log(`Server attivo su http://localhost:${PORT}`));