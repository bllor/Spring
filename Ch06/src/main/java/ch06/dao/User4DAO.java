package ch06.dao;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import ch06.dto.User4DTO;

@Repository
public class User4DAO {
	
	@Autowired
	private static final Logger log = LogManager.getLogger(User4DAO.class);
	@Autowired
	private SqlSessionTemplate mybatis;
	
	public void insertUser4(User4DTO dto) {
		log.info("insertUser4 :"+dto.toString());
		mybatis.insert("user4.insertUser4", dto);
	}
	public User4DTO selectUser4(String seq) {
		
		return mybatis.selectOne("user4.selectUser4", seq);
	}
	public List<User4DTO> selectUser4s() {
		return mybatis.selectList("user4.selectUser4s");
	}
	public void updateUser4(User4DTO dto) {
		mybatis.update("user4.updateUser4", dto);
	}
	public void deleteUser4(String seq) {
		mybatis.delete("user4.deleteUser4",seq);
	}
	
}
