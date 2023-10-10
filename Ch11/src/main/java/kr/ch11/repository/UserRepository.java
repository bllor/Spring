package kr.ch11.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import kr.ch11.entity.UserEntity;

@Repository
public interface UserRepository extends JpaRepository<UserEntity, String> {

	//id password를 조회하는 메서드
	//메서드의 이름은 사용자가 지정할 수 없고 규칙이 있다.
	public UserEntity findUserEntityByUidAndPass(String uid, String pass);
}
