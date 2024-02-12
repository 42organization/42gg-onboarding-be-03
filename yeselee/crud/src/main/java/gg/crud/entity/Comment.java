package gg.crud.entity;

import gg.crud.service.CommentService;
import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
@Builder
@Table(name="comment")
@NoArgsConstructor
@AllArgsConstructor
public class Comment {
    // 댓글 id, 내용, 관련 글 내용
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String body;

    @Column(nullable = false)
    private String author;

    @ManyToOne
    @JoinColumn(name = "parent_id")
    private Comment parentComment;  // 상위 댓글

    @OneToMany(mappedBy = "parentComment", orphanRemoval = true)
    private List<Comment> childComment = new ArrayList<>(); // 하위 대댓글

    @ManyToOne
    @JoinColumn(name = "post_id")
    private Post post;

    public void update(String body) {
        this.body = body;
    }
}
