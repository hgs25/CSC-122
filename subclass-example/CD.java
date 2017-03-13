
/**
 * Write a description of class CD here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class CD extends Item
{
    private String artist;
    private int numberOfTracks;

    /**
     * Constructor for objects of class CD
     */
    public CD(String title, String artist, int tracks, int time)
    {
        super(title, time);
        this.artist=artist;
        numberOfTracks = tracks;
    }

    
}
