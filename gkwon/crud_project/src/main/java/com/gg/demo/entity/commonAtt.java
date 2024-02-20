package com.gg.demo.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Embeddable
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CommonAtt {
    @Column(length = 15, nullable = false)
    private String author;
    @Column(length = 100, nullable = false)
    private String content;
    @Column(nullable = false)
    private Long likeCnt;
}
