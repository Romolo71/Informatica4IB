document.addEventListener("DOMContentLoaded", () => {
    let domande = [];
    let indice = 0;
    let score = 0;
    let risposto = false;

    const btnStart = document.getElementById('btn-start');
    const btnNext = document.getElementById('btn-next');

    async function caricaQuiz() {
        const n = document.getElementById('n').value;
        const c = document.getElementById('c').value;
        const d = document.getElementById('d').value;
        const url = `https://opentdb.com/api.php?amount=${n}&category=${c}&difficulty=${d}&type=multiple`;

        try {
            const r = await fetch(url);
            const data = await r.json();
            domande = data.results;

            if (domande.length > 0) {
                document.getElementById('setup').classList.add('nascosto');
                document.getElementById('gioco').classList.remove('nascosto');
                mostraDomanda();
            }
        } catch (e) { alert("Errore connessione"); }
    }

    function mostraDomanda() {
        risposto = false;
        btnNext.innerText = "CONFERMA";
        const d = domande[indice];
        
        document.getElementById('contatore').innerText = `${indice + 1} / ${domande.length}`;
        document.getElementById('titolo-cat').innerText = d.category;
        document.getElementById('testo').innerHTML = d.question;
        
        const box = document.getElementById('risposte');
        box.innerHTML = '';

        let tutte = [...d.incorrect_answers, d.correct_answer];
        tutte.sort(() => Math.random() - 0.5);

        tutte.forEach(r => {
            const label = document.createElement('label');
            label.className = 'answer';
            label.innerHTML = `<input type="radio" name="q" value="${r.replace(/"/g, '&quot;')}"><span>${r}</span>`;
            box.appendChild(label);
        });
    }

    function gestisciClick() {
        const sel = document.querySelector('input[name="q"]:checked');
        if (!sel) return;

        if (!risposto) {
            risposto = true;
            const corretta = domande[indice].correct_answer;
            document.querySelectorAll('.answer').forEach(l => {
                const v = l.querySelector('input').value;
                if (v === corretta) l.classList.add('corretta');
                else if (sel.value === v) l.classList.add('sbagliata');
            });
            if (sel.value === corretta) score++;
            btnNext.innerText = "PROSSIMA";
        } else {
            indice++;
            if (indice < domande.length) mostraDomanda();
            else fine();
        }
    }

    function fine() {
        document.getElementById('gioco').classList.add('nascosto');
        document.getElementById('fine').classList.remove('nascosto');
        document.getElementById('ris').innerText = `Punteggio: ${score} / ${domande.length}`;
    }

    btnStart.onclick = caricaQuiz;
    btnNext.onclick = gestisciClick;
    document.getElementById('btn-reload').onclick = () => location.reload();
});