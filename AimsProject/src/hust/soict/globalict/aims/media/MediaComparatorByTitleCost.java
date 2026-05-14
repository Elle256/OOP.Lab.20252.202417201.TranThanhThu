package hust.soict.globalict.aims.media;

import java.util.Comparator;

public class MediaComparatorByTitleCost implements Comparator<Media> {
    @Override
    public int compare(Media o1, Media o2) {
        // By title
        int titleComparison = o1.getTitle()
                                .compareTo(o2.getTitle());
        if (titleComparison != 0) {
            return titleComparison;
        }
        // By cost
        return Double.compare(o2.getCost(), 
                              o1.getCost());
    }        
}