public class Rubrica {
    private Nodo<Contatto> testa;
    private int lung;

    public Rubrica() {
        this.testa = null;
        this.lung = 0;
    }

    public void aggiungiContatto(Contatto nuovoContatto) {
        Nodo<Contatto> nuovoNodo = new Nodo<>(nuovoContatto);
        String chiaveNuova = nuovoContatto.getChiaveOrdinamento();

        if (testa == null || chiaveNuova.compareTo(testa.getVal().getChiaveOrdinamento()) < 0) {
            nuovoNodo.setNext(this.testa);
            this.testa = nuovoNodo;
            this.lung++;
            return;
        }

        Nodo<Contatto> current = testa;
        while (current.getNext() != null) {
            Nodo<Contatto> nextNode = current.getNext();

            if (chiaveNuova.compareTo(nextNode.getVal().getChiaveOrdinamento()) < 0) {
                break;
            }
            current = nextNode;
        }

        nuovoNodo.setNext(current.getNext());
        current.setNext(nuovoNodo);
        this.lung++;
    }

    public Contatto ricercaContatto(String cognome, String nome) {
        String chiaveRicerca = (cognome.toLowerCase() + nome.toLowerCase());

        Nodo<Contatto> current = testa;
        while (current != null) {
            if (current.getVal().getChiaveOrdinamento().equals(chiaveRicerca)) {
                return current.getVal();
            }
            current = current.getNext();
        }
        return null;
    }

    public boolean eliminaContatto(String cognome, String nome) {
        String chiaveElimina = (cognome.toLowerCase() + nome.toLowerCase());

        if (testa == null) {
            return false;
        }

        if (testa.getVal().getChiaveOrdinamento().equals(chiaveElimina)) {
            this.testa = testa.getNext();
            this.lung--;
            return true;
        }

        Nodo<Contatto> current = testa;
        while (current.getNext() != null) {
            Nodo<Contatto> nextNode = current.getNext();

            if (nextNode.getVal().getChiaveOrdinamento().equals(chiaveElimina)) {
                current.setNext(nextNode.getNext());
                this.lung--;
                return true;
            }
            current = nextNode;
        }
        return false;
    }

    public void visualizzaRubrica() {
        if (testa == null) {
            System.out.println("La rubrica è vuota.");
            return;
        }

        System.out.println("\n--- ELENCO ALFABETICO (" + lung + " contatti) ---\n");
        System.out.println(String.format("%-15s %-15s | %-15s | %s",
                "COGNOME", "NOME", "TELEFONO", "EMAIL"));
        System.out.println("----------------------------------------------------------------------------------");

        Nodo<Contatto> current = testa;
        while (current != null) {
            System.out.println(current.getVal().toString());
            current = current.getNext();
        }
        System.out.println("----------------------------------------------------------------------------------");
    }
}