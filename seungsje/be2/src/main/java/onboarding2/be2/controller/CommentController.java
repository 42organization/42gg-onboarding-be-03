package onboarding2.be2.controller;

import onboarding2.be2.dto.RequestCommentDto;
import onboarding2.be2.dto.RequestDto;
import onboarding2.be2.dto.ResponseCommentDto;
import onboarding2.be2.dto.ResponseDto;
import onboarding2.be2.entity.Comment;
import onboarding2.be2.service.CommentService;
import onboarding2.be2.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/posts/{postId}/comment")
public class CommentController {
    private final CommentService commentService;

    @Autowired
    public CommentController(CommentService commentService) {
        this.commentService = commentService;
    }

    @PostMapping
    public ResponseCommentDto createComment(@PathVariable("postId") Long postId, @RequestBody RequestCommentDto requestCommentDto){
        return commentService.createComment(postId, requestCommentDto);
    }

    @GetMapping("/{commentId}")
    public ResponseCommentDto findComment(@PathVariable("commentId") Long commentId){
        return commentService.getComment(commentId);
    }

    @PutMapping("/{commentId}")
    public ResponseCommentDto updateComment(@PathVariable("commentId") Long commentId, @RequestBody RequestCommentDto requestCommentDto){
        return commentService.updateComment(commentId, requestCommentDto);
    }

    @DeleteMapping("/{commentId}")
    public void deleteComment(@PathVariable("commentId") Long commentId){
        commentService.deleteComment(commentId);
    }

    @PostMapping("/{commentId}/likes")
    public void likeComment(@PathVariable("commentId") Long commentId){
        commentService.likeComment(commentId);
    }

    @DeleteMapping("/{commentId}/likes")
    public void unlikeComment(@PathVariable("commentId") Long commentId){
        commentService.unlikeComment(commentId);
    }
}