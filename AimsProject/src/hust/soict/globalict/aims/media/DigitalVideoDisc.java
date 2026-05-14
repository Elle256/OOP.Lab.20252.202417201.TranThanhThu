package hust.soict.globalict.aims.media;


public class DigitalVideoDisc extends Disc implements Playable {
    
    // Constructor 
    public DigitalVideoDisc(){
        super();
    }
    public DigitalVideoDisc(String title) {
        super(title);
    } 
    public DigitalVideoDisc(String title, String category, float cost) {
        super(title, category, cost);
    }
    public DigitalVideoDisc(String title, String category, String director, float cost) {
        super(title, category, director, cost);
    }
    public DigitalVideoDisc(String title, String category, float cost, int length, String director) {
        super(title, category, cost, length, director);
    }


    @Override
    public String toString() {
        return this.getId() + " - DVD: " + this.getTitle() +
                " - Category: " + this.getCategory() +
                " - Director: " + this.getDirector() +
                " - DVD length: " + this.getLength() +
                " - Cost: " + this.getCost() + "$";
    }

    // Play method
    @Override
    public void play() {
        if (getLength() <= 0) {
            System.out.println("ERROR: DVD '" + getTitle() + "' cannot be played (invalid length).");
            return;
        }
        System.out.println("Playing DVD: " + getTitle());
        System.out.println("DVD length: " + getLength());
    }
}