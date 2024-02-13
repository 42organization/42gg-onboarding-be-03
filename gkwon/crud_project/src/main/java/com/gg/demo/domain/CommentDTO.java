package com.gg.demo.domain;

import com.gg.demo.entity.SubComment;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

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
        private Long likeCnt;
        private List<SubComment> subComments;
    }
}

//@Query(value = "update BoardEntity b set b.boardHits = b.boardHits + 1 where b.id = :id")
