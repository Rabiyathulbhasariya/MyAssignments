package week2.day3;

import java.util.Arrays;

public class MissingElementInAnArray {

	public static void main(String[] args) {
		int[] arr = {1,2,3,4,7,6,8};
		Arrays.sort(arr);
		for ( int i=0; i < arr.length; i++)
		{
			int check = i+1;
			
			if (check!=arr[i])
			{
				System.out.println("Missing number in arrary is " +check);
				
				break;
			}
			
				
		}

	}

}
