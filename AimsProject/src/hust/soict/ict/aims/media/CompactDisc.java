package hust.soict.ict.aims.media;

import java.util.ArrayList;
import java.util.List;

import hust.soict.ict.aims.exception.AlreadyExistedException;
import hust.soict.ict.aims.exception.NegativeException;
import hust.soict.ict.aims.exception.NotExistedException;
import hust.soict.ict.aims.exception.PlayerException;

public class CompactDisc extends Disc implements Playable{
	private static int nbCompactDiscs = 0;
	private String artist;
	private List<Track> tracks = new ArrayList<>();
	
	public CompactDisc(String title, String category, float cost, String director, String artist, ArrayList<Track> tracks) throws NegativeException {
		super(nbCompactDiscs++, title, category, cost, director);
		this.artist = artist;
		this.tracks = tracks;
	}
	
	public CompactDisc(String title, String category, float cost, String director, String artist) throws NegativeException {
		super(nbCompactDiscs++, title, category, cost, director);
		this.artist = artist;
	}

	public String getArtist() {
		return artist;
	}
	
	public void addTrack(Track track) throws AlreadyExistedException {
		if (!tracks.contains(track)) {
			tracks.add(track);
			System.out.println(track.getTitle() + " has been added!");
		}
		else {
			throw new AlreadyExistedException(track.getTitle() + " already in the list. Cannot be added");
		}
	}
	
	public void removeTrack(Track track) throws NotExistedException {
		if (tracks.contains(track)) {
			tracks.remove(track);
			System.out.println(track.getTitle() + " has been removed!");
		}
		else {
			throw new NotExistedException(track.getTitle() + " not in the list. Cannot be removed");
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
	
	public String toString() {
		return "CD - Id: " + this.getId() + " - " + this.getTitle() + " - " + this.getCategory() + " - " + this.getDirector() + " - " + this.getArtist() + " - " + this.getLength() + " : " + this.getCost() + " $";
	}

	@Override
	public void play() throws PlayerException {
		if (this.getLength() > 0) {
			for (Track track : tracks) {
				try {
					track.play();
				} catch (PlayerException e) {
					e.printStackTrace();
				}
			}
		}
		else {
			throw new PlayerException("ERROR: CD length is non-positive");
		}
		
	}
		
}
