package onboarding2.be2.service;

import onboarding2.be2.dto.RequestCommentDto;
import onboarding2.be2.dto.ResponseCommentDto;
import onboarding2.be2.entity.Comment;
import onboarding2.be2.entity.Post;
import onboarding2.be2.repository.CommentRepository;
import onboarding2.be2.repository.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CommentService {
    private final CommentRepository commentRepository;
    private final PostRepository postRepository;

    @Autowired
    public CommentService(CommentRepository commentRepository, PostRepository postRepository) {
        this.commentRepository = commentRepository;
        this.postRepository = postRepository;
    }

    public ResponseCommentDto createComment(Long postId, RequestCommentDto requestCommentDto) {
        Post post = postRepository.findById(postId).orElseThrow(() -> null);
        Comment comment = new Comment();
        comment.setPost(post);
        comment.setText(requestCommentDto.getText());
        comment.setAuthor(requestCommentDto.getAuthor());
        comment.setLikes(0);
        post.addComment(comment);
        comment = commentRepository.save(comment);
        return comment.toResponseCommentDto();
    }

    public ResponseCommentDto getComment(Long commentId) {
        Comment comment = commentRepository.findById(commentId).orElseThrow(() -> null);
        return comment.toResponseCommentDto();
    }

    public ResponseCommentDto updateComment(Long commentId, RequestCommentDto requestCommentDto) {
        Comment comment = commentRepository.findById(commentId).orElseThrow(() -> null);
        if (comment != null) {
            comment.setText(requestCommentDto.getText());
            comment.setAuthor(requestCommentDto.getAuthor());
            comment = commentRepository.save(comment);
            return comment.toResponseCommentDto();
        } else {
            return null;
        }
    }

    public void deleteComment(Long commentId) {
        Comment comment = commentRepository.findById(commentId).orElseThrow(() -> null);
        Post post = comment.getPost();
        post.getComment().remove(comment);
        commentRepository.delete(comment);
    }

    public void likeComment(Long CommentId) {
        Comment comment = commentRepository.findById(CommentId).orElse(null);
        comment.upLikes();
        comment = commentRepository.save(comment);
    }

    public void unlikeComment(Long CommentId) {
        Comment comment = commentRepository.findById(CommentId).orElse(null);
        comment.downLikes();
        comment = commentRepository.save(comment);
    }
}
