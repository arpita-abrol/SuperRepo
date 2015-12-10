/*
Arpita Abrol
APCS1 pd10
HW45 -- Come Together
2015-12-10
*/

public class Rational implements Comparable{

    // INSTANCE VARS
    private int num;
    private int den;
    

    // CONSTRUCTORS
    //default constructor
    public Rational(){
	num = 0;
	den = 1;
    }
	
     //overloaded constructor: checks for division by 0
    public Rational(int n, int d){
	this();
	if (d == 0) {
	    System.out.println("Error: Division by zero");
	}
	else {
	    num = n;
	    den = d;
	}
    }


    // METHODS
    //prints rational number with newlines
    public String toString(){
	return num + "/" + den;
    }
    
    //float approximation of rational number
    public float floatValue(){
	return (float)(num)/(den);
	//Casting has precedence to division.
    }

    //multiplication
    public void multiply (Rational n){
        num *= n.num;
	den *= n.den;
    }
    
    //division
    public void divide(Rational n){
	if (n.num == 0){
	    System.out.println("Error: Division by 0");
	}
	else {
	    num *= n.den;
	    den *= n.num;
	}
    }


    // calc gcd of two ints
    public static int gcd(int a, int b){
	// deal with negatives
	a = Math.abs(a);
	b = Math.abs(b);
        while (b != 0) {
            int num = b;
            b = a % b;
            a = num;
        }
        return a;
    }

    // return gcd of numerator and denominator
    public int gcd(){
	return gcd(num,den);
    }

    // simplify the numerator and denominator of a Rational object
    public static void reduce(Rational n){
	int gcd = gcd(n.num, n.den);
	n.num /= gcd;
	n.den /= gcd;
    }
    
    // add to another Rational object
    public void add(Rational a){
	num = num * a.den + den * a.num;
	den *= a.den;
	reduce(this);
    }

    // subtract another Rational object
    public void subtract(Rational a){
	num = num * a.den - den * a.num;
	den *= a.den;
	reduce(this);
    }


    //overrides equals method
    public boolean equals( Object o ) {
	return this.compareTo(o) == 0;
    }

    // returns diff of two Rational objects
    public int compareTo( Object o ) {
	if (o == null) 
	    throw new NullPointerException("\ncompareTo() input null");
	if (!(o instanceof Rational))
	    throw new ClassCastException("\ncompareTo() input not a Rational");
	if (this.floatValue() == ((Rational)(o)).floatValue()) 
	    return 0;
	if (this.floatValue() > ((Rational)(o)).floatValue()) 
	    return 1;
	else 
	    return -1;
    }

    public static void main(String[] args){

	Rational z = new Rational(1,2);
	Rational y = new Rational(1,3);
	Rational x = new Rational(6,9);
	reduce(x);
	System.out.println(x);
	z.add(y);
	System.out.println(z);
	z.subtract(y);
	System.out.println(z);

	Rational d = new Rational(2,4);
	Rational e = new Rational(3,6);
	System.out.println(d.compareTo(e));
	
	Rational a = new Rational(1,2);
	Rational b = new Rational(2,4);
	System.out.println(a.equals(b));

	Rational abc = null;
	//System.out.println( a.compareTo(abc) ); //error

	String xyz = "";
	//a.compareTo(xyz); //error
	
    }

}
