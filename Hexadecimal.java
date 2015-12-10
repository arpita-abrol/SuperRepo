/*
Arpita Abrol
APCS1 pd10
HW45 -- Come Together
2015-12-10
*/

public class Hexadecimal implements Comparable{

    //class var
    private static final String ALLHEX = "0123456789ABCDEF";

    
    //instance vars
    private int _decNum;
    private String _hexNum;

    
    //CONSTRUCTORS
    //default constructor
    public Hexadecimal() {
	_decNum = 0;
	_hexNum = "0";
    }

    //overloaded constructor #1--given _decNum (positive)
    public Hexadecimal( int n ) {
	_decNum = n;
	_hexNum = decToHex(n);
    }

    //overloaded constructor #2--given _hexNum (positive)
    public Hexadecimal( String n ) {
	_hexNum = n;
	_decNum = hexToDec(n);
    }

    
    //string representation aka toString()
    public String toString() {
	return _hexNum; 
    }

    
    //convert from decimal num to hex num iterative
    public static String decToHex( int n ) {
	String hex = "";
	while ( n > 0 ) {
	    hex = (ALLHEX.substring((n%16),(n%16)+1)) + hex;
	    n = n/16;
	}
	return hex;
    }

    //convert from decimal num to hex num recursive
    public static String decToHexR( int n ) {
	if ( n == 0 ) { return ""; }
        return decToHexR( n/16 ) + (ALLHEX.substring((n%16),(n%16)+1));
    }

    //convert from hex num to decimal num iterative
    //goes from right to left
    public static int hexToDec( String n ) {
	int ret = 0;
	for (int i=0; i<n.length(); i++) {
	    ret += (int)(ALLHEX.indexOf(n.substring(n.length()-i-1, n.length()-i)) * Math.pow(16, i));
	}
	return ret;
    }

    /*
      //hexToDec going from left to right
    public static int hexToDec( String n ) {
	int dec = 0;
	for( int i = 0; i < n.length(); i++ ) {
	    String x = n.substring(i,i+1);
	    dec += (int)(ALLHEX.indexOf(x)) * Math.pow(16,n.length()-1-i);
	}
	return dec;
    }
    */

    //convert from hex num to decimal num recursive
    public static int hexToDecR( String n ) {
	if (n.length() == 0) {
	    return 0;
	}
	else {
	    return (int)(ALLHEX.indexOf(n.substring(0,1)) * Math.pow(16, n.length()-1)) + hexToDecR(n.substring(1));
	}
    }

    
    //checks to see if 2 objects are equivalent
    public boolean equals( Object val ) {
	return compareTo(val) == 0;
    }

    
    //tells which of the 2 hexadecimal objects is greater
    public int compareTo( Object o ) {
	if (o == null) 
	    throw new NullPointerException("\ncompareTo() input null");
	if (!(o instanceof Comparable))
	    throw new ClassCastException("\ncompareTo() input not a Comparable");
	if (this.value() == ((Comparable)o).value()) {
	    return 0;
	}
	else if (this.value() < ((Comparable)o).value()) {
	    return -1;
	}
	else {
	    return 1;
	}
    }

    //each class in the Comparable interface will use value to compare nums
    public double value() {
	return (double)(this._decNum);
    }

    
    //main method for testing!!!
    public static void main( String[]args ) {

	Comparable b1 = new Binary(10);
	Comparable h1 = new Hexadecimal(10);
	Comparable r1 = new Rational(10);
	System.out.println( b1.equals(r1) );
	
	/*

	System.out.println();
	System.out.println("testing...");

	Hexadecimal h1 = new Hexadecimal("7F");
	Hexadecimal h2 = new Hexadecimal(127);
	Hexadecimal h3 = new Hexadecimal("10E9");
	Hexadecimal h4 = h3;

	System.out.println("\n==...");
	System.out.println(h1 == h2); //should be false
	System.out.println(h3 == h4); //should be true

	System.out.println("\n.equals()...");
	System.out.println(h1.equals(h2)); //should be true
	System.out.println(h3.equals(h4)); //should be true
	System.out.println(h1.equals(h4)); //should be false
	System.out.println(h2.equals(h3)); //should be false

	System.out.println("\n.compareTo()...");
	System.out.println(h1.compareTo(h4)); //should be -1
	System.out.println(h3.compareTo(h2)); //should be 1

	System.out.println();
	//System.out.println(h1.compareTo("7F")); //should throw error
	//System.out.println(h2.equals(null)); //should throw error

	*/
	
    } //end main
    
} //end class
