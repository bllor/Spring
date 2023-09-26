package kr.ch07.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Builder
public class User1DTO {

	


	private String uid;
	
	
	private String name;
	
	
	private String hp;
	
	
	private int age;
	/*
	
	noargsconstructor는 아무 속성도 없는 생성자(초기화 시킬 때 사용하는 생성자)
	public void user1DTO() {}
	
	allargsconstructor는 모든 속성을 매개변수로 받는 생성자
	public void user1DTO(String uid,String name,String hp,int age) {}
	
	*/
	
}
