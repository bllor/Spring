package kr.ch12.entity;

import java.time.LocalDateTime;
import java.util.Collection;
import java.util.Map;

import org.hibernate.annotations.CreationTimestamp;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.oauth2.core.user.OAuth2User;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
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
@Entity
@Table(name="User")
public class UserEntity implements OAuth2User {

	@Id
	private String uid;
	private String pass;
	private String name;
	private int age;
	private String hp;
	private String role;
	
	@CreationTimestamp
	private LocalDateTime regDate;
	
	//추가필드
	private String provider;
	private String nickname;
	private String email;
	@Override
	public Map<String, Object> getAttributes() {
		//속성들을 맵구조체로 만들어야 한다.
		//put으로 넣어야 한다.
		
		return null;
	}
	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		//ROLE을 추가하는 것
		//myUserDetails에 존재한다.
		return null;
	}
}
