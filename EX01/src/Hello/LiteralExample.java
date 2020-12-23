package Hello;

public class LiteralExample { //부모 클래스
	public static int k = 10; // 필드
	
	public static void main(String[] args) { //메서드(함수)
		
		Hello2 hello2 = new Hello2(10, 2); //시공해주세요 1,2로요 //클래스의 인스턴스화 new
		//System.out.println(hello2);
	
		
	//정수 리터럴	
		int var1 = 10;
			System.out.println(var1);		
		int var2 = 010;
			System.out.println(var2);
		int var3 = 0x10;
			System.out.println(var3);
	//실수 리터럴		
		double var4 = 0.25;
			System.out.println(var4);
		double var5 = 2E5;
			System.out.println(var5);
	//문자리터럴
		char var6 = 'A';
			System.out.println(var6);
		char var7 = '한';
			System.out.println(var7);
			
		System.out.println("\t들여쓰기"); //들여쓰기
		System.out.println("대한\n민국"); //줄바꿈
		System.out.println("This\'s Java");
		System.out.println("이것은 \"중요\" 합니다"); //\이스케이프 탈출
		System.out.println("가격이\\300입니다");
		
		char var8 = '\u0041' + 25;
		int var9 = '\u0041' + 25;
		
		char cha = 'd';
		String str = "dddd";
		System.out.println(cha);
		System.out.println(str);
		
		System.out.println( (int) var6); //강제형변환 casting
		System.out.println(var8); //10진수 4곱하기 16의 1승 + 1 곱하기 16의 0승
		System.out.println(var9);
		
	
		
		
		
		
		
		
	}
}
