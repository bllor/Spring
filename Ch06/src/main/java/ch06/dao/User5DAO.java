package ch06.dao;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import ch06.dto.User5DTO;

@Repository
public class User5DAO {

	@Autowired
	private SqlSessionTemplate mybatis;
	
	
	public void insertUser5(User5DTO dto) {
		mybatis.insert("user5.insertUser5", dto);
	}
	public User5DTO selectUser5(String uid) {
		return null;
	}
	public List<User5DTO> selectUser5s() {
		return mybatis.selectList("user5.selectUser5s");
	}
	public void updateUser5(User5DTO dto) {}
	public void deleteUser5(String uid) {}
	
}
