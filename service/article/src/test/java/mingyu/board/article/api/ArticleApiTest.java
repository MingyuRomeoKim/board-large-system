package mingyu.board.article.api;

import lombok.AllArgsConstructor;
import lombok.Getter;
import mingyu.board.article.dto.response.ArticleResponseDto;
import org.junit.jupiter.api.Test;
import org.springframework.web.client.RestClient;

public class ArticleApiTest {
    RestClient restClient = RestClient.create("http://localhost:9000");

    @Test
    void createTest() {
        ArticleResponseDto responseDto = create(new ArticleCreateRequestDto("hi 영재", "my content 영재", 1L, 1L));
        System.out.println("response = " + responseDto);

    }

    ArticleResponseDto create(ArticleCreateRequestDto requestDto) {
        return restClient.post()
                .uri("/api/v1/articles")
                .body(requestDto)
                .retrieve()
                .body(ArticleResponseDto.class);
    }

    @Test
    void readTest() {
        ArticleResponseDto responseDto = read(194344710042345472L);
        System.out.println("response = " + responseDto);
    }

    ArticleResponseDto read(Long articleId) {
        return restClient.get()
                .uri("/api/v1/articles/{articleId}",articleId)
                .retrieve()
                .body(ArticleResponseDto.class);
    }

    @Test
    void updateTest() {
        ArticleUpdateRequestDto requestDto = new ArticleUpdateRequestDto("hi change12", "my content change12");
        ArticleResponseDto responseDto  = update(194323218732843008L, requestDto);
        System.out.println("responseDto = " + responseDto);
    }

    ArticleResponseDto update(Long articleId , ArticleUpdateRequestDto requestDto) {
        return restClient.put()
                .uri("/api/v1/articles/{articleId}",articleId)
                .body(requestDto)
                .retrieve()
                .body(ArticleResponseDto.class);
    }

    @Test
    void deleteTest() {
        restClient.delete()
                .uri("/api/v1/articles/{articleId}",194329359756513280L)
                .retrieve()
                .body(Void.class);
    }

    @Getter
    @AllArgsConstructor
    static class ArticleCreateRequestDto {
        private String title;
        private String content;
        private Long writerId;
        private Long boardId;
    }

    @Getter
    @AllArgsConstructor
    static class ArticleUpdateRequestDto {
        private String title;
        private String content;
    }

}
