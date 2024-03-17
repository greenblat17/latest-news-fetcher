package dev.greenblat.newsfetcher.controller;

import dev.greenblat.newsfetcher.dto.Article;
import dev.greenblat.newsfetcher.service.FetcherService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1/articles")
@RequiredArgsConstructor
public class ArticleController {

    private final FetcherService fetcherService;

    @GetMapping("/fetch")
    public List<Article> fetch() {
        return fetcherService.getArticle();
    }

}
