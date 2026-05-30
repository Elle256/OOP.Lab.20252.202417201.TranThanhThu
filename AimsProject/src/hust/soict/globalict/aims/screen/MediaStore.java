package hust.soict.globalict.aims.screen;

import javax.swing.*;
import java.awt.*;
import hust.soict.globalict.aims.media.*;
import hust.soict.globalict.aims.cart.Cart; 
import hust.soict.globalict.aims.exception.PlayerException; 
import hust.soict.globalict.aims.exception.LimitExceededException; 


public class MediaStore extends JPanel {
    private Media media;
    private Cart cart; 

    public MediaStore(Media media, Cart cart) {
        this.media = media;
        this.cart = cart;
        this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

        JLabel title = new JLabel(media.getTitle());
        title.setFont(new Font(title.getFont().getName(), Font.BOLD, 20));
        title.setAlignmentX(Component.CENTER_ALIGNMENT);
        JLabel cost = new JLabel("" + media.getCost() + " $");
        cost.setAlignmentX(Component.CENTER_ALIGNMENT);

        JPanel container = new JPanel();
        container.setLayout(new FlowLayout(FlowLayout.CENTER));

        JButton btnAddToCart = new JButton("Add to cart");
container.add(btnAddToCart);

btnAddToCart.addActionListener(e -> {
    try {
        cart.addMedia(media); 
        JOptionPane.showMessageDialog(this, 
            media.getTitle() + " has been added to your cart.", 
            "Cart Update", 
            JOptionPane.INFORMATION_MESSAGE);
            
    } catch (LimitExceededException ex) {
        JOptionPane.showMessageDialog(this, 
            "Cannot add to cart: " + ex.getMessage(), 
            "Cart Error", 
            JOptionPane.ERROR_MESSAGE);
    }
});

        if (media instanceof Playable) {
            JButton btnPlay = new JButton("Play");
            container.add(btnPlay);
            
            btnPlay.addActionListener(e -> {
                try {
                    String playMessage = "";
                    
                    
                    if (media instanceof DigitalVideoDisc) {
                        playMessage = ((DigitalVideoDisc) media).playGUI();
                    } else if (media instanceof CompactDisc) {
                        playMessage = ((CompactDisc) media).playGUI();
                    }
                    
                    
                    JOptionPane.showMessageDialog(this, 
                        playMessage, 
                        "Media Player", 
                        JOptionPane.INFORMATION_MESSAGE);
                        
                } catch (PlayerException ex) {
                    JOptionPane.showMessageDialog(this, 
                        ex.getMessage(), 
                        "Player Error", 
                        JOptionPane.ERROR_MESSAGE);
                }
            });
        }

        this.add(Box.createVerticalGlue());
        this.add(title);
        this.add(cost);
        this.add(Box.createVerticalGlue());
        this.add(container);

        this.setBorder(BorderFactory.createLineBorder(Color.BLACK));
    }
}