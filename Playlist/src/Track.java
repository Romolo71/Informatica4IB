public class Track {
    private Track previous;
    private Track next;
    private String title;
    private String author;
    private float length;

    public Track(String title, String author, float length) {
        this.previous = null;
        this.next = null;
        this.title = title;
        this.author = author;
        this.length = length;
    }

    public Track getPrevious() {
        return previous;
    }

    public Track getNext() {
        return next;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public float getLength() {
        return length;
    }

    public void setPrevious(Track previous) {
        this.previous = previous;
    }

    public void setNext(Track next) {
        this.next = next;
    }
}
