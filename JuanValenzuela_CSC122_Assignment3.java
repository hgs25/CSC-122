/**
 * Finds the n-th prime number
 * 
 * @author Juan Valenzuela
 * @version 04.02.2016
 *
 */
class Prime 
{
	/**
	 * main method
	 * @param args
	 */
	public static void main (String[] args)
	{
		Prime prime = new Prime();
		prime.printPrime(10001);
	}
	
	/**
	 * Constructor
	 */
	public Prime()
	{
	}
	
	/**
	 * tests to see if a number is Prime
	 * @param num
	 * @return isPrime
	 */
	private boolean isPrime(int num)
	{
		boolean isPrime = true;
		for(int i=2; i<=Math.sqrt(num); i++)
		{
			if(num % i == 0)
			{
				isPrime=false;
			}
		}
		return(isPrime);
	}
	
	/**
	 * calculate the 1st n prime numbers
	 * 
	 * @param n
	 */
	private int calcPrime(int n)
	{		
		int prime = 0;
		int number = 2;
		int count = 0;
		while(count<n)
		{			
			if(isPrime(number))
			{
				prime = number;
				count++;
			}
			number++;
		}
		return(prime);
	}
	
	/**
	 * prints the nth prime.
	 * 
	 * @param n
	 */
	public void printPrime(int n)
	{
		int prime = calcPrime(n);
		String number = Integer.toString(n);
		if(number.endsWith("1"))
		{
			System.out.println("The "+ n +"st prime number is: " + prime);
		}
		else if(number.endsWith("2"))
		{
			System.out.println("The "+ n +"nd prime number is: " + prime);
		}
		else if(number.endsWith("3"))
		{
			System.out.println("The "+ n +"rd prime number is: " + prime);
		}
		else
		{
			System.out.println("The "+ n +"th prime number is: " + prime);
		}
	}
}
