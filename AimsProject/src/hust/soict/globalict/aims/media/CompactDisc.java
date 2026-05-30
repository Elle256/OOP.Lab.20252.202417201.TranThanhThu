package hust.soict.globalict.aims.media;

import java.util.*;

import hust.soict.globalict.aims.exception.PlayerException;

public class CompactDisc extends Media implements Playable {

    private String artist;
    private List<Track> tracks = new ArrayList<Track>();

    public String getArtist() {
        return artist;
    }

    public CompactDisc(String title) {
        super(title);
    }
    
    public CompactDisc(String title, String category, String artist, float cost) {
        super(title, category, cost);
        this.artist = artist;
    }

    public void addTrack(Track track) {
        if (!tracks.contains(track)) {
            tracks.add(track);
            System.out.println("Track: " + track.getTitle() + " has been added to CD: " + this.getTitle());
        } else {
            System.out.println("Track already exists in CD.");
        }
    }

    public void removeTrack(Track track) {
        if (tracks.contains(track)) {
            tracks.remove(track);
            System.out.println("Track: " + track.getTitle() + " has been removed from CD: " + this.getTitle());
        } else {
            System.out.println("Track does not exist in CD.");
        }
    }
    
    public int getLength() {
        int totalLength = 0;
        for (Track track : tracks) {
            totalLength += track.getLength();
        }
        return totalLength;
    }

    @Override
    public void play() throws PlayerException {
        if (this.getLength() > 0) {
            System.out.println("Playing CD: " + this.getTitle());
            System.out.println("CD length: " + this.getLength());
            
            for (Track track : tracks) {
                try {
                    track.play();
                } catch (PlayerException e) {
                    throw e; 
                }
            }
        } else {
            throw new PlayerException("ERROR: CD length is non-positive!");
        }
    }

    @Override
    public String toString() {
        return this.getId() + " - CD: " + this.getTitle() +
                " - Category: " + this.getCategory() +
                " - Artist: " + this.getArtist() +
                " - Length: " + this.getLength() + " seconds" + 
                " - Cost: " + this.getCost() + "$";
    }

    public String playGUI() throws PlayerException {
        if(this.getLength() > 0) {
            String output =  "Playing CD: " + this.getTitle() + "\n" + 
                             "CD length: " + formatDuration(this.getLength()) + "\n\n";
                             
            for (Track track : tracks) {
                try {
                    output += track.playGUI() + "\n";
                } catch (PlayerException e) {
                    output += track.getTitle() + "\n" + e.getMessage();
                }
            }
            return output;
        } else {
            throw new PlayerException("ERROR: CD length is non-positive!");
        }
    }
    
    private String formatDuration(int lengthInSeconds) {
        int minutes = lengthInSeconds / 60;
        int seconds = lengthInSeconds % 60;
        return String.format("%d:%02d", minutes, seconds);
    }
}