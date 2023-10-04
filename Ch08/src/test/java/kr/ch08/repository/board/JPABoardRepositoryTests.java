package kr.ch08.repository.board;

import java.util.Iterator;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import jakarta.transaction.Transactional;
import kr.ch08.entity.board.ArticleEntity;
import kr.ch08.entity.board.CommentEntity;
import kr.ch08.entity.board.FileEntity;
import kr.ch08.entity.board.UserEntity;

@SpringBootTest
public class JPABoardRepositoryTests {

	
	@Autowired private ArticleRepository articleRepo;
	@Autowired private CommentRepository commentRepo;
	@Autowired private FileRepository fileRepo;
	@Autowired private UserRepository userRepo;
	
	
	
	@DisplayName("insertUser 테스트")
	//displayName은 console 창에 나타날 이름을 지정하는 것이다.
	public void insertUser() {
		
		UserEntity user = UserEntity.builder()
									.uid("a103")
									.name("김춘하")
									.hp("010-2222-1111")
									.build();
		
		userRepo.save(user);
		
	}
	
	
	@DisplayName("insertArticle 테스트")
	public void insertArticle() {
		
		UserEntity user = UserEntity.builder().uid("a103").build();
		//user에 없는 uid를 넣게되면 에러가 발생한다.
		
		
		ArticleEntity article = ArticleEntity.builder()
											.title("제목4")
											.content("내용4")
											.user(user)
											.build();
		//user를 넣지 않고 실행을 하면 writer에 null로 들어간다.
		
		
		
		articleRepo.save(article);
		
	}

	@DisplayName("insertComment 테스트")
	public void insertComment() {
		
		UserEntity user = UserEntity.builder().uid("a101").build();
		//user에 없는 uid를 넣게되면 에러가 발생한다.
		
		
		ArticleEntity article = ArticleEntity.builder()
											.no(2)
											.build();
		
		CommentEntity comment = CommentEntity.builder()
											.content("댓글 3")
											.user(user)
											.article(article)
											.build();
		
		commentRepo.save(comment);
											
	}
	
	
	
	@DisplayName("insertFile 테스트")
	public void insertFile() {
		
		ArticleEntity article = ArticleEntity.builder().no(4).build();
		FileEntity file = FileEntity.builder()
									.oName("테스트2.txt")
									.sName("adsfsdafdasfes.txt")
									.article(article)
									.build();
									
		fileRepo.save(file);
	}
	
	
	@DisplayName("selectArticles 테스트")
	public void selectArticles() {
		
		List<ArticleEntity> articles = articleRepo.findAll();//findAll==select * from 과 같다.
		//System.out.println(articles);
			
		
		for(ArticleEntity article : articles) {
			System.out.println(article);
		}
		
		
	}
	
	@Test
	@Transactional
	/*
	 * 양방향으로 처리되는 엔티티관계에서 다수의 select를 수행하기 때문에
	 * 단일 select 처리 후 종료되는 특징으로 접속이 종료됨(no session)
	 * 따라서 그 다음 select 실행에서 no session 에러 발생
	 * 이럴 경우 @Transactional 선언으로 트랜잭션 처리를 해줘야함
	 * 
	 * -----
	 * could not initialize proxy <- 참조할 수 없을 때 발생함(데이터 값이 없다는 뜻)
	 */
	
	@DisplayName("selectArticle 테스트")
	public void selectArticle() {
		
		Optional<ArticleEntity> result = articleRepo.findById(4);
		//nullpointException을 방지하기 위해서 optional을 사용한다.
		ArticleEntity article = result.orElseThrow();
		System.out.println(article);
		
	}
	
}
/*
no Session에러가 나는 이유는 
jpa에 스프링jdbc를 이용하는데 select를 한 번 할 때마다 접속했다가 close를 하는데 close를 한 다음 열지 못하니까 에러가남
그래서 단일 작업으로 만들어주어야 함.
@transactional 어노테이션을 붙여준다.
*/
