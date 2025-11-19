public class Node<T>{
    Node<T> right;
    Node<T> left;
    T val;

    public Node(T val) {
        this.right = null;
        this.left = null;
        this.val = val;
    }

    public Node<T> getRight() {
        return right;
    }

    public Node<T> getLeft() {
        return left;
    }

    public void setRight(Node right) {
        this.right = right;
    }

    public void setLeft(Node left) {
        this.left = left;
    }

    public T getVal() {
        return val;
    }



    public int compareTo(Node<T> nodo){
        String val1 = "" + this.val;
        String val2 = "" + nodo.getVal();
        if(val1.compareTo(val2) >= 0){
            return 1;
        }
        else{
            return -1;
        }
    }

    @Override
    public String toString() {
        return "" + val;
    }
}