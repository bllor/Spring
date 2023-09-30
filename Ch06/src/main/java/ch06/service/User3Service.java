package ch06.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ch06.dao.User3DAO;
import ch06.dto.User3DTO;

@Service
public class User3Service {

	@Autowired
	private User3DAO dao;
	
	public void insertUser3(User3DTO dto) {
		dao.insertUser3(dto);
	}
	public User3DTO selectUser3(String uid) {
		return dao.selectUser3(uid);
	}
	public List<User3DTO> selectUser3s() {
		return dao.selectUser3s();
	}
	public void updateUser3(User3DTO dto) {
		dao.updateUser3(dto);
	}
	public void deleteUser3(String uid) {
		dao.deleteUser3(uid);
	}
}
