package com.example.testapi.controller;


import com.example.testapi.model.TestApi;
import com.example.testapi.repository.TestApiRepository;
import org.springframework.web.bind.annotation.*;

import javax.websocket.server.PathParam;
import java.util.List;

@RestController
@RequestMapping("/todo/list")
public class TestApiController {

    private TestApiRepository repository;

    public TestApiController(TestApiRepository repository) {
        this.repository = repository;
    }


    //1
    @PostMapping("/create")
    public void createTestApi(@RequestBody TestApi testApi) {
        repository.save(testApi);
    }

    //2
    @GetMapping("/{generateid}")
    public TestApi findTestApiByGenerateId(@PathVariable String generateid) {
        return this.repository.findByGenerateid(generateid);
    }

    //3
    @PutMapping("/{generateid}/edit")
    public void editTestApi(@PathVariable String generateid,@RequestBody TestApi task){
        TestApi test=this.repository.findByGenerateid(generateid);
        test.setComplete(task.getComplete());
        test.setTitle(task.getTitle());
        test.setCreate_at(task.getCreate_at());
        test.setUpdate_at(task.getUpdate_at());
        this.repository.save(test);
    }

    //4
    @PatchMapping("/{generateid}/complete")
    public TestApi updateComplete(@PathVariable String generateid,@RequestBody TestApi testApi){
        TestApi test=this.repository.findByGenerateid(generateid);
        test.setComplete(testApi.getComplete());
        return  test;
    }



    //5
    @DeleteMapping("/{generateid}")
    public void deleteTestApi(@PathVariable String generateid){
        TestApi testApi=this.repository.findByGenerateid(generateid);
        this.repository.delete(testApi);
    }


    //6
    @GetMapping("/all")
    public List<TestApi> getAllTestApi() {
        return this.repository.findAll();
    }


    //7
    @GetMapping()
    public List<TestApi> ReverseComplete(@RequestParam("filter") boolean filter){
        return repository.findByComplete(!filter);
    }



}
