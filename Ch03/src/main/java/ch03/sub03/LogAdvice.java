package ch03.sub03;

import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component("log")
public class LogAdvice {

	@Pointcut("execution(void ch03.sub03.Service.insert(..))")
	public void insertPointcut() {};//내용이 없는 참조 메서드
	
	@Pointcut("execution(void ch03.sub03.Service.select(..))")
	public void selectPointcut() {};//내용이 없는 참조 메서드

	@Before("insertPointcut() || selectPointcut()")
	public void beforeLog() {
		System.out.println("------------------------");
		System.out.println("cross-cutting beforeLog");
	}
	
	@After("insertPointcut() || selectPointcut()")
	public void afterLog() {
		System.out.println("cross-cutting afterLog");
		System.out.println("------------------------");
	}

//이 클래스가 aspect라서 aspect 어노테이션을 선언
	
}
