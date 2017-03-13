/******************************************
 * YOU MAY NOT CHANGE THIS FILE IN ANY WAY!
 ******************************************/

public class Test
{
    public static void main(String [] args)
    {
	//Testing constructors with both valid and invalid inputs
	Fraction a = new Fraction();		
	System.out.println("1: " + a);

	Fraction b = new Fraction(1, 6);
	System.out.println("2: " + b);
	
	Fraction c = new Fraction(5, 0);
	System.out.println("3: " + c);

	Fraction d = new Fraction(14, -6);
	System.out.println("4: " + d);

	Fraction e = new Fraction("0.678");
	System.out.println("5: " + e);

	Fraction f = new Fraction("1.333333");
	System.out.println("6: " + f);

	Fraction g = new Fraction("12/10");
	System.out.println("7: " + g);

	//Testing equality by reference and by value
	Fraction h = new Fraction(1, 6);	
	System.out.println("8: " + h + isItEqual(h, b) + b);
	System.out.println("9: " + h + " == " + b + " is " + (h == b));
	System.out.println("10: " + d + isItEqual(d, h) + h);

	Fraction i = d;
	System.out.println("11: " + i + isItEqual(i, d) + d);

	Fraction j = new Fraction(2, 12);
	System.out.println("12: " + j + isItEqual(j, b) + b);

	Fraction k = new Fraction("6/7");
	Fraction l = new Fraction("12/14");
	System.out.println("13: " + k + isItEqual(k, l) + l);
    
	//Testing lessThan, equals and greaterThan functions
	Fraction m = new Fraction("10000001/2");
	Fraction n = new Fraction("10000001/3");
	System.out.println("14: " + m + isItEqual(m, n) + n);
	System.out.println("15: " + m + compare(m, n) + n); 
	System.out.println("16: " + n + compare(n, m) + m); 

	//Testing add, sub, mult, and div functions    
	Fraction p = new Fraction("0.2");
	Fraction q = new Fraction("6/15");
	Fraction r = p.add(q);
	System.out.println("17: " + p + " + " + q + " = " + r);
	
	Fraction s = p.sub(q);
	System.out.println("18: " + p + " - " + q + " = " + s);
	
	Fraction t = p.mult(q);
	System.out.println("19: " + p + " * " + q + " = " + t);
	
	Fraction u = p.div(b);
	System.out.println("20: " + p + " ./. " + b + " = " + u);
    }

    public static String isItEqual(Fraction a, Fraction b)
    {
	if (a.equals(b))
	    return " is equal to ";

	return " is NOT equal to ";
    }

    public static String compare(Fraction a, Fraction b)
    {
	if (a.greaterThan(b))
	    return " > ";
	if (a.lessThan(b))
	    return " < ";
	return " ~ ";
    }
}
