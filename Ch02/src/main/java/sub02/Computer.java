package sub02;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component("com")
public class Computer {

	private CPU cpu;
	private RAM ram;
	
	//DI - Field Inject
	@Autowired
	private HDD hdd;
	
	//DI - Constructor Inject
	@Autowired
	public Computer(CPU cpu) {
		this.cpu = cpu;
	}
	//context에서 computer에 cpu를 주입하면 자동으로 처리가 되게끔 @autowired선언을 해준다.

	//DI - Setter Inject
	@Autowired
	public void setRam(RAM ram) {
		this.ram = ram;
	}
	
//	초기화된 캡슐화된 객체의 값을 바꿀 수 있는 것이 set이다.
//	set을 통해서 간접적으로 값에 접근해서 바꾼다.
//	스프링에서 setRam을 호출하면서 주입.
	
	
	
	public void show() {
		cpu.show();
		ram.show();
		hdd.show();
	}
	
	
}
