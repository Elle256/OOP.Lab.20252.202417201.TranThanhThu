package hust.soict.globalict.aims.store;

import java.util.ArrayList;

import hust.soict.globalict.aims.media.Media;

public class Store {

    private ArrayList<Media> itemsInStore
            = new ArrayList<Media>();

    public void addMedia(Media media) {

        if (!itemsInStore.contains(media)) {

            itemsInStore.add(media);

            System.out.println(
                    "Media added to store");
        } else {

            System.out.println(
                    "Media already exists");
        }
    }

    public void removeMedia(Media media) {

        if (itemsInStore.contains(media)) {

            itemsInStore.remove(media);

            System.out.println(
                    "Media removed from store");
        } else {

            System.out.println(
                    "Media not found");
        }
    }

    public void print() {

        System.out.println("Store:");

        for (Media media : itemsInStore) {
            System.out.println(media);
        }
    }
}