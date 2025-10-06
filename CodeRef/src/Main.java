
public class Main {
    public static void main(String[] args) {
        Coda<String> c = new Coda<>();

        c.enqueue("Sergio Perez");
        c.enqueue("Vito Antonio Liuzzi");
        c.enqueue("Vito Antonio Tanzi");
        c.enqueue("Jarno Trulli");
        c.enqueue("Giancarlo Fisichella");
        c.enqueue("Antonio Giovinazzi");
        c.enqueue("Alessandro Pierguidi");
        c.enqueue("Antonio Fuoco");
        c.enqueue("Robert Kubica");

        System.out.println(c);
        System.out.println();

        for (int i = 0; i < 5; i++) {
            c.dequeue();
        }

        System.out.println();
        System.out.println(c);
    }
}