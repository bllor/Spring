package ch03.sub02;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component("service1")
public class Service {

	@Autowired
	private LogAdvice advice;
	//advice는 부가기능을 받는 모듈
	
	
	
	public void insert() {
		advice.beforeLog();
		System.out.println("CoreConcern Insert");
		advice.afterLog();
	}
	
	
	
	public void select() {
		System.out.println("CoreConcern select");

	}
	public void update(int no) {
		System.out.println("CoreConcern Update");

	}
	public void delete(int no , String name) {
		System.out.println("CoreConcern Delete");

	}
	
}
