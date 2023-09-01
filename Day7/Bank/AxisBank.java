package week3.day7;

public class AxisBank extends Bank{
	public void deposit()
	{
		System.out.println("Axis deposit");
	}

	public static void main(String[] args) {
		
		AxisBank ab = new AxisBank();
		ab.saving();
		ab.fixed();
		ab.deposit();
	}

}
