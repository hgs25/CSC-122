/**
 * finds the pythagorean triplet that add up to 1000.
 * 
 * @author Juan Valenzuela
 * @version 04.08.2016
 */
class Pythagorean 
{
	public static void main(String[] args)
	{
		Pythagorean calc = new Pythagorean();
		calc.findTriplet(1000);
	}
	
	/**
	 * class constructor
	 */
	public Pythagorean()
	{		
	}
	
	public void findTriplet(double sum)
	{
		double c=0;
		for(double a=1; a<sum; a++)
		{
			for(double b=1; b<sum; b++)
			{
				c = Math.sqrt(a*a+b*b);
				if((a+b+c)==sum)
				{
					System.out.println((int)a+" , "+(int)b+" and "+(int)c
							+ " are the pythagorean triple in which the sum is "+sum+".");
					System.out.println("The product of the triple is: "+(int)(a*b*c));
					return;
				}
			}
		}
	}
}
