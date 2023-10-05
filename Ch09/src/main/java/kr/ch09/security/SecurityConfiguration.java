package kr.ch09.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configurers.CsrfConfigurer;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;


@Configuration
public class SecurityConfiguration {

	
	@Autowired
	private SecurityUserService service;
	
	@Bean
	//스프링 container에 등록한다.
	public SecurityFilterChain filterChain( HttpSecurity http ) throws Exception {
		
		// 인가 설정
				http.authorizeHttpRequests(
						authorizehttprequeuests ->
						authorizehttprequeuests
							.requestMatchers("/").permitAll()//인덱스는 모두가 다 들어갈 수 있고
							.requestMatchers("/admin/**").hasAuthority("ADMIN")//admin이라고 된 곳은 role이 admin인 id만 들어갈 수 있음
							.requestMatchers("/manager/**").hasAnyAuthority("ADMIN","MANAGER")
							.requestMatchers("/user/**").permitAll()
							
						);
				// 사이트 위변조 방지 설정
				http.csrf(CsrfConfigurer::disable);
				
				// 로그인 설정
				http.formLogin(
						login -> login
							.loginPage("/user/login")
							.defaultSuccessUrl("/user/success")
							.failureUrl("/user/login?success=100")
							.usernameParameter("uid")
							.passwordParameter("pass")
						);
				// 로그아웃 설정
				http.logout(
						logout -> logout
						.invalidateHttpSession(true)
						.logoutRequestMatcher(new AntPathRequestMatcher("/user/logout"))
						.logoutSuccessUrl("/user/login?success=200")
						);
				
				// 사용자 인증처리 컴포넌트 등록
				http.userDetailsService(service);
				
				return http.build();
			}
			
			@Bean
			public PasswordEncoder passwordEncoder() {
				return new BCryptPasswordEncoder();
			}
	
	
}
