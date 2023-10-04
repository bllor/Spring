package ch06.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ch06.dao.User5DAO;
import ch06.dto.User5DTO;

@Service
public class User5Service {

	
	@Autowired
	private User5DAO dao;
	
	public void insertUser5(User5DTO dto) {
		dao.insertUser5(dto);
	}
	public User5DTO selectUser5(String uid) {
		return dao.selectUser5(uid);
	}
	public List<User5DTO> selectUser5s() {
		return dao.selectUser5s();
	}
	public void updateUser5(User5DTO dto) {
		dao.updateUser5(dto);
	}
	public void deleteUser5(String uid) {
		dao.deleteUser5(uid);
	}
}
