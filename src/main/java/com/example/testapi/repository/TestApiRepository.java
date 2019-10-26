package com.example.testapi.repository;


import com.example.testapi.model.TestApi;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface TestApiRepository extends JpaRepository<TestApi,Long> {

    TestApi findByGenerateid(String generateId);
    List<TestApi> findByComplete(boolean complete);

}
