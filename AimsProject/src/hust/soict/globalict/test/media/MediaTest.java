package hust.soict.globalict.test.media;

import java.util.ArrayList;
import java.util.Collections; 
import java.util.List;
import hust.soict.globalict.aims.media.*;
import hust.soict.globalict.aims.exception.PlayerException; 

public class MediaTest {
    public static void main(String[] args) {

        List<Media> mediae = new ArrayList<Media>();

        DigitalVideoDisc dvd = new DigitalVideoDisc("Interstellar", "Sci-Fi", 15.99f, 169, "Christopher Nolan");

        Book book = new Book("Clean Architecture", "Programming", 45.50f);
        book.addAuthor("Robert C. Martin");

        CompactDisc cd = new CompactDisc("Thriller", "Pop", "Michael Jackson", 12.99f);
        cd.addTrack(new Track("Shape of You", 233));
        cd.addTrack(new Track("Perfect", 263));
        cd.addTrack(new Track("Galway Girl", 170));

    
        mediae.add(cd);
        mediae.add(book);
        mediae.add(dvd);
        System.out.println("===== MEDIA LIST =====");
        for (Media media : mediae) {
            System.out.println(media.toString());
            System.out.println("--------------------------------");
        }

        System.out.println("\n===== SORTED BY TITLE THEN COST =====");
        Collections.sort(mediae, Media.COMPARE_BY_TITLE_COST);
        for (Media media : mediae) {
            System.out.printf("Title: %-20s | Cost: %.2f$%n", media.getTitle(), media.getCost());
        }
        System.out.println("\n===== TESTING PLAY FUNCTIONALITY =====");
        for (Media media : mediae) {
            if (media instanceof Playable) {
                System.out.println("Playing media: " + media.getTitle());
                try {
                    ((Playable) media).play();
                } catch (PlayerException e) {
                    System.err.println("Error playing " + media.getTitle() + ": " + e.getMessage());
                }
                System.out.println("--------------------------------");
            } else {
                System.out.println("'" + media.getTitle() + "' is a Book and cannot be played.\n---");
            }
        }
    }
}