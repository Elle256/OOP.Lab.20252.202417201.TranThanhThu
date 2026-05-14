package hust.soict.globalict.aims;

import hust.soict.globalict.aims.cart.Cart;
import hust.soict.globalict.aims.media.*;
import hust.soict.globalict.aims.store.Store;

import java.util.Scanner;

public class Aims {

    private static Store store = new Store();
    private static Cart  cart  = new Cart();
    private static Scanner scanner = new Scanner(System.in);

    public static void showMenu() {
        System.out.println("\nAIMS: ");
        System.out.println("--------------------------------");
        System.out.println("1. View store");
        System.out.println("2. Update store");
        System.out.println("3. See current cart");
        System.out.println("0. Exit");
        System.out.println("--------------------------------");
        System.out.print("Please choose a number: 0-1-2-3: ");
    }
    
    public static void storeMenu() {
        System.out.println("\nOptions: ");
        System.out.println("--------------------------------");
        System.out.println("1. See a media's details");
        System.out.println("2. Add a media to cart");
        System.out.println("3. Play a media");
        System.out.println("4. See current cart");
        System.out.println("0. Back");
        System.out.println("--------------------------------");
        System.out.print("Please choose a number: 0-1-2-3-4: ");
    }

    public static void mediaDetailsMenu() {
        System.out.println("\nOptions: ");
        System.out.println("--------------------------------");
        System.out.println("1. Add to cart");
        System.out.println("2. Play");
        System.out.println("0. Back");
        System.out.println("--------------------------------");
        System.out.print("Please choose a number: 0-1-2: ");
    }

    public static void cartMenu() {
        System.out.println("\nOptions: ");
        System.out.println("--------------------------------");
        System.out.println("1. Filter medias in cart");
        System.out.println("2. Sort medias in cart");
        System.out.println("3. Remove media from cart");
        System.out.println("4. Play a media");
        System.out.println("5. Place order");
        System.out.println("0. Back");
        System.out.println("--------------------------------");
        System.out.print("Please choose a number: 0-1-2-3-4-5: ");
    }

    private static int readInt() {
        try {
            return Integer.parseInt(scanner.nextLine().trim());
        } catch (NumberFormatException e) {
            return -1;
        }
    }

    private static String readLine(String prompt) {
        System.out.print(prompt);
        return scanner.nextLine().trim();
    }

    private static Media findInStore(String title) {
        Media m = store.searchByTitle(title);
        if (m == null) System.out.println("No media found with title: '" + title + "'");
        return m;
    }

    private static Media findInCart(String title) {
        Media m = cart.searchByTitle(title);
        if (m == null) System.out.println("No media found with title: '" + title + "'");
        return m;
    }

    private static void viewStore() {
        store.print();
        boolean back = false;
        while (!back) {
            storeMenu();
            int choice = readInt();
            switch (choice) {
                case 1: seeMediaDetails(); break;
                case 2: addMediaToCart();  break;
                case 3: playMediaInStore(); break;
                case 4: viewCart();        break;
                case 0: back = true;       break;
                default: System.out.println("Invalid choice.");
            }
        }
    }

    private static void seeMediaDetails() {
        String title = readLine("Enter media title: ");
        if (title.isEmpty()) { System.out.println("Title cannot be empty."); return; }

        Media media = findInStore(title);
        if (media == null) return;

        System.out.println("\n" + media);

        boolean back = false;
        while (!back) {
            mediaDetailsMenu();
            int choice = readInt();
            switch (choice) {
                case 1:
                    cart.addMedia(media);
                    break;
                case 2:
                    if (media instanceof Playable) {
                        ((Playable) media).play();
                    } else {
                        System.out.println("This media type cannot be played.");
                    }
                    break;
                case 0:
                    back = true;
                    break;
                default:
                    System.out.println("Invalid choice.");
            }
        }
    }

    private static void addMediaToCart() {
        String title = readLine("Enter media title to add to cart: ");
        if (title.isEmpty()) { System.out.println("Title cannot be empty."); return; }
        Media media = findInStore(title);
        if (media != null) cart.addMedia(media);
    }

    private static void playMediaInStore() {
        String title = readLine("Enter media title to play: ");
        if (title.isEmpty()) { System.out.println("Title cannot be empty."); return; }
        Media media = findInStore(title);
        if (media == null) return;
        if (media instanceof Playable) {
            ((Playable) media).play();
        } else {
            System.out.println("'" + media.getTitle() + "' cannot be played (Books are not playable).");
        }
    }

    private static void updateStore() {
        System.out.println("\nUpdate Store:");
        System.out.println("1. Add media to store");
        System.out.println("2. Remove media from store");
        System.out.println("0. Back");
        System.out.print("Choose: ");
        int choice = readInt();
        switch (choice) {
            case 1: addMediaToStore();    break;
            case 2: removeMediaFromStore(); break;
            case 0: break;
            default: System.out.println("Invalid choice.");
        }
    }

    private static void addMediaToStore() {
        System.out.println("Choose media type:");
        System.out.println("1. Book  2. DVD  3. CD");
        System.out.print("Type: ");
        int type = readInt();
        switch (type) {
            case 1: {
                String title    = readLine("Title: ");
                String category = readLine("Category: ");
                float  cost     = Float.parseFloat(readLine("Cost: "));
                Book book = new Book(title, category, cost);
                String author;
                while (!(author = readLine("Add author (blank to finish): ")).isEmpty()) {
                    book.addAuthor(author);
                }
                store.addMedia(book);
                break;
            }
            case 2: {
                String title    = readLine("Title: ");
                String category = readLine("Category: ");
                float  cost     = Float.parseFloat(readLine("Cost: "));
                int    length   = Integer.parseInt(readLine("Length (min): "));
                String director = readLine("Director: ");
                store.addMedia(new DigitalVideoDisc(title, category, cost, length, director));
                break;
            }
            case 3: {
                String title    = readLine("Title: ");
                String category = readLine("Category: ");
                float  cost     = Float.parseFloat(readLine("Cost: "));
                String artist   = readLine("Artist: ");
                String director = readLine("Director: ");
                CompactDisc cd = new CompactDisc(title, category, director, cost, artist);
                String trackTitle;
                while (!(trackTitle = readLine("Add track title (blank to finish): ")).isEmpty()) {
                    int trackLen = Integer.parseInt(readLine("  Track length: "));
                    cd.addTrack(new Track(trackTitle, trackLen));
                }
                store.addMedia(cd);
                break;
            }
            default: System.out.println("Invalid type.");
        }
    }

    private static void removeMediaFromStore() {
        store.print();
        String title = readLine("Enter title of media to remove: ");
        Media media = findInStore(title);
        if (media != null) store.removeMedia(media);
    }

    private static void viewCart() {
        cart.print();
        boolean back = false;
        while (!back) {
            cartMenu();
            int choice = readInt();
            switch (choice) {
                case 1: filterCart();        break;
                case 2: sortCart();          break;
                case 3: removeFromCart();    break;
                case 4: playMediaInCart();   break;
                case 5: placeOrder();        back = true; break;
                case 0: back = true;         break;
                default: System.out.println("Invalid choice.");
            }
        }
    }

    private static void filterCart() {
        System.out.println("Filter by: 1. ID   2. Title");
        System.out.print("Choose: ");
        int f = readInt();
        if (f == 1) {
            int id = Integer.parseInt(readLine("Enter ID: "));
            Media m = cart.searchById(id);
            if (m != null) System.out.println(m);
            else System.out.println("Not found.");
        } else if (f == 2) {
            String title = readLine("Enter title: ");
            Media m = cart.searchByTitle(title);
            if (m != null) System.out.println(m);
            else System.out.println("Not found.");
        } else {
            System.out.println("Invalid.");
        }
    }

    private static void sortCart() {
        System.out.println("Sort by: 1. Title (then cost)   2. Cost (then title)");
        System.out.print("Choose: ");
        int s = readInt();
        if (s == 1) {
            cart.sortByTitleCost();
            System.out.println("Sorted by title.");
        } else if (s == 2) {
            cart.sortByCostTitle();
            System.out.println("Sorted by cost.");
        } else {
            System.out.println("Invalid.");
        }
        cart.print();
    }

    private static void removeFromCart() {
        cart.print();
        String title = readLine("Enter title to remove: ");
        Media media = findInCart(title);
        if (media != null) cart.removeMedia(media);
    }

    private static void playMediaInCart() {
        String title = readLine("Enter title to play: ");
        Media media = findInCart(title);
        if (media == null) return;
        if (media instanceof Playable) {
            ((Playable) media).play();
        } else {
            System.out.println("'" + media.getTitle() + "' cannot be played.");
        }
    }

    private static void placeOrder() {
        System.out.println("\n>>> Order placed successfully! Thank you for shopping at AIMS.");
        System.out.println(">>> Your cart has been cleared.");
        cart.clear();
    }


    private static void loadDemoData() {
        Book b1 = new Book("Clean Code", "Programming", 39.99f);
        b1.addAuthor("Robert C. Martin");
        store.addMedia(b1);

        Book b2 = new Book("Design Patterns", "Programming", 49.99f);
        b2.addAuthor("Gang of Four");
        store.addMedia(b2);

        DigitalVideoDisc dvd1 = new DigitalVideoDisc("Inception", "Sci-Fi", 9.99f, 148, "Christopher Nolan");
        store.addMedia(dvd1);

        DigitalVideoDisc dvd2 = new DigitalVideoDisc("The Matrix", "Action", 7.99f, 136, "Wachowski");
        store.addMedia(dvd2);

        CompactDisc cd1 = new CompactDisc("Thriller", "Pop", "Michael Jackson", 12.99f,  "Quincy Jones");
        cd1.addTrack(new Track("Wanna Be Startin' Somethin'", 363));
        cd1.addTrack(new Track("Billie Jean", 294));
        cd1.addTrack(new Track("Beat It", 258));
        store.addMedia(cd1);

        CompactDisc cd2 = new CompactDisc("Abbey Road", "Rock", "George Martin", 14.99f, "The Beatles");
        cd2.addTrack(new Track("Come Together", 259));
        cd2.addTrack(new Track("Something", 182));
        store.addMedia(cd2);

    }

    public static void main(String[] args) {
        loadDemoData();

        System.out.println("=== Polymorphism Demo (Section 11) ===");
        java.util.List<Media> mediae = new java.util.ArrayList<>();
        mediae.addAll(store.getItemsInStore());
        for (Media m : mediae) {
            System.out.println(m.toString());
            System.out.println("---");
        }

        // Main application loop
        boolean running = true;
        while (running) {
            showMenu();
            int choice = readInt();
            switch (choice) {
                case 1: viewStore();   break;
                case 2: updateStore(); break;
                case 3: viewCart();    break;
                case 0:
                    System.out.println("Goodbye!");
                    running = false;
                    break;
                default:
                    System.out.println("Invalid choice. Please enter 0, 1, 2, or 3.");
            }
        }
        scanner.close();
    }
}