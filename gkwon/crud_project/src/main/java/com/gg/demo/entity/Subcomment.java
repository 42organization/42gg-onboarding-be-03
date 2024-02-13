package com.gg.demo.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "Subcomment")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor(access = AccessLevel.PROTECTED)
public class SubComment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long subCommentId;

    @Embedded
    private CommonAtt att;

    @JsonIgnore
    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL, optional = true)
    @JoinColumn(name = "commentId") // 외부 키의 컬럼 이름 지정
    private Comment comment;

    public SubComment(CommonAtt newAtt) {
        this.att = newAtt;
    }
}
