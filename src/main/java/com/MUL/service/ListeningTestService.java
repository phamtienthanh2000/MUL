package com.MUL.service;

import com.MUL.entity.Answer;
import com.MUL.entity.ListeningTest;
import com.MUL.entity.Question;
import com.MUL.entity.Test;
import com.MUL.repository.AnswerRepository;
import com.MUL.repository.ListeningTestRepository;
import com.MUL.repository.QuestionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
public class ListeningTestService implements com.MUL.service.Service<ListeningTest,Long>{
    @Autowired
    private ListeningTestRepository listeningTestRepository ;

    @Autowired
    private QuestionRepository questionRepository;

    @Autowired
    private AnswerRepository answerRepository;



    @Transactional
    @Override
    public void save(ListeningTest entity) {

        for (Question q : entity.getQuestionList()) {
            System.out.println("Error 1 ");

            q.setTest(entity);
            System.out.println("Error 2 ");

            for (Answer a : q.getAnswerList()) {
                a.setQuestion(q);
            }
            ListeningTest entityAfterSaved = listeningTestRepository.saveAndFlush(entity);



        }
    }

    @Override
    public List<ListeningTest> getAll() {
        List<ListeningTest> result =  listeningTestRepository.findAll();
        return result;
    }

    @Override
    public ListeningTest findById(Long id) {
        Optional<ListeningTest> result =  listeningTestRepository.findById(id);;
        return result.isPresent()?result.get():null;
    }

    @Override
    public void update(ListeningTest entity) {
        System.out.println("update start");
        ListeningTest updateTest = listeningTestRepository.findById(entity.getId()).get();
        updateTest.setTestType(entity.getTestType());
        updateTest.setTestName(entity.getTestName());
        updateTest.setAudioSource(entity.getAudioSource());
        Question updateQuestionData = null;
        Question updateQuestion = null;
        for(int i = 0 ; i <updateTest.getQuestionList().size();i++){
            System.out.println("i "+i);
            updateQuestion = updateTest.getQuestionList().get(i);;
            updateQuestionData = entity.getQuestionList().get(i);
            updateQuestion.setQuestionNumber(updateQuestionData.getQuestionNumber());
            updateQuestion.setCorrectAnswerName(updateQuestionData.getCorrectAnswerName());
            updateQuestion.setQuestionContent(updateQuestionData.getQuestionContent());
            updateQuestion.setExplaination(updateQuestionData.getExplaination());
            System.out.println("error check 1");
          //  questionRepository.save(updateQuestion);
            System.out.println("error check 2");

            // System.out.println("Update question" +updateQuestion);
            //updateQuestionData.setTest(updateQuestion.getTest());
            Answer updateAnswerData = null;
            Answer updateAnswer = null;
            for(int j = 0 ; j < updateQuestion.getAnswerList().size();j++){
                System.out.println("error check 3");

                updateAnswer = updateQuestion.getAnswerList().get(j);
                updateAnswerData = updateQuestionData.getAnswerList().get(j);
                updateAnswer.setAnswerName(updateAnswerData.getAnswerName());
                updateAnswer.setAnswerContent(updateAnswerData.getAnswerContent());
              //  answerRepository.save(updateAnswer);

            }


        }
         listeningTestRepository.save(updateTest);
       // System.out.println(afterUpdatedEntity);


    }

    @Override
    public void deleteById(Long id) {
        listeningTestRepository.deleteById(id);
//
    }

    @Override
    public List<ListeningTest> findByKeyword(String keyword) {
        String searchKey = "%"+keyword+"%";
        List<ListeningTest> result = listeningTestRepository.findDistinctByTestTypeLikeOrTestNameLikeOrAudioSourceLike(searchKey,searchKey,searchKey);

        return result;
    }
}
