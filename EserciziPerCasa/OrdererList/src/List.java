public class List<T> {
    Nodo<T> head;

    public List() {
        this.head = null;
    }

    public void add(Nodo<T> nuovo){

        if(head == null){
            head = nuovo;
        }
        else if (head.getNext() == null) {

        }
        else{
            Nodo<T> current = head;

            while (current != null){
                if (nuovo.getVal() > current.getVal() && current.getNext().getVal() != null) {
                    if(nuovo.getVal() < current.getNext().getVal()){
                        current.getNext().setPrev(nuovo);
                        nuovo.setNext(current.getNext());
                        nuovo.setPrev(current);
                        current.setNext(nuovo);
                    }
                }
                current = current.getNext();
            }
        }

    }
}
