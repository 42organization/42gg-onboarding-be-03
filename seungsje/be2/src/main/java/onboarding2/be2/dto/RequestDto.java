package onboarding2.be2.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter @Setter
@NoArgsConstructor
@AllArgsConstructor
public class RequestDto {
    private long postId;
    private String title;
    private String text;
    private String author;
}
