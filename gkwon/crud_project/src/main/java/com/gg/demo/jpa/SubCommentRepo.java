package com.gg.demo.jpa;

import com.gg.demo.entity.SubComment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface SubCommentRepo extends JpaRepository<SubComment, Long> {
    @Modifying
    @Query(value = "update SubComment s set s.att.likeCnt = s.att.likeCnt + 1 where s.subCommentId = :subcommentId")
    void likeHit(@Param("subcommentId") Long subcommentId);
}