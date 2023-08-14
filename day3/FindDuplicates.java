package week2.day3;

public class FindDuplicates {

	public static void main(String[] args) {
		int[] dup= {23,5,6,9,10,100,5,6,9,23,8};
		System.out.println("_________________________");
		System.out.println("duplicate numbers");
		System.out.println("_________________________");
		for(int i = 0; i < (dup.length); i++)
		{
			for (int j = i+1; j<(dup.length); j++)
			{
				if ((dup[i])==(dup[j]))
				{
					int c= dup[i]; 
					System.out.println(c);
				}
			}
		}
	}
}


