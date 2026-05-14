package hust.soict.globalict.aims.cart;
import hust.soict.globalict.aims.media.Media;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Cart {
    public static final int MAX_NUMBERS_ORDERED = 20;
    private List<Media> itemsOrdered = new ArrayList<Media>();

    public int getSize() { return itemsOrdered.size(); }
 
    public List<Media> getItemsOrdered() { return itemsOrdered; }

    public boolean addMedia(Media media) {
        if (itemsOrdered.size() >= MAX_NUMBERS_ORDERED) {
            System.out.println("Cart is full! Cannot add more than " + MAX_NUMBERS_ORDERED + " items.");
            return false;
        }
        if (itemsOrdered.contains(media)) {
            System.out.println("'" + media.getTitle() + "' is already in the cart.");
            return false;
        }
        itemsOrdered.add(media);
        System.out.println("'" + media.getTitle() + "' added to cart. Cart now has "
                + itemsOrdered.size() + " item(s).");
        return true;
    }

    public boolean removeMedia(Media media) {
        if (itemsOrdered.contains(media)) {
            itemsOrdered.remove(media);
            System.out.println("'" + media.getTitle() + "' removed from cart.");
            return true;
        }
        System.out.println("'" + media.getTitle() + "' not found in cart.");
        return false;
    }

    public float totalCost() {
        float total = 0f;
        for (Media m : itemsOrdered) {
            total += m.getCost();
        }
        return total;
    }

    public Media searchByTitle(String title) {
        for (Media m : itemsOrdered) {
            if (m.getTitle().equalsIgnoreCase(title)) return m;
        }
        return null;
    }
    public Media searchById(int id) {
        for (Media m : itemsOrdered) {
            if (m.getId() == id) return m;
        }
        return null;
    }
    public ArrayList<Media> searchByCategory(String category) {
        ArrayList<Media> result = new ArrayList<>();

        for (Media m : itemsOrdered) {
            if (m.getCategory() .equalsIgnoreCase(category)) {
                result.add(m);
            }
        }

        return result;
    }

    public Media searchByPrice(int price) {
        for (Media m : itemsOrdered) {
            if (m.getCost() == price) {
                return m;
            }
        }

    return null;
    }

    public ArrayList<Media> searchByPrice(int min, int max) {
        ArrayList<Media> result = new ArrayList<>();
        for (Media m : itemsOrdered) {
            if (m.getCost() >= min && m.getCost() <= max) {
                result.add(m);
            }
        }
        return result;
    }

    public void sortByCostTitle() {
        Collections.sort(itemsOrdered, Media.COMPARE_BY_COST_TITLE);
    }
    public void sortByTitleCost() {
        Collections.sort(itemsOrdered, Media.COMPARE_BY_TITLE_COST);
    }

    public void clear() {
        itemsOrdered.clear();
    }
    
    public void print() {
        System.out.println("-------------------CART--------------------------");
        if (itemsOrdered.isEmpty()) {
            System.out.println("  (Cart is empty)");
        } else {
            for (int i = 0; i < itemsOrdered.size(); i++) {
                Media m = itemsOrdered.get(i);
                System.out.printf("  %d. %-30s %10.2f $%n", (i + 1), m.getTitle(), m.getCost());
            }
        }
        System.out.println("--------------------------------------------------");
        System.out.printf("  Total cost: %.2f $%n", totalCost());
        System.out.println("--------------------------------------------------");
    }
    

}