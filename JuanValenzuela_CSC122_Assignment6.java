import java.util.ArrayList;

/**
 * sums up the primes below a number.
 *
 * @author Juan Valenzuela
 * @version 04.19.2016
 */
class Summation
{
	public static void main(String[] args)
	{
		Summation summation = new Summation();
		summation.listPrimes(2000000);
		System.out.println(summation.sumOfPrimes());
	}

	ArrayList <Long> primes;

	public Summation()
	{
		primes = new ArrayList<>();
	}

	/**
	 * tests to see if a number is Prime
	 * @param num
	 * @return isPrime
	 */
	private boolean isPrime(long num)
	{
		for(long i=2; i<=Math.sqrt(num); i++)
		{
			if(num % i == 0)
			{
				return(false);
			}
		}
		return(true);
	}

	/**
	 * calculates and lists all the primes under a given number
	 *
	 * @param num : the largest number a prime could be.
	 */
	public void listPrimes(long limit)
	{
		for(long i=2; i<limit; i++)
		{
			if(isPrime(i))
			{
				primes.add(i);
			}
		}
	}

	/**
	 * Sums up the primes
	 * @return sum
	 */
	public long sumOfPrimes()
	{
		long sum = 0;
		for(Long prime:primes)
		{
			sum=sum+prime;
		}
		return(sum);
	}
}
