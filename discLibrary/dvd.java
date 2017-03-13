
/**
 * creates instance of a dvd
 * 
 * @author Juan Valenzuela 
 * @version 03.14.2016
 */
public class dvd
{
    private String title;
    private String director;
    private String star;
    private String comment;
    private int runningTime;
    private boolean gotIt;

    /**
     * Constructor for objects of class dvd
     */
    public dvd(String title, String director, String Star, int runningTime)
    {
        this.title = title;
        this.director = director;
        this.star = star;
        this.runningTime = runningTime;
        comment = "";
        gotIt = false;
    }

    public void setComment(String comment)
    {
        this.comment = comment;
    }
    
    public String getComment()
    {
        return (comment);
    }
    
    public void setOwn(boolean own)
    {
        gotIt = own;
    }
    
    public boolean getOwn()
    {
        return(gotIt);
    }
    
    public void printInfo()
    {
        System.out.println("Film: "+title+"\nDirected by: "+director+"\nStarring: "+star
                            +"\nruntime: "+runningTime+"\nComments: "+comment+"\nOwn: "+gotIt);
    }
}
