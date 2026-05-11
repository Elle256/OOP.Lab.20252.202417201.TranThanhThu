package hust.soict.globalict.aims.cart;

import java.util.ArrayList;

import hust.soict.globalict.aims.media.Media;

public class Cart {

    private ArrayList<Media> itemsOrdered
            = new ArrayList<Media>();

    public Cart() {

    }

    public void addMedia(Media media) {

        if (!itemsOrdered.contains(media)) {

            itemsOrdered.add(media);

            System.out.println("Added");
        } else {

            System.out.println(
                    "Media already exists");
        }
    }

    public void removeMedia(Media media) {

        if (itemsOrdered.contains(media)) {

            itemsOrdered.remove(media);

            System.out.println("Removed");
        } else {

            System.out.println(
                    "Media not found");
        }
    }

    public float totalCost() {

        float sum = 0;

        for (Media media : itemsOrdered) {
            sum += media.getCost();
        }

        return sum;
    }

    public void print() {

        System.out.println("Cart:");

        for (Media media : itemsOrdered) {
            System.out.println(media);
        }

        System.out.println(
                "Total cost: "
                        + totalCost());
    }
}