package hust.soict.globalict.aims.screen;

import javax.swing.*;
import java.awt.*;
import hust.soict.globalict.aims.media.*;

public class MediaStore extends JPanel {
    private Media media;

    public MediaStore(Media media) {
        this.media = media;
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
        if (media instanceof Playable) {
            JButton btnPlay = new JButton("Play");
            container.add(btnPlay);
            
            btnPlay.addActionListener(e -> {
                JOptionPane.showMessageDialog(this, 
                    "Playing: " + media.getTitle(), 
                    "Media Player", 
                    JOptionPane.INFORMATION_MESSAGE);
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