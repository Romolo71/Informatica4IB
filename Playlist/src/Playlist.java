public class Playlist {
    private Track head;
    private Track current;

    public Playlist() {
        this.head = null;
        this.current = null;
    }

    public void setNextTrack(Track newTrack){
        Track truckMAN = newTrack;

        if(head == null){
            head = truckMAN;
            current = head;
        }

        else{
            current.setNext(truckMAN);
            truckMAN.setPrevious(current);
            current = truckMAN;
        }
    }

    public void setPreviousTrack(Track newTrack){
        Track truckMAN = newTrack;

        if(head == null){
            head = truckMAN;
            current = head;
        }

        else{
            truckMAN.setNext(current);

        }
    }
}
