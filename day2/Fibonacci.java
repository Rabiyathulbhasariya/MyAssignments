package week1.day2;

public class Fibonacci {

	public static void main(String[] args) {
		int n = 8, a = 0, b=1, c;
		System.out.println(a);
		System.out.println(b);
		for (int i =0; i<(n-2); i++)
		{

			c = a + b;
			System.out.println(c);
			a=b;
			b=c;
		}
	}
}



