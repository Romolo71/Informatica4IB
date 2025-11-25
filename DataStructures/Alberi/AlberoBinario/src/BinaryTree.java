public class BinaryTree<T> {
    Node<T> root;
    int h;

    public BinaryTree(Node<T> root) {
        this.root = root;
        this.h = 0;
    }

    public void addToTree(Node<T> tmpRoot, Node<T> newNode){
        if(tmpRoot != null){
           boolean cond = newNode.compareTo(tmpRoot) >= 0;

           if(!cond && tmpRoot.left == null){
               tmpRoot.setLeft(newNode);

           }
           else if(cond && tmpRoot.right == null){
               tmpRoot.setRight(newNode);
           }
           else{
               addToTree(tmpRoot.left, newNode);
               addToTree(tmpRoot.right, newNode);
           }
        }
        h++;
    }

    public void viewInOrder(Node<T> nodo){
        if(nodo != null){
            viewInOrder(nodo.left);
            System.out.println(nodo);
            viewInOrder(nodo.right);
        }
    }

    public void viewInPreOrder(Node<T> nodo){
        if(nodo != null){
            System.out.println(nodo);
            viewInPreOrder(nodo.left);
            viewInPreOrder(nodo.right);
        }
    }

    public void viewInPostOrder(Node<T> nodo){
        if(nodo != null){
            viewInPostOrder(nodo.left);
            viewInPostOrder(nodo.right);
            System.out.println(nodo);
        }
    }

    public boolean find(T val){
        return findRec(root, val);
    }

    private boolean findRec(Node<T> n, T val){
        if(n.getVal().equals(val)){
            return true;
        }
        return findRec(n.getLeft(), val) || findRec(n.getRight(), val);
    }

    public int getLeafsCount(Node<T> n){
        int leafs = 0;

        if(n.getLeft() == null && n.getRight() == null){
            leafs++;
        }
        else{
            leafs += getLeafsCount(n.getLeft());
            leafs += getLeafsCount(n.getRight());
        }
        return leafs;
    }

    //  - Implementa un metodo cerca(int valore) che restituisce il nodo contenente valore (null se non esiste).        *
    //  - Implementa un metodo rimuovi(Nodo n) che rimuove il nodo selezionato ma non i suoi sottoalberi figli
    //  - Implementa un metodo calcolaAltezza() che restituisce l'altezza dell'albero                                   *
    //  - Implementa un metodo contaNodi() che restituisce il numero totale di nodi di un albero.                       *
    //  - Implementa un metodo sommaNodi() che restituisce la somma di tutti i nodi dell'albero.                        *
    //  - Implementa un metodo livelloNodo(Nodo n) che restituisce la profondità cui si trova il nodo dato.

    public Node<T> findNode(T val){
        Node<T> n = root;
        if(n.getVal().equals(val)){
            return n;
        }
        else{
            findNode(n.getLeft().getVal());
            findNode(n.getRight().getVal());
        }
        return null;
    }

    public void removeNode(Node<T> nodo){
        if(nodo != null){
            System.out.println("Il nodo che vuoi rimuovere non esiste! ");
        }
        if(nodo.getLeft() == null && nodo.getRight() == null){
            nodo = null;
        }
    }

    public int getH(){
        return h;
    }

    public int getNodeCount(){
        return nodeCountRec(root);
    }

    private int nodeCountRec(Node<T> nodo){
        int count = 0;
        if(nodo != null){
            nodeCountRec(nodo.left);
            count++;
            nodeCountRec(nodo.right);
        }
        return count;
    }

    public int getNodeSum(){
        int sum = 0;
        return (int) nodeSumRec(root, 0);
    }

    private Integer nodeSumRec(Node<T> nodo, int sum){
        if(nodo != null){
            nodeSumRec(nodo.left, sum);
            sum += (Integer) nodo.getVal();
            nodeSumRec(nodo.right, sum);
        }
        return sum;
    }

    public int getLevelNode(T n){
        Node<T> nodo = new Node<>(n);
        return getLevelNodeRec(nodo, root);
    }
    private int getLevelNodeRec(Node<T> nodo, Node<T> subtree){
        if(subtree == null) return Integer.MAX_VALUE - 1;
        if(subtree.equals(nodo)){
            return 0;
        }

        int stl = getLevelNodeRec(nodo, subtree.left) + 1;
        int str = getLevelNodeRec(nodo, subtree.right) + 1;

        if(stl != Integer.MAX_VALUE){
            return stl;
        }
        if(str != Integer.MAX_VALUE){
            return str;
        }
        return Integer.MAX_VALUE;
    }
}
