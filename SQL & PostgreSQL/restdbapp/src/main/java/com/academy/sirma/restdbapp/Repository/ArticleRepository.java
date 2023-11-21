package com.academy.sirma.restdbapp.Repository;

import com.academy.sirma.restdbapp.Model.Article;
import com.academy.sirma.restdbapp.Model.User;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class ArticleRepository {
    private final JdbcTemplate jdbcTemplate;

    public ArticleRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public void addArticle(Article article){
        String sql = "INSERT INTO articles(title, content,user_id) VALUES(?, ?, ?)";
        jdbcTemplate.update(sql,article.getTitle(),article.getContent(),article.getUserId());
    }

    public List<Article> getAllArticles(int userId) {
        String sql = "SELECT * FROM articles WHERE user_id = ?";
        return jdbcTemplate.query(sql, new Object[]{userId}, new BeanPropertyRowMapper<>(Article.class));
    }
}
