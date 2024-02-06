package com.gg.demo.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
public class PostDTO {

    @Getter
    @Setter
    @NoArgsConstructor
    @AllArgsConstructor
    public static class createPostDto
    {
        private String title;
        private String content;
        private String author;
        private final int viewCnt = 0;
        private final int likeCnt = 0;
    }

    @Getter
    @NoArgsConstructor
    @AllArgsConstructor
    public static class readPostDto
    {
        private Long postId;
        private String title;
        private String content;
        private String author;
        private Long viewCnt;
        private Long likeCnt;
    }
}
