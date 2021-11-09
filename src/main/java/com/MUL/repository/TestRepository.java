package com.MUL.repository;

import com.MUL.entity.Test;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.NoRepositoryBean;

@NoRepositoryBean
public interface TestRepository extends JpaRepository<Test,Long>{
}
