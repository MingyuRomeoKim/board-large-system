package mingyu.board.article.dto.request;

import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
public class ArticleUpdateRequestDto {
    private String title;
    private String content;
}
