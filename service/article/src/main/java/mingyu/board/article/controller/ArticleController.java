package mingyu.board.article.controller;

import lombok.RequiredArgsConstructor;
import mingyu.board.article.dto.request.ArticleCreateRequestDto;
import mingyu.board.article.dto.request.ArticleUpdateRequestDto;
import mingyu.board.article.dto.response.ArticleResponseDto;
import mingyu.board.article.service.ArticleService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/articles")
public class ArticleController {

    private final ArticleService articleService;

    @GetMapping("/{articleId}")
    public ArticleResponseDto read(@PathVariable Long articleId) {
        return articleService.read(articleId);
    }

    @PostMapping
    public ArticleResponseDto create(@RequestBody ArticleCreateRequestDto articleCreateRequest) {
        return articleService.create(articleCreateRequest);
    }

    @PutMapping("/{articleId}")
    public ArticleResponseDto update(@PathVariable Long articleId, @RequestBody ArticleUpdateRequestDto articleUpdateRequest) {
        return articleService.update(articleId, articleUpdateRequest);
    }

    @DeleteMapping("/{articleId}")
    public void delete(@PathVariable Long articleId) {
        articleService.delete(articleId);
    }
}
