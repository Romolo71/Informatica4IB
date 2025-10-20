public class Nodo<T> {
    private Nodo<T> next;
    private Nodo<T> prev;
    private T val;

    public Nodo(T val) {
        this.next = null;
        this.prev = null;
        this.val = val;
    }

    public void setNext(Nodo n) {
        this.next = n;
    }

    public Nodo<T> getNext() {
        return next;
    }

    public void setPrev(Nodo<T> prev) {
        this.prev = prev;
    }

    public Nodo<T> getPrev() {
        return prev;
    }

    public T getVal() {
        return val;
    }
}