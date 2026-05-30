package hust.soict.globalict.aims.screen;

import hust.soict.globalict.aims.media.CompactDisc;
import hust.soict.globalict.aims.store.Store;
import hust.soict.globalict.aims.cart.Cart;
import javax.swing.*;

public class AddCompactDiscToStoreScreen extends AddItemToStoreScreen {
    private JTextField tfDirector, tfArtist;

    public AddCompactDiscToStoreScreen(Store store, Cart cart) {
        super(store,cart, "Add CD to Store");
    }

    @Override
    protected JPanel createCenter() {
        JPanel center = super.createCenter();
        
        center.add(new JLabel("Director:"));
        tfDirector = new JTextField();
        center.add(tfDirector);

        center.add(new JLabel("Artist:"));
        tfArtist = new JTextField();
        center.add(tfArtist);

        JButton btnAdd = new JButton("Add CD");
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
            String director = tfDirector.getText();
            String artist = tfArtist.getText();

            CompactDisc cd = new CompactDisc(title, category, artist, cost);
            store.addMedia(cd);
            
            JOptionPane.showMessageDialog(this, "CD added successfully!");
            
            tfTitle.setText(""); tfCategory.setText(""); tfCost.setText("");
            tfDirector.setText(""); tfArtist.setText("");
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(this, "Cost must be a number!", "Input Error", JOptionPane.ERROR_MESSAGE);
        }
    }
}