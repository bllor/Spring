package kr.ch10.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import kr.ch10.dto.User2DTO;
import lombok.Builder;
import lombok.Data;

@Data
@Entity
@Builder
@Table(name="USER2")
public class User2Entity {

		@Id
		private String ID;
		private String NAME;
		private String HP;
		private String AGE;
		
		//DTO 변환 메서드
		public User2DTO toDTO() {
			
			return User2DTO.builder()
							.ID(ID)
							.NAME(NAME)
							.HP(HP)
							.AGE(AGE)
							.build();
							
		}
}
