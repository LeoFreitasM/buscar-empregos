package com.jobfinder.search_for_jobs.model;

import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "vagas")
public class Jobs {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 255)
    private String title;

    @Column(nullable = false, length = 255)
    private String link;

    @Column(nullable = false, length = 255)
    private String cityJob;

    private LocalDateTime date = LocalDateTime.now();


    public Jobs(){

    }

    public Long getId(){
        return id;
    }

    public void setId(Long id){
        this.id = id;
    }

    public String getTitle(){
        return title;
    }

    public void setTitle(String title){
        this.title = title;
    }

    public String getLink(){
        return link;
    }

    public void setLink(String link){
        this.link = link;
    }

    public LocalDateTime getDate(){
        return date;
    }

    public String getCityJob() {
        return cityJob;
    }

    public void setCityJob(String cityJob) {
        this.cityJob = cityJob;
    }

    public void setDate(LocalDateTime date){
        this.date = date;
    }

    @Override
    public String toString() {
        return "Jobs{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", link='" + link + '\'' +
                ", cityJob='" + cityJob + '\'' +
                ", date=" + date +
                '}';
    }
}