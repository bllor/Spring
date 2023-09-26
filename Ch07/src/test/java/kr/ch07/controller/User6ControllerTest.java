package kr.ch07.controller;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import kr.ch07.mapper.User6Mapper;
import kr.ch07.service.User6service;

@WebMvcTest(controllers = User6Controller.class)
public class User6ControllerTest {

	@Autowired
	private MockMvc mvc;
	
	@MockBean
	private User6service service;
	
	@MockBean
    private User6Mapper user6Mapper; // 모의(mock) 객체로 대체
	
	@Test
	 public void register() throws Exception {
		 mvc
			.perform(post("/user6/register")
					.param("uid","s101")
					.param("name","홍길동")
					.param("age","23")
					)                 //index 요청 테스트
			.andExpect(status().is3xxRedirection())				//요청결과 상태 테스트
			.andExpect(redirectedUrl("/user6/list"))		//반환되는 view 이름 테스트
			.andDo(print());
	
	}
 


	
	
}
