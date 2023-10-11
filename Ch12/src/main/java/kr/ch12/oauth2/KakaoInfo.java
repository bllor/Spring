package kr.ch12.oauth2;

import java.util.Map;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class KakaoInfo {

	private  Map<String, Object> attributes;
	
	public String getId() {
		return attributes.get("id").toString();
	}

	public String getProvider() {
		return "kakao";
		//return attributes.get("provider").toString();
	}

	public String getEmail() {
		//kakao_account 이게 맵임
		return (String)((Map<?,?>) attributes.get("kakao_account")).get("email");
	}

	public String getNickname() {
		return (String)((Map<?,?>) attributes.get("properties")).get("nickname");
	}

	
}
