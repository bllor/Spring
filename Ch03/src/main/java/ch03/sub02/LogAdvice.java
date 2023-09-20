package ch03.sub02;

import org.springframework.stereotype.Component;

@Component
public class LogAdvice {

	public void beforeLog() {
		System.out.println("------------------------");
		System.out.println("cross-cutting beforeLog");
	}
	public void afterLog() {
		System.out.println("cross-cutting afterLog");
		System.out.println("------------------------");
	}
}
