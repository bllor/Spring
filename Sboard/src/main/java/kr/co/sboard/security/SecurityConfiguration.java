package kr.co.sboard.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configurers.CsrfConfigurer;
import org.springframework.security.config.annotation.web.configurers.FormLoginConfigurer;
import org.springframework.security.config.annotation.web.configurers.HttpBasicConfigurer;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;



@Configuration
public class SecurityConfiguration {

	

	@Bean
	public SecurityFilterChain filterChain( HttpSecurity http ) throws Exception {
		
		http
			//사이트 위변조 방지 비활성
			.csrf(CsrfConfigurer::disable)//::는 매서드 참조 연산자로 람다식을 간결하게 표현해준다.
			//기본 HTTP 인증방식 비활성
			.httpBasic(HttpBasicConfigurer::disable)
			//폼로그인 설정
			.formLogin(config -> config.loginPage("/user/login")
										.defaultSuccessUrl("/list")
										.failureUrl("/user/login?success=100")
										.usernameParameter("uid")
										.passwordParameter("pass"))

			//로그아웃 설정
				 .logout(config ->config.logoutUrl("/user/logout")
						 				.invalidateHttpSession(true)
						 .logoutSuccessUrl("/user/login?success=200"))
			//인가 권한 설정
			.authorizeHttpRequests(AuthorizeRequests ->AuthorizeRequests
														.requestMatchers("/admin/**").hasAuthority("ADMIN") 
														.requestMatchers("/manager/**").hasAnyAuthority("ADMIN","MANAGER") 
														.requestMatchers("/user/**").permitAll()
														.anyRequest().permitAll());
				return http.build();
				//개발할 때는 crsf를 해제시켜 놓는다.
				//API서버이므로 세션 인증 방식으로 처리를 하지 않으므로, Httpbasic도 disable시켜준다.
				//로그인을 할 때 데이터는 JSON으로 넘어온다.	
			}
	
	
			@Bean
			public PasswordEncoder passwordEncoder() {
				return new BCryptPasswordEncoder();
			}
	
	@Bean
	public AuthenticationManager authenticationManager (AuthenticationConfiguration config) throws Exception {
		return config.getAuthenticationManager();
	}
	
}
