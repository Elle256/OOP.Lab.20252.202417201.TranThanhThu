package hust.soict.globalict.aims.screen;

import javax.swing.*;
import java.awt.*;
import java.util.List;
import hust.soict.globalict.aims.store.Store;
import hust.soict.globalict.aims.media.*;

// --- CLASS MEDIASTORE (Ô HIỂN THỊ TỪNG SẢN PHẨM) ---
class MediaStore extends JPanel {
    private Media media;

    public MediaStore(Media media) {
        this.media = media;
        this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

        // Tiêu đề sản phẩm
        JLabel title = new JLabel(media.getTitle());
        title.setFont(new Font(title.getFont().getName(), Font.BOLD, 20));
        title.setAlignmentX(Component.CENTER_ALIGNMENT);

        // Giá tiền
        JLabel cost = new JLabel("" + media.getCost() + " $");
        cost.setAlignmentX(Component.CENTER_ALIGNMENT);

        // Khung chứa các nút bấm hành động
        JPanel container = new JPanel();
        container.setLayout(new FlowLayout(FlowLayout.CENTER));

        JButton btnAddToCart = new JButton("Add to cart");
        container.add(btnAddToCart);

        // Nếu sản phẩm thuộc loại có thể phát nhạc/phim (Playable) thì thêm nút Play
        if (media instanceof Playable) {
            JButton btnPlay = new JButton("Play");
            container.add(btnPlay);
            
            // Xử lý sự kiện bấm nút Play (Tạm thời hiển thị Dialog)
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

// --- CLASS MAIN STORESCREEN (MÀN HÌNH CHÍNH) ---
public class StoreScreen extends JFrame {
    private Store store;

    public StoreScreen(Store store) {
        this.store = store;
        Container cp = getContentPane();
        cp.setLayout(new BorderLayout());

        cp.add(createNorth(), BorderLayout.NORTH);
        cp.add(createCenter(), BorderLayout.CENTER);

        setTitle("Store Management System");
        setSize(1024, 768);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }

    // Tạo thanh công cụ phía trên (Menu và Header)
    JPanel createNorth() {
        JPanel north = new JPanel();
        north.setLayout(new BoxLayout(north, BoxLayout.Y_AXIS));
        north.add(createMenuBar());
        north.add(createHeader());
        return north;
    }

    // Tạo thanh MenuBar
    JMenuBar createMenuBar() {
        JMenuBar menuBar = new JMenuBar();
        
        JMenu menuOptions = new JMenu("Options");
        JMenu menuUpdateStore = new JMenu("Update Store");
        
        menuUpdateStore.add(new JMenuItem("Add Book"));
        menuUpdateStore.add(new JMenuItem("Add CD"));
        menuUpdateStore.add(new JMenuItem("Add DVD"));
        
        menuOptions.add(menuUpdateStore);
        menuOptions.add(new JMenuItem("View cart"));
        menuOptions.add(new JMenuItem("Exit"));
        
        menuBar.add(menuOptions);
        return menuBar;
    }

    // Tạo Header hiển thị tiêu đề và nút xem giỏ hàng
    JPanel createHeader() {
        JPanel header = new JPanel();
        header.setLayout(new BoxLayout(header, BoxLayout.X_AXIS));

        JLabel title = new JLabel("AIMS STORE");
        title.setFont(new Font(title.getFont().getName(), Font.BOLD, 30));
        title.setForeground(Color.CYAN);

        JButton btnCart = new JButton("View cart");
        btnCart.setPreferredSize(new Dimension(100, 50));
        btnCart.setMaximumSize(new Dimension(100, 50));

        header.add(Box.createHorizontalStrut(10));
        header.add(title);
        header.add(Box.createHorizontalGlue());
        header.add(btnCart);
        header.add(Box.createHorizontalStrut(10));

        header.setBackground(Color.DARK_GRAY);
        return header;
    }

    // Tạo khu vực lưới hiển thị danh sách hàng hóa
    JPanel createCenter() {
        JPanel center = new JPanel();
        List<Media> mediaInStore = store.getItemsInStore();
        
        // Tạo lưới gồm 3 cột, số hàng tự động tính dựa trên lượng item
        center.setLayout(new GridLayout(0, 3, 10, 10));

        for (Media media : mediaInStore) {
            MediaStore cell = new MediaStore(media);
            center.add(cell);
        }

        return center;
    }

    public static void main(String[] args) {
        Store store = new Store();

        // Nạp dữ liệu mẫu
        store.addMedia(new DigitalVideoDisc("The Lion King", "Animation", "Roger Allers", 19.95f));
        store.addMedia(new DigitalVideoDisc("Star Wars", "Science Fiction", "George Lucas", 24.95f));
        store.addMedia(new DigitalVideoDisc("Aladdin", "Animation", "John Musker", 18.99f));
        store.addMedia(new DigitalVideoDisc("Interstellar", "Sci-Fi", 15.99f, 169, "Christopher Nolan"));
               
        Book book = new Book("Java Core", "Technology", 15.50f);
        book.addAuthor("Cay Horstmann");
        store.addMedia(book);

        CompactDisc cd = new CompactDisc("Greatest Hits", "Pop", "Michael Jackson", 20.00f, "Michael Jackson");
        store.addMedia(cd);

        new StoreScreen(store);
    }
}