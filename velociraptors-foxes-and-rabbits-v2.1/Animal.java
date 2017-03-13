import java.util.List;
import java.util.Random;

/**
 * Superclass for all animals
 * 
 * A simple model of an animal.
 * Animals age, move, breed, and die.
 * 
 * @author Juan Valenzuela 
 * @version 2016.04.05
 */
public class Animal
{
    // Individual characteristics (instance fields).
    
    // The animal's age.
    protected int age;
    // Whether the animal is alive or not.
    protected boolean alive;
    // The animal's position.
    protected Location location;
    // The field occupied.
    protected Field field;

    /**
     * created a new animal. An animal may be created as a newborn 
     * or with a random age.
     * 
     * @param randomAge If true, the animal will have random  age and hunger level.
     * @param field The field currently occupied.
     * @param location The location within the field.
     */
    public Animal(Field field, Location location)
    {
        age = 0;
        alive = true;
        this.field = field;
        setLocation(location);
    }

    /**
     * Check whether the animal is alive.
     * @return True if animal is alive.
     */
    public boolean isAlive()
    {
        return (alive);
    }
    
    /**
     * indicated that the rabbit is no longer alive.
     */
    public void setDead()
    {
        alive = false;
        if (location != null)
        {
            field.clear(location);
            location = null;
            field = null;
        }
    }
    
    /**
     * returns the anilam's location
     * @return location
     */
    public Location getLocation()
    {
        return(location);
    }
    
    /**
     * place the animal at the new location in the given field.
     * @param newLocation The animal's new location.
     */
    protected void setLocation(Location newLocation)
    {
        if (location != null)
        {
            field.clear(location);
        }
        location = newLocation;
        field.place(this, newLocation);
    }
}
