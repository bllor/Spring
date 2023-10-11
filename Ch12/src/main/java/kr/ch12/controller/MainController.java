package kr.ch12.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import kr.ch12.oauth2.OAuth2UserService;
import kr.ch12.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;

@Log4j2
@RequiredArgsConstructor
@Controller
public class MainController {

	private final OAuth2UserService service;
	
	@GetMapping(value= {"/","/index"})
	public String index() {
		return"/index";
	}
	
	@GetMapping("/user/login")
	public String login() {
		return "/user/login";
	}
	
	@GetMapping("/user/logout")
	public String logout(@RequestParam("id") String id) {
		log.info("id : "+id);
		
		return"redirect:/";
	}
}
