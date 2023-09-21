package ch05.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import ch05.DTO.User1DTO;

@Repository
public class User1DAO {
//싱글톤이 필요없음
//repository를 spring context에 등록을 해서 주입을 받으므로
//context에 들어가는 객체들이 결론적으로는 싱글톤임
	
	
	//스프링과 jdbc를 연결하는 클래스
	//spring context에서 클래스를 주입받아야 하므로, application.xml에 설정을 해두어야 한다.
	@Autowired
	private JdbcTemplate jdbc;
	
	public void insertUser1(User1DTO dto) {
		
		String sql ="insert into `user1` values(?,?,?,?)";
		Object[] params= {
							dto.getUid(), 
							dto.getName() , 
							dto.getHp(), 
							dto.getAge()}; 
		
		jdbc.update(sql,params);
		
	}
	
	public User1DTO selectUser1(String uid) {
		String sql ="select * from `user1` where uid =?";
		User1DTO dto = jdbc.queryForObject(sql,new User1RowMapper() ,uid );
		return dto;
	}
	
	public List<User1DTO> selectUser1s() {
		String sql ="select * from `user1`";
		List<User1DTO> users = jdbc.query(sql, new User1RowMapper());
		//쿼리문의 결과처리를 User1RowMapper에서 한다.
		return users;
	}
	
	public void updateUser1(User1DTO dto) {
		String sql ="update `user1` set `name`=?, `hp`=?, `age`=? where `uid`=? ";
		Object []param= {
						dto.getName(),
						dto.getHp(),
						dto.getAge(),
						dto.getUid()
		};
		jdbc.update(sql,param);
	}
	
	public void deleteUser1(String uid) {
		String sql = "delete from `user1` where uid=? ";
		 
		jdbc.update(sql,uid);
				
	}
	
	
}
