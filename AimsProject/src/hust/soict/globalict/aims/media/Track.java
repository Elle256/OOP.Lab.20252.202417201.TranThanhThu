package hust.soict.globalict.aims.media;

import java.time.Duration;
import hust.soict.globalict.aims.exception.PlayerException;

public class Track implements Playable {
    
    private String title;
    private int length;

    // Constructor 
    public Track(String title, int length) {
        this.title = title;
        this.length = length;
    }

    @Override
    public void play() throws PlayerException {
        if (this.getLength() > 0) {
            System.out.println("Playing track: " + this.getTitle());
            System.out.println("Track length: " + this.getLength());
        } else {
            throw new PlayerException("ERROR: Track length is non-positive!");
        }
    }

    public String playGUI() throws PlayerException {
        if (this.getLength() > 0) {
            return "Playing track: " + this.getTitle() + "\n" + 
                   "Track length: " + formatDuration(this.getLength());
        } else {
            throw new PlayerException("ERROR: Track length is non-positive!");
        }
    }

    public String formatDuration(int durationInSeconds) {
        Duration duration = Duration.ofSeconds(durationInSeconds);
        return String.format("%02d:%02d", duration.toMinutes(), duration.minusMinutes(duration.toMinutes()).getSeconds());
    }

    // Getter methods
    public String getTitle() {
        return title;
    }
    
    public int getLength() {
        return length;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {  
            return true;
        }
        if (!(obj instanceof Track)) {
            return false;
        }
        Track otherTrack = (Track) obj;
        
        if (this.title != null && this.title.equals(otherTrack.getTitle()) && this.length == otherTrack.getLength()) {
            return true;
        }
        
        return false;
    }
}