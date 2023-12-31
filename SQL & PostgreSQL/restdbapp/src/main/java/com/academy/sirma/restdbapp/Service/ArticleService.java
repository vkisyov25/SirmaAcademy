package com.academy.sirma.restdbapp.Service;

import com.academy.sirma.restdbapp.Model.Article;
import com.academy.sirma.restdbapp.Repository.ArticleRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ArticleService {
    private final ArticleRepository articleRepository;

    public ArticleService(ArticleRepository articleRepository) {
        this.articleRepository = articleRepository;
    }

    public void addArticle(Article article){
        articleRepository.addArticle(article);
    }

    public List<Article> getAllArticles(int userId) {
        return articleRepository.getAllArticles(userId);
    }
}
