package hust.soict.globalict.aims.media;

import java.util.Comparator;

public class MediaComparatorByCostTitle implements Comparator<Media>{

    @Override
    public int compare(Media o1, Media o2) {
        // By cost
        int costComparison = Double.compare(o2.getCost(), 
                                            o1.getCost());
        if (costComparison != 0) {
            return costComparison;
        }
        // By title
        return o1.getTitle()
                 .compareTo(o2.getTitle());        
    }
}