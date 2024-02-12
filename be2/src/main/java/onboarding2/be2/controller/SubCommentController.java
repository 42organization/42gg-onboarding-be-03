package onboarding2.be2.controller;

import onboarding2.be2.dto.*;
import onboarding2.be2.entity.Comment;
import onboarding2.be2.repository.SubCommentRepository;
import onboarding2.be2.service.CommentService;
import onboarding2.be2.service.PostService;
import onboarding2.be2.service.SubCommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/posts/{postId}/comment/{commentId}")
public class SubCommentController {
    private final SubCommentService subCommentService;

    @Autowired
    public SubCommentController(SubCommentService subCommentService) {
        this.subCommentService = subCommentService;
    }

    @PostMapping
    public ResponseSubCommentDto createComment(@PathVariable("commentId") Long commentId, @RequestBody RequestSubCommentDto requestSubCommentDto){
        return subCommentService.createSubComment(commentId, requestSubCommentDto);
    }

    @GetMapping("/{subCommentId}")
    public ResponseSubCommentDto findComment(@PathVariable("subCommentId") Long subCommentId){
        return subCommentService.getSubComment(subCommentId);
    }

    @PutMapping("/{subCommentId}")
    public ResponseSubCommentDto updateComment(@PathVariable("subCommentId") Long subCommentId, @RequestBody RequestSubCommentDto requestSubCommentDto){
        return subCommentService.updateSubComment(subCommentId, requestSubCommentDto);
    }

    @DeleteMapping("/{subCommentId}")
    public void deleteComment(@PathVariable("subCommentId") Long subCommentId){
        subCommentService.deleteSubComment(subCommentId);
    }

    @PostMapping("/{subCommentId}/likes")
    public void likeComment(@PathVariable("subCommentId") Long subCommentId){
        subCommentService.likeSubComment(subCommentId);
    }

    @DeleteMapping("/{subCommentId}/likes")
    public void unlikeComment(@PathVariable("subCommentId") Long subCommentId){
        subCommentService.unlikeSubComment(subCommentId);
    }
}