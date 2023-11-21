package com.academy.sirma.restdbapp.Controller;

import com.academy.sirma.restdbapp.Model.Article;
import com.academy.sirma.restdbapp.Service.ArticleService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/article")
public class ArticleController {
    private final ArticleService articleService;

    public ArticleController(ArticleService articleService) {
        this.articleService = articleService;
    }
    @PostMapping("/createArticle")
    public void createArticle(@RequestBody Article article){
        articleService.addArticle(article);
    }
}
