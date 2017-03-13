/**
 * Program the produces fractions from inputed numbers
 * 
 * @author Juan Valenzuela
 * @version 04.16.2016
 */

public class Fraction
{
    private int numerator;		    //The value of the numerator
    private int denominator;		//The value of the denominator
    
    private int tempNum;
    private int tempDen;

    /**
     * A default constructor which should set the fraction to 1/1.
     */
    public Fraction()
    {
    	numerator = 1;
    	denominator = 1;
    }

    /**
     * A second constructor which should set the fraction to a/b but only
     * if the denominator is not 0. If it is, the fraction should be set
     * to a/1.
     * 
     * @param a : the fraction's numerator
     * @param b : the fraction's denominator
     */
    public Fraction(int a, int b)
    {
    	if(b<0)
    	{
    		numerator = -a;
    	}
    	else
    	{
    		numerator = a;
    	}
    	
    	if (b==0)
    	{
    		denominator=1;
    	}
    	else
    	{
    		denominator=Math.abs(b);
    	}
    }

    /**
     * A third constructor which takes a string of the form either "a/b"
     * or "a.bcd" and initializes the fraction fields appropriately. If
     * the string was the decimal representation of a fraction, it
     * converts that decimal to a traditional fraction with a numerator and
     * denominator.
     * 
     * @param a
     */
    public Fraction(String a)
    {
    	if(a.contains("/")) //if the string is in fraction format
    	{   		
	    		String[] fractionArray = a.trim().split("/");
	    		numerator = Integer.parseInt(fractionArray[0]);
	    		denominator = Integer.parseInt(fractionArray[1]);
    		
	    	if(denominator == 0)
	    	{
	   			denominator = 1;
	   			System.out.println("denominator must be a non zero number."+
	   							   "/n Denominator set to 1");
	   		}
	    	
    		if(denominator<0) //if denominator is negative, set numerator to negative 
    			              //and denominator to positive
	    	{
	    		numerator = -numerator;
	    		denominator = Math.abs(denominator);
	   		}	
    	}
    	
    	if(a.contains(".")) //if the string is in decimal format
    	{
    		double decPlace = a.substring(a.indexOf('.')).length();
    		double decimal = Double.parseDouble(a);
    		
    		numerator = (int)(decimal*Math.pow(10, decPlace-1));
    		denominator = (int)(1*Math.pow(10, decPlace-1));
    		
    		reduce(numerator, denominator);
    		numerator = tempNum;
    		denominator = tempDen;
    	}
    }
    
    /**
     * converts a decimal to fraction and reduces
     * 
     * @param numerator
     * @param denominator
     */
    private void reduce(int num, int den)
    {
    	for(int x=2; x<num || x<den; x++)
    	{
    		while(num % x == 0 && den % x == 0) //find number that evenly divides both 
    			                                //numerator and denominator
    		{
    			num = num/x;
    			den = den/x;
    		}
    	}
    	
    	tempNum = num;
		tempDen = den;
    }

	/**
	 * returns the value of the numerator
	 * 
	 * @return
	 */
    public int getNum()
    {
    	return numerator;
    }

    /**
     * returns the value of the denominator
     * 
     * @return
     */
    public int getDen()
    {
    	return denominator;
    }
    
    /**
     * modifies the value of the numerator
     * 
     * @param a
     */
    public void setNum(int a)
    {
    	numerator=a;
    }

    /**
     * modifies the value of the denominator
     * 
     * @param a
     */
    public void setDen(int a)
    {
    	if(a==0)
    	{
    		System.out.println("error: denominator must be a nonzero number."
    							+"/n denominator is unchanged");
    		return;
    	}
    	if(denominator<0)
    	{
    		numerator = -numerator;
    	}
    	denominator=Math.abs(a);
    }


    /**
     *  returns a string representation of the fraction i.e. in the form "a/b"
     */
    public String toString()
    {
    	return (numerator+"/"+denominator);
    }

    /**
     * compares two fractions for equality.
     * 
     * @return
     */
    public boolean equals(Object obj)
    {
    	if(obj instanceof Fraction)
    	{
    		Fraction a = (Fraction) obj;
    		return(toDecimal() ==a.toDecimal());
    	}
    	
    	return false;
    }

    /**
     * returns the double value of a fraction
     * 
     * @return
     */
    private double toDecimal()
    {
    	return((double)numerator/denominator);
    }
    
    /**
     * compares the fractions to see if one is greater than the other
     * 
     * @param a
     * @return
     */
    public boolean greaterThan(Fraction a)
    {
    	return (toDecimal()>a.toDecimal());
    }

    /**
     * compares the fractions to see if one is less than the other
     * 
     * @return
     */
    public boolean lessThan(Fraction a)
    {
    	return (toDecimal()<a.toDecimal());
    }
    
    private int findLCM(int den1, int den2)
    {
    	boolean lcmFound = false;
		int lcm=0; //the least common multiple of the two denominators
		while(!lcmFound)
		{
			lcm++;
			if(lcm % den1 == 0 && lcm % den2 == 0)
			{
				lcmFound = true;
				return(lcm);
			}    			
		}
		return(lcm);
    }

    public Fraction add(Fraction a)
    {
    	int num1 = numerator;
    	int den1 = denominator;
    	
    	int num2 = a.getNum();
    	int den2 = a.getDen();
    	
    	if(den1!=den2)
    	{
    		int lcm = findLCM(den1, den2);
    		
    		num1 = num1 * (lcm/den1);
    		num2 = num2 * (lcm/den2);
    		den1 = lcm;		
    	}
    	num1 = num1+num2;
    	
    	reduce(num1,den1);
    	num1 = tempNum;
    	den1 = tempDen;
    	
    	return (new Fraction(num1,den1));
    }

    public Fraction sub(Fraction a)
    {
    	int num1 = numerator;
    	int den1 = denominator;
    	
    	int num2 = a.getNum();
    	int den2 = a.getDen();
    	
    	if(den1!=den2)
    	{
    		int lcm = findLCM(den1, den2);
    		
    		num1 = num1 * (lcm/den1);
    		num2 = num2 * (lcm/den2);
    		den1 = lcm;		
    	}
    	num1 = num1-num2;
    	
    	reduce(num1,den1);
    	num1 = tempNum;
    	den1 = tempDen;
    	
    	return (new Fraction(num1,den1));
    }

    public Fraction mult(Fraction a)
    {
    	int num1 = numerator;
    	int den1 = denominator;
    	
    	int num2 = a.getNum();
    	int den2 = a.getDen();
    	
    	num1 = num1*num2;
    	den1 = den1*den2;
    	
    	reduce(num1,den1);
    	num1 = tempNum;
    	den1 = tempDen;
    	
    	return (new Fraction(num1,den1));
    }

    public Fraction div(Fraction a)
    {
    	int num1 = numerator;
    	int den1 = denominator;
    	
    	//get reciprocal of fraction a
    	int num2 = a.getDen();
    	int den2 = a.getNum();
    	
    	num1 = num1*num2;
    	den1 = den1*den2;
    	
    	reduce(num1,den1);
    	num1 = tempNum;
    	den1 = tempDen;
    	
    	return (new Fraction(num1,den1));
    }
}
