package com.MUL.repository;

import com.MUL.entity.ListeningTest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ListeningTestRepository extends JpaRepository<ListeningTest,Long> {
    public List<ListeningTest> findDistinctByTestTypeLikeOrTestNameLikeOrAudioSourceLike(String testType,String testName, String audioSource);
    //public List<ListeningTest> findDistinctByQuestionList.

}
