package com.MUL.service;

import com.MUL.entity.Article;
import com.MUL.entity.Tag;
import com.MUL.repository.ArticleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ArticleService implements com.MUL.service.Service<Article,Long> {
    @Autowired
    private ArticleRepository articleRepository;

    @Override
    public void save(Article entity) {
        for(Tag t : entity.getTag()){
            t.setArticle(entity);
        }

        articleRepository.save(entity);
        //articleRepository.saveAndFlush();

    }

    @Override
    public List<Article> getAll(){
        return articleRepository.findAll();
    }

    @Override
    public Article findById(Long id) {

        Optional<Article> result=  articleRepository.findById(id);
        return result.isPresent() ? result.get() : null;
    }

    @Override
    public void update(Article entity) {
        Article updateArticle = articleRepository.getById(entity.getId());

        for(Tag t : entity.getTag()){
            t.setArticle(entity);
        }
        articleRepository.save(entity);

    }

    @Override
    public void deleteById(Long id) {
        articleRepository.deleteById(id);
    }
    //search by title
    // tag , level ,
    // searchByTitle,tag,level -> tra ve 1 trong 3
    // tra ve ca 3 entity
    // input list , ki tu search
    //
    // Article[] search by tag (List data, keyword ) -> list
    //

    public List<Article> findByKeyword(String keyWord){
        String searchKey = "%"+keyWord+"%";
        List<Article>  search =  articleRepository.findByKeyword(searchKey,searchKey,searchKey,searchKey);
        List<Article> result = new ArrayList<>();
        for(Article a : search){
            boolean duplicate = false;
            for(Article article : result){
                if(article.getId() == a.getId()) {
                    duplicate = true;
                }
            }
            if(!duplicate){
                result.add(a);
            }

        }



        return result;
    }

}
