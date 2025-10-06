public class Coda<T> {
    private Nodo<T> testa;
    private Nodo<T> fine;
    private int lung;

    public Coda() {
        this.testa = null;
        this.fine = null;
        this.lung = 0;
    }

    public void enqueue(T elem) {
        // riceviamo un elemento di tipo T
        // Creo nuovo nodo
        Nodo<T> n = new Nodo<>(elem);
        this.fine.setNext(n);
        this.lung++;
        this.fine = n;
        if (testa == null){
            this.testa = n;
        }
    }

    public T dequeue() {
        Nodo<T> oldTesta = this.testa;
        Nodo<T> newTesta = this.testa.getNext();
        this.testa = newTesta;
        this.lung--;
        return oldTesta.getVal();
    }

    public int size() {
        return this.lung;
    }

    public boolean isEmpty() {
        return (this.lung == 0);
    }

    public String toString() {
        Nodo<T> ij = this.testa;
        String testo = "{ ";
        for (int i = 0; i < this.lung - 1; i++) {
            testo += ij.toString();
            if(i < i + 1){
                testo += ", ";
            }
            ij = ij.getNext();
        }
        testo += " }";
        return testo;
    }


}
