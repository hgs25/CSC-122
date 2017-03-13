/**
 * class that creates an instance of cd
 * 
 * @author Juan Valenzuela 
 * @version 03.14.2016
 */
public class cd
{
    private String title;
    private String artist;
    private int numberOfTracks;
    private int playtime;
    private String comment;
    private boolean gotIt;
    
    /**
     * Constructor for objects of class cd
     */
    public cd(String title, String artist, int numberOfTracks, int playtime)
    {
        this.title = title;
        this.artist = artist;
        this.numberOfTracks = numberOfTracks;
        this.playtime = playtime;
        comment = "";
        gotIt = false;        
    }

    public void setComment(String comment)
    {
        this.comment = comment;
    }
    
    public String getComment()
    {
        return(comment);
    }
    
    public void setOwn(boolean gotIt)
    {
        this.gotIt = gotIt;
    }
    
    public boolean getOwn ()
    {
        return(gotIt);
    }
    
    public void printDetails()
    {
    }
}
