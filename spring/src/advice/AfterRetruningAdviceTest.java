package advice;

import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;

@Aspect
public class AfterRetruningAdviceTest {
	@AfterReturning(returning = "rvt", pointcut = "execution(* bean.*.*(..))")
	public void log(Object rvt) {
		System.out.println("��ȡĿ�귽������ֵ" + rvt);
		System.out.println("��־��¼");
	}

}
