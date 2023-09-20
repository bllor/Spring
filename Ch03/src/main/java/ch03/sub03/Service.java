package ch03.sub03;

import org.springframework.stereotype.Component;

@Component("service2")
public class Service {

	public void insert() {
		System.out.println("CoreConcern insert");

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
