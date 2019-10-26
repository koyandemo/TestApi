package com.example.testapi.controller;


import com.example.testapi.model.Response;
import com.example.testapi.model.TestApi;
import com.example.testapi.repository.TestApiRepository;
import org.apache.commons.lang3.RandomStringUtils;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import java.time.LocalDate;
import java.util.Date;
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
    public TestApi createTestApi(@RequestBody TestApi testApi) {
        testApi.setGenerateid(RandomStringUtils.randomAlphabetic(12));
        testApi.setCreate_at(LocalDate.now());

        boolean reverse=testApi.getComplete();
        testApi.setComplete(!testApi.getComplete());
      return   this.repository.save(testApi);

    }

    //2
    @GetMapping("/{generateid}")
    public TestApi findTestApiByGenerateId(@PathVariable String generateid) {
        return this.repository.findByGenerateid(generateid);
    }

    //3
    @PutMapping("/{generateid}/edit")
    public TestApi editTestApi(@PathVariable String generateid,@RequestBody TestApi testapi){
        TestApi test=this.repository.findByGenerateid(generateid);
        test.setComplete(testapi.getComplete());
        test.setTitle(testapi.getTitle());
        test.setCreate_at(test.getCreate_at());
        test.setUpdate_at(LocalDate.now());
      return   this.repository.save(test);
    }

    //4
    @PatchMapping("/{generateid}/complete")
    public TestApi updateComplete(@PathVariable String generateid,@RequestBody TestApi testApi){
        TestApi test=this.repository.findByGenerateid(generateid);
        test.setComplete(testApi.getComplete());
        test.setUpdate_at(LocalDate.now());
        return  test;
    }



    //5
    @DeleteMapping("/{generateid}")
    public ResponseEntity<Response> deleteTestApi(@PathVariable String generateid){
        TestApi testApi=this.repository.findByGenerateid(generateid);
        this.repository.delete(testApi);
        return ResponseEntity.ok().body(new Response(HttpStatus.OK,"successfully Delete Operation"));
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
