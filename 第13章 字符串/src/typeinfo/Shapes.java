package typeinfo;

import java.util.Arrays;
import java.util.List;

abstract class Shape {
	void draw() {
		System.out.println(this + ".draw()");
	}

	@Override
	public abstract String toString();

}

class Circle extends Shape {
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "Circle";
	}
}

class Square extends Shape {
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "Square";
	}
}

class Triangle extends Shape {
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "Triangle";
	}
}

public class Shapes {
	public static void main(String[] args) {
		List<Shape> shapeList = Arrays.asList(new Circle(), new Square(),
				new Triangle());
		for (Shape shape : shapeList) {
			shape.draw();
		}
	}
}