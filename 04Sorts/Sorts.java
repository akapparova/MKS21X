import java.util.Arrays;

public class Sorts{
    /**EDIT THIS METHOD TO MATCH YOUR NAME 
     */
    public static String name(){
	return "10.Kapparova.AsimAyana"; 
    }

  /**Selection sort of an int array. 
  *Upon completion, the elements of the array will be in increasing order.
  *@param data  the elements to be sorted.
  */
    public static void selectionSort(int[] data){
	for (int i = 0; i < data.length ; i ++){
	    int smallInd = i;
	    int smallValue = data[smallInd];
	    for (int j = i+1; j < data.length; j ++){
		if (data[j] < smallValue){
		   smallValue = data[j];
		   smallInd = j;
		}
	    }
	    swap (data, i, smallInd);
	}
    }
		
    public static void swap(int [] ary, int i, int j){
	int temp = ary[i];
	ary[i] = ary[j];
	ary[j] = temp;
    }

    public static void main(String[] args) {
	int[] a = {6,3,1,7,5,9,4,0,2};
	selectionSort(a);
	System.out.println(Arrays.toString(a));
	int[] b = {};
	selectionSort(b);
	System.out.println(Arrays.toString(b));
	int[] c = {10};
	selectionSort(c);
	System.out.println(Arrays.toString(c));
	int[] d = {400,303,1500,1759,1618,13,11,1436,2168,1172,5280,2016,38387};
	selectionSort(d);
	System.out.println(Arrays.toString(d));
    }

 

}
