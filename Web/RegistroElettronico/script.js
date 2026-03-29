document.addEventListener("DOMContentLoaded", () => {
    const MATERIE = ["Ed. Civica", "Italiano", "Storia", "Inglese", "Matematica", "Informatica", "Sistemi", "TPSIT", "Telecom.", "Scienze Mot."]; // [cite: 40, 49]
    let database = [];
    let selIdx = -1;

    const formVoti = document.getElementById('voti-form');
    const headRow = document.getElementById('head-row');
    const selMateria = document.getElementById('sel-materia');

    // Inizializzazione dinamica basata su Fase 1
    MATERIE.forEach(m => {
        formVoti.innerHTML += `<div class="voto-riga"><label>${m}</label><input type="text" class="v-in" data-m="${m}"></div>`;
        headRow.innerHTML += `<th>${m}</th>`;
        selMateria.innerHTML += `<option value="${m}">${m}</option>`;
    });

    function render() {
        const tbody = document.getElementById('body-tabella');
        tbody.innerHTML = '';
        database.forEach((s, i) => {
            const tr = document.createElement('tr');
            if(i === selIdx) tr.className = 'selected';
            
            let votiCells = MATERIE.map(m => `<td>${s.voti[m] || ''}</td>`).join('');
            tr.innerHTML = `<td>${s.cognome} ${s.nome}</td><td>${s.sesso}</td>${votiCells}`;
            
            tr.onclick = () => {
                selIdx = i;
                document.getElementById('cognome').value = s.cognome;
                document.getElementById('nome').value = s.nome;
                document.querySelector(`input[name="sesso"][value="${s.sesso}"]`).checked = true;
                document.querySelectorAll('.v-in').forEach(input => input.value = s.voti[input.dataset.m]);
                render();
            };
            tbody.appendChild(tr);
        });
        calcolaMedia();
    }

    document.getElementById('btn-inserisci').onclick = () => {
        let studente = {
            cognome: document.getElementById('cognome').value, // [cite: 61]
            nome: document.getElementById('nome').value, // [cite: 61]
            sesso: document.querySelector('input[name="sesso"]:checked').value, // [cite: 61]
            voti: {}
        };
        document.querySelectorAll('.v-in').forEach(input => studente.voti[input.dataset.m] = input.value); // [cite: 62]
        database.push(studente); // [cite: 63]
        render();
    };

    document.getElementById('btn-modifica').onclick = () => {
        if(selIdx > -1) {
            database[selIdx].cognome = document.getElementById('cognome').value;
            database[selIdx].nome = document.getElementById('nome').value;
            database[selIdx].sesso = document.querySelector('input[name="sesso"]:checked').value;
            document.querySelectorAll('.v-in').forEach(input => database[selIdx].voti[input.dataset.m] = input.value);
            render();
        }
    };

    document.getElementById('btn-rimuovi').onclick = () => {
        if(selIdx > -1) {
            database.splice(selIdx, 1);
            selIdx = -1;
            render();
        }
    };

    document.getElementById('btn-ordina').onclick = () => {
        database.sort((a, b) => a.cognome.localeCompare(b.cognome)); // [cite: 64]
        render();
    };

    function calcolaMedia() {
        const mat = selMateria.value;
        let somma = 0, count = 0;
        database.forEach(s => {
            let v = parseFloat(s.voti[mat]);
            if(!isNaN(v)) { somma += v; count++; }
        });
        const media = count > 0 ? (somma/count).toFixed(2) : "--"; // [cite: 66]
        document.getElementById('res-media').innerText = `Media ${mat}: ${media}`; // [cite: 52]
    }

    selMateria.onchange = calcolaMedia;
});