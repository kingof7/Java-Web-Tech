package Hello;

public class Cat implements Interface{

	@Override
	public void call() {
		System.out.println("야옹야옹");
		
	}
	
	public static void main(String[] args) {
		
		Interface cat = new Cat();
		cat.call();
		
	}

}
