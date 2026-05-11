/*package hust.soict.globalict.aims;
import hust.soict.globalict.aims.cart.Cart;
import hust.soict.globalict.aims.media.DigitalVideoDisc;

public class Aims {
    public static void main(String[] args){
        Cart anOrder = new Cart();

        DigitalVideoDisc dvd1 = new DigitalVideoDisc("The Lion King", "Animation", "Roger Allers",87,19.95f);
        anOrder.addDigitalVideoDisc(dvd1);

        DigitalVideoDisc dvd2 = new DigitalVideoDisc("Star Wars", "Science Fiction", "George Lucas",87,24.95f);
        anOrder.addDigitalVideoDisc(dvd2);

        DigitalVideoDisc dvd3 = new DigitalVideoDisc("Aladin", "Animation", 18.99f);
        anOrder.addDigitalVideoDisc(dvd3);

        System.out.println("--------------------------------------");
        System.out.println("Total Cost is: ");
        System.out.println(anOrder.totalCost());
        System.out.println("--------------------------------------------");

        anOrder.removeDigitalVideoDisc(dvd2);
        System.out.println("Total Cost is: ");
        System.out.println(anOrder.totalCost());
    }
}*/

package hust.soict.globalict.aims;

import hust.soict.globalict.aims.cart.Cart;
import hust.soict.globalict.aims.media.*;
import hust.soict.globalict.aims.store.Store;

public class Aims {

    public static void main(String[] args) {

        Store store = new Store();
        Cart cart = new Cart();

        Book book = new Book(
                1,
                "Java",
                "Programming",
                10f
        );

        DigitalVideoDisc dvd
                = new DigitalVideoDisc(
                2,
                "Batman",
                "Action",
                "Nolan",
                120,
                20f
        );

        CompactDisc cd
                = new CompactDisc(
                3,
                "Hits",
                "Music",
                "ABC",
                15f,
                "Taylor"
        );

        store.addMedia(book);
        store.addMedia(dvd);
        store.addMedia(cd);

        cart.addMedia(book);
        cart.addMedia(cd);

        cart.print();
    }
}
