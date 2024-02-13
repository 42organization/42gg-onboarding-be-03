package com.gg.demo.controller;

import com.gg.demo.domain.CommentDTO;
import com.gg.demo.jpa.CommentRepo;
import com.gg.demo.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/{postId}/comments")
public class CommentRestController {

    private final CommentService commentService;

    private final CommentRepo repo;

    @Autowired
    public CommentRestController(CommentService service, CommentRepo repo) {
        this.commentService = service;
        this.repo = repo;
    }

    // Create a Comment
    @PostMapping("/create")
    public void createComment(@PathVariable("postId") Long postId, @RequestBody CommentDTO.createCommentDto commentDto) {
        commentService.createComment(postId, commentDto);
    }

    // like up
    @Transactional
    @PostMapping("/{commentId}/likeUp")
    public void likeUp(@PathVariable("commentId") Long commentId) {
        repo.likeHit(commentId);
    }

    // Update Comment by ID
    @PutMapping("/{commentId}")
    public void updateComment(@PathVariable("commentId") Long CommentId, @RequestBody CommentDTO.createCommentDto updatedComment) {
        commentService.updateComment(CommentId, updatedComment);
    }

    // Delete Comment by ID
    @DeleteMapping("/{commentId}")
    public void deleteComment(@PathVariable("commentId") Long CommentId) {
        commentService.deleteComment(CommentId);
    }
}
