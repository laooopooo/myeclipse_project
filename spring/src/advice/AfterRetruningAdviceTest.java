package advice;

import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;

@Aspect
public class AfterRetruningAdviceTest {
	@AfterReturning(returning = "rvt", pointcut = "execution(* bean.*.*(..))")
	public void log(Object rvt) {
		System.out.println("获取目标方法返回值" + rvt);
		System.out.println("日志记录");
	}

}
