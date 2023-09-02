package week3.day9;

public class ReverseEvenWords {

	public static void main(String[] args) {
		String text = "I am a software tester"; 
		String[] split = text.split(" ");
		for(int i=0;i<split.length; i++)
		{
			if(i%2!=0)
			{
				char[] rev=split[i].toCharArray();
				int len=rev.length;
				for(int j=len-1;j>=0;j--)
				{
					System.out.print(rev[j]);
				}
				
			}
			else
			{
				System.out.println();
				System.out.println(split[i]);
				
			}
			
		}

	}

}

/* Declare the input as Follow
	
a) split the words and have it in an array
b) Traverse through each word (using loop)
c) find the odd index within the loop (use mod operator)

d)split the words and have it in an array

e)print the even position words in reverse order using another loop (nested loop)
f) Convert words to character array if the position is even else print the word as it is(concatenate space at the end).*/
