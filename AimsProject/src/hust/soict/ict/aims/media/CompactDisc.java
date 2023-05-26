package hust.soict.ict.aims.media;

import java.util.ArrayList;
import java.util.List;

public class CompactDisc extends Disc{
	private String artist;
	private List<Track> tracks = new ArrayList<>();
	
	public CompactDisc(String artist, List<Track> tracks, int id, String title, String category, float cost, String director) {
		super(id, title, category, cost, director);
		this.artist = artist;
		this.tracks = tracks;
	}

	public String getArtist() {
		return artist;
	}
	
	public void addTrack(Track track) {
		if (!tracks.contains(track)) {
			tracks.add(track);
			System.out.println(track.getTitle() + " has been added!");
		}
		else {
			System.out.println(track.getTitle() + " already in the list. Cannot be added");
		}
	}
	
	public void removeTrack(Track track) {
		if (tracks.contains(track)) {
			tracks.remove(track);
			System.out.println(track.getTitle() + " has been removed!");
		}
		else {
			System.out.println(track.getTitle() + " not in the list. Cannot be removed");
		}
	}
	
	public int getLength() {
		int total = 0;
		for (Track track : tracks) {
			total += track.getLength();
		}
		return total;
	}
}
