public class Barcode implements Comparable<Barcode>{
    
    private String _zip;
    
    String[] code = {"||:::", ":::||", "::|:|", "::||:", ":|::|", ":|:|:", ":||::", "|:::|", "|::|:", "|:|::"};

    private int checkSum(){
	int num = Integer.parseInt(_zip);
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

    public String toString(){
	String ans = "";
	for (int i = 0; i < 5; i++){
	    ans += code[Integer.parseInt(_zip.substring(i, i + 1))];
	}
	ans += code[checkSum()];
	return _zip + checkSum() + "       " + ans;
    }

    public int compareTo(Barcode other){
	return toString().compareTo(other.toString());
    }

    public String toZip(String code){
	String zip =  "";
	for (int i = 0; i < code.length() - 5; i += 5){
	    zip += code.charAt(i);
	}
	return zip;
    }
}
