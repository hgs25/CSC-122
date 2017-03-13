
/**
 * Write a description of class DVD here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class DVD extends Item
{
    private String director;
    private String star;
    
    /**
     * Constructor for objects of class DVD
     */
    public DVD(String title, int playTime, String director, String star)
    {
        super(title,playTime);
        this.director = director;
        this.star=star;
    }

    
}
