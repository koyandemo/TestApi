package com.example.testapi.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.time.LocalDate;


@Entity
public class TestApi {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String generateid;
    private String title;
    private Boolean complete;
   // @DateTimeFormat(pattern = "yyyy-MM-dd")
      @JsonFormat(pattern = "yyyy-MM-dd")
    private LocalDate create_at;
    //@DateTimeFormat(pattern = "yyyy-MM-dd")
      @JsonFormat(pattern = "yyyy-MM-dd")
    private LocalDate update_at;

    public TestApi() {
    }

    public TestApi(String generateid, String title, Boolean complete, LocalDate create_at, LocalDate update_at) {
        this.generateid = generateid;
        this.title = title;
        this.complete = complete;
        this.create_at = create_at;
        this.update_at = update_at;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getGenerateid() {
        return generateid;
    }

    public void setGenerateid(String generateid) {
        this.generateid = generateid;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Boolean getComplete() {
        return complete;
    }

    public void setComplete(Boolean complete) {
        this.complete = complete;
    }

    public LocalDate getCreate_at() {
        return create_at;
    }

    public void setCreate_at(LocalDate create_at) {
        this.create_at = create_at;
    }

    public LocalDate getUpdate_at() {
        return update_at;
    }

    public void setUpdate_at(LocalDate update_at) {
        this.update_at = update_at;
    }
}
