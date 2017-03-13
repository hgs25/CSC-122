import java.util.ArrayList;

/**
 * Write a description of class Database here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Database
{
    private ArrayList<CD> cds;
    private ArrayList<DVD> dvds;

    /**
     * Constructor for objects of class Database
     */
    public Database()
    {
        cds = new ArrayList<>();
        dvds = new ArrayList<>();
    }

    public void addCD(CD theCD)
    {
        cds.add(theCD);
    }
    
    public void addDVD(DVD theDVD)
    {
        dvds.add(theDVD);
    }
    
    public void list()
    {
        for(CD cd:cds)
        {
            cd.print();
            System.out.println();
        }
        for(DVD dvd:dvds)
        {
            dvd.print();
            System.out.println();
        }
    }
}
