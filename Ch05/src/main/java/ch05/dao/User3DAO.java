package ch05.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class User3DAO {

	@Autowired
	private JdbcTemplate jdbc;
	
	public void insertUser3() {};
	public void selectUser3() {};
	public void selectUser3s() {};
	public void updateUser3() {};
	public void deleteUser3() {};


}
