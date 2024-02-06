package com.gg.demo.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
public class CommentDTO {

    @Getter
    @Setter
    @NoArgsConstructor
    @AllArgsConstructor
    public static class createCommentDto
    {
        private String content;
        private String author;
    }

    @Getter
    @NoArgsConstructor
    @AllArgsConstructor
    public static class readCommentDto
    {
        private Long postId;
        private Long commentId;
        private String content;
        private String author;
        private String likeCnt;
    }
}

//@Query(value = "update BoardEntity b set b.boardHits = b.boardHits + 1 where b.id = :id")
