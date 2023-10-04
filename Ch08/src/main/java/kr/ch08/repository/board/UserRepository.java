package kr.ch08.repository.board;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import kr.ch08.entity.board.UserEntity;

@Repository
public interface UserRepository  extends JpaRepository<UserEntity, String> {
//String 자리에는 사용하려는 Entity의 id의 타입과 같은 것으로 한다.
//UserEntity의 id의 타입은 String이므로 String를 선언
	
	
}
