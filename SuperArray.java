/*
Arpita Abrol
APCS1 pd10
HW45 -- Come Together
2015-12-10
*/

public class SuperArray{
 
    //~~~~~INSTANCE VARS~~~~~
    //underlying container, or "core" of this data structure:
    private Comparable[] _data;

    //position of last meaningful value
    private int _lastPos;

    //size of this instance of SuperArray
    private int _size;

		
    //~~~~~METHODS~~~~~
    //default constructor – initializes 10-item array
    public SuperArray() { 
	_data = new Comparable[10];
	_lastPos = -1; //flag to indicate no lastpos yet
	_size = 0;	
    }

		
    //output array in [a,b,c] format
    public String toString() { 
	String foo = "[";
	for( int i = 0; i < _size; i++ ) {
	    foo += _data[i] + ",";
	}
	//shave off trailing comma
	if ( foo.length() > 1 )
	    foo = foo.substring( 0, foo.length()-1 );
	foo += "]";
	return foo;
    }

		
    //double capacity of this SuperArray
    private void expand() { 
	Comparable[] temp = new Comparable[ _data.length * 2 ];
	for( int i = 0; i < _data.length; i++ )
	    temp[i] = _data[i];
	_data = temp;
    }

		
    //accessor -- return value at specified index
    public Comparable get( int index ) {
	return _data[index];
    }

		
    //mutator -- set value at index to newVal, 
    //           return old value at index
    public Comparable set( int index, Comparable newVal ) { 
 	Comparable temp = _data[index];
	_data[index] = newVal;
	return temp;
    }


    // ~~~~~~~~~~~~~~ PHASE II ~~~~~~~~~~~~~~
    //adds an item after the last item
    public void add( Comparable newVal ) {
	//make sure there's room
        if (_data.length == _size) {
	    this.expand();
	}

	//add and update vars
	_data[_lastPos + 1] = newVal; 
	_lastPos += 1;
	_size = size();
    }


    //inserts an item at index
    //shifts existing elements to the right
    public void add( int index, Comparable newVal ){
	//make sure there's room
        if (_data.length == _size) {
	    this.expand();
	}
	//if index after lastPos, just add it last
	if (index > _lastPos) {
	    add(newVal);
	}
	//otherwise shift and add
	else {
	    for (int i = _lastPos ; i >= index ; i--) {
		_data[i+1] = _data[i];
	    }
	    _data[index] = newVal;
	    _lastPos += 1;
	    _size = size();
	}
    }


    //removes the item at index
    //shifts elements left to fill in newly-empted slot
    public void remove( int index ){
	//shift left, item to remove doesn't matter
	for (int i = index ; i < _lastPos ; i++) {
	    _data[i] = _data[i+1];
	}
	_lastPos -= 1;
	_size = size();
    }


    //return number of meaningful items in _data
    public int size(){
        return _lastPos + 1;
    }

    //searches array
    public int linSearch( Comparable val ) {
	for ( int i = 0; i < _lastPos; i++ ) {
	    if ( _data[i].equals(val) ) {
		return i;
	    }
	}
	return -1;
    }

    //check if _data is sorted
    public boolean isSorted() {
	for( int i = 0; i < _lastPos; i++ ) {
	    if ( _data[i].compareTo( _data[i+1] ) > 0 ) {
		return false;
	    }
	}
	return true;
    }


    //main method for testing
    public static void main( String[] args ) {

	SuperArray pikachu = new SuperArray();
	pikachu.add( new Binary(2) );
	pikachu.add( new Binary(7) );
	pikachu.add( new Hexadecimal(7) );
	pikachu.add( new Rational(7) );
	pikachu.add( new Hexadecimal(10) );
	pikachu.add( new Rational(11) );

	System.out.println( pikachu );
	System.out.println( pikachu.isSorted() );
	System.out.println( pikachu.linSearch( new Rational(10) ) );

	pikachu.remove(2);
	pikachu.add( new Rational(11,2) );
	pikachu.add( 2, new Binary("10001001") );

	System.out.println( pikachu );
	System.out.println( pikachu.isSorted() );
	System.out.println( pikachu.linSearch( new Binary("100") ) );
	
	/*
        SuperArray curtis = new SuperArray();
	System.out.println("Printing empty SuperArray curtis...");
	System.out.println(curtis);

	for( int i = 0; i < curtis._data.length; i++ ) {
	    curtis.set(i,i*2);
	    curtis._size++; //necessary bc no add() method yet
	}

	System.out.println("Printing populated SuperArray curtis...");
	System.out.println(curtis);

	System.out.println("testing get()...");
	for( int i = 0; i < curtis._size; i++ ) {
	    System.out.print( "item at index" + i + ":\t" );
	    System.out.println( curtis.get(i) );
	}

	System.out.println("Expanded SuperArray curtis:");
	curtis.expand();
	System.out.println(curtis);

	//============================================
	//PHASE II
	
	ListInt mayfield = new SuperArray();
	System.out.println("Printing empty SuperArray mayfield...");
	System.out.println(mayfield);

	mayfield.add(5);
	mayfield.add(4);
	mayfield.add(3);
	mayfield.add(2);
	mayfield.add(1);

	System.out.println("Printing populated SuperArray mayfield...");
	System.out.println(mayfield);

	mayfield.remove(3);
	System.out.println("Printing SuperArray mayfield post-remove...");
	System.out.println(mayfield);
	mayfield.remove(3);
	System.out.println("Printing SuperArray mayfield post-remove...");
	System.out.println(mayfield);
        
	mayfield.add(3,99);
	System.out.println("Printing SuperArray mayfield post-insert...");
	System.out.println(mayfield);
	mayfield.add(2,88);
	System.out.println("Printing SuperArray mayfield post-insert...");
	System.out.println(mayfield);
	mayfield.add(1,77);
	System.out.println("Printing SuperArray mayfield post-insert...");
	System.out.println(mayfield);

	// =========== extras ===========

	System.out.println("Printing SuperArray mayfield's size...");
	System.out.println(mayfield.size());
	*/

    }//end main
		
}//end class
