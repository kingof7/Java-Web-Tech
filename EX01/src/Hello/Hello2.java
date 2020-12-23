package Hello;

public class Hello2 extends Abstract{
	
	public static int a = 1; //this.a
	private int b = 21; //this.b
	
//	public Hello2() {
//		System.out.println(this.a + this.b);
//	}
//	
	//오버로딩
	public Hello2(int a, int b) {
		
		this.a = a;
		this.b = b;
				
		System.out.println(this.a+this.b);
		
		// TODO Auto-generated constructor stub
	}
		
	public static void main(String[] args) {
		System.out.println(k);
		
	}
}
