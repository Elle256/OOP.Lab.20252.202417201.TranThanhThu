package hust.soict.globalict.aims.screen;

import hust.soict.globalict.aims.media.Book;
import hust.soict.globalict.aims.store.Store;
import hust.soict.globalict.aims.cart.Cart;
import javax.swing.*;

public class AddBookToStoreScreen extends AddItemToStoreScreen {
    private JTextField tfAuthor;

    public AddBookToStoreScreen(Store store, Cart cart) {
        super(store,cart, "Add Book to Store");
    }

    @Override
    protected JPanel createCenter() {
        JPanel center = super.createCenter();
        
        center.add(new JLabel("Author (comma separated):"));
        tfAuthor = new JTextField();
        center.add(tfAuthor);

        JButton btnAdd = new JButton("Add Book");
        btnAdd.addActionListener(e -> addItem());
        center.add(btnAdd);

        return center;
    }

    @Override
    protected void addItem() {
        try {
            String title = tfTitle.getText();
            String category = tfCategory.getText();
            float cost = Float.parseFloat(tfCost.getText());
            
            Book book = new Book(title, category, cost);
            
            String[] authors = tfAuthor.getText().split(",");
            for (String author : authors) {
                if(!author.trim().isEmpty()) {
                    book.addAuthor(author.trim());
                }
            }

            store.addMedia(book);
            JOptionPane.showMessageDialog(this, "Book added successfully!");
            
            tfTitle.setText(""); tfCategory.setText(""); tfCost.setText(""); tfAuthor.setText("");
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(this, "Cost must be a number!", "Input Error", JOptionPane.ERROR_MESSAGE);
        }
    }
}