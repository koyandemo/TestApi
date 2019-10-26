package com.example.testapi.configuration;


import com.example.testapi.model.TestApi;
import com.example.testapi.repository.TestApiRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

@Component
public class DataLoader implements CommandLineRunner {


    @Autowired
    private TestApiRepository testApiRepository;

    @Override
    public void run(String... args) throws Exception {

        TestApi testApi = new TestApi();
        testApi.setGenerateid("123456789012");
        testApi.setComplete(true);
        testApi.setTitle("TestApi One");
        testApi.setCreate_at(LocalDate.now());



        TestApi testApitwo = new TestApi();
        testApitwo.setGenerateid("210987645321");
        testApitwo.setComplete(true);
        testApitwo.setTitle("TestApi Two");
        testApitwo.setCreate_at(LocalDate.now());


      //  testApiRepository.save(testApi);
       // testApiRepository.save(testApitwo);
    }
}
