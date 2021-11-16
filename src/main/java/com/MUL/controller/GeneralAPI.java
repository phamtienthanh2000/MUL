package com.MUL.controller;

import com.MUL.entity.Question;
import com.MUL.repository.QuestionRepository;
import com.MUL.service.ArticleService;
import com.MUL.service.GeneralService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@ComponentScan(basePackages = "com.mul.service")
public class GeneralAPI {
    @Autowired
    private QuestionRepository questionRepository ;
    @Autowired
    private GeneralService generalService;
    @GetMapping(path = "/question/{keyword}")
    public List<Question> testQuestionRepository(@PathVariable String keyword){
        String searchKey = "%"+keyword+"%";
        return questionRepository.findDistinctByQuestionContentLikeOrExplainationLike(searchKey,searchKey);


    }
    @GetMapping(path = {"/find-by-keyword/{keyword}"})
    public List<Object> findByKeyword(@PathVariable(name = "keyword") String keyword){
        return generalService.findByKeyword(keyword);

    }

}
