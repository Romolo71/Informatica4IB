import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Playlist playlist = new Playlist();
        boolean running = true;

        System.out.println("=== GESTORE PLAYLIST ===\n");

        while (running) {
            printMenu();
            System.out.print("Scegli un'opzione: ");

            int scelta = scanner.nextInt();
            scanner.nextLine(); // Consuma il newline

            switch (scelta) {
                case 1:
                    addTrackNext(scanner, playlist);
                    break;
                case 2:
                    addTrackPrev(scanner, playlist);
                    break;
                case 3:
                    showCurrent(playlist);
                    break;
                case 4:
                    forward(playlist);
                    break;
                case 5:
                    backward(playlist);
                    break;
                case 6:
                    removeCurrent(playlist);
                    break;
                case 7:
                    showPlaylist(playlist);
                    break;
                case 8:
                    showSize(playlist);
                    break;
                case 9:
                    exportPlaylist(scanner, playlist);
                    break;
                case 10:
                    importPlaylist(scanner, playlist);
                    break;
                case 0:
                    running = false;
                    System.out.println("Arrivederci!");
                    break;
                default:
                    System.out.println("Opzione non valida!\n");
            }
        }

        scanner.close();
    }

    private static void printMenu() {
        System.out.println("\n--- MENU ---");
        System.out.println("1. Aggiungi Track dopo il corrente");
        System.out.println("2. Aggiungi Track prima del corrente");
        System.out.println("3. Mostra Track corrente");
        System.out.println("4. Vai al Track successivo");
        System.out.println("5. Vai al Track precedente");
        System.out.println("6. Rimuovi Track corrente");
        System.out.println("7. Mostra tutta la playlist");
        System.out.println("8. Mostra dimensione playlist");
        System.out.println("9. Esporta playlist su file");
        System.out.println("10. Importa playlist da file");
        System.out.println("0. Esci");
        System.out.println("------------");
    }

    private static void addTrackNext(Scanner scanner, Playlist playlist) {
        System.out.print("Titolo: ");
        String titolo = scanner.nextLine();
        System.out.print("Artista: ");
        String artista = scanner.nextLine();
        System.out.println("Lunghezza: ");
        float lunghezza = scanner.nextFloat();

        Track Track = new Track(titolo, artista, lunghezza);
        playlist.addNextTrack(Track);
        System.out.println("✓ Track aggiunto dopo il corrente\n");
    }

    private static void addTrackPrev(Scanner scanner, Playlist playlist) {
        System.out.print("Titolo: ");
        String titolo = scanner.nextLine();
        System.out.print("Artista: ");
        String artista = scanner.nextLine();
        System.out.println("Lunghezza: ");
        float lunghezza = scanner.nextFloat();

        Track Track = new Track(titolo, artista, lunghezza);
        playlist.addPreviousTrack(Track);
        System.out.println("✓ Track aggiunto prima del corrente\n");
    }

    private static void showCurrent(Playlist playlist) {
        if (playlist.isEmpty()) {
            System.out.println("La playlist è vuota!\n");
        } else {
            System.out.println("Track corrente: " + playlist.getCurrent() + "\n");
        }
    }

    private static void forward(Playlist playlist) {
        if (playlist.isEmpty()) {
            System.out.println("La playlist è vuota!\n");
        } else {
            playlist.forward();
            System.out.println("✓ Passato al Track successivo\n");
        }
    }

    private static void backward(Playlist playlist) {
        if (playlist.isEmpty()) {
            System.out.println("La playlist è vuota!\n");
        } else {
            playlist.backward();
            System.out.println("✓ Passato al Track precedente\n");
        }
    }

    private static void removeCurrent(Playlist playlist) {
        if (playlist.isEmpty()) {
            System.out.println("La playlist è vuota!\n");
        } else {
            playlist.remove();
            System.out.println("✓ Track corrente rimosso\n");
        }
    }

    private static void showPlaylist(Playlist playlist) {
        System.out.println("Playlist: " + playlist.toString() + "\n");
    }

    private static void exportPlaylist(Scanner scanner, Playlist playlist) {
        System.out.print("Nome file (es. playlist.csv): ");
        String filename = scanner.nextLine();
        try {
            playlist.export(filename);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        System.out.println("✓ Playlist esportata in " + filename + "\n");
    }

    private static void importPlaylist(Scanner scanner, Playlist playlist) {
        System.out.print("Nome file (es. playlist.csv): ");
        String filename = scanner.nextLine();
        try {
            playlist.addFromFile(filename);
            System.out.println("✓ Playlist importata da " + filename + "\n");
        } catch (Exception e) {
            System.out.println("✗ Errore durante l'importazione: " + e.getMessage() + "\n");
        }
    }

    private static void showSize(Playlist playlist) {
        System.out.println("Dimensione playlist: " + playlist.getSize() + " brani\n");
    }
}