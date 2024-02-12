package onboarding2.be2.service;

import onboarding2.be2.dto.RequestCommentDto;
import onboarding2.be2.dto.RequestSubCommentDto;
import onboarding2.be2.dto.ResponseCommentDto;
import onboarding2.be2.dto.ResponseSubCommentDto;
import onboarding2.be2.entity.Comment;
import onboarding2.be2.entity.Post;
import onboarding2.be2.entity.SubComment;
import onboarding2.be2.repository.CommentRepository;
import onboarding2.be2.repository.SubCommentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SubCommentService {
    private final CommentRepository commentRepository;
    private final SubCommentRepository subCommentRepository;

    @Autowired
    public SubCommentService(CommentRepository commentRepository, SubCommentRepository subCommentRepository) {
        this.commentRepository = commentRepository;
        this.subCommentRepository = subCommentRepository;
    }

    public ResponseSubCommentDto createSubComment(Long commentId, RequestSubCommentDto requestSubCommentDto) {
        Comment comment = commentRepository.findById(commentId).orElseThrow(() -> null);
        SubComment subComment = new SubComment();
        subComment.setComment(comment);
        subComment.setText(requestSubCommentDto.getText());
        subComment.setAuthor(requestSubCommentDto.getAuthor());
        subComment.setLikes(0);
        comment.addSubComment(subComment);
        subComment = subCommentRepository.save(subComment);
        return subComment.toResponseSubCommentDto();
    }

    public ResponseSubCommentDto getSubComment(Long subCommentId) {
        SubComment subComment = subCommentRepository.findById(subCommentId).orElseThrow(() -> null);
        return subComment.toResponseSubCommentDto();
    }

    public ResponseSubCommentDto updateSubComment(Long subCommentId, RequestSubCommentDto requestSubCommentDto) {
        SubComment subComment = subCommentRepository.findById(subCommentId).orElseThrow(() -> null);
        if (subComment != null) {
            subComment.setText(requestSubCommentDto.getText());
            subComment.setAuthor(requestSubCommentDto.getAuthor());
            subComment = subCommentRepository.save(subComment);
            return subComment.toResponseSubCommentDto();
        } else {
            return null;
        }
    }

    public void deleteSubComment(Long subCommentId) {
        SubComment subComment = subCommentRepository.findById(subCommentId).orElseThrow(() -> null);
        Comment comment = subComment.getComment();
        comment.getSubComment().remove(subComment);
        subCommentRepository.delete(subComment);
    }

    public void likeSubComment(Long SubCommentId) {
        SubComment subComment = subCommentRepository.findById(SubCommentId).orElse(null);
        subComment.upLikes();
        subComment = subCommentRepository.save(subComment);
    }

    public void unlikeSubComment(Long SubCommentId) {
        SubComment subComment = subCommentRepository.findById(SubCommentId).orElse(null);
        subComment.downLikes();
        subComment = subCommentRepository.save(subComment);
    }
}x`x`