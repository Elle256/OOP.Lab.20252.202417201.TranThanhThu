package hust.soict.globalict.test.media;
import java.util.ArrayList;
import java.util.List;

import hust.soict.globalict.aims.media.*;

public class MediaTest {
    public static void main(String[] args) {

        List<Media> mediae = new ArrayList<Media>();

        // ===== DVD =====
        DigitalVideoDisc dvd =
                new DigitalVideoDisc(
                        "Interstellar",
                        "Sci-Fi",
                        15.99f,
                        169,
                        "Christopher Nolan"
                        
                        
                );

        // ===== BOOK =====
        Book book =
                new Book(
                        "Clean Architecture",
                        "Programming",
                        45.50f
                );

        book.addAuthor("Robert C. Martin");

        // ===== COMPACT DISC =====
        CompactDisc cd =
                new CompactDisc("Thriller", "Pop", "Michael Jackson", 12.99f,  "Quincy Jones");

        Track track1 =
                new Track(
                        "Shape of You",
                        233
                );

        Track track2 =
                new Track(
                        "Perfect",
                        263
                );

        Track track3 =
                new Track(
                        "Galway Girl",
                        170
                );

        cd.addTrack(track1);
        cd.addTrack(track2);
        cd.addTrack(track3);

        // ===== ADD MEDIA =====
        mediae.add(cd);
        mediae.add(book);
        mediae.add(dvd);

        // ===== DISPLAY MEDIA =====
        System.out.println("===== MEDIA LIST =====");

        for (Media media : mediae) {

            System.out.println(media.toString());
            System.out.println("--------------------------------");
        }
    }
}
