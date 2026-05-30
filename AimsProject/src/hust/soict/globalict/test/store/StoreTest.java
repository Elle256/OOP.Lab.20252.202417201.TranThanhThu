package hust.soict.globalict.test.store;

import hust.soict.globalict.aims.media.Book;
import hust.soict.globalict.aims.media.CompactDisc;
import hust.soict.globalict.aims.media.DigitalVideoDisc;
import hust.soict.globalict.aims.media.Track;
import hust.soict.globalict.aims.store.Store;

public class StoreTest {

    public static void main(String[] args) {
        Store store = new Store();
        
        DigitalVideoDisc dvd1 = new DigitalVideoDisc("Inception", "Sci-Fi", 9.99f, 148, "Christopher Nolan");
        DigitalVideoDisc dvd2 = new DigitalVideoDisc("The Matrix", "Action", 7.99f, 136, "Wachowski");

        Book book1 = new Book("Clean Code", "Programming", 39.99f);
        book1.addAuthor("Robert C. Martin");

        Book book2 = new Book("Design Patterns", "Programming", 49.99f);
        book2.addAuthor("Gang of Four");

        CompactDisc cd1 = new CompactDisc("Thriller", "Pop", "Michael Jackson", 12.99f);
        Track t1 = new Track("Wanna Be Startin' Somethin'", 363);
        Track t2 = new Track("Billie Jean", 294);
        Track t3 = new Track("Beat It", 258);
        cd1.addTrack(t1);
        cd1.addTrack(t2);
        cd1.addTrack(t3);

        System.out.println("===== ADDING ITEMS TO STORE =====");
        store.addMedia(dvd1);
        store.addMedia(dvd2);
        store.addMedia(book1);
        store.addMedia(book2);
        store.addMedia(cd1);

        System.out.println("\n===== CURRENT STORE ITEMS =====");
        store.print();

        System.out.println("\n===== REMOVING 'The Matrix' FROM STORE =====");
        store.removeMedia(dvd2);

        System.out.println("\n===== STORE ITEMS AFTER REMOVAL =====");
        store.print();
    }
}