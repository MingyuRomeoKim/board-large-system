package mingyu.board.article.service;

import lombok.RequiredArgsConstructor;
import mingyu.board.article.dto.request.ArticleCreateRequestDto;
import mingyu.board.article.dto.request.ArticleUpdateRequestDto;
import mingyu.board.article.dto.response.ArticleResponseDto;
import mingyu.board.article.entity.Article;
import mingyu.board.article.repository.ArticleRepository;
import mingyu.board.common.snowflake.Snowflake;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class ArticleService {
    private final Snowflake snowflake = new Snowflake();
    private final ArticleRepository articleRepository;

    @Transactional
    public ArticleResponseDto create(ArticleCreateRequestDto request) {
        Article article = articleRepository.save(
                Article.create(snowflake.nextId(), request.getTitle(), request.getContent(), request.getBoardId(), request.getWriterId())
        );

        return ArticleResponseDto.from(article);
    }

    @Transactional
    public ArticleResponseDto update(Long articleId, ArticleUpdateRequestDto request) {
        Article article = articleRepository.findById(articleId).orElseThrow();
        article.update(request.getTitle(), request.getContent());
        return ArticleResponseDto.from(article);
    }

    public ArticleResponseDto read(Long articleId) {
        Article article = articleRepository.findById(articleId).orElseThrow();
        return ArticleResponseDto.from(article);
    }

    @Transactional
    public void delete(Long articleId) {
        articleRepository.deleteById(articleId);
    }
}
