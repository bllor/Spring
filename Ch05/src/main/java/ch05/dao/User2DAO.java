package ch05.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import ch05.DTO.User2DTO;

@Repository
public class User2DAO {
	
	@Autowired
	private JdbcTemplate jdbc;
	
	public void insertUser2(User2DTO dto) {
		String sql = "insert into `user2` values (?, ?, ?, ?)";
		Object []param = {
						dto.getUid(),
						dto.getName(),
						dto.getHp(),
						dto.getAge()
		};
		
		jdbc.update(sql, param);
		
	}
	public User2DTO selectUser2(String uid) {
		
		String sql ="select * from `user2` where uid=?";
		User2DTO dto = jdbc.queryForObject(sql, new User2RowMapper(), uid);
		return dto;
	
	}
	public List<User2DTO> selectUser2s() {
		String sql ="select * from `user2`";
		List<User2DTO> users = jdbc.query(sql, new User2RowMapper());
		return users;		
	}
	public void updateUser2(User2DTO dto) {
		String sql ="update `user2` set `name`=?, `hp`=?, `age`=? where uid=?";
		Object []param = {
						dto.getName(),
						dto.getHp(),
						dto.getAge(),
						dto.getUid()
		};
				
		jdbc.update(sql, param);
				
		}
		
	
	public void deleteUser2(String uid) {
		String sql = "delete from `user2` where uid=?";
		jdbc.update(sql, uid);
		
	}
}
