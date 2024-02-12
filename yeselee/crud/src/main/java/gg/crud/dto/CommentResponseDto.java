package gg.crud.dto;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class CommentResponseDto {
    private Long id;
    private String body;
    private String author;
}
