package com.MUL.repository;

import com.MUL.entity.Article;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ArticleRepository extends JpaRepository<Article,Long> {
    @Query(
        value = "Select DISTINCT a.* , t.* From Article a Left JOIN Tag t ON a.id=t.article_id" +
                " Where a.title LIKE :title OR a.level LIKE :level  Or a.description Like :description " +
                "Or t.content LIKE :content"
                 , nativeQuery = true

    )
    public List<Article> findByKeyword(@Param("title") String title,@Param("level") String level ,@Param("description") String description ,@Param("content") String content);
}
