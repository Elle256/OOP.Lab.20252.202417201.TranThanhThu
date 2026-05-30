package hust.soict.globalict.aims.cart;

import hust.soict.globalict.aims.exception.LimitExceededException; 
import hust.soict.globalict.aims.media.Media;
import java.util.ArrayList;
import java.util.Collections;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class Cart {
    public static final int MAX_NUMBERS_ORDERED = 20;
    private ObservableList<Media> itemsOrdered = FXCollections.observableArrayList();
    
    public int getSize() { 
        return itemsOrdered.size(); 
    }
    
    public ObservableList<Media> getItemsOrdered() {
        return itemsOrdered;
    }

    public void addMedia(Media media) throws LimitExceededException {
        if (itemsOrdered.size() >= MAX_NUMBERS_ORDERED) {
            throw new LimitExceededException("ERROR: The number of media has reached its limit (" + MAX_NUMBERS_ORDERED + ").");
        }
        
        if (itemsOrdered.contains(media)) {
            System.out.println("'" + media.getTitle() + "' is already in the cart.");
            return; 
        }
        itemsOrdered.add(media);
        System.out.println("'" + media.getTitle() + "' added to cart. Cart now has " + itemsOrdered.size() + " item(s).");
    }

    public boolean removeMedia(Media media) {
        if(itemsOrdered.isEmpty()) {
            System.out.println("Nothing to remove!");
            return false;
        }
        if (itemsOrdered.remove(media)) {
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
            if (m.getTitle() != null && m.getTitle().equalsIgnoreCase(title)) return m;
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
            if (m.getCategory() != null && m.getCategory().equalsIgnoreCase(category)) {
                result.add(m);
            }
        }
        return result;
    }

    public Media searchByPrice(float price) {
        for (Media m : itemsOrdered) {
            if (Math.abs(m.getCost() - price) < 0.001f) { 
                return m;
            }
        }
        return null;
    }

    public ArrayList<Media> searchByPrice(float min, float max) {
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