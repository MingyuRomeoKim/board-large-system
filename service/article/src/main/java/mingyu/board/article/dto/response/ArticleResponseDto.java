package mingyu.board.article.dto.response;

import lombok.Getter;
import lombok.ToString;
import mingyu.board.article.entity.Article;

import java.time.LocalDateTime;

@Getter
@ToString
public class ArticleResponseDto {
    private Long articleId;
    private String title;
    private String content;
    private Long boardId;
    private Long writerId;
    private LocalDateTime createdAt;
    private LocalDateTime modifiedAt;

    public static ArticleResponseDto from (Article article) {
        ArticleResponseDto response = new ArticleResponseDto();
        response.articleId = article.getArticleId();
        response.title = article.getTitle();
        response.content = article.getContent();
        response.boardId = article.getBoardId();
        response.writerId = article.getWriterId();
        response.createdAt = article.getCreatedAt();
        response.modifiedAt = article.getModifiedAt();
        return response;
    }
}
