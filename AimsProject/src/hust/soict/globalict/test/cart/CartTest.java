package hust.soict.globalict.test.cart;
import hust.soict.globalict.aims.cart.Cart;
import hust.soict.globalict.aims.media.DigitalVideoDisc;
import hust.soict.globalict.aims.media.Book;


public class CartTest {
    public static void main(String[] args) {
     
        Cart cart = new Cart();
        
        DigitalVideoDisc dvd1 = new DigitalVideoDisc("The Lion King", "Animation",19.95f,87, "Roger Allers"); 
        cart.addMedia(dvd1);

        Book bk = new Book("The Lion Queen", "Animation",19);; 
        cart.addMedia(bk);


        DigitalVideoDisc dvd2 = new DigitalVideoDisc("Star War", "Science Fiction",24.95f,56, "George Lucas"); 
        cart.addMedia(dvd2);

        DigitalVideoDisc dvd3 = new DigitalVideoDisc("Aladin", "Animation", 18.99f);
        cart.addMedia(dvd3);

        cart.print();

        System.out.println(cart.searchById(1));
        System.out.println(cart.searchByTitle("Star War"));
        System.out.println(cart.searchByCategory("Animation"));
        System.out.println(cart.searchByPrice(19));
        System.out.println(cart.searchByPrice(20,25));

    }
}