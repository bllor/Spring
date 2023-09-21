package ch04.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import ch04.dto.ModelDTO;

@Controller
public class AnnotationController {

	@RequestMapping(value="/annotation/param", method=RequestMethod.GET)
	public String param() {
		return "/annotation/param";
	}
	
	
	@RequestMapping(value="/annotation/param1", method=RequestMethod.POST)
	public String param1(@RequestParam("uid") String uid, Model model) {
	
		System.out.println("AnnotationController uid : "+uid);
		
		//모델 참조를 통한 View 데이터 출력
		//model을 통해서 데이터를 보낸다.
		model.addAttribute("uid", uid);
		return"/result/param";
	}
	
	
	
	@PostMapping("/annotation/param2")
	public String param2(@RequestParam("uid") String uid,
						 String name,
						Model model) {
		//requestParam은 생략가능하다. 프론트 컨트롤러에서 처리가 되어서 데이터가 넘어오므로
		//모델의 선언위치는 상관없다.
		
		System.out.println("uid : "+uid);
		System.out.println("name : "+name);

		model.addAttribute("uid", uid);
		model.addAttribute("name", name);
		return"/result/param";
	}
	@PostMapping("/annotation/param3")
	public String param3(String uid,  int age, String name, String hp, Model model) {
		
		model.addAttribute("uid", uid);
		model.addAttribute("name", name);
		model.addAttribute("hp", hp);
		model.addAttribute("age", age);
		
		return"/result/param";
	}
	
	
	@GetMapping("/annotation/model")
	public String model() {
		return "/annotation/model";
	}
	
	@PostMapping("/annotation/model1")
	public String model1(@ModelAttribute ModelDTO dto) {
		//form에서 보내진 값을 modelDTO에 바인딩하려면 modelattribute를 사용
		//modelattribute도 생략가능
		//출력하려면 model을 선언해주어도 되지만,
		//modelattribute에 model선언 기능이 추가 되어 있으므로 생략해도 된다.
		//result.view에서 바로 사용할 수 잇음
		return "/result/model";
	}
	
	@PostMapping("/annotation/model2")
	public String model2(@ModelAttribute("user") ModelDTO dto) {
		//@ModelAttribute("user")에서 key이름이 user, value가 dto
		return "/result/model";
	}

	@PostMapping("/annotation/model3")
	public String model3(ModelDTO dto ,RedirectAttributes rttr) {
		
		
		
		rttr.addAttribute("param","용");
		return "redirect:/annotation/model?={param}";
	}

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
