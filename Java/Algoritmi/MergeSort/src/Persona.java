class Persona implements Comparable<Persona> {
    String nome;
    int eta;

    public Persona(String n, int e) {
        nome = n;
        eta = e;
    }

    @Override
    public int compareTo(Persona o) {
        return Integer.compare(this.eta, o.eta);  // Ordina per età
    }

    @Override
    public String toString() {
        return nome + " (" + eta + ")";
    }
}