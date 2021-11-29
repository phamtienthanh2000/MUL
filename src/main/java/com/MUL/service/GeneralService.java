package com.MUL.service;

import com.MUL.entity.Article;
import com.MUL.entity.ListeningTest;
import com.MUL.entity.Question;
import com.MUL.entity.ReadingTest;
import com.MUL.repository.ArticleRepository;
import com.MUL.repository.ListeningTestRepository;
import com.MUL.repository.QuestionRepository;
import com.MUL.repository.ReadingTestRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class GeneralService {
    @Autowired
    ArticleService articleService ;
    @Autowired
    ListeningTestRepository listeningTestRepository;
    @Autowired
    ReadingTestRepository readingTestRepository;
    @Autowired
    QuestionRepository questionRepository;
    public List<Object> findByKeyword(String keyword){
        String searchKey = "%"+keyword+"%";
        List<Object> result = new ArrayList<>();
        List<Article> articles = articleService.findByKeyword(keyword);
       result.add(articles);
        List<ReadingTest> readingTests = readingTestRepository.findDistinctByTestTypeLikeOrTestNameLikeOrTextThemeLikeOrParagraphLikeOrLevelLike(searchKey,searchKey,searchKey,searchKey,searchKey);
       result.add(readingTests);
       List<ListeningTest> listeningTests = listeningTestRepository.findDistinctByTestTypeLikeOrTestNameLikeOrAudioSourceLikeOrLevelLike(searchKey,searchKey,searchKey,searchKey);
       result.add(listeningTests);
       List<Question> questions = questionRepository.findDistinctByQuestionContentLikeOrExplainationLike(searchKey,searchKey);
       result.add(questions);
       return result;

    }

}
