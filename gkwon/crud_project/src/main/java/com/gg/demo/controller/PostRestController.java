package com.gg.demo.controller;

import com.gg.demo.domain.PostDTO;
import com.gg.demo.jpa.PostRepo;
import com.gg.demo.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/posts")
public class PostRestController {

    private final PostService postService;
    private final PostRepo repo;

    @Autowired
    public PostRestController(PostService service, PostRepo repo) {
        this.postService = service;
        this.repo = repo;
    }

    // Get all posts
    @GetMapping
    public List<PostDTO.getAllPostDto> getAllPosts() {
        return postService.getAllPosts();
    }

    // Create a post
    @PostMapping("/create")
    public void createPost(@RequestBody PostDTO.createPostDto postDto) {
        postService.createPost(postDto);
    }

    // like up
    @Transactional
    @PostMapping("/{postId}/likeUp")
    public void likeUp(@PathVariable("postId") Long postId) {
        repo.likeHit(postId);
    }

    // Get post by ID
    @GetMapping("/{postId}")
    public PostDTO.readPostDto getPostDetail(@PathVariable("postId") Long postId) {
        return postService.getPost(postId);
    }

    // Update post by ID
    @PutMapping("/{postId}")
    public void updatePost(@PathVariable("postId") Long postId, @RequestBody PostDTO.createPostDto updatedPost) {
        postService.updatePost(postId, updatedPost);
    }

    // Delete post by ID
    @DeleteMapping("/{postId}")
    public void deletePost(@PathVariable("postId") Long postId) {
        postService.deletePost(postId);
    }
}
