import java.util.Scanner;

public class Main {
    // Codici ANSI per i colori
    public static final String RESET = "\u001B[0m";
    public static final String RED = "\u001B[31m";
    public static final String GREEN = "\u001B[32m";
    public static final String YELLOW = "\u001B[33m";
    public static final String BLUE = "\u001B[34m";
    public static final String PURPLE = "\u001B[35m";
    public static final String CYAN = "\u001B[36m";
    public static final String WHITE = "\u001B[37m";
    public static final String BOLD = "\u001B[1m";

    private static BinaryTree<String> tree;
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        boolean running = true;

        System.out.println(GREEN + BOLD + "\n╔════════════════════════════════════════╗");
        System.out.println("║   BENVENUTO NEL TESTER BINARY TREE     ║");
        System.out.println("╚════════════════════════════════════════╝" + RESET);

        while (running) {
            printMenu();
            int choice = getChoice();

            switch (choice) {
                case 1:
                    createTree();
                    break;
                case 2:
                    addNode();
                    break;
                case 3:
                    viewInOrder();
                    break;
                case 4:
                    viewPreOrder();
                    break;
                case 5:
                    viewPostOrder();
                    break;
                case 6:
                    showTreeInfo();
                    break;
                case 0:
                    running = false;
                    System.out.println(CYAN + "\n👋 Grazie per aver utilizzato il tester!" + RESET);
                    break;
                default:
                    System.out.println(RED + "❌ Scelta non valida!" + RESET);
            }
        }

        scanner.close();
    }

    private static void printMenu() {
        System.out.println("\n" + BLUE + "═══════════════════════════════════════");
        System.out.println(BOLD + "            🌳 MENU PRINCIPALE" + RESET + BLUE);
        System.out.println("═══════════════════════════════════════" + RESET);

        System.out.println(YELLOW + "1." + RESET + " 🌱 Crea nuovo albero");
        System.out.println(YELLOW + "2." + RESET + " ➕ Aggiungi nodo");
        System.out.println(YELLOW + "3." + RESET + " 📋 Visualizza In-Order");
        System.out.println(YELLOW + "4." + RESET + " 📋 Visualizza Pre-Order");
        System.out.println(YELLOW + "5." + RESET + " 📋 Visualizza Post-Order");
        System.out.println(YELLOW + "6." + RESET + " ℹ️  Informazioni albero");
        System.out.println(YELLOW + "0." + RESET + " 🚪 Esci");

        System.out.println(BLUE + "═══════════════════════════════════════" + RESET);
        System.out.print(CYAN + "➤ Inserisci la tua scelta: " + RESET);
    }

    private static int getChoice() {
        try {
            return Integer.parseInt(scanner.nextLine());
        } catch (NumberFormatException e) {
            return -1;
        }
    }

    private static void createTree() {
        System.out.println("\n" + PURPLE + BOLD + "🌱 CREAZIONE NUOVO ALBERO" + RESET);
        System.out.print(WHITE + "Inserisci il valore della radice: " + RESET);
        String value = scanner.nextLine();

        Node<String> root = new Node<>(value);
        tree = new BinaryTree<>(root);

        System.out.println(GREEN + "✅ Albero creato con successo! Radice: " + value + RESET);
    }

    private static void addNode() {
        if (tree == null) {
            System.out.println(RED + "❌ Errore: Devi prima creare un albero!" + RESET);
            return;
        }

        System.out.println("\n" + PURPLE + BOLD + "➕ AGGIUNTA NODO" + RESET);
        System.out.print(WHITE + "Inserisci il valore del nodo: " + RESET);
        String value = scanner.nextLine();

        Node<String> newNode = new Node<>(value);
        tree.addToTree(tree.root, newNode);

        System.out.println(GREEN + "✅ Nodo '" + value + "' aggiunto all'albero!" + RESET);
    }

    private static void viewInOrder() {
        if (tree == null) {
            System.out.println(RED + "❌ Errore: Devi prima creare un albero!" + RESET);
            return;
        }

        System.out.println("\n" + PURPLE + BOLD + "📋 VISUALIZZAZIONE IN-ORDER (Sinistra-Radice-Destra)" + RESET);
        System.out.println(CYAN + "─────────────────────────────────────" + RESET);
        tree.viewInOrder(tree.root);
        System.out.println(CYAN + "─────────────────────────────────────" + RESET);
    }

    private static void viewPreOrder() {
        if (tree == null) {
            System.out.println(RED + "❌ Errore: Devi prima creare un albero!" + RESET);
            return;
        }

        System.out.println("\n" + PURPLE + BOLD + "📋 VISUALIZZAZIONE PRE-ORDER (Radice-Sinistra-Destra)" + RESET);
        System.out.println(CYAN + "─────────────────────────────────────" + RESET);
        tree.viewInPreOrder(tree.root);
        System.out.println(CYAN + "─────────────────────────────────────" + RESET);
    }

    private static void viewPostOrder() {
        if (tree == null) {
            System.out.println(RED + "❌ Errore: Devi prima creare un albero!" + RESET);
            return;
        }

        System.out.println("\n" + PURPLE + BOLD + "📋 VISUALIZZAZIONE POST-ORDER (Sinistra-Destra-Radice)" + RESET);
        System.out.println(CYAN + "─────────────────────────────────────" + RESET);
        tree.viewInPostOrder(tree.root);
        System.out.println(CYAN + "─────────────────────────────────────" + RESET);
    }

    private static void showTreeInfo() {
        if (tree == null) {
            System.out.println(RED + "❌ Errore: Devi prima creare un albero!" + RESET);
            return;
        }

        System.out.println("\n" + PURPLE + BOLD + "ℹ️  INFORMAZIONI ALBERO" + RESET);
        System.out.println(CYAN + "─────────────────────────────────────" + RESET);
        System.out.println(WHITE + "🌳 Radice: " + YELLOW + tree.root.getVal() + RESET);
        System.out.println(WHITE + "📏 Altezza (contatore): " + YELLOW + tree.h + RESET);
        System.out.println(CYAN + "─────────────────────────────────────" + RESET);
    }
}