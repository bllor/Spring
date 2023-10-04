package kr.ch08.repository.board;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import kr.ch08.entity.board.CommentEntity;

@Repository
public interface CommentRepository  extends JpaRepository<CommentEntity, Integer> {
//Integer 자리에는 사용하려는 Entity의 id의 타입과 같은 것으로 한다.
//articleEntity의 id의 타입은 Integer이므로 Integer를 선언
	
	
}
