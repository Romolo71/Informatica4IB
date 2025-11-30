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
            head.setNext(nuovo);
        }
        else{
            Nodo<T> current = head;

            while (current != null){
                if (nuovo.compareTo(current) > 0 && current.getNext().getVal() != null) {      //Se il valore nuovo è maggiore del corrente
                    if(nuovo.compareTo(current.getNext()) < 0){                                //se il valore è compreso tra corrente e il prossimo di corrente
                        current.getNext().setPrev(nuovo);
                        nuovo.setNext(current.getNext());
                        nuovo.setPrev(current);
                        current.setNext(nuovo);
                    }
                    else{
                        current.setNext(nuovo);
                        nuovo.setPrev(current);
                    }
                }
                current = current.getNext();
            }
        }

    }

    public void remove(){
        if(head == null){
            System.out.println("La lista è vuota");
        } else if (head.getNext() == null) {
            System.out.println("Ho tolto: " + head);
            head = null;
        }
        else{
            System.out.println("Ho tolto: " + head);
            head = head.getPrev();
            head.setNext(null);
        }
    }

    public String search(Nodo<T> value){
        Nodo<T> it = head;
        int cont = 1;
        boolean found = false;
        while(it != null && !found){
            if(it.isEqual(value)){
                found = true;
            }
            it = it.getNext();
            cont++;
        }

        if(found){
            return "Trovato! Si trova in posizione " + cont;
        }
        else{
            return "Il valore: " + value + " non è presente in lista";
        }
    }

    @Override
    public String toString() {
        String out = "";

        Nodo<T> iterator = head;
        while (iterator != null){
            out = out + iterator.getVal();
            if(iterator.getNext() != null){
                out = out + ", ";
            }
            else{
                out = out + ".";
            }
            iterator = iterator.getNext();
        }
        return out;
    }
}
