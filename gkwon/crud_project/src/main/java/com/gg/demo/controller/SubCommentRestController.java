package com.gg.demo.controller;

import com.gg.demo.domain.SubCommentDTO;
import com.gg.demo.jpa.SubCommentRepo;
import com.gg.demo.service.SubCommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/{postId}/{commentId}/subComments")
public class SubCommentRestController {

    private final SubCommentService SubCommentService;
    private final SubCommentRepo repo;

    @Autowired
    public SubCommentRestController(SubCommentService service, SubCommentRepo repo) {
        this.SubCommentService = service;
        this.repo = repo;
    }

    // Create a SubComment
    @PostMapping("/create")
    public void createSubComment(@PathVariable("commentId") Long commentId, @RequestBody SubCommentDTO.createSubCommentDto subCommentDto) {
        SubCommentService.createSubComment(commentId, subCommentDto);
    }

    // Update SubComment by ID
    @PutMapping("/{subCommentId}")
    public void updateSubComment(@PathVariable("subCommentId") Long SubCommentId, @RequestBody SubCommentDTO.createSubCommentDto updatedSubComment) {
        SubCommentService.updateSubComment(SubCommentId, updatedSubComment);
    }

    // like up
    @Transactional
    @PostMapping("/{subCommentId}/likeUp")
    public void likeUp(@PathVariable("subCommentId") Long subCommentId) {
        repo.likeHit(subCommentId);
    }

    // Delete SubComment by ID
    @DeleteMapping("/{subCommentId}")
    public void deleteSubComment(@PathVariable("subCommentId") Long SubCommentId) {
        SubCommentService.deleteSubComment(SubCommentId);
    }
}
