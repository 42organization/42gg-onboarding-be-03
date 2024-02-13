package com.gg.demo.jpa;

import com.gg.demo.entity.Comment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface CommentRepo extends JpaRepository<Comment, Long> {
    @Modifying
    @Query(value = "update Comment c set c.att.likeCnt = c.att.likeCnt + 1 where c.commentId = : commentId")
    void likeHit(@Param("commentId") Long commentId);
}