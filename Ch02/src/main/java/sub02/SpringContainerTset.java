package sub02;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

/*
 * 날짜: 2023/09/18
 * 이름: 최동일
 * 내용: 스프링 컨테이너 실습하기
 * 
 * 
 * DI(Dependency Injection)
 * - 의존성 주입이라는 의미로 객체를 생성하는 방식이 아닌 컨테이너로부터 주입 받는 방식
 * - new를 사용하긴하지만 자주사용되는 객체(controller, dao, service 등등)는 주입식으로 사용함
 * - 생성자, 세터, 필드 3가지 주입 방식이 있다.
 * - @Component 선언으로 객체를 컨테이너에 등록
 * - @Component는 @Controller, @Service, @Repository(==dao)로 세분화 되어있다.
 * 
 */

public class SpringContainerTset {

	public static void main(String[] args) {
		
		ApplicationContext ctx = new GenericXmlApplicationContext("application.xml");
		
		Computer com= (Computer)ctx.getBean("com");
		
		
		System.out.println("--------------");
		com.show();
		
	}
	
}
