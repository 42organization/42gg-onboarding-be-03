package com.gg.demo.domain;

import com.gg.demo.entity.Comment;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

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
        private Long likeCnt;
        private List<Comment> comments;
    }

    @Getter
    @NoArgsConstructor
    @AllArgsConstructor
    public static class getAllPostDto
    {
        private Long postId;
        private String title;
        private String author;
        private Long likeCnt;
    }
}
