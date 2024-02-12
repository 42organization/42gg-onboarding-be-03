package onboarding2.be2.entity;

import jakarta.persistence.*;
import lombok.*;
import onboarding2.be2.dto.ResponseSubCommentDto;
import org.yaml.snakeyaml.tokens.CommentToken;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity  //  User 객체와 DB 테이블을 매핑
public class SubComment {
    @Id // 변수 PK
    @GeneratedValue(strategy = GenerationType.IDENTITY) // 값이 없어도 자동으로 할당
    @Column(name = "sub_comment_id")
    private Long subCommentId;
    @Column(nullable = false)
    private String author;
    @Column(nullable = false)
    private String text;
    @Column(nullable = false)
    private int likes;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "comment_id")
    private Comment comment;

    public ResponseSubCommentDto toResponseSubCommentDto() {
        return new ResponseSubCommentDto(this.subCommentId, this.author, this.text, this.likes);
    }

    public void upLikes() {
        this.likes += 1;
    }

    public void downLikes() {
        if (this.likes > 0)
            this.likes -= 1;
    }
}
