package kr.ch12.oauth2;

import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.oauth2.client.userinfo.DefaultOAuth2UserService;
import org.springframework.security.oauth2.client.userinfo.OAuth2UserRequest;
import org.springframework.security.oauth2.core.OAuth2AuthenticationException;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.stereotype.Service;

import kr.ch12.entity.UserEntity;
import kr.ch12.repository.UserRepository;
import lombok.extern.log4j.Log4j2;

@Log4j2
@Service
public class OAuth2UserService extends DefaultOAuth2UserService {

	@Autowired
	private UserRepository userRepository;
	
	@Override
		public OAuth2User loadUser(OAuth2UserRequest userRequest) throws OAuth2AuthenticationException {
		//loadUser 매서드는 카카오의 서버에서 가지고 있는 사용자의 정보가 들어오는 곳
		
		//카카오에서 발행되는 JWT토큰
		//인증서버에서 발행한 토큰이 리소스서버로 넘어갔다가, 애플리케이션으로 보내짐
		String accessToken = userRequest.getAccessToken().getTokenValue();
		log.info("accessToken : "+accessToken);
		
		//서비스 제공자
 		String provider =  userRequest.getClientRegistration().getRegistrationId();
 		log.info("Provider : "+provider);
		
		OAuth2User oAuth2User  = super.loadUser(userRequest);
		log.info("oAuth2User : "+oAuth2User);
		//카카오, 네이버, 구글 등에 따라 조건을 다르게 만들어주어야 한다.
		//카카오info, 네이버info 사용되는 것에 따라 생성한다.
		
		
		Map<String , Object> attributes = oAuth2User.getAttributes();
		KakaoInfo kakaoInfo = new KakaoInfo(attributes);
		log.info("kakaoInfo : "+kakaoInfo);
		
		//회원가입처리
		//id는 카카오의 고유 식별번호
		String id = kakaoInfo.getId();
		String email = kakaoInfo.getEmail();
		String nickname = kakaoInfo.getNickname();
		
		 Optional<UserEntity>result = userRepository.findById(id);
		
		 UserEntity user = null;
		 
		 //DB에 저장을 할 때 userEntity에 저장된 user가 저장이 되어야 한다.
		 //oAuth2User는 카카오에서 발급하는 것으로 SpringSecurity에 포함되는 내용
		 
		 if(result.isEmpty()) {
			 //최초 소셜 동의체크 후 가입
			  user = UserEntity.builder()
			 									.uid(provider+"_"+id)
			 									.name(nickname)
			 									.nickname(nickname)
			 									.email(email)
			 									.provider(provider)
			 									.role("USER")
			 									.build();
			 
			 userRepository.save(user);
		 
		 }else {
			 //회원가입된 사용자 조회
			  user = result.get();
		 }
		
		return user;
		}
	
}
