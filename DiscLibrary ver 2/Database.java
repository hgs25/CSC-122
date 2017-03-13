import java.util.ArrayList;

/**
 * Write a description of class Database here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Database
{
    private ArrayList<Item> items;

    /**
     * Constructor for objects of class Database
     */
    public Database()
    {
        items = new ArrayList<>();
    }

    public void addItem(Item theItem)
    {
        items.add(theItem);
    }
    
    public void list()
    {
        for (Item item:items)
        {
            item.print();
            System.out.println();
        }
    }
}
