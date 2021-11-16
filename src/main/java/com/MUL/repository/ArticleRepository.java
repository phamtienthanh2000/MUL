package com.MUL.repository;

import com.MUL.entity.Article;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ArticleRepository extends JpaRepository<Article,Long> {

    public List<Article> findDistinctByTitleLikeOrTagLikeOrLevelLikeOrDescriptionLike(String title,String tag,String level,String description);

}
