package hust.soict.globalict.aims.screen;

import hust.soict.globalict.aims.media.DigitalVideoDisc;
import hust.soict.globalict.aims.store.Store;
import hust.soict.globalict.aims.cart.Cart;
import javax.swing.*;

public class AddDigitalVideoDiscToStoreScreen extends AddItemToStoreScreen {
    private JTextField tfDirector, tfLength;

    public AddDigitalVideoDiscToStoreScreen(Store store, Cart cart) {
        super(store,cart, "Add DVD to Store");
    }

    @Override
    protected JPanel createCenter() {
        JPanel center = super.createCenter(); 
        
        center.add(new JLabel("Director:"));
        tfDirector = new JTextField();
        center.add(tfDirector);

        center.add(new JLabel("Length:"));
        tfLength = new JTextField();
        center.add(tfLength);

        JButton btnAdd = new JButton("Add DVD");
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
            int length = Integer.parseInt(tfLength.getText());

            DigitalVideoDisc dvd = new DigitalVideoDisc(title, category, cost, length, director);
            store.addMedia(dvd);
            
            JOptionPane.showMessageDialog(this, "DVD added successfully!");
            tfTitle.setText(""); tfCategory.setText(""); tfCost.setText("");
            tfDirector.setText(""); tfLength.setText("");
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(this, "Cost and Length must be numbers!", "Input Error", JOptionPane.ERROR_MESSAGE);
        }
    }
}