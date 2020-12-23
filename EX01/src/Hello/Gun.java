package Hello;

public class Gun {
	
	public static int x = 1; // 전역변수
	
	public static void call(int z) { // (int z = y) y를 받아서 z에 넣음
		System.out.println("콜" + x);
		System.out.println(z);
	}
	
	public static void meow(int z) {
		System.out.println("야옹" + x);
		System.out.println(z);
	}
	
	public static void main(String[] args) {
		
			int y = 3; // 지역변수
			System.out.println("냥냥");
			System.out.println(x + y);
			call(y); //호출 = 부른다 = 함수 쓰겟다. // y를 던짐
			meow(y);
	}
	

}
