package com.jobfinder.search_for_jobs.model;

import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "vagas")
public class Jobs {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 80)
    private String title;

    @Column(nullable = false, length = 255)
    private String link;

    private LocalDateTime dataCadastro = LocalDateTime.now();


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

    public LocalDateTime getDataCadastro(){
        return dataCadastro;
    }

    public void setDataCadastro(LocalDateTime dataCadastro){
        this.dataCadastro = dataCadastro;
    }



}

