public class Nodo<T> {
    private Nodo<T> next;
    private T val;

    public Nodo(T val) {
        this.next = null;
        this.val = val;
    }

    public void setNext(Nodo n) {
        this.next = n;
    }

    public Nodo<T> getNext() {
        return next;
    }

    public T getVal() {
        return val;
    }
}
