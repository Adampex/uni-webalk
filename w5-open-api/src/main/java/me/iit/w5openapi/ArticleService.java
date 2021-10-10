package me.iit.w5openapi;

import java.util.List;

public interface ArticleService {
    List<ArticleDto> findAll();
    ArticleDto getById(Long id);
    Long save(ArticleDto articleDto);
    void deleteById(Long id);
}