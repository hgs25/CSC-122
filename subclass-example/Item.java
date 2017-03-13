
/**
 * Write a description of class Item here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Item
{
    private String title;
    private int playTime;
    private boolean gotIt;
    private String comment;

    /**
     * Constructor for objects of class Item
     */
    public Item(String title, int playTime)
    {
        this.title=title;
        this.playTime=playTime;
        gotIt=false;
        comment="";
    }

    
}
