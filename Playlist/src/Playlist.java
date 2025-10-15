import java.io.*;

public class Playlist {
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

    public void export(String fileName){

    }
}
