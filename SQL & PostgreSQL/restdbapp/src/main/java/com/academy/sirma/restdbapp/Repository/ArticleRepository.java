package com.academy.sirma.restdbapp.Repository;

import com.academy.sirma.restdbapp.Model.Article;
import com.academy.sirma.restdbapp.Model.User;
import org.springframework.jdbc.core.JdbcTemplate;

public class ArticleRepository {
    private final JdbcTemplate jdbcTemplate;

    public ArticleRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public void addArticle(Article article){
        String sql = "INSERT INTO articles(title, content,userId) VALUES(?, ?, ?)";
        jdbcTemplate.update(sql,article.getTitle(),article.getContent(),article.getUserId());
    }


}
