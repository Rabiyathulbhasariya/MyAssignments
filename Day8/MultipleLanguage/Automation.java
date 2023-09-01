package week3.day7;

public class Automation extends MultipleLanguage implements Language,TestTool{

	public static void main(String[] args) {
		Automation auto = new Automation();
		auto.Selenium();
		auto.Java();
		auto.ruby();
		auto.python();

	}

	public void Selenium() {
		System.out.println("Selenium");
		
	}

	public void Java() {
		System.out.println("Java");
		
	}

	@Override
	public void ruby() {
		System.out.println("ruby");
		
	}

}
