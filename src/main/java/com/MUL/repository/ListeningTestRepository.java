package com.MUL.repository;

import com.MUL.entity.ListeningTest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ListeningTestRepository extends JpaRepository<ListeningTest,Long> {

}
