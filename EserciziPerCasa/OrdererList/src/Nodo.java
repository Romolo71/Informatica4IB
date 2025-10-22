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

    public int compareTo(Nodo<T> obj){
        String val1 = "" + this.val;
        String val2 = "" + obj.getVal();

        if(val1.compareTo(val2) > 0){
            return 1;
        }
        else{
            return -1;
        }
    }

    public boolean isEqual(Nodo<T> obj){
        String v1 = this.getVal() + "";
        String v2 = obj.getVal() + "";

        if(v1.compareTo(v2) == 0){
            return true;
        }
        else{
            return false;
        }
    }

    @Override
    public String toString() {
        return "" + val;
    }
}