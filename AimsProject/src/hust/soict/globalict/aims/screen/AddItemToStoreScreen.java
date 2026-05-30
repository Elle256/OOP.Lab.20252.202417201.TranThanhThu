package hust.soict.globalict.aims.screen;

import javax.swing.*;
import java.awt.*;
import hust.soict.globalict.aims.store.Store;
import hust.soict.globalict.aims.cart.Cart;

public abstract class AddItemToStoreScreen extends JFrame {
    protected Store store;
    protected Cart cart; 
    protected JTextField tfTitle, tfCategory, tfCost;

    public AddItemToStoreScreen(Store store, Cart cart, String title) {
        this.store = store;
        this.cart = cart; 
        setTitle(title);
        setSize(1024, 768);
        setLayout(new BorderLayout());

        add(createMenuBar(), BorderLayout.NORTH);
        add(createCenter(), BorderLayout.CENTER);

        setLocationRelativeTo(null); 
        setVisible(true);
    }

    private JMenuBar createMenuBar() {
        JMenuBar menuBar = new JMenuBar();
        JMenu menuOptions = new JMenu("Options");
        JMenu menuUpdateStore = new JMenu("Update Store");

        JMenuItem addBook = new JMenuItem("Add Book");
        addBook.addActionListener(e -> { new AddBookToStoreScreen(store, cart); dispose(); });
        
        JMenuItem addCD = new JMenuItem("Add CD");
        addCD.addActionListener(e -> { new AddCompactDiscToStoreScreen(store, cart); dispose(); });
        
        JMenuItem addDVD = new JMenuItem("Add DVD");
        addDVD.addActionListener(e -> { new AddDigitalVideoDiscToStoreScreen(store, cart); dispose(); });

        menuUpdateStore.add(addBook);
        menuUpdateStore.add(addCD);
        menuUpdateStore.add(addDVD);

        JMenuItem viewStore = new JMenuItem("View store");
        viewStore.addActionListener(e -> { new StoreScreen(store, cart); dispose(); }); 

        JMenuItem viewCart = new JMenuItem("View cart");
        viewCart.addActionListener(e -> { new CartScreen(store,cart); dispose(); });

        menuOptions.add(menuUpdateStore);
        menuOptions.add(viewStore);
        menuOptions.add(viewCart); 

        menuBar.setLayout(new FlowLayout(FlowLayout.LEFT));
        menuBar.add(menuOptions);
        return menuBar;
    }

    protected JPanel createCenter() {
        JPanel center = new JPanel();
        center.setLayout(new GridLayout(0, 2, 10, 10)); 
        center.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));

        center.add(new JLabel("Title:"));
        tfTitle = new JTextField();
        center.add(tfTitle);

        center.add(new JLabel("Category:"));
        tfCategory = new JTextField();
        center.add(tfCategory);

        center.add(new JLabel("Cost:"));
        tfCost = new JTextField();
        center.add(tfCost);

        return center;
    }

    protected abstract void addItem();
}