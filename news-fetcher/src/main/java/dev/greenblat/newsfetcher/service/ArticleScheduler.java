package dev.greenblat.newsfetcher.service;

import dev.greenblat.newsfetcher.repository.ArticleRepository;
import dev.greenblat.newsfetcher.dto.NewsResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.MediaType;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.WebClient;

import java.time.LocalDate;

@Component
@RequiredArgsConstructor
public class ArticleScheduler {

    private final ArticleRepository articleRepository;


    @Value("${news.api.url}")
    private String url;

    @Value("${news.api.key}")
    private String apiKey;

    @Scheduled(fixedRate = 10000)
    public void loadArticles() {
        var webClient = WebClient.builder()
                .baseUrl(url)
                .build();

        var newsResponse = webClient.get()
                .uri(
                        "?q={tag}&from={date}&apiKey={key}&language=ru",
                        getTagForQuery(),
                        LocalDate.now().toString(),
                        apiKey
                )
                .accept(MediaType.APPLICATION_JSON)
                .retrieve()
                .bodyToMono(NewsResponse.class)
                .block();

        var articles = newsResponse.getArticles();
        articleRepository.save(articles);
    }

    private String getTagForQuery() {
        return "news";
    }
}
