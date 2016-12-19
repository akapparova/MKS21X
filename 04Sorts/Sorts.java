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

    public static void insertionSort(int[] data){
	int next = 1;
	int value = 0;
	int shift = 0;
	while (next < data.length){
	    value = data[next];
	    if (value < data[next-1]){
		while (next> 0 && data[next-1] > value){
		    next--;
		    shift++;
		}
		for (int x = next + shift; x > next; x--){
		    data[x] = data[x-1];
		}
		data[next] = value;
		shift = 0;
	    }
	    next++;
	}
	}

public static void bubbleSort(int[] data){
	boolean rach  = true;
	int a;
	while(rach){
	    rach = false;
	    for(int i = 0; i < data.length-1; i++){
		if(data[i] > data[i+1]){
		    a = data[i];
		    data[i] = data[i+1];
		    data[i+1] = a;
		    rach = true;
		}
	    }
	}
    }
    
}
