package kr.ch09.security;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;


@Getter
@Setter
@Builder
@ToString
public class MyUserDetails implements UserDetails {
//여기의 내용이 session에 저장된다.

	
	private static final long serialVersionUID = 1L;

	
	//DB의 사용자 정보를 매핑
	private String uid;
	private String pass;
	private String name;
	private int age;
	private String hp;
	private String role;
	private LocalDateTime regDate;
	
	

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
	//등급(role)을 리턴해줌
	//일반 사용자 user, 중간 관리자 manager, 최고관리자 admin
	//권한이 하나 이상인 사람이 있을 수 있으므로 collection을 사용한다
	//계장이 갖는 권한 목록
		
		List<GrantedAuthority> authorities = new ArrayList<>();
		authorities.add(new SimpleGrantedAuthority(role));
		return authorities;
	}

	@Override
	public String getPassword() {
		//비밀번호를 return한다.
		
		return pass;
	}

	@Override
	public String getUsername() {
		//여기서 username은 이름이 아니라 아이디를 뜻한다.
		return uid;
	}

	@Override
	public boolean isAccountNonExpired() {
		//계장 만료 여부 확인(true==만료안됨 & false==만료됨 -> 로그인이 안됨.)
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		//계정 잠김 여부(true:잠김x , false:잠김)
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		//계정 비밀번호 만료 여부(true:만료안됨 , false:만료)
		//한 가지 비밀 번호를 계속 사용하게 하면 안된다.
		//계속 비밀번호를 바꿀 수 있게 해야지 보안 문제에서 빠져나올 수 있다.
		return true;
	}

	@Override
	public boolean isEnabled() {
		//계정 활성화 여부(true:활성화 , false:비활성화)		
		return true;
	}

}
