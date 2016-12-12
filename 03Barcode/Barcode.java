public class Barcode implements Comparable<Barcode>{
    
    private String _zip;
    
    private static String[] code = {"||:::", ":::||", "::|:|", "::||:", ":|::|", ":|:|:", ":||::", "|:::|", "|::|:", "|:|::"};

    private static int checkSum(String zip){
	int num = Integer.parseInt(zip);
	int sum = 0;
	while (num > 0) {
	    sum += num % 10;
	    num /= 10;
	}
	int checkNum = sum % 10;
	return checkNum;
    }

    public Barcode(String zip){
	try{
	    Integer.parseInt(zip);
	}
	catch (NumberFormatException e){
	    throw new IllegalArgumentException("Zip should contain only digits!");
	}
	if (zip.length() != 5){
	    throw new IllegalArgumentException("Zip shouldn't be longer than 5 digits!");
	}
	_zip = zip;
    }

    public static String toCode(String zip){
	String ans = "";
	for (int i = 0; i < 5; i++){
	    ans += code[Integer.parseInt(zip.substring(i, i + 1))];
	}
	ans += code[checkSum(zip)];
	return "|" + ans + "|";
    }

	    
    public String toString(){
	String ans = "";
	for (int i = 0; i < 5; i++){
	    ans += code[Integer.parseInt(_zip.substring(i, i + 1))];
	}
	ans += code[checkSum(_zip)];
	return _zip + checkSum(_zip) + " " + "|" + ans + "|";
    }

    public int compareTo(Barcode other){
	return toString().compareTo(other.toString());
    }

    public static String toZip(String c){
	String zipCode =  "";
	if (c.length() != 32){
	    throw new IllegalArgumentException("Barcode not correct length!");
	}
	if (c.charAt(0) != '|' || c.charAt (c.length() - 1) != '|'){
	throw new IllegalArgumentException("Barcode doesn't have guardrail(s)!");
	}
	for (int i = 0; i < c.length(); i ++){
	    if (c.charAt(i) != '|' &&  c.charAt(i) != ':'){
		throw new IllegalArgumentException("Barcode contains non-Barcode characters!");
	    }
	}
	for(int i = 1; i < c.length() - 5; i += 5){
		String num = c.substring(i, i+5);
		switch(num){
		case "||:::":
		    zipCode += "0";
		    break;
		case ":::||":
		    zipCode += "1";
		    break;
		case  "::|:|":
		    zipCode += "2";
		    break;
		case "::||:":
		    zipCode += "3";
		    break;
		case ":|::|":
		    zipCode += "4";
		    break;
		case ":|:|:":
		    zipCode += "5";
		    break;
		case ":||::":
		    zipCode += "6";
		    break;
		case "|:::|":
		    zipCode += "7";
		    break;
		case "|::|:":
		    zipCode += "8";
		    break;
		case "|:|::":
		    zipCode += "9";
		    break;
		default:
		    throw new IllegalArgumentException("Invalid characters!");
		}
	    }
	    if(checkSum(zipCode.substring(0, 5))%10 != Integer.parseInt(zipCode.substring(5))){
		throw new IllegalArgumentException("Checksum doesn't Check out!");
	    }
	    return zipCode;
    }
}

