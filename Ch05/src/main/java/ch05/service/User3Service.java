package ch05.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ch05.dao.User3DAO;

@Service
public class User3Service {

	@Autowired
	private User3DAO dao;
	
	public void insertUser3() {};
	public void selectUser3() {};
	public void selectUser3s() {};
	public void updateUser3() {};
	public void deleteUser3() {};

	
}
