package hust.soict.globalict.aims.media;

import java.util.Comparator;

public abstract class Media {

    private static int idCounter = 0;

    private int id;
    private String title;
    private String category;
    private float cost;

    public static final Comparator<Media> COMPARE_BY_TITLE_COST = new MediaComparatorByTitleCost();
    public static final Comparator<Media> COMPARE_BY_COST_TITLE = new MediaComparatorByCostTitle();
    // Constructor 
    public Media() {
		this.id = ++idCounter;
    }
    public Media(String title) {
        this.title = title;
		this.id = ++idCounter;
    }
    public Media(String title, String category) {
        this.title = title;
        this.category = category;
        this.id = ++idCounter;
    }
    public Media(String title, String category, float cost) {
        this.title = title;
        this.category = category;
        this.cost = cost;
        this.id = ++idCounter;
    }
    
    // Getter method
    public int getId() {
        return id;
    }
    public String getTitle() {
        return title;
    }
    public String getCategory() {
        return category;
    }
    public float getCost() {
        return cost;
    }

    // Setter method
    public void setTitle(String title) {
        this.title = title;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof Media)) return false;
        Media other = (Media) obj;
        return this.title != null && this.title.equals(other.title);
    }

    @Override
    public String toString() {
        return "Media [id=" + id + ", title=" + title
                + ", category=" + category + ", cost=" + cost + "]";
    }
    
}