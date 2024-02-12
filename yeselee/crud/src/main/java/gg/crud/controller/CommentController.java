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
    @PostMapping("/posts/{id}/comment")
    public String createComment(@PathVariable Long id, @RequestBody CommentRequestDto commentRequestDto) {
        return commentService.createComment(id, commentRequestDto);
    }

    // 글의 댓글 전체 조회
    @GetMapping("/posts/{id}/comment")
    public List<CommentResponseDto> getAllComments(@PathVariable Long id) {
        return commentService.findAllComments(id);
    }

    // 댓글 삭제
    @DeleteMapping("/comments/{id}")
    public String deleteComment(@PathVariable Long id) {
        return commentService.deleteComment(id);
    }

    // 댓글 수정
    @PutMapping("/comments/{id}")
    public Long updateComment(@PathVariable Long id, @RequestBody CommentRequestDto commentRequestDto) {
        return commentService.updateComment(id, commentRequestDto);
    }
}
