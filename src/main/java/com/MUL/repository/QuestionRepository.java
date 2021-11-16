package com.MUL.repository;

import com.MUL.entity.Question;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface QuestionRepository extends JpaRepository<Question,Long> {

    public List<Question> findDistinctByQuestionContentLikeOrExplainationLike(String questionContent, String explaination);

}
