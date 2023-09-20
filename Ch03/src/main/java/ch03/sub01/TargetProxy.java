package ch03.sub01;

public class TargetProxy implements Target {
//aop모델이라고 보면된다.
	
	private Target target;
	
	public TargetProxy(Target target) {
		 this.target = target;
	}
	
	public void before() {
		System.out.println("cross-cutting before");
	}
	public void after() {
		System.out.println("cross-cutting after");

	}
	
	public void doBusiness() {
		before();
		target.doBusiness();
		after();
		
	}
	
	
	
}
