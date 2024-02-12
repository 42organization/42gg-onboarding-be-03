package gg.crud.controller;

import gg.crud.dto.CommentRequestDto;
import gg.crud.dto.CommentResponseDto;
import gg.crud.service.CommentService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
public class CommentController {
    private final CommentService commentService;

    // 댓글 등록
    @PostMapping("/posts/{postId}/comments")
    public String createComment(@PathVariable Long postId, @RequestBody CommentRequestDto commentRequestDto, @RequestParam(required = false) Long parentId) {
        return commentService.createComment(postId, commentRequestDto, parentId);
    }

    // 글의 댓글 전체 조회
    @GetMapping("/posts/{postId}/comments")
    public List<CommentResponseDto> getAllComments(@PathVariable Long postId) {
        return commentService.findAllComments(postId);
    }

    // 댓글 삭제
    @DeleteMapping("/comments/{commentId}")
    public String deleteComment(@PathVariable Long commentId) {
        return commentService.deleteComment(commentId);
    }

    // 댓글 수정
    @PutMapping("/comments/{commentId}")
    public Long updateComment(@PathVariable Long commentId, @RequestBody CommentRequestDto commentRequestDto) {
        return commentService.updateComment(commentId, commentRequestDto);
    }
}
