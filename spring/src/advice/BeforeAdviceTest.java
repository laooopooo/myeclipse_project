package advice;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;

@Aspect
public class BeforeAdviceTest {
	@Before("execution(* bean.*.*(..))")
	public void authority() {
		System.out.println("����Ȩ�޼�鷽��");
	}

}
