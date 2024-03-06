package dev.greenblat.newsfetcher;

import dev.greenblat.newsfetcher.dto.Article;
import dev.greenblat.newsfetcher.service.FetcherService;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@SpringBootApplication
@EnableScheduling
@EnableCaching
@RestController
@RequiredArgsConstructor
public class NewsFetcherApplication {

    private final FetcherService fetcherService;

    public static void main(String[] args) {
        SpringApplication.run(NewsFetcherApplication.class, args);
    }

    @GetMapping("/fetch")
    public List<Article> fetch() {
        return fetcherService.getArticle();
    }

}
