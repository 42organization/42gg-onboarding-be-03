package com.gg.demo.service;

import com.gg.demo.domain.PostDTO;
import com.gg.demo.entity.CommonAtt;
import com.gg.demo.entity.Post;
import com.gg.demo.jpa.PostRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class PostService {
    private final PostRepo repo;

    @Autowired
    public PostService(PostRepo repo) {
        this.repo = repo;
    }

    public void createPost(PostDTO.createPostDto post) {
        CommonAtt newAtt = new CommonAtt("test_author", post.getContent(), 0L);
        Post newEntity = new Post(post.getTitle(), newAtt);
        repo.save(newEntity);
    }

    public PostDTO.readPostDto getPost(Long id) {
        Optional<Post> optionalEPost = repo.findById(id);
        if (optionalEPost.isPresent()) {
            Post post = optionalEPost.get();
            return new PostDTO.readPostDto(
                    id, // 게시물 ID
                    post.getTitle(), // 게시물 제목
                    post.getAtt().getContent(), // 게시물 내용
                    post.getAtt().getAuthor(), // 게시물 작성자
                    post.getAtt().getLikeCnt(), // 게시물 좋아요 수
                    post.getComments() // 게시물의 댓글 목록
            );
        } else {
            // 주어진 ID에 해당하는 게시물이 없는 경우 null 반환
            return null;
        }
    }

    public List<PostDTO.getAllPostDto> getAllPosts() {
        List<Post> postList = repo.findAll();
        List<PostDTO.getAllPostDto> dtoList = new ArrayList<>();

        for (Post post : postList) {
            PostDTO.getAllPostDto dto = new PostDTO.getAllPostDto(
                    post.getId(),
                    post.getTitle(),
                    post.getAtt().getAuthor(),
                    post.getAtt().getLikeCnt());
            dtoList.add(dto);
        }
        return dtoList;
    }

    public PostDTO.createPostDto updatePost(Long id, PostDTO.createPostDto update) {
        Optional<Post> optionalEPost = repo.findById(id);
        if (optionalEPost.isPresent()) {
            Post existingPost = optionalEPost.get();
            existingPost.setTitle(update.getTitle());
            existingPost.getAtt().setContent(update.getContent());
            repo.save(existingPost);
            return new PostDTO.createPostDto(
                    update.getTitle(),
                    update.getContent(),
                    existingPost.getAtt().getAuthor());
        }
        return null; // or throw an exception
    }

    public void deletePost(Long id) {
        repo.deleteById(id);
    }
}
