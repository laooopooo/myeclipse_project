package advice;

import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;

@Aspect
public class AfterThrowingAeviceTest {

	@AfterThrowing(throwing = "ex", pointcut = "execution(* bean.*.*(..))")
	public void doRecoveryActions(Throwable ex) {
		System.out.println("抛出的异常" + ex);
		System.out.println("异常处理程序");
	}
}
