package bean;

import org.springframework.stereotype.Component;

@Component
public class Chinese extends Person {
	public void sayHello(String name) {
		System.out.println(name + "Hello,Spring AOP");
		try {
			int a = 10 / 0;
		} catch (Exception e) {
			throw e;
		}
	}

	public void eat(String food) {
		System.out.println("ÎÒÕýÔÚ³Ô" + food);
	}

}
