package week2.day3;

import java.util.Arrays;

public class SecondLargest {

	public static void main(String[] args) {
		int [] large = {10,5,63,98,100,52,1,54};
		int i = large.length;
		Arrays.sort(large);
		System.out.println("Second Largest Number is " + large[i-2]);
		
	}
}
