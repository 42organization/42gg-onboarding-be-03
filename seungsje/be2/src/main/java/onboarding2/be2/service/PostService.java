package onboarding2.be2.service;

import onboarding2.be2.dto.*;
import onboarding2.be2.entity.Comment;
import onboarding2.be2.entity.Post;
import onboarding2.be2.entity.SubComment;
import onboarding2.be2.repository.CommentRepository;
import onboarding2.be2.repository.PostRepository;
import onboarding2.be2.repository.SubCommentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PostService {
    private final PostRepository postRepository;

    @Autowired
    public PostService(PostRepository postRepository, CommentRepository commentRepository, SubCommentRepository subCommentRepository) {
        this.postRepository = postRepository;
    }

    public ResponseDto createPost(RequestDto requestDto) {
        Post post = new Post();
        post.setTitle(requestDto.getTitle());
        post.setText(requestDto.getText());
        post.setAuthor(requestDto.getAuthor());
        post.setViews(0);
        post.setLikes(0);
        post = postRepository.save(post);
        return post.toResponseDto();
    }

    public ResponseDto findPost(Long postId) {
        Post post = postRepository.findById(postId).orElse(null);
        if (post != null) {
            post.upviews();
            post = postRepository.save(post);
            return post.toResponseDto();
        } else {
            return null;
        }
    }

    public ResponseDto updatePost(Long postId, RequestDto requestDto) {
        Post post = postRepository.findById(postId).orElse(null);
        if (post != null) {
            post.setTitle(requestDto.getTitle());
            post.setText(requestDto.getText());
            post.setAuthor(requestDto.getAuthor());
            post = postRepository.save(post);
            return post.toResponseDto();
        } else {
            return null;
        }
    }

    public void deletePost(Long postId) {
        postRepository.deleteById(postId);
    }


    public void likePost(Long postId) {
        Post post = postRepository.findById(postId).orElse(null);
        post.upLikes();
        post = postRepository.save(post);
    }

    public void unlikePost(Long postId) {
        Post post = postRepository.findById(postId).orElse(null);
        post.downLikes();
        post = postRepository.save(post);
    }
}
