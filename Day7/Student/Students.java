package week3.day7;

public class Students {
	public void getStudentInfo(int id)
	{
		System.out.println(id);
	}
	
	public void getStudentInfo(int id, String name)
	{
		System.out.println(id+" & "+name);
	}
	
	public void getStudentInfo(String email, long phone)
	{
		System.out.println(email+" & "+phone);
	}

	public static void main(String[] args) {
		Students id = new Students();
		id.getStudentInfo(12352400);
		id.getStudentInfo(12352400, "Rabiya");
		id.getStudentInfo("ra@ga.com", 8056094313L);

	}

}
