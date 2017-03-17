package advice;

import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;

@Aspect
public class AfterThrowingAeviceTest {

	@AfterThrowing(throwing = "ex", pointcut = "execution(* bean.*.*(..))")
	public void doRecoveryActions(Throwable ex) {
		System.out.println("�׳����쳣" + ex);
		System.out.println("�쳣�������");
	}
}
