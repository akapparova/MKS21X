public class Barcode implements Comparable<Barcode>{
    
    private String _zip;
    private int _checkDigit;
    
    String[] code = {"||:::", ":::||", "::|:|", "::||:", ":|::|", ":|:|:", ":||::", "|:::|", "|::|:", "|:|::"};

    private int checkSum(){
	int x = 0;
	for(int i = 0 ; i < _zip.length() ; i++){
	    x += _zip.charAt(i);
	}
	x += _checkDigit;
	return x;
    }

    public Barcode(String zip){
	try{
	    Integer.parseInt(zip);
	}
	catch (NumberFormatException e){
	    throw new RuntimeException("Zip should contain only digits!");
	}
	if (zip.length() != 5){
	    throw new RuntimeException("Zip shouldn't be longer than 5 digits!");
	}
	_zip = zip;
	_checkDigit = checkSum();
    }

    public Barcode clone(){
	return new Barcode(_zip);
    }

    public String toString(){
	String ans = "";
	for (int i = 0; i < 5; i++){
	    ans += code[Integer.parseInt(_zip.substring(i, i + 1))];
	}
	ans += code[_checkDigit];
	return _zip + _checkDigit + "       " + ans;
    }


    public int compareTo(Barcode other){
	return toString().compareTo(other.toString());
    }

    public static void main(String args[]){
	Barcode b = new Barcode("08451");
	Barcode c = new Barcode("99999");
	Barcode d = new Barcode("11111");
	System.out.println(b); //084518 |||:::|::|::|::|:|:|::::|||::|:|
	System.out.println(b.toString().compareTo("084518 |||:::|::|::|::|:|:|::::|||::|:|")); //0
	System.out.println(b.compareTo(b)); //0
	System.out.println(c.compareTo(b));
	System.out.println(d.compareTo(b));
	/*length
	  Barcode e = new Barcode("123456");
	  System.out.println(e);
	*/
	/*length
	  Barcode e = new Barcode("1234");
	  System.out.println(e);
	*/
	/*type
	  Barcode e= new Barcode("12.45");
	  System.out.println(e);
	*/
    }   
}
