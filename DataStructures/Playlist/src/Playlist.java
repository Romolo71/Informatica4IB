import java.io.*;
import java.io.IOException;
import java.util.Scanner;

public class Playlist{
    private Track head;
    private Track current;

    public Playlist() {
        this.head = null;
        this.current = null;
    }

    public void addNextTrack(Track newTrack){
        Track truckMAN = newTrack;

        if(head == null){
            head = truckMAN;
            current = head;
        }

        else{
            truckMAN.setNext(current.getNext());
            current.getNext().setPrevious(truckMAN);

            truckMAN.setPrevious(current);
            current.setNext(truckMAN);
        }
    }

    public void addPreviousTrack(Track newTrack){
        Track truckMAN = newTrack;

        if(head == null){
            head = truckMAN;
            current = head;
        }

        else{
            truckMAN.setPrevious(current.getPrevious());
            current.getPrevious().setNext(truckMAN);

            truckMAN.setNext(current);
            current.setPrevious(truckMAN);
        }
    }

    public void setCurrent(Track current) {
        this.current = current;
    }

    public Track getCurrent() {
        return current;
    }

    public void setCurrentPrevious(){
        if(current.getPrevious() == null){
            System.out.println("Non hai brani precedenti al corrente (" + current + ")");
        }

        else{
            Track newCurrent = current.getPrevious();
            System.out.println("Il brano corrente è passato da :" + current + " al precedente (" + newCurrent + ")");
            current = newCurrent;
        }
    }

    public void setCurrentNext(){
        if(current.getNext() == null){
            System.out.println("Non hai brani successivi al corrente (" + current + ")");
        }

        else{
            Track newCurrent = current.getNext();
            System.out.println("Il brano corrente è passato da " + current + " al successivo (" + newCurrent + ")");
            current = newCurrent;
        }
    }

    public void getElenco(){
        Track t = head;
        if(t == null){
            System.out.println("La playlist è vuota, aggiungi dei brani!");
        }
        else{
            System.out.println("la Playlist contine: " + "\n");

            while(t != null){
                t.getInfo();
                t = t.getNext();
            }
        }
    }

    public void remove(){
        if(current == null){
            System.out.println("Non ci sono canzoni!");
        }

        else if(current.getPrevious() == null && current.getNext() == null){
            System.out.println("Rimuovo la canzone, è l'unica presente, vuoi continuare? (Y/n)");
            Scanner chooooose = new Scanner(System.in);
            String risposta = chooooose.nextLine();

            if(risposta.toLowerCase().equals("y")){
                System.out.println("Rimuovo la canzone");
                current = null;
                head = null;
            }
            else{
                System.out.println("Mi hai deluso, incoerente");
            }
        }

        else if(current.getPrevious() != null && current.getNext() == null){        //Se è il primo
            current = null;
        }

        else if(current.getNext() != null && current.getPrevious() != null){        //Se è uno qualsiasi
            current.getPrevious().setNext(current.getNext());
            current.getNext().setPrevious(current.getPrevious());
            current = null;
        }

        else{                                                                       //Se è l'ultimo
            current.getPrevious().setNext(null);
            current = null;
        }


    }

    public void export(String fileName) throws IOException{
        BufferedWriter writer = new BufferedWriter(new FileWriter("Playlist.csv"));
        Track i = head;

        while(i != null){
            writer.write(i.getInfo());
            if(i.getNext() != null){
                writer.newLine();
            }
            i = i.getNext();
        }
    }

    public void addFromFile(String filename) throws IOException{
        BufferedReader reader = new BufferedReader(new FileReader(filename));
        String line;
        while ((line = reader.readLine()) != null) {
            String[] parts = line.split(",");
            if (parts.length == 2) {
                Track brano = new Track(parts[0], parts[1], 0);
                this.addNextTrack(brano);
            }
        }

    }

    public boolean isEmpty() {
        if(head == null && current == null){
            return true;
        }
        else{
            return false;
        }
    }

    public void forward() {
        if (current.getNext() != null) {
            current = current.getNext();
        }
    }
    public void backward() {
        if (current.getPrevious() != null) {
            current = current.getPrevious();
        }
    }

    public int getSize() {
        int cont = 0;
        Track i = head;

        while(i != null){
            cont++;
            i = i.getNext();
        }
        return cont;
    }
}
