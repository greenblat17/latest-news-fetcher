package dev.greenblat.newsfetcher.service;

import dev.greenblat.newsfetcher.dto.Article;
import dev.greenblat.newsfetcher.dto.NewsResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import java.time.LocalDate;

@Service
@RequiredArgsConstructor
@Slf4j
public class FetcherService {

    @Value("${news.api.url}")
    private String url;

    @Value("${news.api.key}")
    private String apiKey;

    public Article getArticle() {
        log.info("get Article");
        var webClient = WebClient.builder()
                .baseUrl(url)
                .build();

        var newsResponse = webClient.get()
                .uri(
                        "?q={tag}&from={date}&apiKey={key}&language=ru",
                        "news",
                        LocalDate.now().toString(),
                        apiKey
                )
                .accept(MediaType.APPLICATION_JSON)
                .retrieve()
                .bodyToMono(NewsResponse.class)
                .block();

        return newsResponse.getArticles().get(0);
    }
}
