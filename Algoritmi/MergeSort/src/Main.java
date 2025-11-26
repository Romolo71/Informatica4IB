import java.util.*;

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
    public static final String TEAL = "\\e[1;96m";

    private static Scanner scanner = new Scanner(System.in);

    //╔════════════════════════════════════════════════════════════╗
    //║                          MAIN                              ║
    //╚════════════════════════════════════════════════════════════╝
    public static void main(String[] args) {

        boolean running = true;

        System.out.println(GREEN + BOLD + "\n╔════════════════════════════════════════╗");
        System.out.println("║      BENVENUTO NEL TESTER MERGE SORT   ║");
        System.out.println("╚════════════════════════════════════════╝" + RESET);


        while (running) {
            printMenu();
            int choice = getChoice();

            switch (choice) {
                case 1 -> sortInt();
                case 2 -> sortDouble();
                case 3 -> sortFloat();
                case 4 -> sortChar();
                case 5 -> sortString();
                case 6 -> sortGeneric();
                case 7 -> sortArrayList();
                case 0 -> {
                    running = false;
                    System.out.println(CYAN + "\n👋 Grazie per aver utilizzato il tester!" + RESET);
                }
                default -> System.out.println(RED + "❌ Scelta non valida!" + RESET);
            }
        }

        scanner.close();
    }

    //╔════════════════════════════════════════════════════════════╗
    //║                        MENU                                ║
    //╚════════════════════════════════════════════════════════════╝
    private static void printMenu() {
        System.out.println("\n" + BLUE + "═══════════════════════════════════════");
        System.out.println(BOLD + "            🔢 MENU MERGE SORT" + RESET + BLUE);
        System.out.println("═══════════════════════════════════════" + RESET);

        System.out.println(YELLOW + "1." + RESET + "  🔢 Ordina int[]");
        System.out.println(YELLOW + "2." + RESET + "  🔢 Ordina double[]");
        System.out.println(YELLOW + "3." + RESET + "  🔢 Ordina float[]");
        System.out.println(YELLOW + "4." + RESET + "  🔤 Ordina char[]");
        System.out.println(YELLOW + "5." + RESET + "  🔤 Ordina String[]");
        System.out.println(YELLOW + "6." + RESET + "  📦 Ordina T[] (Generics)");
        System.out.println(YELLOW + "7." + RESET + "  📜 Ordina ArrayList<T>");
        System.out.println(YELLOW + "0." + RESET + "  🚪 Esci");

        System.out.println(BLUE + "═══════════════════════════════════════" + RESET);
        System.out.print(CYAN + "➤ Inserisci la tua scelta: " + RESET);
    }

    private static int getChoice() {
        try { return Integer.parseInt(scanner.nextLine()); }
        catch (Exception e) { return -1; }
    }

    //╔════════════════════════════════════════════════════════════╗
    //║                    LETTURA ARRAY                           ║
    //╚════════════════════════════════════════════════════════════╝
    private static int[] readIntArray() {
        System.out.print(WHITE + "Inserisci numeri separati da virgola e spazio: " + RESET);
        String[] p = scanner.nextLine().split(", ");
        int[] arr = new int[p.length];
        for (int i = 0; i < p.length; i++) arr[i] = Integer.parseInt(p[i]);
        return arr;
    }

    private static double[] readDoubleArray() {
        System.out.print(WHITE + "Inserisci numeri separati da virgola e spazio: " + RESET);
        String[] p = scanner.nextLine().split(", ");
        double[] arr = new double[p.length];
        for (int i = 0; i < p.length; i++) arr[i] = Double.parseDouble(p[i]);
        return arr;
    }

    private static float[] readFloatArray() {
        System.out.print(WHITE + "Inserisci numeri separati da virgola e spazio: " + RESET);
        String[] p = scanner.nextLine().split(", ");
        float[] arr = new float[p.length];
        for (int i = 0; i < p.length; i++) arr[i] = Float.parseFloat(p[i]);
        return arr;
    }

    private static char[] readCharArray() {
        System.out.print(WHITE + "Inserisci caratteri senza spazi: " + RESET);
        return scanner.nextLine().toCharArray();
    }

    private static String[] readStringArray() {
        System.out.print(WHITE + "Inserisci parole separate da virgola e spazio: " + RESET);
        return scanner.nextLine().split(", ");
    }

    //╔════════════════════════════════════════════════════════════╗
    //║                LETTURA CLASSE GENERICA                     ║
    //╚════════════════════════════════════════════════════════════╝

    private static Persona[] randArray(int len) {          //Modificare in base alla classe creatasi
        Persona[] arr = new Persona[len];
        Random Strings = new Random();
        Random inter = new Random();
        for (int i = 0; i < len; i++){
            arr[i] = new Persona("Persona " + Strings.nextInt(100), inter.nextInt(100));
        }
        return arr;
    }

    //╔════════════════════════════════════════════════════════════╗
    //║                  METODI DI SORTING                         ║
    //╚════════════════════════════════════════════════════════════╝

    private static void sortInt() {
        System.out.println(PURPLE + BOLD + "\n🔢 MERGE SORT INT" + RESET);
        int[] arr = readIntArray();
        mergeSort(arr);
        System.out.println(GREEN + "Risultato: " + Arrays.toString(arr) + RESET);
    }

    private static void sortDouble() {
        System.out.println(PURPLE + BOLD + "\n🔢 MERGE SORT DOUBLE" + RESET);
        double[] arr = readDoubleArray();
        mergeSort(arr);
        System.out.println(GREEN + "Risultato: " + Arrays.toString(arr) + RESET);
    }

    private static void sortFloat() {
        System.out.println(PURPLE + BOLD + "\n🔢 MERGE SORT FLOAT" + RESET);
        float[] arr = readFloatArray();
        mergeSort(arr);
        System.out.println(GREEN + "Risultato: " + Arrays.toString(arr) + RESET);
    }

    private static void sortChar() {
        System.out.println(PURPLE + BOLD + "\n🔤 MERGE SORT CHAR" + RESET);
        char[] arr = readCharArray();
        mergeSort(arr);
        System.out.println(GREEN + "Risultato: " + Arrays.toString(arr) + RESET);
    }

    private static void sortString() {
        System.out.println(PURPLE + BOLD + "\n🔤 MERGE SORT STRING" + RESET);
        String[] arr = readStringArray();
        mergeSort(arr);
        System.out.println(GREEN + "Risultato: " + Arrays.toString(arr) + RESET);
    }

    private static void sortGeneric() {
        System.out.println(PURPLE + BOLD + "\n📦 MERGE SORT GENERICS (T[])" + RESET);
        System.out.println(TEAL + "Iserisci la quanto lungo deve essere l'array: " + RESET);
        int len = scanner.nextInt();
        Persona[] arr = randArray(len);
        mergeSort(arr);
        System.out.println(GREEN + "Risultato: " + Arrays.toString(arr) + RESET);
    }

    private static void sortArrayList() {
        System.out.println(PURPLE + BOLD + "\n📜 MERGE SORT ARRAYLIST<T>" + RESET);
        String[] arr = readStringArray();

        ArrayList<String> list = new ArrayList<>(Arrays.asList(arr));

        mergeSort(list);

        System.out.println(GREEN + "Risultato: " + list + RESET);
    }

    //╔════════════════════════════════════════════════════════════╗
    //║                TUTTE LE VERSIONI DI MERGE SORT             ║
    //╚════════════════════════════════════════════════════════════╝

    // INT
    public static void mergeSort(int[] arr) {
        if (arr.length <= 1) return;
        int mid = arr.length / 2;

        int[] left = Arrays.copyOfRange(arr, 0, mid);
        int[] right = Arrays.copyOfRange(arr, mid, arr.length);

        mergeSort(left);
        mergeSort(right);
        merge(arr, left, right);
    }
    private static void merge(int[] arr, int[] L, int[] R) {
        int i = 0, j = 0, k = 0;
        while (i < L.length && j < R.length)
            arr[k++] = (L[i] <= R[j]) ? L[i++] : R[j++];
        while (i < L.length) arr[k++] = L[i++];
        while (j < R.length) arr[k++] = R[j++];
    }


    // DOUBLE

    public static void mergeSort(double[] arr) {
        if (arr.length <= 1) return;
        int mid = arr.length / 2;

        double[] left = Arrays.copyOfRange(arr, 0, mid);
        double[] right = Arrays.copyOfRange(arr, mid, arr.length);

        mergeSort(left);
        mergeSort(right);
        merge(arr, left, right);
    }
    private static void merge(double[] arr, double[] L, double[] R) {
        int i = 0, j = 0, k = 0;
        while (i < L.length && j < R.length)
            arr[k++] = (L[i] <= R[j]) ? L[i++] : R[j++];
        while (i < L.length) arr[k++] = L[i++];
        while (j < R.length) arr[k++] = R[j++];
    }

    // FLOAT
    public static void mergeSort(float[] arr) {
        if (arr.length <= 1) return;
        int mid = arr.length / 2;

        float[] left = Arrays.copyOfRange(arr, 0, mid);
        float[] right = Arrays.copyOfRange(arr, mid, arr.length);

        mergeSort(left);
        mergeSort(right);
        merge(arr, left, right);
    }
    private static void merge(float[] arr, float[] L, float[] R) {
        int i = 0, j = 0, k = 0;
        while (i < L.length && j < R.length)
            arr[k++] = (L[i] <= R[j]) ? L[i++] : R[j++];
        while (i < L.length) arr[k++] = L[i++];
        while (j < R.length) arr[k++] = R[j++];
    }

    // CHAR
    public static void mergeSort(char[] arr) {
        if (arr.length <= 1) return;
        int mid = arr.length / 2;

        char[] left = Arrays.copyOfRange(arr, 0, mid);
        char[] right = Arrays.copyOfRange(arr, mid, arr.length);

        mergeSort(left);
        mergeSort(right);
        merge(arr, left, right);
    }
    private static void merge(char[] arr, char[] L, char[] R) {
        int i = 0, j = 0, k = 0;
        while (i < L.length && j < R.length)
            arr[k++] = (L[i] <= R[j]) ? L[i++] : R[j++];
        while (i < L.length) arr[k++] = L[i++];
        while (j < R.length) arr[k++] = R[j++];
    }

    // STRING & GENERICS T
    public static <T extends Comparable<? super T>> void mergeSort(T[] arr) {
        if (arr.length <= 1) return;

        int mid = arr.length / 2;

        T[] left = Arrays.copyOfRange(arr, 0, mid);
        T[] right = Arrays.copyOfRange(arr, mid, arr.length);

        mergeSort(left);
        mergeSort(right);
        merge(arr, left, right);
    }
    private static <T extends Comparable<? super T>> void merge(T[] arr, T[] L, T[] R) {
        int i = 0, j = 0, k = 0;
        while (i < L.length && j < R.length)
            arr[k++] = (L[i].compareTo(R[j]) <= 0) ? L[i++] : R[j++];
        while (i < L.length) arr[k++] = L[i++];
        while (j < R.length) arr[k++] = R[j++];
    }

    // ARRAYLIST
    public static <T extends Comparable<? super T>> void mergeSort(ArrayList<T> list) {
        if (list.size() <= 1) return;

        int mid = list.size() / 2;

        ArrayList<T> left = new ArrayList<>(list.subList(0, mid));
        ArrayList<T> right = new ArrayList<>(list.subList(mid, list.size()));

        mergeSort(left);
        mergeSort(right);

        merge(list, left, right);
    }
    private static <T extends Comparable<? super T>>
    void merge(ArrayList<T> list, ArrayList<T> L, ArrayList<T> R) {
        int i = 0, j = 0, k = 0;

        while (i < L.size() && j < R.size()) {
            if (L.get(i).compareTo(R.get(j)) <= 0)
                list.set(k++, L.get(i++));
            else
                list.set(k++, R.get(j++));
        }

        while (i < L.size()) list.set(k++, L.get(i++));
        while (j < R.size()) list.set(k++, R.get(j++));
    }
}