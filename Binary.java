/*
Arpita Abrol
APCS1 pd10
HW45 -- Come Together
2015-12-10
*/

//skeleton file for class Binary

public class Binary implements Comparable{

    private int _decNum;
    private String _binNum;


    //CONSTRUCTORS
    //default constructor
    public Binary() { 
	_decNum = 0;
	_binNum = "" + _decNum;
    }

    //overloaded constructor--accept dec num
    public Binary( int n ) { 
        _decNum = n;
	_binNum = decToBin(n);
    }

    //overloaded constructor--accpet bin num in str
    public Binary( String s ) {
	_decNum = binToDec(s);
	_binNum = s;
    }


    //stringify
    public String toString() {   
	return _binNum;
    }


    // String decToBin(int) -- converts base-10 input to binary
    public static String decToBin( int n ) {
	String bin = "";
	while (n > 0) {
	    bin = (n%2) + bin;
	    n = (int)(n/2);
	}
	return bin;
    }


    //String decToBinR(int) -- converts base-10 input to binary, recursively
    public static String decToBinR( int n ) {   
        String bin = "";
	if (n == 0) {
	    return "0";
	}
	bin = decToBinR( (int)(n/2) ) + n%2;
	if (bin.length() > 1) {
	    if (bin.substring(0,1).equals("0")) {
		bin = bin.substring(1);
	    }
	}
	return bin;
    }


    //String binToDec(String) -- converts base-10 input to binary
    public static int binToDec( String s ) {
        int dec = 0;
        for( int i = s.length(); i > 0; i-- ) {
	    int x = Integer.parseInt( s.substring(i-1,i) );
	    dec += x*(int)(Math.pow(2,s.length()-i));
	}
	return dec;
    }


    //String binToDecR(String) -- converts base-10 input to binary, recursively
    public static int binToDecR( String s ) { 
	int n = Integer.parseInt(s);
	return binToDecRH(n, 0);
    }

    public static int binToDecRH( int n, int x) {
	if (n == 0) {
	    return 0;
	}
	return (int) (n%10 * Math.pow(2,x) + binToDecRH(n/10, x+1));
    }


    /*=============================================
      boolean equals(Object) -- tells whether 2 Objs are equivalent
      pre:  other is an instance of class Binary
      post: Returns true if this and other are aliases (pointers to same Object), or if this and other represent equal binary values
      =============================================*/
    public boolean equals(Object val){
	return this.compareTo(val) == 0;
    }


    /*=============================================
      int compareTo(Object) -- tells which of two Binary objects is greater
      pre:  other is instance of class Binary
      post: Returns 0 if this Object is equal to the input Object,
      negative integer if this<input, positive integer otherwise
      =============================================*/
    public int compareTo( Object o ) {
	if (o == null) 
	    throw new NullPointerException("\ncompareTo() input null");
	if (!(o instanceof Binary))
	    throw new ClassCastException("\ncompareTo() input not a Binary");
	if (this._decNum == ((Binary)o)._decNum) {
	    return 0;
	}
        if (this._decNum < ((Binary)o)._decNum) {
	    return -1;
	}
	else {
	    return 1;
	}
    }


    //main method for testing
    public static void main( String[] args ) {

	System.out.println(decToBin(1));
	System.out.println(decToBin(2));
	System.out.println(decToBin(3));
	System.out.println(decToBin(14));
	System.out.println(decToBin(85));
	System.out.println(decToBinR(1));
	System.out.println(decToBinR(2));
	System.out.println(decToBinR(3));
	System.out.println(decToBinR(14));
	System.out.println(decToBinR(85));
	System.out.println(binToDec("1"));
	System.out.println(binToDec("10"));
	System.out.println(binToDec("11"));
	System.out.println(binToDec("1110"));
	System.out.println(binToDec("1010101"));
	System.out.println(binToDecR("1"));
	System.out.println(binToDecR("10"));
	System.out.println(binToDecR("11"));
	System.out.println(binToDecR("1110"));
	System.out.println(binToDecR("1010101"));

	
	  System.out.println();
	  System.out.println( "Testing ..." );

	  Binary b1 = new Binary(5);
	  Binary b2 = new Binary(5);
	  Binary b3 = b1;
	  Binary b4 = new Binary(7);

	  System.out.println( b1 );
	  System.out.println( b2 );
	  System.out.println( b3 );       
	  System.out.println( b4 );       

	  System.out.println( "\n==..." );
	  System.out.println( b1 == b2 ); //should be false
	  System.out.println( b1 == b3 ); //should be true

	  System.out.println( "\n.equals()..." );
	  System.out.println( b1.equals(b2) ); //should be true
	  System.out.println( b1.equals(b3) ); //should be true
	  System.out.println( b3.equals(b1) ); //should be true
	  System.out.println( b4.equals(b2) ); //should be false
	  System.out.println( b1.equals(b4) ); //should be false

	  System.out.println( "\n.compareTo..." );
	  System.out.println( b1.compareTo(b2) ); //should be 0
	  System.out.println( b1.compareTo(b3) ); //should be 0
	  System.out.println( b1.compareTo(b4) ); //should be neg
	  System.out.println( b4.compareTo(b1) ); //should be pos

	  Binary bin = new Binary(5);
	  Binary abc = null;
	  String str = "";
	  //bin.compareTo(abc); //error
	  //bin.equals(str); //error
	  
	  
    }//end main()

} //end class
