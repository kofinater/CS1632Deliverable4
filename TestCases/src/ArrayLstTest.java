import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;
public class ArrayLstTest {
	ArrayList<int[]> listOfArrays = new ArrayList<int[]>();
	@Before //Creating 100 integer arrays
	public void setUp() throws Exception {
		Random r = new Random();
		int size; //size of array
		for(int i=0; i<100; i++){
			size = r.nextInt(1000);
			int[] currArr = new int[size];
			for(int j=0; j<size;j++){
				currArr[j] = r.nextInt(Integer.MAX_VALUE); // only positive or 0 values
			}
			listOfArrays.add(currArr);
		}
	}
	
	//Test that the sorted arrays are nonDecreasing
	@Test
	public void nonDecreasingTest() {
		for(int[] arr : listOfArrays){
			Arrays.sort(arr);
			boolean nonDecreasing = true;
			for(int i =0; i<arr.length-1 ; i++){
				if(arr[i] > arr[i+1]){
					nonDecreasing = false;
				}
				
			}
			assertTrue(nonDecreasing);
		}
		
	}
	
	//Test that the sort function is idempotent
	@Test
	public void idempotentTest(){
		for(int[] arr : listOfArrays){
			Arrays.sort(arr);
			int[] copy = arr.clone();
			Arrays.sort(arr);
			assertTrue(Arrays.equals(copy, arr));
		}
	}
	
	//Test that the sort function is pure
	@Test
	public void pureTest(){
		for(int[] arr : listOfArrays){
			int[] copy = arr.clone();
			Arrays.sort(arr);
			Arrays.sort(copy);
			assertTrue(Arrays.equals(copy, arr));
		}
	}

}
