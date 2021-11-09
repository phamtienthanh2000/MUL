package com.MUL.controller;

import com.MUL.entity.Article;
import com.MUL.service.ArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path="article")
@ComponentScan(basePackages = "com.mul.service")
public class ArticleController {
    @Autowired
    private ArticleService articleService ;

    @GetMapping(path ="/get-all")
    public List<Article> getArticles(){
         return  articleService.getAll();
    }
    @GetMapping(path ="/get-by-id/{id}")
    public Article getArticleById(@PathVariable(name = "id") Long id){
        return articleService.findById(id);

    }

    @PostMapping(path = "/create")
    public void createArticle(@RequestBody Article article){
     //   System.out.println("In here");
        articleService.save(article);

    }

    @PutMapping(path = "/update")
    public void updateArticle(@RequestBody Article article){
        articleService.update(article);
    }

    @DeleteMapping(path = "/delete")
    public void deleteArticleById(@RequestParam(name = "id") Long id){
        articleService.deleteById(id);
    }


}
