package week2.day3;

public class Car {
	
	public void driveCar()
	{
		System.out.println("Drive car");
	}
	
	public void applyBrake()
	{
		System.out.println("Brake Applied");
	}
	
	public void soundHorn()
	{
		System.out.println("Sound Horn");
	}
	
	public void isPuncture()
	{
		System.out.println("Not Punctured");
	}
	

	public static void main(String[] args) {
		
		Car car = new Car();
		{
			car.driveCar();
			car.applyBrake();
			car.soundHorn();
			car.isPuncture();
		}
		

	}

}
