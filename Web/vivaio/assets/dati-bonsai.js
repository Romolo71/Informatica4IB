// Dati strutturati per i Bonsai
const databaseBonsai = {
    "elencoBonsai": [
        {
            "nome": "Bonsai di Olivo",
            "descrizione": "L'olivo è uno dei bonsai più amati per la sua resistenza e il tronco nodoso che evoca paesaggi mediterranei. È una pianta sempreverde che ama il sole e richiede potature mirate per mantenere la forma.",
            "fileImg": "bonsai1.jpg"
        },
        {
            "nome": "Ginepro (Juniperus)",
            "descrizione": "Classico dell'arte bonsai, il ginepro è celebre per la flessibilità del tronco che permette di creare forme spettacolari (stile cascata o inclinato). Resistente e longevo.",
            "fileImg": "bonsai2.jpg"
        },
        {
            "nome": "Acero Palmato",
            "descrizione": "Famoso per il mutamento cromatico delle sue foglie, che passano dal verde brillante all'arancio e rosso intenso in autunno. Richiede molta attenzione all'esposizione solare.",
            "fileImg": "bonsai3.jpg"
        },
        {
            "nome": "Ficus Retusa",
            "descrizione": "Il bonsai perfetto per chi inizia. Molto tollerante agli errori di irrigazione e capace di produrre radici aeree suggestive anche in ambienti interni.",
            "fileImg": "bonsai4.jpg"
        }
    ]
};

// Array di immagini per la generazione random (usa i tuoi nomi file o URL)
const immaginiRandom = [
    "https://images.unsplash.com/photo-1512428813834-c702c7702b78?auto=format&fit=crop&w=300",
    "https://images.unsplash.com/photo-1599598477995-f37774435773?auto=format&fit=crop&w=300",
    "https://images.unsplash.com/photo-1620191836102-36c561b327be?auto=format&fit=crop&w=300",
    "https://images.unsplash.com/photo-1610450949065-0f0907572793?auto=format&fit=crop&w=300"
];

function ottieniImmagineRandom() {
    const indice = Math.floor(Math.random() * immaginiRandom.length);
    return immaginiRandom[indice];
}