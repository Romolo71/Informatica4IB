import java.util.Scanner;
import java.util.InputMismatchException;

public class Main {

    public static void main(String[] args) throws InputMismatchException {
        Rubrica rubrica = new Rubrica();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\n\n--- MENU RUBRICA TELEFONICA ---");
            System.out.println("1. Aggiungi nuovo contatto (ordinato)");
            System.out.println("2. Ricerca contatto");
            System.out.println("3. Elimina contatto");
            System.out.println("4. Visualizza elenco alfabetico");
            System.out.println("0. Esci");
            System.out.print("Scelta: ");

            int scelta = scanner.nextInt();
            scanner.nextLine();

            String cognome, nome, telefono, email;
            Contatto trovato;

            switch (scelta) {
                case 1:
                    System.out.println("\n--- AGGIUNGI CONTATTO ---");
                    System.out.print("Cognome: "); cognome = scanner.nextLine();
                    System.out.print("Nome: "); nome = scanner.nextLine();

                    if (rubrica.ricercaContatto(cognome, nome) != null) {
                        System.out.println("Errore: Contatto " + cognome + " " + nome + " già presente.");
                        break;
                    }

                    System.out.print("Telefono: "); telefono = scanner.nextLine();
                    System.out.print("Email: "); email = scanner.nextLine();

                    rubrica.aggiungiContatto(new Contatto(cognome, nome, telefono, email));
                    System.out.println("Contatto aggiunto e ordinato con successo.");
                    break;

                case 2:
                    System.out.println("\n--- RICERCA CONTATTO ---");
                    System.out.print("Cognome da cercare: "); cognome = scanner.nextLine();
                    System.out.print("Nome da cercare: "); nome = scanner.nextLine();
                    trovato = rubrica.ricercaContatto(cognome, nome);

                    if (trovato != null) {
                        System.out.println("\nContatto trovato:");
                        System.out.println(trovato.toString());
                    } else {
                        System.out.println("Contatto non trovato nella rubrica.");
                    }
                    break;

                case 3:
                    System.out.println("\n--- ELIMINA CONTATTO ---");
                    System.out.print("Cognome da eliminare: "); cognome = scanner.nextLine();
                    System.out.print("Nome da eliminare: "); nome = scanner.nextLine();

                    if (rubrica.eliminaContatto(cognome, nome)) {
                        System.out.println("Contatto eliminato con successo.");
                    } else {
                        System.out.println("Errore: Contatto non trovato o impossibile eliminare.");
                    }
                    break;

                case 4:
                    rubrica.visualizzaRubrica();
                    break;

                case 0:
                    System.out.println("Uscita dal programma. Arrivederci!");
                    scanner.close();
                    return;

                default:
                    System.out.println("Scelta non valida. Riprova.");
                    break;
            }
        }
    }
}