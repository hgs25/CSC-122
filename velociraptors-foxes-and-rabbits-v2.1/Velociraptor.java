import java.util.List;
import java.util.Iterator;
import java.util.Random;

/**
 * A simple model of a velociraptor.
 * Foxes age, move, eat foxes, and die.
 * 
 * @author Juan Valenzuela, David J. Barnes and Michael Kölling
 * @version 2016.04.05
 */
public class Velociraptor extends Animal
{
    // Characteristics shared by all Velociraptors (class variables).
    
    // The age at which a velociraptor can start to breed.
    private static final int BREEDING_AGE = 15;
    // The age to which a velociraptor can live.
    private static final int MAX_AGE = 150;
    // The likelihood of a velociraptor breeding.
    private static final double BREEDING_PROBABILITY = 0.05;
    // The maximum number of births.
    private static final int MAX_LITTER_SIZE = 5;
    // The food value of a single fox/rabbit. In effect, this is the
    // number of steps a velociraptor can go before it has to eat again.
    private static final int FOX_FOOD_VALUE = 13;
    private static final int RABBIT_FOOD_VALUE = 3;
    // A shared random number generator to control breeding.
    private static final Random rand = Randomizer.getRandom();
    
    //The velociraptor's food level, which is increased by eating rabbits/foxes.
    private int foodLevel;

    /**
     * Create a Velociraptor. A velociraptor can be created as a new born (age zero
     * and not hungry) or with a random age and food level.
     * 
     * @param randomAge If true, the fox will have random age and hunger level.
     * @param field The field currently occupied.
     * @param location The location within the field.
     */
    public Velociraptor(boolean randomAge, Field field, Location location)
    {
        super(field, location);
        if(randomAge) 
        {
            age = rand.nextInt(MAX_AGE);
            foodLevel = rand.nextInt(FOX_FOOD_VALUE);
        }
        else 
        {
            // leave age at 0
            foodLevel = rand.nextInt(FOX_FOOD_VALUE);
        }
    }
    
    /**
     * This is what the velociraptor does most of the time: it hunts for
     * foxes/rabbits. In the process, it might breed, die of hunger,
     * or die of old age.
     * @param field The field currently occupied.
     * @param newFoxes A list to return newly born foxes.
     */
    public void hunt(List<Velociraptor> newVelociraptors)
    {
        incrementAge();
        incrementHunger();
        if(alive) 
        {
            giveBirth(newVelociraptors);            
            // Move towards a source of food if found.
            Location newLocation = findFood();
            if(newLocation == null) 
            { 
                // No food found - try to move to a free location.
                newLocation = field.freeAdjacentLocation(location);
            }
            // See if it was possible to move.
            if(newLocation != null) 
            {
                super.setLocation(newLocation);
            }
            else {
                // Overcrowding.
                super.setDead();
            }
        }
    }
    
    /**
     * Increase the age. This could result in the Velociraptor's death.
     */
    private void incrementAge()
    {
        age++;
        if(age > MAX_AGE) 
        {
            setDead();
        }
    }
    
    /**
     * Make this velociraptor more hungry. This could result in the fox's death.
     */
    private void incrementHunger()
    {
        foodLevel--;
        if(foodLevel <= 0) 
        {
            setDead();
        }
    }
    
    /**
     * Look for foxes adjacent to the current location.
     * Only the first live fox is eaten.
     * @return Where food was found, or null if it wasn't.
     */
    private Location findFood()
    {
        List<Location> adjacent = field.adjacentLocations(location);
        Iterator<Location> it = adjacent.iterator();
        while(it.hasNext()) 
        {
            Location where = it.next();
            Object animal = field.getObjectAt(where);
            if(animal instanceof Fox) 
            {
                Fox fox = (Fox) animal;
                if(fox.isAlive()) 
                { 
                    fox.setDead();
                    foodLevel = FOX_FOOD_VALUE;
                    return where;
                }
            }
            else if(animal instanceof Rabbit)
            {
                Rabbit rabbit = (Rabbit) animal;
                if(rabbit.isAlive())
                {
                    rabbit.setDead();
                    foodLevel = RABBIT_FOOD_VALUE;
                    return where;
                }
            }
        }
        return null;
    }
    
    /**
     * Check whether or not this velociraptor is to give birth at this step.
     * New births will be made into free adjacent locations.
     * @param newVelociraptors A list to return newly born foxes.
     */
    private void giveBirth(List<Velociraptor> newVelociraptors)
    {
        // New velociraptors are born into adjacent locations.
        // Get a list of adjacent free locations.
        List<Location> free = field.getFreeAdjacentLocations(location);
        int births = breed();
        for(int b = 0; b < births && free.size() > 0; b++) 
        {
            Location loc = free.remove(0);
            Velociraptor young = new Velociraptor(false, field, loc);
            newVelociraptors.add(young);
        }
    }
        
    /**
     * Generate a number representing the number of births,
     * if it can breed.
     * @return The number of births (may be zero).
     */
    private int breed()
    {
        int births = 0;
        if(canBreed() && rand.nextDouble() <= BREEDING_PROBABILITY) 
        {
            births = rand.nextInt(MAX_LITTER_SIZE) + 1;
        }
        return births;
    }

    /**
     * A velociraptor can breed if it has reached the breeding age.
     */
    private boolean canBreed()
    {
        return age >= BREEDING_AGE;
    }    
}
