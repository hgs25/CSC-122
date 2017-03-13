/**
 * finds the pythagorean triplet that add up to 1000.
 * 
 * @author Juan Valenzuela
 * @version 04.08.2016
 */
class PythagoreanV2 
{
	public static void main(String[] args)
	{
		Pythagorean calc = new Pythagorean();
		calc.findTriplet(1000);
	}
	
	/**
	 * class constructor
	 */
	public PythagoreanV2()
	{		
	}
	
	public void findTriplet(double sum)
	{
		double c=0;
		for(double a=1; a<sum; a++)
		{
			for(double b=a+1; b<sum; b++)
			{
				c = sum-a-b ;
				if(Math.pow(a, 2)+Math.pow(b, 2)==Math.pow(c, 2))
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