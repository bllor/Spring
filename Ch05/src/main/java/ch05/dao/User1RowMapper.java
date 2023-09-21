package ch05.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import ch05.DTO.User1DTO;

public class User1RowMapper implements RowMapper<User1DTO> {

	@Override
	public User1DTO mapRow(ResultSet rs, int rowNum) throws SQLException {
	//rs에는 쿼리문 실행결과가 들어옴.
	
		User1DTO dto = new User1DTO();
		dto.setUid(rs.getString(1));
		dto.setName(rs.getString(2));
		dto.setHp(rs.getString(3));
		dto.setAge(rs.getInt(4));
		
		return dto;
	}
}
