package week1.day2;

public class Factorial {

	public static void main(String[] args) {
		int a = 6, i, b=1;
		for (i=1; i<=a; i++)
		{
			b = b * i;
		}
		System.out.println("Factorial of " + a +" is " + b);
	}

}
