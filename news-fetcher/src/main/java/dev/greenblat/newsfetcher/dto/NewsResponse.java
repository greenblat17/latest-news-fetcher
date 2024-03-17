package dev.greenblat.newsfetcher.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class NewsResponse {
    private String httpStatus;
    private Long totalResult;
    private List<Article> articles;
}
