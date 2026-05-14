package hust.soict.globalict.aims.media;

public class Track implements Playable {

    private String title;
    private int length;

    //Constructors
    public Track(){}
    public Track(String title, int length) {
        this.title = title;
        this.length = length;
    }

    //Getters
    public String getTitle() {
        return title;
    }

    public int getLength() {
        return length;
    }

    //Implement play()
    @Override
    public void play() {
        if (this.length <= 0) {
            System.out.println(
                "Cannot play track: " + this.getTitle());
            return;
        }
        System.out.println("Playing Track: " + this.getTitle());
        System.out.println("Track length: " + this.getLength());
    }

    @Override
    public boolean equals(Object obj) {
        if(this == obj) return true;
        if (obj instanceof Track) {
            Track other = (Track) obj;
            return this.title.equals(other.title) && this.length == other.length && this.title !=null;
        }

        return false;
    }

@Override
public String toString() {
    return "Track: " + title + " - length: " + length;
}
}
