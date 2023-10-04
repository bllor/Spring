package kr.ch08.entity.board;

import java.time.LocalDateTime;
import java.util.List;

import org.hibernate.annotations.CreationTimestamp;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name="BoardArticle")
public class ArticleEntity {

	
	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	//위의 ge~ 선언은 auto_increment와 같다.
	private int no;
	private String title;
	private String content;
	
	
	//방향성을 고려해서 Article에서 User를 참조해야 Article을 조회할 때 User이 동시에 참조됨.
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="writer")
	private UserEntity  user;
	//writer은 user의 uid로 참조하는데 
	//userEntity의 user로 작성하게 되면 article 엔티티와 user엔티티의 의존관계가 생긴다.
	//다(article) 대 일(user) 관계이므로 manyToOne(fetch = FetchType.LAZY)으로 관계설정을 한다.
	//앞에 나오는 것이 현재 entity이고, to다음의 관계는 연결될 entity
	//JoinColumn(name="writer")은 join할 때 사용되는 user의 이름을 writer로 한다는 선언
	
	
	//방향성을 고려해서 Article에서 Comment를 참조해야 Article을 조회할 때 Comment가 동시에 참조됨.
	//양방향 관계에서 외래키를 갖는 엔티티의 속성을 mappedBy 속성으로 연결 주인을 설정
	//^ 외래키를 가지는 테이블을 정의한 곳에 mappedBy를 해서 주체를 정함
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "article")
	private List<CommentEntity>  comments;
	//oneToMany관계에서는 List로 사용된다.
	//mappedBy = "article"은 join관계에서 누가 주인인지 알려주는 것으로ㅡ
	//연결되는 엔티티에서 사용되는 변수의 이름을 정해준다.
	
	
	//방향성을 고려해서 Article에서 Comment를 참조해야 Article을 조회할 때 Comment가 동시에 참조됨.
	@OneToOne(fetch=FetchType.LAZY, mappedBy = "article")
	private FileEntity file;
	
	//실무에서는 하나의 글에 여러 파일이 올라오지만
	//실습을 할 때는 하나의 글에 하나의 파일만 올라온다고 가정한 후 작업한다.
	//양방향에 대한 연결 주체를 지정해주어야 한다.
	
	
	@CreationTimestamp
	private LocalDateTime rdate;
	//입력되는 날짜를 넣기 위해서 다음과 같이 선언을 하였음
}
