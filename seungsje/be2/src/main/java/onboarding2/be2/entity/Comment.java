package onboarding2.be2.entity;

import jakarta.persistence.*;
import lombok.*;
import onboarding2.be2.dto.ResponseCommentDto;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity  //  User 객체와 DB 테이블을 매핑
public class Comment {
    @Id // 변수 PK
    @GeneratedValue(strategy = GenerationType.IDENTITY) // 값이 없어도 자동으로 할당
    @Column(name = "comment_id")
    private Long commentId;
    @Column(nullable = false)
    private String author;
    @Column(nullable = false)
    private String text;
    @Column(nullable = false)
    private int likes;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "post_id")
    private Post post;
    @OneToMany(mappedBy = "comment", cascade = CascadeType.ALL)
    private List<SubComment> subComment = new ArrayList<>();

    public ResponseCommentDto toResponseCommentDto() {
        return new ResponseCommentDto(this.commentId, this.author, this.text, this.likes);
    }

    public void upLikes() {
        this.likes += 1;
    }

    public void downLikes() {
        if (this.likes > 0)
            this.likes -= 1;
    }


    public void addSubComment(SubComment subcomment) {
        this.subComment.add(subcomment);
    }

    public List<SubComment> getSubComment() {
        return subComment;
    }
}
