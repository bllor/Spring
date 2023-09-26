package kr.ch07.controller;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.web.servlet.MockMvc;


@WebMvcTest(controllers = MainController.class)
public class MainCotrollerTest {
	
	//MVC 테스트를 위한 가상 MVC 객체
	@Autowired
	private MockMvc mvc;
	
	
	//test외 다른 어노테이션들은 static을 붙여주어야 한다.
	@BeforeAll
	public static void beforeAll() {
		System.out.println("beforeall");
	};
	
	@BeforeEach
	public  void beforeEach() {
		System.out.println("beforeeach");
	}
	
	@AfterAll
	public static void afterAll() {
		System.out.println("afterall");
	};
	
	@AfterEach
	public  void afterEach() {
		System.out.println("aftereach");
	}
	
	
	//테스트케이스 중 어떤 것이 먼저 실행되는지는 중요하지 않다.
	@Test
	public void index() throws Exception {
		mvc
		.perform(get("/index"))                 //index 요청 테스트
		.andExpect(status().isOk())				//요청결과 상태 테스트
		.andExpect(view().name("/index"))		//반환되는 view 이름 테스트
		.andDo(print());						//요청 테스트 결과 출력
	}
	
	
	public void include() throws Exception {
		mvc
		.perform(get("/include")
				.param("name","홍길동")
				.param("age","23")
				)                 //index 요청 테스트
		.andExpect(status().isOk())				//요청결과 상태 테스트
		.andExpect(view().name("/include"))		//반환되는 view 이름 테스트
		.andDo(print());						//요청 테스트 결과 출력
	}
	
	public void layout() {
		System.out.println("layout");
	}
	
}
