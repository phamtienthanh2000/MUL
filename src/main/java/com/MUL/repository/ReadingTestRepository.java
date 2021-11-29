package com.MUL.repository;

import com.MUL.entity.ReadingTest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ReadingTestRepository extends JpaRepository<ReadingTest,Long> {
    public List<ReadingTest> findDistinctByTestTypeLikeOrTestNameLikeOrTextThemeLikeOrParagraphLikeOrLevelLike(String testType, String testName,String textTheme, String paragraph,String level);

}
