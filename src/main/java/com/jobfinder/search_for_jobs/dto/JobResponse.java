package com.jobfinder.search_for_jobs.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class JobResponse {

    private String name;
    private String jobUrl;
    private String city;

    public JobResponse(){

    }

    public String getName() {
        return name;
    }

    public void setName(String name){
        this.name = name;
    }

    public String getJobUrl() {
        return jobUrl;
    }

    public void setJobUrl(String jobUrl) {
        this.jobUrl = jobUrl;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    @Override
    public String toString() {
        return "JobResponse{" +
                "name='" + name + '\'' +
                ", jobUrl='" + jobUrl + '\'' +
                ", city='" + city + '\'' +
                '}';
    }
}
