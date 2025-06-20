package mingyu.board.article.dto.request;

import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
public class ArticleCreateRequestDto {
    private String title;
    private String content;
    private Long writerId;
    private Long boardId;
}
