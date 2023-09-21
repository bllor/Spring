package ch04.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class MainController {
	//메서드를 출력하고자 하는 파일의 이름으로 정하는 것이 좋다.
	//출력하려는 것뷰의 이름을 리턴 해줘야 함.
	//메인 컨트롤러에서 HandlerAdapter로 데이터를 리턴할 때 index라는 이름을 리턴한다.
	
	@RequestMapping(value={"/","/index"}, method=RequestMethod.GET)
	public String index() {
		return "index";//뷰의 정보
		//이 메서드는 프론트컨트롤러가 실행시키는데 그러기 위해서는 requestMapping 어노테이션이 필요
		//return값 에 접두어 접미어가 붙음(어디서 설정해둠)
	}
	
	@RequestMapping(value="/hello", method = RequestMethod.GET)
	public String hello() {
		return "hello";
	}
	
	@GetMapping("/welcome")
	public String welcome() {
		return "welcome";
	}
	
	@RequestMapping(value="/greeting", method = RequestMethod.GET)
	public String greeting() {
		return "greeting";
	}
	
	@GetMapping("/redirect")
	public String redirect() {
		return "redirect:/annotation/param";
		//주소 고정이므로 컨텍스트 루트를 없에고 보낸다.
	}
	
	@GetMapping("/forward")
	public String forward() {
		return "forward:/annotation/model";
		//주소 고정이므로 컨텍스트 루트를 없에고 보낸다.
	}
	
	
}
