package ch06.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import ch06.dto.User3DTO;
import ch06.service.User3Service;

@Controller
public class User3Controller {
	
	@Autowired
	User3Service service;
	
	@GetMapping("/user3/register")
	public String register() {
		return"/user3/register";
	}
	
	
	@GetMapping("/user3/list")
	public String list(Model model) {
		
		List<User3DTO> users = service.selectUser3s();
		model.addAttribute("users", users);
		return "/user3/list";
	}
	
	@PostMapping("/user3/register")
	public String register(User3DTO dto) {
		service.insertUser3(dto);
		
		return "redirect:/user3/list";
	}
	
	@GetMapping("/user3/modify")
	public String modify(String uid, Model model) {
		
		User3DTO dto = service.selectUser3(uid);
		model.addAttribute(dto);
		return("/user3/modify");
	}
	
	@PostMapping("/user3/modify")
	public String modify(User3DTO dto) {
		
		service.updateUser3(dto);
		
		return"redirect:/user3/list";
	}
	
	@GetMapping("/user3/delete")
	public String delete(String uid) {
		service.deleteUser3(uid);
		return"redirect:/user3/list";
	}
	
}
