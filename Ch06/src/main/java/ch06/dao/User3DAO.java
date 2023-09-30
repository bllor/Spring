package ch06.dao;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import ch06.dto.User3DTO;

@Repository
public class User3DAO {
	
	@Autowired
	private SqlSessionTemplate mybatis;
	
	
	public void insertUser3(User3DTO dto) {
		mybatis.insert("user3.insertUser3", dto);
	}
	public User3DTO selectUser3(String uid) {
		return mybatis.selectOne("user3.selectUser3", uid);
	}
	public List<User3DTO> selectUser3s() {
		return mybatis.selectList("user3.selectUser3s");
	}
	public void updateUser3(User3DTO dto) {
		mybatis.update("user3.updateUser3", dto);
	}
	public void deleteUser3(String uid) {
		mybatis.delete("user3.deleteUser3",uid);
		
	}
}
