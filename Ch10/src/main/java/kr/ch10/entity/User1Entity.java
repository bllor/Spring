package kr.ch10.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Data
@Entity
@Table(name="USER1")
public class User1Entity {

	@Id
	private String ID;
	private String NAME;
	private String HP;
	private String AGE;
}
