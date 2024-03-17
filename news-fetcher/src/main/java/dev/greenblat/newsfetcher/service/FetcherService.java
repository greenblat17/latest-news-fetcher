package dev.greenblat.newsfetcher.service;

import dev.greenblat.newsfetcher.repository.ArticleRepository;
import dev.greenblat.newsfetcher.dto.Article;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class FetcherService {

    private final ArticleRepository articleRepository;

    public List<Article> getArticle() {
        log.info("get Article");
        return articleRepository.get();
    }

}
