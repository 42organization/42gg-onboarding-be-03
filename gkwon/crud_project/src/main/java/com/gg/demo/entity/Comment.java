package com.gg.demo.entity;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "CRUD")
@Getter
@Setter
@AllArgsConstructor(access = AccessLevel.PROTECTED)
public class Comment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long commentId;

    @Embedded
    private commonAtt att;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "postId") // 외부 키의 컬럼 이름 지정
    private Post post;
    public Post(String title, String content)
    {
        this.title = title;
        this.content = content;
    }

    public Post() {

    }
}
