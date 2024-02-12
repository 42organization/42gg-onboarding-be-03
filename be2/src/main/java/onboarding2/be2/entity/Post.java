package onboarding2.be2.entity;

import jakarta.persistence.*;
import lombok.*;
import onboarding2.be2.dto.ResponseDto;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity  //  User 객체와 DB 테이블을 매핑
public class Post {
    @Id // 변수 PK
    @GeneratedValue(strategy = GenerationType.IDENTITY) // 값이 없어도 자동으로 할당
    @Column(name = "post_id")
    private Long postId;
    @Column(nullable = false) // 테이블의 컬럼 설정 값을 명시
    private String title;
    @Column(nullable = false)
    private String text;
    @Column(nullable = false)
    private String author;
    @Column(nullable = false)
    private int views;
    @Column(nullable = false)
    private int likes;
    @OneToMany(mappedBy = "post", cascade = CascadeType.ALL)
    private List<Comment> comment = new ArrayList<>();

    public ResponseDto toResponseDto() {
        return new ResponseDto(this.postId, this.title, this.text, this.author, this.views, this.likes);
    }

    public void upLikes() {
        this.likes += 1;
    }

    public void downLikes() {
        if (this.likes > 0)
            this.likes -= 1;
    }

    public void upviews() {
        this.views += 1;
    }

    public void addComment(Comment comment) {
        this.comment.add(comment);
    }

    public List<Comment> getComment() {
        return comment;
    }
}