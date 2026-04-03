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
}