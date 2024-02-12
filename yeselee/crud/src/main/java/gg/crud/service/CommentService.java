package gg.crud.service;

import gg.crud.dto.CommentRequestDto;
import gg.crud.dto.CommentResponseDto;
import gg.crud.entity.Comment;
import gg.crud.entity.Post;
import gg.crud.repository.CommentRepository;
import gg.crud.repository.PostRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
@RequiredArgsConstructor
public class CommentService {
    private final CommentRepository commentRepository;
    private final PostRepository postRepository;

    // 댓글 등록
    public String createComment(Long id, CommentRequestDto commentRequestDto) {
        try {
            Post post = postRepository.findById(id).orElseThrow(()
                    -> new IllegalArgumentException("해당 글이 존재하지 않습니다."));
            Comment comment = Comment.builder()
                    .body(commentRequestDto.getBody())
                    .author(commentRequestDto.getAuthor())
                    .post(post)
                    .build();

            commentRepository.save(comment);

            return comment.getId().toString();
        } catch(IllegalArgumentException e) {
            return e.getMessage();
        }
    }

    // 글 하나의 댓글 전체 조회
    public List<CommentResponseDto> findAllComments(Long id) {
            Post post = postRepository.findById(id).orElseThrow(()
                    -> new IllegalArgumentException("해당 글이 존재하지 않습니다."));
            List<Comment> commentList = commentRepository.findByPost(post);

            return commentList.stream()
                    .map(comment -> CommentResponseDto.builder()
                            .id(comment.getId())
                            .body(comment.getBody())
                            .author(comment.getAuthor())
                            .build())
                    .toList();
    }

    // 댓글 삭제
    public String deleteComment(Long id) {
        commentRepository.deleteById(id);

        return "comment deleted";
    }

    // 댓글 수정
    public Long updateComment(Long id, CommentRequestDto commentRequestDto) {
        Comment comment = commentRepository.findById(id).orElseThrow(()
                -> new IllegalArgumentException("해당 댓글이 존재하지 않습니다."));
        comment.update(commentRequestDto.getBody());
        commentRepository.save(comment);

        return comment.getId();
    }
}
