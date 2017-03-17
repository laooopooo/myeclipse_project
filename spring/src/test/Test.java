package test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import bean.Chinese;

public class Test {
	public static void main(String[] args) {
		ApplicationContext ctx = new ClassPathXmlApplicationContext("bean.xml");
		Chinese c = ctx.getBean("chinese", Chinese.class);
		c.eat("xigua");
		c.sayHello("zhangsan");
	}

}
