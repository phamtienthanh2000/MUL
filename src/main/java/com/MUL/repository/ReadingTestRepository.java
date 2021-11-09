package com.MUL.repository;

import com.MUL.entity.ReadingTest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ReadingTestRepository extends JpaRepository<ReadingTest,Long> {
}
