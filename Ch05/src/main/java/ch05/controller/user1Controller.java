package ch05.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import ch05.DTO.User1DTO;
import ch05.service.User1Service;

@Controller
public class user1Controller {

	@Autowired
	private User1Service service;
	//서비스를 인터페이스로 만드는 것이 좋다.
	
	
	@GetMapping("/user1/register")
	public String register() {
		return "/user1/register";
	}
	
	@PostMapping("/user1/register")
	public String register(User1DTO dto) {
		service.insertUser1(dto);
		
		return "redirect:/user1/list";
	}
	
	@GetMapping("/user1/list")
	public String list(Model model) {
		List<User1DTO> users = service.selectUser1s();
		model.addAttribute("users",users);
		return "/user1/list";
	}
	
	@GetMapping("/user1/modify")
	public String modify(String uid,Model model) {
		
		User1DTO user = service.selectUser1(uid);
		model.addAttribute(user);
		//키이름을 지정해주지 않고 보내면 값의 이름을 키로 지정한다.
		//value가 배열이거나 컬렉션인 경우 클래스 이름의 첫자는 소문자로 처리한다.
		//dto의 경우 user1DTO가 보내진다.
				
		return "/user1/modify";
	}
	
	@PostMapping("/user1/modify")
	public String modify(@ModelAttribute User1DTO dto) {

		service.updateUser1(dto);
		//키이름을 지정해주지 않고 보내면 값의 클래스 명을 키로 지정한다.
		
		return "redirect:/user1/list";
	}
	
	@GetMapping("/user1/delete")
	public String delete(String uid) {
		service.deleteUser1(uid);
		return "redirect:/user1/list";
	}

	
}
