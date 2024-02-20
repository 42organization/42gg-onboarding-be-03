package gg.crud.repository;

import gg.crud.entity.Comment;
import gg.crud.entity.Post;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CommentRepository extends JpaRepository<Comment, Long> {
    List<Comment> findByPost(Post post);    // post 검색 쿼리
}
