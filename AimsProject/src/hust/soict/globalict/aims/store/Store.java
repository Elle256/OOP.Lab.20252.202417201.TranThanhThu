package hust.soict.globalict.aims.store;

import java.util.ArrayList;
import java.util.List;
import hust.soict.globalict.aims.media.Media;

public class Store {
    private List<Media> itemsInStore = new ArrayList<Media>();
    
    public List<Media> getItemsInStore() { 
        return itemsInStore; 
    }
    
    public void addMedia(Media media) {
        if (!itemsInStore.contains(media)) {
            itemsInStore.add(media);
            System.out.println("[Store] Added successfully: " + media.getTitle());
        } else {
            System.out.println("[Store] " + media.getTitle() + " is already in the store.");
        }
    }

    public void removeMedia(Media media) {
        if (itemsInStore.contains(media)) {
            itemsInStore.remove(media);
            System.out.println("[Store] Removed successfully: " + media.getTitle());
        } else {
            System.out.println("[Store] Media not found: " + media.getTitle());
        }
    }

    public Media searchByTitle(String title) {
        for (Media m : itemsInStore) {
            if (title != null && title.equalsIgnoreCase(m.getTitle())) {
                return m;
            }
        }
        return null;
    }

    public Media searchById(int id) {
        for (Media m : itemsInStore) {
            if (m.getId() == id) {
                return m;
            }
        }
        return null;
    }
    
    public void print() {
        System.out.println("***********************STORE**********************");
        if (itemsInStore.isEmpty()) {
            System.out.println("  (Store is empty)");
        } else {
            for (int i = 0; i < itemsInStore.size(); i++) {
                Media m = itemsInStore.get(i);
                System.out.printf("  %d. %-30s %10.2f $%n", (i + 1), m.getTitle(), m.getCost());
            }
        }
        System.out.println("**************************************************");
    }
}