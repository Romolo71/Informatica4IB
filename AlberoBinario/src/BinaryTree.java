@SuppressWarnings("unchecked")
public class BinaryTree<T> {
    Node<T> radice;
    int h;

    public BinaryTree(Node<T> radice) {
        this.radice = radice;
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

    public Node<T> addRicorsivo(Node<T> nodo, T valore){
        if (nodo == null)
            return new Node<T>(valore);

        if(valore
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
}
