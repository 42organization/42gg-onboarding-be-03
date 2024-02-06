package com.gg.demo.entity;

import jakarta.persistence.Embeddable;


@Embeddable
public class commonAtt {
    private String author;
    private String content;
    private Long likeCnt;
}
