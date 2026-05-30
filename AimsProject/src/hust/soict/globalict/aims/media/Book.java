package hust.soict.globalict.aims.media;

import java.util.List;
import java.util.ArrayList;

public class Book extends Media {
    private List<String> authors = new ArrayList<String>();

    public Book() {
        super();
    }
    public Book(String title) {
        super(title);
    }

    public Book(String title, String category) {
        super(title, category);
    }

    public Book(String title, String category, float cost) {
        super(title, category, cost);
    }

    public void addAuthor(String authorName) {
        if (!authors.contains(authorName)) {
            authors.add(authorName);
        }
        else{
             System.out.println("This author has already been in the list!");
        }
    }
    public void removeAuthor(String authorName) {
        if (authors.contains(authorName)) {
            authors.remove(authorName);
        } else {
            System.out.println("Author not found: " + authorName);
        }
    }
    @Override
    public String toString() {
        return this.getId()+" - Book: " + getTitle() + " - "+ getCategory()+ " - Authors: "
                + authors + " - "+ getCost();
    }
}