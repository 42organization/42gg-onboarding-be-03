package com.gg.demo.service;

import com.gg.demo.domain.SubCommentDTO;
import com.gg.demo.entity.Comment;
import com.gg.demo.entity.CommonAtt;
import com.gg.demo.entity.SubComment;
import com.gg.demo.jpa.CommentRepo;
import com.gg.demo.jpa.SubCommentRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class SubCommentService {
    private final SubCommentRepo repo;
    private final CommentRepo commentRepo;

    @Autowired
    public SubCommentService(SubCommentRepo repo, CommentRepo commentRepo) {
        this.commentRepo = commentRepo;
        this.repo = repo;
    }

    public void createSubComment(Long commentId, SubCommentDTO.createSubCommentDto SubComment) {
        Optional<Comment> optionalComment = commentRepo.findById(commentId);
        if (optionalComment.isPresent()) {
            Comment caught = optionalComment.get();
            caught.setCommentId(commentId);
            CommonAtt newAtt = new CommonAtt("test_author", SubComment.getContent(), 0L);
            SubComment newEntity = new SubComment(newAtt);
            newEntity.setComment(caught);
            repo.save(newEntity);
        }
    }

    public SubCommentDTO.createSubCommentDto updateSubComment(Long id, SubCommentDTO.createSubCommentDto update) {
        Optional<SubComment> optionalESubComment = repo.findById(id);
        if (optionalESubComment.isPresent()) {
            SubComment existingSubComment = optionalESubComment.get();
            existingSubComment.getAtt().setContent(update.getContent());
            repo.save(existingSubComment);
            return new SubCommentDTO.createSubCommentDto(update.getContent(), existingSubComment.getAtt().getAuthor());
        }
        return null; // or throw an exception
    }

    public void deleteSubComment(Long id) {
        repo.deleteById(id);
    }
}
