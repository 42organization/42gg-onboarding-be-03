package com.gg.demo.service;

import com.gg.demo.domain.CommentDTO;
import com.gg.demo.entity.Comment;
import com.gg.demo.entity.CommonAtt;
import com.gg.demo.entity.Post;
import com.gg.demo.jpa.CommentRepo;
import com.gg.demo.jpa.PostRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CommentService {
    private final CommentRepo repo;
    private final PostRepo postRepo;

    @Autowired
    public CommentService(CommentRepo repo, PostRepo postRepo) {
        this.repo = repo;
        this.postRepo = postRepo;
    }

    public void createComment(Long postId, CommentDTO.createCommentDto comment) {
        Optional<Post> optionalPost = postRepo.findById(postId);
        if (optionalPost.isPresent()) {
            Post caught = optionalPost.get();
            CommonAtt newAtt = new CommonAtt("test_author", comment.getContent(), 0L);
            Comment newEntity = new Comment(newAtt);
            newEntity.setPost(caught);
            repo.save(newEntity);
        }
    }

    public CommentDTO.createCommentDto updateComment(Long id, CommentDTO.createCommentDto update) {
        Optional<Comment> optionalEComment = repo.findById(id);
        if (optionalEComment.isPresent()) {
            Comment existingComment = optionalEComment.get();
            existingComment.getAtt().setContent(update.getContent());
            repo.save(existingComment);
            return new CommentDTO.createCommentDto(update.getContent(), existingComment.getAtt().getAuthor());
        }
        return null; // or throw an exception
    }

    public void deleteComment(Long id) {
        repo.deleteById(id);
    }
}
