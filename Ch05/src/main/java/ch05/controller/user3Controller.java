package ch05.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import ch05.DTO.User3DTO;

@Controller
public class user3Controller {

	@GetMapping("/user3/register")
	public String register() {
		return "/user3/register";
	}

	@GetMapping("/user3/list")
	public String list() {
		return "/user3/list";
	}

	@PostMapping("/user3/register")
	public String register(User3DTO dto) {
		
		
		return"redirect:/user3/list";
	}
	
}
