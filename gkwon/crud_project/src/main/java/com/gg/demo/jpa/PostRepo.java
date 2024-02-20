package com.gg.demo.jpa;

import com.gg.demo.entity.Post;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface PostRepo extends JpaRepository<Post, Long> {
    @Modifying
    @Query(value = "update Post p set p.att.likeCnt = p.att.likeCnt + 1 where p.id = :postId")
    void likeHit(@Param("postId") Long id);
}