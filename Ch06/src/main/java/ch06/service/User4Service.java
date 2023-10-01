package ch06.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ch06.dao.User4DAO;
import ch06.dto.User4DTO;

@Service
public class User4Service {

	@Autowired
	private User4DAO dao;
	
	public void insertUser4(User4DTO dto) {
		dao.insertUser4(dto);
	}
	public User4DTO selectUser4(String seq) {
		
		return dao.selectUser4(seq);
	}
	public List<User4DTO> selectUser4s() {
		return dao.selectUser4s();
	}
	public void updateUser4(User4DTO dto) {
		 dao.updateUser4(dto);
	}
	public void deleteUser4(String seq) {
		dao.deleteUser4(seq);
	}
}
