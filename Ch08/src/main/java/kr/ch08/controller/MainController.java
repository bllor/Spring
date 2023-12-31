package kr.ch08.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import kr.ch08.dto.User1DTO;
import kr.ch08.entity.User1Entity;
import kr.ch08.repository.User1Repository;
import kr.ch08.service.User1Service;

@Controller
public class MainController {

	@Autowired
	private User1Repository repo;

	@GetMapping(value = {"/", "/index"})
	public String index() {
		return "/index";
	}

	@GetMapping("/query1")
	public String query1() {

		User1Entity entity = repo.findUser1EntityByUid("m101");
		System.out.println(entity);

		return "redirect:/";
	}
	@GetMapping("/query2")
	public String query2() {

		List<User1Entity> list = repo.findUser1EntityByName("최동일");
		System.out.println(list);

		return "redirect:/";
	}
	@GetMapping("/query3")
	public String query3() {
		return "redirect:/";
	}
	@GetMapping("/query4")
	public String query4() {
		return "redirect:/";
	}
	@GetMapping("/query5")
	public String query5() {
		return "redirect:/";
	}
	@GetMapping("/query6")
	public String query6() {
		return "redirect:/";
	}
	@GetMapping("/query7")
	public String query7() {
		return "redirect:/";
	}
	@GetMapping("/query8")
	public String query8() {
		return "redirect:/";
	}
	@GetMapping("/query9")
	public String query9() {
		return "redirect:/";
	}
	@GetMapping("/query10")
	public String query10() {
		return "redirect:/";
	}
	@GetMapping("/query11")
	public String query11() {
		return "redirect:/";
	}
	@GetMapping("/query12")
	public String query12() {
		return "redirect:/";
	}
	@GetMapping("/query13")
	public String query13() {
		return "redirect:/";
	}
	@GetMapping("/query14")
	public String query14() {
		return "redirect:/";
	}
	@GetMapping("/query15")
	public String query15() {
		return "redirect:/";
	}
	@GetMapping("/query16")
	public String query16() {
		return "redirect:/";
	}
	@GetMapping("/query17")
	public String query17() {
		return "redirect:/";
	}
	@GetMapping("/query18")
	public String query18() {
		return "redirect:/";
	}
	@GetMapping("/query19")
	public String query19() {
		return "redirect:/";
	}
	@GetMapping("/query20")
	public String query20() {
		return "redirect:/";
	}
	@GetMapping("/query21")
	public String query21() {
		return "redirect:/";
	}
	@GetMapping("/query22")
	public String query22() {
		return "redirect:/";
	}
	@GetMapping("/query23")
	public String query23() {
		
		List<Object[]>result = repo.selectUser1ByUid("m101");
		
		for(Object[] obj : result) {
			
			System.out.println("obj[0] : "+ obj[0]);
			System.out.println("obj[1] : "+ obj[1]);
			System.out.println("obj[2] : "+ obj[2]);
		}
		
		return "redirect:/";
	}

	
}
