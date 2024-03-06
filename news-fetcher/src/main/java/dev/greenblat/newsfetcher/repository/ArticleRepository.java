package dev.greenblat.newsfetcher.repository;

import dev.greenblat.newsfetcher.dto.Article;
import lombok.RequiredArgsConstructor;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@RequiredArgsConstructor
public class ArticleRepository {

    private final RedisTemplate<String, List<Article>> redisTemplate;

    private static final String KEY = "article";

    public void save(List<Article> articles) {
        redisTemplate.opsForValue().set(KEY, articles);
    }

    public List<Article> get() {
        return redisTemplate.opsForValue().get(KEY);
    }
}
