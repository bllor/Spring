package kr.ch10.dto;

import kr.ch10.entity.User2Entity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class User2DTO {

	private String ID;
	private String NAME;
	private String HP;
	private String AGE;
	
	//ENTITY 변환 메서드
	
	public User2Entity toEntity() {
	return User2Entity.builder()
						.ID(ID)
						.NAME(NAME)
						.HP(HP)
						.AGE(AGE)
						.build()
			;	
	}
	
}
