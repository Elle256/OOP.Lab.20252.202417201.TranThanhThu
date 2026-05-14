package hust.soict.globalict.aims.media;

import java.util.ArrayList;

public class CompactDisc extends Disc implements Playable {

    private String artist;
    private ArrayList<Track> tracks = new ArrayList<>();

    public CompactDisc(String title, String category, String director, float cost, String artist) {
        super(title, category, cost, 0, director);
        this.artist = artist;
    }
    public CompactDisc() {
        super();
    }

    public String getArtist() {
        return artist;
    }

    public void addTrack(Track track) {
        if (tracks.contains(track)) {
            System.out.println( "Track already exists");
        } else {
            tracks.add(track);
        }
    }

    public void removeTrack(Track track) {
        if (tracks.contains(track)) {
            tracks.remove(track);
        } else {
            System.out.println( "Track not found");
        }
    }

    @Override
    public int getLength() {
        int total = 0;
        for (Track track : tracks) {
            total += track.getLength();
        }
        return total;
    }


    @Override
    public void play() {
        if (this.getLength() <= 0) {
            System.out.println("Cannot play the CD: "+this.getTitle());
            return;
        }
        System.out.println("Playing CD: " + this.getTitle());
        System.out.println("CD length: " + this.getLength());
        for (Track track : tracks) {
            track.play(); 
        }
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(this.getId()).append(" - ")
          .append("CD{")
          .append("\n  Title    : ").append(getTitle())
          .append("\n  Category : ").append(getCategory())
          .append("\n  Artist   : ").append(artist)
          .append("\n  Director : ").append(getDirector())
          .append("\n  Length   : ").append(getLength())
          .append("\n  Cost     : ").append(getCost())
          .append("\n  Tracks   :");
        if (tracks.isEmpty()) {
            sb.append(" (none)");
        } else {
            for (Track t : tracks) {
                sb.append("\n    - ").append(t);
            }
        }
        sb.append("\n}");
        return sb.toString();
    }
}