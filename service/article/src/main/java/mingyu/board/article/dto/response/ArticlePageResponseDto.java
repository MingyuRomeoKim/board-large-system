package mingyu.board.article.dto.response;

import lombok.Getter;
import lombok.ToString;
import mingyu.board.article.entity.Article;

import java.util.List;

@Getter
@ToString
public class ArticlePageResponseDto {
    private List<ArticleResponseDto> articles;
    private Long articleCount;

    public static ArticlePageResponseDto from(List<ArticleResponseDto> articles, Long articleCount) {
        ArticlePageResponseDto articlePageResponseDto = new ArticlePageResponseDto();
        articlePageResponseDto.articles = articles;
        articlePageResponseDto.articleCount = articleCount;
        return articlePageResponseDto;
    }
}
