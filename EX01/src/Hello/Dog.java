package Hello;

public class Dog implements Interface{

	@Override
	public void call() {
		System.out.println("멍멍");
		
	}
	
	public static void main(String[] args) {
		Interface dog = new Dog();
		dog.call();
	}

}
