package hust.soict.globalict.aims.screen.CartScreen;

import javax.swing.JFrame;
import javafx.application.Platform;
import javafx.embed.swing.JFXPanel;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import hust.soict.globalict.aims.cart.Cart;
import hust.soict.globalict.aims.media.Book;
import hust.soict.globalict.aims.media.CompactDisc;
import hust.soict.globalict.aims.media.DigitalVideoDisc;

public class CartScreen extends JFrame {
    private Cart cart;

    public CartScreen(Cart cart) {
        super();
        this.cart = cart;

        JFXPanel fxPanel = new JFXPanel();
        this.add(fxPanel);

        this.setTitle("Cart Management System");
        this.setSize(1024, 768);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);

        Platform.runLater(new Runnable() {
            @Override
            public void run() {
                try {
                    FXMLLoader loader = new FXMLLoader(getClass().getResource("CartScreen.fxml"));
                    
                    CartScreenController controller = new CartScreenController(cart);
                    loader.setController(controller);
                    
                    Parent root = loader.load();
                    fxPanel.setScene(new Scene(root));
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    public static void main(String[] args) {
        Cart testCart = new Cart();

        testCart.addMedia(new DigitalVideoDisc("The Lion King", "Animation", "Roger Allers", 19.95f));
        testCart.addMedia(new DigitalVideoDisc("Star Wars", "Science Fiction", "George Lucas", 24.95f));
        
        Book book = new Book("Design Patterns", "Technology", 35.00f);
        book.addAuthor("Erich Gamma");
        testCart.addMedia(book);

        CompactDisc cd = new CompactDisc("Thriller", "Pop", "Michael Jackson", 15.00f, "Michael Jackson");
        testCart.addMedia(cd);

        new CartScreen(testCart);
    }
}