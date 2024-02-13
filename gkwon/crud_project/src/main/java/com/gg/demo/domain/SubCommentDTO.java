package com.gg.demo.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
public class SubCommentDTO {

    @Getter
    @Setter
    @NoArgsConstructor
    @AllArgsConstructor
    public static class createSubCommentDto
    {
        private String content;
        private String author;
    }

    @Getter
    @NoArgsConstructor
    @AllArgsConstructor
    public static class readSubCommentDto
    {
        private Long id;
        private String content;
        private String author;
        private String likeCnt;
    }
}
