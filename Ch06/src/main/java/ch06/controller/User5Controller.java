package ch06.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import ch06.dto.User5DTO;
import ch06.service.User5Service;

@Controller
public class User5Controller {

	@Autowired
	private User5Service service;

	@GetMapping("/user5/register")
	public String register() {
		return "/user5/register";
	}
	
	@GetMapping("/user5/list")
	public String list(Model model) {
		
		List<User5DTO>users =  service.selectUser5s();
		model.addAttribute("users",users);
		return "/user5/list";
	}
	
	@PostMapping("/user5/register")
	public String register(User5DTO dto) {
		service.insertUser5(dto);
		return "redirect:/user5/list";
	}
	
}
