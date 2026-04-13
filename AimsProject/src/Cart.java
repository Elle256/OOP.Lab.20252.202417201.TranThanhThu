public class Cart {
    public static final int MAX_NUMBERS_ORDERED = 20;
    private DigitalVideoDisc itemsOrdered[] = new DigitalVideoDisc[MAX_NUMBERS_ORDERED];
    private int realOrdered = 0;

    public void addDigitalVideoDisc(DigitalVideoDisc disc) {
        if (realOrdered < MAX_NUMBERS_ORDERED) {
            itemsOrdered[realOrdered] = disc;
            realOrdered++;
        } else {
            System.out.println("The cart is full");
        }
    }

    public void addDigitalVideoDisc(DigitalVideoDisc[] discs){
        for (DigitalVideoDisc disc : discs) {
        addDigitalVideoDisc(disc); 
    }
    }
    // Method which allows to pass an arbitrary number of arguments for dvd.
    //public void addDigitalVideoDisc(DigitalVideoDisc... discs) {
        //for (DigitalVideoDisc disc : discs) {
            //addDigitalVideoDisc(disc);
        //}
    //}
    public void addDigitalVideoDisc(DigitalVideoDisc disc1, DigitalVideoDisc disc2) {
        addDigitalVideoDisc(disc1);
        addDigitalVideoDisc(disc2);
}


    public void removeDigitalVideoDisc(DigitalVideoDisc disc) {
        if (realOrdered == 0) {
            System.out.println("Cart is empty");
            return;
        }

        boolean found = false;

        for (int i = 0; i < realOrdered; i++) {
            if (itemsOrdered[i].equals(disc)) {
                found = true;
                System.out.println("Removed disc " + disc.getTitle());
                for (int j = i; j < realOrdered - 1; j++) {
                    itemsOrdered[j] = itemsOrdered[j + 1];
                }

                itemsOrdered[realOrdered - 1] = null;
                realOrdered--;
                return;
            }
        }

        if (!found) {
            System.out.println("Disc not found");
        }
    }

    public float totalCost() {
        float sum = 0;

        for (int i = 0; i < realOrdered; i++) {
            sum += itemsOrdered[i].getCost();
        }

        return sum;
    }

    public void printCart() {
    System.out.println("***********************CART***********************");
    System.out.println("Ordered Items:");

    float totalCost = 0;

    for (int i = 0; i < realOrdered; i++) {
        System.out.println((i + 1) + ". " + itemsOrdered[i].toString());
        totalCost += itemsOrdered[i].getCost();
    }

    System.out.println("Total cost: " + totalCost + " $");
    System.out.println("***************************************************");
}
    public void searchById(int id) {
    boolean found = false;

    for (int i = 0; i < realOrdered; i++) {
        if (itemsOrdered[i].getId() == id) {
            System.out.println("Found: " + itemsOrdered[i]);
            found = true;
            break;
        }
    }

    if (!found) {
        System.out.println("No matching DVD found.");
    }
}

    public void searchByTitle(String title) {
    boolean found = false;

    for (int i = 0; i < realOrdered; i++) {
        if (itemsOrdered[i].isMatch(title)) {
            System.out.println("Found: " + itemsOrdered[i]);
            found = true;
        }
    }

    if (!found) {
        System.out.println("No matching DVD found.");
    }
}



}