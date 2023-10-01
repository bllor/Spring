package ch06.controller;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import ch06.dto.User4DTO;
import ch06.service.User4Service;


@Controller
public class User4Controller {
	@Autowired
	private static final Logger log = LogManager.getLogger(User4Controller.class);
	
	
	@Autowired
	private User4Service service;
	
	@GetMapping("/user4/register")
	public String register() {
		return"/user4/register";
	}
	
	@PostMapping("/user4/register")
	public String register(User4DTO dto) {
		log.info("REGISTER : "+dto.toString());
		log.info("NAME : "+dto.getName());
		log.info("gender : "+dto.getGender());
		log.info("AGE : "+dto.getAge());
		log.info("ADDR : "+dto.getAddr());
		service.insertUser4(dto);
		return "redirect:/user4/list";
	}
	
	@GetMapping("/user4/list")
	public String list(Model model) {
		List<User4DTO> users=  service.selectUser4s();
		model.addAttribute("users", users);
		return"/user4/list";
	}
	
	
	@GetMapping("/user4/delete")
	public String delete(String seq) {
		service.deleteUser4(seq);
		return "redirect:/user4/list";
	}
	
	@GetMapping("/user4/modify")
	public String modify(String seq, Model model) {
		 User4DTO dto = service.selectUser4(seq);
		model.addAttribute(dto);
		return "/user4/modify";
	}
	
	@PostMapping("/user4/modify")
	public String modify(User4DTO dto) {
		service.updateUser4(dto);
		
		return"redirect:/user4/list";
	}
	
}
