package Hello; //package 부분

// import libarary : 라이브러리 임포트 부분

public class Delivery { // class 시작 부분 (비현실)
	
	//1. 필드(속성, 변수) 부분
	int iv;  // 전역변수 : 같은 클래스에서 호출이 가능하며
	static String 엽기떡볶이_time = "50"; // 전역변수이면서 static : 다른 클래스에서도 호출 가능
	static String 페리카나_time = "40"; // main method가 static이기에 main안에서 사용되는 변수들은 다 static 붙어야함
	static String 김밥천국_time = "30";
	static String 삼겹살잘하는집_time = "60";	
	

	//2. 메소드 부분
	
	// main 메소드
	public static void main(String[] args) {	
		
		String x = "인천 계양구 아나지로 199 505동 2501호"; // 지역변수 : 메소드 안에서 선언되고 사라지니까
				
		yupgi_delivery(x, 엽기떡볶이_time); //call
		System.out.println();
		
		pericana_delivery(x, 페리카나_time);
		System.out.println();
		
		gimbap_delivery(x, 김밥천국_time);
		System.out.println();
		
		pork_delivery(x, 삼겹살잘하는집_time);	
				
	}
	
	//일반 메소드
	
	public static void yupgi_delivery(String x, String 엽기떡볶이_time) {	// method
		System.out.println("배달중입니다. 주문지: " + x);
		System.out.println("엽기떡볶이가 " + 엽기떡볶이_time + "분 후에 도착합니다.");
	}
	
	public static void pericana_delivery(String x, String time) {	// method
		System.out.println("배달중입니다. 주문지: " + x);
		System.out.println("페리카나가 " + time + "분 후에 도착합니다.");
	}
	
	public static void gimbap_delivery(String x, String time) {	// method
		System.out.println("배달중입니다. 주문지: " + x);
		System.out.println("김밥천국이 " + time + "분 후에 도착합니다.");
	}
	
	public static void pork_delivery(String x, String time) {	// method
		System.out.println("배달중입니다. 주문지: " + x);
		System.out.println("삼겹살잘하는집이 " + time + "분 후에 도착합니다.");
	}

}

