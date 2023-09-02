package week3.day9;

public class ChangeOddIndexToUpperCase {

	public static void main(String[] args) {
		String text = "changeme";
		char[] odd = text.toCharArray();
		
		for(int i=0; i<odd.length;i++)
		{
			if(i%2==0)
			{
				char c = Character.toUpperCase(odd[i]);
				
				
				System.out.print(c);
			}
				
			else
			{
				System.out.print(odd[i]);
			}
		}
			
		
	}

}


/*
Pseudo Code

* Declare String Input as Follow
 
* String test = "changeme";

* a) Convert the String to character array

* b) Traverse through each character (using loop)

* c)find the odd index within the loop (use mod operator)

* d)within the loop, change the character to uppercase, if the index is odd else don't change
 
*/