public class Tester{
    //Thank you to Ben Weinstein of period 9 for this test code!
    
    public static void main(String args[]){
	//INITIAL TESTS
	System.out.println("\nINITIAL TESTS");
	Barcode a = new Barcode("08451");
	Barcode b = new Barcode("99999");
	Barcode c = new Barcode("11111");
	System.out.println(a); //084518 |||:::|::|::|::|:|:|::::|||::|:|
	System.out.println(a.toString().compareTo("084518 |||:::|::|::|::|:|:|::::|||::|:|")); //0
	System.out.println(a.compareTo(a)); //0
	System.out.println(b.compareTo(a)); //9
	System.out.println(c.compareTo(a)); //1
		
	//more tests for second part of the lab:

	//
	//CONSTRUCTOR TESTS
	//
	
	System.out.println("\nCONSTRUCTOR TESTS");
	System.out.println(new Barcode("99999"));
	try{
	    new Barcode("024df");
	}catch(IllegalArgumentException e){
	    e.printStackTrace(); //zip contains a non digit
	}
	
	try{
	    new Barcode("010101010");
	}catch(IllegalArgumentException e){
	    e.printStackTrace(); //zip is not correct length
	}
	
	//
	//toCode TESTS
	//
	
	System.out.println("\ntoCode TESTS");
	System.out.println(Barcode.toCode("99999"));
	//Barcode b = new Barcode("99999"); //already done in init tests
	String zipOfB = (b.toString()).substring(7); // slices off begin zip part
	System.out.println(Barcode.toCode("99999").compareTo(zipOfB)); //0

	//exceptions for toCode()
	try{
	    Barcode.toCode("222222");
	}catch(IllegalArgumentException e){
	    e.printStackTrace(); //given zip is not correct length
	}
	
	try{
	    Barcode.toCode("eeeef");
	}catch(IllegalArgumentException e){
	    e.printStackTrace(); //given zip contains a non digit
	}

	//
	//toZip TESTS
	//
	System.out.println("\ntoZip TESTS");
	//	System.out.println(Barcode.toZip(Barcode.toCode("99999"))); //99999

	//exceptions for toZip()
	try{
	    Barcode.toZip("|:|");
	}catch(IllegalArgumentException e){
	    e.printStackTrace();//not correct length
	}

	try{
	    Barcode.toZip("eeeeeeeeeeeeeeeeeeeeeeeeeeeeeeee");
	}catch(IllegalArgumentException e){
	    e.printStackTrace();//invalid guard rails
	}

	try{
	    Barcode.toZip("|eeeeeeeeeeeeeeeeeeeeeeeeeeeeee|");
	}catch(IllegalArgumentException e){
	    e.printStackTrace();//invalid barcode characters
	}

	try{
	    Barcode.toZip("|||:::|::|::|::|:|:||||:|||::|:|");
	}catch(IllegalArgumentException e){
	    e.printStackTrace();//encoded int invalid
	}

	try{
	    Barcode.toZip("|||:::|::|::|::|:|:|::::|||::|||");
	}catch(IllegalArgumentException e){
	    e.printStackTrace();//invalid checkDigit
	}
	

	
	
	
	
	    
	
      
			       
	
    }
}
