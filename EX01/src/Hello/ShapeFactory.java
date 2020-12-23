package Hello;
//정보은닉

class ShapeFactory extends Abstract implements Interface  {

	public Shape createRectangle() {
		return new Rectangle();
	}

	public Shape createCircle() {
		return new Circle();
	}

}

public static void main(String[] args) {

    ShapeFactory factory = new ShapeFactory();



    Shape shape = factory.createCircle(); // 메인은 실제로 Rectangle()과 Circle()를모른다 오로지 createCircle()을 호출했기에

    shape.draw();


}
