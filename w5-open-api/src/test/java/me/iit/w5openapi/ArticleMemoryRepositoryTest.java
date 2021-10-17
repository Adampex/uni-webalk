package me.iit.w5openapi;

import java.util.List;

import static org.junit.Assert.*;

public class ArticleMemoryRepositoryTest {

    @org.junit.Test
    public void findAll_Entry() {
        // GIVEN
        ArticleMemoryRepository articleMemoryRepository = new ArticleMemoryRepository();

        // WHEN
        List<ArticleDto> result = articleMemoryRepository.findAll();

        // THEN
        assertEquals(0, result.size());
    }

    @org.junit.Test
    public void findAll_NotEmpty() {
        // GIVEN
        ArticleMemoryRepository articleMemoryRepository = new ArticleMemoryRepository();
        ArticleDto articleDto = new ArticleDto();
        articleDto.setAuthor("Author");
        articleDto.setPages(23);
        articleDto.setId(2L);
        articleDto.setTitle("title");

        articleMemoryRepository.save(articleDto);

        // WHEN
        List<ArticleDto> result = articleMemoryRepository.findAll();

        // THEN
        assertEquals(1, result.size());
        assertEquals(articleDto, result.get(0));
    }

    @org.junit.Test
    public void findArticleById() {
        // GIVEN
        ArticleMemoryRepository articleMemoryRepository = new ArticleMemoryRepository();
        Long id = 2L;
        ArticleDto articleDto = new ArticleDto();
        articleDto.setAuthor("Author");
        articleDto.setPages(23);
        articleDto.setId(id);
        articleDto.setTitle("title");

        articleMemoryRepository.save(articleDto);

        // WHEN
        int result = articleMemoryRepository.findArticleById(id);

        // THEN
        assertEquals(0, result);
    }

    @org.junit.Test
    public void findArticleById_NotFound() {
        // GIVEN
        ArticleMemoryRepository articleMemoryRepository = new ArticleMemoryRepository();
        Long id = 2L;
        Long notExistsId = 4L;
        ArticleDto articleDto = new ArticleDto();
        articleDto.setAuthor("Author");
        articleDto.setPages(23);
        articleDto.setId(id);
        articleDto.setTitle("title");

        articleMemoryRepository.save(articleDto);

        // WHEN
        int result = articleMemoryRepository.findArticleById(notExistsId);

        // THEN
        assertEquals(-1, result);
    }

    @org.junit.Test
    public void deleteById() {
        // GIVEN
        ArticleMemoryRepository articleMemoryRepository = new ArticleMemoryRepository();
        Long id = 2L;
        Long notExistsId = 4L;
        ArticleDto articleDto = new ArticleDto();
        articleDto.setAuthor("Author");
        articleDto.setPages(23);
        articleDto.setId(id);
        articleDto.setTitle("title");

        articleMemoryRepository.save(articleDto);

        // WHEN
        articleMemoryRepository.deleteById(id);

        // THEN
        assertEquals(0, articleMemoryRepository.findAll().size());
    }

    @org.junit.Test
    public void deleteById_notExists() {
        // GIVEN
        ArticleMemoryRepository articleMemoryRepository = new ArticleMemoryRepository();
        Long id = 2L;
        Long notExistsId = 4L;
        ArticleDto articleDto = new ArticleDto();
        articleDto.setAuthor("Author");
        articleDto.setPages(23);
        articleDto.setId(id);
        articleDto.setTitle("title");

        articleMemoryRepository.save(articleDto);

        // WHEN
        articleMemoryRepository.deleteById(notExistsId);

        // THEN
        assertEquals(1, articleMemoryRepository.findAll().size());
    }

    @org.junit.Test
    public void getById_notExists() {
        // GIVEN
        ArticleMemoryRepository articleMemoryRepository = new ArticleMemoryRepository();
        Long id = 2L;
        Long notExistsId = 4L;
        ArticleDto articleDto = new ArticleDto();
        articleDto.setAuthor("Author");
        articleDto.setPages(23);
        articleDto.setId(id);
        articleDto.setTitle("title");

        articleMemoryRepository.save(articleDto);

        // WHEN
        ArticleDto dto = articleMemoryRepository.getById(notExistsId);

        // THEN
        assertNull(dto);
    }

    @org.junit.Test
    public void getById_Exists() {
        // GIVEN
        ArticleMemoryRepository articleMemoryRepository = new ArticleMemoryRepository();
        Long id = 2L;
        Long notExistsId = 4L;
        ArticleDto articleDto = new ArticleDto();
        articleDto.setAuthor("Author");
        articleDto.setPages(23);
        articleDto.setId(id);
        articleDto.setTitle("title");

        articleMemoryRepository.save(articleDto);

        // WHEN
        ArticleDto dto = articleMemoryRepository.getById(id);

        // THEN
        assertEquals(articleDto, dto);
    }

    @org.junit.Test
    public void save_update() {
        // GIVEN
        ArticleMemoryRepository articleMemoryRepository = new ArticleMemoryRepository();
        Long id = 2L;
        Long notExistsId = 4L;
        ArticleDto articleDto = new ArticleDto();
        articleDto.setAuthor("Author");
        articleDto.setPages(23);
        articleDto.setId(id);
        articleDto.setTitle("title");

        articleMemoryRepository.save(articleDto);

        // WHEN
        ArticleDto articleDto2 = new ArticleDto();
        articleDto2.setAuthor("Author 2");
        articleDto2.setPages(14);
        articleDto2.setId(id);
        articleDto2.setTitle("title 2");

        articleMemoryRepository.save(articleDto2);

        // THEN
        List<ArticleDto> articleDtoList = articleMemoryRepository.findAll();
        assertEquals(1, articleDtoList.size());

        assertEquals(articleDto2, articleDtoList.get(0));
    }
}