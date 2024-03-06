package dev.greenblat.newsfetcher.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Article implements Serializable {
    private Source source;
    private String author;
    private String title;
    private String description;
    private String url;
}
