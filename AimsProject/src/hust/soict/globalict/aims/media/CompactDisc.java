package hust.soict.globalict.aims.media;

import java.util.ArrayList;

public class CompactDisc
        extends Disc
        implements Playable {

    private String artist;
    private ArrayList<Track> tracks
            = new ArrayList<>();

    public CompactDisc(int id,
                       String title,
                       String category,
                       String director,
                       float cost,
                       String artist) {

        super(id, title, category,
                cost, 0, director);

        this.artist = artist;
    }

    public String getArtist() {
        return artist;
    }

    public void addTrack(Track track) {

        if (tracks.contains(track)) {

            System.out.println(
                    "Track already exists");
        } else {

            tracks.add(track);

            System.out.println(
                    "Track added");
        }
    }

    public void removeTrack(Track track) {

        if (tracks.contains(track)) {

            tracks.remove(track);

            System.out.println(
                    "Track removed");
        } else {

            System.out.println(
                    "Track not found");
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

        System.out.println(
                "Playing CD: "
                        + this.getTitle());

        System.out.println(
                "CD length: "
                        + this.getLength());

        for (Track track : tracks) {
            track.play();
        }
    }
}