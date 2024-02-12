package gg.crud.entity;

import jakarta.persistence.*;
import lombok.*;

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
    @JoinColumn(name = "post_id")
    private Post post;

    public void update(String body) {
        this.body = body;
    }
}
