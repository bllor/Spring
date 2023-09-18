package sub01;

public class SamsungTV {
	
	private Speaker spk;

	public void powerOn() {
		System.out.println("SamsungTV powerOn");
	}

	public void powerOff() {
		System.out.println("SamsungTV powerOff");
	}
	
	public void soundUp() {
		spk.soundUp();
	}
	public void soundDown() {
		spk.soundDown();
	}
	
	/*
		이 코드는 문제가 있는데 speak에 대한 초기값이 없음(자바에서는 생성자로 초기화를 시킴)
		그래서 spk.soundUp을 할 경우 에러가 발생함
		
		하지만 스프링 컨테이너로부터 객체를 주입 받음으로써 객체를 초기화하지 않더라도 실행이된다.(생성자가 필요없다.)
	*/
	
}
