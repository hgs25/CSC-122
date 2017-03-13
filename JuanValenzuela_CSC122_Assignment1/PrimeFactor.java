import java.util.TreeSet;

/**
 * lists the prime factors and the largest prime factor of a number
 * 
 * @author Juan Valenzuela 
 * @version 03.21.2016
 */
class PrimeFactor
{
    public static void main(String[] args)
    {
        PrimeFactor factor = new PrimeFactor();
        long number = 0;
        
        try
        {
            number = Long.parseLong(args[0]);
        }
        catch (NumberFormatException e)
        {
            System.err.println("Argument: " + args[0] + " must be an integer.");
            System.exit(1);
        }
        catch (ArrayIndexOutOfBoundsException b)
        {
            System.err.print("Default: The largest prime factor of 600851475143 is ");
            factor.largestPrime(600851475143L);
        }
        if(number!= 0)
        {
            factor.largestPrime(number);
        }
    }
    
    TreeSet<Long> primeFactors;
    
    /**
     * Constructor for objects of class PrimeFactor
     */
    public PrimeFactor()
    {        
    }
    
    /**
     * Calculates the prime factors of a given number
     * 
     * @param number
     */
    private void calculatePrimes(long number )
    {
        primeFactors = new TreeSet<>();
        long prime = 2L;
        if (number == 1)
        {
            primeFactors.add(number);
        }
        while(prime<=number)
        {
            long factorRemainder = number%prime;
            long factorWhole = number/prime;
            if(factorRemainder == 0)
            {
                primeFactors.add(prime);
                number=factorWhole;
            }
            else
            {
                prime++;
            }
        }
    }
    
    /**
     * lists the prime factors of a given number.
     * Add L at the end of the number to make the input valid.
     * 
     * @param number
     */
    public void listPrimes(long number)
    {
        calculatePrimes(number);
        for(long primeFactor:primeFactors)
        {
            System.out.println(primeFactor);
        }
    }
    
    /**
     * lists the largest prime factor of a number
     * Add L at the end of the number to make the input valid.
     * 
     * @param number
     */
    public void largestPrime(long number)
    {
        calculatePrimes(number);
        System.out.println(primeFactors.last());
    }
}
