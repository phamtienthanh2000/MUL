package com.MUL.service;

import com.MUL.entity.Answer;
import com.MUL.entity.ListeningTest;
import com.MUL.entity.Question;
import com.MUL.entity.ReadingTest;
import com.MUL.repository.ReadingTestRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Optional;

@org.springframework.stereotype.Service
public class ReadingTestService implements com.MUL.service.Service<ReadingTest,Long>{
    @Autowired
    private ReadingTestRepository readingTestRepository;

    @Override
    public void save(ReadingTest entity) {
        List<Question> questionList = entity.getQuestionList();
        for(Question q : questionList){
            q.setTest(entity);
            for(Answer a : q.getAnswerList()){
                a.setQuestion(q);
            }
        }

        readingTestRepository.save(entity);


    }

    @Override
    public List<ReadingTest> getAll() {
        return readingTestRepository.findAll();
    }

    @Override
    public ReadingTest findById(Long id) {
        Optional<ReadingTest> result =  readingTestRepository.findById(id);
        System.out.println(result.get());
        return result.isPresent()?result.get():null;
    }

    @Override
    public void update(ReadingTest entity) {
        ReadingTest updateReadingTest = readingTestRepository.getById(entity.getId());
        updateReadingTest.setTestName(entity.getTestName());
        updateReadingTest.setTestType(entity.getTestType());
        updateReadingTest.setParagraph(entity.getParagraph());
        updateReadingTest.setTextTheme(entity.getTextTheme());

        Question updateQuestion = null;
        Question updateQuestionData = null;
        for(int i = 0 ; i < updateReadingTest.getQuestionList().size();i++){
            updateQuestion = updateReadingTest.getQuestionList().get(i);
            updateQuestionData = entity.getQuestionList().get(i);
            updateQuestion.setQuestionNumber(updateQuestionData.getQuestionNumber());
            updateQuestion.setCorrectAnswerName(updateQuestionData.getCorrectAnswerName());
            updateQuestion.setQuestionContent(updateQuestionData.getQuestionContent());
            updateQuestion.setExplaination(updateQuestionData.getExplaination());
            Answer updateAnswer = null;
            Answer updateAnswerData = null;
            for(int j = 0 ; j < updateQuestion.getAnswerList().size();j++){
                updateAnswer = updateQuestion.getAnswerList().get(j);
                updateAnswerData = updateQuestionData.getAnswerList().get(j);
                updateAnswer.setAnswerName(updateAnswerData.getAnswerName());
                updateAnswer.setAnswerContent(updateAnswerData.getAnswerContent());
            }

        }

        readingTestRepository.save(updateReadingTest);

    }

    @Override
    public void deleteById(Long id) {

        readingTestRepository.deleteById(id);

    }

    @Override
    public List<ReadingTest> findByKeyword(String keyword) {
        String searchKey = "%"+keyword+"%";
        System.out.println("searchkey : "+searchKey);

        List<ReadingTest>result = readingTestRepository.findDistinctByTestTypeLikeOrTestNameLikeOrTextThemeLikeOrParagraphLike(searchKey,searchKey,searchKey,searchKey);
        System.out.println("result : "+result);
        return result;

    }
}
