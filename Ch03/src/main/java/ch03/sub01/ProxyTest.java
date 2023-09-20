package ch03.sub01;

public class ProxyTest {

	
	public static void main(String[] args) {
		
		Target target = new TargetImpl();
		Target proxy = new TargetProxy(target);
		
		proxy.doBusiness();
	}
}
